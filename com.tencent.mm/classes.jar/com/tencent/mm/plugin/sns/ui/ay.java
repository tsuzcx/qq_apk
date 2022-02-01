package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ay
{
  private Activity dtg;
  private List<bzh> list;
  
  public ay(Activity paramActivity)
  {
    AppMethodBeat.i(98728);
    this.list = new ArrayList();
    this.dtg = paramActivity;
    AppMethodBeat.o(98728);
  }
  
  private boolean fm(String paramString, int paramInt)
  {
    AppMethodBeat.i(98731);
    Object localObject = h.aBr(paramString);
    if (localObject == null)
    {
      ae.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(98731);
      return false;
    }
    paramString = ((p)localObject).ebP();
    if (paramString.HUG == null)
    {
      ae.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
      AppMethodBeat.o(98731);
      return false;
    }
    if (paramString.HUG.Gtx.size() == 0)
    {
      ae.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      AppMethodBeat.o(98731);
      return false;
    }
    this.list.clear();
    paramString = paramString.HUG.Gtx.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (bzh)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!ah.dXB().B((bzh)localObject)))
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
        AppMethodBeat.o(98731);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98731);
    return true;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, ba paramba, long paramLong)
  {
    AppMethodBeat.i(98730);
    if (paramView == null)
    {
      ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
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
      str = localaz.dsN;
      i = localaz.index;
      j = localaz.position;
      if (!fm(str, i))
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      com.tencent.mm.kernel.g.ajS();
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
        AppMethodBeat.o(98730);
        return;
      }
      p localp = h.aBr(str);
      if (!fm(str, i))
      {
        ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(98730);
        return;
      }
      localIntent = new Intent();
      if (localp == null) {
        break label799;
      }
      if (paramba != null) {
        paramba.zCa.F(localp);
      }
      TimeLineObject localTimeLineObject = localp.ebP();
      if (localaz.index >= localTimeLineObject.HUG.Gtx.size()) {
        break label765;
      }
      paramba = (bzh)localTimeLineObject.HUG.Gtx.get(localaz.index);
      if (paramInt1 != 1) {
        break label777;
      }
      localObject = com.tencent.mm.modelsns.e.pY(716);
      label279:
      ((com.tencent.mm.modelsns.e)localObject).GU(r.o(localp)).qb(localp.field_type).eV(localp.Rt(32)).GU(localp.ecx()).GU(paramba.Id).qb(localaz.index).qb(localTimeLineObject.HUG.Gtx.size());
      ((com.tencent.mm.modelsns.e)localObject).aLH();
      if (paramInt1 != 1) {
        break label788;
      }
      paramba = com.tencent.mm.modelsns.e.pY(744);
      label365:
      paramba.GU(r.o(localp)).qb(localp.field_type).eV(localp.Rt(32)).GU(localp.ecx());
      paramba.b(localIntent, "intent_key_StatisticsOplog");
      paramba = new Bundle();
      paramba.putInt("stat_scene", 3);
      paramba.putString("stat_msg_id", "sns_" + r.zV(localp.field_snsId));
      paramba.putString("stat_send_msg_user", localp.field_userName);
      localIntent.putExtra("_stat_obj", paramba);
    }
    for (;;)
    {
      paramba = new int[2];
      paramView.getLocationInWindow(paramba);
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
      localIntent.putExtra("k_is_from_sns_main_timeline", localaz.Arr);
      localIntent.putExtra("sns_gallery_thumb_location", new Rect(paramba[0], paramba[1], k + paramba[0], paramba[1] + m));
      localIntent.putExtra("sns_ad_exposure_start_time", paramLong);
      localIntent.setClass(this.dtg, SnsBrowseUI.class);
      paramView = this.dtg;
      paramba = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramba.ahE(), "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)paramba.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/sns/ui/SnsImageDialogShowerMgr", "showImg", "(Landroid/view/View;IILcom/tencent/mm/plugin/sns/model/TimelineContext;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.dtg.overridePendingTransition(0, 0);
      AppMethodBeat.o(98730);
      return;
      label765:
      paramba = new bzh();
      break;
      label777:
      localObject = com.tencent.mm.modelsns.e.pZ(716);
      break label279;
      label788:
      paramba = com.tencent.mm.modelsns.e.pZ(744);
      break label365;
      label799:
      ae.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay
 * JD-Core Version:    0.7.0.1
 */