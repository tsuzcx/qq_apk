package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ay
{
  private Activity dsa;
  private List<byn> list;
  
  public ay(Activity paramActivity)
  {
    AppMethodBeat.i(98728);
    this.list = new ArrayList();
    this.dsa = paramActivity;
    AppMethodBeat.o(98728);
  }
  
  private boolean fd(String paramString, int paramInt)
  {
    AppMethodBeat.i(98731);
    Object localObject = h.aAa(paramString);
    if (localObject == null)
    {
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(98731);
      return false;
    }
    paramString = ((p)localObject).dYl();
    if (paramString.HAT == null)
    {
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
      AppMethodBeat.o(98731);
      return false;
    }
    if (paramString.HAT.GaQ.size() == 0)
    {
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      AppMethodBeat.o(98731);
      return false;
    }
    this.list.clear();
    paramString = paramString.HAT.GaQ.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (byn)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!ag.dUb().B((byn)localObject)))
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
        AppMethodBeat.o(98731);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98731);
    return true;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, com.tencent.mm.plugin.sns.model.az paramaz, long paramLong)
  {
    AppMethodBeat.i(98730);
    if (paramView == null)
    {
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(98730);
      return;
    }
    Object localObject = paramView.getTag();
    az localaz;
    String str;
    int i;
    int j;
    Intent localIntent;
    if ((localObject instanceof az))
    {
      localaz = (az)localObject;
      str = localaz.drH;
      i = localaz.index;
      j = localaz.position;
      if (!fd(str, i))
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      g.ajD();
      if (!g.ajC().isSDCardAvailable())
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
        AppMethodBeat.o(98730);
        return;
      }
      p localp = h.aAa(str);
      if (!fd(str, i))
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      localIntent = new Intent();
      if (localp == null) {
        break label799;
      }
      if (paramaz != null) {
        paramaz.zkL.F(localp);
      }
      TimeLineObject localTimeLineObject = localp.dYl();
      if (localaz.index >= localTimeLineObject.HAT.GaQ.size()) {
        break label765;
      }
      paramaz = (byn)localTimeLineObject.HAT.GaQ.get(localaz.index);
      if (paramInt1 != 1) {
        break label777;
      }
      localObject = com.tencent.mm.modelsns.e.pV(716);
      label279:
      ((com.tencent.mm.modelsns.e)localObject).Gs(q.n(localp)).pY(localp.field_type).eS(localp.QM(32)).Gs(localp.dYT()).Gs(paramaz.Id).pY(localaz.index).pY(localTimeLineObject.HAT.GaQ.size());
      ((com.tencent.mm.modelsns.e)localObject).aLk();
      if (paramInt1 != 1) {
        break label788;
      }
      paramaz = com.tencent.mm.modelsns.e.pV(744);
      label365:
      paramaz.Gs(q.n(localp)).pY(localp.field_type).eS(localp.QM(32)).Gs(localp.dYT());
      paramaz.b(localIntent, "intent_key_StatisticsOplog");
      paramaz = new Bundle();
      paramaz.putInt("stat_scene", 3);
      paramaz.putString("stat_msg_id", "sns_" + q.zw(localp.field_snsId));
      paramaz.putString("stat_send_msg_user", localp.field_userName);
      localIntent.putExtra("_stat_obj", paramaz);
    }
    for (;;)
    {
      paramaz = new int[2];
      paramView.getLocationInWindow(paramaz);
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
      localIntent.putExtra("K_source", paramInt1);
      localIntent.putExtra("K_ad_source", paramInt2);
      localIntent.putExtra("k_is_from_sns_main_timeline", localaz.Aae);
      localIntent.putExtra("sns_gallery_thumb_location", new Rect(paramaz[0], paramaz[1], k + paramaz[0], paramaz[1] + m));
      localIntent.putExtra("sns_ad_exposure_start_time", paramLong);
      localIntent.setClass(this.dsa, SnsBrowseUI.class);
      paramView = this.dsa;
      paramaz = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramaz.ahp(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)paramaz.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.dsa.overridePendingTransition(0, 0);
      AppMethodBeat.o(98730);
      return;
      label765:
      paramaz = new byn();
      break;
      label777:
      localObject = com.tencent.mm.modelsns.e.pW(716);
      break label279;
      label788:
      paramaz = com.tencent.mm.modelsns.e.pW(744);
      break label365;
      label799:
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
    }
  }
  
  final void w(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98729);
    a(paramView, paramInt1, paramInt2, null, 0L);
    AppMethodBeat.o(98729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay
 * JD-Core Version:    0.7.0.1
 */