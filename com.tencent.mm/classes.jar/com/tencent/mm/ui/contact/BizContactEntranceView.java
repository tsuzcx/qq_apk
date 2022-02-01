package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.View;
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
import com.tencent.mm.am.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.ci.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView
  extends RelativeLayout
{
  private View XqJ;
  private TextView XqK;
  private LinearLayout XqL;
  private boolean XqM;
  private boolean XqN;
  private Context mContext;
  private View uzz;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37663);
    this.uzz = null;
    this.XqM = true;
    this.mContext = paramContext;
    init();
    hUn();
    AppMethodBeat.o(37663);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(37662);
    this.uzz = null;
    this.XqM = true;
    this.mContext = paramContext;
    init();
    hUn();
    AppMethodBeat.o(37662);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(37661);
    this.uzz = null;
    this.XqM = true;
    this.mContext = paramContext;
    init();
    hUn();
    AppMethodBeat.o(37661);
  }
  
  private void hUn()
  {
    AppMethodBeat.i(37665);
    long l = System.currentTimeMillis();
    bh.beI();
    int j = c.bbL().hyq();
    View localView;
    if (j > 0)
    {
      this.XqM = true;
      localView = this.XqJ;
      if (!this.XqM) {
        break label127;
      }
    }
    label127:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.XqM) {
        bh.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            final long l1 = 0L;
            AppMethodBeat.i(37660);
            Object localObject1 = af.bjv();
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
            ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
            localObject2 = ((StringBuilder)localObject2).toString();
            Log.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
            localObject1 = ((com.tencent.mm.ao.f)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject1 == null) {}
            for (;;)
            {
              bh.beI();
              long l2 = Util.nullAsLong(c.aHp().b(233473, null), 0);
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
      Log.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.XqM), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(37665);
      return;
      this.XqM = false;
      break;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(37664);
    this.XqN = false;
    View.inflate(getContext(), R.i.ecb, this);
    this.uzz = findViewById(R.h.container);
    this.XqJ = this.uzz.findViewById(R.h.dtk);
    this.XqL = ((LinearLayout)this.uzz.findViewById(R.h.dun));
    Object localObject = this.XqJ.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.aZ(getContext(), R.f.ContactListHeight) * a.kn(getContext())));
    this.XqJ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.uzz.setOnClickListener(new BizContactEntranceView.1(this));
    this.XqJ.setOnTouchListener(new BizContactEntranceView.2(this));
    localObject = (MaskLayout)this.XqJ.findViewById(R.h.dtj);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    q.bhz();
    localImageView.setImageBitmap(com.tencent.mm.am.f.TK("service_officialaccounts"));
    this.XqK = ((TextView)((MaskLayout)localObject).findViewById(R.h.tipcnt_tv));
    AppMethodBeat.o(37664);
  }
  
  public final void GJ(boolean paramBoolean)
  {
    AppMethodBeat.i(264916);
    if ((this.XqJ == null) || (this.XqL == null))
    {
      AppMethodBeat.o(264916);
      return;
    }
    if (paramBoolean)
    {
      int i = this.XqJ.getPaddingLeft();
      this.XqJ.setBackground(aw.bf(this.mContext, R.d.list_item_divider));
      this.XqJ.setPadding(i, 0, 0, 0);
      this.XqL.setBackground(null);
      AppMethodBeat.o(264916);
      return;
    }
    this.XqJ.setBackground(null);
    this.XqL.setBackground(aw.bf(this.mContext, R.d.list_item_divider));
    AppMethodBeat.o(264916);
  }
  
  public final void gZg()
  {
    AppMethodBeat.i(264915);
    hUn();
    setVisible(true);
    AppMethodBeat.o(264915);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(37666);
    Log.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.XqM) });
    View localView = this.uzz;
    if ((paramBoolean) && (this.XqM)) {}
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