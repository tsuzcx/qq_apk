package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.TextWatcher;

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
    //   2: ldc 22
    //   4: ldc 23
    //   6: invokestatic 29	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: invokevirtual 33	java/lang/Object:toString	()Ljava/lang/String;
    //   13: astore_3
    //   14: aload_0
    //   15: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   18: getfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIl	Ljava/lang/String;
    //   21: ifnonnull +326 -> 347
    //   24: ldc 39
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   31: invokestatic 43	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:f	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)I
    //   34: ifeq +12 -> 46
    //   37: aload_0
    //   38: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   41: ldc 39
    //   43: putfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIl	Ljava/lang/String;
    //   46: aload_0
    //   47: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   50: invokestatic 46	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   53: ifne +165 -> 218
    //   56: aload_0
    //   57: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   60: invokevirtual 50	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/e;
    //   63: getfield 56	com/tencent/mm/plugin/wenote/model/nativenote/manager/e:aiH	I
    //   66: aload_0
    //   67: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   70: invokevirtual 50	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelection	()Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/e;
    //   73: getfield 59	com/tencent/mm/plugin/wenote/model/nativenote/manager/e:Eo	I
    //   76: if_icmpne +142 -> 218
    //   79: aload_1
    //   80: ldc 61
    //   82: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   85: ifne +29 -> 114
    //   88: new 69	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   95: aload_1
    //   96: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 61
    //   101: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: aload_3
    //   108: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: ifne +29 -> 140
    //   114: aload_1
    //   115: ldc 61
    //   117: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   120: ifeq +98 -> 218
    //   123: aload_1
    //   124: ldc 81
    //   126: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   129: ifne +89 -> 218
    //   132: aload_1
    //   133: aload_3
    //   134: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifeq +81 -> 218
    //   140: aload_0
    //   141: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   144: invokevirtual 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
    //   147: aload_1
    //   148: invokevirtual 89	java/lang/String:length	()I
    //   151: aload_1
    //   152: invokevirtual 89	java/lang/String:length	()I
    //   155: ldc 91
    //   157: invokeinterface 97 4 0
    //   162: checkcast 99	[Landroid/text/style/ParagraphStyle;
    //   165: arraylength
    //   166: ifle +52 -> 218
    //   169: aload_0
    //   170: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   173: invokevirtual 102	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
    //   176: istore_2
    //   177: aload_0
    //   178: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   181: iconst_1
    //   182: invokestatic 106	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Z)Z
    //   185: pop
    //   186: aload_0
    //   187: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   190: invokevirtual 85	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getText	()Landroid/text/Editable;
    //   193: ldc 61
    //   195: invokeinterface 109 2 0
    //   200: pop
    //   201: aload_0
    //   202: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   205: iconst_0
    //   206: invokestatic 106	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Z)Z
    //   209: pop
    //   210: aload_0
    //   211: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   214: iload_2
    //   215: invokevirtual 113	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:setSelection	(I)V
    //   218: aload_0
    //   219: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   222: invokestatic 117	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   225: ifnull +89 -> 314
    //   228: aload_0
    //   229: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   232: invokestatic 46	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   235: ifne +79 -> 314
    //   238: aload_1
    //   239: aload_3
    //   240: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   243: ifne +71 -> 314
    //   246: aload_0
    //   247: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   250: invokevirtual 121	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:ciu	()Landroid/text/Spannable;
    //   253: astore_1
    //   254: aload_0
    //   255: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   258: aload_3
    //   259: putfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIl	Ljava/lang/String;
    //   262: aload_0
    //   263: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   266: invokestatic 117	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:g	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/b/c;
    //   269: astore_3
    //   270: aload_0
    //   271: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   274: invokestatic 125	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:h	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   277: astore 4
    //   279: aload_0
    //   280: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   283: invokestatic 129	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:i	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Landroid/text/Spannable;
    //   286: astore 5
    //   288: aload_0
    //   289: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   292: invokevirtual 102	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
    //   295: pop
    //   296: aload_3
    //   297: aload 4
    //   299: aload 5
    //   301: aload_1
    //   302: aload_0
    //   303: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   306: invokevirtual 132	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
    //   309: invokeinterface 137 5 0
    //   314: aload_0
    //   315: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   318: invokestatic 140	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:e	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   321: pop
    //   322: aload_0
    //   323: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   326: invokestatic 143	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:j	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   329: pop
    //   330: aload_0
    //   331: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   334: invokestatic 146	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:k	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)V
    //   337: aload_0
    //   338: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   341: invokestatic 149	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:l	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)V
    //   344: aload_0
    //   345: monitorexit
    //   346: return
    //   347: aload_0
    //   348: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   351: getfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIl	Ljava/lang/String;
    //   354: astore_1
    //   355: goto -328 -> 27
    //   358: astore_1
    //   359: aload_0
    //   360: monitorexit
    //   361: aload_1
    //   362: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	2
    //   0	363	1	paramEditable	android.text.Editable
    //   176	39	2	i	int
    //   13	284	3	localObject	Object
    //   277	21	4	localWXRTEditText	WXRTEditText
    //   286	14	5	localSpannable	android.text.Spannable
    // Exception table:
    //   from	to	target	type
    //   2	24	358	finally
    //   27	46	358	finally
    //   46	114	358	finally
    //   114	140	358	finally
    //   140	218	358	finally
    //   218	314	358	finally
    //   314	344	358	finally
    //   347	355	358	finally
  }
  
  /* Error */
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   6: invokestatic 155	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
    //   9: ifnonnull +107 -> 116
    //   12: ldc 39
    //   14: astore 5
    //   16: aload_0
    //   17: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   20: invokestatic 46	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:d	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Z
    //   23: ifne +90 -> 113
    //   26: aload_1
    //   27: invokeinterface 158 1 0
    //   32: aload 5
    //   34: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifne +76 -> 113
    //   40: aload_0
    //   41: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   44: aload_0
    //   45: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   48: invokevirtual 102	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionStart	()I
    //   51: invokestatic 161	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;I)I
    //   54: pop
    //   55: aload_0
    //   56: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   59: aload_0
    //   60: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   63: invokevirtual 132	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:getSelectionEnd	()I
    //   66: invokestatic 164	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:b	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;I)I
    //   69: pop
    //   70: aload_0
    //   71: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   74: aload_1
    //   75: invokeinterface 158 1 0
    //   80: invokestatic 167	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Ljava/lang/String;)Ljava/lang/String;
    //   83: pop
    //   84: aload_0
    //   85: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   88: aload_0
    //   89: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   92: invokestatic 155	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
    //   95: putfield 37	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:rIl	Ljava/lang/String;
    //   98: aload_0
    //   99: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   102: aload_0
    //   103: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   106: invokevirtual 121	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:ciu	()Landroid/text/Spannable;
    //   109: invokestatic 170	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:a	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;Landroid/text/Spannable;)Landroid/text/Spannable;
    //   112: pop
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: aload_0
    //   117: getfield 14	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText$2:rIL	Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;
    //   120: invokestatic 155	com/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText:c	(Lcom/tencent/mm/plugin/wenote/model/nativenote/manager/WXRTEditText;)Ljava/lang/String;
    //   123: astore 5
    //   125: goto -109 -> 16
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	2
    //   0	133	1	paramCharSequence	CharSequence
    //   0	133	2	paramInt1	int
    //   0	133	3	paramInt2	int
    //   0	133	4	paramInt3	int
    //   14	110	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   2	12	128	finally
    //   16	113	128	finally
    //   116	125	128	finally
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      WXRTEditText.e(this.rIL);
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