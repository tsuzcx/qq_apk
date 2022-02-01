package com.tencent.mm.plugin.mv.ui.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/state/album/InitAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "previewDataObj", "Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "(Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;)V", "getPreviewDataObj", "()Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends BaseStateAction
{
  public final egz McW;
  
  public b(egz paramegz)
  {
    AppMethodBeat.i(286463);
    this.McW = paramegz;
    AppMethodBeat.o(286463);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(286487);
    if (this == paramObject)
    {
      AppMethodBeat.o(286487);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(286487);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.McW, paramObject.McW))
    {
      AppMethodBeat.o(286487);
      return false;
    }
    AppMethodBeat.o(286487);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286477);
    int i = this.McW.hashCode();
    AppMethodBeat.o(286477);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286469);
    String str = "InitAction(previewDataObj=" + this.McW + ')';
    AppMethodBeat.o(286469);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.b.a.b
 * JD-Core Version:    0.7.0.1
 */