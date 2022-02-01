package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cop
  extends com.tencent.mm.bw.a
{
  public boa HAv;
  public abu HAw;
  public pr HAx;
  public int oGc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197201);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.oGc);
      if (this.HAv != null)
      {
        paramVarArgs.lJ(2, this.HAv.computeSize());
        this.HAv.writeFields(paramVarArgs);
      }
      if (this.HAw != null)
      {
        paramVarArgs.lJ(3, this.HAw.computeSize());
        this.HAw.writeFields(paramVarArgs);
      }
      if (this.HAx != null)
      {
        paramVarArgs.lJ(4, this.HAx.computeSize());
        this.HAx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197201);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.oGc) + 0;
      paramInt = i;
      if (this.HAv != null) {
        paramInt = i + f.a.a.a.lI(2, this.HAv.computeSize());
      }
      i = paramInt;
      if (this.HAw != null) {
        i = paramInt + f.a.a.a.lI(3, this.HAw.computeSize());
      }
      paramInt = i;
      if (this.HAx != null) {
        paramInt = i + f.a.a.a.lI(4, this.HAx.computeSize());
      }
      AppMethodBeat.o(197201);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(197201);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cop localcop = (cop)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197201);
        return -1;
      case 1: 
        localcop.oGc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(197201);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((boa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcop.HAv = ((boa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(197201);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcop.HAw = ((abu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(197201);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new pr();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((pr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcop.HAx = ((pr)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(197201);
      return 0;
    }
    AppMethodBeat.o(197201);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cop
 * JD-Core Version:    0.7.0.1
 */