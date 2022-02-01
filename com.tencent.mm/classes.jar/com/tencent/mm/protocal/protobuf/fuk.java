package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import org.json.JSONObject;

public final class fuk
  extends com.tencent.mm.bx.a
{
  public int Height;
  public int Width;
  public b abSD;
  public int abSE;
  public long abSF;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258960);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Url", this.abSD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DurationMs", Integer.valueOf(this.abSE), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Filesize", Long.valueOf(this.abSF), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Width", Integer.valueOf(this.Width), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Height", Integer.valueOf(this.Height), false);
      label80:
      AppMethodBeat.o(258960);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label80;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117938);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abSD != null) {
        paramVarArgs.d(1, this.abSD);
      }
      paramVarArgs.bS(2, this.abSE);
      paramVarArgs.bv(3, this.abSF);
      paramVarArgs.bS(4, this.Width);
      paramVarArgs.bS(5, this.Height);
      AppMethodBeat.o(117938);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abSD == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = i.a.a.b.b.a.c(1, this.abSD) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abSE);
      int j = i.a.a.b.b.a.q(3, this.abSF);
      int k = i.a.a.b.b.a.cJ(4, this.Width);
      int m = i.a.a.b.b.a.cJ(5, this.Height);
      AppMethodBeat.o(117938);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117938);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fuk localfuk = (fuk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117938);
          return -1;
        case 1: 
          localfuk.abSD = locala.ajGk.kFX();
          AppMethodBeat.o(117938);
          return 0;
        case 2: 
          localfuk.abSE = locala.ajGk.aar();
          AppMethodBeat.o(117938);
          return 0;
        case 3: 
          localfuk.abSF = locala.ajGk.aaw();
          AppMethodBeat.o(117938);
          return 0;
        case 4: 
          localfuk.Width = locala.ajGk.aar();
          AppMethodBeat.o(117938);
          return 0;
        }
        localfuk.Height = locala.ajGk.aar();
        AppMethodBeat.o(117938);
        return 0;
      }
      AppMethodBeat.o(117938);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fuk
 * JD-Core Version:    0.7.0.1
 */