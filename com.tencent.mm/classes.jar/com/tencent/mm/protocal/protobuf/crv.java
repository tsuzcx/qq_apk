package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class crv
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String aayb;
  public int aayc;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258619);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestKey", this.aayb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      label52:
      AppMethodBeat.o(258619);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258622);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IJG);
      if (this.aayb != null) {
        paramVarArgs.g(2, this.aayb);
      }
      paramVarArgs.bS(3, this.aayc);
      AppMethodBeat.o(258622);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IJG) + 0;
      paramInt = i;
      if (this.aayb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aayb);
      }
      i = i.a.a.b.b.a.cJ(3, this.aayc);
      AppMethodBeat.o(258622);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258622);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      crv localcrv = (crv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258622);
        return -1;
      case 1: 
        localcrv.IJG = locala.ajGk.aar();
        AppMethodBeat.o(258622);
        return 0;
      case 2: 
        localcrv.aayb = locala.ajGk.readString();
        AppMethodBeat.o(258622);
        return 0;
      }
      localcrv.aayc = locala.ajGk.aar();
      AppMethodBeat.o(258622);
      return 0;
    }
    AppMethodBeat.o(258622);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crv
 * JD-Core Version:    0.7.0.1
 */