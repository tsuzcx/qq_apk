package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class y
  extends com.tencent.mm.bw.a
{
  public String UrU;
  public String UrV;
  public int UrW;
  public int UrX;
  public int UrY;
  public int UrZ;
  public int Usa;
  public String sessionId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258634);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.e(1, this.sessionId);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.UrU != null) {
        paramVarArgs.e(3, this.UrU);
      }
      if (this.UrV != null) {
        paramVarArgs.e(4, this.UrV);
      }
      paramVarArgs.aM(5, this.UrW);
      paramVarArgs.aM(6, this.UrX);
      paramVarArgs.aM(7, this.UrY);
      paramVarArgs.aM(8, this.UrZ);
      paramVarArgs.aM(9, this.Usa);
      AppMethodBeat.o(258634);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label630;
      }
    }
    label630:
    for (int i = g.a.a.b.b.a.f(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.UrU != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UrU);
      }
      paramInt = i;
      if (this.UrV != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.UrV);
      }
      i = g.a.a.b.b.a.bu(5, this.UrW);
      int j = g.a.a.b.b.a.bu(6, this.UrX);
      int k = g.a.a.b.b.a.bu(7, this.UrY);
      int m = g.a.a.b.b.a.bu(8, this.UrZ);
      int n = g.a.a.b.b.a.bu(9, this.Usa);
      AppMethodBeat.o(258634);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(258634);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258634);
          return -1;
        case 1: 
          localy.sessionId = locala.UbS.readString();
          AppMethodBeat.o(258634);
          return 0;
        case 2: 
          localy.username = locala.UbS.readString();
          AppMethodBeat.o(258634);
          return 0;
        case 3: 
          localy.UrU = locala.UbS.readString();
          AppMethodBeat.o(258634);
          return 0;
        case 4: 
          localy.UrV = locala.UbS.readString();
          AppMethodBeat.o(258634);
          return 0;
        case 5: 
          localy.UrW = locala.UbS.zi();
          AppMethodBeat.o(258634);
          return 0;
        case 6: 
          localy.UrX = locala.UbS.zi();
          AppMethodBeat.o(258634);
          return 0;
        case 7: 
          localy.UrY = locala.UbS.zi();
          AppMethodBeat.o(258634);
          return 0;
        case 8: 
          localy.UrZ = locala.UbS.zi();
          AppMethodBeat.o(258634);
          return 0;
        }
        localy.Usa = locala.UbS.zi();
        AppMethodBeat.o(258634);
        return 0;
      }
      AppMethodBeat.o(258634);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.y
 * JD-Core Version:    0.7.0.1
 */