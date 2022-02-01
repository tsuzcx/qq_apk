package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.model.audio.j;
import com.tencent.mm.protocal.protobuf.aup;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderLikeFragment;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "lastScene", "Lcom/tencent/mm/plugin/recordvideo/model/audio/NetSceneAudioPanelGetFinderLikedList;", "destroy", "", "loadData", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reset", "plugin-recordvideo_release"})
public final class EditorAudioFinderLikeFragment
  extends EditorAudioFinderTabFragment
{
  private j IaW;
  private b lastBuffer;
  
  public EditorAudioFinderLikeFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(216619);
    h.aGY().a(3965, (i)this);
    AppMethodBeat.o(216619);
  }
  
  public EditorAudioFinderLikeFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216620);
    h.aGY().a(3965, (i)this);
    AppMethodBeat.o(216620);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(216616);
    h.aGY().b(3965, (i)this);
    AppMethodBeat.o(216616);
  }
  
  public final void dlN()
  {
    AppMethodBeat.i(216615);
    this.IaW = new j(this.lastBuffer);
    h.aGY().b((q)this.IaW);
    AppMethodBeat.o(216615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(216618);
    if ((paramq != null) && (p.h(this.IaW, paramq)))
    {
      this.IaW = null;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((j)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
          AppMethodBeat.o(216618);
          throw paramString;
        }
        this.lastBuffer = ((aup)paramString).lastBuffer;
        paramString = ((j)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
          AppMethodBeat.o(216618);
          throw paramString;
        }
        paramString = ((aup)paramString).SGN;
        p.j(paramString, "(rr.responseProtoBuf as …dListResponse).liked_list");
        paramString = (List)paramString;
        paramq = ((j)paramq).rr.bhY();
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLikedListResponse");
          AppMethodBeat.o(216618);
          throw paramString;
        }
        if (((aup)paramq).continueFlag == 0) {
          break label193;
        }
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      n(paramString, bool);
      AppMethodBeat.o(216618);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(216617);
    super.reset();
    AppMethodBeat.o(216617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioFinderLikeFragment
 * JD-Core Version:    0.7.0.1
 */