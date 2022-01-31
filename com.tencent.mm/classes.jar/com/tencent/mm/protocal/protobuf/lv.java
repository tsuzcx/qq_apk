package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lv
  extends com.tencent.mm.bv.a
{
  public int fws;
  public int id;
  public String key;
  public String name;
  public int type;
  public String ugX;
  public String value;
  public LinkedList<lv> wAq;
  
  public lv()
  {
    AppMethodBeat.i(151382);
    this.wAq = new LinkedList();
    AppMethodBeat.o(151382);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151383);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      paramVarArgs.aO(2, this.type);
      if (this.name != null) {
        paramVarArgs.e(3, this.name);
      }
      if (this.key != null) {
        paramVarArgs.e(4, this.key);
      }
      if (this.value != null) {
        paramVarArgs.e(5, this.value);
      }
      paramVarArgs.e(6, 8, this.wAq);
      paramVarArgs.aO(7, this.fws);
      if (this.ugX != null) {
        paramVarArgs.e(8, this.ugX);
      }
      AppMethodBeat.o(151383);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.id) + 0 + e.a.a.b.b.a.bl(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.name);
      }
      i = paramInt;
      if (this.key != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.key);
      }
      paramInt = i;
      if (this.value != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.value);
      }
      i = paramInt + e.a.a.a.c(6, 8, this.wAq) + e.a.a.b.b.a.bl(7, this.fws);
      paramInt = i;
      if (this.ugX != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.ugX);
      }
      AppMethodBeat.o(151383);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wAq.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151383);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      lv locallv = (lv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(151383);
        return -1;
      case 1: 
        locallv.id = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151383);
        return 0;
      case 2: 
        locallv.type = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151383);
        return 0;
      case 3: 
        locallv.name = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(151383);
        return 0;
      case 4: 
        locallv.key = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(151383);
        return 0;
      case 5: 
        locallv.value = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(151383);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lv();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((lv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locallv.wAq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151383);
        return 0;
      case 7: 
        locallv.fws = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(151383);
        return 0;
      }
      locallv.ugX = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(151383);
      return 0;
    }
    AppMethodBeat.o(151383);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lv
 * JD-Core Version:    0.7.0.1
 */