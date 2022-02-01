package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwu
  extends com.tencent.mm.bx.a
{
  public int EoA;
  public int EoB;
  public int EoC;
  public LinkedList<Integer> EoD;
  public int EoE;
  public LinkedList<Integer> EoF;
  public int EoG;
  public LinkedList<Integer> EoH;
  public String EoI;
  public int Eov;
  public int Eow;
  public int Eox;
  public dlh Eoy;
  public int Eoz;
  
  public cwu()
  {
    AppMethodBeat.i(115851);
    this.EoD = new LinkedList();
    this.EoF = new LinkedList();
    this.EoH = new LinkedList();
    AppMethodBeat.o(115851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115852);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eoy == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Eov);
      paramVarArgs.aR(2, this.Eow);
      paramVarArgs.aR(3, this.Eox);
      if (this.Eoy != null)
      {
        paramVarArgs.kX(4, this.Eoy.computeSize());
        this.Eoy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Eoz);
      paramVarArgs.aR(6, this.EoA);
      paramVarArgs.aR(7, this.EoB);
      paramVarArgs.aR(8, this.EoC);
      paramVarArgs.f(9, 2, this.EoD);
      paramVarArgs.aR(10, this.EoE);
      paramVarArgs.f(11, 2, this.EoF);
      paramVarArgs.aR(12, this.EoG);
      paramVarArgs.f(13, 2, this.EoH);
      if (this.EoI != null) {
        paramVarArgs.d(14, this.EoI);
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Eov) + 0 + f.a.a.b.b.a.bA(2, this.Eow) + f.a.a.b.b.a.bA(3, this.Eox);
      paramInt = i;
      if (this.Eoy != null) {
        paramInt = i + f.a.a.a.kW(4, this.Eoy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Eoz) + f.a.a.b.b.a.bA(6, this.EoA) + f.a.a.b.b.a.bA(7, this.EoB) + f.a.a.b.b.a.bA(8, this.EoC) + f.a.a.a.d(9, 2, this.EoD) + f.a.a.b.b.a.bA(10, this.EoE) + f.a.a.a.d(11, 2, this.EoF) + f.a.a.b.b.a.bA(12, this.EoG) + f.a.a.a.d(13, 2, this.EoH);
      paramInt = i;
      if (this.EoI != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EoI);
      }
      AppMethodBeat.o(115852);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EoD.clear();
      this.EoF.clear();
      this.EoH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Eoy == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cwu localcwu = (cwu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115852);
        return -1;
      case 1: 
        localcwu.Eov = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 2: 
        localcwu.Eow = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 3: 
        localcwu.Eox = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcwu.Eoy = ((dlh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115852);
        return 0;
      case 5: 
        localcwu.Eoz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 6: 
        localcwu.EoA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 7: 
        localcwu.EoB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 8: 
        localcwu.EoC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 9: 
        localcwu.EoD = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
        AppMethodBeat.o(115852);
        return 0;
      case 10: 
        localcwu.EoE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 11: 
        localcwu.EoF = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
        AppMethodBeat.o(115852);
        return 0;
      case 12: 
        localcwu.EoG = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115852);
        return 0;
      case 13: 
        localcwu.EoH = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
        AppMethodBeat.o(115852);
        return 0;
      }
      localcwu.EoI = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(115852);
      return 0;
    }
    AppMethodBeat.o(115852);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwu
 * JD-Core Version:    0.7.0.1
 */