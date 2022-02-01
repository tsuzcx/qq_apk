package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aam
  extends com.tencent.mm.bx.a
{
  public cse FZq;
  public LinkedList<ja> FZr;
  public boolean FZs;
  public cse FZt;
  
  public aam()
  {
    AppMethodBeat.i(215797);
    this.FZr = new LinkedList();
    AppMethodBeat.o(215797);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZq != null)
      {
        paramVarArgs.lC(1, this.FZq.computeSize());
        this.FZq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FZr);
      paramVarArgs.bt(3, this.FZs);
      if (this.FZt != null)
      {
        paramVarArgs.lC(4, this.FZt.computeSize());
        this.FZt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZq == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lB(1, this.FZq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.FZr) + f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.FZt != null) {
        paramInt = i + f.a.a.a.lB(4, this.FZt.computeSize());
      }
      AppMethodBeat.o(215798);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FZr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215798);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aam localaam = (aam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215798);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaam.FZq = ((cse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215798);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ja();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ja)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaam.FZr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215798);
          return 0;
        case 3: 
          localaam.FZs = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(215798);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cse();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaam.FZt = ((cse)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215798);
        return 0;
      }
      AppMethodBeat.o(215798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aam
 * JD-Core Version:    0.7.0.1
 */