package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxi
  extends com.tencent.mm.bx.a
{
  public cxj Ept;
  public cxh Epu;
  public cxg Epv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ept != null)
      {
        paramVarArgs.kX(1, this.Ept.computeSize());
        this.Ept.writeFields(paramVarArgs);
      }
      if (this.Epu != null)
      {
        paramVarArgs.kX(2, this.Epu.computeSize());
        this.Epu.writeFields(paramVarArgs);
      }
      if (this.Epv != null)
      {
        paramVarArgs.kX(3, this.Epv.computeSize());
        this.Epv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ept == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.kW(1, this.Ept.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Epu != null) {
        paramInt = i + f.a.a.a.kW(2, this.Epu.computeSize());
      }
      i = paramInt;
      if (this.Epv != null) {
        i = paramInt + f.a.a.a.kW(3, this.Epv.computeSize());
      }
      AppMethodBeat.o(125844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxi localcxi = (cxi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125844);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxi.Ept = ((cxj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxi.Epu = ((cxh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxi.Epv = ((cxg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      AppMethodBeat.o(125844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxi
 * JD-Core Version:    0.7.0.1
 */