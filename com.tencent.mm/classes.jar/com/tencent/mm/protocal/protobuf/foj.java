package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class foj
  extends com.tencent.mm.bx.a
{
  public int abOL;
  public String url;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258092);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "url", this.url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "vt", Integer.valueOf(this.abOL), false);
      label38:
      AppMethodBeat.o(258092);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153015);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      paramVarArgs.bS(2, this.abOL);
      AppMethodBeat.o(153015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label254;
      }
    }
    label254:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abOL);
      AppMethodBeat.o(153015);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153015);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        foj localfoj = (foj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153015);
          return -1;
        case 1: 
          localfoj.url = locala.ajGk.readString();
          AppMethodBeat.o(153015);
          return 0;
        }
        localfoj.abOL = locala.ajGk.aar();
        AppMethodBeat.o(153015);
        return 0;
      }
      AppMethodBeat.o(153015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foj
 * JD-Core Version:    0.7.0.1
 */