package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class sz
  extends com.tencent.mm.bx.a
{
  public String IHo;
  public String YYt;
  public String YYu;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260054);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "IconUrl", this.IHo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Descrption", this.YYt, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DescFormat", this.YYu, false);
      label46:
      AppMethodBeat.o(260054);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117844);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHo == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(117844);
        throw paramVarArgs;
      }
      if (this.IHo != null) {
        paramVarArgs.g(1, this.IHo);
      }
      if (this.YYt != null) {
        paramVarArgs.g(2, this.YYt);
      }
      if (this.YYu != null) {
        paramVarArgs.g(3, this.YYu);
      }
      AppMethodBeat.o(117844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHo == null) {
        break label378;
      }
    }
    label378:
    for (int i = i.a.a.b.b.a.h(1, this.IHo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YYt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YYt);
      }
      i = paramInt;
      if (this.YYu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YYu);
      }
      AppMethodBeat.o(117844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IHo == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(117844);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117844);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        sz localsz = (sz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117844);
          return -1;
        case 1: 
          localsz.IHo = locala.ajGk.readString();
          AppMethodBeat.o(117844);
          return 0;
        case 2: 
          localsz.YYt = locala.ajGk.readString();
          AppMethodBeat.o(117844);
          return 0;
        }
        localsz.YYu = locala.ajGk.readString();
        AppMethodBeat.o(117844);
        return 0;
      }
      AppMethodBeat.o(117844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sz
 * JD-Core Version:    0.7.0.1
 */