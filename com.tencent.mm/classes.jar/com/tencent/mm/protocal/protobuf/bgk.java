package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgk
  extends com.tencent.mm.bv.a
{
  public long lastUpdateTime;
  public int version;
  public LinkedList<oi> wOn;
  public int wOo;
  public int wOp;
  
  public bgk()
  {
    AppMethodBeat.i(28560);
    this.wOn = new LinkedList();
    AppMethodBeat.o(28560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28561);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wOn);
      paramVarArgs.aO(2, this.version);
      paramVarArgs.aO(3, this.wOo);
      paramVarArgs.aO(4, this.wOp);
      paramVarArgs.am(5, this.lastUpdateTime);
      AppMethodBeat.o(28561);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.wOn);
      i = e.a.a.b.b.a.bl(2, this.version);
      int j = e.a.a.b.b.a.bl(3, this.wOo);
      int k = e.a.a.b.b.a.bl(4, this.wOp);
      int m = e.a.a.b.b.a.p(5, this.lastUpdateTime);
      AppMethodBeat.o(28561);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wOn.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28561);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bgk localbgk = (bgk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28561);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new oi();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((oi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbgk.wOn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28561);
        return 0;
      case 2: 
        localbgk.version = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28561);
        return 0;
      case 3: 
        localbgk.wOo = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28561);
        return 0;
      case 4: 
        localbgk.wOp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28561);
        return 0;
      }
      localbgk.lastUpdateTime = ((e.a.a.a.a)localObject1).CLY.sm();
      AppMethodBeat.o(28561);
      return 0;
    }
    AppMethodBeat.o(28561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgk
 * JD-Core Version:    0.7.0.1
 */