package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clg
  extends com.tencent.mm.bx.a
{
  public String EgD;
  public int fVE;
  public String rZo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117905);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EgD != null) {
        paramVarArgs.d(1, this.EgD);
      }
      paramVarArgs.aR(2, this.fVE);
      if (this.rZo != null) {
        paramVarArgs.d(3, this.rZo);
      }
      AppMethodBeat.o(117905);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EgD == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.EgD) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.fVE);
      paramInt = i;
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.rZo);
      }
      AppMethodBeat.o(117905);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117905);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        clg localclg = (clg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117905);
          return -1;
        case 1: 
          localclg.EgD = locala.KhF.readString();
          AppMethodBeat.o(117905);
          return 0;
        case 2: 
          localclg.fVE = locala.KhF.xS();
          AppMethodBeat.o(117905);
          return 0;
        }
        localclg.rZo = locala.KhF.readString();
        AppMethodBeat.o(117905);
        return 0;
      }
      AppMethodBeat.o(117905);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clg
 * JD-Core Version:    0.7.0.1
 */