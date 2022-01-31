package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cuo
  extends com.tencent.mm.bv.a
{
  public String username;
  public String ydb;
  public cto ydg;
  public String ydr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102423);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ydg == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(102423);
        throw paramVarArgs;
      }
      if (this.ydg != null)
      {
        paramVarArgs.iQ(1, this.ydg.computeSize());
        this.ydg.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      if (this.ydb != null) {
        paramVarArgs.e(3, this.ydb);
      }
      if (this.ydr != null) {
        paramVarArgs.e(4, this.ydr);
      }
      AppMethodBeat.o(102423);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ydg == null) {
        break label538;
      }
    }
    label538:
    for (int i = e.a.a.a.iP(1, this.ydg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.username);
      }
      i = paramInt;
      if (this.ydb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ydb);
      }
      paramInt = i;
      if (this.ydr != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ydr);
      }
      AppMethodBeat.o(102423);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ydg == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(102423);
          throw paramVarArgs;
        }
        AppMethodBeat.o(102423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cuo localcuo = (cuo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(102423);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cto();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cto)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcuo.ydg = ((cto)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(102423);
          return 0;
        case 2: 
          localcuo.username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(102423);
          return 0;
        case 3: 
          localcuo.ydb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(102423);
          return 0;
        }
        localcuo.ydr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(102423);
        return 0;
      }
      AppMethodBeat.o(102423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuo
 * JD-Core Version:    0.7.0.1
 */