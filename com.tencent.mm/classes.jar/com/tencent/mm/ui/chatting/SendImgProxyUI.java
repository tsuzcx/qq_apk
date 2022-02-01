package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI
  extends MMBaseActivity
{
  private static boolean isRunning = false;
  private p mcf = null;
  
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
        if (s.aKC(str))
        {
          long l = i.aSp(str);
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
  
  private static void g(ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1)
  {
    AppMethodBeat.i(34894);
    if (paramArrayList.size() != paramArrayList1.size())
    {
      ac.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
      AppMethodBeat.o(34894);
      return;
    }
    int i = 0;
    while (i < paramArrayList1.size())
    {
      int j = ((Integer)paramArrayList.get(i)).intValue();
      Object localObject = o.aFx().oR(j);
      int k = (int)i.aSp((String)paramArrayList1.get(i));
      ((e)localObject).setOffset(k);
      ((e)localObject).oL(k);
      o.aFx().a(j, (e)localObject);
      long l = ((e)localObject).hGV;
      ac.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[] { Long.valueOf(l), Integer.valueOf(j) });
      localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(l);
      ((bo)localObject).setStatus(5);
      ((bo)localObject).jA(256);
      ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(l, (bo)localObject);
      ac.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((dy)localObject).field_msgId), Long.valueOf(((dy)localObject).field_msgSvrId), ((dy)localObject).field_talker, Integer.valueOf(((bo)localObject).getType()), Integer.valueOf(((dy)localObject).field_isSend), ((dy)localObject).field_imgPath, Integer.valueOf(((dy)localObject).field_status), Long.valueOf(((dy)localObject).field_createTime) });
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
    aj.b(getWindow());
    ac.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    if (isRunning)
    {
      ac.w("MicroMsg.SendImgProxyUI", "duplicate instance");
      finish();
      AppMethodBeat.o(34890);
      return;
    }
    isRunning = true;
    setContentView(2131493128);
    this.mcf = com.tencent.mm.ui.base.h.b(this, getString(2131761075), false, null);
    final boolean bool1 = ax.isWifi(this);
    boolean bool2 = WXHardCoderJNI.hcSendPicMsgEnable;
    int j = WXHardCoderJNI.hcSendPicMsgDelay;
    int k = WXHardCoderJNI.hcSendPicMsgCPU;
    int m = WXHardCoderJNI.hcSendPicMsgIO;
    if (WXHardCoderJNI.hcSendPicMsgThr) {
      i = com.tencent.mm.kernel.g.agU().eVl();
    }
    i = WXHardCoderJNI.startPerformance(bool2, j, k, m, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34889);
        ac.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
        SendImgProxyUI.a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(-1));
        az.agU().eVm();
        ac.i("MicroMsg.SendImgProxyUI", "test before finish");
        SendImgProxyUI.a(SendImgProxyUI.this).dismiss();
        SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", localArrayList));
        SendImgProxyUI.bvu();
        SendImgProxyUI.this.finish();
        if (ax.isWifi(SendImgProxyUI.this) == bool1) {
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
    ac.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(34891);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34892);
    ac.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onResume();
    AppMethodBeat.o(34892);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.SendImgProxyUI
 * JD-Core Version:    0.7.0.1
 */