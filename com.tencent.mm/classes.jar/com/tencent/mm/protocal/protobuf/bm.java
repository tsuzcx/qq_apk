package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bm
  extends com.tencent.mm.bw.a
{
  public bn KFc;
  public bn KFd;
  public bn KFe;
  public bn KFf;
  public bn KFg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122481);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KFc != null)
      {
        paramVarArgs.ni(1, this.KFc.computeSize());
        this.KFc.writeFields(paramVarArgs);
      }
      if (this.KFd != null)
      {
        paramVarArgs.ni(2, this.KFd.computeSize());
        this.KFd.writeFields(paramVarArgs);
      }
      if (this.KFe != null)
      {
        paramVarArgs.ni(3, this.KFe.computeSize());
        this.KFe.writeFields(paramVarArgs);
      }
      if (this.KFf != null)
      {
        paramVarArgs.ni(4, this.KFf.computeSize());
        this.KFf.writeFields(paramVarArgs);
      }
      if (this.KFg != null)
      {
        paramVarArgs.ni(5, this.KFg.computeSize());
        this.KFg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KFc == null) {
        break label926;
      }
    }
    label926:
    for (int i = g.a.a.a.nh(1, this.KFc.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KFd != null) {
        paramInt = i + g.a.a.a.nh(2, this.KFd.computeSize());
      }
      i = paramInt;
      if (this.KFe != null) {
        i = paramInt + g.a.a.a.nh(3, this.KFe.computeSize());
      }
      paramInt = i;
      if (this.KFf != null) {
        paramInt = i + g.a.a.a.nh(4, this.KFf.computeSize());
      }
      i = paramInt;
      if (this.KFg != null) {
        i = paramInt + g.a.a.a.nh(5, this.KFg.computeSize());
      }
      AppMethodBeat.o(122481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bm localbm = (bm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122481);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbm.KFc = ((bn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbm.KFd = ((bn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbm.KFe = ((bn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbm.KFf = ((bn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbm.KFg = ((bn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      AppMethodBeat.o(122481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bm
 * JD-Core Version:    0.7.0.1
 */