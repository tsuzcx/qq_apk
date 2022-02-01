package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbf
  extends com.tencent.mm.bx.a
{
  public int EsR;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EsR);
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      AppMethodBeat.o(152711);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EsR) + 0;
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      AppMethodBeat.o(152711);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152711);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dbf localdbf = (dbf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152711);
        return -1;
      case 1: 
        localdbf.EsR = locala.KhF.xS();
        AppMethodBeat.o(152711);
        return 0;
      }
      localdbf.mAQ = locala.KhF.readString();
      AppMethodBeat.o(152711);
      return 0;
    }
    AppMethodBeat.o(152711);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbf
 * JD-Core Version:    0.7.0.1
 */