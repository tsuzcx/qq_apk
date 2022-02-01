package com.tencent.mm.pluginsdk.ui.span;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene;", "", "()V", "Companion", "SCENE", "plugin-comm_release"})
public final class t
{
  public static final t.a Rtl;
  
  static
  {
    AppMethodBeat.i(192039);
    Rtl = new t.a((byte)0);
    AppMethodBeat.o(192039);
  }
  
  public static final Bundle ap(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(192046);
    if (paramBoolean) {}
    for (Bundle localBundle = b.Rtn.aqS(paramInt);; localBundle = b.Rtm.aqS(paramInt))
    {
      localBundle.putInt("key_wxa_short_link_launch_chat_type", paramInt);
      AppMethodBeat.o(192046);
      return localBundle;
    }
  }
  
  public static final Bundle hmX()
  {
    AppMethodBeat.i(192049);
    Bundle localBundle = new Bundle();
    localBundle.putString("key_wxa_short_link_launch_scene", b.Rto.name());
    AppMethodBeat.o(192049);
    return localBundle;
  }
  
  public static final Bundle hmY()
  {
    AppMethodBeat.i(192053);
    Bundle localBundle = new Bundle();
    localBundle.putString("key_wxa_short_link_launch_scene", b.Rtp.name());
    AppMethodBeat.o(192053);
    return localBundle;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "", "sceneValue", "", "preSceneValue", "(Ljava/lang/String;III)V", "getPreSceneValue", "()I", "setPreSceneValue", "(I)V", "getSceneValue", "makeData", "", "date", "Landroid/os/Bundle;", "chatType", "SINGLE_CHATTING", "GROUP_CHATTING", "FAVORITE", "TIME_LINE", "FINDER", "CHATTING_RECORD_FROM_FAV", "CHATTING_RECORD_FROM_SINGLE_CHAT", "CHATTING_RECORD_FROM_GROUP_CHAT", "NOTE_FROM_FAV", "NOTE_FROM_SINGLE_CHAT", "NOTE_FROM_GROUP_CHAT", "NOTE_FROM_TIMELINE", "plugin-comm_release"})
  public static enum b
  {
    public int RtA;
    public final int Rtz;
    
    static
    {
      AppMethodBeat.i(229535);
      b localb1 = new b("SINGLE_CHATTING", 0, 1007, 0);
      Rtm = localb1;
      b localb2 = new b("GROUP_CHATTING", 1, 1008, 0);
      Rtn = localb2;
      b localb3 = new b("FAVORITE", 2, 1010, 0);
      Rto = localb3;
      b localb4 = new b("TIME_LINE", 3, 1155, 0);
      Rtp = localb4;
      b localb5 = new b("FINDER", 4, 1184, 0);
      Rtq = localb5;
      b localb6 = new b("CHATTING_RECORD_FROM_FAV", 5, 1096, 5);
      Rtr = localb6;
      b localb7 = new b("CHATTING_RECORD_FROM_SINGLE_CHAT", 6, 1096, 1);
      Rts = localb7;
      b localb8 = new b("CHATTING_RECORD_FROM_GROUP_CHAT", 7, 1096, 2);
      Rtt = localb8;
      b localb9 = new b("NOTE_FROM_FAV", 8, 1186, 5);
      Rtu = localb9;
      b localb10 = new b("NOTE_FROM_SINGLE_CHAT", 9, 1186, 1);
      Rtv = localb10;
      b localb11 = new b("NOTE_FROM_GROUP_CHAT", 10, 1186, 2);
      Rtw = localb11;
      b localb12 = new b("NOTE_FROM_TIMELINE", 11, 1186, 3);
      Rtx = localb12;
      Rty = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10, localb11, localb12 };
      AppMethodBeat.o(229535);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.Rtz = paramInt1;
      this.RtA = paramInt2;
    }
    
    public final Bundle aqS(int paramInt)
    {
      AppMethodBeat.i(229536);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_wxa_short_link_launch_scene", name());
      localBundle.putInt("key_wxa_short_link_launch_chat_type", paramInt);
      AppMethodBeat.o(229536);
      return localBundle;
    }
    
    public final void e(Bundle paramBundle, int paramInt)
    {
      AppMethodBeat.i(229537);
      p.k(paramBundle, "date");
      paramBundle.putString("key_wxa_short_link_launch_scene", name());
      paramBundle.putInt("key_wxa_short_link_launch_chat_type", paramInt);
      AppMethodBeat.o(229537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.t
 * JD-Core Version:    0.7.0.1
 */