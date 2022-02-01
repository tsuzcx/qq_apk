package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class dre
  extends com.tencent.mm.bx.a
{
  public String Username;
  public double aaXd;
  public long aaXe;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260174);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Username", this.Username, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Score", Double.valueOf(this.aaXd), false);
      com.tencent.mm.bk.a.a(localJSONObject, "LastUpdateTime", Long.valueOf(this.aaXe), false);
      label52:
      AppMethodBeat.o(260174);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117880);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(117880);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      paramVarArgs.d(2, this.aaXd);
      paramVarArgs.bv(3, this.aaXe);
      AppMethodBeat.o(117880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label353;
      }
    }
    label353:
    for (paramInt = i.a.a.b.b.a.h(1, this.Username) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.q(3, this.aaXe);
      AppMethodBeat.o(117880);
      return paramInt + (i + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Username == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(117880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117880);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dre localdre = (dre)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117880);
          return -1;
        case 1: 
          localdre.Username = locala.ajGk.readString();
          AppMethodBeat.o(117880);
          return 0;
        case 2: 
          localdre.aaXd = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(117880);
          return 0;
        }
        localdre.aaXe = locala.ajGk.aaw();
        AppMethodBeat.o(117880);
        return 0;
      }
      AppMethodBeat.o(117880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dre
 * JD-Core Version:    0.7.0.1
 */