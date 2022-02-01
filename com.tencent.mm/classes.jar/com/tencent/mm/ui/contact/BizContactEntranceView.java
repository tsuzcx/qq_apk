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
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.p;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView
  extends RelativeLayout
{
  private View KkF;
  private TextView KkG;
  private LinearLayout KkH;
  private boolean KkI;
  private boolean KkJ;
  private Context mContext;
  private View pAv;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37663);
    this.pAv = null;
    this.KkI = true;
    this.mContext = paramContext;
    init();
    fHI();
    AppMethodBeat.o(37663);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37662);
    this.pAv = null;
    this.KkI = true;
    this.mContext = paramContext;
    init();
    fHI();
    AppMethodBeat.o(37662);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37661);
    this.pAv = null;
    this.KkI = true;
    this.mContext = paramContext;
    init();
    fHI();
    AppMethodBeat.o(37661);
  }
  
  private void init()
  {
    AppMethodBeat.i(37664);
    this.KkJ = false;
    View.inflate(getContext(), 2131493194, this);
    this.pAv = findViewById(2131298736);
    this.KkF = this.pAv.findViewById(2131297284);
    this.KkH = ((LinearLayout)this.pAv.findViewById(2131297372));
    Object localObject = this.KkF.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cc.a.ay(getContext(), 2131165242) * com.tencent.mm.cc.a.il(getContext())));
    this.KkF.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.pAv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37657);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = new Intent();
        ((Intent)localObject).putExtra("intent_service_type", 251658241);
        d.b(paramAnonymousView.getContext(), "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37657);
      }
    });
    this.KkF.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37658);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/BizContactEntranceView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((BizContactEntranceView.a(BizContactEntranceView.this) instanceof MMActivity)) {
          ((MMActivity)BizContactEntranceView.a(BizContactEntranceView.this)).hideVKB();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/BizContactEntranceView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37658);
        return false;
      }
    });
    localObject = (MaskLayout)this.KkF.findViewById(2131297283);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    p.aEk();
    localImageView.setImageBitmap(e.Dc("service_officialaccounts"));
    this.KkG = ((TextView)((MaskLayout)localObject).findViewById(2131305882));
    AppMethodBeat.o(37664);
  }
  
  final void fHI()
  {
    AppMethodBeat.i(37665);
    long l = System.currentTimeMillis();
    ba.aBQ();
    int j = c.azp().fqy();
    View localView;
    if (j > 0)
    {
      this.KkI = true;
      localView = this.KkF;
      if (!this.KkI) {
        break label127;
      }
    }
    label127:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.KkI) {
        ba.ajF().ay(new Runnable()
        {
          public final void run()
          {
            final long l1 = 0L;
            AppMethodBeat.i(37660);
            Object localObject1 = ag.aFZ();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
            ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
            localObject2 = ((StringBuilder)localObject2).toString();
            ad.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
            localObject1 = ((f)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject1 == null) {}
            for (;;)
            {
              ba.aBQ();
              long l2 = bt.dU(c.ajl().get(233473, null));
              ad.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
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
      ad.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.KkI), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(37665);
      return;
      this.KkI = false;
      break;
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(37666);
    ad.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.KkI) });
    View localView = this.pAv;
    if ((paramBoolean) && (this.KkI)) {}
    for (;;)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(37666);
      return;
      i = 8;
    }
  }
  
  public final void yl(boolean paramBoolean)
  {
    AppMethodBeat.i(194536);
    if ((this.KkF == null) || (this.KkH == null))
    {
      AppMethodBeat.o(194536);
      return;
    }
    if (paramBoolean)
    {
      int i = this.KkF.getPaddingLeft();
      this.KkF.setBackground(com.tencent.mm.ui.aq.aM(this.mContext, 2130969245));
      this.KkF.setPadding(i, 0, 0, 0);
      this.KkH.setBackground(null);
      AppMethodBeat.o(194536);
      return;
    }
    this.KkF.setBackground(null);
    this.KkH.setBackground(com.tencent.mm.ui.aq.aM(this.mContext, 2130969245));
    AppMethodBeat.o(194536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView
 * JD-Core Version:    0.7.0.1
 */