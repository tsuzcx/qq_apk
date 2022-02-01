package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bes
  extends com.tencent.mm.bx.a
{
  public String DbM;
  public int DbN;
  public String szn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147769);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DbM != null) {
        paramVarArgs.d(1, this.DbM);
      }
      paramVarArgs.aR(2, this.DbN);
      if (this.szn != null) {
        paramVarArgs.d(3, this.szn);
      }
      AppMethodBeat.o(147769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DbM == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.DbM) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DbN);
      paramInt = i;
      if (this.szn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.szn);
      }
      AppMethodBeat.o(147769);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147769);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bes localbes = (bes)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147769);
          return -1;
        case 1: 
          localbes.DbM = locala.KhF.readString();
          AppMethodBeat.o(147769);
          return 0;
        case 2: 
          localbes.DbN = locala.KhF.xS();
          AppMethodBeat.o(147769);
          return 0;
        }
        localbes.szn = locala.KhF.readString();
        AppMethodBeat.o(147769);
        return 0;
      }
      AppMethodBeat.o(147769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bes
 * JD-Core Version:    0.7.0.1
 */