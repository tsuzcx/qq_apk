package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ik
  extends com.tencent.mm.bw.a
{
  public String DgJ;
  public String FTI;
  public String FTJ;
  public String FTK;
  public String FTL;
  public String dlT;
  public String uVs;
  public String wRt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91355);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FTI != null) {
        paramVarArgs.d(1, this.FTI);
      }
      if (this.DgJ != null) {
        paramVarArgs.d(2, this.DgJ);
      }
      if (this.dlT != null) {
        paramVarArgs.d(3, this.dlT);
      }
      if (this.wRt != null) {
        paramVarArgs.d(4, this.wRt);
      }
      if (this.uVs != null) {
        paramVarArgs.d(5, this.uVs);
      }
      if (this.FTJ != null) {
        paramVarArgs.d(6, this.FTJ);
      }
      if (this.FTK != null) {
        paramVarArgs.d(7, this.FTK);
      }
      if (this.FTL != null) {
        paramVarArgs.d(8, this.FTL);
      }
      AppMethodBeat.o(91355);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FTI == null) {
        break label642;
      }
    }
    label642:
    for (int i = f.a.a.b.b.a.e(1, this.FTI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DgJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DgJ);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlT);
      }
      paramInt = i;
      if (this.wRt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wRt);
      }
      i = paramInt;
      if (this.uVs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uVs);
      }
      paramInt = i;
      if (this.FTJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FTJ);
      }
      i = paramInt;
      if (this.FTK != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FTK);
      }
      paramInt = i;
      if (this.FTL != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FTL);
      }
      AppMethodBeat.o(91355);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91355);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ik localik = (ik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91355);
          return -1;
        case 1: 
          localik.FTI = locala.OmT.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 2: 
          localik.DgJ = locala.OmT.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 3: 
          localik.dlT = locala.OmT.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 4: 
          localik.wRt = locala.OmT.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 5: 
          localik.uVs = locala.OmT.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 6: 
          localik.FTJ = locala.OmT.readString();
          AppMethodBeat.o(91355);
          return 0;
        case 7: 
          localik.FTK = locala.OmT.readString();
          AppMethodBeat.o(91355);
          return 0;
        }
        localik.FTL = locala.OmT.readString();
        AppMethodBeat.o(91355);
        return 0;
      }
      AppMethodBeat.o(91355);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ik
 * JD-Core Version:    0.7.0.1
 */