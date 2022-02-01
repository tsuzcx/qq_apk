package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dym
  extends com.tencent.mm.bw.a
{
  public long EfR;
  public int FhS;
  public bpa FhT;
  public LinkedList<String> GeH;
  public LinkedList<yh> GeI;
  public int Scene;
  public String nOG;
  public String pAD;
  
  public dym()
  {
    AppMethodBeat.i(117951);
    this.GeH = new LinkedList();
    this.GeI = new LinkedList();
    AppMethodBeat.o(117951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.GeH);
      paramVarArgs.aR(2, this.FhS);
      if (this.pAD != null) {
        paramVarArgs.d(3, this.pAD);
      }
      paramVarArgs.aR(4, this.Scene);
      paramVarArgs.aO(5, this.EfR);
      if (this.nOG != null) {
        paramVarArgs.d(6, this.nOG);
      }
      if (this.FhT != null)
      {
        paramVarArgs.ln(7, this.FhT.computeSize());
        this.FhT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.GeI);
      AppMethodBeat.o(117952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.GeH) + 0 + f.a.a.b.b.a.bx(2, this.FhS);
      paramInt = i;
      if (this.pAD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pAD);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Scene) + f.a.a.b.b.a.p(5, this.EfR);
      paramInt = i;
      if (this.nOG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.nOG);
      }
      i = paramInt;
      if (this.FhT != null) {
        i = paramInt + f.a.a.a.lm(7, this.FhT.computeSize());
      }
      paramInt = f.a.a.a.c(8, 8, this.GeI);
      AppMethodBeat.o(117952);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GeH.clear();
      this.GeI.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dym localdym = (dym)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117952);
        return -1;
      case 1: 
        localdym.GeH.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(117952);
        return 0;
      case 2: 
        localdym.FhS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117952);
        return 0;
      case 3: 
        localdym.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 4: 
        localdym.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117952);
        return 0;
      case 5: 
        localdym.EfR = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(117952);
        return 0;
      case 6: 
        localdym.nOG = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdym.FhT = ((bpa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new yh();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdym.GeI.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    AppMethodBeat.o(117952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dym
 * JD-Core Version:    0.7.0.1
 */