package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cea
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String Username;
  public SKBuiltinBuffer_t xOb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94576);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xOb == null)
      {
        paramVarArgs = new b("Not all required fields were included: HBBuffer");
        AppMethodBeat.o(94576);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      paramVarArgs.aO(2, this.CreateTime);
      if (this.xOb != null)
      {
        paramVarArgs.iQ(3, this.xOb.computeSize());
        this.xOb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.CreateTime);
      paramInt = i;
      if (this.xOb != null) {
        paramInt = i + e.a.a.a.iP(3, this.xOb.computeSize());
      }
      AppMethodBeat.o(94576);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xOb == null)
        {
          paramVarArgs = new b("Not all required fields were included: HBBuffer");
          AppMethodBeat.o(94576);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94576);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cea localcea = (cea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94576);
          return -1;
        case 1: 
          localcea.Username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94576);
          return 0;
        case 2: 
          localcea.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94576);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcea.xOb = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94576);
        return 0;
      }
      AppMethodBeat.o(94576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cea
 * JD-Core Version:    0.7.0.1
 */