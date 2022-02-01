package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dnw
  extends com.tencent.mm.bw.a
{
  public String FQp;
  public String hCp;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQp != null) {
        paramVarArgs.d(1, this.FQp);
      }
      if (this.hCp != null) {
        paramVarArgs.d(2, this.hCp);
      }
      paramVarArgs.aS(3, this.weight);
      AppMethodBeat.o(124569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQp == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.FQp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hCp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hCp);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.weight);
      AppMethodBeat.o(124569);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124569);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnw localdnw = (dnw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124569);
          return -1;
        case 1: 
          localdnw.FQp = locala.OmT.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 2: 
          localdnw.hCp = locala.OmT.readString();
          AppMethodBeat.o(124569);
          return 0;
        }
        localdnw.weight = locala.OmT.zc();
        AppMethodBeat.o(124569);
        return 0;
      }
      AppMethodBeat.o(124569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnw
 * JD-Core Version:    0.7.0.1
 */