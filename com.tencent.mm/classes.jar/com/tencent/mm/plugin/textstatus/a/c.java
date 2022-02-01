package com.tencent.mm.plugin.textstatus.a;

import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "()V", "isPure", "", "onAttach", "", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "sourceJumpInfos", "backJumpInfos", "plugin-textstatus_release"})
public abstract class c
  extends i
{
  public abstract void c(String paramString, List<TextStatusJumpInfo> paramList1, List<TextStatusJumpInfo> paramList2);
  
  public abstract boolean gkH();
  
  public final void s(String paramString, List<TextStatusJumpInfo> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.c
 * JD-Core Version:    0.7.0.1
 */