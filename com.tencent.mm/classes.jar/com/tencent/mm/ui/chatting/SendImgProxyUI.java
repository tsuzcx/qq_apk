package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI
  extends MMBaseActivity
{
  private static boolean isRunning = false;
  private p iMZ = null;
  
  private static ArrayList<String> a(ArrayList<String> paramArrayList1, int paramInt, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    AppMethodBeat.i(31007);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList1 != null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        String str = (String)paramArrayList1.next();
        if (r.aoX(str))
        {
          long l = com.tencent.mm.vfs.e.avI(str);
          if ((!paramBoolean) && (l > paramInt)) {
            paramArrayList2.add(str);
          } else {
            localArrayList.add(str);
          }
        }
      }
    }
    AppMethodBeat.o(31007);
    return localArrayList;
  }
  
  private static void g(ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1)
  {
    AppMethodBeat.i(31008);
    if (paramArrayList.size() != paramArrayList1.size())
    {
      ab.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
      AppMethodBeat.o(31008);
      return;
    }
    int i = 0;
    while (i < paramArrayList1.size())
    {
      int j = ((Integer)paramArrayList.get(i)).intValue();
      Object localObject = o.ahC().lv(j);
      int k = (int)com.tencent.mm.vfs.e.avI((String)paramArrayList1.get(i));
      ((com.tencent.mm.at.e)localObject).setOffset(k);
      ((com.tencent.mm.at.e)localObject).lq(k);
      o.ahC().a(j, (com.tencent.mm.at.e)localObject);
      long l = ((com.tencent.mm.at.e)localObject).fDU;
      ab.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[] { Long.valueOf(l), Integer.valueOf(j) });
      localObject = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(l);
      ((bi)localObject).setStatus(5);
      ((bi)localObject).hr(256);
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(l, (bi)localObject);
      ab.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((dd)localObject).field_msgId), Long.valueOf(((dd)localObject).field_msgSvrId), ((dd)localObject).field_talker, Integer.valueOf(((bi)localObject).getType()), Integer.valueOf(((dd)localObject).field_isSend), ((dd)localObject).field_imgPath, Integer.valueOf(((dd)localObject).field_status), Long.valueOf(((dd)localObject).field_createTime) });
      i += 1;
    }
    AppMethodBeat.o(31008);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(31004);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    af.a(getWindow());
    ab.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    if (isRunning)
    {
      ab.w("MicroMsg.SendImgProxyUI", "duplicate instance");
      finish();
      AppMethodBeat.o(31004);
      return;
    }
    isRunning = true;
    setContentView(2130968799);
    this.iMZ = com.tencent.mm.ui.base.h.b(this, getString(2131301428), false, null);
    boolean bool1 = at.isWifi(this);
    boolean bool2 = WXHardCoderJNI.hcSendPicMsgEnable;
    int j = WXHardCoderJNI.hcSendPicMsgDelay;
    int k = WXHardCoderJNI.hcSendPicMsgCPU;
    int m = WXHardCoderJNI.hcSendPicMsgIO;
    if (WXHardCoderJNI.hcSendPicMsgThr) {
      i = com.tencent.mm.kernel.g.RO().dtc();
    }
    i = WXHardCoderJNI.startPerformance(bool2, j, k, m, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
    aw.RO().ac(new SendImgProxyUI.1(this, bool1, i));
    AppMethodBeat.o(31004);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(31005);
    ab.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(31005);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(31006);
    ab.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onResume();
    AppMethodBeat.o(31006);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendImgProxyUI
 * JD-Core Version:    0.7.0.1
 */