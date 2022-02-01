package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.c.d;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;

public class WXRTEditText
  extends PasterEditText
  implements SpanWatcher
{
  com.tencent.mm.plugin.wenote.model.nativenote.b.c XBf;
  private WXRTEditText XBg;
  private j XBh;
  private com.tencent.mm.plugin.wenote.model.nativenote.c.b XBi;
  private MTimerHandler eln;
  public int mI;
  private int xAa;
  private int xAb;
  private int xAc;
  private boolean xAd;
  TextWatcher xAe;
  int xAf;
  public boolean xyj;
  public int xyl;
  private int xzA;
  private boolean xzB;
  private boolean xzC;
  private int xzD;
  private int xzE;
  private String xzF;
  public String xzG;
  private Spannable xzH;
  int xzI;
  public RecyclerView.v xzK;
  private boolean xzL;
  private boolean xzM;
  private boolean xzN;
  private boolean xzO;
  private boolean xzP;
  private boolean xzQ;
  private boolean xzR;
  public boolean xzT;
  public boolean xzU;
  private int xzV;
  private Paint xzW;
  private boolean xzY;
  private Path xzZ;
  private int xzz;
  
  public WXRTEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(30482);
    this.xzz = -1;
    this.xzA = -1;
    this.xzB = false;
    this.xzG = "";
    this.xzI = 0;
    this.XBg = null;
    this.mI = 0;
    this.xyj = false;
    this.xzQ = false;
    this.xzT = false;
    this.xyl = 0;
    this.xzU = false;
    this.xzV = -1;
    this.xzW = null;
    this.eln = null;
    this.XBi = null;
    this.xzY = false;
    this.xzZ = null;
    this.xAa = -1;
    this.xAb = -1;
    this.xAc = -1;
    this.xAd = false;
    this.xAe = new TextWatcher()
    {
      /* Error */
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: sipush 30480
        //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: ldc 28
        //   10: ldc 29
        //   12: invokestatic 35	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   15: aload_1
        //   16: invokevirtual 39	java/lang/Object:toString	()Ljava/lang/String;
        //   19: astore_3
        //   20: aload_0
        //   21: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   24: getfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   27: ifnonnull +348 -> 375
        //   30: ldc 45
        //   32: astore_1
        //   33: aload_0
        //   34: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   37: invokestatic 49	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:f	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
        //   40: ifeq +12 -> 52
        //   43: aload_0
        //   44: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   47: ldc 45
        //   49: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   52: aload_0
        //   53: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   56: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   59: ifne +165 -> 224
        //   62: aload_0
        //   63: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   66: invokevirtual 56	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/e;
        //   69: getfield 62	com/tencent/mm/plugin/wenote/model/nativenote/manager/e:uG	I
        //   72: aload_0
        //   73: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   76: invokevirtual 56	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/e;
        //   79: getfield 65	com/tencent/mm/plugin/wenote/model/nativenote/manager/e:uH	I
        //   82: if_icmpne +142 -> 224
        //   85: aload_1
        //   86: ldc 67
        //   88: invokevirtual 73	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   91: ifne +29 -> 120
        //   94: new 75	java/lang/StringBuilder
        //   97: dup
        //   98: invokespecial 76	java/lang/StringBuilder:<init>	()V
        //   101: aload_1
        //   102: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: ldc 67
        //   107: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   113: aload_3
        //   114: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   117: ifne +29 -> 146
        //   120: aload_1
        //   121: ldc 67
        //   123: invokevirtual 73	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   126: ifeq +98 -> 224
        //   129: aload_1
        //   130: ldc 87
        //   132: invokevirtual 73	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   135: ifne +89 -> 224
        //   138: aload_1
        //   139: aload_3
        //   140: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   143: ifeq +81 -> 224
        //   146: aload_0
        //   147: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   150: invokevirtual 91	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
        //   153: aload_1
        //   154: invokevirtual 95	java/lang/String:length	()I
        //   157: aload_1
        //   158: invokevirtual 95	java/lang/String:length	()I
        //   161: ldc 97
        //   163: invokeinterface 103 4 0
        //   168: checkcast 105	[Landroid/text/style/ParagraphStyle;
        //   171: arraylength
        //   172: ifle +52 -> 224
        //   175: aload_0
        //   176: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   179: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   182: istore_2
        //   183: aload_0
        //   184: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   187: iconst_1
        //   188: invokestatic 112	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Z)Z
        //   191: pop
        //   192: aload_0
        //   193: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   196: invokevirtual 91	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
        //   199: ldc 67
        //   201: invokeinterface 115 2 0
        //   206: pop
        //   207: aload_0
        //   208: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   211: iconst_0
        //   212: invokestatic 112	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Z)Z
        //   215: pop
        //   216: aload_0
        //   217: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   220: iload_2
        //   221: invokevirtual 118	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:setSelection	(I)V
        //   224: aload_0
        //   225: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   228: invokestatic 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
        //   231: ifnull +105 -> 336
        //   234: aload_0
        //   235: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   238: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   241: ifne +95 -> 336
        //   244: aload_1
        //   245: aload_3
        //   246: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   249: ifne +87 -> 336
        //   252: aload_0
        //   253: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   256: invokevirtual 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:dwD	()Landroid/text/Spannable;
        //   259: astore_1
        //   260: aload_0
        //   261: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   264: aload_3
        //   265: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   268: aload_0
        //   269: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   272: invokestatic 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
        //   275: astore_3
        //   276: aload_0
        //   277: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   280: invokestatic 130	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:h	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   283: astore 4
        //   285: aload_0
        //   286: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   289: invokestatic 133	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:i	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Landroid/text/Spannable;
        //   292: astore 5
        //   294: aload_0
        //   295: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   298: invokestatic 136	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:j	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
        //   301: pop
        //   302: aload_0
        //   303: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   306: invokestatic 139	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:k	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
        //   309: pop
        //   310: aload_0
        //   311: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   314: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   317: pop
        //   318: aload_3
        //   319: aload 4
        //   321: aload 5
        //   323: aload_1
        //   324: aload_0
        //   325: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   328: invokevirtual 142	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
        //   331: invokeinterface 147 5 0
        //   336: aload_0
        //   337: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   340: invokestatic 150	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:e	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   343: pop
        //   344: aload_0
        //   345: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   348: invokestatic 153	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:l	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   351: pop
        //   352: aload_0
        //   353: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   356: invokestatic 156	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:m	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)V
        //   359: aload_0
        //   360: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   363: invokestatic 159	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:n	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)V
        //   366: sipush 30480
        //   369: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   372: aload_0
        //   373: monitorexit
        //   374: return
        //   375: aload_0
        //   376: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   379: getfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   382: astore_1
        //   383: goto -350 -> 33
        //   386: astore_1
        //   387: aload_0
        //   388: monitorexit
        //   389: aload_1
        //   390: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	391	0	this	2
        //   0	391	1	paramAnonymousEditable	Editable
        //   182	39	2	i	int
        //   19	300	3	localObject	Object
        //   283	37	4	localWXRTEditText	WXRTEditText
        //   292	30	5	localSpannable	Spannable
        // Exception table:
        //   from	to	target	type
        //   2	30	386	finally
        //   33	52	386	finally
        //   52	120	386	finally
        //   120	146	386	finally
        //   146	224	386	finally
        //   224	336	386	finally
        //   336	372	386	finally
        //   375	383	386	finally
      }
      
      /* Error */
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: sipush 30478
        //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: aload_0
        //   9: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   12: invokestatic 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   15: ifnonnull +113 -> 128
        //   18: ldc 45
        //   20: astore 5
        //   22: aload_0
        //   23: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   26: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   29: ifne +90 -> 119
        //   32: aload_1
        //   33: invokeinterface 171 1 0
        //   38: aload 5
        //   40: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   43: ifne +76 -> 119
        //   46: aload_0
        //   47: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   50: aload_0
        //   51: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   54: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   57: invokestatic 174	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;I)I
        //   60: pop
        //   61: aload_0
        //   62: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   65: aload_0
        //   66: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   69: invokevirtual 142	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
        //   72: invokestatic 177	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;I)I
        //   75: pop
        //   76: aload_0
        //   77: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   80: aload_1
        //   81: invokeinterface 171 1 0
        //   86: invokestatic 180	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Ljava/lang/String;)Ljava/lang/String;
        //   89: pop
        //   90: aload_0
        //   91: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   94: aload_0
        //   95: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   98: invokestatic 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   101: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   104: aload_0
        //   105: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   108: aload_0
        //   109: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   112: invokevirtual 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:dwD	()Landroid/text/Spannable;
        //   115: invokestatic 183	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Landroid/text/Spannable;)Landroid/text/Spannable;
        //   118: pop
        //   119: sipush 30478
        //   122: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   125: aload_0
        //   126: monitorexit
        //   127: return
        //   128: aload_0
        //   129: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   132: invokestatic 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   135: astore 5
        //   137: goto -115 -> 22
        //   140: astore_1
        //   141: aload_0
        //   142: monitorexit
        //   143: aload_1
        //   144: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	145	0	this	2
        //   0	145	1	paramAnonymousCharSequence	CharSequence
        //   0	145	2	paramAnonymousInt1	int
        //   0	145	3	paramAnonymousInt2	int
        //   0	145	4	paramAnonymousInt3	int
        //   20	116	5	str	String
        // Exception table:
        //   from	to	target	type
        //   2	18	140	finally
        //   22	119	140	finally
        //   119	125	140	finally
        //   128	137	140	finally
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        try
        {
          AppMethodBeat.i(30479);
          WXRTEditText.e(WXRTEditText.this);
          AppMethodBeat.o(30479);
          return;
        }
        finally
        {
          paramAnonymousCharSequence = finally;
          throw paramAnonymousCharSequence;
        }
      }
    };
    this.xAf = 0;
    init();
    AppMethodBeat.o(30482);
  }
  
  public WXRTEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(30483);
    this.xzz = -1;
    this.xzA = -1;
    this.xzB = false;
    this.xzG = "";
    this.xzI = 0;
    this.XBg = null;
    this.mI = 0;
    this.xyj = false;
    this.xzQ = false;
    this.xzT = false;
    this.xyl = 0;
    this.xzU = false;
    this.xzV = -1;
    this.xzW = null;
    this.eln = null;
    this.XBi = null;
    this.xzY = false;
    this.xzZ = null;
    this.xAa = -1;
    this.xAb = -1;
    this.xAc = -1;
    this.xAd = false;
    this.xAe = new TextWatcher()
    {
      /* Error */
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: sipush 30480
        //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: ldc 28
        //   10: ldc 29
        //   12: invokestatic 35	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   15: aload_1
        //   16: invokevirtual 39	java/lang/Object:toString	()Ljava/lang/String;
        //   19: astore_3
        //   20: aload_0
        //   21: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   24: getfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   27: ifnonnull +348 -> 375
        //   30: ldc 45
        //   32: astore_1
        //   33: aload_0
        //   34: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   37: invokestatic 49	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:f	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
        //   40: ifeq +12 -> 52
        //   43: aload_0
        //   44: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   47: ldc 45
        //   49: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   52: aload_0
        //   53: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   56: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   59: ifne +165 -> 224
        //   62: aload_0
        //   63: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   66: invokevirtual 56	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/e;
        //   69: getfield 62	com/tencent/mm/plugin/wenote/model/nativenote/manager/e:uG	I
        //   72: aload_0
        //   73: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   76: invokevirtual 56	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/e;
        //   79: getfield 65	com/tencent/mm/plugin/wenote/model/nativenote/manager/e:uH	I
        //   82: if_icmpne +142 -> 224
        //   85: aload_1
        //   86: ldc 67
        //   88: invokevirtual 73	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   91: ifne +29 -> 120
        //   94: new 75	java/lang/StringBuilder
        //   97: dup
        //   98: invokespecial 76	java/lang/StringBuilder:<init>	()V
        //   101: aload_1
        //   102: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: ldc 67
        //   107: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   113: aload_3
        //   114: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   117: ifne +29 -> 146
        //   120: aload_1
        //   121: ldc 67
        //   123: invokevirtual 73	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   126: ifeq +98 -> 224
        //   129: aload_1
        //   130: ldc 87
        //   132: invokevirtual 73	java/lang/String:endsWith	(Ljava/lang/String;)Z
        //   135: ifne +89 -> 224
        //   138: aload_1
        //   139: aload_3
        //   140: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   143: ifeq +81 -> 224
        //   146: aload_0
        //   147: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   150: invokevirtual 91	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
        //   153: aload_1
        //   154: invokevirtual 95	java/lang/String:length	()I
        //   157: aload_1
        //   158: invokevirtual 95	java/lang/String:length	()I
        //   161: ldc 97
        //   163: invokeinterface 103 4 0
        //   168: checkcast 105	[Landroid/text/style/ParagraphStyle;
        //   171: arraylength
        //   172: ifle +52 -> 224
        //   175: aload_0
        //   176: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   179: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   182: istore_2
        //   183: aload_0
        //   184: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   187: iconst_1
        //   188: invokestatic 112	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Z)Z
        //   191: pop
        //   192: aload_0
        //   193: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   196: invokevirtual 91	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
        //   199: ldc 67
        //   201: invokeinterface 115 2 0
        //   206: pop
        //   207: aload_0
        //   208: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   211: iconst_0
        //   212: invokestatic 112	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Z)Z
        //   215: pop
        //   216: aload_0
        //   217: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   220: iload_2
        //   221: invokevirtual 118	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:setSelection	(I)V
        //   224: aload_0
        //   225: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   228: invokestatic 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
        //   231: ifnull +105 -> 336
        //   234: aload_0
        //   235: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   238: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   241: ifne +95 -> 336
        //   244: aload_1
        //   245: aload_3
        //   246: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   249: ifne +87 -> 336
        //   252: aload_0
        //   253: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   256: invokevirtual 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:dwD	()Landroid/text/Spannable;
        //   259: astore_1
        //   260: aload_0
        //   261: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   264: aload_3
        //   265: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   268: aload_0
        //   269: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   272: invokestatic 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
        //   275: astore_3
        //   276: aload_0
        //   277: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   280: invokestatic 130	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:h	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   283: astore 4
        //   285: aload_0
        //   286: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   289: invokestatic 133	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:i	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Landroid/text/Spannable;
        //   292: astore 5
        //   294: aload_0
        //   295: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   298: invokestatic 136	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:j	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
        //   301: pop
        //   302: aload_0
        //   303: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   306: invokestatic 139	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:k	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
        //   309: pop
        //   310: aload_0
        //   311: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   314: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   317: pop
        //   318: aload_3
        //   319: aload 4
        //   321: aload 5
        //   323: aload_1
        //   324: aload_0
        //   325: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   328: invokevirtual 142	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
        //   331: invokeinterface 147 5 0
        //   336: aload_0
        //   337: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   340: invokestatic 150	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:e	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   343: pop
        //   344: aload_0
        //   345: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   348: invokestatic 153	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:l	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   351: pop
        //   352: aload_0
        //   353: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   356: invokestatic 156	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:m	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)V
        //   359: aload_0
        //   360: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   363: invokestatic 159	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:n	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)V
        //   366: sipush 30480
        //   369: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   372: aload_0
        //   373: monitorexit
        //   374: return
        //   375: aload_0
        //   376: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   379: getfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   382: astore_1
        //   383: goto -350 -> 33
        //   386: astore_1
        //   387: aload_0
        //   388: monitorexit
        //   389: aload_1
        //   390: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	391	0	this	2
        //   0	391	1	paramAnonymousEditable	Editable
        //   182	39	2	i	int
        //   19	300	3	localObject	Object
        //   283	37	4	localWXRTEditText	WXRTEditText
        //   292	30	5	localSpannable	Spannable
        // Exception table:
        //   from	to	target	type
        //   2	30	386	finally
        //   33	52	386	finally
        //   52	120	386	finally
        //   120	146	386	finally
        //   146	224	386	finally
        //   224	336	386	finally
        //   336	372	386	finally
        //   375	383	386	finally
      }
      
      /* Error */
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: sipush 30478
        //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   8: aload_0
        //   9: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   12: invokestatic 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   15: ifnonnull +113 -> 128
        //   18: ldc 45
        //   20: astore 5
        //   22: aload_0
        //   23: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   26: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
        //   29: ifne +90 -> 119
        //   32: aload_1
        //   33: invokeinterface 171 1 0
        //   38: aload 5
        //   40: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   43: ifne +76 -> 119
        //   46: aload_0
        //   47: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   50: aload_0
        //   51: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   54: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
        //   57: invokestatic 174	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;I)I
        //   60: pop
        //   61: aload_0
        //   62: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   65: aload_0
        //   66: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   69: invokevirtual 142	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
        //   72: invokestatic 177	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;I)I
        //   75: pop
        //   76: aload_0
        //   77: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   80: aload_1
        //   81: invokeinterface 171 1 0
        //   86: invokestatic 180	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Ljava/lang/String;)Ljava/lang/String;
        //   89: pop
        //   90: aload_0
        //   91: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   94: aload_0
        //   95: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   98: invokestatic 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   101: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xzG	Ljava/lang/String;
        //   104: aload_0
        //   105: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   108: aload_0
        //   109: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   112: invokevirtual 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:dwD	()Landroid/text/Spannable;
        //   115: invokestatic 183	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Landroid/text/Spannable;)Landroid/text/Spannable;
        //   118: pop
        //   119: sipush 30478
        //   122: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   125: aload_0
        //   126: monitorexit
        //   127: return
        //   128: aload_0
        //   129: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:XBj	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
        //   132: invokestatic 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
        //   135: astore 5
        //   137: goto -115 -> 22
        //   140: astore_1
        //   141: aload_0
        //   142: monitorexit
        //   143: aload_1
        //   144: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	145	0	this	2
        //   0	145	1	paramAnonymousCharSequence	CharSequence
        //   0	145	2	paramAnonymousInt1	int
        //   0	145	3	paramAnonymousInt2	int
        //   0	145	4	paramAnonymousInt3	int
        //   20	116	5	str	String
        // Exception table:
        //   from	to	target	type
        //   2	18	140	finally
        //   22	119	140	finally
        //   119	125	140	finally
        //   128	137	140	finally
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        try
        {
          AppMethodBeat.i(30479);
          WXRTEditText.e(WXRTEditText.this);
          AppMethodBeat.o(30479);
          return;
        }
        finally
        {
          paramAnonymousCharSequence = finally;
          throw paramAnonymousCharSequence;
        }
      }
    };
    this.xAf = 0;
    init();
    AppMethodBeat.o(30483);
  }
  
  private void b(Spannable paramSpannable)
  {
    AppMethodBeat.i(30500);
    int i = getSelectionStart();
    setSpannableText(com.tencent.mm.smiley.u.iVt().a(getContext(), paramSpannable, getTextSize()));
    int j = getText().length() - paramSpannable.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(30500);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(30500);
  }
  
  private void dwI()
  {
    AppMethodBeat.i(30505);
    Editable localEditable = getText();
    if (localEditable.getSpans(0, localEditable.length(), getClass()) != null) {
      localEditable.setSpan(this, 0, localEditable.length(), 18);
    }
    AppMethodBeat.o(30505);
  }
  
  private void dwJ()
  {
    AppMethodBeat.i(30513);
    if (this.eln == null)
    {
      this.eln = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(30481);
          if ((WXRTEditText.o(WXRTEditText.this) != null) && (WXRTEditText.o(WXRTEditText.this).getType() == 1))
          {
            int i = WXRTEditText.o(WXRTEditText.this).xAI;
            WXRTEditText.p(WXRTEditText.this);
            WXRTEditText.this.ay(i, false);
          }
          AppMethodBeat.o(30481);
          return true;
        }
      }, false);
      AppMethodBeat.o(30513);
      return;
    }
    this.eln.stopTimer();
    AppMethodBeat.o(30513);
  }
  
  private void dwK()
  {
    AppMethodBeat.i(30515);
    if (this.XBi == null)
    {
      this.XBi = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
      AppMethodBeat.o(30515);
      return;
    }
    this.XBi.reset();
    AppMethodBeat.o(30515);
  }
  
  private void gN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30516);
    if (this.xzI == 2)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().L(this.xzV, 1, this.xzV, 1);
      AppMethodBeat.o(30516);
      return;
    }
    if (this.xzI == 1)
    {
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().L(this.xzV, 0, this.xzV, 0);
      AppMethodBeat.o(30516);
      return;
    }
    com.tencent.mm.plugin.wenote.model.nativenote.c.e locale = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr();
    int i = this.xzV;
    locale.L(i, paramInt1, i, paramInt2);
    AppMethodBeat.o(30516);
  }
  
  private j getRTLayout()
  {
    AppMethodBeat.i(30508);
    try
    {
      if ((this.XBh == null) || (this.xzR))
      {
        this.XBh = new j(getText());
        this.xzR = false;
      }
      j localj = this.XBh;
      return localj;
    }
    finally
    {
      AppMethodBeat.o(30508);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(30485);
    this.XBg = this;
    removeTextChangedListener(this.xAe);
    addTextChangedListener(this.xAe);
    setMovementMethod(com.tencent.mm.plugin.wenote.model.nativenote.spans.i.iEv());
    this.xzV = -1;
    this.xzW = new Paint(1);
    this.xzW.setColor(1347529272);
    this.XBi = new com.tencent.mm.plugin.wenote.model.nativenote.c.b();
    this.xzZ = new Path();
    this.xAa = -1;
    this.xAb = -1;
    this.xAc = -1;
    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled())
    {
      setHighlightColor(0);
      setCustomSelectionActionModeCallback(new ActionMode.Callback()
      {
        public final boolean onActionItemClicked(ActionMode paramAnonymousActionMode, MenuItem paramAnonymousMenuItem)
        {
          return false;
        }
        
        public final boolean onCreateActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
        {
          return false;
        }
        
        public final void onDestroyActionMode(ActionMode paramAnonymousActionMode) {}
        
        public final boolean onPrepareActionMode(ActionMode paramAnonymousActionMode, Menu paramAnonymousMenu)
        {
          return false;
        }
      });
    }
    AppMethodBeat.o(30485);
  }
  
  private void setParagraphsAreUp2Date(boolean paramBoolean)
  {
    try
    {
      if (!this.xzP) {
        this.xzO = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String a(i parami)
  {
    AppMethodBeat.i(30497);
    if (parami == i.XBl)
    {
      parami = getText().toString();
      AppMethodBeat.o(30497);
      return parami;
    }
    if (parami == i.XBm)
    {
      parami = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
      AppMethodBeat.o(30497);
      return parami;
    }
    AppMethodBeat.o(30497);
    return "";
  }
  
  public final <V, C extends g<V>> void a(t<V, C> paramt, V paramV)
  {
    AppMethodBeat.i(30504);
    if ((!this.xzQ) && (!this.xzN))
    {
      if (this.xzC) {}
      for (Spannable localSpannable = null;; localSpannable = dwD())
      {
        paramt.a(this, paramV);
        try
        {
          if ((this.XBf != null) && (!this.xzC))
          {
            paramt = dwD();
            paramV = this.XBf;
            getSelectionStart();
            getSelectionEnd();
            getSelectionStart();
            paramV.a(this, localSpannable, paramt, getSelectionEnd());
          }
          this.xzR = true;
          return;
        }
        finally
        {
          AppMethodBeat.o(30504);
        }
      }
    }
    AppMethodBeat.o(30504);
  }
  
  public final void ay(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(30514);
    Editable localEditable = getText();
    if (localEditable == null)
    {
      AppMethodBeat.o(30514);
      return;
    }
    Layout localLayout = getLayout();
    if (localLayout == null)
    {
      AppMethodBeat.o(30514);
      return;
    }
    int k = localEditable.length();
    if ((paramInt < 0) || (paramInt > k))
    {
      AppMethodBeat.o(30514);
      return;
    }
    int i;
    if (k == 0)
    {
      paramInt = 0;
      i = 0;
    }
    for (;;)
    {
      if ((i < 0) || (i > k) || (paramInt < 0) || (paramInt > k))
      {
        AppMethodBeat.o(30514);
        return;
        if (paramInt < k)
        {
          if ((paramBoolean) || (localEditable.charAt(paramInt) != '\n'))
          {
            j = localLayout.getOffsetToRightOf(paramInt);
            i = paramInt;
            paramInt = j;
          }
        }
        else if ((paramInt == k) && (paramBoolean)) {
          i = localLayout.getOffsetToLeftOf(paramInt);
        }
      }
      else
      {
        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwR())
        {
          requestFocus();
          setIgnoreSelectChangeByMultiSelect(true);
          setSelection(i, paramInt);
          setIgnoreSelectChangeByMultiSelect(false);
          if (this.XBf != null)
          {
            this.XBf.g(true, 50L);
            this.XBf.JK(1);
          }
        }
        gN(i, paramInt);
        com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().Q(true, true);
        AppMethodBeat.o(30514);
        return;
      }
      i = paramInt;
      int j = paramInt;
      paramInt = i;
      i = j;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(30491);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(30491);
    return bool;
  }
  
  public final void dwC()
  {
    AppMethodBeat.i(30490);
    if (this.XBf != null)
    {
      this.XBf.g(true, 50L);
      this.XBf.JK(1);
    }
    AppMethodBeat.o(30490);
  }
  
  public final Spannable dwD()
  {
    AppMethodBeat.i(30494);
    Object localObject = super.getText();
    if (localObject != null) {}
    for (;;)
    {
      localObject = new a((CharSequence)localObject);
      AppMethodBeat.o(30494);
      return localObject;
      localObject = "";
    }
  }
  
  public final void dwE()
  {
    try
    {
      this.xzC = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dwF()
  {
    try
    {
      this.xzC = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dwG()
  {
    try
    {
      this.xzB = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dwH()
  {
    try
    {
      this.xzB = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public m[] getCurrentEditorCursorNumberSpan()
  {
    AppMethodBeat.i(30510);
    Object localObject = getParagraphsInSelection();
    localObject = (m[])getText().getSpans(((e)localObject).uG, ((e)localObject).uH, m.class);
    AppMethodBeat.o(30510);
    return localObject;
  }
  
  public String getCurrentEditorCursorParagraphStr()
  {
    AppMethodBeat.i(30509);
    Object localObject = getParagraphsInSelection();
    localObject = getText().subSequence(((e)localObject).uG, ((e)localObject).uH).toString().trim();
    AppMethodBeat.o(30509);
    return localObject;
  }
  
  public int getEditTextType()
  {
    return this.xzI;
  }
  
  public ArrayList<n> getParagraphs()
  {
    AppMethodBeat.i(30507);
    ArrayList localArrayList = getRTLayout().xAm;
    AppMethodBeat.o(30507);
    return localArrayList;
  }
  
  public e getParagraphsInSelection()
  {
    int k = 0;
    AppMethodBeat.i(30506);
    Object localObject = getRTLayout();
    e locale = new e(this);
    int j = ((j)localObject).di(locale.uG);
    int i;
    int m;
    if (locale.isEmpty())
    {
      i = locale.uH;
      m = ((j)localObject).di(i);
      if ((((j)localObject).xAl != 0) && (j >= 0)) {
        break label119;
      }
      i = 0;
      label71:
      j = k;
      if (((j)localObject).xAl != 0)
      {
        if (m >= 0) {
          break label174;
        }
        j = k;
      }
    }
    for (;;)
    {
      localObject = new e(i, j);
      AppMethodBeat.o(30506);
      return localObject;
      i = locale.uH - 1;
      break;
      label119:
      if (j < ((j)localObject).xAl)
      {
        i = ((n)((j)localObject).xAm.get(j)).uG;
        break label71;
      }
      i = ((n)((j)localObject).xAm.get(((j)localObject).xAl - 1)).uH - 1;
      break label71;
      label174:
      if (m < ((j)localObject).xAl) {
        j = ((n)((j)localObject).xAm.get(m)).uH;
      } else {
        j = ((n)((j)localObject).xAm.get(((j)localObject).xAl - 1)).uH - 1;
      }
    }
  }
  
  public int getPosInDataList()
  {
    return this.xzV;
  }
  
  public int getRecyclerItemPosition()
  {
    AppMethodBeat.i(30498);
    if (this.xzK.KI() == -1)
    {
      AppMethodBeat.o(30498);
      return 0;
    }
    int i = this.xzK.KI();
    AppMethodBeat.o(30498);
    return i;
  }
  
  public String getSelectedText()
  {
    AppMethodBeat.i(30495);
    Object localObject = getText();
    e locale = getSelection();
    if ((locale.uG >= 0) && (locale.uH >= 0) && (locale.uH <= ((Spannable)localObject).length()))
    {
      localObject = ((Spannable)localObject).subSequence(locale.uG, locale.uH).toString();
      AppMethodBeat.o(30495);
      return localObject;
    }
    AppMethodBeat.o(30495);
    return null;
  }
  
  public e getSelection()
  {
    AppMethodBeat.i(30496);
    e locale = new e(getSelectionStart(), getSelectionEnd());
    AppMethodBeat.o(30496);
    return locale;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(30511);
    Object localObject;
    d locald;
    int j;
    int m;
    int k;
    int i;
    if ((com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled()) && (this.xzI == 0))
    {
      localObject = getText();
      if (localObject != null)
      {
        locald = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().iEs();
        if (locald != null)
        {
          j = -1;
          m = 0;
          switch (com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().JQ(this.xzV))
          {
          default: 
            k = 0;
            i = 0;
            if ((j >= 0) && (i <= ((Editable)localObject).length()) && (j <= i)) {
              break;
            }
          }
        }
      }
    }
    do
    {
      do
      {
        super.onDraw(paramCanvas);
        AppMethodBeat.o(30511);
        return;
      } while (locald.oHY == locald.xAR);
      j = locald.oHY;
      i = locald.xAR;
      k = 0;
      break;
      j = 0;
      i = ((Editable)localObject).length();
      m = 1;
      k = 1;
      break;
      j = locald.oHY;
      i = ((Editable)localObject).length();
      m = 1;
      k = 0;
      break;
      j = 0;
      i = locald.xAR;
      k = 1;
      break;
      localObject = getLayout();
    } while (localObject == null);
    if (this.xAa == -1) {
      this.xAa = getPaddingLeft();
    }
    if (this.xAb == -1) {
      this.xAb = getPaddingTop();
    }
    if (this.xAc == -1) {
      this.xAc = getPaddingBottom();
    }
    if (this.xzZ == null) {
      this.xzZ = new Path();
    }
    this.xzZ.reset();
    label548:
    label836:
    for (;;)
    {
      int n;
      int i1;
      int i2;
      float f1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      try
      {
        n = ((Layout)localObject).getLineForOffset(j);
        i1 = ((Layout)localObject).getLineForOffset(i);
        if (n > i1) {
          break;
        }
        i2 = ((Layout)localObject).getWidth();
        f1 = ((Layout)localObject).getPrimaryHorizontal(j) + this.xAa;
        f2 = ((Layout)localObject).getLineTop(n) + this.xAb;
        f3 = ((Layout)localObject).getLineBottom(n) + this.xAb;
        f4 = ((Layout)localObject).getPrimaryHorizontal(i) + this.xAa;
        f5 = ((Layout)localObject).getLineTop(i1) + this.xAb;
        f6 = ((Layout)localObject).getLineBottom(i1) + this.xAb;
        if ((k == 0) || (m == 0)) {
          break label548;
        }
        this.xzZ.addRect(this.xAa, 0.0F, this.xAa + i2, f6 + this.xAc, Path.Direction.CW);
        if (this.xzZ.isEmpty()) {
          break;
        }
        if (this.xzW == null)
        {
          this.xzW = new Paint(1);
          this.xzW.setColor(1347529272);
        }
        paramCanvas.drawPath(this.xzZ, this.xzW);
      }
      catch (Exception localException)
      {
        Log.e("noteeditor.WXRTEditText", "tryDrawCover: ", new Object[] { localException });
      }
      break;
      if (n == i1)
      {
        if (k != 0) {
          this.xzZ.addRect(this.xAa, 0.0F, f4, f6, Path.Direction.CW);
        } else if (m != 0) {
          this.xzZ.addRect(f1, f2, this.xAa + i2, f6 + this.xAc, Path.Direction.CW);
        } else {
          this.xzZ.addRect(f1, f2, f4, f6, Path.Direction.CW);
        }
      }
      else
      {
        if (k != 0)
        {
          this.xzZ.addRect(this.xAa, 0.0F, this.xAa + i2, f3, Path.Direction.CW);
          this.xzZ.addRect(this.xAa, f5, f4, f6, Path.Direction.CW);
        }
        for (;;)
        {
          if (i1 - n <= 1) {
            break label836;
          }
          this.xzZ.addRect(this.xAa, f3, this.xAa + i2, f5, Path.Direction.CW);
          break;
          if (m != 0)
          {
            this.xzZ.addRect(f1, f2, this.xAa + i2, f3, Path.Direction.CW);
            this.xzZ.addRect(this.xAa, f5, this.xAa + i2, f6 + this.xAc, Path.Direction.CW);
          }
          else
          {
            this.xzZ.addRect(f1, f2, this.xAa + i2, f3, Path.Direction.CW);
            this.xzZ.addRect(this.xAa, f5, f4, f6, Path.Direction.CW);
          }
        }
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(30492);
    this.xAd = false;
    this.xzz = -1;
    this.xzA = -1;
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (this.XBf != null) {
      this.XBf.a(this, paramBoolean, getRecyclerItemPosition());
    }
    if ((paramBoolean) && (!this.xAd)) {
      onSelectionChanged(getSelectionStart(), getSelectionEnd());
    }
    AppMethodBeat.o(30492);
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30493);
    try
    {
      if (this.xzB) {
        return;
      }
      this.xAd = true;
      if (paramInt1 < 0)
      {
        AppMethodBeat.o(30493);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(30493);
    }
    if ((this.xzz != paramInt1) || (this.xzA != paramInt2))
    {
      this.xzz = paramInt1;
      this.xzA = paramInt2;
      super.onSelectionChanged(paramInt1, paramInt2);
      if (paramInt2 <= paramInt1) {
        break label247;
      }
    }
    label247:
    for (boolean bool = true;; bool = false)
    {
      this.xzM = bool;
      if ((!this.xzN) && (!this.xzO))
      {
        this.xzP = true;
        com.tencent.mm.plugin.wenote.model.nativenote.spans.u.a(this, new t[0]);
        this.xzP = false;
        setParagraphsAreUp2Date(true);
      }
      if (this.XBf != null)
      {
        this.xzQ = true;
        this.XBf.a(this, paramInt1, paramInt2);
        this.xzQ = false;
      }
      if ((com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled()) && (!this.xzY) && (hasFocus()) && (this.xzV >= 0))
      {
        gN(paramInt1, paramInt2);
        if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().JQ(this.xzV) == 1)
        {
          com.tencent.mm.plugin.wenote.model.nativenote.c.e locale = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr();
          if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit)
          {
            locale.h(true, 0L);
            locale.dxa();
            locale.dwY();
          }
        }
      }
      AppMethodBeat.o(30493);
      return;
    }
  }
  
  public void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30501);
    this.xzL = true;
    if (((paramObject instanceof g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(30501);
  }
  
  public void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(30503);
    this.xzL = true;
    if (((paramObject instanceof g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(30503);
  }
  
  public void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30502);
    this.xzL = true;
    if (((paramObject instanceof g)) && ((paramObject instanceof ParagraphStyle))) {
      setParagraphsAreUp2Date(false);
    }
    AppMethodBeat.o(30502);
  }
  
  /* Error */
  public boolean onTextContextMenuItem(int paramInt)
  {
    // Byte code:
    //   0: sipush 30499
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: ldc_w 629
    //   10: if_icmpne +20 -> 30
    //   13: aload_0
    //   14: getfield 240	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:XBf	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   17: invokeinterface 632 1 0
    //   22: sipush 30499
    //   25: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_1
    //   29: ireturn
    //   30: iload_1
    //   31: ldc_w 633
    //   34: if_icmpeq +10 -> 44
    //   37: iload_1
    //   38: ldc_w 634
    //   41: if_icmpne +91 -> 132
    //   44: invokestatic 639	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:clearData	()V
    //   47: aload_0
    //   48: iload_1
    //   49: invokespecial 641	com/tencent/mm/ui/widget/edittext/PasterEditText:onTextContextMenuItem	(I)Z
    //   52: istore_3
    //   53: iload_1
    //   54: ldc_w 642
    //   57: if_icmpne +20 -> 77
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xAf	I
    //   65: aload_0
    //   66: invokevirtual 183	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
    //   69: astore 4
    //   71: aload_0
    //   72: aload 4
    //   74: invokespecial 644	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Landroid/text/Spannable;)V
    //   77: iload_1
    //   78: ldc_w 642
    //   81: if_icmpne +43 -> 124
    //   84: aload_0
    //   85: getfield 91	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xyj	Z
    //   88: ifeq +36 -> 124
    //   91: aload_0
    //   92: getfield 240	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:XBf	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   95: ifnull +24 -> 119
    //   98: aload_0
    //   99: getfield 240	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:XBf	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   102: iconst_0
    //   103: lconst_0
    //   104: invokeinterface 401 4 0
    //   109: aload_0
    //   110: getfield 240	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:XBf	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   113: iconst_0
    //   114: invokeinterface 404 2 0
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield 91	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xyj	Z
    //   124: sipush 30499
    //   127: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iload_3
    //   131: ireturn
    //   132: iload_1
    //   133: ldc_w 642
    //   136: if_icmpne -89 -> 47
    //   139: aload_0
    //   140: invokevirtual 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getContext	()Landroid/content/Context;
    //   143: pop
    //   144: invokestatic 647	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:dwl	()I
    //   147: istore_2
    //   148: iload_2
    //   149: iconst_2
    //   150: if_icmpne +9 -> 159
    //   153: invokestatic 639	com/tencent/mm/plugin/wenote/model/nativenote/manager/f:clearData	()V
    //   156: goto -109 -> 47
    //   159: iload_2
    //   160: iconst_3
    //   161: if_icmpne -114 -> 47
    //   164: aload_0
    //   165: getfield 240	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:XBf	Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   168: aload_0
    //   169: invokeinterface 649 2 0
    //   174: sipush 30499
    //   177: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: iconst_1
    //   181: ireturn
    //   182: astore 4
    //   184: ldc_w 569
    //   187: ldc_w 651
    //   190: iconst_1
    //   191: anewarray 201	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload 4
    //   198: aastore
    //   199: invokestatic 576	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: sipush 30499
    //   205: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: astore 5
    //   212: ldc_w 569
    //   215: ldc_w 653
    //   218: iconst_1
    //   219: anewarray 201	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_0
    //   225: getfield 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xAf	I
    //   228: invokestatic 659	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: invokestatic 576	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload_0
    //   236: getfield 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xAf	I
    //   239: iconst_3
    //   240: if_icmpge +45 -> 285
    //   243: aload_0
    //   244: aload_0
    //   245: getfield 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xAf	I
    //   248: iconst_1
    //   249: iadd
    //   250: putfield 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:xAf	I
    //   253: aload_0
    //   254: new 661	android/text/SpannableStringBuilder
    //   257: dup
    //   258: iconst_2
    //   259: anewarray 451	java/lang/CharSequence
    //   262: dup
    //   263: iconst_0
    //   264: ldc_w 663
    //   267: aastore
    //   268: dup
    //   269: iconst_1
    //   270: aload 4
    //   272: aastore
    //   273: invokestatic 669	android/text/TextUtils:concat	([Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   276: invokespecial 670	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   279: invokespecial 644	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Landroid/text/Spannable;)V
    //   282: goto -205 -> 77
    //   285: sipush 30499
    //   288: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload 5
    //   293: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	WXRTEditText
    //   0	294	1	paramInt	int
    //   147	15	2	i	int
    //   52	79	3	bool	boolean
    //   69	4	4	localEditable	Editable
    //   182	89	4	localNullPointerException	java.lang.NullPointerException
    //   210	82	5	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    // Exception table:
    //   from	to	target	type
    //   47	53	182	java/lang/NullPointerException
    //   71	77	210	java/lang/IndexOutOfBoundsException
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(30512);
    Object localObject1;
    int i;
    label391:
    boolean bool1;
    if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled())
    {
      localObject1 = getText();
      if (localObject1 == null)
      {
        dwK();
        AppMethodBeat.o(30512);
        return true;
      }
      int j = ((Editable)localObject1).length();
      i = getOffsetForPosition(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((j < 0) || (i < 0) || (i > j))
      {
        dwK();
        AppMethodBeat.o(30512);
        return true;
      }
      switch (paramMotionEvent.getAction())
      {
      }
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(30512);
            return true;
            j = (int)paramMotionEvent.getX();
            int k = (int)paramMotionEvent.getY();
            Object localObject2 = getLayout();
            k = ((Layout)localObject2).getOffsetForHorizontal(((Layout)localObject2).getLineForVertical(k), j);
            localObject2 = (k[])getText().getSpans(k, k + 1, k.class);
            if ((com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwR()) && (j < b.dwB()) && (localObject2.length != 0))
            {
              Log.i("noteeditor.WXRTEditText", "clicked todo");
              this.XBf.iEe();
              localObject2[0].a(this, (Spannable)localObject1, paramMotionEvent, localObject2[0]);
            }
            else
            {
              dwK();
              this.XBi.a(1, paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), paramMotionEvent.getX(), paramMotionEvent.getY(), i);
              dwJ();
              this.eln.startTimer(500L, 0L);
              continue;
              dwK();
              dwJ();
            }
          }
          dwJ();
        } while (this.XBi == null);
        localObject1 = this.XBi;
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        float f3 = paramMotionEvent.getX();
        float f4 = paramMotionEvent.getY();
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).xAJ = f1;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).xAK = f2;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).xAL = f3;
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).xAM = f4;
        if (((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).viewType != 1) {
          break;
        }
        ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).xAN = i;
        j = this.XBi.getType();
        dwK();
      } while (j != 2);
      if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwR()) {
        if (hasFocus())
        {
          if ((getSelectionStart() != getSelectionEnd()) || (i != getSelectionStart())) {
            break label707;
          }
          bool1 = true;
          bool2 = true;
        }
      }
    }
    for (;;)
    {
      setIgnoreSelectChangeByMultiSelect(true);
      setSelection(i);
      setIgnoreSelectChangeByMultiSelect(false);
      if (this.XBf != null)
      {
        this.XBf.g(true, 50L);
        this.XBf.JK(1);
      }
      gN(i, i);
      com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().Q(bool2, bool1);
      break;
      ((com.tencent.mm.plugin.wenote.model.nativenote.c.b)localObject1).xAN = 0;
      break label391;
      requestFocus();
      bool1 = false;
      bool2 = false;
      continue;
      paramMotionEvent = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().iEs();
      bool1 = bool2;
      if (com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr().dwZ())
      {
        bool1 = bool2;
        if (paramMotionEvent.getSelectType() == 1)
        {
          bool1 = bool2;
          if (paramMotionEvent.dIY == this.xzV)
          {
            bool1 = bool2;
            if (paramMotionEvent.oHY == i) {
              bool1 = true;
            }
          }
        }
      }
      gN(i, i);
      paramMotionEvent = com.tencent.mm.plugin.wenote.model.nativenote.c.e.iEr();
      if (!com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit) {
        break;
      }
      paramMotionEvent.dxa();
      paramMotionEvent.dwY();
      paramMotionEvent.h(true, 50L);
      paramMotionEvent.nV(true);
      paramMotionEvent.nU(bool1);
      break;
      if ((paramMotionEvent.getAction() == 1) && (this.XBf != null))
      {
        this.XBf.g(true, 300L);
        this.XBf.JK(1);
      }
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(30512);
      return bool1;
      label707:
      bool1 = false;
      bool2 = true;
    }
  }
  
  public void setEditTextType(int paramInt)
  {
    this.xzI = paramInt;
  }
  
  public void setIgnoreSelectChangeByMultiSelect(boolean paramBoolean)
  {
    this.xzY = paramBoolean;
  }
  
  public void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(30484);
    super.setMaxHeight(paramInt);
    AppMethodBeat.o(30484);
  }
  
  public void setPosInDataList(int paramInt)
  {
    this.xzV = paramInt;
  }
  
  public void setRichTextEditing(String paramString)
  {
    AppMethodBeat.i(30486);
    dwE();
    if (!Util.isNullOrNil(paramString)) {
      setSpannableText(com.tencent.mm.plugin.wenote.model.nativenote.a.a.anA(paramString));
    }
    for (;;)
    {
      dwF();
      AppMethodBeat.o(30486);
      return;
      setText("");
    }
  }
  
  public void setSpannableText(Spanned paramSpanned)
  {
    AppMethodBeat.i(30487);
    dwE();
    dwG();
    super.setText(paramSpanned, TextView.BufferType.EDITABLE);
    dwH();
    dwI();
    com.tencent.mm.plugin.wenote.model.nativenote.spans.u.a(this, new t[0]);
    dwF();
    setContentDescription(com.tencent.mm.plugin.wenote.c.c.l(a(i.XBm), getContext()));
    AppMethodBeat.o(30487);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(30488);
    dwE();
    super.setText(paramString);
    dwF();
    setContentDescription(com.tencent.mm.plugin.wenote.c.c.l(a(i.XBm), getContext()));
    AppMethodBeat.o(30488);
  }
  
  public void setTextWithoutIgnore(String paramString)
  {
    AppMethodBeat.i(30489);
    super.setText(paramString);
    AppMethodBeat.o(30489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText
 * JD-Core Version:    0.7.0.1
 */