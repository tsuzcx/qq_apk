package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.d;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class bd
{
  private Activity fDf;
  private List<cvt> list;
  
  public bd(Activity paramActivity)
  {
    AppMethodBeat.i(98728);
    this.list = new ArrayList();
    this.fDf = paramActivity;
    AppMethodBeat.o(98728);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, SnsInfo paramSnsInfo, be parambe, int paramInt1, int paramInt2, ai paramai)
  {
    AppMethodBeat.i(269968);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
      AppMethodBeat.o(269968);
      return;
    }
    if (paramai == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
      AppMethodBeat.o(269968);
      return;
    }
    if (paramSnsInfo == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
      AppMethodBeat.o(269968);
      return;
    }
    h.aHH();
    if (!h.aHG().isSDCardAvailable())
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
      AppMethodBeat.o(269968);
      return;
    }
    String str = parambe.fCM;
    int i = parambe.index;
    int j = parambe.position;
    parambe = paramSnsInfo.getTimeLine();
    if ((parambe.ContentObj == null) || (parambe.ContentObj.Sqr.size() == 0))
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
      AppMethodBeat.o(269968);
      return;
    }
    paramai.fOn().N(paramSnsInfo);
    TimeLineObject localTimeLineObject = paramSnsInfo.getTimeLine();
    if (i < localTimeLineObject.ContentObj.Sqr.size()) {}
    for (parambe = (cvt)localTimeLineObject.ContentObj.Sqr.get(i); !aj.fOF().C(parambe); parambe = new cvt())
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[] { Integer.valueOf(parambe.fWh) });
      AppMethodBeat.o(269968);
      return;
    }
    if (paramInt1 == 1)
    {
      paramai = l.wO(716);
      paramai.Xf(t.w(paramSnsInfo)).wR(paramSnsInfo.field_type).gx(paramSnsInfo.isAd()).Xf(paramSnsInfo.getUxinfo()).Xf(parambe.Id).wR(i).wR(localTimeLineObject.ContentObj.Sqr.size());
      paramai.bpa();
      if (paramInt1 != 1) {
        break label630;
      }
      parambe = l.wO(744);
      label327:
      parambe.Xf(t.w(paramSnsInfo)).wR(paramSnsInfo.field_type).gx(paramSnsInfo.isAd()).Xf(paramSnsInfo.getUxinfo());
      parambe.b(paramIntent, "intent_key_StatisticsOplog");
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
      parambe = new Bundle();
      parambe.putInt("stat_scene", 3);
      parambe.putString("stat_msg_id", "sns_" + t.Qu(paramSnsInfo.field_snsId));
      parambe.putString("stat_send_msg_user", paramSnsInfo.getUserName());
      paramIntent.putExtra("_stat_obj", parambe);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramIntent.aFh(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/ui/SnsImageViewTag;IILcom/tencent/mm/plugin/sns/model/SnsContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(269968);
      return;
      paramai = l.wP(716);
      break;
      label630:
      parambe = l.wP(744);
      break label327;
      paramIntent.putExtra("key_from_scene", 1);
      continue;
      paramIntent.putExtra("key_from_scene", 2);
      continue;
      paramIntent.putExtra("key_from_scene", 3);
    }
  }
  
  private boolean go(String paramString, int paramInt)
  {
    AppMethodBeat.i(98731);
    Object localObject = com.tencent.mm.plugin.sns.storage.f.bbl(paramString);
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
    if (paramString.ContentObj.Sqr.size() == 0)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      AppMethodBeat.o(98731);
      return false;
    }
    this.list.clear();
    paramString = paramString.ContentObj.Sqr.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (cvt)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!aj.fOF().C((cvt)localObject)))
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
  
  public final void a(View paramView, int paramInt1, int paramInt2, bb parambb, long paramLong)
  {
    AppMethodBeat.i(98730);
    if (paramView == null)
    {
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(98730);
      return;
    }
    Object localObject = paramView.getTag();
    be localbe;
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
    if ((localObject instanceof be))
    {
      localbe = (be)localObject;
      str = localbe.fCM;
      i = localbe.index;
      j = localbe.position;
      if (!go(str, i))
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      h.aHH();
      if (!h.aHG().isSDCardAvailable())
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
        AppMethodBeat.o(98730);
        return;
      }
      SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.storage.f.bbl(str);
      if (!go(str, i))
      {
        Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      localIntent = new Intent();
      if (localSnsInfo == null) {
        break label836;
      }
      if (parambb != null) {
        parambb.JZd.N(localSnsInfo);
      }
      TimeLineObject localTimeLineObject = localSnsInfo.getTimeLine();
      if (localbe.index >= localTimeLineObject.ContentObj.Sqr.size()) {
        break label802;
      }
      parambb = (cvt)localTimeLineObject.ContentObj.Sqr.get(localbe.index);
      if (paramInt1 != 1) {
        break label814;
      }
      localObject = l.wO(716);
      ((l)localObject).Xf(t.w(localSnsInfo)).wR(localSnsInfo.field_type).gx(localSnsInfo.isAd()).Xf(localSnsInfo.getUxinfo()).Xf(parambb.Id).wR(localbe.index).wR(localTimeLineObject.ContentObj.Sqr.size());
      ((l)localObject).bpa();
      if (paramInt1 != 1) {
        break label825;
      }
      parambb = l.wO(744);
      parambb.Xf(t.w(localSnsInfo)).wR(localSnsInfo.field_type).gx(localSnsInfo.isAd()).Xf(localSnsInfo.getUxinfo());
      parambb.b(localIntent, "intent_key_StatisticsOplog");
      parambb = new Bundle();
      parambb.putInt("stat_scene", 3);
      parambb.putString("stat_msg_id", "sns_" + t.Qu(localSnsInfo.field_snsId));
      parambb.putString("stat_send_msg_user", localSnsInfo.getUserName());
      localIntent.putExtra("_stat_obj", parambb);
      parambb = new int[2];
      if (!ar.hIH()) {
        break label846;
      }
      paramView.getLocationOnScreen(parambb);
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
      localIntent.putExtra("k_is_from_sns_main_timeline", localbe.KOn);
      localIntent.putExtra("sns_gallery_thumb_location", new Rect(parambb[0], parambb[1], k + parambb[0], parambb[1] + m));
      localIntent.putExtra("sns_ad_exposure_start_time", paramLong);
      localIntent.setClass(this.fDf, SnsBrowseUI.class);
      paramView = this.fDf;
      parambb = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, parambb.aFh(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)parambb.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.fDf.overridePendingTransition(0, 0);
      AppMethodBeat.o(98730);
      return;
      label802:
      parambb = new cvt();
      break;
      label814:
      localObject = l.wP(716);
      break label288;
      label825:
      parambb = l.wP(744);
      break label372;
      label836:
      Log.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
      break label487;
      label846:
      paramView.getLocationInWindow(parambb);
      break label504;
      localIntent.putExtra("key_from_scene", 1);
      continue;
      localIntent.putExtra("key_from_scene", 2);
      continue;
      localIntent.putExtra("key_from_scene", 3);
    }
  }
  
  final void x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98729);
    a(paramView, paramInt1, paramInt2, null, 0L);
    AppMethodBeat.o(98729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd
 * JD-Core Version:    0.7.0.1
 */