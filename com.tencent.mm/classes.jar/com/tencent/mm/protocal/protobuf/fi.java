package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fi
  extends com.tencent.mm.bx.a
{
  public String appId;
  public int appServiceType;
  public int euz;
  public String username;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258752);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "appId", this.appId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "username", this.username, false);
      com.tencent.mm.bk.a.a(localJSONObject, "versionType", Integer.valueOf(this.euz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "appServiceType", Integer.valueOf(this.appServiceType), false);
      label63:
      AppMethodBeat.o(258752);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258755);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bS(3, this.euz);
      paramVarArgs.bS(4, this.appServiceType);
      AppMethodBeat.o(258755);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.euz);
      int j = i.a.a.b.b.a.cJ(4, this.appServiceType);
      AppMethodBeat.o(258755);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258755);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fi localfi = (fi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258755);
          return -1;
        case 1: 
          localfi.appId = locala.ajGk.readString();
          AppMethodBeat.o(258755);
          return 0;
        case 2: 
          localfi.username = locala.ajGk.readString();
          AppMethodBeat.o(258755);
          return 0;
        case 3: 
          localfi.euz = locala.ajGk.aar();
          AppMethodBeat.o(258755);
          return 0;
        }
        localfi.appServiceType = locala.ajGk.aar();
        AppMethodBeat.o(258755);
        return 0;
      }
      AppMethodBeat.o(258755);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fi
 * JD-Core Version:    0.7.0.1
 */