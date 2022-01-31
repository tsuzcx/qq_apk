package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class an
{
  private Activity bMV;
  private List<awd> list = new ArrayList();
  
  public an(Activity paramActivity)
  {
    this.bMV = paramActivity;
  }
  
  private boolean cy(String paramString, int paramInt)
  {
    Object localObject = h.OB(paramString);
    if (localObject == null)
    {
      y.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[] { paramString, Integer.valueOf(paramInt) });
      return false;
    }
    paramString = ((n)localObject).bGe();
    if (paramString.tNr == null)
    {
      y.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
      return false;
    }
    if (paramString.tNr.sPJ.size() == 0)
    {
      y.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      return false;
    }
    this.list.clear();
    paramString = paramString.tNr.sPJ.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (awd)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!af.bDC().B((awd)localObject)))
      {
        y.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, au paramau)
  {
    if (paramView == null) {
      y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
    }
    Object localObject;
    do
    {
      return;
      localObject = paramView.getTag();
    } while (!(localObject instanceof ao));
    ao localao = (ao)localObject;
    String str = localao.bMB;
    int i = localao.index;
    int j = localao.position;
    if (!cy(str, i))
    {
      y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
      return;
    }
    com.tencent.mm.kernel.g.DQ();
    if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
    {
      y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
      return;
    }
    n localn = h.OB(str);
    if (!cy(str, i))
    {
      y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
      return;
    }
    Intent localIntent = new Intent();
    if (localn != null)
    {
      if (paramau != null) {
        paramau.ota.y(localn);
      }
      bxk localbxk = localn.bGe();
      if (localao.index < localbxk.tNr.sPJ.size())
      {
        paramau = (awd)localbxk.tNr.sPJ.get(localao.index);
        if (paramInt1 != 1) {
          break label664;
        }
        localObject = com.tencent.mm.modelsns.b.jd(716);
        label254:
        ((com.tencent.mm.modelsns.b)localObject).ni(i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM()).ni(paramau.lsK).jg(localao.index).jg(localbxk.tNr.sPJ.size());
        ((com.tencent.mm.modelsns.b)localObject).QX();
        if (paramInt1 != 1) {
          break label675;
        }
        paramau = com.tencent.mm.modelsns.b.jd(744);
        label340:
        paramau.ni(i.j(localn)).jg(localn.field_type).cb(localn.yr(32)).ni(localn.bGM());
        paramau.b(localIntent, "intent_key_StatisticsOplog");
        paramau = new Bundle();
        paramau.putInt("stat_scene", 3);
        paramau.putString("stat_msg_id", "sns_" + i.fN(localn.field_snsId));
        paramau.putString("stat_send_msg_user", localn.field_userName);
        localIntent.putExtra("_stat_obj", paramau);
      }
    }
    for (;;)
    {
      paramau = new int[2];
      paramView.getLocationInWindow(paramau);
      int k = paramView.getWidth();
      int m = paramView.getHeight();
      if (paramInt1 == -1) {
        localIntent.putExtra("k_is_from_sns_msg_ui", true);
      }
      localIntent.putExtra("sns_gallery_localId", str);
      localIntent.putExtra("sns_gallery_position", i);
      localIntent.putExtra("sns_position", j);
      localIntent.putExtra("sns_gallery_showtype", 1);
      localIntent.putExtra("K_ad_scene", paramInt1);
      localIntent.putExtra("K_ad_source", paramInt2);
      localIntent.putExtra("k_is_from_sns_main_timeline", localao.oVB);
      localIntent.putExtra("img_gallery_left", paramau[0]);
      localIntent.putExtra("img_gallery_top", paramau[1]);
      localIntent.putExtra("img_gallery_width", k);
      localIntent.putExtra("img_gallery_height", m);
      localIntent.setClass(this.bMV, SnsBrowseUI.class);
      this.bMV.startActivity(localIntent);
      this.bMV.overridePendingTransition(0, 0);
      return;
      paramau = new awd();
      break;
      label664:
      localObject = com.tencent.mm.modelsns.b.je(716);
      break label254;
      label675:
      paramau = com.tencent.mm.modelsns.b.je(744);
      break label340;
      y.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
    }
  }
  
  public final void l(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.an
 * JD-Core Version:    0.7.0.1
 */