package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class gnh
  extends com.tencent.mm.bx.a
{
  public String aaWC;
  public String nickname;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259720);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "plugin_appid", this.aaWC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "nickname", this.nickname, false);
      label35:
      AppMethodBeat.o(259720);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259721);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaWC != null) {
        paramVarArgs.g(1, this.aaWC);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      AppMethodBeat.o(259721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaWC == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaWC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nickname);
      }
      AppMethodBeat.o(259721);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259721);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gnh localgnh = (gnh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259721);
          return -1;
        case 1: 
          localgnh.aaWC = locala.ajGk.readString();
          AppMethodBeat.o(259721);
          return 0;
        }
        localgnh.nickname = locala.ajGk.readString();
        AppMethodBeat.o(259721);
        return 0;
      }
      AppMethodBeat.o(259721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnh
 * JD-Core Version:    0.7.0.1
 */