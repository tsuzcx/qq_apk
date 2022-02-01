package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkt
  extends com.tencent.mm.bx.a
{
  public int Ctr;
  public String DAn;
  public String DIt;
  public boolean DIu;
  public String DIv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123623);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ctr);
      if (this.DIt != null) {
        paramVarArgs.d(2, this.DIt);
      }
      paramVarArgs.bg(3, this.DIu);
      if (this.DIv != null) {
        paramVarArgs.d(4, this.DIv);
      }
      if (this.DAn != null) {
        paramVarArgs.d(5, this.DAn);
      }
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Ctr) + 0;
      paramInt = i;
      if (this.DIt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DIt);
      }
      i = paramInt + (f.a.a.b.b.a.fY(3) + 1);
      paramInt = i;
      if (this.DIv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DIv);
      }
      i = paramInt;
      if (this.DAn != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DAn);
      }
      AppMethodBeat.o(123623);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123623);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkt localbkt = (bkt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123623);
        return -1;
      case 1: 
        localbkt.Ctr = locala.KhF.xS();
        AppMethodBeat.o(123623);
        return 0;
      case 2: 
        localbkt.DIt = locala.KhF.readString();
        AppMethodBeat.o(123623);
        return 0;
      case 3: 
        localbkt.DIu = locala.KhF.fHu();
        AppMethodBeat.o(123623);
        return 0;
      case 4: 
        localbkt.DIv = locala.KhF.readString();
        AppMethodBeat.o(123623);
        return 0;
      }
      localbkt.DAn = locala.KhF.readString();
      AppMethodBeat.o(123623);
      return 0;
    }
    AppMethodBeat.o(123623);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkt
 * JD-Core Version:    0.7.0.1
 */