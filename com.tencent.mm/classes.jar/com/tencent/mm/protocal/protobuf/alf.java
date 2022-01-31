package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alf
  extends com.tencent.mm.bv.a
{
  public int Ret;
  public String wQf;
  public auh wva;
  public int xbZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10181);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Ret);
      if (this.wva != null)
      {
        paramVarArgs.iQ(2, this.wva.computeSize());
        this.wva.writeFields(paramVarArgs);
      }
      if (this.wQf != null) {
        paramVarArgs.e(3, this.wQf);
      }
      paramVarArgs.aO(4, this.xbZ);
      AppMethodBeat.o(10181);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.Ret) + 0;
      paramInt = i;
      if (this.wva != null) {
        paramInt = i + e.a.a.a.iP(2, this.wva.computeSize());
      }
      i = paramInt;
      if (this.wQf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wQf);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xbZ);
      AppMethodBeat.o(10181);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(10181);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      alf localalf = (alf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(10181);
        return -1;
      case 1: 
        localalf.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(10181);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new auh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((auh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localalf.wva = ((auh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(10181);
        return 0;
      case 3: 
        localalf.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10181);
        return 0;
      }
      localalf.xbZ = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(10181);
      return 0;
    }
    AppMethodBeat.o(10181);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alf
 * JD-Core Version:    0.7.0.1
 */