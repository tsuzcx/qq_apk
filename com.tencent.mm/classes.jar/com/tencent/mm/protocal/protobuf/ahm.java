package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ahm
  extends com.tencent.mm.bx.a
{
  public int pSt;
  public String pSu;
  public String pSv;
  public String pSw;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259226);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BrandFlag", Integer.valueOf(this.pSt), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExternalInfo", this.pSu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BrandInfo", this.pSv, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BrandIconURL", this.pSw, false);
      label60:
      AppMethodBeat.o(259226);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117864);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.pSt);
      if (this.pSu != null) {
        paramVarArgs.g(2, this.pSu);
      }
      if (this.pSv != null) {
        paramVarArgs.g(3, this.pSv);
      }
      if (this.pSw != null) {
        paramVarArgs.g(4, this.pSw);
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.pSt) + 0;
      paramInt = i;
      if (this.pSu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pSu);
      }
      i = paramInt;
      if (this.pSv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSv);
      }
      paramInt = i;
      if (this.pSw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSw);
      }
      AppMethodBeat.o(117864);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117864);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ahm localahm = (ahm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117864);
        return -1;
      case 1: 
        localahm.pSt = locala.ajGk.aar();
        AppMethodBeat.o(117864);
        return 0;
      case 2: 
        localahm.pSu = locala.ajGk.readString();
        AppMethodBeat.o(117864);
        return 0;
      case 3: 
        localahm.pSv = locala.ajGk.readString();
        AppMethodBeat.o(117864);
        return 0;
      }
      localahm.pSw = locala.ajGk.readString();
      AppMethodBeat.o(117864);
      return 0;
    }
    AppMethodBeat.o(117864);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahm
 * JD-Core Version:    0.7.0.1
 */