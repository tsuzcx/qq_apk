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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;

public class MaskLayout
  extends RelativeLayout
{
  private ImageView Aov;
  private Drawable adVh;
  private View view;
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142330);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MaskLayout, paramInt, 0);
    this.adVh = paramContext.getDrawable(a.m.MaskLayout_foreground);
    paramContext.recycle();
    AppMethodBeat.o(142330);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(142335);
    removeView(this.Aov);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    switch (1.adVi[parama.ordinal()])
    {
    default: 
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    }
    for (;;)
    {
      addView(this.Aov, localLayoutParams1);
      AppMethodBeat.o(142335);
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
  
  public final void a(Bitmap paramBitmap, a parama)
  {
    AppMethodBeat.i(142334);
    a(parama);
    this.Aov.setImageBitmap(paramBitmap);
    AppMethodBeat.o(142334);
  }
  
  public View getContentView()
  {
    return this.view;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(142331);
    super.onFinishInflate();
    this.view = findViewById(a.g.content);
    if (this.view == null)
    {
      Log.d("MicroMsg.MaskLayout", "%s", new Object[] { "not found view by id, new one" });
      this.view = new View(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.view.setLayoutParams(localLayoutParams);
      addView(this.view);
    }
    this.Aov = new ImageView(getContext());
    this.Aov.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.Aov.setImageDrawable(this.adVh);
    addView(this.Aov);
    AppMethodBeat.o(142331);
  }
  
  public void setMaskBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(142332);
    a(a.adVn);
    this.Aov.setImageBitmap(paramBitmap);
    AppMethodBeat.o(142332);
  }
  
  public void setMaskDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142333);
    a(a.adVn);
    this.Aov.setImageDrawable(paramDrawable);
    AppMethodBeat.o(142333);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(142329);
      adVj = new a("SUBSCRIPT_DRAWABLE_DIRECTION_TOP_RIGHT", 0);
      adVk = new a("SUBSCRIPT_DRAWABLE_DIRECTION_TOP_LEFT", 1);
      adVl = new a("SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT", 2);
      adVm = new a("SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_LEFT", 3);
      adVn = new a("SUBSCRIPT_DRAWABLE_DIRECTION_ALL", 4);
      adVo = new a[] { adVj, adVk, adVl, adVm, adVn };
      AppMethodBeat.o(142329);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MaskLayout
 * JD-Core Version:    0.7.0.1
 */