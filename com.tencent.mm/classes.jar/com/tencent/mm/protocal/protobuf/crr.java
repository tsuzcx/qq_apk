package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crr
  extends com.tencent.mm.bw.a
{
  public String ESn;
  public String FvA;
  public String FvB;
  public int ncL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91678);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ESn != null) {
        paramVarArgs.d(1, this.ESn);
      }
      if (this.FvB != null) {
        paramVarArgs.d(2, this.FvB);
      }
      paramVarArgs.aR(3, this.ncL);
      if (this.FvA != null) {
        paramVarArgs.d(4, this.FvA);
      }
      AppMethodBeat.o(91678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ESn == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.ESn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FvB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FvB);
      }
      i += f.a.a.b.b.a.bx(3, this.ncL);
      paramInt = i;
      if (this.FvA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FvA);
      }
      AppMethodBeat.o(91678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91678);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        crr localcrr = (crr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91678);
          return -1;
        case 1: 
          localcrr.ESn = locala.LVo.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 2: 
          localcrr.FvB = locala.LVo.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 3: 
          localcrr.ncL = locala.LVo.xF();
          AppMethodBeat.o(91678);
          return 0;
        }
        localcrr.FvA = locala.LVo.readString();
        AppMethodBeat.o(91678);
        return 0;
      }
      AppMethodBeat.o(91678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crr
 * JD-Core Version:    0.7.0.1
 */