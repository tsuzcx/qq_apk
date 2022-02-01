package com.tencent.mm.sns_compose.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/GalleryData;", "", "flipItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FlipItem;", "Lkotlin/collections/ArrayList;", "position", "", "(Ljava/util/ArrayList;I)V", "getFlipItem", "()Ljava/util/ArrayList;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final ArrayList<bzi> aczd;
  public final int position;
  
  public a(ArrayList<bzi> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(235481);
    this.aczd = paramArrayList;
    this.position = paramInt;
    AppMethodBeat.o(235481);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(235511);
    if (this == paramObject)
    {
      AppMethodBeat.o(235511);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(235511);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.aczd, paramObject.aczd))
    {
      AppMethodBeat.o(235511);
      return false;
    }
    if (this.position != paramObject.position)
    {
      AppMethodBeat.o(235511);
      return false;
    }
    AppMethodBeat.o(235511);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(235501);
    int i = this.aczd.hashCode();
    int j = this.position;
    AppMethodBeat.o(235501);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(235491);
    String str = "GalleryData(flipItem=" + this.aczd + ", position=" + this.position + ')';
    AppMethodBeat.o(235491);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sns_compose.a.a
 * JD-Core Version:    0.7.0.1
 */