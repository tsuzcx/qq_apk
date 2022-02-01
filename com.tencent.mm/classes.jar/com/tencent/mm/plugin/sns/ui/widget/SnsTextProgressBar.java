package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.sns.i.a;

public class SnsTextProgressBar
  extends ProgressBar
{
  private int FG;
  private Context mContext;
  private Paint mPaint;
  private String mText;
  private int mTextSize;
  private String zlE;
  
  public SnsTextProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100565);
    this.mContext = paramContext;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, i.a.SnsTextProgressBar, 0, 0);
    try
    {
      setTextSize(paramContext.getInteger(0, 18));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(100565);
    }
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(100569);
    this.FG = paramInt;
    this.mText = (String.valueOf(paramInt) + "%");
    AppMethodBeat.o(100569);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"DrawAllocation"})
  protected void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 94
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 96	android/widget/ProgressBar:onDraw	(Landroid/graphics/Canvas;)V
    //   12: aload_0
    //   13: new 98	android/graphics/Paint
    //   16: dup
    //   17: invokespecial 99	android/graphics/Paint:<init>	()V
    //   20: putfield 101	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   23: aload_0
    //   24: getfield 101	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   27: iconst_1
    //   28: invokevirtual 105	android/graphics/Paint:setAntiAlias	(Z)V
    //   31: aload_0
    //   32: getfield 107	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:zlE	Ljava/lang/String;
    //   35: ifnull +13 -> 48
    //   38: aload_0
    //   39: getfield 107	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:zlE	Ljava/lang/String;
    //   42: invokevirtual 111	java/lang/String:length	()I
    //   45: ifgt +118 -> 163
    //   48: aload_0
    //   49: getfield 27	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mContext	Landroid/content/Context;
    //   52: invokevirtual 115	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   55: ldc 116
    //   57: invokevirtual 122	android/content/res/Resources:getColor	(I)I
    //   60: istore 4
    //   62: aload_0
    //   63: getfield 101	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   66: iload 4
    //   68: invokevirtual 125	android/graphics/Paint:setColor	(I)V
    //   71: aload_0
    //   72: getfield 101	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   75: aload_0
    //   76: getfield 127	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mTextSize	I
    //   79: i2f
    //   80: invokevirtual 130	android/graphics/Paint:setTextSize	(F)V
    //   83: new 132	android/graphics/Rect
    //   86: dup
    //   87: invokespecial 133	android/graphics/Rect:<init>	()V
    //   90: astore 5
    //   92: aload_0
    //   93: getfield 101	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   96: aload_0
    //   97: getfield 88	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mText	Ljava/lang/String;
    //   100: iconst_0
    //   101: aload_0
    //   102: getfield 88	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mText	Ljava/lang/String;
    //   105: invokevirtual 111	java/lang/String:length	()I
    //   108: aload 5
    //   110: invokevirtual 137	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   113: aload_0
    //   114: invokevirtual 140	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:getWidth	()I
    //   117: iconst_2
    //   118: idiv
    //   119: aload 5
    //   121: invokevirtual 143	android/graphics/Rect:centerX	()I
    //   124: isub
    //   125: i2f
    //   126: fstore_2
    //   127: aload_0
    //   128: invokevirtual 146	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:getHeight	()I
    //   131: iconst_2
    //   132: idiv
    //   133: aload 5
    //   135: invokevirtual 149	android/graphics/Rect:centerY	()I
    //   138: isub
    //   139: i2f
    //   140: fstore_3
    //   141: aload_1
    //   142: aload_0
    //   143: getfield 88	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mText	Ljava/lang/String;
    //   146: fload_2
    //   147: fload_3
    //   148: aload_0
    //   149: getfield 101	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   152: invokevirtual 155	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   155: ldc 94
    //   157: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    //   163: aload_0
    //   164: getfield 107	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:zlE	Ljava/lang/String;
    //   167: invokestatic 161	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   170: istore 4
    //   172: goto -110 -> 62
    //   175: astore_1
    //   176: aload_0
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	SnsTextProgressBar
    //   0	180	1	paramCanvas	android.graphics.Canvas
    //   126	21	2	f1	float
    //   140	8	3	f2	float
    //   60	111	4	i	int
    //   90	44	5	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   2	48	175	finally
    //   48	62	175	finally
    //   62	160	175	finally
    //   163	172	175	finally
  }
  
  public void setPaintColor(String paramString)
  {
    this.zlE = paramString;
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(100566);
    setText(paramInt);
    super.setProgress(paramInt);
    AppMethodBeat.o(100566);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(100568);
    this.mTextSize = a.fromDPToPix(this.mContext, paramInt);
    AppMethodBeat.o(100568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar
 * JD-Core Version:    0.7.0.1
 */