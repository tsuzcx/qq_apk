package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WXRTEditText$2
  implements TextWatcher
{
  WXRTEditText$2(WXRTEditText paramWXRTEditText) {}
  
  /* Error */
  public final void afterTextChanged(android.text.Editable paramEditable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 26787
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 28
    //   10: ldc 29
    //   12: invokestatic 35	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 39	java/lang/Object:toString	()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   24: getfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyR	Ljava/lang/String;
    //   27: ifnonnull +348 -> 375
    //   30: ldc 45
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   37: invokestatic 49	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:f	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
    //   40: ifeq +12 -> 52
    //   43: aload_0
    //   44: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   47: ldc 45
    //   49: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyR	Ljava/lang/String;
    //   52: aload_0
    //   53: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   56: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   59: ifne +165 -> 224
    //   62: aload_0
    //   63: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   66: invokevirtual 56	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/e;
    //   69: getfield 62	com/tencent/mm/plugin/wenote/model/nativenote/manager/e:akX	I
    //   72: aload_0
    //   73: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   76: invokevirtual 56	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/e;
    //   79: getfield 65	com/tencent/mm/plugin/wenote/model/nativenote/manager/e:Fe	I
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
    //   147: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
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
    //   176: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   179: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
    //   182: istore_2
    //   183: aload_0
    //   184: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   187: iconst_1
    //   188: invokestatic 112	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Z)Z
    //   191: pop
    //   192: aload_0
    //   193: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   196: invokevirtual 91	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
    //   199: ldc 67
    //   201: invokeinterface 115 2 0
    //   206: pop
    //   207: aload_0
    //   208: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   211: iconst_0
    //   212: invokestatic 112	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Z)Z
    //   215: pop
    //   216: aload_0
    //   217: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   220: iload_2
    //   221: invokevirtual 118	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:setSelection	(I)V
    //   224: aload_0
    //   225: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   228: invokestatic 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   231: ifnull +105 -> 336
    //   234: aload_0
    //   235: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   238: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   241: ifne +95 -> 336
    //   244: aload_1
    //   245: aload_3
    //   246: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifne +87 -> 336
    //   252: aload_0
    //   253: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   256: invokevirtual 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:diL	()Landroid/text/Spannable;
    //   259: astore_1
    //   260: aload_0
    //   261: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   264: aload_3
    //   265: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyR	Ljava/lang/String;
    //   268: aload_0
    //   269: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   272: invokestatic 122	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   275: astore_3
    //   276: aload_0
    //   277: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   280: invokestatic 130	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:h	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   283: astore 4
    //   285: aload_0
    //   286: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   289: invokestatic 133	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:i	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Landroid/text/Spannable;
    //   292: astore 5
    //   294: aload_0
    //   295: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   298: invokestatic 136	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:j	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
    //   301: pop
    //   302: aload_0
    //   303: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   306: invokestatic 139	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:k	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
    //   309: pop
    //   310: aload_0
    //   311: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   314: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
    //   317: pop
    //   318: aload_3
    //   319: aload 4
    //   321: aload 5
    //   323: aload_1
    //   324: aload_0
    //   325: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   328: invokevirtual 142	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
    //   331: invokeinterface 147 5 0
    //   336: aload_0
    //   337: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   340: invokestatic 150	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:e	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   343: pop
    //   344: aload_0
    //   345: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   348: invokestatic 153	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:l	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   351: pop
    //   352: aload_0
    //   353: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   356: invokestatic 156	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:m	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)V
    //   359: aload_0
    //   360: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   363: invokestatic 159	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:n	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)V
    //   366: sipush 26787
    //   369: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_0
    //   373: monitorexit
    //   374: return
    //   375: aload_0
    //   376: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   379: getfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyR	Ljava/lang/String;
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
    //   0	391	1	paramEditable	android.text.Editable
    //   182	39	2	i	int
    //   19	300	3	localObject	Object
    //   283	37	4	localWXRTEditText	WXRTEditText
    //   292	30	5	localSpannable	android.text.Spannable
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
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 26785
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   12: invokestatic 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
    //   15: ifnonnull +113 -> 128
    //   18: ldc 45
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   26: invokestatic 52	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   29: ifne +90 -> 119
    //   32: aload_1
    //   33: invokeinterface 171 1 0
    //   38: aload 5
    //   40: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifne +76 -> 119
    //   46: aload_0
    //   47: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   50: aload_0
    //   51: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   54: invokevirtual 108	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
    //   57: invokestatic 174	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;I)I
    //   60: pop
    //   61: aload_0
    //   62: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   65: aload_0
    //   66: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   69: invokevirtual 142	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
    //   72: invokestatic 177	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;I)I
    //   75: pop
    //   76: aload_0
    //   77: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   80: aload_1
    //   81: invokeinterface 171 1 0
    //   86: invokestatic 180	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: aload_0
    //   91: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   94: aload_0
    //   95: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   98: invokestatic 168	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
    //   101: putfield 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:vyR	Ljava/lang/String;
    //   104: aload_0
    //   105: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   108: aload_0
    //   109: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   112: invokevirtual 126	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:diL	()Landroid/text/Spannable;
    //   115: invokestatic 183	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Landroid/text/Spannable;)Landroid/text/Spannable;
    //   118: pop
    //   119: sipush 26785
    //   122: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: aload_0
    //   129: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:vzr	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
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
    //   0	145	1	paramCharSequence	CharSequence
    //   0	145	2	paramInt1	int
    //   0	145	3	paramInt2	int
    //   0	145	4	paramInt3	int
    //   20	116	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	18	140	finally
    //   22	119	140	finally
    //   119	125	140	finally
    //   128	137	140	finally
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      AppMethodBeat.i(26786);
      WXRTEditText.e(this.vzr);
      AppMethodBeat.o(26786);
      return;
    }
    finally
    {
      paramCharSequence = finally;
      throw paramCharSequence;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.2
 * JD-Core Version:    0.7.0.1
 */