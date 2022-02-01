package com.tencent.mm.plugin.sns.ui.a.b;

import android.content.Context;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class a
  extends b
{
  private boolean DEBUG = false;
  private List<String> RES = new ArrayList();
  private bn RHe;
  private int RHf = (int)(System.currentTimeMillis() / 1000L);
  private boolean RHg = false;
  private volatile boolean RHh = false;
  private byte[] RHi = new byte[0];
  public HashMap<String, Boolean> RHj = new HashMap();
  protected HashMap<String, String> RHk = new HashMap();
  private String RHl = "";
  private String RHm = "";
  protected volatile String RiY = "";
  protected volatile String RiZ = "";
  protected volatile String Rja = "";
  protected volatile String Rjb = "";
  private String Rzk;
  private Context mContext;
  private bx onc;
  protected volatile String zPH = "";
  
  public a(SnsInfo paramSnsInfo)
  {
    super(paramSnsInfo);
    jJA();
  }
  
  private void aNi()
  {
    synchronized (this.RHi)
    {
      Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by initData");
      if (Util.isNullOrNil(this.Rjb)) {
        this.zPH = ai(0L, this.zPH);
      }
      return;
    }
  }
  
  public final void Eu(boolean paramBoolean)
  {
    this.RHh = paramBoolean;
  }
  
  public final void a(Context paramContext, bn parambn, String paramString)
  {
    this.mContext = paramContext;
    this.RHe = parambn;
    this.Rzk = paramString;
    h.baF();
    this.onc = ((n)h.ax(n.class)).bzA();
  }
  
  public final void baQ(String paramString)
  {
    this.RiY = paramString;
  }
  
  public final void baR(String paramString)
  {
    Log.i("MicroMsg.SnsTimeLineVendingSide", "setUnreadBottomSeq:[%s, %s]", new Object[] { paramString, Long.valueOf(t.aXD(paramString)) });
    this.RiZ = paramString;
  }
  
  public final void baS(String paramString)
  {
    Log.i("MicroMsg.SnsTimeLineVendingSide", "setUnreadTopSeq:[%s, %s]", new Object[] { paramString, Long.valueOf(t.aXD(paramString)) });
    this.Rja = paramString;
  }
  
  public final void baT(String paramString)
  {
    synchronized (this.RHi)
    {
      this.zPH = paramString;
      return;
    }
  }
  
  public final void baU(String paramString)
  {
    synchronized (this.RHi)
    {
      this.Rjb = paramString;
      return;
    }
  }
  
  public void destroyAsynchronous()
  {
    super.destroyAsynchronous();
    com.tencent.mm.kiss.widget.textview.c.mGx.bbI();
    this.RHj.clear();
    this.mContext = null;
    this.RHe = null;
    this.onc = null;
    this.agtA = null;
  }
  
  public final void hpl()
  {
    long l2 = 0L;
    looperCheckForVending();
    int i = al.hgN().QxQ;
    long l1;
    if (i == ay.Qyz)
    {
      l1 = al.hgN().QxP;
      Log.printDebugStack("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeqWithoutFault", new Object[0]);
      Log.d("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeqWithoutFault %s %s", new Object[] { Integer.valueOf(al.hgr().hhi()), this.zPH });
      this.zPH = t.uB(al.hgB().h(l1, al.hgr().hhi(), false));
      this.zPH = this.zPH;
      this.Rjb = t.uB(l1);
      Log.d("MicroMsg.SnsTimeLineVendingSide", "unreadTipFaultItem.end:%s, upLimitSeq:%s, downLimitSeq:%s", new Object[] { Long.valueOf(l1), Long.valueOf(t.aXD(this.Rjb)), Long.valueOf(t.aXD(this.zPH)) });
      return;
    }
    label170:
    int j;
    if (i == ay.QyB)
    {
      if (this.mCount == 0)
      {
        l1 = 0L;
        this.RHh = true;
        synchronized (this.RHi)
        {
          Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by addSizeByNormal");
          this.zPH = ai(l1, this.zPH);
          return;
        }
      }
      i = this.mCount - 1;
      j = 0;
    }
    for (;;)
    {
      ??? = (SnsInfo)getItem(i);
      if ((??? != null) && (!((SnsInfo)???).isSourceExist(32)) && (((SnsInfo)???).field_snsId != 0L))
      {
        l1 = ((SnsInfo)???).field_snsId;
        Log.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[] { Long.valueOf(l1), ((SnsInfo)???).getStringSeq() });
        break label170;
      }
      j += 1;
      i -= 1;
      if ((i < 0) || (j > 500))
      {
        l1 = 0L;
        break label170;
        if (i != ay.QyA) {
          break;
        }
        if (this.mCount == 0)
        {
          l1 = l2;
          synchronized (this.RHi)
          {
            this.Rjb = vy(l1);
            return;
          }
        }
        i = 0;
        j = 0;
        for (;;)
        {
          ??? = (SnsInfo)getItem(i);
          if ((??? != null) && (!((SnsInfo)???).isSourceExist(32)) && (((SnsInfo)???).field_snsId != 0L))
          {
            l1 = ((SnsInfo)???).field_snsId;
            Log.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", new Object[] { Long.valueOf(l1), ((SnsInfo)???).getStringSeq() });
            break;
          }
          j += 1;
          i += 1;
          l1 = l2;
          if (i >= this.mCount) {
            break;
          }
          l1 = l2;
          if (j > 500) {
            break;
          }
        }
      }
    }
  }
  
  public final String hqK()
  {
    return this.RiZ;
  }
  
  public final String hqL()
  {
    return this.Rja;
  }
  
  public final String hqM()
  {
    return this.zPH;
  }
  
  public final String hqN()
  {
    return this.Rjb;
  }
  
  public final String hqO()
  {
    return this.RiY;
  }
  
  /* Error */
  public android.database.Cursor hqP()
  {
    // Byte code:
    //   0: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: invokevirtual 479	com/tencent/mm/plugin/sns/ui/a/b/a:init	()V
    //   8: aload_0
    //   9: getfield 63	com/tencent/mm/plugin/sns/ui/a/b/a:Rjb	Ljava/lang/String;
    //   12: invokestatic 108	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   15: ifne +549 -> 564
    //   18: invokestatic 440	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   21: astore 9
    //   23: aload_0
    //   24: getfield 61	com/tencent/mm/plugin/sns/ui/a/b/a:zPH	Ljava/lang/String;
    //   27: astore 11
    //   29: aload_0
    //   30: getfield 63	com/tencent/mm/plugin/sns/ui/a/b/a:Rjb	Ljava/lang/String;
    //   33: astore 10
    //   35: iconst_2
    //   36: newarray int
    //   38: astore 8
    //   40: aload 10
    //   42: invokestatic 482	com/tencent/mm/plugin/sns/storage/w:bad	(Ljava/lang/String;)Z
    //   45: istore 5
    //   47: invokestatic 485	com/tencent/mm/plugin/sns/storage/w:hla	()Ljava/lang/String;
    //   50: astore 7
    //   52: aload 7
    //   54: astore 6
    //   56: aload 11
    //   58: invokestatic 482	com/tencent/mm/plugin/sns/storage/w:bad	(Ljava/lang/String;)Z
    //   61: ifeq +36 -> 97
    //   64: new 487	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 488	java/lang/StringBuilder:<init>	()V
    //   71: aload 7
    //   73: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 494
    //   79: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 9
    //   84: aload 11
    //   86: invokevirtual 498	com/tencent/mm/plugin/sns/storage/w:bae	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 501	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 6
    //   97: aload 6
    //   99: astore 7
    //   101: iload 5
    //   103: ifeq +36 -> 139
    //   106: new 487	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 488	java/lang/StringBuilder:<init>	()V
    //   113: aload 6
    //   115: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 494
    //   121: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 9
    //   126: aload 10
    //   128: invokevirtual 504	com/tencent/mm/plugin/sns/storage/w:bai	(Ljava/lang/String;)Ljava/lang/String;
    //   131: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 501	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 7
    //   139: new 487	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 488	java/lang/StringBuilder:<init>	()V
    //   146: aload 7
    //   148: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 506
    //   154: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 501	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore 6
    //   162: new 487	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 488	java/lang/StringBuilder:<init>	()V
    //   169: aload 6
    //   171: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: getstatic 509	com/tencent/mm/plugin/sns/storage/w:QYX	Ljava/lang/String;
    //   177: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 501	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore 6
    //   185: aload 9
    //   187: getfield 513	com/tencent/mm/plugin/sns/storage/w:QYR	Lcom/tencent/mm/plugin/sns/storage/ab;
    //   190: aload 6
    //   192: aconst_null
    //   193: iconst_2
    //   194: invokevirtual 519	com/tencent/mm/plugin/sns/storage/ab:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   197: astore 7
    //   199: aload 7
    //   201: invokeinterface 522 1 0
    //   206: ifeq +500 -> 706
    //   209: new 118	com/tencent/mm/plugin/sns/storage/SnsInfo
    //   212: dup
    //   213: invokespecial 119	com/tencent/mm/plugin/sns/storage/SnsInfo:<init>	()V
    //   216: astore 9
    //   218: aload 9
    //   220: aload 7
    //   222: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:convertFrom	(Landroid/database/Cursor;)V
    //   225: aload 9
    //   227: getfield 525	com/tencent/mm/plugin/sns/storage/SnsInfo:field_createTime	I
    //   230: istore_1
    //   231: iload 5
    //   233: ifeq +468 -> 701
    //   236: aload 7
    //   238: invokeinterface 528 1 0
    //   243: ifeq +458 -> 701
    //   246: new 118	com/tencent/mm/plugin/sns/storage/SnsInfo
    //   249: dup
    //   250: invokespecial 119	com/tencent/mm/plugin/sns/storage/SnsInfo:<init>	()V
    //   253: astore 9
    //   255: aload 9
    //   257: aload 7
    //   259: invokevirtual 123	com/tencent/mm/plugin/sns/storage/SnsInfo:convertFrom	(Landroid/database/Cursor;)V
    //   262: aload 9
    //   264: getfield 525	com/tencent/mm/plugin/sns/storage/SnsInfo:field_createTime	I
    //   267: istore_2
    //   268: aload 7
    //   270: invokeinterface 531 1 0
    //   275: ldc_w 533
    //   278: new 487	java/lang/StringBuilder
    //   281: dup
    //   282: ldc_w 535
    //   285: invokespecial 537	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: aload 6
    //   290: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w 539
    //   296: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload_1
    //   300: invokevirtual 542	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc_w 544
    //   306: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: iload_2
    //   310: invokevirtual 542	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: invokevirtual 501	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload 8
    //   321: iconst_0
    //   322: iload_1
    //   323: iastore
    //   324: aload 8
    //   326: iconst_1
    //   327: iload_2
    //   328: iastore
    //   329: aload 8
    //   331: iconst_0
    //   332: iaload
    //   333: istore_2
    //   334: aload 8
    //   336: iconst_1
    //   337: iaload
    //   338: istore_1
    //   339: ldc 94
    //   341: ldc_w 546
    //   344: iconst_3
    //   345: anewarray 154	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload_0
    //   351: getfield 51	com/tencent/mm/plugin/sns/ui/a/b/a:RHf	I
    //   354: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: iload_2
    //   361: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   364: aastore
    //   365: dup
    //   366: iconst_2
    //   367: aload_0
    //   368: getfield 61	com/tencent/mm/plugin/sns/ui/a/b/a:zPH	Ljava/lang/String;
    //   371: aastore
    //   372: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: aload_0
    //   376: getfield 51	com/tencent/mm/plugin/sns/ui/a/b/a:RHf	I
    //   379: iload_2
    //   380: aload_0
    //   381: getfield 130	com/tencent/mm/plugin/sns/ui/a/b/a:Rzk	Ljava/lang/String;
    //   384: invokestatic 552	com/tencent/mm/plugin/sns/ad/d/d:O	(IILjava/lang/String;)V
    //   387: aload_0
    //   388: iload_2
    //   389: putfield 51	com/tencent/mm/plugin/sns/ui/a/b/a:RHf	I
    //   392: ldc 94
    //   394: ldc_w 554
    //   397: iconst_4
    //   398: anewarray 154	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: aload_0
    //   404: getfield 63	com/tencent/mm/plugin/sns/ui/a/b/a:Rjb	Ljava/lang/String;
    //   407: invokestatic 379	com/tencent/mm/plugin/sns/data/t:aXD	(Ljava/lang/String;)J
    //   410: invokestatic 190	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   413: aastore
    //   414: dup
    //   415: iconst_1
    //   416: aload_0
    //   417: getfield 61	com/tencent/mm/plugin/sns/ui/a/b/a:zPH	Ljava/lang/String;
    //   420: invokestatic 379	com/tencent/mm/plugin/sns/data/t:aXD	(Ljava/lang/String;)J
    //   423: invokestatic 190	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   426: aastore
    //   427: dup
    //   428: iconst_2
    //   429: iload_1
    //   430: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: aastore
    //   434: dup
    //   435: iconst_3
    //   436: iload_2
    //   437: invokestatic 160	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: invokestatic 440	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   447: aload_0
    //   448: getfield 61	com/tencent/mm/plugin/sns/ui/a/b/a:zPH	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 63	com/tencent/mm/plugin/sns/ui/a/b/a:Rjb	Ljava/lang/String;
    //   455: iload_2
    //   456: iload_1
    //   457: invokevirtual 558	com/tencent/mm/plugin/sns/storage/w:u	(Ljava/lang/String;Ljava/lang/String;II)Landroid/database/Cursor;
    //   460: astore 6
    //   462: ldc 94
    //   464: ldc_w 560
    //   467: iconst_1
    //   468: anewarray 154	java/lang/Object
    //   471: dup
    //   472: iconst_0
    //   473: lload_3
    //   474: invokestatic 564	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
    //   477: invokestatic 190	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   480: aastore
    //   481: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: ldc 94
    //   486: ldc_w 566
    //   489: invokestatic 568	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: sipush 500
    //   495: invokestatic 574	com/tencent/mm/modelsns/l:wO	(I)Lcom/tencent/mm/modelsns/l;
    //   498: astore 7
    //   500: aload 7
    //   502: invokevirtual 577	com/tencent/mm/modelsns/l:bMD	()Z
    //   505: ifeq +33 -> 538
    //   508: aload_0
    //   509: getfield 340	com/tencent/mm/vending/base/c:mCount	I
    //   512: istore_1
    //   513: iload_1
    //   514: ifne +97 -> 611
    //   517: aload 7
    //   519: iconst_0
    //   520: invokevirtual 580	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   523: iconst_0
    //   524: invokevirtual 580	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   527: iconst_0
    //   528: invokevirtual 580	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   531: pop
    //   532: aload 7
    //   534: invokevirtual 583	com/tencent/mm/modelsns/l:bMH	()Z
    //   537: pop
    //   538: invokestatic 172	com/tencent/mm/plugin/sns/model/al:hgN	()Lcom/tencent/mm/plugin/sns/model/ax;
    //   541: astore 7
    //   543: aload 7
    //   545: getfield 181	com/tencent/mm/plugin/sns/model/ax:Qxy	Z
    //   548: ifeq +13 -> 561
    //   551: aload 7
    //   553: getfield 185	com/tencent/mm/plugin/sns/model/ax:QxJ	Ljava/util/Map;
    //   556: invokeinterface 584 1 0
    //   561: aload 6
    //   563: areturn
    //   564: invokestatic 440	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   567: aload_0
    //   568: getfield 61	com/tencent/mm/plugin/sns/ui/a/b/a:zPH	Ljava/lang/String;
    //   571: invokevirtual 588	com/tencent/mm/plugin/sns/storage/w:baj	(Ljava/lang/String;)I
    //   574: istore_2
    //   575: iconst_0
    //   576: istore_1
    //   577: goto -238 -> 339
    //   580: astore 6
    //   582: ldc 94
    //   584: new 487	java/lang/StringBuilder
    //   587: dup
    //   588: ldc_w 590
    //   591: invokespecial 537	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   594: aload 6
    //   596: invokevirtual 593	java/lang/Throwable:toString	()Ljava/lang/String;
    //   599: invokevirtual 492	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 501	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 596	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: goto -221 -> 387
    //   611: aload_0
    //   612: iconst_1
    //   613: invokevirtual 454	com/tencent/mm/plugin/sns/ui/a/b/a:getItem	(I)Ljava/lang/Object;
    //   616: checkcast 118	com/tencent/mm/plugin/sns/storage/SnsInfo
    //   619: invokestatic 348	com/tencent/mm/plugin/sns/data/t:x	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Ljava/lang/String;
    //   622: astore 8
    //   624: aload_0
    //   625: iload_1
    //   626: iconst_1
    //   627: isub
    //   628: invokevirtual 454	com/tencent/mm/plugin/sns/ui/a/b/a:getItem	(I)Ljava/lang/Object;
    //   631: checkcast 118	com/tencent/mm/plugin/sns/storage/SnsInfo
    //   634: invokestatic 348	com/tencent/mm/plugin/sns/data/t:x	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Ljava/lang/String;
    //   637: astore 9
    //   639: aload 8
    //   641: aload_0
    //   642: getfield 85	com/tencent/mm/plugin/sns/ui/a/b/a:RHl	Ljava/lang/String;
    //   645: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   648: ifeq +15 -> 663
    //   651: aload 9
    //   653: aload_0
    //   654: getfield 87	com/tencent/mm/plugin/sns/ui/a/b/a:RHm	Ljava/lang/String;
    //   657: invokevirtual 602	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   660: ifne -122 -> 538
    //   663: aload_0
    //   664: aload 8
    //   666: putfield 85	com/tencent/mm/plugin/sns/ui/a/b/a:RHl	Ljava/lang/String;
    //   669: aload_0
    //   670: aload 9
    //   672: putfield 87	com/tencent/mm/plugin/sns/ui/a/b/a:RHm	Ljava/lang/String;
    //   675: aload 7
    //   677: iload_1
    //   678: invokevirtual 580	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
    //   681: aload 8
    //   683: invokevirtual 606	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   686: aload 9
    //   688: invokevirtual 606	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
    //   691: pop
    //   692: aload 7
    //   694: invokevirtual 583	com/tencent/mm/modelsns/l:bMH	()Z
    //   697: pop
    //   698: goto -160 -> 538
    //   701: iconst_0
    //   702: istore_2
    //   703: goto -435 -> 268
    //   706: iconst_0
    //   707: istore_1
    //   708: goto -477 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	711	0	this	a
    //   230	478	1	i	int
    //   267	436	2	j	int
    //   3	471	3	l	long
    //   45	187	5	bool	boolean
    //   54	508	6	localObject1	Object
    //   580	15	6	localObject2	Object
    //   50	643	7	localObject3	Object
    //   38	644	8	localObject4	Object
    //   21	666	9	localObject5	Object
    //   33	94	10	str1	String
    //   27	58	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   375	387	580	finally
  }
  
  protected final void init()
  {
    if (!this.RHg)
    {
      aNi();
      this.RHg = true;
    }
  }
  
  public final void resetSize()
  {
    looperCheckForVending();
    Log.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", new Object[] { Boolean.valueOf(this.RHh) });
    if (this.RHh) {
      return;
    }
    synchronized (this.RHi)
    {
      Log.i("MicroMsg.SnsTimeLineVendingSide", "updateDownLimitSeq by resetSize");
      this.zPH = ai(0L, this.zPH);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.a.b.a
 * JD-Core Version:    0.7.0.1
 */