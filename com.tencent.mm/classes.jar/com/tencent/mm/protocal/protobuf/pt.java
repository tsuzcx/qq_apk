package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pt
  extends com.tencent.mm.bw.a
{
  public pl Egr;
  public pk Egs;
  public long Egt;
  public pr Egu;
  public pv Egv;
  public pq Egw;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117850);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      if (this.Egr != null)
      {
        paramVarArgs.ln(2, this.Egr.computeSize());
        this.Egr.writeFields(paramVarArgs);
      }
      if (this.Egs != null)
      {
        paramVarArgs.ln(3, this.Egs.computeSize());
        this.Egs.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.Egt);
      if (this.Egu != null)
      {
        paramVarArgs.ln(5, this.Egu.computeSize());
        this.Egu.writeFields(paramVarArgs);
      }
      if (this.Egv != null)
      {
        paramVarArgs.ln(6, this.Egv.computeSize());
        this.Egv.writeFields(paramVarArgs);
      }
      if (this.Egw != null)
      {
        paramVarArgs.ln(7, this.Egw.computeSize());
        this.Egw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ndI) + 0;
      paramInt = i;
      if (this.Egr != null) {
        paramInt = i + f.a.a.a.lm(2, this.Egr.computeSize());
      }
      i = paramInt;
      if (this.Egs != null) {
        i = paramInt + f.a.a.a.lm(3, this.Egs.computeSize());
      }
      i += f.a.a.b.b.a.p(4, this.Egt);
      paramInt = i;
      if (this.Egu != null) {
        paramInt = i + f.a.a.a.lm(5, this.Egu.computeSize());
      }
      i = paramInt;
      if (this.Egv != null) {
        i = paramInt + f.a.a.a.lm(6, this.Egv.computeSize());
      }
      paramInt = i;
      if (this.Egw != null) {
        paramInt = i + f.a.a.a.lm(7, this.Egw.computeSize());
      }
      AppMethodBeat.o(117850);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pt localpt = (pt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117850);
        return -1;
      case 1: 
        localpt.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117850);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpt.Egr = ((pl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpt.Egs = ((pk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 4: 
        localpt.Egt = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(117850);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpt.Egu = ((pr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpt.Egv = ((pv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new pq();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((pq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localpt.Egw = ((pq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    AppMethodBeat.o(117850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pt
 * JD-Core Version:    0.7.0.1
 */