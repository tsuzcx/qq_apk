package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sz
  extends buy
{
  public int Scene;
  public LinkedList<Integer> wLv;
  public LinkedList<sy> wLw;
  public String wuH;
  
  public sz()
  {
    AppMethodBeat.i(14719);
    this.wLv = new LinkedList();
    this.wLw = new LinkedList();
    AppMethodBeat.o(14719);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14720);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.wLv);
      paramVarArgs.aO(3, this.Scene);
      if (this.wuH != null) {
        paramVarArgs.e(4, this.wuH);
      }
      paramVarArgs.e(5, 8, this.wLw);
      AppMethodBeat.o(14720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 2, this.wLv) + e.a.a.b.b.a.bl(3, this.Scene);
      paramInt = i;
      if (this.wuH != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wuH);
      }
      i = e.a.a.a.c(5, 8, this.wLw);
      AppMethodBeat.o(14720);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wLv.clear();
        this.wLw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14720);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        sz localsz = (sz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14720);
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
            localsz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14720);
          return 0;
        case 2: 
          localsz.wLv.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(14720);
          return 0;
        case 3: 
          localsz.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14720);
          return 0;
        case 4: 
          localsz.wuH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14720);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sy();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localsz.wLw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(14720);
        return 0;
      }
      AppMethodBeat.o(14720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sz
 * JD-Core Version:    0.7.0.1
 */