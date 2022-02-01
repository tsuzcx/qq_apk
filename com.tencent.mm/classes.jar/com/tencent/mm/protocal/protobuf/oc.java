package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oc
  extends com.tencent.mm.bw.a
{
  public int FMH;
  public int FPb;
  public String GbA;
  public int GbB;
  public int GbC;
  public int GbD;
  public int GbE;
  public int GbF;
  public long GbG;
  public LinkedList<String> GbH;
  public String Gbn;
  public int dEu;
  public LinkedList<String> ddt;
  public int heF;
  public int mwj;
  public String url;
  public int weight;
  
  public oc()
  {
    AppMethodBeat.i(188935);
    this.ddt = new LinkedList();
    this.GbH = new LinkedList();
    AppMethodBeat.o(188935);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124437);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbA != null) {
        paramVarArgs.d(1, this.GbA);
      }
      paramVarArgs.aS(2, this.weight);
      paramVarArgs.aS(3, this.GbB);
      paramVarArgs.aS(4, this.dEu);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aS(6, this.heF);
      paramVarArgs.aS(7, this.GbC);
      paramVarArgs.aS(8, this.GbD);
      paramVarArgs.aS(9, this.GbE);
      paramVarArgs.aS(10, this.GbF);
      paramVarArgs.aS(11, this.FMH);
      paramVarArgs.aS(12, this.FPb);
      paramVarArgs.aS(13, this.mwj);
      paramVarArgs.e(14, 1, this.ddt);
      paramVarArgs.aZ(15, this.GbG);
      if (this.Gbn != null) {
        paramVarArgs.d(18, this.Gbn);
      }
      paramVarArgs.e(19, 1, this.GbH);
      AppMethodBeat.o(124437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbA == null) {
        break label990;
      }
    }
    label990:
    for (paramInt = f.a.a.b.b.a.e(1, this.GbA) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.weight) + f.a.a.b.b.a.bz(3, this.GbB) + f.a.a.b.b.a.bz(4, this.dEu);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.heF) + f.a.a.b.b.a.bz(7, this.GbC) + f.a.a.b.b.a.bz(8, this.GbD) + f.a.a.b.b.a.bz(9, this.GbE) + f.a.a.b.b.a.bz(10, this.GbF) + f.a.a.b.b.a.bz(11, this.FMH) + f.a.a.b.b.a.bz(12, this.FPb) + f.a.a.b.b.a.bz(13, this.mwj) + f.a.a.a.c(14, 1, this.ddt) + f.a.a.b.b.a.p(15, this.GbG);
      paramInt = i;
      if (this.Gbn != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Gbn);
      }
      i = f.a.a.a.c(19, 1, this.GbH);
      AppMethodBeat.o(124437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ddt.clear();
        this.GbH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124437);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        oc localoc = (oc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(124437);
          return -1;
        case 1: 
          localoc.GbA = locala.OmT.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 2: 
          localoc.weight = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 3: 
          localoc.GbB = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 4: 
          localoc.dEu = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 5: 
          localoc.url = locala.OmT.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 6: 
          localoc.heF = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 7: 
          localoc.GbC = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 8: 
          localoc.GbD = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 9: 
          localoc.GbE = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 10: 
          localoc.GbF = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 11: 
          localoc.FMH = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 12: 
          localoc.FPb = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 13: 
          localoc.mwj = locala.OmT.zc();
          AppMethodBeat.o(124437);
          return 0;
        case 14: 
          localoc.ddt.add(locala.OmT.readString());
          AppMethodBeat.o(124437);
          return 0;
        case 15: 
          localoc.GbG = locala.OmT.zd();
          AppMethodBeat.o(124437);
          return 0;
        case 18: 
          localoc.Gbn = locala.OmT.readString();
          AppMethodBeat.o(124437);
          return 0;
        }
        localoc.GbH.add(locala.OmT.readString());
        AppMethodBeat.o(124437);
        return 0;
      }
      AppMethodBeat.o(124437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oc
 * JD-Core Version:    0.7.0.1
 */