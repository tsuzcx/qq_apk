package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjv
  extends com.tencent.mm.bx.a
{
  public String DHV;
  public String DHW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123622);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DHV != null) {
        paramVarArgs.d(1, this.DHV);
      }
      if (this.DHW != null) {
        paramVarArgs.d(2, this.DHW);
      }
      AppMethodBeat.o(123622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DHV == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.DHV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DHW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DHW);
      }
      AppMethodBeat.o(123622);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123622);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bjv localbjv = (bjv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123622);
          return -1;
        case 1: 
          localbjv.DHV = locala.KhF.readString();
          AppMethodBeat.o(123622);
          return 0;
        }
        localbjv.DHW = locala.KhF.readString();
        AppMethodBeat.o(123622);
        return 0;
      }
      AppMethodBeat.o(123622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjv
 * JD-Core Version:    0.7.0.1
 */