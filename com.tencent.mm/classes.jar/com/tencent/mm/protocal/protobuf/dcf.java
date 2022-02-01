package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcf
  extends com.tencent.mm.bx.a
{
  public String sdv;
  public String vJI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdv != null) {
        paramVarArgs.d(1, this.sdv);
      }
      if (this.vJI != null) {
        paramVarArgs.d(2, this.vJI);
      }
      AppMethodBeat.o(6437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdv == null) {
        break label282;
      }
    }
    label282:
    for (paramInt = f.a.a.b.b.a.e(1, this.sdv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vJI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vJI);
      }
      AppMethodBeat.o(6437);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(6437);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dcf localdcf = (dcf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6437);
          return -1;
        case 1: 
          localdcf.sdv = locala.KhF.readString();
          AppMethodBeat.o(6437);
          return 0;
        }
        localdcf.vJI = locala.KhF.readString();
        AppMethodBeat.o(6437);
        return 0;
      }
      AppMethodBeat.o(6437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcf
 * JD-Core Version:    0.7.0.1
 */