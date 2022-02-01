package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqk
  extends com.tencent.mm.bx.a
{
  public String DDP;
  public String Ejq;
  public String pZX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122530);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pZX != null) {
        paramVarArgs.d(1, this.pZX);
      }
      if (this.Ejq != null) {
        paramVarArgs.d(2, this.Ejq);
      }
      if (this.DDP != null) {
        paramVarArgs.d(3, this.DDP);
      }
      AppMethodBeat.o(122530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pZX == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.pZX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ejq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ejq);
      }
      i = paramInt;
      if (this.DDP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DDP);
      }
      AppMethodBeat.o(122530);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122530);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqk localcqk = (cqk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122530);
          return -1;
        case 1: 
          localcqk.pZX = locala.KhF.readString();
          AppMethodBeat.o(122530);
          return 0;
        case 2: 
          localcqk.Ejq = locala.KhF.readString();
          AppMethodBeat.o(122530);
          return 0;
        }
        localcqk.DDP = locala.KhF.readString();
        AppMethodBeat.o(122530);
        return 0;
      }
      AppMethodBeat.o(122530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqk
 * JD-Core Version:    0.7.0.1
 */