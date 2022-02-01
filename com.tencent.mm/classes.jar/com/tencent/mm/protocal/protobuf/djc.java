package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djc
  extends com.tencent.mm.bw.a
{
  public djd HQJ;
  public djb HQK;
  public dja HQL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQJ != null)
      {
        paramVarArgs.lJ(1, this.HQJ.computeSize());
        this.HQJ.writeFields(paramVarArgs);
      }
      if (this.HQK != null)
      {
        paramVarArgs.lJ(2, this.HQK.computeSize());
        this.HQK.writeFields(paramVarArgs);
      }
      if (this.HQL != null)
      {
        paramVarArgs.lJ(3, this.HQL.computeSize());
        this.HQL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HQJ == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lI(1, this.HQJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HQK != null) {
        paramInt = i + f.a.a.a.lI(2, this.HQK.computeSize());
      }
      i = paramInt;
      if (this.HQL != null) {
        i = paramInt + f.a.a.a.lI(3, this.HQL.computeSize());
      }
      AppMethodBeat.o(125844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djc localdjc = (djc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125844);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjc.HQJ = ((djd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjc.HQK = ((djb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dja();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dja)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjc.HQL = ((dja)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djc
 * JD-Core Version:    0.7.0.1
 */