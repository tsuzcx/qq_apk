package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcd
  extends buy
{
  public String gwS;
  public String jJE;
  public String lGG;
  public String lGH;
  public String nGG;
  public int nrR;
  public String wAb;
  public String wAc;
  public String wQd;
  public String wYf;
  public int wkX;
  public hm wsm;
  public String wsn;
  public int wso;
  public String wsp;
  public String wsq;
  public SKBuiltinBuffer_t wsr;
  public SKBuiltinBuffer_t wss;
  public String xri;
  public String xrj;
  public String xrk;
  public int xrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58912);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wsm != null)
      {
        paramVarArgs.iQ(2, this.wsm.computeSize());
        this.wsm.writeFields(paramVarArgs);
      }
      if (this.nGG != null) {
        paramVarArgs.e(3, this.nGG);
      }
      if (this.wsn != null) {
        paramVarArgs.e(4, this.wsn);
      }
      paramVarArgs.aO(5, this.wso);
      if (this.wsp != null) {
        paramVarArgs.e(6, this.wsp);
      }
      if (this.gwS != null) {
        paramVarArgs.e(7, this.gwS);
      }
      if (this.jJE != null) {
        paramVarArgs.e(8, this.jJE);
      }
      if (this.wsq != null) {
        paramVarArgs.e(9, this.wsq);
      }
      if (this.lGH != null) {
        paramVarArgs.e(10, this.lGH);
      }
      if (this.lGG != null) {
        paramVarArgs.e(11, this.lGG);
      }
      paramVarArgs.aO(13, this.wkX);
      paramVarArgs.aO(14, this.nrR);
      if (this.wAc != null) {
        paramVarArgs.e(15, this.wAc);
      }
      if (this.wAb != null) {
        paramVarArgs.e(16, this.wAb);
      }
      if (this.xri != null) {
        paramVarArgs.e(17, this.xri);
      }
      if (this.wQd != null) {
        paramVarArgs.e(18, this.wQd);
      }
      if (this.wYf != null) {
        paramVarArgs.e(19, this.wYf);
      }
      if (this.xrj != null) {
        paramVarArgs.e(20, this.xrj);
      }
      if (this.xrk != null) {
        paramVarArgs.e(21, this.xrk);
      }
      paramVarArgs.aO(22, this.xrl);
      if (this.wsr != null)
      {
        paramVarArgs.iQ(23, this.wsr.computeSize());
        this.wsr.writeFields(paramVarArgs);
      }
      if (this.wss != null)
      {
        paramVarArgs.iQ(24, this.wss.computeSize());
        this.wss.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58912);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1886;
      }
    }
    label1886:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsm != null) {
        paramInt = i + e.a.a.a.iP(2, this.wsm.computeSize());
      }
      i = paramInt;
      if (this.nGG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nGG);
      }
      paramInt = i;
      if (this.wsn != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wsn);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wso);
      paramInt = i;
      if (this.wsp != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wsp);
      }
      i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.gwS);
      }
      paramInt = i;
      if (this.jJE != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.jJE);
      }
      i = paramInt;
      if (this.wsq != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wsq);
      }
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.lGH);
      }
      i = paramInt;
      if (this.lGG != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.lGG);
      }
      i = i + e.a.a.b.b.a.bl(13, this.wkX) + e.a.a.b.b.a.bl(14, this.nrR);
      paramInt = i;
      if (this.wAc != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.wAc);
      }
      i = paramInt;
      if (this.wAb != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.wAb);
      }
      paramInt = i;
      if (this.xri != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.xri);
      }
      i = paramInt;
      if (this.wQd != null) {
        i = paramInt + e.a.a.b.b.a.f(18, this.wQd);
      }
      paramInt = i;
      if (this.wYf != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.wYf);
      }
      i = paramInt;
      if (this.xrj != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.xrj);
      }
      paramInt = i;
      if (this.xrk != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.xrk);
      }
      i = paramInt + e.a.a.b.b.a.bl(22, this.xrl);
      paramInt = i;
      if (this.wsr != null) {
        paramInt = i + e.a.a.a.iP(23, this.wsr.computeSize());
      }
      i = paramInt;
      if (this.wss != null) {
        i = paramInt + e.a.a.a.iP(24, this.wss.computeSize());
      }
      AppMethodBeat.o(58912);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(58912);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bcd localbcd = (bcd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 12: 
        default: 
          AppMethodBeat.o(58912);
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
            localbcd.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58912);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcd.wsm = ((hm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58912);
          return 0;
        case 3: 
          localbcd.nGG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 4: 
          localbcd.wsn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 5: 
          localbcd.wso = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58912);
          return 0;
        case 6: 
          localbcd.wsp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 7: 
          localbcd.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 8: 
          localbcd.jJE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 9: 
          localbcd.wsq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 10: 
          localbcd.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 11: 
          localbcd.lGG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 13: 
          localbcd.wkX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58912);
          return 0;
        case 14: 
          localbcd.nrR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58912);
          return 0;
        case 15: 
          localbcd.wAc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 16: 
          localbcd.wAb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 17: 
          localbcd.xri = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 18: 
          localbcd.wQd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 19: 
          localbcd.wYf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 20: 
          localbcd.xrj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 21: 
          localbcd.xrk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58912);
          return 0;
        case 22: 
          localbcd.xrl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58912);
          return 0;
        case 23: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcd.wsr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58912);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbcd.wss = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58912);
        return 0;
      }
      AppMethodBeat.o(58912);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcd
 * JD-Core Version:    0.7.0.1
 */