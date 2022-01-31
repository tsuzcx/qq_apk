package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bxi
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public long wBW;
  public String wBZ;
  public int wzS;
  public int xKm;
  public LinkedList<cpj> xKn;
  public String xba;
  public azu xqU;
  
  public bxi()
  {
    AppMethodBeat.i(124347);
    this.xKn = new LinkedList();
    AppMethodBeat.o(124347);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124348);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xba == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(124348);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.wBW);
      if (this.xba != null) {
        paramVarArgs.e(2, this.xba);
      }
      paramVarArgs.aO(3, this.wzS);
      if (this.xqU != null)
      {
        paramVarArgs.iQ(4, this.xqU.computeSize());
        this.xqU.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xKm);
      paramVarArgs.e(6, 8, this.xKn);
      paramVarArgs.aO(7, this.Scene);
      if (this.wBZ != null) {
        paramVarArgs.e(8, this.wBZ);
      }
      AppMethodBeat.o(124348);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.p(1, this.wBW) + 0;
      paramInt = i;
      if (this.xba != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xba);
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.wzS);
      paramInt = i;
      if (this.xqU != null) {
        paramInt = i + e.a.a.a.iP(4, this.xqU.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xKm) + e.a.a.a.c(6, 8, this.xKn) + e.a.a.b.b.a.bl(7, this.Scene);
      paramInt = i;
      if (this.wBZ != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wBZ);
      }
      AppMethodBeat.o(124348);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xKn.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xba == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(124348);
        throw paramVarArgs;
      }
      AppMethodBeat.o(124348);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bxi localbxi = (bxi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124348);
        return -1;
      case 1: 
        localbxi.wBW = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(124348);
        return 0;
      case 2: 
        localbxi.xba = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124348);
        return 0;
      case 3: 
        localbxi.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124348);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbxi.xqU = ((azu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124348);
        return 0;
      case 5: 
        localbxi.xKm = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124348);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cpj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbxi.xKn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124348);
        return 0;
      case 7: 
        localbxi.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124348);
        return 0;
      }
      localbxi.wBZ = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(124348);
      return 0;
    }
    AppMethodBeat.o(124348);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxi
 * JD-Core Version:    0.7.0.1
 */