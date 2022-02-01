package com.tencent.mm.pluginsdk.ui.span;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene;", "", "()V", "Companion", "SCENE", "plugin-comm_release"})
public final class t
{
  public static final t.a Kse;
  
  static
  {
    AppMethodBeat.i(223477);
    Kse = new t.a((byte)0);
    AppMethodBeat.o(223477);
  }
  
  public static final Bundle Ao(boolean paramBoolean)
  {
    AppMethodBeat.i(223478);
    if (paramBoolean)
    {
      localBundle = b.Ksg.grZ();
      AppMethodBeat.o(223478);
      return localBundle;
    }
    Bundle localBundle = b.Ksf.grZ();
    AppMethodBeat.o(223478);
    return localBundle;
  }
  
  public static final Bundle grX()
  {
    AppMethodBeat.i(223479);
    Bundle localBundle = new Bundle();
    localBundle.putString("key_wxa_short_link_launch_scene", b.Ksh.name());
    AppMethodBeat.o(223479);
    return localBundle;
  }
  
  public static final Bundle grY()
  {
    AppMethodBeat.i(223480);
    Bundle localBundle = new Bundle();
    localBundle.putString("key_wxa_short_link_launch_scene", b.Ksi.name());
    AppMethodBeat.o(223480);
    return localBundle;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "", "sceneValue", "", "preSceneValue", "(Ljava/lang/String;III)V", "getPreSceneValue", "()I", "setPreSceneValue", "(I)V", "getSceneValue", "makeData", "Landroid/os/Bundle;", "", "date", "SINGLE_CHATTING", "GROUP_CHATTING", "FAVORITE", "TIME_LINE", "FINDER", "CHATTING_RECORD_FROM_FAV", "CHATTING_RECORD_FROM_SINGLE_CHAT", "CHATTING_RECORD_FROM_GROUP_CHAT", "NOTE_FROM_FAV", "NOTE_FROM_SINGLE_CHAT", "NOTE_FROM_GROUP_CHAT", "NOTE_FROM_TIMELINE", "plugin-comm_release"})
  public static enum b
  {
    public final int Kss;
    public int Kst;
    
    static
    {
      AppMethodBeat.i(223472);
      b localb1 = new b("SINGLE_CHATTING", 0, 1007, 0);
      Ksf = localb1;
      b localb2 = new b("GROUP_CHATTING", 1, 1008, 0);
      Ksg = localb2;
      b localb3 = new b("FAVORITE", 2, 1010, 0);
      Ksh = localb3;
      b localb4 = new b("TIME_LINE", 3, 1155, 0);
      Ksi = localb4;
      b localb5 = new b("FINDER", 4, 1184, 0);
      Ksj = localb5;
      b localb6 = new b("CHATTING_RECORD_FROM_FAV", 5, 1096, 5);
      Ksk = localb6;
      b localb7 = new b("CHATTING_RECORD_FROM_SINGLE_CHAT", 6, 1096, 1);
      Ksl = localb7;
      b localb8 = new b("CHATTING_RECORD_FROM_GROUP_CHAT", 7, 1096, 2);
      Ksm = localb8;
      b localb9 = new b("NOTE_FROM_FAV", 8, 1186, 5);
      Ksn = localb9;
      b localb10 = new b("NOTE_FROM_SINGLE_CHAT", 9, 1186, 1);
      Kso = localb10;
      b localb11 = new b("NOTE_FROM_GROUP_CHAT", 10, 1186, 2);
      Ksp = localb11;
      b localb12 = new b("NOTE_FROM_TIMELINE", 11, 1186, 3);
      Ksq = localb12;
      Ksr = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10, localb11, localb12 };
      AppMethodBeat.o(223472);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.Kss = paramInt1;
      this.Kst = paramInt2;
    }
    
    public final void br(Bundle paramBundle)
    {
      AppMethodBeat.i(223474);
      p.h(paramBundle, "date");
      paramBundle.putString("key_wxa_short_link_launch_scene", name());
      AppMethodBeat.o(223474);
    }
    
    public final Bundle grZ()
    {
      AppMethodBeat.i(223473);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_wxa_short_link_launch_scene", name());
      AppMethodBeat.o(223473);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.t
 * JD-Core Version:    0.7.0.1
 */