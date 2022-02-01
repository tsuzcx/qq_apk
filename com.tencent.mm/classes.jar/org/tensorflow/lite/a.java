package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] ajZj;
  private final int value;
  
  static
  {
    AppMethodBeat.i(187269);
    ajZc = new a("FLOAT32", 0, 1);
    ajZd = new a("INT32", 1, 2);
    ajZe = new a("UINT8", 2, 3);
    ajZf = new a("INT64", 3, 4);
    ajZg = new a("STRING", 4, 5);
    ajZh = new a("BOOL", 5, 6);
    ajZi = new a("INT8", 6, 9);
    ajZk = new a[] { ajZc, ajZd, ajZe, ajZf, ajZg, ajZh, ajZi };
    ajZj = values();
    AppMethodBeat.o(187269);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
  
  static a aNw(int paramInt)
  {
    AppMethodBeat.i(187257);
    Object localObject = ajZj;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      a locala = localObject[i];
      if (locala.value == paramInt)
      {
        AppMethodBeat.o(187257);
        return locala;
      }
      i += 1;
    }
    localObject = new IllegalArgumentException("DataType error: DataType " + paramInt + " is not recognized in Java (version " + TensorFlowLite.kKc() + ")");
    AppMethodBeat.o(187257);
    throw ((Throwable)localObject);
  }
  
  public final int kJY()
  {
    AppMethodBeat.i(187276);
    switch (1.ajZl[ordinal()])
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
      AppMethodBeat.o(187276);
      throw localIllegalArgumentException;
    case 1: 
    case 2: 
      AppMethodBeat.o(187276);
      return 4;
    case 3: 
    case 4: 
      AppMethodBeat.o(187276);
      return 1;
    case 5: 
      AppMethodBeat.o(187276);
      return 8;
    case 6: 
      AppMethodBeat.o(187276);
      return -1;
    }
    AppMethodBeat.o(187276);
    return -1;
  }
  
  final String kJZ()
  {
    AppMethodBeat.i(187284);
    switch (1.ajZl[ordinal()])
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
      AppMethodBeat.o(187284);
      throw localIllegalArgumentException;
    case 1: 
      AppMethodBeat.o(187284);
      return "float";
    case 2: 
      AppMethodBeat.o(187284);
      return "int";
    case 3: 
    case 4: 
      AppMethodBeat.o(187284);
      return "byte";
    case 5: 
      AppMethodBeat.o(187284);
      return "long";
    case 6: 
      AppMethodBeat.o(187284);
      return "bool";
    }
    AppMethodBeat.o(187284);
    return "string";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.tensorflow.lite.a
 * JD-Core Version:    0.7.0.1
 */