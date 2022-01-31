package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmy
  extends com.tencent.mm.bv.a
{
  public clw xBi;
  public int xcm;
  public String xcn;
  public String xco;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28572);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xcm);
      if (this.xcn != null) {
        paramVarArgs.e(2, this.xcn);
      }
      if (this.xco != null) {
        paramVarArgs.e(3, this.xco);
      }
      if (this.xBi != null)
      {
        paramVarArgs.iQ(4, this.xBi.computeSize());
        this.xBi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28572);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xcm) + 0;
      paramInt = i;
      if (this.xcn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xcn);
      }
      i = paramInt;
      if (this.xco != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xco);
      }
      paramInt = i;
      if (this.xBi != null) {
        paramInt = i + e.a.a.a.iP(4, this.xBi.computeSize());
      }
      AppMethodBeat.o(28572);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28572);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bmy localbmy = (bmy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28572);
        return -1;
      case 1: 
        localbmy.xcm = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28572);
        return 0;
      case 2: 
        localbmy.xcn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28572);
        return 0;
      case 3: 
        localbmy.xco = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28572);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new clw();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((clw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbmy.xBi = ((clw)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28572);
      return 0;
    }
    AppMethodBeat.o(28572);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmy
 * JD-Core Version:    0.7.0.1
 */