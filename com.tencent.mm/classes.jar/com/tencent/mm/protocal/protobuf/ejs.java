package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ejs
  extends com.tencent.mm.bw.a
{
  public int FXW;
  public String HDz;
  public int HqA;
  public String ImD;
  public int ImE;
  public boolean ImF = false;
  public boolean ImG = false;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FXW);
      paramVarArgs.aS(2, this.HqA);
      if (this.session_id != null) {
        paramVarArgs.d(3, this.session_id);
      }
      if (this.ImD != null) {
        paramVarArgs.d(4, this.ImD);
      }
      if (this.HDz != null) {
        paramVarArgs.d(5, this.HDz);
      }
      paramVarArgs.aS(6, this.ImE);
      paramVarArgs.bC(7, this.ImF);
      paramVarArgs.bC(8, this.ImG);
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FXW) + 0 + f.a.a.b.b.a.bz(2, this.HqA);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.session_id);
      }
      i = paramInt;
      if (this.ImD != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ImD);
      }
      paramInt = i;
      if (this.HDz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HDz);
      }
      i = f.a.a.b.b.a.bz(6, this.ImE);
      int j = f.a.a.b.b.a.amF(7);
      int k = f.a.a.b.b.a.amF(8);
      AppMethodBeat.o(117961);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ejs localejs = (ejs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117961);
        return -1;
      case 1: 
        localejs.FXW = locala.OmT.zc();
        AppMethodBeat.o(117961);
        return 0;
      case 2: 
        localejs.HqA = locala.OmT.zc();
        AppMethodBeat.o(117961);
        return 0;
      case 3: 
        localejs.session_id = locala.OmT.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 4: 
        localejs.ImD = locala.OmT.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 5: 
        localejs.HDz = locala.OmT.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 6: 
        localejs.ImE = locala.OmT.zc();
        AppMethodBeat.o(117961);
        return 0;
      case 7: 
        localejs.ImF = locala.OmT.gvY();
        AppMethodBeat.o(117961);
        return 0;
      }
      localejs.ImG = locala.OmT.gvY();
      AppMethodBeat.o(117961);
      return 0;
    }
    AppMethodBeat.o(117961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejs
 * JD-Core Version:    0.7.0.1
 */