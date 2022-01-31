package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.i.l;

public class SnsTextProgressBar
  extends ProgressBar
{
  private int gFm;
  private String hnV;
  private Context mContext;
  private Paint mPaint;
  private String prs;
  private int xL;
  
  public SnsTextProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, i.l.SnsTextProgressBar, 0, 0);
    try
    {
      setTextSize(paramContext.getInteger(i.l.SnsTextProgressBar_testSize, 18));
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void setText(int paramInt)
  {
    this.xL = paramInt;
    this.hnV = (String.valueOf(paramInt) + "%");
  }
  
  /* Error */
  @android.annotation.SuppressLint({"DrawAllocation"})
  protected void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 88	android/widget/ProgressBar:onDraw	(Landroid/graphics/Canvas;)V
    //   7: aload_0
    //   8: new 90	android/graphics/Paint
    //   11: dup
    //   12: invokespecial 91	android/graphics/Paint:<init>	()V
    //   15: putfield 93	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   18: aload_0
    //   19: getfield 93	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   22: iconst_1
    //   23: invokevirtual 97	android/graphics/Paint:setAntiAlias	(Z)V
    //   26: aload_0
    //   27: getfield 99	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:prs	Ljava/lang/String;
    //   30: ifnull +13 -> 43
    //   33: aload_0
    //   34: getfield 99	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:prs	Ljava/lang/String;
    //   37: invokevirtual 103	java/lang/String:length	()I
    //   40: ifgt +114 -> 154
    //   43: aload_0
    //   44: getfield 20	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mContext	Landroid/content/Context;
    //   47: invokevirtual 107	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   50: getstatic 112	com/tencent/mm/plugin/sns/i$c:white_text_color_pressed	I
    //   53: invokevirtual 118	android/content/res/Resources:getColor	(I)I
    //   56: istore 4
    //   58: aload_0
    //   59: getfield 93	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   62: iload 4
    //   64: invokevirtual 121	android/graphics/Paint:setColor	(I)V
    //   67: aload_0
    //   68: getfield 93	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   71: aload_0
    //   72: getfield 123	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:gFm	I
    //   75: i2f
    //   76: invokevirtual 126	android/graphics/Paint:setTextSize	(F)V
    //   79: new 128	android/graphics/Rect
    //   82: dup
    //   83: invokespecial 129	android/graphics/Rect:<init>	()V
    //   86: astore 5
    //   88: aload_0
    //   89: getfield 93	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   92: aload_0
    //   93: getfield 81	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:hnV	Ljava/lang/String;
    //   96: iconst_0
    //   97: aload_0
    //   98: getfield 81	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:hnV	Ljava/lang/String;
    //   101: invokevirtual 103	java/lang/String:length	()I
    //   104: aload 5
    //   106: invokevirtual 133	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   109: aload_0
    //   110: invokevirtual 136	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:getWidth	()I
    //   113: iconst_2
    //   114: idiv
    //   115: aload 5
    //   117: invokevirtual 139	android/graphics/Rect:centerX	()I
    //   120: isub
    //   121: i2f
    //   122: fstore_2
    //   123: aload_0
    //   124: invokevirtual 142	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:getHeight	()I
    //   127: iconst_2
    //   128: idiv
    //   129: aload 5
    //   131: invokevirtual 145	android/graphics/Rect:centerY	()I
    //   134: isub
    //   135: i2f
    //   136: fstore_3
    //   137: aload_1
    //   138: aload_0
    //   139: getfield 81	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:hnV	Ljava/lang/String;
    //   142: fload_2
    //   143: fload_3
    //   144: aload_0
    //   145: getfield 93	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   148: invokevirtual 151	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: aload_0
    //   155: getfield 99	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:prs	Ljava/lang/String;
    //   158: invokestatic 157	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   161: istore 4
    //   163: goto -105 -> 58
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	SnsTextProgressBar
    //   0	171	1	paramCanvas	android.graphics.Canvas
    //   122	21	2	f1	float
    //   136	8	3	f2	float
    //   56	106	4	i	int
    //   86	44	5	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   2	43	166	finally
    //   43	58	166	finally
    //   58	151	166	finally
    //   154	163	166	finally
  }
  
  public void setPaintColor(String paramString)
  {
    this.prs = paramString;
  }
  
  public void setProgress(int paramInt)
  {
    setText(paramInt);
    super.setProgress(paramInt);
  }
  
  public void setTextSize(int paramInt)
  {
    this.gFm = a.fromDPToPix(this.mContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar
 * JD-Core Version:    0.7.0.1
 */