package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI
  extends MMBaseActivity
{
  private static boolean Uz = false;
  private w rYw = null;
  
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
          long l = y.bEl(str);
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
  
  private static void m(ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1)
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
      Object localObject = r.bKa().wq(j);
      int k = (int)y.bEl((String)paramArrayList1.get(i));
      ((com.tencent.mm.modelimage.h)localObject).wj(k);
      ((com.tencent.mm.modelimage.h)localObject).wk(k);
      r.bKa().a(j, (com.tencent.mm.modelimage.h)localObject);
      long l = ((com.tencent.mm.modelimage.h)localObject).oGz;
      Log.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[] { Long.valueOf(l), Integer.valueOf(j) });
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l);
      ((cc)localObject).setStatus(5);
      ((cc)localObject).po(256);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(l, (cc)localObject);
      Log.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((fi)localObject).field_msgId), Long.valueOf(((fi)localObject).field_msgSvrId), ((fi)localObject).field_talker, Integer.valueOf(((cc)localObject).getType()), Integer.valueOf(((fi)localObject).field_isSend), ((fi)localObject).field_imgPath, Integer.valueOf(((fi)localObject).field_status), Long.valueOf(((cc)localObject).getCreateTime()) });
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
    aw.g(getWindow());
    Log.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[] { Boolean.valueOf(Uz), Integer.valueOf(hashCode()) });
    if (Uz)
    {
      Log.w("MicroMsg.SendImgProxyUI", "duplicate instance");
      finish();
      AppMethodBeat.o(34890);
      return;
    }
    Uz = true;
    setContentView(R.i.background_transparent);
    this.rYw = k.a(this, getString(R.l.gNp), false, null);
    final boolean bool1 = NetStatusUtil.isWifi(this);
    boolean bool2 = WXHardCoderJNI.hcSendPicMsgEnable;
    int j = WXHardCoderJNI.hcSendPicMsgDelay;
    int k = WXHardCoderJNI.hcSendPicMsgCPU;
    int m = WXHardCoderJNI.hcSendPicMsgIO;
    if (WXHardCoderJNI.hcSendPicMsgThr) {
      i = com.tencent.mm.kernel.h.baH().getProcessTid();
    }
    i = WXHardCoderJNI.startPerformance(bool2, j, k, m, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34889);
        Log.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
        SendImgProxyUI.a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(-1));
        bh.baH().setLowPriority();
        Log.i("MicroMsg.SendImgProxyUI", "test before finish");
        SendImgProxyUI.a(SendImgProxyUI.this).dismiss();
        SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", localArrayList));
        SendImgProxyUI.cth();
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
    Log.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[] { Boolean.valueOf(Uz), Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(34891);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34892);
    Log.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[] { Boolean.valueOf(Uz), Integer.valueOf(hashCode()) });
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