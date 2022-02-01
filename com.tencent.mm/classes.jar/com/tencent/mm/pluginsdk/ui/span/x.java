package com.tencent.mm.pluginsdk.ui.span;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene;", "", "()V", "Companion", "SCENE", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final x.a YpG;
  
  static
  {
    AppMethodBeat.i(245174);
    YpG = new x.a((byte)0);
    AppMethodBeat.o(245174);
  }
  
  public static final Bundle aq(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(245167);
    if (paramBoolean) {}
    for (Bundle localBundle = b.YpJ.awY(paramInt);; localBundle = b.YpI.awY(paramInt))
    {
      localBundle.putInt("key_wxa_short_link_launch_chat_type", paramInt);
      AppMethodBeat.o(245167);
      return localBundle;
    }
  }
  
  public static final Bundle iNN()
  {
    AppMethodBeat.i(245169);
    Bundle localBundle = new Bundle();
    localBundle.putString("key_wxa_short_link_launch_scene", b.YpK.name());
    AppMethodBeat.o(245169);
    return localBundle;
  }
  
  public static final Bundle iNO()
  {
    AppMethodBeat.i(245171);
    Bundle localBundle = new Bundle();
    localBundle.putString("key_wxa_short_link_launch_scene", b.YpL.name());
    AppMethodBeat.o(245171);
    return localBundle;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/span/WxaShortLinkScene$SCENE;", "", "sceneValue", "", "preSceneValue", "(Ljava/lang/String;III)V", "getPreSceneValue", "()I", "setPreSceneValue", "(I)V", "getSceneValue", "makeData", "", "date", "Landroid/os/Bundle;", "chatType", "SINGLE_CHATTING", "GROUP_CHATTING", "FAVORITE", "TIME_LINE", "FINDER", "CHATTING_RECORD_FROM_FAV", "CHATTING_RECORD_FROM_SINGLE_CHAT", "CHATTING_RECORD_FROM_GROUP_CHAT", "NOTE_FROM_FAV", "NOTE_FROM_SINGLE_CHAT", "NOTE_FROM_GROUP_CHAT", "NOTE_FROM_TIMELINE", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    public final int CKA;
    public int YpH;
    
    static
    {
      AppMethodBeat.i(245195);
      YpI = new b("SINGLE_CHATTING", 0, 1007, 0);
      YpJ = new b("GROUP_CHATTING", 1, 1008, 0);
      YpK = new b("FAVORITE", 2, 1010, 0);
      YpL = new b("TIME_LINE", 3, 1155, 0);
      YpM = new b("FINDER", 4, 1184, 0);
      YpN = new b("CHATTING_RECORD_FROM_FAV", 5, 1096, 5);
      YpO = new b("CHATTING_RECORD_FROM_SINGLE_CHAT", 6, 1096, 1);
      YpP = new b("CHATTING_RECORD_FROM_GROUP_CHAT", 7, 1096, 2);
      YpQ = new b("NOTE_FROM_FAV", 8, 1186, 5);
      YpR = new b("NOTE_FROM_SINGLE_CHAT", 9, 1186, 1);
      YpS = new b("NOTE_FROM_GROUP_CHAT", 10, 1186, 2);
      YpT = new b("NOTE_FROM_TIMELINE", 11, 1186, 3);
      YpU = new b[] { YpI, YpJ, YpK, YpL, YpM, YpN, YpO, YpP, YpQ, YpR, YpS, YpT };
      AppMethodBeat.o(245195);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.CKA = paramInt1;
      this.YpH = paramInt2;
    }
    
    public final Bundle awY(int paramInt)
    {
      AppMethodBeat.i(245198);
      Bundle localBundle = new Bundle();
      localBundle.putString("key_wxa_short_link_launch_scene", name());
      localBundle.putInt("key_wxa_short_link_launch_chat_type", paramInt);
      AppMethodBeat.o(245198);
      return localBundle;
    }
    
    public final void d(Bundle paramBundle, int paramInt)
    {
      AppMethodBeat.i(245204);
      s.u(paramBundle, "date");
      paramBundle.putString("key_wxa_short_link_launch_scene", name());
      paramBundle.putInt("key_wxa_short_link_launch_chat_type", paramInt);
      AppMethodBeat.o(245204);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.x
 * JD-Core Version:    0.7.0.1
 */