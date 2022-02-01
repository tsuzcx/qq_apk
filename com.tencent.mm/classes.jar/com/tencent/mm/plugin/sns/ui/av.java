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
import com.tencent.mm.plugin.sns.k.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class av
{
  private Activity djj;
  private List<bpi> list;
  
  public av(Activity paramActivity)
  {
    AppMethodBeat.i(98728);
    this.list = new ArrayList();
    this.djj = paramActivity;
    AppMethodBeat.o(98728);
  }
  
  private boolean eD(String paramString, int paramInt)
  {
    AppMethodBeat.i(98731);
    Object localObject = h.apK(paramString);
    if (localObject == null)
    {
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(98731);
      return false;
    }
    paramString = ((p)localObject).dxy();
    if (paramString.Etm == null)
    {
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
      AppMethodBeat.o(98731);
      return false;
    }
    if (paramString.Etm.DaC.size() == 0)
    {
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      AppMethodBeat.o(98731);
      return false;
    }
    this.list.clear();
    paramString = paramString.Etm.DaC.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (bpi)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!af.dtr().B((bpi)localObject)))
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
  
  public final void a(View paramView, int paramInt1, int paramInt2, ax paramax, long paramLong)
  {
    AppMethodBeat.i(98730);
    if (paramView == null)
    {
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
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
      str = localaw.diQ;
      i = localaw.index;
      j = localaw.position;
      if (!eD(str, i))
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      g.afC();
      if (!g.afB().isSDCardAvailable())
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
        AppMethodBeat.o(98730);
        return;
      }
      p localp = h.apK(str);
      if (!eD(str, i))
      {
        ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      localIntent = new Intent();
      if (localp == null) {
        break label799;
      }
      if (paramax != null) {
        paramax.wIv.C(localp);
      }
      TimeLineObject localTimeLineObject = localp.dxy();
      if (localaw.index >= localTimeLineObject.Etm.DaC.size()) {
        break label765;
      }
      paramax = (bpi)localTimeLineObject.Etm.DaC.get(localaw.index);
      if (paramInt1 != 1) {
        break label777;
      }
      localObject = d.oE(716);
      label279:
      ((d)localObject).zi(q.l(localp)).oH(localp.field_type).ew(localp.Nb(32)).zi(localp.dyg()).zi(paramax.Id).oH(localaw.index).oH(localTimeLineObject.Etm.DaC.size());
      ((d)localObject).aBj();
      if (paramInt1 != 1) {
        break label788;
      }
      paramax = d.oE(744);
      label365:
      paramax.zi(q.l(localp)).oH(localp.field_type).ew(localp.Nb(32)).zi(localp.dyg());
      paramax.b(localIntent, "intent_key_StatisticsOplog");
      paramax = new Bundle();
      paramax.putInt("stat_scene", 3);
      paramax.putString("stat_msg_id", "sns_" + q.st(localp.field_snsId));
      paramax.putString("stat_send_msg_user", localp.field_userName);
      localIntent.putExtra("_stat_obj", paramax);
    }
    for (;;)
    {
      paramax = new int[2];
      paramView.getLocationInWindow(paramax);
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
      localIntent.putExtra("k_is_from_sns_main_timeline", localaw.xvU);
      localIntent.putExtra("sns_gallery_thumb_location", new Rect(paramax[0], paramax[1], k + paramax[0], paramax[1] + m));
      localIntent.putExtra("sns_ad_exposure_start_time", paramLong);
      localIntent.setClass(this.djj, SnsBrowseUI.class);
      paramView = this.djj;
      paramax = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramax.adn(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)paramax.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.djj.overridePendingTransition(0, 0);
      AppMethodBeat.o(98730);
      return;
      label765:
      paramax = new bpi();
      break;
      label777:
      localObject = d.oF(716);
      break label279;
      label788:
      paramax = d.oF(744);
      break label365;
      label799:
      ad.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
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