package io.flutter.embedding.engine.dart;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class DartExecutor$a
{
  public final String aaqL;
  public final String aaqM;
  public final String aaqN;
  
  public DartExecutor$a(String paramString1, String paramString2)
  {
    this.aaqL = paramString1;
    this.aaqM = null;
    this.aaqN = paramString2;
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
    if (!this.aaqL.equals(paramObject.aaqL))
    {
      AppMethodBeat.o(10213);
      return false;
    }
    boolean bool = this.aaqN.equals(paramObject.aaqN);
    AppMethodBeat.o(10213);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(10214);
    int i = this.aaqL.hashCode();
    int j = this.aaqN.hashCode();
    AppMethodBeat.o(10214);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(10212);
    String str = "DartEntrypoint( bundle path: " + this.aaqL + ", function: " + this.aaqN + " )";
    AppMethodBeat.o(10212);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor.a
 * JD-Core Version:    0.7.0.1
 */