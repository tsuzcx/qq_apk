package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dab
  extends com.tencent.mm.bx.a
{
  public String DUZ;
  public String EgD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117930);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EgD != null) {
        paramVarArgs.d(1, this.EgD);
      }
      if (this.DUZ != null) {
        paramVarArgs.d(2, this.DUZ);
      }
      AppMethodBeat.o(117930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EgD == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.EgD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DUZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DUZ);
      }
      AppMethodBeat.o(117930);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117930);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dab localdab = (dab)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117930);
          return -1;
        case 1: 
          localdab.EgD = locala.KhF.readString();
          AppMethodBeat.o(117930);
          return 0;
        }
        localdab.DUZ = locala.KhF.readString();
        AppMethodBeat.o(117930);
        return 0;
      }
      AppMethodBeat.o(117930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dab
 * JD-Core Version:    0.7.0.1
 */