package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class ban
  extends buy
{
  public String wBZ;
  public int wzS;
  public String xba;
  public int xpF;
  public int xpG = 2;
  public double xpH;
  public double xpI;
  public String xpJ;
  public b xpK;
  public b xpL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124321);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xba != null) {
        paramVarArgs.e(2, this.xba);
      }
      paramVarArgs.aO(3, this.wzS);
      paramVarArgs.aO(4, this.xpF);
      if (this.wBZ != null) {
        paramVarArgs.e(5, this.wBZ);
      }
      paramVarArgs.aO(6, this.xpG);
      paramVarArgs.f(7, this.xpH);
      paramVarArgs.f(8, this.xpI);
      if (this.xpJ != null) {
        paramVarArgs.e(9, this.xpJ);
      }
      if (this.xpK != null) {
        paramVarArgs.c(11, this.xpK);
      }
      if (this.xpL != null) {
        paramVarArgs.c(12, this.xpL);
      }
      AppMethodBeat.o(124321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label844;
      }
    }
    label844:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xba != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xba);
      }
      i = i + e.a.a.b.b.a.bl(3, this.wzS) + e.a.a.b.b.a.bl(4, this.xpF);
      paramInt = i;
      if (this.wBZ != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wBZ);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xpG) + (e.a.a.b.b.a.eW(7) + 8) + (e.a.a.b.b.a.eW(8) + 8);
      paramInt = i;
      if (this.xpJ != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xpJ);
      }
      i = paramInt;
      if (this.xpK != null) {
        i = paramInt + e.a.a.b.b.a.b(11, this.xpK);
      }
      paramInt = i;
      if (this.xpL != null) {
        paramInt = i + e.a.a.b.b.a.b(12, this.xpL);
      }
      AppMethodBeat.o(124321);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124321);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ban localban = (ban)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 10: 
        default: 
          AppMethodBeat.o(124321);
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
            localban.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124321);
          return 0;
        case 2: 
          localban.xba = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124321);
          return 0;
        case 3: 
          localban.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124321);
          return 0;
        case 4: 
          localban.xpF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124321);
          return 0;
        case 5: 
          localban.wBZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124321);
          return 0;
        case 6: 
          localban.xpG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124321);
          return 0;
        case 7: 
          localban.xpH = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(124321);
          return 0;
        case 8: 
          localban.xpI = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(124321);
          return 0;
        case 9: 
          localban.xpJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124321);
          return 0;
        case 11: 
          localban.xpK = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(124321);
          return 0;
        }
        localban.xpL = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(124321);
        return 0;
      }
      AppMethodBeat.o(124321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ban
 * JD-Core Version:    0.7.0.1
 */