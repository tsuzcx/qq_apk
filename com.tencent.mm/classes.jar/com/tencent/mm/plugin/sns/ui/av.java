package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class av
{
  private Activity dgE;
  private List<btz> list;
  
  public av(Activity paramActivity)
  {
    AppMethodBeat.i(98728);
    this.list = new ArrayList();
    this.dgE = paramActivity;
    AppMethodBeat.o(98728);
  }
  
  private boolean eL(String paramString, int paramInt)
  {
    AppMethodBeat.i(98731);
    Object localObject = h.auT(paramString);
    if (localObject == null)
    {
      ac.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(98731);
      return false;
    }
    paramString = ((p)localObject).dLV();
    if (paramString.FQo == null)
    {
      ac.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
      AppMethodBeat.o(98731);
      return false;
    }
    if (paramString.FQo.Etz.size() == 0)
    {
      ac.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      AppMethodBeat.o(98731);
      return false;
    }
    this.list.clear();
    paramString = paramString.FQo.Etz.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (btz)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!af.dHO().B((btz)localObject)))
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
        AppMethodBeat.o(98731);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98731);
    return true;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, ay paramay, long paramLong)
  {
    AppMethodBeat.i(98730);
    if (paramView == null)
    {
      ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(98730);
      return;
    }
    Object localObject = paramView.getTag();
    aw localaw;
    String str;
    int i;
    int j;
    Intent localIntent;
    if ((localObject instanceof aw))
    {
      localaw = (aw)localObject;
      str = localaw.dgl;
      i = localaw.index;
      j = localaw.position;
      if (!eL(str, i))
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      g.agS();
      if (!g.agR().isSDCardAvailable())
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
        AppMethodBeat.o(98730);
        return;
      }
      p localp = h.auT(str);
      if (!eL(str, i))
      {
        ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      localIntent = new Intent();
      if (localp == null) {
        break label799;
      }
      if (paramay != null) {
        paramay.xUQ.D(localp);
      }
      TimeLineObject localTimeLineObject = localp.dLV();
      if (localaw.index >= localTimeLineObject.FQo.Etz.size()) {
        break label765;
      }
      paramay = (btz)localTimeLineObject.FQo.Etz.get(localaw.index);
      if (paramInt1 != 1) {
        break label777;
      }
      localObject = d.ps(716);
      label279:
      ((d)localObject).Dn(q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32)).Dn(localp.dMD()).Dn(paramay.Id).pv(localaw.index).pv(localTimeLineObject.FQo.Etz.size());
      ((d)localObject).aHZ();
      if (paramInt1 != 1) {
        break label788;
      }
      paramay = d.ps(744);
      label365:
      paramay.Dn(q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32)).Dn(localp.dMD());
      paramay.b(localIntent, "intent_key_StatisticsOplog");
      paramay = new Bundle();
      paramay.putInt("stat_scene", 3);
      paramay.putString("stat_msg_id", "sns_" + q.wW(localp.field_snsId));
      paramay.putString("stat_send_msg_user", localp.field_userName);
      localIntent.putExtra("_stat_obj", paramay);
    }
    for (;;)
    {
      paramay = new int[2];
      paramView.getLocationInWindow(paramay);
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
      localIntent.putExtra("k_is_from_sns_main_timeline", localaw.yIK);
      localIntent.putExtra("sns_gallery_thumb_location", new Rect(paramay[0], paramay[1], k + paramay[0], paramay[1] + m));
      localIntent.putExtra("sns_ad_exposure_start_time", paramLong);
      localIntent.setClass(this.dgE, SnsBrowseUI.class);
      paramView = this.dgE;
      paramay = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramay.aeD(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)paramay.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.dgE.overridePendingTransition(0, 0);
      AppMethodBeat.o(98730);
      return;
      label765:
      paramay = new btz();
      break;
      label777:
      localObject = d.pt(716);
      break label279;
      label788:
      paramay = d.pt(744);
      break label365;
      label799:
      ac.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
    }
  }
  
  final void v(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98729);
    a(paramView, paramInt1, paramInt2, null, 0L);
    AppMethodBeat.o(98729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.av
 * JD-Core Version:    0.7.0.1
 */