package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbc
  extends buy
{
  public String lang;
  public int limit;
  public int offset;
  public String xqk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80118);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.offset);
      paramVarArgs.aO(3, this.limit);
      if (this.lang != null) {
        paramVarArgs.e(4, this.lang);
      }
      if (this.xqk != null) {
        paramVarArgs.e(5, this.xqk);
      }
      AppMethodBeat.o(80118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.offset) + e.a.a.b.b.a.bl(3, this.limit);
      paramInt = i;
      if (this.lang != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.lang);
      }
      i = paramInt;
      if (this.xqk != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xqk);
      }
      AppMethodBeat.o(80118);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bbc localbbc = (bbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80118);
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
            localbbc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80118);
          return 0;
        case 2: 
          localbbc.offset = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80118);
          return 0;
        case 3: 
          localbbc.limit = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80118);
          return 0;
        case 4: 
          localbbc.lang = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80118);
          return 0;
        }
        localbbc.xqk = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80118);
        return 0;
      }
      AppMethodBeat.o(80118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbc
 * JD-Core Version:    0.7.0.1
 */