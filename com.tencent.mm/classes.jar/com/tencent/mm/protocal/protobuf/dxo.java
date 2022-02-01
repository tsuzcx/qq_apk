package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxo
  extends com.tencent.mm.bx.a
{
  public String KHW;
  public String LwN;
  public String qwV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qwV != null) {
        paramVarArgs.d(1, this.qwV);
      }
      if (this.KHW != null) {
        paramVarArgs.d(2, this.KHW);
      }
      if (this.LwN != null) {
        paramVarArgs.d(3, this.LwN);
      }
      AppMethodBeat.o(203820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qwV == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.qwV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KHW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.KHW);
      }
      i = paramInt;
      if (this.LwN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.LwN);
      }
      AppMethodBeat.o(203820);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203820);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxo localdxo = (dxo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(203820);
          return -1;
        case 1: 
          localdxo.qwV = locala.KhF.readString();
          AppMethodBeat.o(203820);
          return 0;
        case 2: 
          localdxo.KHW = locala.KhF.readString();
          AppMethodBeat.o(203820);
          return 0;
        }
        localdxo.LwN = locala.KhF.readString();
        AppMethodBeat.o(203820);
        return 0;
      }
      AppMethodBeat.o(203820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxo
 * JD-Core Version:    0.7.0.1
 */