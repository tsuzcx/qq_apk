package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfm
  extends com.tencent.mm.bv.a
{
  public int type;
  public String wug;
  public LinkedList<bvw> xuA;
  public cjw xuz;
  
  public bfm()
  {
    AppMethodBeat.i(48896);
    this.xuA = new LinkedList();
    AppMethodBeat.o(48896);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48897);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xuz != null)
      {
        paramVarArgs.iQ(1, this.xuz.computeSize());
        this.xuz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xuA);
      paramVarArgs.aO(3, this.type);
      if (this.wug != null) {
        paramVarArgs.e(4, this.wug);
      }
      AppMethodBeat.o(48897);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xuz == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = e.a.a.a.iP(1, this.xuz.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.xuA) + e.a.a.b.b.a.bl(3, this.type);
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wug);
      }
      AppMethodBeat.o(48897);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xuA.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48897);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bfm localbfm = (bfm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48897);
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
            localbfm.xuz = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48897);
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
            localbfm.xuA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48897);
          return 0;
        case 3: 
          localbfm.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48897);
          return 0;
        }
        localbfm.wug = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48897);
        return 0;
      }
      AppMethodBeat.o(48897);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfm
 * JD-Core Version:    0.7.0.1
 */