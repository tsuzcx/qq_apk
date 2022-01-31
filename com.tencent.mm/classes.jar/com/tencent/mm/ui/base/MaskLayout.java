package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MaskLayout
  extends RelativeLayout
{
  private ImageView mDg;
  private View view;
  private Drawable znS;
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106966);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.MaskLayout, paramInt, 0);
    this.znS = paramContext.getDrawable(0);
    paramContext.recycle();
    AppMethodBeat.o(106966);
  }
  
  private void a(MaskLayout.a parama)
  {
    AppMethodBeat.i(106971);
    removeView(this.mDg);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    switch (MaskLayout.1.znT[parama.ordinal()])
    {
    default: 
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    }
    for (;;)
    {
      addView(this.mDg, localLayoutParams1);
      AppMethodBeat.o(106971);
      return;
      localLayoutParams2.addRule(12);
      localLayoutParams2.addRule(11);
      localLayoutParams1 = localLayoutParams2;
      continue;
      localLayoutParams2.addRule(12);
      localLayoutParams2.addRule(9);
      localLayoutParams1 = localLayoutParams2;
      continue;
      localLayoutParams2.addRule(11);
      localLayoutParams1 = localLayoutParams2;
    }
  }
  
  public final void a(Bitmap paramBitmap, MaskLayout.a parama)
  {
    AppMethodBeat.i(106970);
    a(parama);
    this.mDg.setImageBitmap(paramBitmap);
    AppMethodBeat.o(106970);
  }
  
  public View getContentView()
  {
    return this.view;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(106967);
    super.onFinishInflate();
    this.view = findViewById(2131820946);
    if (this.view == null)
    {
      ab.d("MicroMsg.MaskLayout", "%s", new Object[] { "not found view by id, new one" });
      this.view = new View(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.view.setLayoutParams(localLayoutParams);
      addView(this.view);
    }
    this.mDg = new ImageView(getContext());
    this.mDg.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.mDg.setImageDrawable(this.znS);
    addView(this.mDg);
    AppMethodBeat.o(106967);
  }
  
  public void setMaskBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(106968);
    a(MaskLayout.a.znY);
    this.mDg.setImageBitmap(paramBitmap);
    AppMethodBeat.o(106968);
  }
  
  public void setMaskDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(106969);
    a(MaskLayout.a.znY);
    this.mDg.setImageDrawable(paramDrawable);
    AppMethodBeat.o(106969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MaskLayout
 * JD-Core Version:    0.7.0.1
 */