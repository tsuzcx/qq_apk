package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byh
  extends com.tencent.mm.bx.a
{
  public int CKO;
  public String DUX;
  public String DUY;
  public String DcB;
  public int DcC;
  public String DcD;
  public String mAQ;
  public String rZo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117887);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CKO);
      if (this.rZo != null) {
        paramVarArgs.d(2, this.rZo);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      if (this.DcB != null) {
        paramVarArgs.d(4, this.DcB);
      }
      paramVarArgs.aR(5, this.DcC);
      if (this.DcD != null) {
        paramVarArgs.d(6, this.DcD);
      }
      if (this.DUX != null) {
        paramVarArgs.d(7, this.DUX);
      }
      if (this.DUY != null) {
        paramVarArgs.d(8, this.DUY);
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CKO) + 0;
      paramInt = i;
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rZo);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mAQ);
      }
      paramInt = i;
      if (this.DcB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DcB);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DcC);
      paramInt = i;
      if (this.DcD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DcD);
      }
      i = paramInt;
      if (this.DUX != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DUX);
      }
      paramInt = i;
      if (this.DUY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DUY);
      }
      AppMethodBeat.o(117887);
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
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byh localbyh = (byh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117887);
        return -1;
      case 1: 
        localbyh.CKO = locala.KhF.xS();
        AppMethodBeat.o(117887);
        return 0;
      case 2: 
        localbyh.rZo = locala.KhF.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 3: 
        localbyh.mAQ = locala.KhF.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 4: 
        localbyh.DcB = locala.KhF.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 5: 
        localbyh.DcC = locala.KhF.xS();
        AppMethodBeat.o(117887);
        return 0;
      case 6: 
        localbyh.DcD = locala.KhF.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 7: 
        localbyh.DUX = locala.KhF.readString();
        AppMethodBeat.o(117887);
        return 0;
      }
      localbyh.DUY = locala.KhF.readString();
      AppMethodBeat.o(117887);
      return 0;
    }
    AppMethodBeat.o(117887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byh
 * JD-Core Version:    0.7.0.1
 */