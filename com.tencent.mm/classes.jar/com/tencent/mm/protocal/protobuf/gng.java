package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class gng
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String scope;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259731);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "scope", this.scope, false);
      com.tencent.mm.bk.a.a(localJSONObject, "desc", this.desc, false);
      label35:
      AppMethodBeat.o(259731);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259738);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      AppMethodBeat.o(259738);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      AppMethodBeat.o(259738);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259738);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gng localgng = (gng)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259738);
          return -1;
        case 1: 
          localgng.scope = locala.ajGk.readString();
          AppMethodBeat.o(259738);
          return 0;
        }
        localgng.desc = locala.ajGk.readString();
        AppMethodBeat.o(259738);
        return 0;
      }
      AppMethodBeat.o(259738);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gng
 * JD-Core Version:    0.7.0.1
 */