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
import com.tencent.mm.aj.p;
import com.tencent.mm.al.af;
import com.tencent.mm.br.d;
import com.tencent.mm.cc.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView
  extends RelativeLayout
{
  private View ItZ;
  private TextView Iua;
  private LinearLayout Iub;
  private boolean Iuc;
  private boolean Iud;
  private Context mContext;
  private View oWL;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37663);
    this.oWL = null;
    this.Iuc = true;
    this.mContext = paramContext;
    init();
    fqV();
    AppMethodBeat.o(37663);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37662);
    this.oWL = null;
    this.Iuc = true;
    this.mContext = paramContext;
    init();
    fqV();
    AppMethodBeat.o(37662);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37661);
    this.oWL = null;
    this.Iuc = true;
    this.mContext = paramContext;
    init();
    fqV();
    AppMethodBeat.o(37661);
  }
  
  private void init()
  {
    AppMethodBeat.i(37664);
    this.Iud = false;
    View.inflate(getContext(), 2131493194, this);
    this.oWL = findViewById(2131298736);
    this.ItZ = this.oWL.findViewById(2131297284);
    this.Iub = ((LinearLayout)this.oWL.findViewById(2131297372));
    Object localObject = this.ItZ.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.av(getContext(), 2131165242) * a.ic(getContext())));
    this.ItZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.oWL.setOnClickListener(new View.OnClickListener()
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
    this.ItZ.setOnTouchListener(new View.OnTouchListener()
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
    localObject = (MaskLayout)this.ItZ.findViewById(2131297283);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    p.aBh();
    localImageView.setImageBitmap(com.tencent.mm.aj.e.Ad("service_officialaccounts"));
    this.Iua = ((TextView)((MaskLayout)localObject).findViewById(2131305882));
    AppMethodBeat.o(37664);
  }
  
  final void fqV()
  {
    AppMethodBeat.i(37665);
    long l = System.currentTimeMillis();
    az.ayM();
    int j = c.awB().fav();
    View localView;
    if (j > 0)
    {
      this.Iuc = true;
      localView = this.ItZ;
      if (!this.Iuc) {
        break label127;
      }
    }
    label127:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.Iuc) {
        az.agU().az(new Runnable()
        {
          public final void run()
          {
            final long l1 = 0L;
            AppMethodBeat.i(37660);
            Object localObject1 = af.aCW();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
            ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
            localObject2 = ((StringBuilder)localObject2).toString();
            ac.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
            localObject1 = ((com.tencent.mm.al.e)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject1 == null) {}
            for (;;)
            {
              az.ayM();
              long l2 = bs.dR(c.agA().get(233473, null));
              ac.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
              ap.f(new Runnable()
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
      ac.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.Iuc), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(37665);
      return;
      this.Iuc = false;
      break;
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(37666);
    ac.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Iuc) });
    View localView = this.oWL;
    if ((paramBoolean) && (this.Iuc)) {}
    for (;;)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(37666);
      return;
      i = 8;
    }
  }
  
  public final void xy(boolean paramBoolean)
  {
    AppMethodBeat.i(196745);
    if ((this.ItZ == null) || (this.Iub == null))
    {
      AppMethodBeat.o(196745);
      return;
    }
    if (paramBoolean)
    {
      int i = this.ItZ.getPaddingLeft();
      this.ItZ.setBackground(ao.aI(this.mContext, 2130969245));
      this.ItZ.setPadding(i, 0, 0, 0);
      this.Iub.setBackground(null);
      AppMethodBeat.o(196745);
      return;
    }
    this.ItZ.setBackground(null);
    this.Iub.setBackground(ao.aI(this.mContext, 2130969245));
    AppMethodBeat.o(196745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView
 * JD-Core Version:    0.7.0.1
 */