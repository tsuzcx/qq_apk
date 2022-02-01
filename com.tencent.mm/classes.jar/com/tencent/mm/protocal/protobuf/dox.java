package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dox
  extends com.tencent.mm.bx.a
{
  public String PnJ;
  public int PnK;
  public int aaVG;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258120);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "optScope", this.PnJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "optState", Integer.valueOf(this.PnK), false);
      com.tencent.mm.bk.a.a(localJSONObject, "optAvatarId", Integer.valueOf(this.aaVG), false);
      label52:
      AppMethodBeat.o(258120);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147773);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.PnJ != null) {
        paramVarArgs.g(1, this.PnJ);
      }
      paramVarArgs.bS(2, this.PnK);
      paramVarArgs.bS(3, this.aaVG);
      AppMethodBeat.o(147773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.PnJ == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = i.a.a.b.b.a.h(1, this.PnJ) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.PnK);
      int j = i.a.a.b.b.a.cJ(3, this.aaVG);
      AppMethodBeat.o(147773);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147773);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dox localdox = (dox)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147773);
          return -1;
        case 1: 
          localdox.PnJ = locala.ajGk.readString();
          AppMethodBeat.o(147773);
          return 0;
        case 2: 
          localdox.PnK = locala.ajGk.aar();
          AppMethodBeat.o(147773);
          return 0;
        }
        localdox.aaVG = locala.ajGk.aar();
        AppMethodBeat.o(147773);
        return 0;
      }
      AppMethodBeat.o(147773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dox
 * JD-Core Version:    0.7.0.1
 */