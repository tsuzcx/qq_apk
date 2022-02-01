package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ti
  extends com.tencent.mm.bw.a
{
  public String CRv;
  public String CRw;
  public int DyO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113965);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CRv != null) {
        paramVarArgs.d(1, this.CRv);
      }
      if (this.CRw != null) {
        paramVarArgs.d(2, this.CRw);
      }
      paramVarArgs.aS(3, this.DyO);
      AppMethodBeat.o(113965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRv == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.CRv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CRw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CRw);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.DyO);
      AppMethodBeat.o(113965);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113965);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ti localti = (ti)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113965);
          return -1;
        case 1: 
          localti.CRv = locala.OmT.readString();
          AppMethodBeat.o(113965);
          return 0;
        case 2: 
          localti.CRw = locala.OmT.readString();
          AppMethodBeat.o(113965);
          return 0;
        }
        localti.DyO = locala.OmT.zc();
        AppMethodBeat.o(113965);
        return 0;
      }
      AppMethodBeat.o(113965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ti
 * JD-Core Version:    0.7.0.1
 */