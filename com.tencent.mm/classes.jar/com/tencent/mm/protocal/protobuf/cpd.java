package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpd
  extends com.tencent.mm.bv.a
{
  public String title;
  public LinkedList<cjg> xXT;
  public LinkedList<cjg> xXU;
  public LinkedList<uo> xXV;
  
  public cpd()
  {
    AppMethodBeat.i(89150);
    this.xXT = new LinkedList();
    this.xXU = new LinkedList();
    this.xXV = new LinkedList();
    AppMethodBeat.o(89150);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89151);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      paramVarArgs.e(2, 8, this.xXT);
      paramVarArgs.e(3, 8, this.xXU);
      paramVarArgs.e(4, 8, this.xXV);
      AppMethodBeat.o(89151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = e.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.xXT);
      int j = e.a.a.a.c(3, 8, this.xXU);
      int k = e.a.a.a.c(4, 8, this.xXV);
      AppMethodBeat.o(89151);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xXT.clear();
        this.xXU.clear();
        this.xXV.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89151);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpd localcpd = (cpd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89151);
          return -1;
        case 1: 
          localcpd.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89151);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpd.xXT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89151);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpd.xXU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89151);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcpd.xXV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89151);
        return 0;
      }
      AppMethodBeat.o(89151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpd
 * JD-Core Version:    0.7.0.1
 */