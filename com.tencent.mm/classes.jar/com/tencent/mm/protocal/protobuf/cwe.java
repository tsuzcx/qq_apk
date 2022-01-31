package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwe
  extends buy
{
  public String cwc;
  public int id;
  public String query;
  public LinkedList<Integer> yet;
  
  public cwe()
  {
    AppMethodBeat.i(93816);
    this.yet = new LinkedList();
    AppMethodBeat.o(93816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93817);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cwc != null) {
        paramVarArgs.e(2, this.cwc);
      }
      paramVarArgs.aO(3, this.id);
      paramVarArgs.e(4, 2, this.yet);
      if (this.query != null) {
        paramVarArgs.e(5, this.query);
      }
      AppMethodBeat.o(93817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label533;
      }
    }
    label533:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.cwc);
      }
      i = i + e.a.a.b.b.a.bl(3, this.id) + e.a.a.a.c(4, 2, this.yet);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.query);
      }
      AppMethodBeat.o(93817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.yet.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(93817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cwe localcwe = (cwe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93817);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcwe.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(93817);
          return 0;
        case 2: 
          localcwe.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93817);
          return 0;
        case 3: 
          localcwe.id = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93817);
          return 0;
        case 4: 
          localcwe.yet.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(93817);
          return 0;
        }
        localcwe.query = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(93817);
        return 0;
      }
      AppMethodBeat.o(93817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwe
 * JD-Core Version:    0.7.0.1
 */