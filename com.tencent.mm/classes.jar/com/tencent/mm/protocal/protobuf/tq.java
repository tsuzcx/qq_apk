package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tq
  extends com.tencent.mm.bw.a
{
  public int GjL;
  public int GjM;
  public String GjN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GjL);
      paramVarArgs.aS(2, this.GjM);
      if (this.GjN != null) {
        paramVarArgs.d(3, this.GjN);
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GjL) + 0 + f.a.a.b.b.a.bz(2, this.GjM);
      paramInt = i;
      if (this.GjN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GjN);
      }
      AppMethodBeat.o(113972);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      tq localtq = (tq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113972);
        return -1;
      case 1: 
        localtq.GjL = locala.OmT.zc();
        AppMethodBeat.o(113972);
        return 0;
      case 2: 
        localtq.GjM = locala.OmT.zc();
        AppMethodBeat.o(113972);
        return 0;
      }
      localtq.GjN = locala.OmT.readString();
      AppMethodBeat.o(113972);
      return 0;
    }
    AppMethodBeat.o(113972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tq
 * JD-Core Version:    0.7.0.1
 */