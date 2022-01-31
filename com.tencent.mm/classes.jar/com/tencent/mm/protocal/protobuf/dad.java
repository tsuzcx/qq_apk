package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dad
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b wxN;
  public LinkedList<daa> wxO;
  public String xTl;
  
  public dad()
  {
    AppMethodBeat.i(96338);
    this.wxO = new LinkedList();
    AppMethodBeat.o(96338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96339);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xTl == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(96339);
        throw paramVarArgs;
      }
      if (this.xTl != null) {
        paramVarArgs.e(1, this.xTl);
      }
      if (this.wxN != null) {
        paramVarArgs.c(2, this.wxN);
      }
      paramVarArgs.e(3, 8, this.wxO);
      AppMethodBeat.o(96339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xTl == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = e.a.a.b.b.a.f(1, this.xTl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wxN != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.wxN);
      }
      paramInt = e.a.a.a.c(3, 8, this.wxO);
      AppMethodBeat.o(96339);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wxO.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xTl == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(96339);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dad localdad = (dad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96339);
          return -1;
        case 1: 
          localdad.xTl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96339);
          return 0;
        case 2: 
          localdad.wxN = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(96339);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new daa();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((daa)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localdad.wxO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(96339);
        return 0;
      }
      AppMethodBeat.o(96339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dad
 * JD-Core Version:    0.7.0.1
 */