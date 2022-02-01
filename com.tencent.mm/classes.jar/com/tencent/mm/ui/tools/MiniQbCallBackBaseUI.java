package com.tencent.mm.ui.tools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public class MiniQbCallBackBaseUI
  extends MMActivity
{
  protected void b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(234463);
    Log.i(getTag(), "dealEvent() processName:%s appId:%s readProgress:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt2) });
    AppMethodBeat.o(234463);
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
    //   71: astore 4
    //   73: ldc 77
    //   75: astore 6
    //   77: aload_0
    //   78: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   81: ldc 79
    //   83: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   86: ifeq +414 -> 500
    //   89: aload_0
    //   90: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   93: ldc 79
    //   95: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_1
    //   99: new 89	org/json/JSONObject
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 92	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   107: astore 7
    //   109: aload 7
    //   111: ldc 94
    //   113: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 4
    //   118: aload 7
    //   120: ldc 99
    //   122: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 7
    //   129: ldc 101
    //   131: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore_1
    //   135: aload 7
    //   137: ldc 103
    //   139: invokevirtual 97	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 7
    //   144: aload 7
    //   146: astore 6
    //   148: aload_0
    //   149: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   152: ldc 105
    //   154: iconst_4
    //   155: anewarray 26	java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: aload 4
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload 5
    //   167: aastore
    //   168: dup
    //   169: iconst_2
    //   170: aload_1
    //   171: aastore
    //   172: dup
    //   173: iconst_3
    //   174: aload 6
    //   176: aastore
    //   177: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: aload 6
    //   182: astore 8
    //   184: aload 5
    //   186: astore 7
    //   188: aload 4
    //   190: astore 6
    //   192: aload 8
    //   194: astore 5
    //   196: aload_1
    //   197: astore 4
    //   199: aload 7
    //   201: astore_1
    //   202: aload 5
    //   204: invokestatic 110	com/tencent/mm/ui/chatting/g/a:isFileExist	(Ljava/lang/String;)Z
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
    //   229: astore 5
    //   231: ldc 77
    //   233: astore_1
    //   234: ldc 77
    //   236: astore 4
    //   238: aload_0
    //   239: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   242: ldc 114
    //   244: iconst_2
    //   245: anewarray 26	java/lang/Object
    //   248: dup
    //   249: iconst_0
    //   250: aload 5
    //   252: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   255: invokevirtual 123	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: aload 5
    //   263: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: invokestatic 131	com/tencent/mm/sdk/platformtools/MMApplicationContext:getProcessName	()Ljava/lang/String;
    //   273: astore 5
    //   275: goto -127 -> 148
    //   278: aload_0
    //   279: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   282: ldc 133
    //   284: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   287: ifeq +208 -> 495
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
    //   310: ifeq +180 -> 490
    //   313: aload_0
    //   314: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   317: ldc 139
    //   319: iconst_m1
    //   320: invokevirtual 137	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   323: istore_3
    //   324: iload_3
    //   325: iconst_m1
    //   326: if_icmpeq +161 -> 487
    //   329: bipush 6
    //   331: istore_2
    //   332: aload_0
    //   333: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   336: ldc 141
    //   338: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   341: ifeq +139 -> 480
    //   344: aload_0
    //   345: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   348: ldc 141
    //   350: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   353: astore 7
    //   355: aload_0
    //   356: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   359: ldc 143
    //   361: invokevirtual 83	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   364: ifeq +109 -> 473
    //   367: aload_0
    //   368: invokevirtual 55	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getIntent	()Landroid/content/Intent;
    //   371: ldc 143
    //   373: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   376: astore 8
    //   378: aload_0
    //   379: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   382: ldc 145
    //   384: iconst_4
    //   385: anewarray 26	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: iload_2
    //   391: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aastore
    //   395: dup
    //   396: iconst_1
    //   397: aload 7
    //   399: aastore
    //   400: dup
    //   401: iconst_2
    //   402: aload 8
    //   404: aastore
    //   405: dup
    //   406: iconst_3
    //   407: iload_3
    //   408: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: aastore
    //   412: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: aload 6
    //   417: ldc 147
    //   419: invokestatic 153	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   422: ifeq +17 -> 439
    //   425: aload_0
    //   426: aload_1
    //   427: aload 4
    //   429: iload_2
    //   430: aload 5
    //   432: iload_3
    //   433: invokevirtual 155	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:b	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V
    //   436: goto -217 -> 219
    //   439: aload_0
    //   440: invokevirtual 22	com/tencent/mm/ui/tools/MiniQbCallBackBaseUI:getTag	()Ljava/lang/String;
    //   443: ldc 157
    //   445: iconst_1
    //   446: anewarray 26	java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: aload 6
    //   453: aastore
    //   454: invokestatic 159	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   457: goto -238 -> 219
    //   460: astore 5
    //   462: ldc 77
    //   464: astore_1
    //   465: goto -227 -> 238
    //   468: astore 5
    //   470: goto -232 -> 238
    //   473: ldc 77
    //   475: astore 8
    //   477: goto -99 -> 378
    //   480: ldc 77
    //   482: astore 7
    //   484: goto -129 -> 355
    //   487: goto -155 -> 332
    //   490: iconst_m1
    //   491: istore_3
    //   492: goto -160 -> 332
    //   495: iconst_m1
    //   496: istore_2
    //   497: goto -196 -> 301
    //   500: ldc 77
    //   502: astore 5
    //   504: ldc 77
    //   506: astore 6
    //   508: goto -306 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	MiniQbCallBackBaseUI
    //   0	511	1	paramBundle	android.os.Bundle
    //   300	197	2	i	int
    //   323	169	3	j	int
    //   71	357	4	localObject1	Object
    //   125	78	5	localObject2	Object
    //   229	33	5	localException1	java.lang.Exception
    //   273	158	5	str1	String
    //   460	1	5	localException2	java.lang.Exception
    //   468	1	5	localException3	java.lang.Exception
    //   502	1	5	str2	String
    //   75	432	6	localObject3	Object
    //   107	376	7	localObject4	Object
    //   182	294	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   99	118	229	java/lang/Exception
    //   118	135	460	java/lang/Exception
    //   135	144	468	java/lang/Exception
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MiniQbCallBackBaseUI
 * JD-Core Version:    0.7.0.1
 */