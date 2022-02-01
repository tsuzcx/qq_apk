package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boq
  extends com.tencent.mm.bx.a
{
  public String GJt;
  public String GJu;
  public int GJv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GJt != null) {
        paramVarArgs.d(1, this.GJt);
      }
      if (this.GJu != null) {
        paramVarArgs.d(2, this.GJu);
      }
      paramVarArgs.aS(3, this.GJv);
      AppMethodBeat.o(133172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GJt == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.GJt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GJu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GJu);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GJv);
      AppMethodBeat.o(133172);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133172);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        boq localboq = (boq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133172);
          return -1;
        case 1: 
          localboq.GJt = locala.NPN.readString();
          AppMethodBeat.o(133172);
          return 0;
        case 2: 
          localboq.GJu = locala.NPN.readString();
          AppMethodBeat.o(133172);
          return 0;
        }
        localboq.GJv = locala.NPN.zc();
        AppMethodBeat.o(133172);
        return 0;
      }
      AppMethodBeat.o(133172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boq
 * JD-Core Version:    0.7.0.1
 */