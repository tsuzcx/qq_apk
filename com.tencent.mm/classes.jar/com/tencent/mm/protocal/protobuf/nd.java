package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nd
  extends com.tencent.mm.bw.a
{
  public String DZs;
  public int Ebf;
  public LinkedList<nc> EcV;
  public nj EcW;
  
  public nd()
  {
    AppMethodBeat.i(124435);
    this.EcV = new LinkedList();
    AppMethodBeat.o(124435);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124436);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.EcV);
      paramVarArgs.aR(3, this.Ebf);
      if (this.DZs != null) {
        paramVarArgs.d(4, this.DZs);
      }
      if (this.EcW != null)
      {
        paramVarArgs.ln(5, this.EcW.computeSize());
        this.EcW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.EcV) + 0 + f.a.a.b.b.a.bx(3, this.Ebf);
      paramInt = i;
      if (this.DZs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DZs);
      }
      i = paramInt;
      if (this.EcW != null) {
        i = paramInt + f.a.a.a.lm(5, this.EcW.computeSize());
      }
      AppMethodBeat.o(124436);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EcV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      nd localnd = (nd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(124436);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnd.EcV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124436);
        return 0;
      case 3: 
        localnd.Ebf = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124436);
        return 0;
      case 4: 
        localnd.DZs = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124436);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new nj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((nj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localnd.EcW = ((nj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(124436);
      return 0;
    }
    AppMethodBeat.o(124436);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nd
 * JD-Core Version:    0.7.0.1
 */