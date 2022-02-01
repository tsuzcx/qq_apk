package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$ThirdInfo;", "", "sourceId", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getJumpInfos", "()Ljava/util/List;", "getSourceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-textstatus_release"})
public final class TextStatusEditActivity$e
{
  final String sourceId;
  final List<TextStatusJumpInfo> yNX;
  
  public TextStatusEditActivity$e(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    this.sourceId = paramString;
    this.yNX = paramList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232984);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.h(this.sourceId, paramObject.sourceId)) || (!p.h(this.yNX, paramObject.yNX))) {}
      }
    }
    else
    {
      AppMethodBeat.o(232984);
      return true;
    }
    AppMethodBeat.o(232984);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(232981);
    Object localObject = this.sourceId;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.yNX;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(232981);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(232979);
    String str = "ThirdInfo(sourceId=" + this.sourceId + ", jumpInfos=" + this.yNX + ")";
    AppMethodBeat.o(232979);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.e
 * JD-Core Version:    0.7.0.1
 */