package com.tencent.mm.plugin.sns.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.e.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"addImageScanQRCode", "", "Lcom/tencent/mm/plugin/sns/ui/sheet/ShareSheet;", "currentImage", "Landroid/view/View;", "imageQBarDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "Lkotlin/collections/ArrayList;", "fetchCodeInfo", "view", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "getQBarDataOnCurrentDisplay", "plugin-sns_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void a(c paramc, View paramView, ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(308916);
    kotlin.g.b.s.u(paramc, "<this>");
    kotlin.g.b.s.u(paramArrayList, "imageQBarDataList");
    if (Util.isNullOrNil((List)paramArrayList))
    {
      AppMethodBeat.o(308916);
      return;
    }
    paramc.cDi().agel = new a..ExternalSyntheticLambda2(paramc, paramArrayList, paramView);
    AppMethodBeat.o(308916);
  }
  
  public static final void a(c paramc, View paramView, ArrayList<ImageQBarDataBean> paramArrayList, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(308908);
    kotlin.g.b.s.u(paramc, "<this>");
    kotlin.g.b.s.u(paramArrayList, "imageQBarDataList");
    ImageQBarDataBean localImageQBarDataBean = b(paramc, paramView, paramArrayList);
    Object localObject2;
    Object localObject1;
    if (localImageQBarDataBean != null)
    {
      localObject2 = localImageQBarDataBean.OGQ;
      localObject1 = new e.a((String)localObject2);
      if (paramSnsInfo != null)
      {
        localObject1 = e.a.aP((String)localObject2, paramSnsInfo.getUserName(), String.valueOf(paramSnsInfo.field_snsId));
        kotlin.g.b.s.s(localObject1, "SNS(code, snsInfo.userNa…o.field_snsId.toString())");
      }
      paramc.hse().a(localImageQBarDataBean.hDb, (e.a)localObject1, new a..ExternalSyntheticLambda0(paramc, paramView, paramArrayList));
      AppMethodBeat.o(308908);
      return;
    }
    int i = paramArrayList.size();
    if (i == 1)
    {
      localObject1 = paramArrayList.get(0);
      kotlin.g.b.s.s(localObject1, "imageQBarDataList[0]");
      localImageQBarDataBean = (ImageQBarDataBean)localObject1;
      localObject2 = paramc.hse();
      String str = localImageQBarDataBean.OGQ;
      localObject1 = new e.a(str);
      if (paramSnsInfo != null)
      {
        localObject1 = e.a.aP(str, paramSnsInfo.getUserName(), String.valueOf(paramSnsInfo.field_snsId));
        kotlin.g.b.s.s(localObject1, "SNS(code, snsInfo.userNa…o.field_snsId.toString())");
      }
      ((ScanCodeSheetItemLogic)localObject2).a(localImageQBarDataBean.hDb, (e.a)localObject1, new a..ExternalSyntheticLambda1(paramc, paramView, paramArrayList));
      AppMethodBeat.o(308908);
      return;
    }
    if ((i > 1) && (paramc.cDi().isShowing()))
    {
      paramc.RdW = true;
      a(paramc, paramView, paramArrayList);
      paramc.dDn();
    }
    AppMethodBeat.o(308908);
  }
  
  private static final void a(c paramc, ArrayList paramArrayList, View paramView, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(308929);
    kotlin.g.b.s.u(paramc, "$this_addImageScanQRCode");
    kotlin.g.b.s.u(paramArrayList, "$imageQBarDataList");
    params.clear();
    paramc.hse().a(paramArrayList, b(paramc, paramView, paramArrayList), paramc.cDi(), params, 6);
    AppMethodBeat.o(308929);
  }
  
  private static ImageQBarDataBean b(c paramc, View paramView, ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(308921);
    kotlin.g.b.s.u(paramc, "<this>");
    kotlin.g.b.s.u(paramArrayList, "imageQBarDataList");
    if (paramView == null)
    {
      AppMethodBeat.o(308921);
      return null;
    }
    paramc = (ArrayList)i.a((Context)paramc.activity, paramView, paramArrayList, 0).bsC;
    if (paramc.size() == 1) {}
    for (paramc = (ImageQBarDataBean)paramc.get(0);; paramc = null)
    {
      AppMethodBeat.o(308921);
      return paramc;
    }
  }
  
  private static final void c(c paramc, View paramView, ArrayList paramArrayList)
  {
    AppMethodBeat.i(308923);
    kotlin.g.b.s.u(paramc, "$this_fetchCodeInfo");
    kotlin.g.b.s.u(paramArrayList, "$imageQBarDataList");
    if (paramc.cDi().isShowing())
    {
      paramc.RdW = true;
      a(paramc, paramView, paramArrayList);
      paramc.dDn();
    }
    AppMethodBeat.o(308923);
  }
  
  private static final void d(c paramc, View paramView, ArrayList paramArrayList)
  {
    AppMethodBeat.i(308926);
    kotlin.g.b.s.u(paramc, "$this_fetchCodeInfo");
    kotlin.g.b.s.u(paramArrayList, "$imageQBarDataList");
    if (paramc.cDi().isShowing())
    {
      paramc.RdW = true;
      a(paramc, paramView, paramArrayList);
      paramc.dDn();
    }
    AppMethodBeat.o(308926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.a
 * JD-Core Version:    0.7.0.1
 */