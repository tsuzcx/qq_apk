package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class chg
  extends com.tencent.mm.bv.a
{
  public long Id;
  public chs xRP;
  public String xRQ;
  public int xRy;
  public LinkedList<Integer> xSj;
  
  public chg()
  {
    AppMethodBeat.i(56519);
    this.xSj = new LinkedList();
    AppMethodBeat.o(56519);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56520);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.Id);
      if (this.xRQ != null) {
        paramVarArgs.e(2, this.xRQ);
      }
      if (this.xRP != null)
      {
        paramVarArgs.iQ(3, this.xRP.computeSize());
        this.xRP.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xRy);
      paramVarArgs.f(5, 2, this.xSj);
      AppMethodBeat.o(56520);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.xRQ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xRQ);
      }
      i = paramInt;
      if (this.xRP != null) {
        i = paramInt + e.a.a.a.iP(3, this.xRP.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xRy);
      int j = e.a.a.a.d(5, 2, this.xSj);
      AppMethodBeat.o(56520);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xSj.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56520);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      chg localchg = (chg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56520);
        return -1;
      case 1: 
        localchg.Id = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56520);
        return 0;
      case 2: 
        localchg.xRQ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56520);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chs();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((chs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localchg.xRP = ((chs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56520);
        return 0;
      case 4: 
        localchg.xRy = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56520);
        return 0;
      }
      localchg.xSj = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
      AppMethodBeat.o(56520);
      return 0;
    }
    AppMethodBeat.o(56520);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chg
 * JD-Core Version:    0.7.0.1
 */