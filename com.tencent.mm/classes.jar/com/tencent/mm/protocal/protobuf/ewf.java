package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ewf
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String YWK;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259814);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Query", this.YWK, false);
      label38:
      AppMethodBeat.o(259814);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259818);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IJG);
      if (this.YWK != null) {
        paramVarArgs.g(2, this.YWK);
      }
      AppMethodBeat.o(259818);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IJG) + 0;
      paramInt = i;
      if (this.YWK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YWK);
      }
      AppMethodBeat.o(259818);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259818);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ewf localewf = (ewf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259818);
        return -1;
      case 1: 
        localewf.IJG = locala.ajGk.aar();
        AppMethodBeat.o(259818);
        return 0;
      }
      localewf.YWK = locala.ajGk.readString();
      AppMethodBeat.o(259818);
      return 0;
    }
    AppMethodBeat.o(259818);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewf
 * JD-Core Version:    0.7.0.1
 */