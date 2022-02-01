package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] abMp;
  private final int value;
  
  static
  {
    AppMethodBeat.i(239176);
    abMi = new a("FLOAT32", 0, 1);
    abMj = new a("INT32", 1, 2);
    abMk = new a("UINT8", 2, 3);
    abMl = new a("INT64", 3, 4);
    abMm = new a("STRING", 4, 5);
    abMn = new a("BOOL", 5, 6);
    abMo = new a("INT8", 6, 9);
    abMq = new a[] { abMi, abMj, abMk, abMl, abMm, abMn, abMo };
    abMp = values();
    AppMethodBeat.o(239176);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
  
  static a aGh(int paramInt)
  {
    AppMethodBeat.i(239168);
    Object localObject = abMp;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      a locala = localObject[i];
      if (locala.value == paramInt)
      {
        AppMethodBeat.o(239168);
        return locala;
      }
      i += 1;
    }
    localObject = new IllegalArgumentException("DataType error: DataType " + paramInt + " is not recognized in Java (version " + TensorFlowLite.iVD() + ")");
    AppMethodBeat.o(239168);
    throw ((Throwable)localObject);
  }
  
  public final int iVA()
  {
    AppMethodBeat.i(239165);
    switch (1.abMr[ordinal()])
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
      AppMethodBeat.o(239165);
      throw localIllegalArgumentException;
    case 1: 
    case 2: 
      AppMethodBeat.o(239165);
      return 4;
    case 3: 
    case 4: 
      AppMethodBeat.o(239165);
      return 1;
    case 5: 
      AppMethodBeat.o(239165);
      return 8;
    case 6: 
      AppMethodBeat.o(239165);
      return -1;
    }
    AppMethodBeat.o(239165);
    return -1;
  }
  
  final String iVB()
  {
    AppMethodBeat.i(239173);
    switch (1.abMr[ordinal()])
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
      AppMethodBeat.o(239173);
      throw localIllegalArgumentException;
    case 1: 
      AppMethodBeat.o(239173);
      return "float";
    case 2: 
      AppMethodBeat.o(239173);
      return "int";
    case 3: 
    case 4: 
      AppMethodBeat.o(239173);
      return "byte";
    case 5: 
      AppMethodBeat.o(239173);
      return "long";
    case 6: 
      AppMethodBeat.o(239173);
      return "bool";
    }
    AppMethodBeat.o(239173);
    return "string";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.tensorflow.lite.a
 * JD-Core Version:    0.7.0.1
 */