package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class so
  extends buy
{
  public String fKw;
  public String jJA;
  public String nuv;
  public aw wDH;
  public String wJT;
  public String wKV;
  public String wKW;
  public String wKX;
  public String wKY;
  public int wKZ;
  public String wLa;
  public int wLb;
  public String wLc;
  public int woH;
  public String wvC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56760);
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
      if (this.wKV != null) {
        paramVarArgs.e(3, this.wKV);
      }
      if (this.wvC != null) {
        paramVarArgs.e(4, this.wvC);
      }
      if (this.wKW != null) {
        paramVarArgs.e(5, this.wKW);
      }
      if (this.wKX != null) {
        paramVarArgs.e(6, this.wKX);
      }
      if (this.wKY != null) {
        paramVarArgs.e(7, this.wKY);
      }
      if (this.wJT != null) {
        paramVarArgs.e(8, this.wJT);
      }
      paramVarArgs.aO(9, this.wKZ);
      if (this.wDH != null)
      {
        paramVarArgs.iQ(10, this.wDH.computeSize());
        this.wDH.writeFields(paramVarArgs);
      }
      if (this.wLa != null) {
        paramVarArgs.e(11, this.wLa);
      }
      if (this.jJA != null) {
        paramVarArgs.e(12, this.jJA);
      }
      if (this.nuv != null) {
        paramVarArgs.e(13, this.nuv);
      }
      paramVarArgs.aO(14, this.woH);
      paramVarArgs.aO(15, this.wLb);
      if (this.wLc != null) {
        paramVarArgs.e(16, this.wLc);
      }
      AppMethodBeat.o(56760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1278;
      }
    }
    label1278:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.wKV != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wKV);
      }
      paramInt = i;
      if (this.wvC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wvC);
      }
      i = paramInt;
      if (this.wKW != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wKW);
      }
      paramInt = i;
      if (this.wKX != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wKX);
      }
      i = paramInt;
      if (this.wKY != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wKY);
      }
      paramInt = i;
      if (this.wJT != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wJT);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.wKZ);
      paramInt = i;
      if (this.wDH != null) {
        paramInt = i + e.a.a.a.iP(10, this.wDH.computeSize());
      }
      i = paramInt;
      if (this.wLa != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wLa);
      }
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.jJA);
      }
      i = paramInt;
      if (this.nuv != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.nuv);
      }
      i = i + e.a.a.b.b.a.bl(14, this.woH) + e.a.a.b.b.a.bl(15, this.wLb);
      paramInt = i;
      if (this.wLc != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wLc);
      }
      AppMethodBeat.o(56760);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        so localso = (so)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56760);
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
            localso.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56760);
          return 0;
        case 2: 
          localso.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 3: 
          localso.wKV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 4: 
          localso.wvC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 5: 
          localso.wKW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 6: 
          localso.wKX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 7: 
          localso.wKY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 8: 
          localso.wJT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 9: 
          localso.wKZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56760);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localso.wDH = ((aw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56760);
          return 0;
        case 11: 
          localso.wLa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 12: 
          localso.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 13: 
          localso.nuv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56760);
          return 0;
        case 14: 
          localso.woH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56760);
          return 0;
        case 15: 
          localso.wLb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56760);
          return 0;
        }
        localso.wLc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56760);
        return 0;
      }
      AppMethodBeat.o(56760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.so
 * JD-Core Version:    0.7.0.1
 */