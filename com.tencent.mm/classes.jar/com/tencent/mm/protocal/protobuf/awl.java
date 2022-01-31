package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class awl
  extends buy
{
  public String wOf;
  public String xlW;
  public LinkedList<String> xlX;
  
  public awl()
  {
    AppMethodBeat.i(11774);
    this.xlX = new LinkedList();
    AppMethodBeat.o(11774);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11775);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOf == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(11775);
        throw paramVarArgs;
      }
      if (this.xlW == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_name");
        AppMethodBeat.o(11775);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wOf != null) {
        paramVarArgs.e(2, this.wOf);
      }
      if (this.xlW != null) {
        paramVarArgs.e(3, this.xlW);
      }
      paramVarArgs.e(4, 1, this.xlX);
      AppMethodBeat.o(11775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label600;
      }
    }
    label600:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wOf != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wOf);
      }
      i = paramInt;
      if (this.xlW != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xlW);
      }
      paramInt = e.a.a.a.c(4, 1, this.xlX);
      AppMethodBeat.o(11775);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xlX.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOf == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(11775);
          throw paramVarArgs;
        }
        if (this.xlW == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_name");
          AppMethodBeat.o(11775);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11775);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        awl localawl = (awl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11775);
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
            localawl.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11775);
          return 0;
        case 2: 
          localawl.wOf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11775);
          return 0;
        case 3: 
          localawl.xlW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11775);
          return 0;
        }
        localawl.xlX.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(11775);
        return 0;
      }
      AppMethodBeat.o(11775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awl
 * JD-Core Version:    0.7.0.1
 */