package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class avr
  extends com.tencent.mm.bw.a
{
  public String GMJ;
  public int GMK;
  public int GML;
  public long GMM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GMJ != null) {
        paramVarArgs.d(1, this.GMJ);
      }
      paramVarArgs.aS(2, this.GMK);
      paramVarArgs.aS(3, this.GML);
      paramVarArgs.aZ(99, this.GMM);
      AppMethodBeat.o(152542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GMJ == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.GMJ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GMK);
      int j = f.a.a.b.b.a.bz(3, this.GML);
      int k = f.a.a.b.b.a.p(99, this.GMM);
      AppMethodBeat.o(152542);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152542);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        avr localavr = (avr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152542);
          return -1;
        case 1: 
          localavr.GMJ = locala.OmT.readString();
          AppMethodBeat.o(152542);
          return 0;
        case 2: 
          localavr.GMK = locala.OmT.zc();
          AppMethodBeat.o(152542);
          return 0;
        case 3: 
          localavr.GML = locala.OmT.zc();
          AppMethodBeat.o(152542);
          return 0;
        }
        localavr.GMM = locala.OmT.zd();
        AppMethodBeat.o(152542);
        return 0;
      }
      AppMethodBeat.o(152542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avr
 * JD-Core Version:    0.7.0.1
 */