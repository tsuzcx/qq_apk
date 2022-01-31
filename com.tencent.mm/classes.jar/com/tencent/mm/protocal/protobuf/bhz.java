package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhz
  extends com.tencent.mm.bv.a
{
  public LinkedList<bic> wpb;
  public int xxk;
  
  public bhz()
  {
    AppMethodBeat.i(80127);
    this.wpb = new LinkedList();
    AppMethodBeat.o(80127);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80128);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wpb);
      paramVarArgs.aO(2, this.xxk);
      AppMethodBeat.o(80128);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.wpb);
      i = e.a.a.b.b.a.bl(2, this.xxk);
      AppMethodBeat.o(80128);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wpb.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(80128);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bhz localbhz = (bhz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(80128);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bic();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bic)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbhz.wpb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80128);
        return 0;
      }
      localbhz.xxk = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(80128);
      return 0;
    }
    AppMethodBeat.o(80128);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhz
 * JD-Core Version:    0.7.0.1
 */