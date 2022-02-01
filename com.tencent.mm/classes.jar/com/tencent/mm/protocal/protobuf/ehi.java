package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehi
  extends com.tencent.mm.bw.a
{
  public String GWZ;
  public String GXa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133208);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GWZ != null) {
        paramVarArgs.d(1, this.GWZ);
      }
      if (this.GXa != null) {
        paramVarArgs.d(2, this.GXa);
      }
      AppMethodBeat.o(133208);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GWZ == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.GWZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GXa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GXa);
      }
      AppMethodBeat.o(133208);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133208);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehi localehi = (ehi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133208);
          return -1;
        case 1: 
          localehi.GWZ = locala.OmT.readString();
          AppMethodBeat.o(133208);
          return 0;
        }
        localehi.GXa = locala.OmT.readString();
        AppMethodBeat.o(133208);
        return 0;
      }
      AppMethodBeat.o(133208);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehi
 * JD-Core Version:    0.7.0.1
 */