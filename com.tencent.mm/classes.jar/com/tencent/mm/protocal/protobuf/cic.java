package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cic
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String Id;
  public String jJA;
  public long timeStamp;
  public chj xSJ;
  public chb xSK;
  public String xSL;
  public int xSM;
  public int xSN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56547);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      paramVarArgs.aO(3, this.CreateTime);
      if (this.xSJ != null)
      {
        paramVarArgs.iQ(4, this.xSJ.computeSize());
        this.xSJ.writeFields(paramVarArgs);
      }
      if (this.xSK != null)
      {
        paramVarArgs.iQ(5, this.xSK.computeSize());
        this.xSK.writeFields(paramVarArgs);
      }
      paramVarArgs.am(6, this.timeStamp);
      if (this.xSL != null) {
        paramVarArgs.e(7, this.xSL);
      }
      paramVarArgs.aO(8, this.xSM);
      paramVarArgs.aO(9, this.xSN);
      AppMethodBeat.o(56547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = e.a.a.b.b.a.f(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jJA);
      }
      i += e.a.a.b.b.a.bl(3, this.CreateTime);
      paramInt = i;
      if (this.xSJ != null) {
        paramInt = i + e.a.a.a.iP(4, this.xSJ.computeSize());
      }
      i = paramInt;
      if (this.xSK != null) {
        i = paramInt + e.a.a.a.iP(5, this.xSK.computeSize());
      }
      i += e.a.a.b.b.a.p(6, this.timeStamp);
      paramInt = i;
      if (this.xSL != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xSL);
      }
      i = e.a.a.b.b.a.bl(8, this.xSM);
      int j = e.a.a.b.b.a.bl(9, this.xSN);
      AppMethodBeat.o(56547);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56547);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cic localcic = (cic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56547);
          return -1;
        case 1: 
          localcic.Id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56547);
          return 0;
        case 2: 
          localcic.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56547);
          return 0;
        case 3: 
          localcic.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56547);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcic.xSJ = ((chj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56547);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcic.xSK = ((chb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56547);
          return 0;
        case 6: 
          localcic.timeStamp = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56547);
          return 0;
        case 7: 
          localcic.xSL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56547);
          return 0;
        case 8: 
          localcic.xSM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56547);
          return 0;
        }
        localcic.xSN = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56547);
        return 0;
      }
      AppMethodBeat.o(56547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cic
 * JD-Core Version:    0.7.0.1
 */