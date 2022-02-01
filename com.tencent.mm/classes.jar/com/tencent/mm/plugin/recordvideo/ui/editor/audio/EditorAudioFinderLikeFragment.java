package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.model.audio.j;
import com.tencent.mm.protocal.protobuf.azh;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderLikeFragment;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lastScene", "Lcom/tencent/mm/plugin/recordvideo/model/audio/NetSceneAudioPanelGetFinderLikedList;", "destroy", "", "loadData", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reset", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorAudioFinderLikeFragment
  extends EditorAudioFinderTabFragment
{
  private j NXw;
  private b lastBuffer;
  
  public EditorAudioFinderLikeFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(280128);
    com.tencent.mm.kernel.h.aZW().a(3965, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(280128);
  }
  
  public EditorAudioFinderLikeFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280137);
    com.tencent.mm.kernel.h.aZW().a(3965, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(280137);
  }
  
  public final void dSD()
  {
    AppMethodBeat.i(280144);
    this.NXw = new j(this.lastBuffer);
    com.tencent.mm.kernel.h.aZW().a((p)this.NXw, 0);
    AppMethodBeat.o(280144);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(280155);
    com.tencent.mm.kernel.h.aZW().b(3965, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(280155);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(280182);
    if ((paramp != null) && (kotlin.g.b.s.p(this.NXw, paramp)))
    {
      this.NXw = null;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = c.c.b(((j)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
          AppMethodBeat.o(280182);
          throw paramString;
        }
        this.lastBuffer = ((azh)paramString).lastBuffer;
        paramString = c.c.b(((j)paramp).rr.otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
          AppMethodBeat.o(280182);
          throw paramString;
        }
        paramString = ((azh)paramString).ZJE;
        kotlin.g.b.s.s(paramString, "rr.responseProtoBuf as F…dListResponse).liked_list");
        paramString = (List)paramString;
        paramp = c.c.b(((j)paramp).rr.otC);
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
          AppMethodBeat.o(280182);
          throw paramString;
        }
        if (((azh)paramp).continueFlag == 0) {
          break label202;
        }
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      B(paramString, bool);
      AppMethodBeat.o(280182);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280164);
    super.reset();
    AppMethodBeat.o(280164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioFinderLikeFragment
 * JD-Core Version:    0.7.0.1
 */