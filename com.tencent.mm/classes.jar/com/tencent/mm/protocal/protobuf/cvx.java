package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvx
  extends buy
{
  public int jKs;
  public String wBZ;
  public int wzS;
  public int xCa;
  public String xba;
  public int xpF;
  public int xpG = 2;
  public double xpH;
  public double xpI;
  public String xpJ;
  public String yem;
  public String yen;
  public String yeo;
  public int yep;
  public String yeq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93809);
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
      paramVarArgs.aO(9, this.jKs);
      paramVarArgs.aO(10, this.xCa);
      if (this.xpJ != null) {
        paramVarArgs.e(99, this.xpJ);
      }
      if (this.yem != null) {
        paramVarArgs.e(100, this.yem);
      }
      if (this.yen != null) {
        paramVarArgs.e(101, this.yen);
      }
      if (this.yeo != null) {
        paramVarArgs.e(102, this.yeo);
      }
      paramVarArgs.aO(103, this.yep);
      if (this.yeq != null) {
        paramVarArgs.e(104, this.yeq);
      }
      AppMethodBeat.o(93809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1160;
      }
    }
    label1160:
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
      i = paramInt + e.a.a.b.b.a.bl(6, this.xpG) + (e.a.a.b.b.a.eW(7) + 8) + (e.a.a.b.b.a.eW(8) + 8) + e.a.a.b.b.a.bl(9, this.jKs) + e.a.a.b.b.a.bl(10, this.xCa);
      paramInt = i;
      if (this.xpJ != null) {
        paramInt = i + e.a.a.b.b.a.f(99, this.xpJ);
      }
      i = paramInt;
      if (this.yem != null) {
        i = paramInt + e.a.a.b.b.a.f(100, this.yem);
      }
      paramInt = i;
      if (this.yen != null) {
        paramInt = i + e.a.a.b.b.a.f(101, this.yen);
      }
      i = paramInt;
      if (this.yeo != null) {
        i = paramInt + e.a.a.b.b.a.f(102, this.yeo);
      }
      i += e.a.a.b.b.a.bl(103, this.yep);
      paramInt = i;
      if (this.yeq != null) {
        paramInt = i + e.a.a.b.b.a.f(104, this.yeq);
      }
      AppMethodBeat.o(93809);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(93809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cvx localcvx = (cvx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93809);
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
            localcvx.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(93809);
          return 0;
        case 2: 
          localcvx.xba = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93809);
          return 0;
        case 3: 
          localcvx.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93809);
          return 0;
        case 4: 
          localcvx.xpF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93809);
          return 0;
        case 5: 
          localcvx.wBZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93809);
          return 0;
        case 6: 
          localcvx.xpG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93809);
          return 0;
        case 7: 
          localcvx.xpH = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(93809);
          return 0;
        case 8: 
          localcvx.xpI = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(93809);
          return 0;
        case 9: 
          localcvx.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93809);
          return 0;
        case 10: 
          localcvx.xCa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93809);
          return 0;
        case 99: 
          localcvx.xpJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93809);
          return 0;
        case 100: 
          localcvx.yem = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93809);
          return 0;
        case 101: 
          localcvx.yen = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93809);
          return 0;
        case 102: 
          localcvx.yeo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(93809);
          return 0;
        case 103: 
          localcvx.yep = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93809);
          return 0;
        }
        localcvx.yeq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(93809);
        return 0;
      }
      AppMethodBeat.o(93809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvx
 * JD-Core Version:    0.7.0.1
 */