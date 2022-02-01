package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class za
  extends com.tencent.mm.bx.a
{
  public String FYF;
  public String qXj;
  public String qXu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194940);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qXu != null) {
        paramVarArgs.d(1, this.qXu);
      }
      if (this.qXj != null) {
        paramVarArgs.d(2, this.qXj);
      }
      if (this.FYF != null) {
        paramVarArgs.d(3, this.FYF);
      }
      AppMethodBeat.o(194940);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qXu == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.qXu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qXj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qXj);
      }
      i = paramInt;
      if (this.FYF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FYF);
      }
      AppMethodBeat.o(194940);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(194940);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        za localza = (za)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194940);
          return -1;
        case 1: 
          localza.qXu = locala.NPN.readString();
          AppMethodBeat.o(194940);
          return 0;
        case 2: 
          localza.qXj = locala.NPN.readString();
          AppMethodBeat.o(194940);
          return 0;
        }
        localza.FYF = locala.NPN.readString();
        AppMethodBeat.o(194940);
        return 0;
      }
      AppMethodBeat.o(194940);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.za
 * JD-Core Version:    0.7.0.1
 */