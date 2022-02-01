package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.story.c.a.c;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.textstatus.g.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$c
  implements View.OnClickListener
{
  TextStatusEditActivity$c(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216488);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    paramView = (CaptureDataManager.b)new TextStatusEditActivity.c.a(this);
    new SightParams(1, 0);
    localObject1 = t.Qv(com.tencent.mm.plugin.auth.a.a.ceA());
    p.g(localObject1, "VideoInfoStorage.genFileName(Account.username())");
    o.bhj();
    Object localObject2 = t.Qw((String)localObject1);
    o.bhj();
    localObject1 = RecordConfigProvider.a((String)localObject2, t.Qx((String)localObject1), ((c.a)c.FkZ.aLT()).BOm, ((c.a)c.FkZ.aLT()).BOm.duration * 1000, 15);
    p.g(localObject1, "RecordConfigProvider.get…ENE_TEXT_STATUS\n        )");
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYN, false)) {
      ((RecordConfigProvider)localObject1).remuxType = 2;
    }
    localObject2 = new UICustomParam.a();
    ((UICustomParam.a)localObject2).apE();
    ((UICustomParam.a)localObject2).apD();
    ((UICustomParam.a)localObject2).dz(true);
    ((RecordConfigProvider)localObject1).BOn = ((UICustomParam.a)localObject2).apG();
    ((RecordConfigProvider)localObject1).BOu = Boolean.TRUE;
    ((RecordConfigProvider)localObject1).BOG = false;
    ((RecordConfigProvider)localObject1).BOH = false;
    ((RecordConfigProvider)localObject1).BOI = true;
    ((RecordConfigProvider)localObject1).BOq = Boolean.TRUE;
    ((RecordConfigProvider)localObject1).BOp = 4;
    ((RecordConfigProvider)localObject1).F(2, TextStatusEditVideoPluginLayout.class.getName());
    ((RecordConfigProvider)localObject1).F(1, TextStatusEditPhotoPluginLayout.class.getName());
    CaptureDataManager.BOb.a(paramView);
    paramView = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
    com.tencent.mm.plugin.recordvideo.jumper.a.a((Context)this.GeQ, 2, 2130772161, 2130772162, (RecordConfigProvider)localObject1);
    paramView = SecDataUIC.CWq;
    paramView = this.GeQ.getContext();
    p.g(paramView, "context");
    paramView = (z)SecDataUIC.a.a((Context)paramView, 8, z.class);
    if (paramView != null) {
      paramView.Usu = (1L + paramView.Usu);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$cameraClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.c
 * JD-Core Version:    0.7.0.1
 */