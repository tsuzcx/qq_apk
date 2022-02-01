package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.statistics.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class be
{
  private Activity hHU;
  private List<dmz> list;
  
  public be(Activity paramActivity)
  {
    AppMethodBeat.i(98728);
    this.list = new ArrayList();
    this.hHU = paramActivity;
    AppMethodBeat.o(98728);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, SnsInfo paramSnsInfo, bf parambf, int paramInt1, int paramInt2, ak paramak)
  {
    AppMethodBeat.i(308372);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
      AppMethodBeat.o(308372);
      return;
    }
    if (paramak == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
      AppMethodBeat.o(308372);
      return;
    }
    if (paramSnsInfo == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
      AppMethodBeat.o(308372);
      return;
    }
    h.baF();
    if (!h.baE().isSDCardAvailable())
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
      AppMethodBeat.o(308372);
      return;
    }
    String str = parambf.hHB;
    int i = parambf.index;
    int j = parambf.position;
    parambf = paramSnsInfo.getTimeLine();
    if ((parambf.ContentObj == null) || (parambf.ContentObj.Zpr.size() == 0))
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
      AppMethodBeat.o(308372);
      return;
    }
    paramak.hgf().P(paramSnsInfo);
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    if (i < localTimeLineObject.ContentObj.Zpr.size()) {}
    for (parambf = (dmz)localTimeLineObject.ContentObj.Zpr.get(i); !al.hgy().C(parambf); parambf = new dmz())
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(parambf.icg) });
      AppMethodBeat.o(308372);
      return;
    }
    if (paramInt1 == 1)
    {
      paramak = com.tencent.mm.modelsns.l.wO(716);
      paramak.Ph(t.x(paramSnsInfo)).wR(paramSnsInfo.field_type).hm(paramSnsInfo.isAd()).Ph(paramSnsInfo.getUxinfo()).Ph(parambf.Id).wR(i).wR(localTimeLineObject.ContentObj.Zpr.size());
      paramak.bMH();
      if (paramInt1 != 1) {
        break label630;
      }
      parambf = com.tencent.mm.modelsns.l.wO(744);
      label327:
      parambf.Ph(t.x(paramSnsInfo)).wR(paramSnsInfo.field_type).hm(paramSnsInfo.isAd()).Ph(paramSnsInfo.getUxinfo());
      parambf.b(paramIntent, "intent_key_StatisticsOplog");
      paramIntent.putExtra("sns_soon_enter_photoedit_ui", true);
      paramIntent.putExtra("sns_gallery_localId", str);
      paramIntent.putExtra("sns_gallery_position", i);
      paramIntent.putExtra("sns_position", j);
      paramIntent.putExtra("sns_gallery_showtype", 1);
      paramIntent.putExtra("K_ad_scene", paramInt1);
      paramIntent.putExtra("K_ad_source", paramInt2);
      paramIntent.putExtra("k_is_from_sns_main_timeline", true);
      paramIntent.setClass(paramActivity, SnsBrowseUI.class);
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      parambf = new Bundle();
      parambf.putInt("stat_scene", 3);
      parambf.putString("stat_msg_id", "sns_" + t.uA(paramSnsInfo.field_snsId));
      parambf.putString("stat_send_msg_user", paramSnsInfo.getUserName());
      paramIntent.putExtra("_stat_obj", parambf);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aYi(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(308372);
      return;
      paramak = com.tencent.mm.modelsns.l.wP(716);
      break;
      label630:
      parambf = com.tencent.mm.modelsns.l.wP(744);
      break label327;
      paramIntent.putExtra("key_from_scene", 1);
      continue;
      paramIntent.putExtra("key_from_scene", 2);
      continue;
      paramIntent.putExtra("key_from_scene", 3);
    }
  }
  
  private boolean hi(String paramString, int paramInt)
  {
    AppMethodBeat.i(98731);
    Object localObject = com.tencent.mm.plugin.sns.storage.l.aZL(paramString);
    if (localObject == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(98731);
      return false;
    }
    paramString = ((SnsInfo)localObject).getTimeLine();
    if (paramString.ContentObj == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
      AppMethodBeat.o(98731);
      return false;
    }
    if (paramString.ContentObj.Zpr.size() == 0)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      AppMethodBeat.o(98731);
      return false;
    }
    this.list.clear();
    paramString = paramString.ContentObj.Zpr.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (dmz)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!al.hgy().C((dmz)localObject)))
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
        AppMethodBeat.o(98731);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98731);
    return true;
  }
  
  final void C(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98729);
    a(paramView, paramInt1, paramInt2, null, 0L);
    AppMethodBeat.o(98729);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, bd parambd, long paramLong)
  {
    AppMethodBeat.i(98730);
    if (paramView == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(98730);
      return;
    }
    Object localObject = paramView.getTag();
    bf localbf;
    String str;
    int i;
    int j;
    Intent localIntent;
    label288:
    label372:
    label504:
    int k;
    label487:
    int m;
    if ((localObject instanceof bf))
    {
      localbf = (bf)localObject;
      str = localbf.hHB;
      i = localbf.index;
      j = localbf.position;
      if (!hi(str, i))
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      h.baF();
      if (!h.baE().isSDCardAvailable())
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
        AppMethodBeat.o(98730);
        return;
      }
      SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.storage.l.aZL(str);
      if (!hi(str, i))
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      localIntent = new Intent();
      if (localSnsInfo == null) {
        break label836;
      }
      if (parambd != null) {
        parambd.Qwn.P(localSnsInfo);
      }
      TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
      if (localbf.index >= localTimeLineObject.ContentObj.Zpr.size()) {
        break label802;
      }
      parambd = (dmz)localTimeLineObject.ContentObj.Zpr.get(localbf.index);
      if (paramInt1 != 1) {
        break label814;
      }
      localObject = com.tencent.mm.modelsns.l.wO(716);
      ((com.tencent.mm.modelsns.l)localObject).Ph(t.x(localSnsInfo)).wR(localSnsInfo.field_type).hm(localSnsInfo.isAd()).Ph(localSnsInfo.getUxinfo()).Ph(parambd.Id).wR(localbf.index).wR(localTimeLineObject.ContentObj.Zpr.size());
      ((com.tencent.mm.modelsns.l)localObject).bMH();
      if (paramInt1 != 1) {
        break label825;
      }
      parambd = com.tencent.mm.modelsns.l.wO(744);
      parambd.Ph(t.x(localSnsInfo)).wR(localSnsInfo.field_type).hm(localSnsInfo.isAd()).Ph(localSnsInfo.getUxinfo());
      parambd.b(localIntent, "intent_key_StatisticsOplog");
      parambd = new Bundle();
      parambd.putInt("stat_scene", 3);
      parambd.putString("stat_msg_id", "sns_" + t.uA(localSnsInfo.field_snsId));
      parambd.putString("stat_send_msg_user", localSnsInfo.getUserName());
      localIntent.putExtra("_stat_obj", parambd);
      parambd = new int[2];
      if (!aw.jkS()) {
        break label846;
      }
      paramView.getLocationOnScreen(parambd);
      k = paramView.getWidth();
      m = paramView.getHeight();
      if (paramInt1 == -1) {
        localIntent.putExtra("k_is_from_sns_msg_ui", true);
      }
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      localIntent.putExtra("sns_gallery_localId", str);
      localIntent.putExtra("sns_gallery_position", i);
      localIntent.putExtra("sns_position", j);
      localIntent.putExtra("sns_gallery_showtype", 1);
      localIntent.putExtra("K_ad_scene", paramInt1);
      localIntent.putExtra("K_source", paramInt1);
      localIntent.putExtra("K_ad_source", paramInt2);
      localIntent.putExtra("k_is_from_sns_main_timeline", localbf.Roa);
      localIntent.putExtra("sns_gallery_thumb_location", new Rect(parambd[0], parambd[1], k + parambd[0], parambd[1] + m));
      localIntent.putExtra("sns_ad_exposure_start_time", paramLong);
      localIntent.setClass(this.hHU, SnsBrowseUI.class);
      paramView = this.hHU;
      parambd = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, parambd.aYi(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)parambd.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.hHU.overridePendingTransition(0, 0);
      AppMethodBeat.o(98730);
      return;
      label802:
      parambd = new dmz();
      break;
      label814:
      localObject = com.tencent.mm.modelsns.l.wP(716);
      break label288;
      label825:
      parambd = com.tencent.mm.modelsns.l.wP(744);
      break label372;
      label836:
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
      break label487;
      label846:
      paramView.getLocationInWindow(parambd);
      break label504;
      localIntent.putExtra("key_from_scene", 1);
      continue;
      localIntent.putExtra("key_from_scene", 2);
      continue;
      localIntent.putExtra("key_from_scene", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be
 * JD-Core Version:    0.7.0.1
 */