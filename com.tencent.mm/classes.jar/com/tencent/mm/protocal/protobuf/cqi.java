package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqi
  extends com.tencent.mm.bv.a
{
  public String qsu;
  public String wYm;
  public String wYu;
  public int wqO;
  public String xJi;
  public String xYO;
  public int xYP;
  public String xYQ;
  public String xYR;
  public int xYS;
  public String xYT;
  public int xYU;
  public SKBuiltinBuffer_t xYV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80207);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.qsu != null) {
        paramVarArgs.e(1, this.qsu);
      }
      if (this.xYO != null) {
        paramVarArgs.e(2, this.xYO);
      }
      if (this.wYu != null) {
        paramVarArgs.e(3, this.wYu);
      }
      paramVarArgs.aO(4, this.xYP);
      if (this.xJi != null) {
        paramVarArgs.e(5, this.xJi);
      }
      if (this.xYQ != null) {
        paramVarArgs.e(6, this.xYQ);
      }
      if (this.xYR != null) {
        paramVarArgs.e(7, this.xYR);
      }
      paramVarArgs.aO(8, this.xYS);
      if (this.xYT != null) {
        paramVarArgs.e(9, this.xYT);
      }
      paramVarArgs.aO(10, this.xYU);
      if (this.xYV != null)
      {
        paramVarArgs.iQ(11, this.xYV.computeSize());
        this.xYV.writeFields(paramVarArgs);
      }
      if (this.wYm != null) {
        paramVarArgs.e(12, this.wYm);
      }
      paramVarArgs.aO(13, this.wqO);
      AppMethodBeat.o(80207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qsu == null) {
        break label982;
      }
    }
    label982:
    for (int i = e.a.a.b.b.a.f(1, this.qsu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xYO != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xYO);
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wYu);
      }
      i += e.a.a.b.b.a.bl(4, this.xYP);
      paramInt = i;
      if (this.xJi != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xJi);
      }
      i = paramInt;
      if (this.xYQ != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xYQ);
      }
      paramInt = i;
      if (this.xYR != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xYR);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xYS);
      paramInt = i;
      if (this.xYT != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xYT);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.xYU);
      paramInt = i;
      if (this.xYV != null) {
        paramInt = i + e.a.a.a.iP(11, this.xYV.computeSize());
      }
      i = paramInt;
      if (this.wYm != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wYm);
      }
      paramInt = e.a.a.b.b.a.bl(13, this.wqO);
      AppMethodBeat.o(80207);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqi localcqi = (cqi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80207);
          return -1;
        case 1: 
          localcqi.qsu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80207);
          return 0;
        case 2: 
          localcqi.xYO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80207);
          return 0;
        case 3: 
          localcqi.wYu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80207);
          return 0;
        case 4: 
          localcqi.xYP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80207);
          return 0;
        case 5: 
          localcqi.xJi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80207);
          return 0;
        case 6: 
          localcqi.xYQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80207);
          return 0;
        case 7: 
          localcqi.xYR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80207);
          return 0;
        case 8: 
          localcqi.xYS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80207);
          return 0;
        case 9: 
          localcqi.xYT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80207);
          return 0;
        case 10: 
          localcqi.xYU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80207);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqi.xYV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80207);
          return 0;
        case 12: 
          localcqi.wYm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80207);
          return 0;
        }
        localcqi.wqO = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80207);
        return 0;
      }
      AppMethodBeat.o(80207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqi
 * JD-Core Version:    0.7.0.1
 */