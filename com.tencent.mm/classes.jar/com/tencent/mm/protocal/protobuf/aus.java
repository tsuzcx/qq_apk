package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aus
  extends com.tencent.mm.bv.a
{
  public String materialId;
  public int subType;
  public int wyC;
  public String xjL;
  public aut xjM;
  public String xjN;
  public int xjO;
  public int xjP;
  public long xjQ;
  public int xjR;
  public String xjS;
  public String xjT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56843);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xjL != null) {
        paramVarArgs.e(1, this.xjL);
      }
      paramVarArgs.aO(2, this.subType);
      if (this.materialId != null) {
        paramVarArgs.e(3, this.materialId);
      }
      if (this.xjM != null)
      {
        paramVarArgs.iQ(4, this.xjM.computeSize());
        this.xjM.writeFields(paramVarArgs);
      }
      if (this.xjN != null) {
        paramVarArgs.e(5, this.xjN);
      }
      paramVarArgs.aO(6, this.xjO);
      paramVarArgs.aO(7, this.xjP);
      paramVarArgs.am(8, this.xjQ);
      paramVarArgs.aO(9, this.xjR);
      paramVarArgs.aO(10, this.wyC);
      if (this.xjS != null) {
        paramVarArgs.e(11, this.xjS);
      }
      if (this.xjT != null) {
        paramVarArgs.e(12, this.xjT);
      }
      AppMethodBeat.o(56843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xjL == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = e.a.a.b.b.a.f(1, this.xjL) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.subType);
      paramInt = i;
      if (this.materialId != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.materialId);
      }
      i = paramInt;
      if (this.xjM != null) {
        i = paramInt + e.a.a.a.iP(4, this.xjM.computeSize());
      }
      paramInt = i;
      if (this.xjN != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xjN);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xjO) + e.a.a.b.b.a.bl(7, this.xjP) + e.a.a.b.b.a.p(8, this.xjQ) + e.a.a.b.b.a.bl(9, this.xjR) + e.a.a.b.b.a.bl(10, this.wyC);
      paramInt = i;
      if (this.xjS != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xjS);
      }
      i = paramInt;
      if (this.xjT != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xjT);
      }
      AppMethodBeat.o(56843);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aus localaus = (aus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56843);
          return -1;
        case 1: 
          localaus.xjL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56843);
          return 0;
        case 2: 
          localaus.subType = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56843);
          return 0;
        case 3: 
          localaus.materialId = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56843);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aut();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aut)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaus.xjM = ((aut)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56843);
          return 0;
        case 5: 
          localaus.xjN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56843);
          return 0;
        case 6: 
          localaus.xjO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56843);
          return 0;
        case 7: 
          localaus.xjP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56843);
          return 0;
        case 8: 
          localaus.xjQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56843);
          return 0;
        case 9: 
          localaus.xjR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56843);
          return 0;
        case 10: 
          localaus.wyC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56843);
          return 0;
        case 11: 
          localaus.xjS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56843);
          return 0;
        }
        localaus.xjT = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56843);
        return 0;
      }
      AppMethodBeat.o(56843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aus
 * JD-Core Version:    0.7.0.1
 */