package io.flutter.embedding.engine.dart;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DartExecutor$a
{
  public final String KMa;
  public final String KMb;
  
  public DartExecutor$a(String paramString1, String paramString2)
  {
    this.KMa = paramString1;
    this.KMb = paramString2;
  }
  
  public DartExecutor$a(String paramString1, String paramString2, byte paramByte)
  {
    this(paramString1, paramString2);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(10213);
    if (this == paramObject)
    {
      AppMethodBeat.o(10213);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(10213);
      return false;
    }
    paramObject = (a)paramObject;
    if (!this.KMa.equals(paramObject.KMa))
    {
      AppMethodBeat.o(10213);
      return false;
    }
    boolean bool = this.KMb.equals(paramObject.KMb);
    AppMethodBeat.o(10213);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(10214);
    int i = this.KMa.hashCode();
    int j = this.KMb.hashCode();
    AppMethodBeat.o(10214);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(10212);
    String str = "DartEntrypoint( bundle path: " + this.KMa + ", function: " + this.KMb + " )";
    AppMethodBeat.o(10212);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor.a
 * JD-Core Version:    0.7.0.1
 */