package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dmn
  extends com.tencent.mm.bw.a
{
  public b Lqr;
  public int MJT;
  public String MQb;
  public int oUv;
  public int rBX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138185);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MQb != null) {
        paramVarArgs.e(1, this.MQb);
      }
      paramVarArgs.aM(2, this.oUv);
      paramVarArgs.aM(3, this.rBX);
      paramVarArgs.aM(4, this.MJT);
      if (this.Lqr != null) {
        paramVarArgs.c(5, this.Lqr);
      }
      AppMethodBeat.o(138185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MQb == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.b.b.a.f(1, this.MQb) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv) + g.a.a.b.b.a.bu(3, this.rBX) + g.a.a.b.b.a.bu(4, this.MJT);
      paramInt = i;
      if (this.Lqr != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.Lqr);
      }
      AppMethodBeat.o(138185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(138185);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dmn localdmn = (dmn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138185);
          return -1;
        case 1: 
          localdmn.MQb = locala.UbS.readString();
          AppMethodBeat.o(138185);
          return 0;
        case 2: 
          localdmn.oUv = locala.UbS.zi();
          AppMethodBeat.o(138185);
          return 0;
        case 3: 
          localdmn.rBX = locala.UbS.zi();
          AppMethodBeat.o(138185);
          return 0;
        case 4: 
          localdmn.MJT = locala.UbS.zi();
          AppMethodBeat.o(138185);
          return 0;
        }
        localdmn.Lqr = locala.UbS.hPo();
        AppMethodBeat.o(138185);
        return 0;
      }
      AppMethodBeat.o(138185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmn
 * JD-Core Version:    0.7.0.1
 */