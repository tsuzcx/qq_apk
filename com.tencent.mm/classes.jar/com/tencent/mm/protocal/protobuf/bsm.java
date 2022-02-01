package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsm
  extends com.tencent.mm.bx.a
{
  public String DPE;
  public String DPF;
  public String DPG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63277);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPE != null) {
        paramVarArgs.d(1, this.DPE);
      }
      if (this.DPF != null) {
        paramVarArgs.d(2, this.DPF);
      }
      if (this.DPG != null) {
        paramVarArgs.d(3, this.DPG);
      }
      AppMethodBeat.o(63277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPE == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.DPE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DPF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DPF);
      }
      i = paramInt;
      if (this.DPG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DPG);
      }
      AppMethodBeat.o(63277);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(63277);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsm localbsm = (bsm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63277);
          return -1;
        case 1: 
          localbsm.DPE = locala.KhF.readString();
          AppMethodBeat.o(63277);
          return 0;
        case 2: 
          localbsm.DPF = locala.KhF.readString();
          AppMethodBeat.o(63277);
          return 0;
        }
        localbsm.DPG = locala.KhF.readString();
        AppMethodBeat.o(63277);
        return 0;
      }
      AppMethodBeat.o(63277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsm
 * JD-Core Version:    0.7.0.1
 */