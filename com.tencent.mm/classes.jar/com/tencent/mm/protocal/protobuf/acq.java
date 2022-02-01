package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acq
  extends com.tencent.mm.bw.a
{
  public int Evh;
  public aco Evi;
  public aco Evj;
  public int Evk;
  public int Evl;
  public int Evm;
  public int Evn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Evh);
      if (this.Evi != null)
      {
        paramVarArgs.ln(2, this.Evi.computeSize());
        this.Evi.writeFields(paramVarArgs);
      }
      if (this.Evj != null)
      {
        paramVarArgs.ln(3, this.Evj.computeSize());
        this.Evj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Evk);
      paramVarArgs.aR(5, this.Evl);
      paramVarArgs.aR(6, this.Evm);
      paramVarArgs.aR(7, this.Evn);
      AppMethodBeat.o(90966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Evh) + 0;
      paramInt = i;
      if (this.Evi != null) {
        paramInt = i + f.a.a.a.lm(2, this.Evi.computeSize());
      }
      i = paramInt;
      if (this.Evj != null) {
        i = paramInt + f.a.a.a.lm(3, this.Evj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(4, this.Evk);
      int j = f.a.a.b.b.a.bx(5, this.Evl);
      int k = f.a.a.b.b.a.bx(6, this.Evm);
      int m = f.a.a.b.b.a.bx(7, this.Evn);
      AppMethodBeat.o(90966);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(90966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      acq localacq = (acq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90966);
        return -1;
      case 1: 
        localacq.Evh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(90966);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aco();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localacq.Evi = ((aco)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aco();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localacq.Evj = ((aco)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90966);
        return 0;
      case 4: 
        localacq.Evk = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(90966);
        return 0;
      case 5: 
        localacq.Evl = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(90966);
        return 0;
      case 6: 
        localacq.Evm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(90966);
        return 0;
      }
      localacq.Evn = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(90966);
      return 0;
    }
    AppMethodBeat.o(90966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acq
 * JD-Core Version:    0.7.0.1
 */