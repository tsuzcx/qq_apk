package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lu
  extends com.tencent.mm.bv.a
{
  public int type;
  public int uin;
  public int version;
  public int wAn;
  public int wAo;
  public LinkedList<lv> wAp;
  
  public lu()
  {
    AppMethodBeat.i(151380);
    this.wAp = new LinkedList();
    AppMethodBeat.o(151380);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151381);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.uin);
      paramVarArgs.aO(2, this.wAn);
      paramVarArgs.aO(3, this.wAo);
      paramVarArgs.e(4, 8, this.wAp);
      paramVarArgs.aO(5, this.version);
      paramVarArgs.aO(6, this.type);
      AppMethodBeat.o(151381);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.uin);
      i = e.a.a.b.b.a.bl(2, this.wAn);
      int j = e.a.a.b.b.a.bl(3, this.wAo);
      int k = e.a.a.a.c(4, 8, this.wAp);
      int m = e.a.a.b.b.a.bl(5, this.version);
      int n = e.a.a.b.b.a.bl(6, this.type);
      AppMethodBeat.o(151381);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wAp.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151381);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      lu locallu = (lu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151381);
        return -1;
      case 1: 
        locallu.uin = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151381);
        return 0;
      case 2: 
        locallu.wAn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151381);
        return 0;
      case 3: 
        locallu.wAo = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151381);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((lv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locallu.wAp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151381);
        return 0;
      case 5: 
        locallu.version = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151381);
        return 0;
      }
      locallu.type = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(151381);
      return 0;
    }
    AppMethodBeat.o(151381);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lu
 * JD-Core Version:    0.7.0.1
 */