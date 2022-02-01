package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cu
  extends com.tencent.mm.bx.a
{
  public String Fvf;
  public int Fvg;
  public String Fvh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149137);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvf != null) {
        paramVarArgs.d(1, this.Fvf);
      }
      paramVarArgs.aS(2, this.Fvg);
      if (this.Fvh != null) {
        paramVarArgs.d(3, this.Fvh);
      }
      AppMethodBeat.o(149137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fvf == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fvf) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Fvg);
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fvh);
      }
      AppMethodBeat.o(149137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(149137);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cu localcu = (cu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149137);
          return -1;
        case 1: 
          localcu.Fvf = locala.NPN.readString();
          AppMethodBeat.o(149137);
          return 0;
        case 2: 
          localcu.Fvg = locala.NPN.zc();
          AppMethodBeat.o(149137);
          return 0;
        }
        localcu.Fvh = locala.NPN.readString();
        AppMethodBeat.o(149137);
        return 0;
      }
      AppMethodBeat.o(149137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cu
 * JD-Core Version:    0.7.0.1
 */