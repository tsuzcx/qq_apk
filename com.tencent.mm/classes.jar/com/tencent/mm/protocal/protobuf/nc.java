package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class nc
  extends com.tencent.mm.bv.a
{
  public String Title;
  public int jJU;
  public LinkedList<ni> nrw;
  public long wBW;
  public int wBX;
  public LinkedList<String> wBY;
  public String wBZ;
  public int wzS;
  
  public nc()
  {
    AppMethodBeat.i(124294);
    this.wBY = new LinkedList();
    this.nrw = new LinkedList();
    AppMethodBeat.o(124294);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124295);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wBZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(124295);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.wBW);
      paramVarArgs.aO(2, this.wBX);
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      paramVarArgs.e(4, 1, this.wBY);
      paramVarArgs.e(5, 8, this.nrw);
      paramVarArgs.aO(6, this.jJU);
      if (this.wBZ != null) {
        paramVarArgs.e(7, this.wBZ);
      }
      paramVarArgs.aO(8, this.wzS);
      AppMethodBeat.o(124295);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.wBW) + 0 + e.a.a.b.b.a.bl(2, this.wBX);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Title);
      }
      i = paramInt + e.a.a.a.c(4, 1, this.wBY) + e.a.a.a.c(5, 8, this.nrw) + e.a.a.b.b.a.bl(6, this.jJU);
      paramInt = i;
      if (this.wBZ != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wBZ);
      }
      i = e.a.a.b.b.a.bl(8, this.wzS);
      AppMethodBeat.o(124295);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wBY.clear();
      this.nrw.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wBZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(124295);
        throw paramVarArgs;
      }
      AppMethodBeat.o(124295);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      nc localnc = (nc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124295);
        return -1;
      case 1: 
        localnc.wBW = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(124295);
        return 0;
      case 2: 
        localnc.wBX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124295);
        return 0;
      case 3: 
        localnc.Title = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124295);
        return 0;
      case 4: 
        localnc.wBY.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(124295);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ni();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ni)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localnc.nrw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124295);
        return 0;
      case 6: 
        localnc.jJU = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124295);
        return 0;
      case 7: 
        localnc.wBZ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124295);
        return 0;
      }
      localnc.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(124295);
      return 0;
    }
    AppMethodBeat.o(124295);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nc
 * JD-Core Version:    0.7.0.1
 */