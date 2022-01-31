package com.tencent.mm.plugin.story.f;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$2$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$2"})
final class k$b
  implements Runnable
{
  k$b(zh paramzh, Matrix paramMatrix, Rect paramRect, Context paramContext, ViewGroup paramViewGroup, chf paramchf) {}
  
  public final void run()
  {
    AppMethodBeat.i(109667);
    Object localObject = k.sCp;
    localObject = g.G(d.class);
    j.p(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((d)localObject).getProvider().Ku(this.sCu.cqq);
    j.p(localObject, "MMKernel.plugin(IPluginE…der.getEmojiByMd5(it.md5)");
    k.a((EmojiInfo)localObject, this.sCr, this.faP, this.sCs);
    AppMethodBeat.o(109667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.k.b
 * JD-Core Version:    0.7.0.1
 */