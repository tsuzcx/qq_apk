package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abp
  extends com.tencent.mm.bx.a
{
  public String CTa;
  public String CTe;
  public String Dai;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91429);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CTa != null) {
        paramVarArgs.d(1, this.CTa);
      }
      if (this.Dai != null) {
        paramVarArgs.d(2, this.Dai);
      }
      if (this.CTe != null) {
        paramVarArgs.d(3, this.CTe);
      }
      AppMethodBeat.o(91429);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CTa == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.CTa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dai != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dai);
      }
      i = paramInt;
      if (this.CTe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CTe);
      }
      AppMethodBeat.o(91429);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91429);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        abp localabp = (abp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91429);
          return -1;
        case 1: 
          localabp.CTa = locala.NPN.readString();
          AppMethodBeat.o(91429);
          return 0;
        case 2: 
          localabp.Dai = locala.NPN.readString();
          AppMethodBeat.o(91429);
          return 0;
        }
        localabp.CTe = locala.NPN.readString();
        AppMethodBeat.o(91429);
        return 0;
      }
      AppMethodBeat.o(91429);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abp
 * JD-Core Version:    0.7.0.1
 */