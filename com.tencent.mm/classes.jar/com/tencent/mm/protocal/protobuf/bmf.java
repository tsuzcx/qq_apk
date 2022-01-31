package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmf
  extends com.tencent.mm.bv.a
{
  public cjw wmY;
  public cjw wmZ;
  public awf xAG;
  public LinkedList<ox> xAH;
  public bfv xAI;
  
  public bmf()
  {
    AppMethodBeat.i(48922);
    this.xAH = new LinkedList();
    AppMethodBeat.o(48922);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48923);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xAG != null)
      {
        paramVarArgs.iQ(1, this.xAG.computeSize());
        this.xAG.writeFields(paramVarArgs);
      }
      if (this.wmY != null)
      {
        paramVarArgs.iQ(2, this.wmY.computeSize());
        this.wmY.writeFields(paramVarArgs);
      }
      if (this.wmZ != null)
      {
        paramVarArgs.iQ(3, this.wmZ.computeSize());
        this.wmZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.xAH);
      if (this.xAI != null)
      {
        paramVarArgs.iQ(5, this.xAI.computeSize());
        this.xAI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xAG == null) {
        break label914;
      }
    }
    label914:
    for (int i = e.a.a.a.iP(1, this.xAG.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wmY != null) {
        paramInt = i + e.a.a.a.iP(2, this.wmY.computeSize());
      }
      i = paramInt;
      if (this.wmZ != null) {
        i = paramInt + e.a.a.a.iP(3, this.wmZ.computeSize());
      }
      i += e.a.a.a.c(4, 8, this.xAH);
      paramInt = i;
      if (this.xAI != null) {
        paramInt = i + e.a.a.a.iP(5, this.xAI.computeSize());
      }
      AppMethodBeat.o(48923);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xAH.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48923);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bmf localbmf = (bmf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48923);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbmf.xAG = ((awf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48923);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbmf.wmY = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48923);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbmf.wmZ = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48923);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ox();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ox)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbmf.xAH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48923);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbmf.xAI = ((bfv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48923);
        return 0;
      }
      AppMethodBeat.o(48923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmf
 * JD-Core Version:    0.7.0.1
 */