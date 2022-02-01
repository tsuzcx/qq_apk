package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class coh
  extends com.tencent.mm.bx.a
{
  public String aavx;
  public String aavy;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259789);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "tousername", this.aavx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "privacy_agreement_url", this.aavy, false);
      label35:
      AppMethodBeat.o(259789);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259794);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aavx != null) {
        paramVarArgs.g(1, this.aavx);
      }
      if (this.aavy != null) {
        paramVarArgs.g(2, this.aavy);
      }
      AppMethodBeat.o(259794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aavx == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.aavx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aavy != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aavy);
      }
      AppMethodBeat.o(259794);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259794);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        coh localcoh = (coh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259794);
          return -1;
        case 1: 
          localcoh.aavx = locala.ajGk.readString();
          AppMethodBeat.o(259794);
          return 0;
        }
        localcoh.aavy = locala.ajGk.readString();
        AppMethodBeat.o(259794);
        return 0;
      }
      AppMethodBeat.o(259794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coh
 * JD-Core Version:    0.7.0.1
 */