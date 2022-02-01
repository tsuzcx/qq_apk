package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class duw
  extends com.tencent.mm.bx.a
{
  public int abaL;
  public long abaM;
  public long abaN;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258912);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "field", Integer.valueOf(this.abaL), false);
      com.tencent.mm.bk.a.a(localJSONObject, "from", Long.valueOf(this.abaM), false);
      com.tencent.mm.bk.a.a(localJSONObject, "to", Long.valueOf(this.abaN), false);
      label55:
      AppMethodBeat.o(258912);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117883);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abaL);
      paramVarArgs.bv(2, this.abaM);
      paramVarArgs.bv(3, this.abaN);
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abaL);
      int i = i.a.a.b.b.a.q(2, this.abaM);
      int j = i.a.a.b.b.a.q(3, this.abaN);
      AppMethodBeat.o(117883);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      duw localduw = (duw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117883);
        return -1;
      case 1: 
        localduw.abaL = locala.ajGk.aar();
        AppMethodBeat.o(117883);
        return 0;
      case 2: 
        localduw.abaM = locala.ajGk.aaw();
        AppMethodBeat.o(117883);
        return 0;
      }
      localduw.abaN = locala.ajGk.aaw();
      AppMethodBeat.o(117883);
      return 0;
    }
    AppMethodBeat.o(117883);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duw
 * JD-Core Version:    0.7.0.1
 */