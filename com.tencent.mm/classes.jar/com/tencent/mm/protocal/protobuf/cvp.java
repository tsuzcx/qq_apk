package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvp
  extends com.tencent.mm.bw.a
{
  public LinkedList<cvr> FGq;
  public LinkedList<cvo> FGr;
  public cvq FGs;
  public LinkedList<cvt> FGt;
  public boolean fxO;
  public boolean qPN;
  
  public cvp()
  {
    AppMethodBeat.i(122527);
    this.fxO = true;
    this.qPN = false;
    this.FGq = new LinkedList();
    this.FGr = new LinkedList();
    this.FGt = new LinkedList();
    AppMethodBeat.o(122527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.fxO);
      paramVarArgs.bl(2, this.qPN);
      paramVarArgs.e(3, 8, this.FGq);
      paramVarArgs.e(4, 8, this.FGr);
      if (this.FGs != null)
      {
        paramVarArgs.ln(5, this.FGs.computeSize());
        this.FGs.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.FGt);
      AppMethodBeat.o(122528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.fK(1) + 1 + 0 + (f.a.a.b.b.a.fK(2) + 1) + f.a.a.a.c(3, 8, this.FGq) + f.a.a.a.c(4, 8, this.FGr);
      paramInt = i;
      if (this.FGs != null) {
        paramInt = i + f.a.a.a.lm(5, this.FGs.computeSize());
      }
      i = f.a.a.a.c(6, 8, this.FGt);
      AppMethodBeat.o(122528);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FGq.clear();
      this.FGr.clear();
      this.FGt.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cvp localcvp = (cvp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122528);
        return -1;
      case 1: 
        localcvp.fxO = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(122528);
        return 0;
      case 2: 
        localcvp.qPN = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(122528);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvp.FGq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvp.FGr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvp.FGs = ((cvq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cvt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cvt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcvp.FGt.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    AppMethodBeat.o(122528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvp
 * JD-Core Version:    0.7.0.1
 */