package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] UiU;
  private final int value;
  
  static
  {
    AppMethodBeat.i(238963);
    UiN = new a("FLOAT32", 0, 1);
    UiO = new a("INT32", 1, 2);
    UiP = new a("UINT8", 2, 3);
    UiQ = new a("INT64", 3, 4);
    UiR = new a("STRING", 4, 5);
    UiS = new a("BOOL", 5, 6);
    UiT = new a("INT8", 6, 9);
    UiV = new a[] { UiN, UiO, UiP, UiQ, UiR, UiS, UiT };
    UiU = values();
    AppMethodBeat.o(238963);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
  
  static a awm(int paramInt)
  {
    AppMethodBeat.i(238961);
    Object localObject = UiU;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      a locala = localObject[i];
      if (locala.value == paramInt)
      {
        AppMethodBeat.o(238961);
        return locala;
      }
      i += 1;
    }
    localObject = new IllegalArgumentException("DataType error: DataType " + paramInt + " is not recognized in Java (version " + TensorFlowLite.hQt() + ")");
    AppMethodBeat.o(238961);
    throw ((Throwable)localObject);
  }
  
  public final int hQq()
  {
    AppMethodBeat.i(238960);
    switch (1.UiW[ordinal()])
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
      AppMethodBeat.o(238960);
      throw localIllegalArgumentException;
    case 1: 
    case 2: 
      AppMethodBeat.o(238960);
      return 4;
    case 3: 
    case 4: 
      AppMethodBeat.o(238960);
      return 1;
    case 5: 
      AppMethodBeat.o(238960);
      return 8;
    case 6: 
      AppMethodBeat.o(238960);
      return -1;
    }
    AppMethodBeat.o(238960);
    return -1;
  }
  
  final String hQr()
  {
    AppMethodBeat.i(238962);
    switch (1.UiW[ordinal()])
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
      AppMethodBeat.o(238962);
      throw localIllegalArgumentException;
    case 1: 
      AppMethodBeat.o(238962);
      return "float";
    case 2: 
      AppMethodBeat.o(238962);
      return "int";
    case 3: 
    case 4: 
      AppMethodBeat.o(238962);
      return "byte";
    case 5: 
      AppMethodBeat.o(238962);
      return "long";
    case 6: 
      AppMethodBeat.o(238962);
      return "bool";
    }
    AppMethodBeat.o(238962);
    return "string";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.tensorflow.lite.a
 * JD-Core Version:    0.7.0.1
 */