package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgo
  extends com.tencent.mm.bx.a
{
  public String DEA;
  public int DEB;
  public String DEz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DEz != null) {
        paramVarArgs.d(1, this.DEz);
      }
      if (this.DEA != null) {
        paramVarArgs.d(2, this.DEA);
      }
      paramVarArgs.aR(3, this.DEB);
      AppMethodBeat.o(133172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DEz == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.DEz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DEA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DEA);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DEB);
      AppMethodBeat.o(133172);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133172);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bgo localbgo = (bgo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133172);
          return -1;
        case 1: 
          localbgo.DEz = locala.KhF.readString();
          AppMethodBeat.o(133172);
          return 0;
        case 2: 
          localbgo.DEA = locala.KhF.readString();
          AppMethodBeat.o(133172);
          return 0;
        }
        localbgo.DEB = locala.KhF.xS();
        AppMethodBeat.o(133172);
        return 0;
      }
      AppMethodBeat.o(133172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgo
 * JD-Core Version:    0.7.0.1
 */