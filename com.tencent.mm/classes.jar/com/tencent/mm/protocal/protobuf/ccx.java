package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccx
  extends com.tencent.mm.bv.a
{
  public int type;
  public String wug;
  public bvw xNm;
  public cjw xuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48963);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xuz != null)
      {
        paramVarArgs.iQ(1, this.xuz.computeSize());
        this.xuz.writeFields(paramVarArgs);
      }
      if (this.xNm != null)
      {
        paramVarArgs.iQ(2, this.xNm.computeSize());
        this.xNm.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.type);
      if (this.wug != null) {
        paramVarArgs.e(4, this.wug);
      }
      AppMethodBeat.o(48963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xuz == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = e.a.a.a.iP(1, this.xuz.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xNm != null) {
        i = paramInt + e.a.a.a.iP(2, this.xNm.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.type);
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wug);
      }
      AppMethodBeat.o(48963);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48963);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ccx localccx = (ccx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48963);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccx.xuz = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48963);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localccx.xNm = ((bvw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48963);
          return 0;
        case 3: 
          localccx.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48963);
          return 0;
        }
        localccx.wug = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48963);
        return 0;
      }
      AppMethodBeat.o(48963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccx
 * JD-Core Version:    0.7.0.1
 */