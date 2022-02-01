package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.i.l;

public class SnsTextProgressBar
  extends ProgressBar
{
  private int IB;
  private String Luz;
  private Context mContext;
  private Paint mPaint;
  private String mText;
  private int pyF;
  
  public SnsTextProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100565);
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
      AppMethodBeat.o(100565);
    }
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(100569);
    this.IB = paramInt;
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
    //   2: ldc 97
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 99	android/widget/ProgressBar:onDraw	(Landroid/graphics/Canvas;)V
    //   12: aload_0
    //   13: new 101	android/graphics/Paint
    //   16: dup
    //   17: invokespecial 102	android/graphics/Paint:<init>	()V
    //   20: putfield 104	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   23: aload_0
    //   24: getfield 104	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   27: iconst_1
    //   28: invokevirtual 108	android/graphics/Paint:setAntiAlias	(Z)V
    //   31: aload_0
    //   32: getfield 110	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:Luz	Ljava/lang/String;
    //   35: ifnull +13 -> 48
    //   38: aload_0
    //   39: getfield 110	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:Luz	Ljava/lang/String;
    //   42: invokevirtual 114	java/lang/String:length	()I
    //   45: ifgt +119 -> 164
    //   48: aload_0
    //   49: getfield 27	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mContext	Landroid/content/Context;
    //   52: invokevirtual 118	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   55: getstatic 123	com/tencent/mm/plugin/sns/i$c:white_text_color_pressed	I
    //   58: invokevirtual 129	android/content/res/Resources:getColor	(I)I
    //   61: istore 4
    //   63: aload_0
    //   64: getfield 104	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   67: iload 4
    //   69: invokevirtual 132	android/graphics/Paint:setColor	(I)V
    //   72: aload_0
    //   73: getfield 104	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   76: aload_0
    //   77: getfield 134	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:pyF	I
    //   80: i2f
    //   81: invokevirtual 137	android/graphics/Paint:setTextSize	(F)V
    //   84: new 139	android/graphics/Rect
    //   87: dup
    //   88: invokespecial 140	android/graphics/Rect:<init>	()V
    //   91: astore 5
    //   93: aload_0
    //   94: getfield 104	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   97: aload_0
    //   98: getfield 91	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mText	Ljava/lang/String;
    //   101: iconst_0
    //   102: aload_0
    //   103: getfield 91	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mText	Ljava/lang/String;
    //   106: invokevirtual 114	java/lang/String:length	()I
    //   109: aload 5
    //   111: invokevirtual 144	android/graphics/Paint:getTextBounds	(Ljava/lang/String;IILandroid/graphics/Rect;)V
    //   114: aload_0
    //   115: invokevirtual 147	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:getWidth	()I
    //   118: iconst_2
    //   119: idiv
    //   120: aload 5
    //   122: invokevirtual 150	android/graphics/Rect:centerX	()I
    //   125: isub
    //   126: i2f
    //   127: fstore_2
    //   128: aload_0
    //   129: invokevirtual 153	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:getHeight	()I
    //   132: iconst_2
    //   133: idiv
    //   134: aload 5
    //   136: invokevirtual 156	android/graphics/Rect:centerY	()I
    //   139: isub
    //   140: i2f
    //   141: fstore_3
    //   142: aload_1
    //   143: aload_0
    //   144: getfield 91	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mText	Ljava/lang/String;
    //   147: fload_2
    //   148: fload_3
    //   149: aload_0
    //   150: getfield 104	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:mPaint	Landroid/graphics/Paint;
    //   153: invokevirtual 162	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   156: ldc 97
    //   158: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_0
    //   162: monitorexit
    //   163: return
    //   164: aload_0
    //   165: getfield 110	com/tencent/mm/plugin/sns/ui/widget/SnsTextProgressBar:Luz	Ljava/lang/String;
    //   168: invokestatic 168	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   171: istore 4
    //   173: goto -110 -> 63
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	SnsTextProgressBar
    //   0	181	1	paramCanvas	android.graphics.Canvas
    //   127	21	2	f1	float
    //   141	8	3	f2	float
    //   61	111	4	i	int
    //   91	44	5	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   2	48	176	finally
    //   48	63	176	finally
    //   63	161	176	finally
    //   164	173	176	finally
  }
  
  public void setPaintColor(String paramString)
  {
    this.Luz = paramString;
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
    this.pyF = a.fromDPToPix(this.mContext, paramInt);
    AppMethodBeat.o(100568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar
 * JD-Core Version:    0.7.0.1
 */