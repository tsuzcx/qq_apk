package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/EditorAudioRedDotUtil;", "", "()V", "enable", "", "value", "", "enterEditorAudioPanelCount", "getEnterEditorAudioPanelCount", "()I", "setEnterEditorAudioPanelCount", "(I)V", "enterSelectFinderVideoPanel", "getEnterSelectFinderVideoPanel", "()Z", "setEnterSelectFinderVideoPanel", "(Z)V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "enableHelp", "", "getAccountKey", "", "key", "getAccountMMKV", "onEnterEditorAudioPanel", "onEnterSelectFinderVideoPanel", "shouldShowSelectFinderVideoTip", "Companion", "plugin-recordvideo_release"})
public final class b
{
  public static final a IeM;
  public boolean enable;
  private final f lrB;
  
  static
  {
    AppMethodBeat.i(217308);
    IeM = new a((byte)0);
    AppMethodBeat.o(217308);
  }
  
  public b()
  {
    AppMethodBeat.i(217307);
    this.lrB = g.ar((a)new b(this));
    AppMethodBeat.o(217307);
  }
  
  public final MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(217305);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.lrB.getValue();
    AppMethodBeat.o(217305);
    return localMultiProcessMMKV;
  }
  
  public final int fzp()
  {
    AppMethodBeat.i(217306);
    int i = bcJ().decodeInt("enter_editor_audio_panel_count", 0);
    AppMethodBeat.o(217306);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/EditorAudioRedDotUtil$Companion;", "", "()V", "EDITOR_AUDIO_MMKV", "", "KEY_ENTER_EDITOR_AUDIO_PANEL_COUNT", "KEY_ENTER_SELECT_FINDER_VIDEO_PANEL", "TAG", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements a<MultiProcessMMKV>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b
 * JD-Core Version:    0.7.0.1
 */