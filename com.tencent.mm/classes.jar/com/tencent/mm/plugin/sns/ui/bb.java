package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.b;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bb
{
  private Activity dKq;
  private List<cnb> list;
  
  public bb(Activity paramActivity)
  {
    AppMethodBeat.i(98728);
    this.list = new ArrayList();
    this.dKq = paramActivity;
    AppMethodBeat.o(98728);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, SnsInfo paramSnsInfo, bc parambc, int paramInt1, int paramInt2, ai paramai)
  {
    AppMethodBeat.i(203587);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
      AppMethodBeat.o(203587);
      return;
    }
    if (paramai == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
      AppMethodBeat.o(203587);
      return;
    }
    if (paramSnsInfo == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
      AppMethodBeat.o(203587);
      return;
    }
    com.tencent.mm.kernel.g.aAi();
    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
      AppMethodBeat.o(203587);
      return;
    }
    String str = parambc.dJX;
    int i = parambc.index;
    int j = parambc.position;
    parambc = paramSnsInfo.getTimeLine();
    if ((parambc.ContentObj == null) || (parambc.ContentObj.LoV.size() == 0))
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
      AppMethodBeat.o(203587);
      return;
    }
    paramai.fat().M(paramSnsInfo);
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    if (i < localTimeLineObject.ContentObj.LoV.size()) {}
    for (parambc = (cnb)localTimeLineObject.ContentObj.LoV.get(i); !aj.faL().C(parambc); parambc = new cnb())
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(parambc.ecf) });
      AppMethodBeat.o(203587);
      return;
    }
    if (paramInt1 == 1)
    {
      paramai = k.tO(716);
      paramai.PH(r.v(paramSnsInfo)).tR(paramSnsInfo.field_type).fL(paramSnsInfo.isAd()).PH(paramSnsInfo.getUxinfo()).PH(parambc.Id).tR(i).tR(localTimeLineObject.ContentObj.LoV.size());
      paramai.bfK();
      if (paramInt1 != 1) {
        break label630;
      }
      parambc = k.tO(744);
      label327:
      parambc.PH(r.v(paramSnsInfo)).tR(paramSnsInfo.field_type).fL(paramSnsInfo.isAd()).PH(paramSnsInfo.getUxinfo());
      parambc.b(paramIntent, "intent_key_StatisticsOplog");
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
      parambc = new Bundle();
      parambc.putInt("stat_scene", 3);
      parambc.putString("stat_msg_id", "sns_" + r.Jb(paramSnsInfo.field_snsId));
      parambc.putString("stat_send_msg_user", paramSnsInfo.getUserName());
      paramIntent.putExtra("_stat_obj", parambc);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramIntent.axQ(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(203587);
      return;
      paramai = k.tP(716);
      break;
      label630:
      parambc = k.tP(744);
      break label327;
      paramIntent.putExtra("key_from_scene", 1);
      continue;
      paramIntent.putExtra("key_from_scene", 2);
      continue;
      paramIntent.putExtra("key_from_scene", 3);
    }
  }
  
  private boolean fK(String paramString, int paramInt)
  {
    AppMethodBeat.i(98731);
    Object localObject = f.aQm(paramString);
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
    if (paramString.ContentObj.LoV.size() == 0)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      AppMethodBeat.o(98731);
      return false;
    }
    this.list.clear();
    paramString = paramString.ContentObj.LoV.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (cnb)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!aj.faL().C((cnb)localObject)))
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
  
  public final void a(View paramView, int paramInt1, int paramInt2, com.tencent.mm.plugin.sns.model.bc parambc, long paramLong)
  {
    AppMethodBeat.i(98730);
    if (paramView == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(98730);
      return;
    }
    Object localObject = paramView.getTag();
    bc localbc;
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
    if ((localObject instanceof bc))
    {
      localbc = (bc)localObject;
      str = localbc.dJX;
      i = localbc.index;
      j = localbc.position;
      if (!fK(str, i))
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
        AppMethodBeat.o(98730);
        return;
      }
      SnsInfo localSnsInfo = f.aQm(str);
      if (!fK(str, i))
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      localIntent = new Intent();
      if (localSnsInfo == null) {
        break label836;
      }
      if (parambc != null) {
        parambc.DMa.M(localSnsInfo);
      }
      TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
      if (localbc.index >= localTimeLineObject.ContentObj.LoV.size()) {
        break label802;
      }
      parambc = (cnb)localTimeLineObject.ContentObj.LoV.get(localbc.index);
      if (paramInt1 != 1) {
        break label814;
      }
      localObject = k.tO(716);
      ((k)localObject).PH(r.v(localSnsInfo)).tR(localSnsInfo.field_type).fL(localSnsInfo.isAd()).PH(localSnsInfo.getUxinfo()).PH(parambc.Id).tR(localbc.index).tR(localTimeLineObject.ContentObj.LoV.size());
      ((k)localObject).bfK();
      if (paramInt1 != 1) {
        break label825;
      }
      parambc = k.tO(744);
      parambc.PH(r.v(localSnsInfo)).tR(localSnsInfo.field_type).fL(localSnsInfo.isAd()).PH(localSnsInfo.getUxinfo());
      parambc.b(localIntent, "intent_key_StatisticsOplog");
      parambc = new Bundle();
      parambc.putInt("stat_scene", 3);
      parambc.putString("stat_msg_id", "sns_" + r.Jb(localSnsInfo.field_snsId));
      parambc.putString("stat_send_msg_user", localSnsInfo.getUserName());
      localIntent.putExtra("_stat_obj", parambc);
      parambc = new int[2];
      if (!ao.gJK()) {
        break label846;
      }
      paramView.getLocationOnScreen(parambc);
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
      localIntent.putExtra("k_is_from_sns_main_timeline", localbc.EAv);
      localIntent.putExtra("sns_gallery_thumb_location", new Rect(parambc[0], parambc[1], k + parambc[0], parambc[1] + m));
      localIntent.putExtra("sns_ad_exposure_start_time", paramLong);
      localIntent.setClass(this.dKq, SnsBrowseUI.class);
      paramView = this.dKq;
      parambc = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, parambc.axQ(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)parambc.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.dKq.overridePendingTransition(0, 0);
      AppMethodBeat.o(98730);
      return;
      label802:
      parambc = new cnb();
      break;
      label814:
      localObject = k.tP(716);
      break label288;
      label825:
      parambc = k.tP(744);
      break label372;
      label836:
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
      break label487;
      label846:
      paramView.getLocationInWindow(parambc);
      break label504;
      localIntent.putExtra("key_from_scene", 1);
      continue;
      localIntent.putExtra("key_from_scene", 2);
      continue;
      localIntent.putExtra("key_from_scene", 3);
    }
  }
  
  final void v(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98729);
    a(paramView, paramInt1, paramInt2, null, 0L);
    AppMethodBeat.o(98729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bb
 * JD-Core Version:    0.7.0.1
 */