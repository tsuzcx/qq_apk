package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ess
  extends com.tencent.mm.bx.a
{
  public long aacf;
  public String aacg;
  public int abaj;
  public int abak;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258139);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "FinderObjectId", Long.valueOf(this.aacf), false);
      com.tencent.mm.bk.a.a(localJSONObject, "FinderNonceId", this.aacg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "StartTs", Integer.valueOf(this.abaj), false);
      com.tencent.mm.bk.a.a(localJSONObject, "EndTs", Integer.valueOf(this.abak), false);
      label66:
      AppMethodBeat.o(258139);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258145);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aacf);
      if (this.aacg != null) {
        paramVarArgs.g(2, this.aacg);
      }
      paramVarArgs.bS(3, this.abaj);
      paramVarArgs.bS(4, this.abak);
      AppMethodBeat.o(258145);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.aacf) + 0;
      paramInt = i;
      if (this.aacg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aacg);
      }
      i = i.a.a.b.b.a.cJ(3, this.abaj);
      int j = i.a.a.b.b.a.cJ(4, this.abak);
      AppMethodBeat.o(258145);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258145);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ess localess = (ess)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258145);
        return -1;
      case 1: 
        localess.aacf = locala.ajGk.aaw();
        AppMethodBeat.o(258145);
        return 0;
      case 2: 
        localess.aacg = locala.ajGk.readString();
        AppMethodBeat.o(258145);
        return 0;
      case 3: 
        localess.abaj = locala.ajGk.aar();
        AppMethodBeat.o(258145);
        return 0;
      }
      localess.abak = locala.ajGk.aar();
      AppMethodBeat.o(258145);
      return 0;
    }
    AppMethodBeat.o(258145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ess
 * JD-Core Version:    0.7.0.1
 */