package com.tencent.mm.ui.widget.seekbar;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/seekbar/BothSidesSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isBothSidesMode", "", "()Z", "setBothSidesMode", "(Z)V", "paint", "Landroid/graphics/Paint;", "seekbarHeight", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BothSidesSeekBar
  extends AppCompatSeekBar
{
  private int agmm;
  private boolean agmn;
  private Paint paint;
  
  public BothSidesSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(251755);
    AppMethodBeat.o(251755);
  }
  
  public BothSidesSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251752);
    this.agmm = bd.fromDPToPix(getContext(), 4);
    paramContext = new Paint();
    paramContext.setStrokeCap(Paint.Cap.ROUND);
    paramContext.setStrokeWidth(this.agmm);
    paramAttributeSet = ah.aiuX;
    this.paint = paramContext;
    AppMethodBeat.o(251752);
  }
  
  /* Error */
  public final void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 106
    //   4: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 107
    //   10: invokestatic 47	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 104	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:paint	Landroid/graphics/Paint;
    //   17: ldc 108
    //   19: invokevirtual 111	android/graphics/Paint:setColor	(I)V
    //   22: aload_1
    //   23: fconst_0
    //   24: aload_0
    //   25: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   28: i2f
    //   29: fadd
    //   30: aload_0
    //   31: invokevirtual 118	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getHeight	()I
    //   34: i2f
    //   35: fconst_2
    //   36: fdiv
    //   37: aload_0
    //   38: invokevirtual 121	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getWidth	()I
    //   41: i2f
    //   42: aload_0
    //   43: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   46: i2f
    //   47: fsub
    //   48: aload_0
    //   49: invokevirtual 118	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getHeight	()I
    //   52: i2f
    //   53: fconst_2
    //   54: fdiv
    //   55: aload_0
    //   56: getfield 104	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:paint	Landroid/graphics/Paint;
    //   59: invokevirtual 127	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   62: aload_0
    //   63: getfield 129	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:agmn	Z
    //   66: ifeq +206 -> 272
    //   69: aload_0
    //   70: invokevirtual 132	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getMax	()I
    //   73: iconst_2
    //   74: idiv
    //   75: istore 6
    //   77: aload_0
    //   78: invokevirtual 135	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getProgress	()I
    //   81: iload 6
    //   83: if_icmple +91 -> 174
    //   86: aload_0
    //   87: getfield 104	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:paint	Landroid/graphics/Paint;
    //   90: iconst_m1
    //   91: invokevirtual 111	android/graphics/Paint:setColor	(I)V
    //   94: aload_0
    //   95: invokevirtual 121	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getWidth	()I
    //   98: i2f
    //   99: fconst_2
    //   100: fdiv
    //   101: fstore_2
    //   102: aload_0
    //   103: invokevirtual 118	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getHeight	()I
    //   106: i2f
    //   107: fconst_2
    //   108: fdiv
    //   109: fstore_3
    //   110: aload_0
    //   111: invokevirtual 121	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getWidth	()I
    //   114: i2f
    //   115: fconst_2
    //   116: fdiv
    //   117: fstore 4
    //   119: aload_0
    //   120: invokevirtual 121	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getWidth	()I
    //   123: aload_0
    //   124: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   127: iconst_2
    //   128: imul
    //   129: isub
    //   130: aload_0
    //   131: invokevirtual 132	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getMax	()I
    //   134: idiv
    //   135: aload_0
    //   136: invokevirtual 135	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getProgress	()I
    //   139: iload 6
    //   141: isub
    //   142: imul
    //   143: i2f
    //   144: fstore 5
    //   146: aload_1
    //   147: fload_2
    //   148: fload_3
    //   149: aload_0
    //   150: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   153: i2f
    //   154: fload 4
    //   156: fload 5
    //   158: fadd
    //   159: fadd
    //   160: aload_0
    //   161: invokevirtual 118	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getHeight	()I
    //   164: i2f
    //   165: fconst_2
    //   166: fdiv
    //   167: aload_0
    //   168: getfield 104	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:paint	Landroid/graphics/Paint;
    //   171: invokevirtual 127	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   174: aload_0
    //   175: invokevirtual 135	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getProgress	()I
    //   178: iload 6
    //   180: if_icmpge +79 -> 259
    //   183: aload_0
    //   184: getfield 104	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:paint	Landroid/graphics/Paint;
    //   187: iconst_m1
    //   188: invokevirtual 111	android/graphics/Paint:setColor	(I)V
    //   191: aload_1
    //   192: aload_0
    //   193: invokevirtual 121	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getWidth	()I
    //   196: i2f
    //   197: fconst_2
    //   198: fdiv
    //   199: aload_0
    //   200: invokevirtual 121	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getWidth	()I
    //   203: aload_0
    //   204: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   207: iconst_2
    //   208: imul
    //   209: isub
    //   210: aload_0
    //   211: invokevirtual 132	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getMax	()I
    //   214: idiv
    //   215: iload 6
    //   217: aload_0
    //   218: invokevirtual 135	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getProgress	()I
    //   221: isub
    //   222: imul
    //   223: i2f
    //   224: fsub
    //   225: aload_0
    //   226: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   229: i2f
    //   230: fsub
    //   231: aload_0
    //   232: invokevirtual 118	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getHeight	()I
    //   235: i2f
    //   236: fconst_2
    //   237: fdiv
    //   238: aload_0
    //   239: invokevirtual 121	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getWidth	()I
    //   242: i2f
    //   243: fconst_2
    //   244: fdiv
    //   245: aload_0
    //   246: invokevirtual 118	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getHeight	()I
    //   249: i2f
    //   250: fconst_2
    //   251: fdiv
    //   252: aload_0
    //   253: getfield 104	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:paint	Landroid/graphics/Paint;
    //   256: invokevirtual 127	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   259: aload_0
    //   260: aload_1
    //   261: invokespecial 137	androidx/appcompat/widget/AppCompatSeekBar:onDraw	(Landroid/graphics/Canvas;)V
    //   264: ldc 106
    //   266: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_0
    //   270: monitorexit
    //   271: return
    //   272: aload_0
    //   273: getfield 104	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:paint	Landroid/graphics/Paint;
    //   276: iconst_m1
    //   277: invokevirtual 111	android/graphics/Paint:setColor	(I)V
    //   280: aload_0
    //   281: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   284: i2f
    //   285: fstore_2
    //   286: aload_0
    //   287: invokevirtual 118	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getHeight	()I
    //   290: i2f
    //   291: fconst_2
    //   292: fdiv
    //   293: fstore_3
    //   294: aload_0
    //   295: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   298: i2f
    //   299: fstore 4
    //   301: aload_1
    //   302: fconst_0
    //   303: fload_2
    //   304: fadd
    //   305: fload_3
    //   306: aload_0
    //   307: invokevirtual 121	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getWidth	()I
    //   310: aload_0
    //   311: invokevirtual 115	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getThumbOffset	()I
    //   314: iconst_2
    //   315: imul
    //   316: isub
    //   317: i2f
    //   318: aload_0
    //   319: invokevirtual 135	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getProgress	()I
    //   322: i2f
    //   323: aload_0
    //   324: invokevirtual 132	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getMax	()I
    //   327: i2f
    //   328: fdiv
    //   329: fmul
    //   330: fload 4
    //   332: fadd
    //   333: aload_0
    //   334: invokevirtual 118	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:getHeight	()I
    //   337: i2f
    //   338: fconst_2
    //   339: fdiv
    //   340: aload_0
    //   341: getfield 104	com/tencent/mm/ui/widget/seekbar/BothSidesSeekBar:paint	Landroid/graphics/Paint;
    //   344: invokevirtual 127	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   347: goto -88 -> 259
    //   350: astore_1
    //   351: aload_0
    //   352: monitorexit
    //   353: aload_1
    //   354: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	BothSidesSeekBar
    //   0	355	1	paramCanvas	android.graphics.Canvas
    //   101	203	2	f1	float
    //   109	197	3	f2	float
    //   117	214	4	f3	float
    //   144	13	5	f4	float
    //   75	147	6	i	int
    // Exception table:
    //   from	to	target	type
    //   2	174	350	finally
    //   174	259	350	finally
    //   259	269	350	finally
    //   272	347	350	finally
  }
  
  public final void setBothSidesMode(boolean paramBoolean)
  {
    this.agmn = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.seekbar.BothSidesSeekBar
 * JD-Core Version:    0.7.0.1
 */