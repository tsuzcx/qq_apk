package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ub
  extends com.tencent.mm.bx.a
{
  public String CVO;
  public String CVP;
  public String CVQ;
  public int CVR;
  public int CVS;
  public String CVT;
  public int CVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CVO != null) {
        paramVarArgs.d(1, this.CVO);
      }
      if (this.CVP != null) {
        paramVarArgs.d(2, this.CVP);
      }
      if (this.CVQ != null) {
        paramVarArgs.d(3, this.CVQ);
      }
      paramVarArgs.aR(4, this.CVR);
      paramVarArgs.aR(5, this.CVS);
      if (this.CVT != null) {
        paramVarArgs.d(6, this.CVT);
      }
      paramVarArgs.aR(7, this.CVU);
      AppMethodBeat.o(127444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CVO == null) {
        break label530;
      }
    }
    label530:
    for (int i = f.a.a.b.b.a.e(1, this.CVO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CVP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CVP);
      }
      i = paramInt;
      if (this.CVQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CVQ);
      }
      i = i + f.a.a.b.b.a.bA(4, this.CVR) + f.a.a.b.b.a.bA(5, this.CVS);
      paramInt = i;
      if (this.CVT != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CVT);
      }
      i = f.a.a.b.b.a.bA(7, this.CVU);
      AppMethodBeat.o(127444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127444);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ub localub = (ub)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127444);
          return -1;
        case 1: 
          localub.CVO = locala.KhF.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 2: 
          localub.CVP = locala.KhF.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 3: 
          localub.CVQ = locala.KhF.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 4: 
          localub.CVR = locala.KhF.xS();
          AppMethodBeat.o(127444);
          return 0;
        case 5: 
          localub.CVS = locala.KhF.xS();
          AppMethodBeat.o(127444);
          return 0;
        case 6: 
          localub.CVT = locala.KhF.readString();
          AppMethodBeat.o(127444);
          return 0;
        }
        localub.CVU = locala.KhF.xS();
        AppMethodBeat.o(127444);
        return 0;
      }
      AppMethodBeat.o(127444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ub
 * JD-Core Version:    0.7.0.1
 */