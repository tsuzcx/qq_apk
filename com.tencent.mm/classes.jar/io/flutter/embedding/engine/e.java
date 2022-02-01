package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class e
{
  private Set<String> IYO;
  
  public e(List<String> paramList)
  {
    AppMethodBeat.i(10183);
    this.IYO = new HashSet(paramList);
    AppMethodBeat.o(10183);
  }
  
  public e(String[] paramArrayOfString)
  {
    AppMethodBeat.i(10182);
    this.IYO = new HashSet(Arrays.asList(paramArrayOfString));
    AppMethodBeat.o(10182);
  }
  
  public final String[] fuP()
  {
    AppMethodBeat.i(10184);
    String[] arrayOfString = new String[this.IYO.size()];
    arrayOfString = (String[])this.IYO.toArray(arrayOfString);
    AppMethodBeat.o(10184);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.e
 * JD-Core Version:    0.7.0.1
 */