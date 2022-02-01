package com.tencent.mm.plugin.recordvideo.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/EditorAudioRedDotUtil;", "", "()V", "enable", "", "value", "", "enterEditorAudioPanelCount", "getEnterEditorAudioPanelCount", "()I", "setEnterEditorAudioPanelCount", "(I)V", "enterSelectFinderVideoPanel", "getEnterSelectFinderVideoPanel", "()Z", "setEnterSelectFinderVideoPanel", "(Z)V", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "enableHelp", "", "getAccountKey", "", "key", "getAccountMMKV", "onEnterEditorAudioPanel", "onEnterSelectFinderVideoPanel", "shouldShowSelectFinderVideoTip", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a Obk;
  public boolean enable;
  private final j exj;
  
  static
  {
    AppMethodBeat.i(279568);
    Obk = new c.a((byte)0);
    AppMethodBeat.o(279568);
  }
  
  public c()
  {
    AppMethodBeat.i(279550);
    this.exj = k.cm((a)new b(this));
    AppMethodBeat.o(279550);
  }
  
  public final MultiProcessMMKV atj()
  {
    AppMethodBeat.i(279575);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.exj.getValue();
    AppMethodBeat.o(279575);
    return localMultiProcessMMKV;
  }
  
  public final int gLb()
  {
    AppMethodBeat.i(279581);
    int i = atj().decodeInt("enter_editor_audio_panel_count", 0);
    AppMethodBeat.o(279581);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<MultiProcessMMKV>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.c
 * JD-Core Version:    0.7.0.1
 */