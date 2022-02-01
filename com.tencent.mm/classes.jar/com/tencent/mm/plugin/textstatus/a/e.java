package com.tencent.mm.plugin.textstatus.a;

import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "()V", "getBackPart", "getForePart", "isPure", "", "onAttach", "", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "sourceJumpInfos", "backJumpInfos", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
  extends k
{
  public e()
  {
    super("0");
  }
  
  public abstract void d(String paramString, List<TextStatusJumpInfo> paramList1, List<TextStatusJumpInfo> paramList2);
  
  public abstract k hFs();
  
  public abstract boolean hFt();
  
  public final void y(String paramString, List<TextStatusJumpInfo> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.e
 * JD-Core Version:    0.7.0.1
 */