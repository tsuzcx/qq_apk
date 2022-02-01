package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dsr
  extends com.tencent.mm.bw.a
{
  public int MJT;
  public String MUT;
  public b MUU;
  public String Mba;
  public String Mbb;
  public String SessionId;
  public int xMB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187884);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SessionId != null) {
        paramVarArgs.e(1, this.SessionId);
      }
      if (this.Mbb != null) {
        paramVarArgs.e(2, this.Mbb);
      }
      if (this.Mba != null) {
        paramVarArgs.e(3, this.Mba);
      }
      paramVarArgs.aM(4, this.xMB);
      paramVarArgs.aM(5, this.MJT);
      if (this.MUT != null) {
        paramVarArgs.e(6, this.MUT);
      }
      if (this.MUU != null) {
        paramVarArgs.c(7, this.MUU);
      }
      AppMethodBeat.o(187884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SessionId == null) {
        break label546;
      }
    }
    label546:
    for (int i = g.a.a.b.b.a.f(1, this.SessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mbb != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mbb);
      }
      i = paramInt;
      if (this.Mba != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mba);
      }
      i = i + g.a.a.b.b.a.bu(4, this.xMB) + g.a.a.b.b.a.bu(5, this.MJT);
      paramInt = i;
      if (this.MUT != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MUT);
      }
      i = paramInt;
      if (this.MUU != null) {
        i = paramInt + g.a.a.b.b.a.b(7, this.MUU);
      }
      AppMethodBeat.o(187884);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187884);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dsr localdsr = (dsr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187884);
          return -1;
        case 1: 
          localdsr.SessionId = locala.UbS.readString();
          AppMethodBeat.o(187884);
          return 0;
        case 2: 
          localdsr.Mbb = locala.UbS.readString();
          AppMethodBeat.o(187884);
          return 0;
        case 3: 
          localdsr.Mba = locala.UbS.readString();
          AppMethodBeat.o(187884);
          return 0;
        case 4: 
          localdsr.xMB = locala.UbS.zi();
          AppMethodBeat.o(187884);
          return 0;
        case 5: 
          localdsr.MJT = locala.UbS.zi();
          AppMethodBeat.o(187884);
          return 0;
        case 6: 
          localdsr.MUT = locala.UbS.readString();
          AppMethodBeat.o(187884);
          return 0;
        }
        localdsr.MUU = locala.UbS.hPo();
        AppMethodBeat.o(187884);
        return 0;
      }
      AppMethodBeat.o(187884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsr
 * JD-Core Version:    0.7.0.1
 */