package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hu
  extends com.tencent.mm.bw.a
{
  public String FNs;
  public int FSK;
  public String FSL;
  public String FSM;
  public String jfY;
  public String nIJ;
  public String nJO;
  public int tBN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32127);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNs != null) {
        paramVarArgs.d(1, this.FNs);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      paramVarArgs.aS(4, this.FSK);
      if (this.FSL != null) {
        paramVarArgs.d(5, this.FSL);
      }
      if (this.jfY != null) {
        paramVarArgs.d(6, this.jfY);
      }
      if (this.FSM != null) {
        paramVarArgs.d(7, this.FSM);
      }
      paramVarArgs.aS(8, this.tBN);
      AppMethodBeat.o(32127);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNs == null) {
        break label624;
      }
    }
    label624:
    for (int i = f.a.a.b.b.a.e(1, this.FNs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(4, this.FSK);
      paramInt = i;
      if (this.FSL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FSL);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.jfY);
      }
      paramInt = i;
      if (this.FSM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FSM);
      }
      i = f.a.a.b.b.a.bz(8, this.tBN);
      AppMethodBeat.o(32127);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32127);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hu localhu = (hu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32127);
          return -1;
        case 1: 
          localhu.FNs = locala.OmT.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 2: 
          localhu.nJO = locala.OmT.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 3: 
          localhu.nIJ = locala.OmT.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 4: 
          localhu.FSK = locala.OmT.zc();
          AppMethodBeat.o(32127);
          return 0;
        case 5: 
          localhu.FSL = locala.OmT.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 6: 
          localhu.jfY = locala.OmT.readString();
          AppMethodBeat.o(32127);
          return 0;
        case 7: 
          localhu.FSM = locala.OmT.readString();
          AppMethodBeat.o(32127);
          return 0;
        }
        localhu.tBN = locala.OmT.zc();
        AppMethodBeat.o(32127);
        return 0;
      }
      AppMethodBeat.o(32127);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hu
 * JD-Core Version:    0.7.0.1
 */