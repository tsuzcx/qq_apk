package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI
  extends MMBaseActivity
{
  private static boolean isRunning = false;
  private p mHs = null;
  
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
        if (u.aRF(str))
        {
          long l = o.aZR(str);
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
      ae.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
      AppMethodBeat.o(34894);
      return;
    }
    int i = 0;
    while (i < paramArrayList1.size())
    {
      int j = ((Integer)paramArrayList.get(i)).intValue();
      Object localObject = q.aIX().pw(j);
      int k = (int)o.aZR((String)paramArrayList1.get(i));
      ((com.tencent.mm.av.g)localObject).setOffset(k);
      ((com.tencent.mm.av.g)localObject).pq(k);
      q.aIX().a(j, (com.tencent.mm.av.g)localObject);
      long l = ((com.tencent.mm.av.g)localObject).icx;
      ae.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[] { Long.valueOf(l), Integer.valueOf(j) });
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(l);
      ((bv)localObject).setStatus(5);
      ((bv)localObject).ka(256);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(l, (bv)localObject);
      ae.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), ((ei)localObject).field_talker, Integer.valueOf(((bv)localObject).getType()), Integer.valueOf(((ei)localObject).field_isSend), ((ei)localObject).field_imgPath, Integer.valueOf(((ei)localObject).field_status), Long.valueOf(((ei)localObject).field_createTime) });
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
    al.b(getWindow());
    ae.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    if (isRunning)
    {
      ae.w("MicroMsg.SendImgProxyUI", "duplicate instance");
      finish();
      AppMethodBeat.o(34890);
      return;
    }
    isRunning = true;
    setContentView(2131493128);
    this.mHs = h.b(this, getString(2131761075), false, null);
    final boolean bool1 = az.isWifi(this);
    boolean bool2 = WXHardCoderJNI.hcSendPicMsgEnable;
    int j = WXHardCoderJNI.hcSendPicMsgDelay;
    int k = WXHardCoderJNI.hcSendPicMsgCPU;
    int m = WXHardCoderJNI.hcSendPicMsgIO;
    if (WXHardCoderJNI.hcSendPicMsgThr) {
      i = com.tencent.mm.kernel.g.ajU().foN();
    }
    i = WXHardCoderJNI.startPerformance(bool2, j, k, m, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34889);
        ae.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
        SendImgProxyUI.a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(-1));
        bc.ajU().foO();
        ae.i("MicroMsg.SendImgProxyUI", "test before finish");
        SendImgProxyUI.a(SendImgProxyUI.this).dismiss();
        SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", localArrayList));
        SendImgProxyUI.bAv();
        SendImgProxyUI.this.finish();
        if (az.isWifi(SendImgProxyUI.this) == bool1) {
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
    ae.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(34891);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34892);
    ae.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
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