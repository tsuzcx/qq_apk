package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class an
{
  private Activity cup;
  private List<bcs> list;
  
  public an(Activity paramActivity)
  {
    AppMethodBeat.i(38962);
    this.list = new ArrayList();
    this.cup = paramActivity;
    AppMethodBeat.o(38962);
  }
  
  private boolean dv(String paramString, int paramInt)
  {
    AppMethodBeat.i(38965);
    Object localObject = h.abv(paramString);
    if (localObject == null)
    {
      ab.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(38965);
      return false;
    }
    paramString = ((n)localObject).csh();
    if (paramString.xTS == null)
    {
      ab.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
      AppMethodBeat.o(38965);
      return false;
    }
    if (paramString.xTS.wOa.size() == 0)
    {
      ab.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
      AppMethodBeat.o(38965);
      return false;
    }
    this.list.clear();
    paramString = paramString.xTS.wOa.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (bcs)paramString.next();
      this.list.add(localObject);
      if ((paramInt == i) && (!ag.cpc().B((bcs)localObject)))
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
        AppMethodBeat.o(38965);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(38965);
    return true;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, av paramav, long paramLong)
  {
    AppMethodBeat.i(145542);
    if (paramView == null)
    {
      ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(145542);
      return;
    }
    Object localObject = paramView.getTag();
    ao localao;
    String str;
    int i;
    int j;
    Intent localIntent;
    if ((localObject instanceof ao))
    {
      localao = (ao)localObject;
      str = localao.ctV;
      i = localao.index;
      j = localao.position;
      if (!dv(str, i))
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(145542);
        return;
      }
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
        AppMethodBeat.o(145542);
        return;
      }
      n localn = h.abv(str);
      if (!dv(str, i))
      {
        ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", new Object[] { str, Integer.valueOf(i) });
        AppMethodBeat.o(145542);
        return;
      }
      localIntent = new Intent();
      if (localn == null) {
        break label727;
      }
      if (paramav != null) {
        paramav.rhS.x(localn);
      }
      TimeLineObject localTimeLineObject = localn.csh();
      if (localao.index >= localTimeLineObject.xTS.wOa.size()) {
        break label693;
      }
      paramav = (bcs)localTimeLineObject.xTS.wOa.get(localao.index);
      if (paramInt1 != 1) {
        break label705;
      }
      localObject = com.tencent.mm.modelsns.b.lV(716);
      label279:
      ((com.tencent.mm.modelsns.b)localObject).uv(i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP()).uv(paramav.Id).lY(localao.index).lY(localTimeLineObject.xTS.wOa.size());
      ((com.tencent.mm.modelsns.b)localObject).ake();
      if (paramInt1 != 1) {
        break label716;
      }
      paramav = com.tencent.mm.modelsns.b.lV(744);
      label365:
      paramav.uv(i.j(localn)).lY(localn.field_type).de(localn.Ex(32)).uv(localn.csP());
      paramav.b(localIntent, "intent_key_StatisticsOplog");
      paramav = new Bundle();
      paramav.putInt("stat_scene", 3);
      paramav.putString("stat_msg_id", "sns_" + i.lq(localn.field_snsId));
      paramav.putString("stat_send_msg_user", localn.field_userName);
      localIntent.putExtra("_stat_obj", paramav);
    }
    for (;;)
    {
      paramav = new int[2];
      paramView.getLocationInWindow(paramav);
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
      localIntent.putExtra("k_is_from_sns_main_timeline", localao.rNW);
      localIntent.putExtra("img_gallery_left", paramav[0]);
      localIntent.putExtra("img_gallery_top", paramav[1]);
      localIntent.putExtra("img_gallery_width", k);
      localIntent.putExtra("img_gallery_height", m);
      localIntent.putExtra("sns_ad_exposure_start_time", paramLong);
      localIntent.setClass(this.cup, SnsBrowseUI.class);
      this.cup.startActivity(localIntent);
      this.cup.overridePendingTransition(0, 0);
      AppMethodBeat.o(145542);
      return;
      label693:
      paramav = new bcs();
      break;
      label705:
      localObject = com.tencent.mm.modelsns.b.lW(716);
      break label279;
      label716:
      paramav = com.tencent.mm.modelsns.b.lW(744);
      break label365;
      label727:
      ab.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
    }
  }
  
  final void u(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145541);
    a(paramView, paramInt1, paramInt2, null, 0L);
    AppMethodBeat.o(145541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.an
 * JD-Core Version:    0.7.0.1
 */