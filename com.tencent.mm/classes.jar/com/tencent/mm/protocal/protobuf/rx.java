package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class rx
  extends com.tencent.mm.bx.a
{
  public String Url;
  public String YWK;
  public String YWL;
  public int vhJ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257513);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Query", this.YWK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContextId", this.YWL, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Url", this.Url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Type", Integer.valueOf(this.vhJ), false);
      label60:
      AppMethodBeat.o(257513);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152989);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YWK != null) {
        paramVarArgs.g(1, this.YWK);
      }
      if (this.YWL != null) {
        paramVarArgs.g(2, this.YWL);
      }
      if (this.Url != null) {
        paramVarArgs.g(3, this.Url);
      }
      paramVarArgs.bS(4, this.vhJ);
      AppMethodBeat.o(152989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YWK == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.YWK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YWL != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YWL);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Url);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.vhJ);
      AppMethodBeat.o(152989);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152989);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        rx localrx = (rx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152989);
          return -1;
        case 1: 
          localrx.YWK = locala.ajGk.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 2: 
          localrx.YWL = locala.ajGk.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 3: 
          localrx.Url = locala.ajGk.readString();
          AppMethodBeat.o(152989);
          return 0;
        }
        localrx.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(152989);
        return 0;
      }
      AppMethodBeat.o(152989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rx
 * JD-Core Version:    0.7.0.1
 */