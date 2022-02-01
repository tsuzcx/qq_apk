package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class MiniQbCallBackBaseUI
  extends MMActivity
{
  protected void b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(251102);
    Log.i(getTag(), "dealEvent() processName:%s appId:%s readProgress:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(251102);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  protected String getTag()
  {
    return "MicroMsg.FilesFloatBall.MiniQbCallBackBaseUI";
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 51	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   10: aload_0
    //   11: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   14: ifnonnull +22 -> 36
    //   17: aload_0
    //   18: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   21: ldc 57
    //   23: invokestatic 61	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: invokevirtual 64	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:finish	()V
    //   30: ldc 49
    //   32: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_0
    //   37: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   40: ldc 66
    //   42: iconst_2
    //   43: anewarray 26	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_0
    //   49: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: aload_0
    //   56: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   59: invokevirtual 72	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   62: aastore
    //   63: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc 77
    //   68: astore_1
    //   69: ldc 77
    //   71: astore 5
    //   73: ldc 77
    //   75: astore 7
    //   77: aload_0
    //   78: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   81: ldc 79
    //   83: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   86: ifeq +500 -> 586
    //   89: aload_0
    //   90: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   93: ldc 79
    //   95: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_1
    //   99: new 89	org/json/JSONObject
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 92	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   107: astore 8
    //   109: aload 8
    //   111: ldc 94
    //   113: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 5
    //   118: aload 8
    //   120: ldc 99
    //   122: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 6
    //   127: aload 8
    //   129: ldc 101
    //   131: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore_1
    //   135: aload 8
    //   137: ldc 103
    //   139: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 8
    //   144: aload 8
    //   146: astore 7
    //   148: aload_0
    //   149: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   152: ldc 105
    //   154: iconst_4
    //   155: anewarray 26	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload 5
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload 6
    //   167: aastore
    //   168: dup
    //   169: iconst_2
    //   170: aload_1
    //   171: aastore
    //   172: dup
    //   173: iconst_3
    //   174: aload 7
    //   176: aastore
    //   177: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload 7
    //   182: astore 9
    //   184: aload 6
    //   186: astore 8
    //   188: aload 5
    //   190: astore 7
    //   192: aload 9
    //   194: astore 6
    //   196: aload_1
    //   197: astore 5
    //   199: aload 8
    //   201: astore_1
    //   202: aload 6
    //   204: invokestatic 110	com/tencent/mm/ui/chatting/floatball/a:isFileExist	(Ljava/lang/String;)Z
    //   207: ifne +71 -> 278
    //   210: aload_0
    //   211: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   214: ldc 112
    //   216: invokestatic 61	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual 64	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:finish	()V
    //   223: ldc 49
    //   225: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: return
    //   229: astore 6
    //   231: ldc 77
    //   233: astore_1
    //   234: ldc 77
    //   236: astore 5
    //   238: aload_0
    //   239: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   242: ldc 114
    //   244: iconst_2
    //   245: anewarray 26	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload 6
    //   252: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   255: invokevirtual 123	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: aload 6
    //   263: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: invokestatic 131	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
    //   273: astore 6
    //   275: goto -127 -> 148
    //   278: aload_0
    //   279: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   282: ldc 133
    //   284: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   287: ifeq +294 -> 581
    //   290: aload_0
    //   291: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   294: ldc 133
    //   296: iconst_m1
    //   297: invokevirtual 137	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   300: istore_2
    //   301: aload_0
    //   302: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   305: ldc 139
    //   307: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   310: ifeq +266 -> 576
    //   313: aload_0
    //   314: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   317: ldc 139
    //   319: iconst_m1
    //   320: invokevirtual 137	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   323: istore 4
    //   325: iload 4
    //   327: istore_3
    //   328: iload 4
    //   330: iconst_m1
    //   331: if_icmpeq +9 -> 340
    //   334: bipush 6
    //   336: istore_2
    //   337: iload 4
    //   339: istore_3
    //   340: aload_0
    //   341: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   344: ldc 141
    //   346: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   349: ifeq +224 -> 573
    //   352: aload_0
    //   353: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   356: ldc 141
    //   358: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore 8
    //   363: aload_0
    //   364: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   367: ldc 143
    //   369: iconst_2
    //   370: anewarray 26	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: iload_2
    //   376: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: aastore
    //   380: dup
    //   381: iconst_1
    //   382: aload 8
    //   384: aastore
    //   385: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: ldc 145
    //   390: aload 8
    //   392: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   395: ifeq +178 -> 573
    //   398: iconst_m1
    //   399: iload_2
    //   400: if_icmpne +113 -> 513
    //   403: bipush 9
    //   405: istore_2
    //   406: aload_0
    //   407: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   410: ldc 153
    //   412: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   415: ifeq +151 -> 566
    //   418: aload_0
    //   419: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   422: ldc 153
    //   424: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   427: astore 8
    //   429: aload_0
    //   430: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   433: ldc 155
    //   435: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   438: ifeq +121 -> 559
    //   441: aload_0
    //   442: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   445: ldc 155
    //   447: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   450: astore 9
    //   452: aload_0
    //   453: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   456: ldc 157
    //   458: iconst_4
    //   459: anewarray 26	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: iload_2
    //   465: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aastore
    //   469: dup
    //   470: iconst_1
    //   471: aload 8
    //   473: aastore
    //   474: dup
    //   475: iconst_2
    //   476: aload 9
    //   478: aastore
    //   479: dup
    //   480: iconst_3
    //   481: iload_3
    //   482: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   485: aastore
    //   486: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   489: aload 7
    //   491: ldc 159
    //   493: invokestatic 165	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   496: ifeq +29 -> 525
    //   499: aload_0
    //   500: aload_1
    //   501: aload 5
    //   503: iload_2
    //   504: aload 6
    //   506: iload_3
    //   507: invokevirtual 167	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:b	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V
    //   510: goto -291 -> 219
    //   513: bipush 7
    //   515: iload_2
    //   516: if_icmpne +57 -> 573
    //   519: bipush 10
    //   521: istore_2
    //   522: goto -116 -> 406
    //   525: aload_0
    //   526: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   529: ldc 169
    //   531: iconst_1
    //   532: anewarray 26	java/lang/Object
    //   535: dup
    //   536: iconst_0
    //   537: aload 7
    //   539: aastore
    //   540: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   543: goto -324 -> 219
    //   546: astore 6
    //   548: ldc 77
    //   550: astore_1
    //   551: goto -313 -> 238
    //   554: astore 6
    //   556: goto -318 -> 238
    //   559: ldc 77
    //   561: astore 9
    //   563: goto -111 -> 452
    //   566: ldc 77
    //   568: astore 8
    //   570: goto -141 -> 429
    //   573: goto -167 -> 406
    //   576: iconst_m1
    //   577: istore_3
    //   578: goto -238 -> 340
    //   581: iconst_m1
    //   582: istore_2
    //   583: goto -282 -> 301
    //   586: ldc 77
    //   588: astore 6
    //   590: ldc 77
    //   592: astore 7
    //   594: goto -392 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	MiniQbCallBackBaseUI
    //   0	597	1	paramBundle	android.os.Bundle
    //   300	283	2	i	int
    //   327	251	3	j	int
    //   323	15	4	k	int
    //   71	431	5	localObject1	Object
    //   125	78	6	localObject2	Object
    //   229	33	6	localException1	java.lang.Exception
    //   273	232	6	str1	String
    //   546	1	6	localException2	java.lang.Exception
    //   554	1	6	localException3	java.lang.Exception
    //   588	1	6	str2	String
    //   75	518	7	localObject3	Object
    //   107	462	8	localObject4	Object
    //   182	380	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   99	118	229	java/lang/Exception
    //   118	135	546	java/lang/Exception
    //   135	144	554	java/lang/Exception
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackBaseUI
 * JD-Core Version:    0.7.0.1
 */