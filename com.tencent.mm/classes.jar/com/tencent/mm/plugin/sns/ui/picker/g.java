package com.tencent.mm.plugin.sns.ui.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.dmz;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "", "info", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/MediaObj;)V", "getInfo", "()Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/MediaObj;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  final dmz Qsr;
  final SnsInfo RSO;
  
  public g(SnsInfo paramSnsInfo, dmz paramdmz)
  {
    AppMethodBeat.i(308747);
    this.RSO = paramSnsInfo;
    this.Qsr = paramdmz;
    AppMethodBeat.o(308747);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(308766);
    if (this == paramObject)
    {
      AppMethodBeat.o(308766);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(308766);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.RSO, paramObject.RSO))
    {
      AppMethodBeat.o(308766);
      return false;
    }
    if (!s.p(this.Qsr, paramObject.Qsr))
    {
      AppMethodBeat.o(308766);
      return false;
    }
    AppMethodBeat.o(308766);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(308759);
    int i = this.RSO.hashCode();
    int j = this.Qsr.hashCode();
    AppMethodBeat.o(308759);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(308751);
    String str = "SnsPickerMediaInfo(info=" + this.RSO + ", mediaObj=" + this.Qsr + ')';
    AppMethodBeat.o(308751);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.g
 * JD-Core Version:    0.7.0.1
 */