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
import com.tencent.mm.R.d;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.api.r;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.bd;

public class BizContactEntranceView
  extends RelativeLayout
{
  private View afck;
  private TextView afcl;
  private LinearLayout afcm;
  private boolean afcn;
  private boolean afco;
  private Context mContext;
  private View xFZ;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37663);
    this.xFZ = null;
    this.afcn = true;
    this.mContext = paramContext;
    init();
    jyd();
    AppMethodBeat.o(37663);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37662);
    this.xFZ = null;
    this.afcn = true;
    this.mContext = paramContext;
    init();
    jyd();
    AppMethodBeat.o(37662);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37661);
    this.xFZ = null;
    this.afcn = true;
    this.mContext = paramContext;
    init();
    jyd();
    AppMethodBeat.o(37661);
  }
  
  private void init()
  {
    AppMethodBeat.i(37664);
    this.afco = false;
    View.inflate(getContext(), R.i.geJ, this);
    this.xFZ = findViewById(R.h.container);
    this.afck = this.xFZ.findViewById(R.h.fty);
    this.afcm = ((LinearLayout)this.xFZ.findViewById(R.h.fuF));
    Object localObject = this.afck.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cd.a.bs(getContext(), R.f.ContactListHeight) * com.tencent.mm.cd.a.mo(getContext())));
    this.afck.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.xFZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37657);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (!WeChatBrands.Business.Entries.ContactOa.checkAvailable(paramAnonymousView.getContext()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37657);
          return;
        }
        if (((r)h.ax(r.class)).aBw())
        {
          ((d)h.ax(d.class)).kg(BizContactEntranceView.a(BizContactEntranceView.this));
          ((r)h.ax(r.class)).p(8, "");
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
    this.afck.setOnTouchListener(new View.OnTouchListener()
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
    localObject = (MaskLayout)this.afck.findViewById(R.h.ftx);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    q.bFp();
    localImageView.setImageBitmap(AvatarStorage.LK("service_officialaccounts"));
    this.afcl = ((TextView)((MaskLayout)localObject).findViewById(R.h.tipcnt_tv));
    AppMethodBeat.o(37664);
  }
  
  private void jyd()
  {
    AppMethodBeat.i(37665);
    long l = System.currentTimeMillis();
    bh.bCz();
    int j = com.tencent.mm.model.c.bzA().iZX();
    View localView;
    if (j > 0)
    {
      this.afcn = true;
      localView = this.afck;
      if (!this.afcn) {
        break label127;
      }
    }
    label127:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.afcn) {
        bh.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            final long l1 = 0L;
            AppMethodBeat.i(37660);
            Object localObject1 = af.bHf();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
            ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
            localObject2 = ((StringBuilder)localObject2).toString();
            Log.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
            localObject1 = ((f)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject1 == null) {}
            for (;;)
            {
              bh.bCz();
              long l2 = Util.nullAsLong(com.tencent.mm.model.c.ban().d(233473, null), 0);
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
      Log.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.afcn), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(37665);
      return;
      this.afcn = false;
      break;
    }
  }
  
  public final void Mx(boolean paramBoolean)
  {
    AppMethodBeat.i(252822);
    if ((this.afck == null) || (this.afcm == null))
    {
      AppMethodBeat.o(252822);
      return;
    }
    if (paramBoolean)
    {
      int i = this.afck.getPaddingLeft();
      this.afck.setBackground(bd.by(this.mContext, R.d.list_item_divider));
      this.afck.setPadding(i, 0, 0, 0);
      this.afcm.setBackground(null);
      AppMethodBeat.o(252822);
      return;
    }
    this.afck.setBackground(null);
    this.afcm.setBackground(bd.by(this.mContext, R.d.list_item_divider));
    AppMethodBeat.o(252822);
  }
  
  public final void irV()
  {
    AppMethodBeat.i(252813);
    jyd();
    setVisible(true);
    AppMethodBeat.o(252813);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(37666);
    Log.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.afcn) });
    View localView = this.xFZ;
    if ((paramBoolean) && (this.afcn)) {}
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