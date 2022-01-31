package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bvd
  extends com.tencent.mm.bv.a
{
  public int vNt;
  public int wCO;
  public int xCa;
  public bvg xIN;
  public bvf xIO;
  public int xIP;
  public String xIQ;
  public int xIR;
  public int xIS;
  public int xIT;
  public int xbZ;
  public int xkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80162);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xIQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(80162);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xCa);
      if (this.xIN != null)
      {
        paramVarArgs.iQ(2, this.xIN.computeSize());
        this.xIN.writeFields(paramVarArgs);
      }
      if (this.xIO != null)
      {
        paramVarArgs.iQ(3, this.xIO.computeSize());
        this.xIO.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xbZ);
      paramVarArgs.aO(5, this.xIP);
      if (this.xIQ != null) {
        paramVarArgs.e(6, this.xIQ);
      }
      paramVarArgs.aO(7, this.wCO);
      paramVarArgs.aO(8, this.xIR);
      paramVarArgs.aO(9, this.vNt);
      paramVarArgs.aO(10, this.xIS);
      paramVarArgs.aO(11, this.xIT);
      paramVarArgs.aO(12, this.xkR);
      AppMethodBeat.o(80162);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xCa) + 0;
      paramInt = i;
      if (this.xIN != null) {
        paramInt = i + e.a.a.a.iP(2, this.xIN.computeSize());
      }
      i = paramInt;
      if (this.xIO != null) {
        i = paramInt + e.a.a.a.iP(3, this.xIO.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(4, this.xbZ) + e.a.a.b.b.a.bl(5, this.xIP);
      paramInt = i;
      if (this.xIQ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xIQ);
      }
      i = e.a.a.b.b.a.bl(7, this.wCO);
      int j = e.a.a.b.b.a.bl(8, this.xIR);
      int k = e.a.a.b.b.a.bl(9, this.vNt);
      int m = e.a.a.b.b.a.bl(10, this.xIS);
      int n = e.a.a.b.b.a.bl(11, this.xIT);
      int i1 = e.a.a.b.b.a.bl(12, this.xkR);
      AppMethodBeat.o(80162);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xIQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SampleId");
        AppMethodBeat.o(80162);
        throw paramVarArgs;
      }
      AppMethodBeat.o(80162);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bvd localbvd = (bvd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(80162);
        return -1;
      case 1: 
        localbvd.xCa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80162);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvd.xIN = ((bvg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80162);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbvd.xIO = ((bvf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80162);
        return 0;
      case 4: 
        localbvd.xbZ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80162);
        return 0;
      case 5: 
        localbvd.xIP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80162);
        return 0;
      case 6: 
        localbvd.xIQ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80162);
        return 0;
      case 7: 
        localbvd.wCO = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80162);
        return 0;
      case 8: 
        localbvd.xIR = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80162);
        return 0;
      case 9: 
        localbvd.vNt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80162);
        return 0;
      case 10: 
        localbvd.xIS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80162);
        return 0;
      case 11: 
        localbvd.xIT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80162);
        return 0;
      }
      localbvd.xkR = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(80162);
      return 0;
    }
    AppMethodBeat.o(80162);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvd
 * JD-Core Version:    0.7.0.1
 */