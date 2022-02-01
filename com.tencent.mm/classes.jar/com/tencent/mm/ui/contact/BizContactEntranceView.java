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
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView
  extends RelativeLayout
{
  private View KGZ;
  private TextView KHa;
  private LinearLayout KHb;
  private boolean KHc;
  private boolean KHd;
  private Context mContext;
  private View pGZ;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37663);
    this.pGZ = null;
    this.KHc = true;
    this.mContext = paramContext;
    init();
    fMa();
    AppMethodBeat.o(37663);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37662);
    this.pGZ = null;
    this.KHc = true;
    this.mContext = paramContext;
    init();
    fMa();
    AppMethodBeat.o(37662);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37661);
    this.pGZ = null;
    this.KHc = true;
    this.mContext = paramContext;
    init();
    fMa();
    AppMethodBeat.o(37661);
  }
  
  private void init()
  {
    AppMethodBeat.i(37664);
    this.KHd = false;
    View.inflate(getContext(), 2131493194, this);
    this.pGZ = findViewById(2131298736);
    this.KGZ = this.pGZ.findViewById(2131297284);
    this.KHb = ((LinearLayout)this.pGZ.findViewById(2131297372));
    Object localObject = this.KGZ.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.cb.a.ay(getContext(), 2131165242) * com.tencent.mm.cb.a.iq(getContext())));
    this.KGZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.pGZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37657);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = new Intent();
        ((Intent)localObject).putExtra("intent_service_type", 251658241);
        d.b(paramAnonymousView.getContext(), "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/BizContactEntranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37657);
      }
    });
    this.KGZ.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37658);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/BizContactEntranceView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if ((BizContactEntranceView.a(BizContactEntranceView.this) instanceof MMActivity)) {
          ((MMActivity)BizContactEntranceView.a(BizContactEntranceView.this)).hideVKB();
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/BizContactEntranceView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37658);
        return false;
      }
    });
    localObject = (MaskLayout)this.KGZ.findViewById(2131297283);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    p.aEA();
    localImageView.setImageBitmap(e.DE("service_officialaccounts"));
    this.KHa = ((TextView)((MaskLayout)localObject).findViewById(2131305882));
    AppMethodBeat.o(37664);
  }
  
  final void fMa()
  {
    AppMethodBeat.i(37665);
    long l = System.currentTimeMillis();
    bc.aCg();
    int j = c.azF().fuy();
    View localView;
    if (j > 0)
    {
      this.KHc = true;
      localView = this.KGZ;
      if (!this.KHc) {
        break label127;
      }
    }
    label127:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.KHc) {
        bc.ajU().aw(new Runnable()
        {
          public final void run()
          {
            final long l1 = 0L;
            AppMethodBeat.i(37660);
            Object localObject1 = ag.aGp();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
            ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
            localObject2 = ((StringBuilder)localObject2).toString();
            ae.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
            localObject1 = ((f)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject1 == null) {}
            for (;;)
            {
              bc.aCg();
              long l2 = bu.dV(c.ajA().get(233473, null));
              ae.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              ar.f(new Runnable()
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
      ae.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.KHc), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(37665);
      return;
      this.KHc = false;
      break;
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(37666);
    ae.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.KHc) });
    View localView = this.pGZ;
    if ((paramBoolean) && (this.KHc)) {}
    for (;;)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(37666);
      return;
      i = 8;
    }
  }
  
  public final void yy(boolean paramBoolean)
  {
    AppMethodBeat.i(187937);
    if ((this.KGZ == null) || (this.KHb == null))
    {
      AppMethodBeat.o(187937);
      return;
    }
    if (paramBoolean)
    {
      int i = this.KGZ.getPaddingLeft();
      this.KGZ.setBackground(aq.aM(this.mContext, 2130969245));
      this.KGZ.setPadding(i, 0, 0, 0);
      this.KHb.setBackground(null);
      AppMethodBeat.o(187937);
      return;
    }
    this.KGZ.setBackground(null);
    this.KHb.setBackground(aq.aM(this.mContext, 2130969245));
    AppMethodBeat.o(187937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView
 * JD-Core Version:    0.7.0.1
 */