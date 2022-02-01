package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dqg
  extends com.tencent.mm.bx.a
{
  public String aaWC;
  public String appid;
  public String scope;
  public int state;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257651);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "appid", this.appid, false);
      com.tencent.mm.bk.a.a(localJSONObject, "plugin_appid", this.aaWC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scope", this.scope, false);
      com.tencent.mm.bk.a.a(localJSONObject, "state", Integer.valueOf(this.state), false);
      label60:
      AppMethodBeat.o(257651);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257655);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.aaWC != null) {
        paramVarArgs.g(2, this.aaWC);
      }
      if (this.scope != null) {
        paramVarArgs.g(3, this.scope);
      }
      paramVarArgs.bS(4, this.state);
      AppMethodBeat.o(257655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaWC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaWC);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.scope);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.state);
      AppMethodBeat.o(257655);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257655);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dqg localdqg = (dqg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257655);
          return -1;
        case 1: 
          localdqg.appid = locala.ajGk.readString();
          AppMethodBeat.o(257655);
          return 0;
        case 2: 
          localdqg.aaWC = locala.ajGk.readString();
          AppMethodBeat.o(257655);
          return 0;
        case 3: 
          localdqg.scope = locala.ajGk.readString();
          AppMethodBeat.o(257655);
          return 0;
        }
        localdqg.state = locala.ajGk.aar();
        AppMethodBeat.o(257655);
        return 0;
      }
      AppMethodBeat.o(257655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqg
 * JD-Core Version:    0.7.0.1
 */