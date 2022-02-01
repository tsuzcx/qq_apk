package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgs
  extends com.tencent.mm.bx.a
{
  public int abGB;
  public int abGC;
  public int abGD;
  public fzn abGE;
  public int abGF;
  public int abGG;
  public int abGH;
  public int abGI;
  public LinkedList<Integer> abGJ;
  public int abGK;
  public LinkedList<Integer> abGL;
  public int abGM;
  public LinkedList<Integer> abGN;
  public String abGO;
  
  public fgs()
  {
    AppMethodBeat.i(115851);
    this.abGJ = new LinkedList();
    this.abGL = new LinkedList();
    this.abGN = new LinkedList();
    AppMethodBeat.o(115851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115852);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abGE == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.abGB);
      paramVarArgs.bS(2, this.abGC);
      paramVarArgs.bS(3, this.abGD);
      if (this.abGE != null)
      {
        paramVarArgs.qD(4, this.abGE.computeSize());
        this.abGE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.abGF);
      paramVarArgs.bS(6, this.abGG);
      paramVarArgs.bS(7, this.abGH);
      paramVarArgs.bS(8, this.abGI);
      paramVarArgs.f(9, 2, this.abGJ);
      paramVarArgs.bS(10, this.abGK);
      paramVarArgs.f(11, 2, this.abGL);
      paramVarArgs.bS(12, this.abGM);
      paramVarArgs.f(13, 2, this.abGN);
      if (this.abGO != null) {
        paramVarArgs.g(14, this.abGO);
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abGB) + 0 + i.a.a.b.b.a.cJ(2, this.abGC) + i.a.a.b.b.a.cJ(3, this.abGD);
      paramInt = i;
      if (this.abGE != null) {
        paramInt = i + i.a.a.a.qC(4, this.abGE.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abGF) + i.a.a.b.b.a.cJ(6, this.abGG) + i.a.a.b.b.a.cJ(7, this.abGH) + i.a.a.b.b.a.cJ(8, this.abGI) + i.a.a.a.d(9, 2, this.abGJ) + i.a.a.b.b.a.cJ(10, this.abGK) + i.a.a.a.d(11, 2, this.abGL) + i.a.a.b.b.a.cJ(12, this.abGM) + i.a.a.a.d(13, 2, this.abGN);
      paramInt = i;
      if (this.abGO != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.abGO);
      }
      AppMethodBeat.o(115852);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abGJ.clear();
      this.abGL.clear();
      this.abGN.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.abGE == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fgs localfgs = (fgs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115852);
        return -1;
      case 1: 
        localfgs.abGB = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 2: 
        localfgs.abGC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 3: 
        localfgs.abGD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fzn localfzn = new fzn();
          if ((localObject != null) && (localObject.length > 0)) {
            localfzn.parseFrom((byte[])localObject);
          }
          localfgs.abGE = localfzn;
          paramInt += 1;
        }
        AppMethodBeat.o(115852);
        return 0;
      case 5: 
        localfgs.abGF = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 6: 
        localfgs.abGG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 7: 
        localfgs.abGH = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 8: 
        localfgs.abGI = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 9: 
        localfgs.abGJ = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
        AppMethodBeat.o(115852);
        return 0;
      case 10: 
        localfgs.abGK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 11: 
        localfgs.abGL = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
        AppMethodBeat.o(115852);
        return 0;
      case 12: 
        localfgs.abGM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115852);
        return 0;
      case 13: 
        localfgs.abGN = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
        AppMethodBeat.o(115852);
        return 0;
      }
      localfgs.abGO = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(115852);
      return 0;
    }
    AppMethodBeat.o(115852);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgs
 * JD-Core Version:    0.7.0.1
 */