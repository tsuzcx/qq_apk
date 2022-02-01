package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class aec
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String appName;
  public String version;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257415);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "appId", this.appId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "appName", this.appName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "version", this.version, false);
      label46:
      AppMethodBeat.o(257415);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117856);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.g(2, this.appName);
      }
      if (this.version != null) {
        paramVarArgs.g(3, this.version);
      }
      AppMethodBeat.o(117856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.appName);
      }
      i = paramInt;
      if (this.version != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.version);
      }
      AppMethodBeat.o(117856);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117856);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aec localaec = (aec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117856);
          return -1;
        case 1: 
          localaec.appId = locala.ajGk.readString();
          AppMethodBeat.o(117856);
          return 0;
        case 2: 
          localaec.appName = locala.ajGk.readString();
          AppMethodBeat.o(117856);
          return 0;
        }
        localaec.version = locala.ajGk.readString();
        AppMethodBeat.o(117856);
        return 0;
      }
      AppMethodBeat.o(117856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aec
 * JD-Core Version:    0.7.0.1
 */