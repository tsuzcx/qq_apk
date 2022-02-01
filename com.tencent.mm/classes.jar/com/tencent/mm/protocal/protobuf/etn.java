package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class etn
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String IGU;
  public String YJY;
  public String Zjv;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257824);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Name", this.IGU, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Uuid", this.Zjv, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DeviceType", this.YJY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CreateTime", Integer.valueOf(this.CreateTime), false);
      label60:
      AppMethodBeat.o(257824);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134254);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      if (this.Zjv != null) {
        paramVarArgs.g(2, this.Zjv);
      }
      if (this.YJY != null) {
        paramVarArgs.g(3, this.YJY);
      }
      paramVarArgs.bS(4, this.CreateTime);
      AppMethodBeat.o(134254);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.IGU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zjv != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zjv);
      }
      i = paramInt;
      if (this.YJY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YJY);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.CreateTime);
      AppMethodBeat.o(134254);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(134254);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        etn localetn = (etn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134254);
          return -1;
        case 1: 
          localetn.IGU = locala.ajGk.readString();
          AppMethodBeat.o(134254);
          return 0;
        case 2: 
          localetn.Zjv = locala.ajGk.readString();
          AppMethodBeat.o(134254);
          return 0;
        case 3: 
          localetn.YJY = locala.ajGk.readString();
          AppMethodBeat.o(134254);
          return 0;
        }
        localetn.CreateTime = locala.ajGk.aar();
        AppMethodBeat.o(134254);
        return 0;
      }
      AppMethodBeat.o(134254);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etn
 * JD-Core Version:    0.7.0.1
 */