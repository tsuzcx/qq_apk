package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$ThirdInfo;", "", "sourceId", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getJumpInfos", "()Ljava/util/List;", "getSourceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusEditActivity$e
{
  final List<TextStatusJumpInfo> DHi;
  final String sourceId;
  
  public TextStatusEditActivity$e(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    this.sourceId = paramString;
    this.DHi = paramList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(291236);
    if (this == paramObject)
    {
      AppMethodBeat.o(291236);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(291236);
      return false;
    }
    paramObject = (e)paramObject;
    if (!s.p(this.sourceId, paramObject.sourceId))
    {
      AppMethodBeat.o(291236);
      return false;
    }
    if (!s.p(this.DHi, paramObject.DHi))
    {
      AppMethodBeat.o(291236);
      return false;
    }
    AppMethodBeat.o(291236);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(291230);
    int i;
    if (this.sourceId == null)
    {
      i = 0;
      if (this.DHi != null) {
        break label46;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(291230);
      return i * 31 + j;
      i = this.sourceId.hashCode();
      break;
      label46:
      j = this.DHi.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(291222);
    String str = "ThirdInfo(sourceId=" + this.sourceId + ", jumpInfos=" + this.DHi + ')';
    AppMethodBeat.o(291222);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.e
 * JD-Core Version:    0.7.0.1
 */