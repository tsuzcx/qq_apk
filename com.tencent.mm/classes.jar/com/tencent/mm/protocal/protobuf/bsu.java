package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsu
  extends com.tencent.mm.bx.a
{
  public String Name;
  public String yhw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.yhw != null) {
        paramVarArgs.d(2, this.yhw);
      }
      AppMethodBeat.o(152618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.yhw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.yhw);
      }
      AppMethodBeat.o(152618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152618);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsu localbsu = (bsu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152618);
          return -1;
        case 1: 
          localbsu.Name = locala.NPN.readString();
          AppMethodBeat.o(152618);
          return 0;
        }
        localbsu.yhw = locala.NPN.readString();
        AppMethodBeat.o(152618);
        return 0;
      }
      AppMethodBeat.o(152618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsu
 * JD-Core Version:    0.7.0.1
 */