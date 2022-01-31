package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amg
  extends buy
{
  public int Scene;
  public int nrS;
  public String wQr;
  public int xcV;
  public LinkedList<bdj> xcW;
  public int xcX;
  public LinkedList<bba> xcY;
  
  public amg()
  {
    AppMethodBeat.i(73707);
    this.xcW = new LinkedList();
    this.xcY = new LinkedList();
    AppMethodBeat.o(73707);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73708);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.nrS);
      if (this.wQr != null) {
        paramVarArgs.e(3, this.wQr);
      }
      paramVarArgs.aO(4, this.xcV);
      paramVarArgs.e(5, 8, this.xcW);
      paramVarArgs.aO(6, this.xcX);
      paramVarArgs.e(7, 8, this.xcY);
      paramVarArgs.aO(8, this.Scene);
      AppMethodBeat.o(73708);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.nrS);
      paramInt = i;
      if (this.wQr != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wQr);
      }
      i = e.a.a.b.b.a.bl(4, this.xcV);
      int j = e.a.a.a.c(5, 8, this.xcW);
      int k = e.a.a.b.b.a.bl(6, this.xcX);
      int m = e.a.a.a.c(7, 8, this.xcY);
      int n = e.a.a.b.b.a.bl(8, this.Scene);
      AppMethodBeat.o(73708);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xcW.clear();
        this.xcY.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73708);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        amg localamg = (amg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73708);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamg.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73708);
          return 0;
        case 2: 
          localamg.nrS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73708);
          return 0;
        case 3: 
          localamg.wQr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73708);
          return 0;
        case 4: 
          localamg.xcV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73708);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamg.xcW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73708);
          return 0;
        case 6: 
          localamg.xcX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73708);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bba();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bba)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamg.xcY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73708);
          return 0;
        }
        localamg.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(73708);
        return 0;
      }
      AppMethodBeat.o(73708);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amg
 * JD-Core Version:    0.7.0.1
 */