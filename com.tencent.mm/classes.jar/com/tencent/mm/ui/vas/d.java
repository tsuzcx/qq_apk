package com.tencent.mm.ui.vas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASPadConfig;", "", "()V", "mainTabSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getMainTabSet", "()Ljava/util/HashSet;", "isMainTabForPad", "", "uiCls", "Ljava/lang/Class;", "clsName", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d afQM;
  private static final HashSet<String> afQN;
  
  static
  {
    AppMethodBeat.i(249935);
    afQM = new d();
    HashSet localHashSet = new HashSet();
    localHashSet.add("com.tencent.mm.plugin.textstatus.ui.TextStatusOtherTopicFriendsActivity");
    afQN = localHashSet;
    AppMethodBeat.o(249935);
  }
  
  public static boolean bDo(String paramString)
  {
    AppMethodBeat.i(249929);
    s.u(paramString, "clsName");
    boolean bool = afQN.contains(paramString);
    AppMethodBeat.o(249929);
    return bool;
  }
  
  public static boolean cr(Class<?> paramClass)
  {
    AppMethodBeat.i(249923);
    s.u(paramClass, "uiCls");
    boolean bool = afQN.contains(paramClass.getName());
    AppMethodBeat.o(249923);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.vas.d
 * JD-Core Version:    0.7.0.1
 */