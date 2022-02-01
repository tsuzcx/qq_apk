package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;

public class SendImgProxyUI
  extends MMBaseActivity
{
  private static boolean isRunning = false;
  private p mCn = null;
  
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
        if (t.aQi(str))
        {
          long l = com.tencent.mm.vfs.i.aYo(str);
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
      ad.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
      AppMethodBeat.o(34894);
      return;
    }
    int i = 0;
    while (i < paramArrayList1.size())
    {
      int j = ((Integer)paramArrayList.get(i)).intValue();
      Object localObject = q.aIF().pt(j);
      int k = (int)com.tencent.mm.vfs.i.aYo((String)paramArrayList1.get(i));
      ((com.tencent.mm.aw.g)localObject).setOffset(k);
      ((com.tencent.mm.aw.g)localObject).pn(k);
      q.aIF().a(j, (com.tencent.mm.aw.g)localObject);
      long l = ((com.tencent.mm.aw.g)localObject).hZF;
      ad.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[] { Long.valueOf(l), Integer.valueOf(j) });
      localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(l);
      ((bu)localObject).setStatus(5);
      ((bu)localObject).jY(256);
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(l, (bu)localObject);
      ad.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(((ei)localObject).field_msgSvrId), ((ei)localObject).field_talker, Integer.valueOf(((bu)localObject).getType()), Integer.valueOf(((ei)localObject).field_isSend), ((ei)localObject).field_imgPath, Integer.valueOf(((ei)localObject).field_status), Long.valueOf(((ei)localObject).field_createTime) });
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
    ad.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    if (isRunning)
    {
      ad.w("MicroMsg.SendImgProxyUI", "duplicate instance");
      finish();
      AppMethodBeat.o(34890);
      return;
    }
    isRunning = true;
    setContentView(2131493128);
    this.mCn = h.b(this, getString(2131761075), false, null);
    final boolean bool1 = ay.isWifi(this);
    boolean bool2 = WXHardCoderJNI.hcSendPicMsgEnable;
    int j = WXHardCoderJNI.hcSendPicMsgDelay;
    int k = WXHardCoderJNI.hcSendPicMsgCPU;
    int m = WXHardCoderJNI.hcSendPicMsgIO;
    if (WXHardCoderJNI.hcSendPicMsgThr) {
      i = com.tencent.mm.kernel.g.ajF().fkS();
    }
    i = WXHardCoderJNI.startPerformance(bool2, j, k, m, i, WXHardCoderJNI.hcSendPicMsgTimeout, 203, WXHardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34889);
        ad.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
        SendImgProxyUI.a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(-1));
        ba.ajF().fkT();
        ad.i("MicroMsg.SendImgProxyUI", "test before finish");
        SendImgProxyUI.a(SendImgProxyUI.this).dismiss();
        SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", localArrayList));
        SendImgProxyUI.bzA();
        SendImgProxyUI.this.finish();
        if (ay.isWifi(SendImgProxyUI.this) == bool1) {
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
    ad.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
    super.onDestroy();
    AppMethodBeat.o(34891);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34892);
    ad.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[] { Boolean.valueOf(isRunning), Integer.valueOf(hashCode()) });
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