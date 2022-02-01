package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.api.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView
  extends RelativeLayout
{
  private View PTY;
  private TextView PTZ;
  private LinearLayout PUa;
  private boolean PUb;
  private boolean PUc;
  private Context mContext;
  private View qWL;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37663);
    this.qWL = null;
    this.PUb = true;
    this.mContext = paramContext;
    init();
    gUu();
    AppMethodBeat.o(37663);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37662);
    this.qWL = null;
    this.PUb = true;
    this.mContext = paramContext;
    init();
    gUu();
    AppMethodBeat.o(37662);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37661);
    this.qWL = null;
    this.PUb = true;
    this.mContext = paramContext;
    init();
    gUu();
    AppMethodBeat.o(37661);
  }
  
  private void init()
  {
    AppMethodBeat.i(37664);
    this.PUc = false;
    View.inflate(getContext(), 2131493240, this);
    this.qWL = findViewById(2131299174);
    this.PTY = this.qWL.findViewById(2131297441);
    this.PUa = ((LinearLayout)this.qWL.findViewById(2131297590));
    Object localObject = this.PTY.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cb.a.aH(getContext(), 2131165246) * com.tencent.mm.cb.a.jj(getContext())));
    this.PTY.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.qWL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37657);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (!WeChatBrands.Business.Entries.ContactOa.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37657);
          return;
        }
        if (((q)g.af(q.class)).Vv())
        {
          ((com.tencent.mm.plugin.teenmode.a.b)g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(BizContactEntranceView.a(BizContactEntranceView.this));
          ((q)g.af(q.class)).o(8, "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37657);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("intent_service_type", 251658241);
        com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37657);
      }
    });
    this.PTY.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37658);
        if ((BizContactEntranceView.a(BizContactEntranceView.this) instanceof MMActivity)) {
          ((MMActivity)BizContactEntranceView.a(BizContactEntranceView.this)).hideVKB();
        }
        AppMethodBeat.o(37658);
        return false;
      }
    });
    localObject = (MaskLayout)this.PTY.findViewById(2131297440);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    p.aYn();
    localImageView.setImageBitmap(e.Mp("service_officialaccounts"));
    this.PTZ = ((TextView)((MaskLayout)localObject).findViewById(2131309165));
    AppMethodBeat.o(37664);
  }
  
  public final void Cn(boolean paramBoolean)
  {
    AppMethodBeat.i(233995);
    if ((this.PTY == null) || (this.PUa == null))
    {
      AppMethodBeat.o(233995);
      return;
    }
    if (paramBoolean)
    {
      int i = this.PTY.getPaddingLeft();
      this.PTY.setBackground(at.aN(this.mContext, 2130969285));
      this.PTY.setPadding(i, 0, 0, 0);
      this.PUa.setBackground(null);
      AppMethodBeat.o(233995);
      return;
    }
    this.PTY.setBackground(null);
    this.PUa.setBackground(at.aN(this.mContext, 2130969285));
    AppMethodBeat.o(233995);
  }
  
  final void gUu()
  {
    AppMethodBeat.i(37665);
    long l = System.currentTimeMillis();
    bg.aVF();
    int j = com.tencent.mm.model.c.aSN().gCe();
    View localView;
    if (j > 0)
    {
      this.PUb = true;
      localView = this.PTY;
      if (!this.PUb) {
        break label127;
      }
    }
    label127:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.PUb) {
        bg.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            final long l1 = 0L;
            AppMethodBeat.i(37660);
            Object localObject1 = ag.bah();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
            ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
            localObject2 = ((StringBuilder)localObject2).toString();
            Log.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
            localObject1 = ((f)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject1 == null) {}
            for (;;)
            {
              bg.aVF();
              long l2 = Util.nullAsLong(com.tencent.mm.model.c.azQ().get(233473, null), 0);
              Log.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(37659);
                  TextView localTextView = BizContactEntranceView.c(BizContactEntranceView.this);
                  if ((BizContactEntranceView.b(BizContactEntranceView.this)) && (l1 > this.val$enterTime)) {}
                  for (int i = 0;; i = 4)
                  {
                    localTextView.setVisibility(i);
                    AppMethodBeat.o(37659);
                    return;
                  }
                }
              });
              AppMethodBeat.o(37660);
              return;
              if (!((Cursor)localObject1).moveToFirst())
              {
                ((Cursor)localObject1).close();
              }
              else
              {
                l1 = ((Cursor)localObject1).getLong(0);
                ((Cursor)localObject1).close();
              }
            }
          }
        });
      }
      Log.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.PUb), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(37665);
      return;
      this.PUb = false;
      break;
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(37666);
    Log.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.PUb) });
    View localView = this.qWL;
    if ((paramBoolean) && (this.PUb)) {}
    for (;;)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(37666);
      return;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView
 * JD-Core Version:    0.7.0.1
 */