package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdn;
import e.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public cdn rep;
  public String rlS;
  public int rlT;
  public String rlU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(36828);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.rlS == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(36828);
        throw paramVarArgs;
      }
      if (this.rep == null)
      {
        paramVarArgs = new b("Not all required fields were included: actionGroup");
        AppMethodBeat.o(36828);
        throw paramVarArgs;
      }
      if (this.rlS != null) {
        paramVarArgs.e(1, this.rlS);
      }
      if (this.rep != null)
      {
        paramVarArgs.iQ(2, this.rep.computeSize());
        this.rep.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.rlT);
      if (this.rlU != null) {
        paramVarArgs.e(4, this.rlU);
      }
      AppMethodBeat.o(36828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rlS == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = e.a.a.b.b.a.f(1, this.rlS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rep != null) {
        i = paramInt + e.a.a.a.iP(2, this.rep.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.rlT);
      paramInt = i;
      if (this.rlU != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.rlU);
      }
      AppMethodBeat.o(36828);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.rlS == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(36828);
          throw paramVarArgs;
        }
        if (this.rep == null)
        {
          paramVarArgs = new b("Not all required fields were included: actionGroup");
          AppMethodBeat.o(36828);
          throw paramVarArgs;
        }
        AppMethodBeat.o(36828);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(36828);
          return -1;
        case 1: 
          locale.rlS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(36828);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cdn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locale.rep = ((cdn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(36828);
          return 0;
        case 3: 
          locale.rlT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(36828);
          return 0;
        }
        locale.rlU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(36828);
        return 0;
      }
      AppMethodBeat.o(36828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.e
 * JD-Core Version:    0.7.0.1
 */