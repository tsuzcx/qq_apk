package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blh
  extends com.tencent.mm.bw.a
  implements dyp
{
  public int LUj;
  public int LUk;
  public int LUl;
  public LinkedList<eeo> LUm;
  public LinkedList<eeo> LUn;
  public LinkedList<eeo> LUo;
  public int LlE;
  public int LlF;
  public int LlG;
  public LinkedList<eeo> LlH;
  public LinkedList<eeo> LlI;
  public LinkedList<eeo> LlJ;
  public int LlK;
  public int LlL;
  public int LlM;
  public cbi LlN;
  public int Ret;
  
  public blh()
  {
    AppMethodBeat.i(143974);
    this.LlH = new LinkedList();
    this.LlI = new LinkedList();
    this.LlJ = new LinkedList();
    this.LUm = new LinkedList();
    this.LUn = new LinkedList();
    this.LUo = new LinkedList();
    AppMethodBeat.o(143974);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143975);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      paramVarArgs.aM(2, this.LlE);
      paramVarArgs.aM(3, this.LlF);
      paramVarArgs.aM(4, this.LlG);
      paramVarArgs.e(5, 8, this.LlH);
      paramVarArgs.e(6, 8, this.LlI);
      paramVarArgs.e(7, 8, this.LlJ);
      paramVarArgs.aM(8, this.LlK);
      paramVarArgs.aM(9, this.LlL);
      paramVarArgs.aM(10, this.LlM);
      paramVarArgs.aM(11, this.LUj);
      paramVarArgs.aM(12, this.LUk);
      paramVarArgs.aM(13, this.LUl);
      paramVarArgs.e(14, 8, this.LUm);
      paramVarArgs.e(15, 8, this.LUn);
      paramVarArgs.e(16, 8, this.LUo);
      if (this.LlN != null)
      {
        paramVarArgs.ni(17, this.LlN.computeSize());
        this.LlN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.LlE) + g.a.a.b.b.a.bu(3, this.LlF) + g.a.a.b.b.a.bu(4, this.LlG) + g.a.a.a.c(5, 8, this.LlH) + g.a.a.a.c(6, 8, this.LlI) + g.a.a.a.c(7, 8, this.LlJ) + g.a.a.b.b.a.bu(8, this.LlK) + g.a.a.b.b.a.bu(9, this.LlL) + g.a.a.b.b.a.bu(10, this.LlM) + g.a.a.b.b.a.bu(11, this.LUj) + g.a.a.b.b.a.bu(12, this.LUk) + g.a.a.b.b.a.bu(13, this.LUl) + g.a.a.a.c(14, 8, this.LUm) + g.a.a.a.c(15, 8, this.LUn) + g.a.a.a.c(16, 8, this.LUo);
      paramInt = i;
      if (this.LlN != null) {
        paramInt = i + g.a.a.a.nh(17, this.LlN.computeSize());
      }
      AppMethodBeat.o(143975);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LlH.clear();
      this.LlI.clear();
      this.LlJ.clear();
      this.LUm.clear();
      this.LUn.clear();
      this.LUo.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      blh localblh = (blh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143975);
        return -1;
      case 1: 
        localblh.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 2: 
        localblh.LlE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 3: 
        localblh.LlF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 4: 
        localblh.LlG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localblh.LlH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localblh.LlI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localblh.LlJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 8: 
        localblh.LlK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 9: 
        localblh.LlL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 10: 
        localblh.LlM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 11: 
        localblh.LUj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 12: 
        localblh.LUk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 13: 
        localblh.LUl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143975);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localblh.LUm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localblh.LUn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eeo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localblh.LUo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cbi();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localblh.LlN = ((cbi)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    AppMethodBeat.o(143975);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blh
 * JD-Core Version:    0.7.0.1
 */