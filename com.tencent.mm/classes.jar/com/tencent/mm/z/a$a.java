package com.tencent.mm.z;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/glrender/BitmapFilter$FilterInfo;", "", "type", "", "name", "", "fileName", "(ILjava/lang/String;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getName", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-photoedit-sdk_release"})
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
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.type != paramObject.type) || (!p.h(this.name, paramObject.name)) || (!p.h(this.fileName, paramObject.fileName))) {}
      }
    }
    else
    {
      AppMethodBeat.o(163150);
      return true;
    }
    AppMethodBeat.o(163150);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(163149);
    int k = this.type;
    String str = this.name;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.fileName;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(163149);
      return (i + k * 31) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(163148);
    String str = "FilterInfo(type=" + this.type + ", name=" + this.name + ", fileName=" + this.fileName + ")";
    AppMethodBeat.o(163148);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.z.a.a
 * JD-Core Version:    0.7.0.1
 */