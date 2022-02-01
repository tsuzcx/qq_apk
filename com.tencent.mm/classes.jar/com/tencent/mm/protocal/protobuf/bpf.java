package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpf
  extends com.tencent.mm.bw.a
{
  public String FIx;
  public int FZN;
  public String GSy;
  public long HcG;
  public String HcI;
  public int HcK;
  public int HcL;
  public String HcM;
  public int mwj;
  public int oEe;
  public String oFF;
  public String pqW;
  public int state;
  public String vvw;
  public String yiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GSy != null) {
        paramVarArgs.d(1, this.GSy);
      }
      if (this.FIx != null) {
        paramVarArgs.d(2, this.FIx);
      }
      paramVarArgs.aZ(3, this.HcG);
      paramVarArgs.aS(4, this.state);
      paramVarArgs.aS(5, this.FZN);
      paramVarArgs.aS(6, this.oEe);
      paramVarArgs.aS(7, this.HcK);
      paramVarArgs.aS(8, this.HcL);
      if (this.HcM != null) {
        paramVarArgs.d(9, this.HcM);
      }
      if (this.oFF != null) {
        paramVarArgs.d(10, this.oFF);
      }
      if (this.vvw != null) {
        paramVarArgs.d(11, this.vvw);
      }
      if (this.pqW != null) {
        paramVarArgs.d(12, this.pqW);
      }
      if (this.yiv != null) {
        paramVarArgs.d(13, this.yiv);
      }
      if (this.HcI != null) {
        paramVarArgs.d(14, this.HcI);
      }
      paramVarArgs.aS(15, this.mwj);
      AppMethodBeat.o(72506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GSy == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.b.b.a.e(1, this.GSy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FIx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FIx);
      }
      i = i + f.a.a.b.b.a.p(3, this.HcG) + f.a.a.b.b.a.bz(4, this.state) + f.a.a.b.b.a.bz(5, this.FZN) + f.a.a.b.b.a.bz(6, this.oEe) + f.a.a.b.b.a.bz(7, this.HcK) + f.a.a.b.b.a.bz(8, this.HcL);
      paramInt = i;
      if (this.HcM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HcM);
      }
      i = paramInt;
      if (this.oFF != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.oFF);
      }
      paramInt = i;
      if (this.vvw != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.vvw);
      }
      i = paramInt;
      if (this.pqW != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.pqW);
      }
      paramInt = i;
      if (this.yiv != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.yiv);
      }
      i = paramInt;
      if (this.HcI != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HcI);
      }
      paramInt = f.a.a.b.b.a.bz(15, this.mwj);
      AppMethodBeat.o(72506);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72506);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpf localbpf = (bpf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72506);
          return -1;
        case 1: 
          localbpf.GSy = locala.OmT.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 2: 
          localbpf.FIx = locala.OmT.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 3: 
          localbpf.HcG = locala.OmT.zd();
          AppMethodBeat.o(72506);
          return 0;
        case 4: 
          localbpf.state = locala.OmT.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 5: 
          localbpf.FZN = locala.OmT.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 6: 
          localbpf.oEe = locala.OmT.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 7: 
          localbpf.HcK = locala.OmT.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 8: 
          localbpf.HcL = locala.OmT.zc();
          AppMethodBeat.o(72506);
          return 0;
        case 9: 
          localbpf.HcM = locala.OmT.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 10: 
          localbpf.oFF = locala.OmT.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 11: 
          localbpf.vvw = locala.OmT.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 12: 
          localbpf.pqW = locala.OmT.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 13: 
          localbpf.yiv = locala.OmT.readString();
          AppMethodBeat.o(72506);
          return 0;
        case 14: 
          localbpf.HcI = locala.OmT.readString();
          AppMethodBeat.o(72506);
          return 0;
        }
        localbpf.mwj = locala.OmT.zc();
        AppMethodBeat.o(72506);
        return 0;
      }
      AppMethodBeat.o(72506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpf
 * JD-Core Version:    0.7.0.1
 */