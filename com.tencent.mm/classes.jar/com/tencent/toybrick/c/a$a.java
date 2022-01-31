package com.tencent.toybrick.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public final class a$a
  extends com.tencent.toybrick.f.a
{
  public TextView eXr;
  public TextView mXQ;
  public ImageView xaA;
  public ImageView xaB;
  public MMSwitchBtn xaC;
  public TextView xaz;
  
  public a$a(final a parama, View paramView)
  {
    super(paramView);
    this.eXr = ((TextView)paramView.findViewById(16908310));
    this.xaB = ((ImageView)paramView.findViewById(a.f.left_icon));
    this.xaz = ((TextView)paramView.findViewById(a.f.text_prospect));
    this.xaA = ((ImageView)paramView.findViewById(a.f.image_prospect));
    this.mXQ = ((TextView)paramView.findViewById(a.f.summary));
    this.xaC = ((MMSwitchBtn)paramView.findViewById(a.f.checkbox));
    this.xaC.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void cr(boolean paramAnonymousBoolean)
      {
        a locala = a.a.this.xay;
        locala = a.a.this.xay;
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.toybrick.c.a.a
 * JD-Core Version:    0.7.0.1
 */