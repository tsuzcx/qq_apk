package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cxb
  extends com.tencent.mm.bv.a
{
  public long wsz;
  public long yeJ;
  public String yeK;
  public LinkedList<cxc> yeL;
  
  public cxb()
  {
    AppMethodBeat.i(28735);
    this.yeL = new LinkedList();
    AppMethodBeat.o(28735);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28736);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yeK == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(28736);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.yeJ);
      paramVarArgs.am(2, this.wsz);
      if (this.yeK != null) {
        paramVarArgs.e(3, this.yeK);
      }
      paramVarArgs.e(4, 8, this.yeL);
      AppMethodBeat.o(28736);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.yeJ) + 0 + e.a.a.b.b.a.p(2, this.wsz);
      paramInt = i;
      if (this.yeK != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.yeK);
      }
      i = e.a.a.a.c(4, 8, this.yeL);
      AppMethodBeat.o(28736);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yeL.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.yeK == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(28736);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28736);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cxb localcxb = (cxb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28736);
        return -1;
      case 1: 
        localcxb.yeJ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28736);
        return 0;
      case 2: 
        localcxb.wsz = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28736);
        return 0;
      case 3: 
        localcxb.yeK = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28736);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cxc();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cxc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localcxb.yeL.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28736);
      return 0;
    }
    AppMethodBeat.o(28736);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxb
 * JD-Core Version:    0.7.0.1
 */