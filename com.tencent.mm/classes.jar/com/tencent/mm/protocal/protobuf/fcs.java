package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcs
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public LinkedList<vd> LpM;
  public LinkedList<fbn> Mee;
  public int NyD;
  public String NyE;
  public String NyF;
  public int NyG;
  public gi NyH;
  
  public fcs()
  {
    AppMethodBeat.i(123694);
    this.LpM = new LinkedList();
    this.Mee = new LinkedList();
    AppMethodBeat.o(123694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123695);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KSa);
      paramVarArgs.aM(2, this.NyD);
      if (this.NyE != null) {
        paramVarArgs.e(3, this.NyE);
      }
      if (this.NyF != null) {
        paramVarArgs.e(4, this.NyF);
      }
      paramVarArgs.aM(5, this.NyG);
      paramVarArgs.e(6, 8, this.LpM);
      if (this.NyH != null)
      {
        paramVarArgs.ni(7, this.NyH.computeSize());
        this.NyH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(36, 8, this.Mee);
      AppMethodBeat.o(123695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.KSa) + 0 + g.a.a.b.b.a.bu(2, this.NyD);
      paramInt = i;
      if (this.NyE != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.NyE);
      }
      i = paramInt;
      if (this.NyF != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.NyF);
      }
      i = i + g.a.a.b.b.a.bu(5, this.NyG) + g.a.a.a.c(6, 8, this.LpM);
      paramInt = i;
      if (this.NyH != null) {
        paramInt = i + g.a.a.a.nh(7, this.NyH.computeSize());
      }
      i = g.a.a.a.c(36, 8, this.Mee);
      AppMethodBeat.o(123695);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LpM.clear();
      this.Mee.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fcs localfcs = (fcs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123695);
        return -1;
      case 1: 
        localfcs.KSa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123695);
        return 0;
      case 2: 
        localfcs.NyD = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123695);
        return 0;
      case 3: 
        localfcs.NyE = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 4: 
        localfcs.NyF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 5: 
        localfcs.NyG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123695);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfcs.LpM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfcs.NyH = ((gi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new fbn();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((fbn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localfcs.Mee.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    AppMethodBeat.o(123695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcs
 * JD-Core Version:    0.7.0.1
 */