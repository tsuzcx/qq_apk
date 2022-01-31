package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbp
  extends buy
{
  public String xli;
  public LinkedList<bbm> xqK;
  
  public bbp()
  {
    AppMethodBeat.i(11790);
    this.xqK = new LinkedList();
    AppMethodBeat.o(11790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11791);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xli != null) {
        paramVarArgs.e(2, this.xli);
      }
      paramVarArgs.e(3, 8, this.xqK);
      AppMethodBeat.o(11791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label519;
      }
    }
    label519:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xli != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xli);
      }
      paramInt = e.a.a.a.c(3, 8, this.xqK);
      AppMethodBeat.o(11791);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xqK.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11791);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bbp localbbp = (bbp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11791);
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
            localbbp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11791);
          return 0;
        case 2: 
          localbbp.xli = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11791);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bbm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbbp.xqK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(11791);
        return 0;
      }
      AppMethodBeat.o(11791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbp
 * JD-Core Version:    0.7.0.1
 */