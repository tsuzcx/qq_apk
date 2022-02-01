package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqm
  extends com.tencent.mm.bw.a
{
  public LinkedList<bts> AoH;
  public long DXC;
  public bxe FXO;
  public LinkedList<dha> FXP;
  public LinkedList<adu> FfL;
  
  public dqm()
  {
    AppMethodBeat.i(110917);
    this.FXP = new LinkedList();
    this.FfL = new LinkedList();
    this.AoH = new LinkedList();
    AppMethodBeat.o(110917);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DXC);
      if (this.FXO != null)
      {
        paramVarArgs.ln(2, this.FXO.computeSize());
        this.FXO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.FXP);
      paramVarArgs.e(4, 8, this.FfL);
      paramVarArgs.e(5, 8, this.AoH);
      AppMethodBeat.o(110918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.DXC) + 0;
      paramInt = i;
      if (this.FXO != null) {
        paramInt = i + f.a.a.a.lm(2, this.FXO.computeSize());
      }
      i = f.a.a.a.c(3, 8, this.FXP);
      int j = f.a.a.a.c(4, 8, this.FfL);
      int k = f.a.a.a.c(5, 8, this.AoH);
      AppMethodBeat.o(110918);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FXP.clear();
      this.FfL.clear();
      this.AoH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dqm localdqm = (dqm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110918);
        return -1;
      case 1: 
        localdqm.DXC = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110918);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqm.FXO = ((bxe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dha();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dha)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqm.FXP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new adu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((adu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqm.FfL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bts();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bts)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdqm.AoH.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    AppMethodBeat.o(110918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqm
 * JD-Core Version:    0.7.0.1
 */