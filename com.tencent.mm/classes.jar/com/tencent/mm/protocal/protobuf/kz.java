package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kz
  extends buy
{
  public String ProductID;
  public int Scene;
  public LinkedList<String> wyM;
  public String wyN;
  public double wyO;
  public double wyP;
  
  public kz()
  {
    AppMethodBeat.i(11711);
    this.wyM = new LinkedList();
    AppMethodBeat.o(11711);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11712);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(2, this.ProductID);
      }
      paramVarArgs.e(3, 1, this.wyM);
      paramVarArgs.aO(4, this.Scene);
      if (this.wyN != null) {
        paramVarArgs.e(5, this.wyN);
      }
      paramVarArgs.f(6, this.wyO);
      paramVarArgs.f(7, this.wyP);
      AppMethodBeat.o(11712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label641;
      }
    }
    label641:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ProductID);
      }
      i = i + e.a.a.a.c(3, 1, this.wyM) + e.a.a.b.b.a.bl(4, this.Scene);
      paramInt = i;
      if (this.wyN != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wyN);
      }
      i = e.a.a.b.b.a.eW(6);
      int j = e.a.a.b.b.a.eW(7);
      AppMethodBeat.o(11712);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wyM.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        kz localkz = (kz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11712);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localkz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11712);
          return 0;
        case 2: 
          localkz.ProductID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11712);
          return 0;
        case 3: 
          localkz.wyM.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(11712);
          return 0;
        case 4: 
          localkz.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11712);
          return 0;
        case 5: 
          localkz.wyN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11712);
          return 0;
        case 6: 
          localkz.wyO = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(11712);
          return 0;
        }
        localkz.wyP = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
        AppMethodBeat.o(11712);
        return 0;
      }
      AppMethodBeat.o(11712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kz
 * JD-Core Version:    0.7.0.1
 */