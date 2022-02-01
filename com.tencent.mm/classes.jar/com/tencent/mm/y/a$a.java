package com.tencent.mm.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/glrender/BitmapFilter$FilterInfo;", "", "type", "", "name", "", "fileName", "(ILjava/lang/String;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getName", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  final String fileName;
  public final String name;
  public final int type;
  
  public a$a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(163147);
    this.type = paramInt;
    this.name = paramString1;
    this.fileName = paramString2;
    AppMethodBeat.o(163147);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(163150);
    if (this == paramObject)
    {
      AppMethodBeat.o(163150);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(163150);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(163150);
      return false;
    }
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(163150);
      return false;
    }
    if (!s.p(this.fileName, paramObject.fileName))
    {
      AppMethodBeat.o(163150);
      return false;
    }
    AppMethodBeat.o(163150);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(163149);
    int i = this.type;
    int j = this.name.hashCode();
    int k = this.fileName.hashCode();
    AppMethodBeat.o(163149);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(163148);
    String str = "FilterInfo(type=" + this.type + ", name=" + this.name + ", fileName=" + this.fileName + ')';
    AppMethodBeat.o(163148);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.y.a.a
 * JD-Core Version:    0.7.0.1
 */