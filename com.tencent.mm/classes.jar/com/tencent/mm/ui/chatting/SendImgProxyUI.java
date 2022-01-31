package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;

public class SendImgProxyUI
  extends MMBaseActivity
{
  private static boolean isRunning = false;
  private p hdi = null;
  
  /* Error */
  private static ArrayList<String> a(ArrayList<String> paramArrayList1, int paramInt, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 25	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 26	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aload_0
    //   10: ifnull +198 -> 208
    //   13: aload_0
    //   14: invokevirtual 30	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   17: astore 8
    //   19: aload 8
    //   21: invokeinterface 36 1 0
    //   26: ifeq +182 -> 208
    //   29: aload 8
    //   31: invokeinterface 40 1 0
    //   36: checkcast 42	java/lang/String
    //   39: astore 9
    //   41: aload 9
    //   43: invokevirtual 46	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   46: ldc 48
    //   48: invokevirtual 52	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   51: ifeq +113 -> 164
    //   54: aconst_null
    //   55: astore 6
    //   57: aload 9
    //   59: invokestatic 58	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   62: astore_0
    //   63: aload_0
    //   64: astore 6
    //   66: aload_0
    //   67: invokestatic 64	com/tencent/mm/sdk/platformtools/MMBitmapFactory:checkIsImageLegal	(Ljava/io/InputStream;)Z
    //   70: ifeq +35 -> 105
    //   73: aload_0
    //   74: astore 6
    //   76: aload 9
    //   78: invokestatic 68	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   81: lstore 4
    //   83: iload_3
    //   84: ifne +36 -> 120
    //   87: lload 4
    //   89: iload_1
    //   90: i2l
    //   91: lcmp
    //   92: ifle +28 -> 120
    //   95: aload_0
    //   96: astore 6
    //   98: aload_2
    //   99: aload 9
    //   101: invokevirtual 72	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   104: pop
    //   105: aload_0
    //   106: ifnull -87 -> 19
    //   109: aload_0
    //   110: invokevirtual 77	java/io/InputStream:close	()V
    //   113: goto -94 -> 19
    //   116: astore_0
    //   117: goto -98 -> 19
    //   120: aload_0
    //   121: astore 6
    //   123: aload 7
    //   125: aload 9
    //   127: invokevirtual 72	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   130: pop
    //   131: goto -26 -> 105
    //   134: astore 6
    //   136: aload_0
    //   137: ifnull -118 -> 19
    //   140: aload_0
    //   141: invokevirtual 77	java/io/InputStream:close	()V
    //   144: goto -125 -> 19
    //   147: astore_0
    //   148: goto -129 -> 19
    //   151: astore_0
    //   152: aload 6
    //   154: ifnull +8 -> 162
    //   157: aload 6
    //   159: invokevirtual 77	java/io/InputStream:close	()V
    //   162: aload_0
    //   163: athrow
    //   164: aload 9
    //   166: invokestatic 68	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   169: lstore 4
    //   171: iload_3
    //   172: ifne +21 -> 193
    //   175: lload 4
    //   177: iload_1
    //   178: i2l
    //   179: lcmp
    //   180: ifle +13 -> 193
    //   183: aload_2
    //   184: aload 9
    //   186: invokevirtual 72	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   189: pop
    //   190: goto -171 -> 19
    //   193: aload 7
    //   195: aload 9
    //   197: invokevirtual 72	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   200: pop
    //   201: goto -182 -> 19
    //   204: astore_2
    //   205: goto -43 -> 162
    //   208: aload 7
    //   210: areturn
    //   211: astore_0
    //   212: aconst_null
    //   213: astore_0
    //   214: goto -78 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramArrayList1	ArrayList<String>
    //   0	217	1	paramInt	int
    //   0	217	2	paramArrayList2	ArrayList<String>
    //   0	217	3	paramBoolean	boolean
    //   81	95	4	l	long
    //   55	67	6	localArrayList	ArrayList<String>
    //   134	24	6	localException	java.lang.Exception
    //   7	202	7	localArrayList1	ArrayList
    //   17	13	8	localIterator	java.util.Iterator
    //   39	157	9	str	String
    // Exception table:
    //   from	to	target	type
    //   109	113	116	java/lang/Exception
    //   66	73	134	java/lang/Exception
    //   76	83	134	java/lang/Exception
    //   98	105	134	java/lang/Exception
    //   123	131	134	java/lang/Exception
    //   140	144	147	java/lang/Exception
    //   57	63	151	finally
    //   66	73	151	finally
    //   76	83	151	finally
    //   98	105	151	finally
    //   123	131	151	finally
    //   157	162	204	java/lang/Exception
    //   57	63	211	java/lang/Exception
  }
  
  private static void l(ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1)
  {
    if (paramArrayList.size() != paramArrayList1.size()) {
      y.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList1.size())
      {
        int j = ((Integer)paramArrayList.get(i)).intValue();
        Object localObject = o.OJ().iH(j);
        int k = (int)com.tencent.mm.vfs.e.aeQ((String)paramArrayList1.get(i));
        ((com.tencent.mm.as.e)localObject).setOffset(k);
        ((com.tencent.mm.as.e)localObject).iC(k);
        o.OJ().a(j, (com.tencent.mm.as.e)localObject);
        long l = ((com.tencent.mm.as.e)localObject).enx;
        y.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[] { Long.valueOf(l), Integer.valueOf(j) });
        localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(l);
        ((bi)localObject).setStatus(5);
        ((bi)localObject).ff(256);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(l, (bi)localObject);
        y.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((cs)localObject).field_msgId), Long.valueOf(((cs)localObject).field_msgSvrId), ((cs)localObject).field_talker, Integer.valueOf(((bi)localObject).getType()), Integer.valueOf(((cs)localObject).field_isSend), ((cs)localObject).field_imgPath, Integer.valueOf(((cs)localObject).field_status), Long.valueOf(((cs)localObject).field_createTime) });
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    ak.a(getWindow());
    y.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    if (isRunning)
    {
      y.w("MicroMsg.SendImgProxyUI", "duplicate instance");
      finish();
      return;
    }
    isRunning = true;
    setContentView(R.i.background_transparent);
    this.hdi = h.b(this, getString(R.l.main_sending), false, null);
    boolean bool1 = aq.isWifi(this);
    boolean bool2 = WXHardCoderJNI.hcSendPicMsgEnable;
    int j = WXHardCoderJNI.hcSendPicMsgDelay;
    int k = WXHardCoderJNI.hcSendPicMsgCPU;
    int m = WXHardCoderJNI.hcSendPicMsgIO;
    if (WXHardCoderJNI.hcSendPicMsgThr) {
      i = com.tencent.mm.kernel.g.DS().crd();
    }
    i = WXHardCoderJNI.startPerformance(bool2, j, k, m, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
    au.DS().O(new SendImgProxyUI.1(this, bool1, i));
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onDestroy();
  }
  
  public void onResume()
  {
    y.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendImgProxyUI
 * JD-Core Version:    0.7.0.1
 */