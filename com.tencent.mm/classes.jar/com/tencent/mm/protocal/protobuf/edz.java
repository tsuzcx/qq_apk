package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edz
  extends com.tencent.mm.bx.a
{
  public String HPl;
  public String dwW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117945);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HPl != null) {
        paramVarArgs.d(1, this.HPl);
      }
      if (this.dwW != null) {
        paramVarArgs.d(2, this.dwW);
      }
      AppMethodBeat.o(117945);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HPl == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.HPl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dwW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dwW);
      }
      AppMethodBeat.o(117945);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117945);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edz localedz = (edz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117945);
          return -1;
        case 1: 
          localedz.HPl = locala.NPN.readString();
          AppMethodBeat.o(117945);
          return 0;
        }
        localedz.dwW = locala.NPN.readString();
        AppMethodBeat.o(117945);
        return 0;
      }
      AppMethodBeat.o(117945);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edz
 * JD-Core Version:    0.7.0.1
 */