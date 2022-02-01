package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.model.audio.i;
import com.tencent.mm.protocal.protobuf.ayt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderFavFragment;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lastScene", "Lcom/tencent/mm/plugin/recordvideo/model/audio/NetSceneAudioPanelGetFinderFavList;", "destroy", "", "loadData", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reset", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorAudioFinderFavFragment
  extends EditorAudioFinderTabFragment
{
  private i NXu;
  private b lastBuffer;
  
  public EditorAudioFinderFavFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(280057);
    com.tencent.mm.kernel.h.aZW().a(3966, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(280057);
  }
  
  public EditorAudioFinderFavFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280065);
    com.tencent.mm.kernel.h.aZW().a(3966, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(280065);
  }
  
  public final void dSD()
  {
    AppMethodBeat.i(280074);
    this.NXu = new i(this.lastBuffer);
    com.tencent.mm.kernel.h.aZW().a((p)this.NXu, 0);
    AppMethodBeat.o(280074);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(280082);
    com.tencent.mm.kernel.h.aZW().b(3966, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(280082);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(280097);
    if ((paramp != null) && (kotlin.g.b.s.p(this.NXu, paramp)))
    {
      this.NXu = null;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = c.c.b(((i)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(280097);
          throw paramString;
        }
        this.lastBuffer = ((ayt)paramString).lastBuffer;
        paramString = c.c.b(((i)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(280097);
          throw paramString;
        }
        paramString = ((ayt)paramString).object;
        kotlin.g.b.s.s(paramString, "rr.responseProtoBuf as F…FavListResponse).`object`");
        paramString = (List)paramString;
        paramp = c.c.b(((i)paramp).rr.otC);
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetFavListResponse");
          AppMethodBeat.o(280097);
          throw paramString;
        }
        if (((ayt)paramp).continueFlag == 0) {
          break label202;
        }
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      B(paramString, bool);
      AppMethodBeat.o(280097);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280087);
    super.reset();
    AppMethodBeat.o(280087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioFinderFavFragment
 * JD-Core Version:    0.7.0.1
 */