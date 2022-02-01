package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvl
  extends com.tencent.mm.bw.a
{
  public String Hej;
  public int IaU;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hej != null) {
        paramVarArgs.d(1, this.Hej);
      }
      paramVarArgs.aS(2, this.state);
      paramVarArgs.aS(3, this.IaU);
      AppMethodBeat.o(82486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hej == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hej) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.state);
      int j = f.a.a.b.b.a.bz(3, this.IaU);
      AppMethodBeat.o(82486);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82486);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvl localdvl = (dvl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82486);
          return -1;
        case 1: 
          localdvl.Hej = locala.OmT.readString();
          AppMethodBeat.o(82486);
          return 0;
        case 2: 
          localdvl.state = locala.OmT.zc();
          AppMethodBeat.o(82486);
          return 0;
        }
        localdvl.IaU = locala.OmT.zc();
        AppMethodBeat.o(82486);
        return 0;
      }
      AppMethodBeat.o(82486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvl
 * JD-Core Version:    0.7.0.1
 */