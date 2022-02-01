package com.tencent.mm.plugin.sns.cover.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.no;
import com.tencent.mm.autogen.mmdata.rpt.np;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.pulldown.c;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/edit/SnsCoverFinderPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finderPreview", "Lcom/tencent/mm/plugin/sns/cover/api/AbsSnsBackPreview;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setWindowStyle", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsCoverFinderPreviewUI
  extends MMActivity
{
  public static final SnsCoverFinderPreviewUI.a QkT;
  private com.tencent.mm.plugin.sns.cover.a.a QkU;
  
  static
  {
    AppMethodBeat.i(307356);
    QkT = new SnsCoverFinderPreviewUI.a((byte)0);
    AppMethodBeat.o(307356);
  }
  
  private static final void a(SnsCoverFinderPreviewUI paramSnsCoverFinderPreviewUI, View paramView)
  {
    AppMethodBeat.i(307347);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSnsCoverFinderPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/cover/edit/SnsCoverFinderPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSnsCoverFinderPreviewUI, "this$0");
    paramSnsCoverFinderPreviewUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/cover/edit/SnsCoverFinderPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(307347);
  }
  
  private static final void a(SnsCoverFinderPreviewUI paramSnsCoverFinderPreviewUI, FinderObject paramFinderObject, int paramInt1, int paramInt2, View paramView)
  {
    AppMethodBeat.i(307353);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSnsCoverFinderPreviewUI);
    localb.cH(paramFinderObject);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/cover/edit/SnsCoverFinderPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSnsCoverFinderPreviewUI, "this$0");
    s.u(paramFinderObject, "$finderObject");
    paramSnsCoverFinderPreviewUI.setResult(-1, paramSnsCoverFinderPreviewUI.getIntent());
    paramView = j.QFS.QGL;
    paramView.jft = paramView.F("FinderFeedID", com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramFinderObject.id), true);
    j.QFS.QGL.jfr = paramInt1;
    paramView = j.QFS;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      j.QFS.QGN.vJ(com.tencent.mm.plugin.expt.hellhound.core.b.hF(paramFinderObject.id));
      j.QFS.QGN.jfr = paramInt1;
      paramSnsCoverFinderPreviewUI.finish();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/cover/edit/SnsCoverFinderPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(307353);
      return;
      paramView.QGL.jfu = 3;
      continue;
      paramView.QGL.jfu = 5;
      continue;
      paramView.QGL.jfu = 7;
      continue;
      paramView.QGL.jfu = 6;
      continue;
      paramView.QGL.jfu = 4;
    }
  }
  
  public final int getLayoutId()
  {
    return b.g.cover_finder_preview_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(307376);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.ys(true);
    getWindow().setFormat(-3);
    Object localObject = getIntent().getByteArrayExtra("SELECT_OBJECT");
    int j = getIntent().getIntExtra("SELECT_TAB_TYPE", 0);
    if (localObject == null)
    {
      Log.e("MicroMsg.SnsCoverFinderPreviewUI", "finderObj bytes == null");
      finish();
      AppMethodBeat.o(307376);
      return;
    }
    paramBundle = new FinderObject();
    paramBundle.parseFrom((byte[])localObject);
    localObject = paramBundle.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = (FinderMedia)((LinkedList)localObject).getFirst();
        if ((localObject != null) && (((FinderMedia)localObject).mediaType == 4))
        {
          i = 1;
          if (i == 0) {
            break label274;
          }
        }
      }
    }
    label274:
    for (int i = 3;; i = 4)
    {
      localObject = com.tencent.mm.plugin.sns.cover.preview.a.QlC;
      this.QkU = com.tencent.mm.plugin.sns.cover.preview.a.aW((Context)this, i);
      ((ViewGroup)findViewById(b.f.finder_preview_layout)).addView((View)this.QkU, 0);
      localObject = this.QkU;
      if (localObject != null) {
        ((com.tencent.mm.plugin.sns.cover.a.a)localObject).L(paramBundle);
      }
      findViewById(b.f.cover_finder_preview_back).setOnClickListener(new SnsCoverFinderPreviewUI..ExternalSyntheticLambda0(this));
      findViewById(b.f.cover_finder_preview_finish).setOnClickListener(new SnsCoverFinderPreviewUI..ExternalSyntheticLambda1(this, paramBundle, i, j));
      AppMethodBeat.o(307376);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(307391);
    super.onDestroy();
    com.tencent.mm.plugin.sns.cover.a.a locala = this.QkU;
    if (locala != null) {
      locala.onDestroy();
    }
    AppMethodBeat.o(307391);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(307386);
    super.onPause();
    com.tencent.mm.plugin.sns.cover.a.a locala = this.QkU;
    if (locala != null) {
      locala.onPause();
    }
    AppMethodBeat.o(307386);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(307382);
    super.onResume();
    com.tencent.mm.plugin.sns.cover.a.a locala = this.QkU;
    if (locala != null) {
      locala.onResume();
    }
    AppMethodBeat.o(307382);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.edit.SnsCoverFinderPreviewUI
 * JD-Core Version:    0.7.0.1
 */