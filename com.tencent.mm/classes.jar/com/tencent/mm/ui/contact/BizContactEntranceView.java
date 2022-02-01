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
import com.tencent.mm.ak.p;
import com.tencent.mm.am.af;
import com.tencent.mm.bs.d;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView
  extends RelativeLayout
{
  View GTO;
  private TextView GTP;
  LinearLayout GTQ;
  private boolean GTR;
  private boolean GTS;
  Context mContext;
  private View otk;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37663);
    this.otk = null;
    this.GTR = true;
    this.mContext = paramContext;
    init();
    fbe();
    AppMethodBeat.o(37663);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37662);
    this.otk = null;
    this.GTR = true;
    this.mContext = paramContext;
    init();
    fbe();
    AppMethodBeat.o(37662);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37661);
    this.otk = null;
    this.GTR = true;
    this.mContext = paramContext;
    init();
    fbe();
    AppMethodBeat.o(37661);
  }
  
  private void init()
  {
    AppMethodBeat.i(37664);
    this.GTS = false;
    View.inflate(getContext(), 2131493194, this);
    this.otk = findViewById(2131298736);
    this.GTO = this.otk.findViewById(2131297284);
    this.GTQ = ((LinearLayout)this.otk.findViewById(2131297372));
    Object localObject = this.GTO.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.ap(getContext(), 2131165242) * a.hR(getContext())));
    this.GTO.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.otk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37657);
        Intent localIntent = new Intent();
        localIntent.putExtra("intent_service_type", 251658241);
        d.b(paramAnonymousView.getContext(), "brandservice", ".ui.BrandServiceIndexUI", localIntent);
        AppMethodBeat.o(37657);
      }
    });
    this.GTO.setOnTouchListener(new View.OnTouchListener()
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
    localObject = (MaskLayout)this.GTO.findViewById(2131297283);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    p.auq();
    localImageView.setImageBitmap(com.tencent.mm.ak.e.vX("service_officialaccounts"));
    this.GTP = ((TextView)((MaskLayout)localObject).findViewById(2131305882));
    AppMethodBeat.o(37664);
  }
  
  final void fbe()
  {
    AppMethodBeat.i(37665);
    long l = System.currentTimeMillis();
    az.arV();
    int j = c.apM().eKT();
    View localView;
    if (j > 0)
    {
      this.GTR = true;
      localView = this.GTO;
      if (!this.GTR) {
        break label127;
      }
    }
    label127:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.GTR) {
        az.afE().ax(new Runnable()
        {
          public final void run()
          {
            final long l1 = 0L;
            AppMethodBeat.i(37660);
            Object localObject1 = af.awe();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
            ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
            localObject2 = ((StringBuilder)localObject2).toString();
            ad.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
            localObject1 = ((com.tencent.mm.am.e)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject1 == null) {}
            for (;;)
            {
              az.arV();
              long l2 = bt.dQ(c.afk().get(233473, null));
              ad.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              aq.f(new Runnable()
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
      ad.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.GTR), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(37665);
      return;
      this.GTR = false;
      break;
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(37666);
    ad.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.GTR) });
    View localView = this.otk;
    if ((paramBoolean) && (this.GTR)) {}
    for (;;)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(37666);
      return;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView
 * JD-Core Version:    0.7.0.1
 */