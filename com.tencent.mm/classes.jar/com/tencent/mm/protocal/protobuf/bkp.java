package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkp
  extends buy
{
  public String fKw;
  public String nqc;
  public String ntp;
  public aw wDH;
  public String wKV;
  public String wKW;
  public String wKX;
  public String wKY;
  public String wXQ;
  public String xzm;
  public String xzn;
  public String xzo;
  public String xzp;
  public String xzq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56876);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      if (this.xzm != null) {
        paramVarArgs.e(3, this.xzm);
      }
      if (this.wXQ != null) {
        paramVarArgs.e(4, this.wXQ);
      }
      if (this.wKV != null) {
        paramVarArgs.e(5, this.wKV);
      }
      if (this.xzn != null) {
        paramVarArgs.e(6, this.xzn);
      }
      if (this.wKW != null) {
        paramVarArgs.e(7, this.wKW);
      }
      if (this.wKX != null) {
        paramVarArgs.e(8, this.wKX);
      }
      if (this.wKY != null) {
        paramVarArgs.e(9, this.wKY);
      }
      if (this.xzo != null) {
        paramVarArgs.e(10, this.xzo);
      }
      if (this.wDH != null)
      {
        paramVarArgs.iQ(11, this.wDH.computeSize());
        this.wDH.writeFields(paramVarArgs);
      }
      if (this.xzp != null) {
        paramVarArgs.e(12, this.xzp);
      }
      if (this.nqc != null) {
        paramVarArgs.e(13, this.nqc);
      }
      if (this.ntp != null) {
        paramVarArgs.e(14, this.ntp);
      }
      if (this.xzq != null) {
        paramVarArgs.e(15, this.xzq);
      }
      AppMethodBeat.o(56876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1266;
      }
    }
    label1266:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.xzm != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xzm);
      }
      paramInt = i;
      if (this.wXQ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wXQ);
      }
      i = paramInt;
      if (this.wKV != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wKV);
      }
      paramInt = i;
      if (this.xzn != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xzn);
      }
      i = paramInt;
      if (this.wKW != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wKW);
      }
      paramInt = i;
      if (this.wKX != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wKX);
      }
      i = paramInt;
      if (this.wKY != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wKY);
      }
      paramInt = i;
      if (this.xzo != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xzo);
      }
      i = paramInt;
      if (this.wDH != null) {
        i = paramInt + e.a.a.a.iP(11, this.wDH.computeSize());
      }
      paramInt = i;
      if (this.xzp != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xzp);
      }
      i = paramInt;
      if (this.nqc != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.nqc);
      }
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.ntp);
      }
      i = paramInt;
      if (this.xzq != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xzq);
      }
      AppMethodBeat.o(56876);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56876);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bkp localbkp = (bkp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56876);
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
            localbkp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56876);
          return 0;
        case 2: 
          localbkp.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 3: 
          localbkp.xzm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 4: 
          localbkp.wXQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 5: 
          localbkp.wKV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 6: 
          localbkp.xzn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 7: 
          localbkp.wKW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 8: 
          localbkp.wKX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 9: 
          localbkp.wKY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 10: 
          localbkp.xzo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbkp.wDH = ((aw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56876);
          return 0;
        case 12: 
          localbkp.xzp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 13: 
          localbkp.nqc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        case 14: 
          localbkp.ntp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56876);
          return 0;
        }
        localbkp.xzq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56876);
        return 0;
      }
      AppMethodBeat.o(56876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkp
 * JD-Core Version:    0.7.0.1
 */