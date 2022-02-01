package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bx.a
{
  public long FpT;
  public String FpZ;
  public long Fqa;
  public int Fqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FpZ != null) {
        paramVarArgs.d(1, this.FpZ);
      }
      paramVarArgs.aY(2, this.FpT);
      paramVarArgs.aY(3, this.Fqa);
      paramVarArgs.aS(4, this.Fqb);
      AppMethodBeat.o(91332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FpZ == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.FpZ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FpT);
      int j = f.a.a.b.b.a.p(3, this.Fqa);
      int k = f.a.a.b.b.a.bz(4, this.Fqb);
      AppMethodBeat.o(91332);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91332);
          return -1;
        case 1: 
          localu.FpZ = locala.NPN.readString();
          AppMethodBeat.o(91332);
          return 0;
        case 2: 
          localu.FpT = locala.NPN.zd();
          AppMethodBeat.o(91332);
          return 0;
        case 3: 
          localu.Fqa = locala.NPN.zd();
          AppMethodBeat.o(91332);
          return 0;
        }
        localu.Fqb = locala.NPN.zc();
        AppMethodBeat.o(91332);
        return 0;
      }
      AppMethodBeat.o(91332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.u
 * JD-Core Version:    0.7.0.1
 */