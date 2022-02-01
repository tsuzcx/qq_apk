package com.tencent.mm.plugin.sns.ad.widget.interactionlabel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.b.e;

public class ShakeCoverAnimView
  extends ViewGroup
{
  public static int Qgp = 350;
  public View Qgo;
  public float hco;
  
  public ShakeCoverAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShakeCoverAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ShakeCoverAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(310241);
    paramInt1 = a.fromDPToPix(getContext(), 32);
    if (this.Qgo == null)
    {
      this.Qgo = new View(getContext());
      this.Qgo.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt1));
      this.Qgo.setBackgroundResource(b.e.sns_ad_shake_anim_bg);
      addView(this.Qgo);
    }
    paramInt2 = getMeasuredHeight();
    this.Qgo.layout(0, paramInt2, paramInt1 + 0, paramInt2 + paramInt1);
    paramInt3 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if ((paramInt3 > 0) && (paramInt2 > 0))
    {
      paramInt3 -= paramInt1 / 2;
      paramInt2 += paramInt1 / 2;
      this.hco = ((float)(Math.sqrt(paramInt3 * paramInt3 + paramInt2 * paramInt2) * 2.0D / paramInt1) + 0.5F);
    }
    AppMethodBeat.o(310241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.interactionlabel.ShakeCoverAnimView
 * JD-Core Version:    0.7.0.1
 */