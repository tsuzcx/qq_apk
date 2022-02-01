package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ame
  extends com.tencent.mm.cd.a
{
  public boolean HHQ;
  public boolean HLd;
  public boolean HLe;
  public String HLf;
  public String HLg;
  public boolean NiN;
  public LinkedList<Integer> SwA;
  public boolean SwB;
  public String SwC;
  public int SwD;
  public long duration;
  public int kqZ;
  public int lJz;
  
  public ame()
  {
    AppMethodBeat.i(75026);
    this.SwA = new LinkedList();
    AppMethodBeat.o(75026);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(75027);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.duration);
      paramVarArgs.e(2, 2, this.SwA);
      paramVarArgs.aY(3, this.lJz);
      paramVarArgs.co(4, this.SwB);
      paramVarArgs.co(5, this.NiN);
      paramVarArgs.co(6, this.HLd);
      paramVarArgs.co(7, this.HLe);
      if (this.HLf != null) {
        paramVarArgs.f(8, this.HLf);
      }
      if (this.HLg != null) {
        paramVarArgs.f(9, this.HLg);
      }
      if (this.SwC != null) {
        paramVarArgs.f(10, this.SwC);
      }
      paramVarArgs.co(11, this.HHQ);
      paramVarArgs.aY(12, this.SwD);
      paramVarArgs.aY(13, this.kqZ);
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.duration) + 0 + g.a.a.a.c(2, 2, this.SwA) + g.a.a.b.b.a.bM(3, this.lJz) + (g.a.a.b.b.a.gL(4) + 1) + (g.a.a.b.b.a.gL(5) + 1) + (g.a.a.b.b.a.gL(6) + 1) + (g.a.a.b.b.a.gL(7) + 1);
      paramInt = i;
      if (this.HLf != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.HLf);
      }
      i = paramInt;
      if (this.HLg != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.HLg);
      }
      paramInt = i;
      if (this.SwC != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SwC);
      }
      i = g.a.a.b.b.a.gL(11);
      int j = g.a.a.b.b.a.bM(12, this.SwD);
      int k = g.a.a.b.b.a.bM(13, this.kqZ);
      AppMethodBeat.o(75027);
      return paramInt + (i + 1) + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SwA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ame localame = (ame)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(75027);
        return -1;
      case 1: 
        localame.duration = locala.abFh.AN();
        AppMethodBeat.o(75027);
        return 0;
      case 2: 
        localame.SwA.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(75027);
        return 0;
      case 3: 
        localame.lJz = locala.abFh.AK();
        AppMethodBeat.o(75027);
        return 0;
      case 4: 
        localame.SwB = locala.abFh.AB();
        AppMethodBeat.o(75027);
        return 0;
      case 5: 
        localame.NiN = locala.abFh.AB();
        AppMethodBeat.o(75027);
        return 0;
      case 6: 
        localame.HLd = locala.abFh.AB();
        AppMethodBeat.o(75027);
        return 0;
      case 7: 
        localame.HLe = locala.abFh.AB();
        AppMethodBeat.o(75027);
        return 0;
      case 8: 
        localame.HLf = locala.abFh.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 9: 
        localame.HLg = locala.abFh.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 10: 
        localame.SwC = locala.abFh.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 11: 
        localame.HHQ = locala.abFh.AB();
        AppMethodBeat.o(75027);
        return 0;
      case 12: 
        localame.SwD = locala.abFh.AK();
        AppMethodBeat.o(75027);
        return 0;
      }
      localame.kqZ = locala.abFh.AK();
      AppMethodBeat.o(75027);
      return 0;
    }
    AppMethodBeat.o(75027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ame
 * JD-Core Version:    0.7.0.1
 */