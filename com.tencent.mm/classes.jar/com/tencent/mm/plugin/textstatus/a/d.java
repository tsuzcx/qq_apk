package com.tencent.mm.plugin.textstatus.a;

import com.tencent.mm.plugin.textstatus.proto.au;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomElements;", "", "()V", "getElement", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "elementType", "", "elementKey", "", "onAttach", "", "textStatusID", "jumpElements", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpElement;", "onDetach", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
{
  public abstract k bdo(String paramString);
  
  public abstract void onDetach();
  
  public abstract void y(String paramString, List<au> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.d
 * JD-Core Version:    0.7.0.1
 */