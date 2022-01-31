package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.MaskLayout;

public final class b
  extends RelativeLayout
{
  private TextView contentView;
  private Context context;
  private View gcq;
  private View gyT;
  
  public b(Context paramContext, b.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(33537);
    this.gcq = null;
    this.gyT = null;
    this.contentView = null;
    this.context = paramContext;
    View.inflate(getContext(), 2130968641, this);
    this.gcq = findViewById(2131821084);
    this.gyT = this.gcq.findViewById(2131821085);
    paramContext = this.gyT.getLayoutParams();
    paramContext.height = ((int)(a.ap(this.context, 2131427549) * a.gs(this.context)));
    this.gyT.setLayoutParams(paramContext);
    this.contentView = ((TextView)this.gyT.findViewById(2131821088));
    this.gcq.setOnClickListener(new b.1(this, parama));
    this.gyT.setOnTouchListener(new b.2(this));
    paramContext = (ImageView)((MaskLayout)this.gyT.findViewById(2131821086)).getContentView();
    switch (b.3.AaR[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33537);
      return;
      this.contentView.setText(2131296450);
      d.a(getContext(), paramContext, 2131231210);
      AppMethodBeat.o(33537);
      return;
      this.contentView.setText(2131296454);
      d.a(getContext(), paramContext, 2131231211);
      AppMethodBeat.o(33537);
      return;
      this.gyT.setBackgroundResource(2130838445);
      this.contentView.setText(2131296453);
      d.a(getContext(), paramContext, 2131231217);
    }
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(33538);
    View localView = this.gcq;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(33538);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.b
 * JD-Core Version:    0.7.0.1
 */