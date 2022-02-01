package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzs
  extends com.tencent.mm.bw.a
{
  public int IeF;
  public int IeG;
  public int IeH;
  public int IeI;
  public int IeJ;
  public int IeK;
  public int IeL;
  public int IeM;
  public int IeN;
  public int IeO;
  public LinkedList<Integer> IeP;
  public int IeQ;
  public LinkedList<Integer> IeR;
  public int IeS;
  public LinkedList<Integer> IeT;
  public String IeU;
  public String IeV;
  
  public dzs()
  {
    AppMethodBeat.i(115892);
    this.IeP = new LinkedList();
    this.IeR = new LinkedList();
    this.IeT = new LinkedList();
    AppMethodBeat.o(115892);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IeF);
      paramVarArgs.aS(2, this.IeG);
      paramVarArgs.aS(3, this.IeH);
      paramVarArgs.aS(4, this.IeI);
      paramVarArgs.aS(5, this.IeJ);
      paramVarArgs.aS(6, this.IeK);
      paramVarArgs.aS(7, this.IeL);
      paramVarArgs.aS(8, this.IeM);
      paramVarArgs.aS(9, this.IeN);
      paramVarArgs.aS(10, this.IeO);
      paramVarArgs.e(11, 2, this.IeP);
      paramVarArgs.aS(12, this.IeQ);
      paramVarArgs.e(13, 2, this.IeR);
      paramVarArgs.aS(14, this.IeS);
      paramVarArgs.e(15, 2, this.IeT);
      if (this.IeU != null) {
        paramVarArgs.d(16, this.IeU);
      }
      if (this.IeV != null) {
        paramVarArgs.d(17, this.IeV);
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.IeF) + 0 + f.a.a.b.b.a.bz(2, this.IeG) + f.a.a.b.b.a.bz(3, this.IeH) + f.a.a.b.b.a.bz(4, this.IeI) + f.a.a.b.b.a.bz(5, this.IeJ) + f.a.a.b.b.a.bz(6, this.IeK) + f.a.a.b.b.a.bz(7, this.IeL) + f.a.a.b.b.a.bz(8, this.IeM) + f.a.a.b.b.a.bz(9, this.IeN) + f.a.a.b.b.a.bz(10, this.IeO) + f.a.a.a.c(11, 2, this.IeP) + f.a.a.b.b.a.bz(12, this.IeQ) + f.a.a.a.c(13, 2, this.IeR) + f.a.a.b.b.a.bz(14, this.IeS) + f.a.a.a.c(15, 2, this.IeT);
      paramInt = i;
      if (this.IeU != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.IeU);
      }
      i = paramInt;
      if (this.IeV != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.IeV);
      }
      AppMethodBeat.o(115893);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IeP.clear();
      this.IeR.clear();
      this.IeT.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzs localdzs = (dzs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115893);
        return -1;
      case 1: 
        localdzs.IeF = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 2: 
        localdzs.IeG = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 3: 
        localdzs.IeH = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 4: 
        localdzs.IeI = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 5: 
        localdzs.IeJ = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 6: 
        localdzs.IeK = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 7: 
        localdzs.IeL = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 8: 
        localdzs.IeM = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 9: 
        localdzs.IeN = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 10: 
        localdzs.IeO = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 11: 
        localdzs.IeP.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(115893);
        return 0;
      case 12: 
        localdzs.IeQ = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 13: 
        localdzs.IeR.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(115893);
        return 0;
      case 14: 
        localdzs.IeS = locala.OmT.zc();
        AppMethodBeat.o(115893);
        return 0;
      case 15: 
        localdzs.IeT.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(115893);
        return 0;
      case 16: 
        localdzs.IeU = locala.OmT.readString();
        AppMethodBeat.o(115893);
        return 0;
      }
      localdzs.IeV = locala.OmT.readString();
      AppMethodBeat.o(115893);
      return 0;
    }
    AppMethodBeat.o(115893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzs
 * JD-Core Version:    0.7.0.1
 */