package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsg
  extends com.tencent.mm.bx.a
{
  public int CVe;
  public int DwQ;
  public String DwR;
  public String vNV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vNV != null) {
        paramVarArgs.d(1, this.vNV);
      }
      paramVarArgs.aR(2, this.DwQ);
      if (this.DwR != null) {
        paramVarArgs.d(3, this.DwR);
      }
      paramVarArgs.aR(4, this.CVe);
      AppMethodBeat.o(116456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vNV == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.vNV) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DwQ);
      paramInt = i;
      if (this.DwR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DwR);
      }
      i = f.a.a.b.b.a.bA(4, this.CVe);
      AppMethodBeat.o(116456);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsg localbsg = (bsg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116456);
          return -1;
        case 1: 
          localbsg.vNV = locala.KhF.readString();
          AppMethodBeat.o(116456);
          return 0;
        case 2: 
          localbsg.DwQ = locala.KhF.xS();
          AppMethodBeat.o(116456);
          return 0;
        case 3: 
          localbsg.DwR = locala.KhF.readString();
          AppMethodBeat.o(116456);
          return 0;
        }
        localbsg.CVe = locala.KhF.xS();
        AppMethodBeat.o(116456);
        return 0;
      }
      AppMethodBeat.o(116456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsg
 * JD-Core Version:    0.7.0.1
 */