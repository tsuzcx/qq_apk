package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwv
  extends com.tencent.mm.bx.a
{
  public int DTm;
  public int DTn;
  public String dyc;
  public String ntk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114046);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc != null) {
        paramVarArgs.d(1, this.dyc);
      }
      if (this.ntk != null) {
        paramVarArgs.d(2, this.ntk);
      }
      paramVarArgs.aR(3, this.DTm);
      paramVarArgs.aR(4, this.DTn);
      AppMethodBeat.o(114046);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyc == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ntk != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ntk);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DTm);
      int j = f.a.a.b.b.a.bA(4, this.DTn);
      AppMethodBeat.o(114046);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114046);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwv localbwv = (bwv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114046);
          return -1;
        case 1: 
          localbwv.dyc = locala.KhF.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 2: 
          localbwv.ntk = locala.KhF.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 3: 
          localbwv.DTm = locala.KhF.xS();
          AppMethodBeat.o(114046);
          return 0;
        }
        localbwv.DTn = locala.KhF.xS();
        AppMethodBeat.o(114046);
        return 0;
      }
      AppMethodBeat.o(114046);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwv
 * JD-Core Version:    0.7.0.1
 */