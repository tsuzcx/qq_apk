package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzj
  extends buy
{
  public String wQf;
  public int xpy;
  public LinkedList<bwc> xpz;
  
  public bzj()
  {
    AppMethodBeat.i(73760);
    this.xpz = new LinkedList();
    AppMethodBeat.o(73760);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73761);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wQf != null) {
        paramVarArgs.e(2, this.wQf);
      }
      paramVarArgs.aO(3, this.xpy);
      paramVarArgs.e(4, 8, this.xpz);
      AppMethodBeat.o(73761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wQf != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wQf);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xpy);
      int j = e.a.a.a.c(4, 8, this.xpz);
      AppMethodBeat.o(73761);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xpz.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bzj localbzj = (bzj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73761);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbzj.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73761);
          return 0;
        case 2: 
          localbzj.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73761);
          return 0;
        case 3: 
          localbzj.xpy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73761);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbzj.xpz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73761);
        return 0;
      }
      AppMethodBeat.o(73761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzj
 * JD-Core Version:    0.7.0.1
 */