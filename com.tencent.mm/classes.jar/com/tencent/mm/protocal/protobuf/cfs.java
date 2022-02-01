package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfs
  extends com.tencent.mm.bw.a
{
  public String Fua;
  public String Fub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123635);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fua != null) {
        paramVarArgs.d(1, this.Fua);
      }
      if (this.Fub != null) {
        paramVarArgs.d(2, this.Fub);
      }
      AppMethodBeat.o(123635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fua == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fua) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fub != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fub);
      }
      AppMethodBeat.o(123635);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123635);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfs localcfs = (cfs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123635);
          return -1;
        case 1: 
          localcfs.Fua = locala.LVo.readString();
          AppMethodBeat.o(123635);
          return 0;
        }
        localcfs.Fub = locala.LVo.readString();
        AppMethodBeat.o(123635);
        return 0;
      }
      AppMethodBeat.o(123635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfs
 * JD-Core Version:    0.7.0.1
 */