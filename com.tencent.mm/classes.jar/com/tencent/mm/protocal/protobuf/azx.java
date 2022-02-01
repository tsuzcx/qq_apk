package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azx
  extends com.tencent.mm.bw.a
  implements dfi
{
  public int GQc;
  public int GQd;
  public int GQe;
  public LinkedList<dlb> GQf;
  public LinkedList<dlb> GQg;
  public LinkedList<dlb> GQh;
  public int GqI;
  public int GqJ;
  public int GqK;
  public LinkedList<dlb> GqL;
  public LinkedList<dlb> GqM;
  public LinkedList<dlb> GqN;
  public int GqO;
  public int GqP;
  public int GqQ;
  public boq GqR;
  public int Ret;
  
  public azx()
  {
    AppMethodBeat.i(143974);
    this.GqL = new LinkedList();
    this.GqM = new LinkedList();
    this.GqN = new LinkedList();
    this.GQf = new LinkedList();
    this.GQg = new LinkedList();
    this.GQh = new LinkedList();
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
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      paramVarArgs.aS(2, this.GqI);
      paramVarArgs.aS(3, this.GqJ);
      paramVarArgs.aS(4, this.GqK);
      paramVarArgs.e(5, 8, this.GqL);
      paramVarArgs.e(6, 8, this.GqM);
      paramVarArgs.e(7, 8, this.GqN);
      paramVarArgs.aS(8, this.GqO);
      paramVarArgs.aS(9, this.GqP);
      paramVarArgs.aS(10, this.GqQ);
      paramVarArgs.aS(11, this.GQc);
      paramVarArgs.aS(12, this.GQd);
      paramVarArgs.aS(13, this.GQe);
      paramVarArgs.e(14, 8, this.GQf);
      paramVarArgs.e(15, 8, this.GQg);
      paramVarArgs.e(16, 8, this.GQh);
      if (this.GqR != null)
      {
        paramVarArgs.lJ(17, this.GqR.computeSize());
        this.GqR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0 + f.a.a.b.b.a.bz(2, this.GqI) + f.a.a.b.b.a.bz(3, this.GqJ) + f.a.a.b.b.a.bz(4, this.GqK) + f.a.a.a.c(5, 8, this.GqL) + f.a.a.a.c(6, 8, this.GqM) + f.a.a.a.c(7, 8, this.GqN) + f.a.a.b.b.a.bz(8, this.GqO) + f.a.a.b.b.a.bz(9, this.GqP) + f.a.a.b.b.a.bz(10, this.GqQ) + f.a.a.b.b.a.bz(11, this.GQc) + f.a.a.b.b.a.bz(12, this.GQd) + f.a.a.b.b.a.bz(13, this.GQe) + f.a.a.a.c(14, 8, this.GQf) + f.a.a.a.c(15, 8, this.GQg) + f.a.a.a.c(16, 8, this.GQh);
      paramInt = i;
      if (this.GqR != null) {
        paramInt = i + f.a.a.a.lI(17, this.GqR.computeSize());
      }
      AppMethodBeat.o(143975);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GqL.clear();
      this.GqM.clear();
      this.GqN.clear();
      this.GQf.clear();
      this.GQg.clear();
      this.GQh.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      azx localazx = (azx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143975);
        return -1;
      case 1: 
        localazx.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 2: 
        localazx.GqI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 3: 
        localazx.GqJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 4: 
        localazx.GqK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazx.GqL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazx.GqM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazx.GqN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 8: 
        localazx.GqO = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 9: 
        localazx.GqP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 10: 
        localazx.GqQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 11: 
        localazx.GQc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 12: 
        localazx.GQd = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 13: 
        localazx.GQe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazx.GQf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazx.GQg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazx.GQh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new boq();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((boq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localazx.GqR = ((boq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    AppMethodBeat.o(143975);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azx
 * JD-Core Version:    0.7.0.1
 */