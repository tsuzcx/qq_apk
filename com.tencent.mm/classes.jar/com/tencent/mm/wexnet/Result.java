package com.tencent.mm.wexnet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/Result;", "", "success", "", "codes", "", "desc", "", "", "(Z[J[Ljava/lang/String;)V", "getCodes", "()[J", "getDesc", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getSuccess", "()Z", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class Result
{
  private final long[] codes;
  private final String[] desc;
  private final boolean success;
  
  public Result(boolean paramBoolean, long[] paramArrayOfLong, String[] paramArrayOfString)
  {
    AppMethodBeat.i(231522);
    this.success = paramBoolean;
    this.codes = paramArrayOfLong;
    this.desc = paramArrayOfString;
    AppMethodBeat.o(231522);
  }
  
  public final long[] getCodes()
  {
    return this.codes;
  }
  
  public final String[] getDesc()
  {
    return this.desc;
  }
  
  public final boolean getSuccess()
  {
    return this.success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wexnet.Result
 * JD-Core Version:    0.7.0.1
 */