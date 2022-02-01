package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livebase.redux.ReduxRootReducer;
import com.tencent.mm.plugin.livebase.redux.c;
import com.tencent.mm.plugin.mv.ui.MusicMvAlbumPreviewUI;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "rootReducer", "Lcom/tencent/mm/plugin/livebase/redux/ReduxRootReducer;", "Lcom/tencent/mm/plugin/mv/ui/redux/album/AlbumState;", "getRootReducer", "()Lcom/tencent/mm/plugin/livebase/redux/ReduxRootReducer;", "rootReducer$delegate", "Lkotlin/Lazy;", "store", "Lcom/tencent/mm/plugin/livebase/redux/ReduxStore;", "getStore", "()Lcom/tencent/mm/plugin/livebase/redux/ReduxStore;", "store$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mv_release"})
public final class b
  extends UIComponent
{
  private final f Gil;
  private final f Gim;
  
  public b(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(232246);
    this.Gil = g.ar((kotlin.g.a.a)new a(paramAppCompatActivity));
    this.Gim = g.ar((kotlin.g.a.a)new b(this, paramAppCompatActivity));
    AppMethodBeat.o(232246);
  }
  
  public final ReduxRootReducer<com.tencent.mm.plugin.mv.ui.b.a.a> fgM()
  {
    AppMethodBeat.i(232241);
    ReduxRootReducer localReduxRootReducer = (ReduxRootReducer)this.Gil.getValue();
    AppMethodBeat.o(232241);
    return localReduxRootReducer;
  }
  
  public final c<com.tencent.mm.plugin.mv.ui.b.a.a> fgN()
  {
    AppMethodBeat.i(232244);
    c localc = (c)this.Gim.getValue();
    AppMethodBeat.o(232244);
    return localc;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(232240);
    paramBundle = getActivity().getIntent();
    Object localObject = MusicMvAlbumPreviewUI.Gec;
    localObject = MusicMvAlbumPreviewUI.fgp();
    if (localObject != null)
    {
      fgN().a((com.tencent.mm.plugin.livebase.redux.a)new com.tencent.mm.plugin.mv.ui.b.a.b((doi)localObject));
      paramBundle = MusicMvAlbumPreviewUI.Gec;
      MusicMvAlbumPreviewUI.a(null);
      AppMethodBeat.o(232240);
      return;
    }
    localObject = (b)this;
    paramBundle = paramBundle.getByteArrayExtra("PreviewItemObj");
    if (paramBundle != null)
    {
      doi localdoi = new doi();
      localdoi.parseFrom(paramBundle);
      ((b)localObject).fgN().a((com.tencent.mm.plugin.livebase.redux.a)new com.tencent.mm.plugin.mv.ui.b.a.b(localdoi));
      AppMethodBeat.o(232240);
      return;
    }
    AppMethodBeat.o(232240);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livebase/redux/ReduxRootReducer;", "Lcom/tencent/mm/plugin/mv/ui/redux/album/AlbumState;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<ReduxRootReducer<com.tencent.mm.plugin.mv.ui.b.a.a>>
  {
    a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livebase/redux/ReduxStore;", "Lcom/tencent/mm/plugin/mv/ui/redux/album/AlbumState;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<c<com.tencent.mm.plugin.mv.ui.b.a.a>>
  {
    b(b paramb, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.b
 * JD-Core Version:    0.7.0.1
 */