package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class au
  extends com.tencent.mm.bw.a
{
  public String nVA;
  public String nVB;
  public String nVy;
  public String nVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113931);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nVy != null) {
        paramVarArgs.d(1, this.nVy);
      }
      if (this.nVz != null) {
        paramVarArgs.d(2, this.nVz);
      }
      if (this.nVA != null) {
        paramVarArgs.d(3, this.nVA);
      }
      if (this.nVB != null) {
        paramVarArgs.d(4, this.nVB);
      }
      AppMethodBeat.o(113931);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nVy == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.nVy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nVz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nVz);
      }
      i = paramInt;
      if (this.nVA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nVA);
      }
      paramInt = i;
      if (this.nVB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nVB);
      }
      AppMethodBeat.o(113931);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113931);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        au localau = (au)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113931);
          return -1;
        case 1: 
          localau.nVy = locala.LVo.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 2: 
          localau.nVz = locala.LVo.readString();
          AppMethodBeat.o(113931);
          return 0;
        case 3: 
          localau.nVA = locala.LVo.readString();
          AppMethodBeat.o(113931);
          return 0;
        }
        localau.nVB = locala.LVo.readString();
        AppMethodBeat.o(113931);
        return 0;
      }
      AppMethodBeat.o(113931);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.au
 * JD-Core Version:    0.7.0.1
 */