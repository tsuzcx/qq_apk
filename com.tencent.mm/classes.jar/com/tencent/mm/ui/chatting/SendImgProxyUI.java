package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI
  extends MMBaseActivity
{
  private static boolean isRunning = false;
  private s oTk = null;
  
  private static ArrayList<String> a(ArrayList<String> paramArrayList1, int paramInt, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    AppMethodBeat.i(34893);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList1 != null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        String str = (String)paramArrayList1.next();
        if (ImgUtil.isImgFile(str))
        {
          long l = u.bBQ(str);
          if ((!paramBoolean) && (l > paramInt)) {
            paramArrayList2.add(str);
          } else {
            localArrayList.add(str);
          }
        }
      }
    }
    AppMethodBeat.o(34893);
    return localArrayList;
  }
  
  private static void j(ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1)
  {
    AppMethodBeat.i(34894);
    if (paramArrayList.size() != paramArrayList1.size())
    {
      Log.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
      AppMethodBeat.o(34894);
      return;
    }
    int i = 0;
    while (i < paramArrayList1.size())
    {
      int j = ((Integer)paramArrayList.get(i)).intValue();
      Object localObject = q.bmh().wl(j);
      int k = (int)u.bBQ((String)paramArrayList1.get(i));
      ((g)localObject).we(k);
      ((g)localObject).wf(k);
      q.bmh().a(j, (g)localObject);
      long l = ((g)localObject).lNP;
      Log.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[] { Long.valueOf(l), Integer.valueOf(j) });
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(l);
      ((ca)localObject).setStatus(5);
      ((ca)localObject).pp(256);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(l, (ca)localObject);
      Log.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((et)localObject).field_msgId), Long.valueOf(((et)localObject).field_msgSvrId), ((et)localObject).field_talker, Integer.valueOf(((ca)localObject).getType()), Integer.valueOf(((et)localObject).field_isSend), ((et)localObject).field_imgPath, Integer.valueOf(((et)localObject).field_status), Long.valueOf(((et)localObject).field_createTime) });
      i += 1;
    }
    AppMethodBeat.o(34894);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    final int i = 0;
    AppMethodBeat.i(34890);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    ar.e(getWindow());
    Log.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    if (isRunning)
    {
      Log.w("MicroMsg.SendImgProxyUI", "duplicate instance");
      finish();
      AppMethodBeat.o(34890);
      return;
    }
    isRunning = true;
    setContentView(R.i.background_transparent);
    this.oTk = com.tencent.mm.ui.base.h.a(this, getString(R.l.eLv), false, null);
    final boolean bool1 = NetStatusUtil.isWifi(this);
    boolean bool2 = WXHardCoderJNI.hcSendPicMsgEnable;
    int j = WXHardCoderJNI.hcSendPicMsgDelay;
    int k = WXHardCoderJNI.hcSendPicMsgCPU;
    int m = WXHardCoderJNI.hcSendPicMsgIO;
    if (WXHardCoderJNI.hcSendPicMsgThr) {
      i = com.tencent.mm.kernel.h.aHJ().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool2, j, k, m, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34889);
        Log.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
        SendImgProxyUI.a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(-1));
        bh.aHJ().setLowPriority();
        Log.i("MicroMsg.SendImgProxyUI", "test before finish");
        SendImgProxyUI.a(SendImgProxyUI.this).dismiss();
        SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", localArrayList));
        SendImgProxyUI.cjY();
        SendImgProxyUI.this.finish();
        if (NetStatusUtil.isWifi(SendImgProxyUI.this) == bool1) {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendPicMsgEnable, i);
        }
        AppMethodBeat.o(34889);
      }
    });
    AppMethodBeat.o(34890);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34891);
    Log.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(34891);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34892);
    Log.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onResume();
    AppMethodBeat.o(34892);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendImgProxyUI
 * JD-Core Version:    0.7.0.1
 */