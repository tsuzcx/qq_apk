package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class avt
  extends com.tencent.mm.bw.a
{
  public String GMP;
  public String GMQ;
  public b GMR;
  public int gvx;
  public String uuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuA != null) {
        paramVarArgs.d(1, this.uuA);
      }
      if (this.GMP != null) {
        paramVarArgs.d(2, this.GMP);
      }
      if (this.GMQ != null) {
        paramVarArgs.d(3, this.GMQ);
      }
      paramVarArgs.aS(4, this.gvx);
      if (this.GMR != null) {
        paramVarArgs.c(5, this.GMR);
      }
      AppMethodBeat.o(218926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuA == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.uuA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GMP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GMP);
      }
      i = paramInt;
      if (this.GMQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GMQ);
      }
      i += f.a.a.b.b.a.bz(4, this.gvx);
      paramInt = i;
      if (this.GMR != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.GMR);
      }
      AppMethodBeat.o(218926);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218926);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        avt localavt = (avt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(218926);
          return -1;
        case 1: 
          localavt.uuA = locala.OmT.readString();
          AppMethodBeat.o(218926);
          return 0;
        case 2: 
          localavt.GMP = locala.OmT.readString();
          AppMethodBeat.o(218926);
          return 0;
        case 3: 
          localavt.GMQ = locala.OmT.readString();
          AppMethodBeat.o(218926);
          return 0;
        case 4: 
          localavt.gvx = locala.OmT.zc();
          AppMethodBeat.o(218926);
          return 0;
        }
        localavt.GMR = locala.OmT.gCk();
        AppMethodBeat.o(218926);
        return 0;
      }
      AppMethodBeat.o(218926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avt
 * JD-Core Version:    0.7.0.1
 */