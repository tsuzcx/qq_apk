package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.aub;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderFavFragment;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lastScene", "Lcom/tencent/mm/plugin/recordvideo/model/audio/NetSceneAudioPanelGetFinderFavList;", "destroy", "", "loadData", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reset", "plugin-recordvideo_release"})
public final class EditorAudioFinderFavFragment
  extends EditorAudioFinderTabFragment
{
  private com.tencent.mm.plugin.recordvideo.model.audio.i IaU;
  private b lastBuffer;
  
  public EditorAudioFinderFavFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(221376);
    h.aGY().a(3966, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(221376);
  }
  
  public EditorAudioFinderFavFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(221378);
    h.aGY().a(3966, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(221378);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(221364);
    h.aGY().b(3966, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(221364);
  }
  
  public final void dlN()
  {
    AppMethodBeat.i(221362);
    this.IaU = new com.tencent.mm.plugin.recordvideo.model.audio.i(this.lastBuffer);
    h.aGY().b((q)this.IaU);
    AppMethodBeat.o(221362);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(221373);
    if ((paramq != null) && (p.h(this.IaU, paramq)))
    {
      this.IaU = null;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.recordvideo.model.audio.i)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(221373);
          throw paramString;
        }
        this.lastBuffer = ((aub)paramString).lastBuffer;
        paramString = ((com.tencent.mm.plugin.recordvideo.model.audio.i)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(221373);
          throw paramString;
        }
        paramString = ((aub)paramString).object;
        p.j(paramString, "(rr.responseProtoBuf as …FavListResponse).`object`");
        paramString = (List)paramString;
        paramq = ((com.tencent.mm.plugin.recordvideo.model.audio.i)paramq).rr.bhY();
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(221373);
          throw paramString;
        }
        if (((aub)paramq).continueFlag == 0) {
          break label193;
        }
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      n(paramString, bool);
      AppMethodBeat.o(221373);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(221367);
    super.reset();
    AppMethodBeat.o(221367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioFinderFavFragment
 * JD-Core Version:    0.7.0.1
 */