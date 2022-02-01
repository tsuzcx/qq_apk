package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bon
  extends com.tencent.mm.bw.a
{
  public String HbQ;
  public String HbR;
  public String HbS;
  public String HbT;
  public String HbU;
  public String HbV;
  public String HbW;
  public String hnD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbQ != null) {
        paramVarArgs.d(1, this.HbQ);
      }
      if (this.HbR != null) {
        paramVarArgs.d(2, this.HbR);
      }
      if (this.hnD != null) {
        paramVarArgs.d(3, this.hnD);
      }
      if (this.HbS != null) {
        paramVarArgs.d(4, this.HbS);
      }
      if (this.HbT != null) {
        paramVarArgs.d(5, this.HbT);
      }
      if (this.HbU != null) {
        paramVarArgs.d(6, this.HbU);
      }
      if (this.HbV != null) {
        paramVarArgs.d(7, this.HbV);
      }
      if (this.HbW != null) {
        paramVarArgs.d(8, this.HbW);
      }
      AppMethodBeat.o(91521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HbQ == null) {
        break label642;
      }
    }
    label642:
    for (int i = f.a.a.b.b.a.e(1, this.HbQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HbR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HbR);
      }
      i = paramInt;
      if (this.hnD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hnD);
      }
      paramInt = i;
      if (this.HbS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HbS);
      }
      i = paramInt;
      if (this.HbT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HbT);
      }
      paramInt = i;
      if (this.HbU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HbU);
      }
      i = paramInt;
      if (this.HbV != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HbV);
      }
      paramInt = i;
      if (this.HbW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HbW);
      }
      AppMethodBeat.o(91521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91521);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bon localbon = (bon)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91521);
          return -1;
        case 1: 
          localbon.HbQ = locala.OmT.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 2: 
          localbon.HbR = locala.OmT.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 3: 
          localbon.hnD = locala.OmT.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 4: 
          localbon.HbS = locala.OmT.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 5: 
          localbon.HbT = locala.OmT.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 6: 
          localbon.HbU = locala.OmT.readString();
          AppMethodBeat.o(91521);
          return 0;
        case 7: 
          localbon.HbV = locala.OmT.readString();
          AppMethodBeat.o(91521);
          return 0;
        }
        localbon.HbW = locala.OmT.readString();
        AppMethodBeat.o(91521);
        return 0;
      }
      AppMethodBeat.o(91521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bon
 * JD-Core Version:    0.7.0.1
 */