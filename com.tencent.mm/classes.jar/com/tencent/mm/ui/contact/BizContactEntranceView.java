package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.o;
import com.tencent.mm.cb.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MaskLayout;

public class BizContactEntranceView
  extends RelativeLayout
{
  View Abq;
  private TextView Abr;
  LinearLayout Abs;
  private boolean Abt;
  private boolean Abu;
  private View ldA;
  private Context mContext;
  
  public BizContactEntranceView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33545);
    this.ldA = null;
    this.Abt = true;
    this.mContext = paramContext;
    init();
    dLH();
    AppMethodBeat.o(33545);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33544);
    this.ldA = null;
    this.Abt = true;
    this.mContext = paramContext;
    init();
    dLH();
    AppMethodBeat.o(33544);
  }
  
  public BizContactEntranceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(33543);
    this.ldA = null;
    this.Abt = true;
    this.mContext = paramContext;
    init();
    dLH();
    AppMethodBeat.o(33543);
  }
  
  private void init()
  {
    AppMethodBeat.i(33546);
    this.Abu = false;
    View.inflate(getContext(), 2130968862, this);
    this.ldA = findViewById(2131821084);
    this.Abq = this.ldA.findViewById(2131821836);
    this.Abs = ((LinearLayout)this.ldA.findViewById(2131821838));
    Object localObject = this.Abq.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(a.ap(getContext(), 2131427549) * a.gs(getContext())));
    this.Abq.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.ldA.setOnClickListener(new BizContactEntranceView.1(this));
    this.Abq.setOnTouchListener(new BizContactEntranceView.2(this));
    localObject = (MaskLayout)this.Abq.findViewById(2131821837);
    ImageView localImageView = (ImageView)((MaskLayout)localObject).getContentView();
    o.acQ();
    localImageView.setImageBitmap(d.rc("service_officialaccounts"));
    this.Abr = ((TextView)((MaskLayout)localObject).findViewById(2131821087));
    AppMethodBeat.o(33546);
  }
  
  final void dLH()
  {
    AppMethodBeat.i(33547);
    long l = System.currentTimeMillis();
    aw.aaz();
    int j = c.YA().dwQ();
    View localView;
    if (j > 0)
    {
      this.Abt = true;
      localView = this.Abq;
      if (!this.Abt) {
        break label127;
      }
    }
    label127:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      if (this.Abt) {
        aw.RO().ac(new BizContactEntranceView.3(this));
      }
      ab.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.Abt), Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(33547);
      return;
      this.Abt = false;
      break;
    }
  }
  
  public void setVisible(boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(33548);
    ab.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Abt) });
    View localView = this.ldA;
    if ((paramBoolean) && (this.Abt)) {}
    for (;;)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(33548);
      return;
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView
 * JD-Core Version:    0.7.0.1
 */