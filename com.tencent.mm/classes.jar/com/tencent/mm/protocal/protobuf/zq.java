package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zq
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public int jJu;
  public LinkedList<azi> jJv;
  
  public zq()
  {
    AppMethodBeat.i(62537);
    this.jJv = new LinkedList();
    AppMethodBeat.o(62537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62538);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.e(1, this.Md5);
      }
      paramVarArgs.aO(2, this.jJu);
      paramVarArgs.e(3, 8, this.jJv);
      AppMethodBeat.o(62538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = e.a.a.b.b.a.f(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jJu);
      int j = e.a.a.a.c(3, 8, this.jJv);
      AppMethodBeat.o(62538);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jJv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(62538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zq localzq = (zq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62538);
          return -1;
        case 1: 
          localzq.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62538);
          return 0;
        case 2: 
          localzq.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62538);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azi();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((azi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localzq.jJv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(62538);
        return 0;
      }
      AppMethodBeat.o(62538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zq
 * JD-Core Version:    0.7.0.1
 */