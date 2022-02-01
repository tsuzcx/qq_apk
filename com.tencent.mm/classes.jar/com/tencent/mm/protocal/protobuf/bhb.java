package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bhb
  extends com.tencent.mm.bw.a
{
  public String LQP;
  public int LQQ;
  public int LQR;
  public long LQS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LQP != null) {
        paramVarArgs.e(1, this.LQP);
      }
      paramVarArgs.aM(2, this.LQQ);
      paramVarArgs.aM(3, this.LQR);
      paramVarArgs.bb(99, this.LQS);
      AppMethodBeat.o(152542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LQP == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.LQP) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LQQ);
      int j = g.a.a.b.b.a.bu(3, this.LQR);
      int k = g.a.a.b.b.a.r(99, this.LQS);
      AppMethodBeat.o(152542);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152542);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bhb localbhb = (bhb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152542);
          return -1;
        case 1: 
          localbhb.LQP = locala.UbS.readString();
          AppMethodBeat.o(152542);
          return 0;
        case 2: 
          localbhb.LQQ = locala.UbS.zi();
          AppMethodBeat.o(152542);
          return 0;
        case 3: 
          localbhb.LQR = locala.UbS.zi();
          AppMethodBeat.o(152542);
          return 0;
        }
        localbhb.LQS = locala.UbS.zl();
        AppMethodBeat.o(152542);
        return 0;
      }
      AppMethodBeat.o(152542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhb
 * JD-Core Version:    0.7.0.1
 */