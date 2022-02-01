package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fru
  extends com.tencent.mm.bx.a
{
  public String aavx;
  public String aavy;
  public int status;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259886);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "status", Integer.valueOf(this.status), false);
      com.tencent.mm.bk.a.a(localJSONObject, "tousername", this.aavx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "privacy_agreement_url", this.aavy, false);
      label49:
      AppMethodBeat.o(259886);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259890);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.status);
      if (this.aavx != null) {
        paramVarArgs.g(2, this.aavx);
      }
      if (this.aavy != null) {
        paramVarArgs.g(3, this.aavy);
      }
      AppMethodBeat.o(259890);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.status) + 0;
      paramInt = i;
      if (this.aavx != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aavx);
      }
      i = paramInt;
      if (this.aavy != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aavy);
      }
      AppMethodBeat.o(259890);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259890);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fru localfru = (fru)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259890);
        return -1;
      case 1: 
        localfru.status = locala.ajGk.aar();
        AppMethodBeat.o(259890);
        return 0;
      case 2: 
        localfru.aavx = locala.ajGk.readString();
        AppMethodBeat.o(259890);
        return 0;
      }
      localfru.aavy = locala.ajGk.readString();
      AppMethodBeat.o(259890);
      return 0;
    }
    AppMethodBeat.o(259890);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fru
 * JD-Core Version:    0.7.0.1
 */