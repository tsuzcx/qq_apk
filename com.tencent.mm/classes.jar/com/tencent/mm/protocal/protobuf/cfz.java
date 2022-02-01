package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfz
  extends com.tencent.mm.bx.a
{
  public String EbM;
  public String EbN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133191);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EbM != null) {
        paramVarArgs.d(1, this.EbM);
      }
      if (this.EbN != null) {
        paramVarArgs.d(2, this.EbN);
      }
      AppMethodBeat.o(133191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EbM == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.EbM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EbN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EbN);
      }
      AppMethodBeat.o(133191);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133191);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfz localcfz = (cfz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133191);
          return -1;
        case 1: 
          localcfz.EbM = locala.KhF.readString();
          AppMethodBeat.o(133191);
          return 0;
        }
        localcfz.EbN = locala.KhF.readString();
        AppMethodBeat.o(133191);
        return 0;
      }
      AppMethodBeat.o(133191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfz
 * JD-Core Version:    0.7.0.1
 */