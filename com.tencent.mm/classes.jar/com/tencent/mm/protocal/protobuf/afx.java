package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afx
  extends com.tencent.mm.bx.a
{
  public String CHW;
  public String COP;
  public int COQ;
  public String CVO;
  public String CVP;
  public String CVQ;
  public int CVR;
  public String DfQ;
  public int DfR;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CVO != null) {
        paramVarArgs.d(1, this.CVO);
      }
      if (this.CVP != null) {
        paramVarArgs.d(2, this.CVP);
      }
      if (this.CVQ != null) {
        paramVarArgs.d(3, this.CVQ);
      }
      paramVarArgs.aR(4, this.CVR);
      if (this.DfQ != null) {
        paramVarArgs.d(5, this.DfQ);
      }
      if (this.COP != null) {
        paramVarArgs.d(6, this.COP);
      }
      paramVarArgs.aR(7, this.COQ);
      if (this.CHW != null) {
        paramVarArgs.d(8, this.CHW);
      }
      paramVarArgs.aR(9, this.mBi);
      paramVarArgs.aR(10, this.DfR);
      AppMethodBeat.o(127456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CVO == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.b.b.a.e(1, this.CVO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CVP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CVP);
      }
      i = paramInt;
      if (this.CVQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CVQ);
      }
      i += f.a.a.b.b.a.bA(4, this.CVR);
      paramInt = i;
      if (this.DfQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DfQ);
      }
      i = paramInt;
      if (this.COP != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.COP);
      }
      i += f.a.a.b.b.a.bA(7, this.COQ);
      paramInt = i;
      if (this.CHW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CHW);
      }
      i = f.a.a.b.b.a.bA(9, this.mBi);
      int j = f.a.a.b.b.a.bA(10, this.DfR);
      AppMethodBeat.o(127456);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        afx localafx = (afx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127456);
          return -1;
        case 1: 
          localafx.CVO = locala.KhF.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 2: 
          localafx.CVP = locala.KhF.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 3: 
          localafx.CVQ = locala.KhF.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 4: 
          localafx.CVR = locala.KhF.xS();
          AppMethodBeat.o(127456);
          return 0;
        case 5: 
          localafx.DfQ = locala.KhF.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 6: 
          localafx.COP = locala.KhF.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 7: 
          localafx.COQ = locala.KhF.xS();
          AppMethodBeat.o(127456);
          return 0;
        case 8: 
          localafx.CHW = locala.KhF.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 9: 
          localafx.mBi = locala.KhF.xS();
          AppMethodBeat.o(127456);
          return 0;
        }
        localafx.DfR = locala.KhF.xS();
        AppMethodBeat.o(127456);
        return 0;
      }
      AppMethodBeat.o(127456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afx
 * JD-Core Version:    0.7.0.1
 */