package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csk
  extends com.tencent.mm.bw.a
{
  public int HDx;
  public int HDy;
  public String HDz;
  public String dCX;
  public String dyI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188956);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dCX != null) {
        paramVarArgs.d(1, this.dCX);
      }
      paramVarArgs.aS(2, this.HDx);
      paramVarArgs.aS(3, this.HDy);
      if (this.HDz != null) {
        paramVarArgs.d(4, this.HDz);
      }
      if (this.dyI != null) {
        paramVarArgs.d(5, this.dyI);
      }
      AppMethodBeat.o(188956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dCX == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.dCX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HDx) + f.a.a.b.b.a.bz(3, this.HDy);
      paramInt = i;
      if (this.HDz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HDz);
      }
      i = paramInt;
      if (this.dyI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dyI);
      }
      AppMethodBeat.o(188956);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188956);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csk localcsk = (csk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188956);
          return -1;
        case 1: 
          localcsk.dCX = locala.OmT.readString();
          AppMethodBeat.o(188956);
          return 0;
        case 2: 
          localcsk.HDx = locala.OmT.zc();
          AppMethodBeat.o(188956);
          return 0;
        case 3: 
          localcsk.HDy = locala.OmT.zc();
          AppMethodBeat.o(188956);
          return 0;
        case 4: 
          localcsk.HDz = locala.OmT.readString();
          AppMethodBeat.o(188956);
          return 0;
        }
        localcsk.dyI = locala.OmT.readString();
        AppMethodBeat.o(188956);
        return 0;
      }
      AppMethodBeat.o(188956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csk
 * JD-Core Version:    0.7.0.1
 */