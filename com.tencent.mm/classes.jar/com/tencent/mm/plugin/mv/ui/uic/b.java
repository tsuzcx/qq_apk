package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.MusicMvAlbumPreviewUI;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "stateCenter", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "Lcom/tencent/mm/plugin/mv/ui/state/album/AlbumState;", "getStateCenter", "()Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "stateCenter$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
{
  private final j Mdr;
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287891);
    this.Mdr = k.cm((kotlin.g.a.a)new a(paramAppCompatActivity));
    AppMethodBeat.o(287891);
  }
  
  public final UIStateCenter<com.tencent.mm.plugin.mv.ui.b.a.a> getStateCenter()
  {
    AppMethodBeat.i(287906);
    UIStateCenter localUIStateCenter = (UIStateCenter)this.Mdr.getValue();
    AppMethodBeat.o(287906);
    return localUIStateCenter;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287900);
    Object localObject = getActivity().getIntent();
    paramBundle = MusicMvAlbumPreviewUI.LZJ;
    paramBundle = MusicMvAlbumPreviewUI.gpQ();
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = ah.aiuX)
    {
      if (paramBundle == null)
      {
        paramBundle = (b)this;
        localObject = ((Intent)localObject).getByteArrayExtra("PreviewItemObj");
        if (localObject != null)
        {
          egz localegz = new egz();
          localegz.parseFrom((byte[])localObject);
          paramBundle.getStateCenter().dispatch((IStateAction)new com.tencent.mm.plugin.mv.ui.b.a.b(localegz));
        }
      }
      AppMethodBeat.o(287900);
      return;
      getStateCenter().dispatch((IStateAction)new com.tencent.mm.plugin.mv.ui.b.a.b(paramBundle));
      paramBundle = MusicMvAlbumPreviewUI.LZJ;
      MusicMvAlbumPreviewUI.a(null);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "Lcom/tencent/mm/plugin/mv/ui/state/album/AlbumState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<UIStateCenter<com.tencent.mm.plugin.mv.ui.b.a.a>>
  {
    a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.b
 * JD-Core Version:    0.7.0.1
 */