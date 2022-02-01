package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nc
  extends com.tencent.mm.bw.a
{
  public String FZq;
  public String FZx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZx != null) {
        paramVarArgs.d(2, this.FZx);
      }
      if (this.FZq != null) {
        paramVarArgs.d(3, this.FZq);
      }
      AppMethodBeat.o(124417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZx == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(2, this.FZx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FZq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FZq);
      }
      AppMethodBeat.o(124417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124417);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        nc localnc = (nc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124417);
          return -1;
        case 2: 
          localnc.FZx = locala.OmT.readString();
          AppMethodBeat.o(124417);
          return 0;
        }
        localnc.FZq = locala.OmT.readString();
        AppMethodBeat.o(124417);
        return 0;
      }
      AppMethodBeat.o(124417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nc
 * JD-Core Version:    0.7.0.1
 */