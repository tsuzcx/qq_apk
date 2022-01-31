package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxw
  extends com.tencent.mm.bv.a
{
  public String fKw;
  public int gwP;
  public String jJA;
  public String jKG;
  public String wJq;
  public String wJr;
  public String wNI;
  public String wNJ;
  public String wYu;
  public int xKf;
  public bie xKv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80179);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.wNI != null) {
        paramVarArgs.e(3, this.wNI);
      }
      if (this.wNJ != null) {
        paramVarArgs.e(4, this.wNJ);
      }
      paramVarArgs.aO(5, this.gwP);
      if (this.wJq != null) {
        paramVarArgs.e(6, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(7, this.wJr);
      }
      if (this.fKw != null) {
        paramVarArgs.e(8, this.fKw);
      }
      paramVarArgs.aO(9, this.xKf);
      if (this.xKv != null)
      {
        paramVarArgs.iQ(10, this.xKv.computeSize());
        this.xKv.writeFields(paramVarArgs);
      }
      if (this.wYu != null) {
        paramVarArgs.e(11, this.wYu);
      }
      AppMethodBeat.o(80179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label890;
      }
    }
    label890:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.wNI != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wNI);
      }
      paramInt = i;
      if (this.wNJ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wNJ);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.gwP);
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wJr);
      }
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.fKw);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.xKf);
      paramInt = i;
      if (this.xKv != null) {
        paramInt = i + e.a.a.a.iP(10, this.xKv.computeSize());
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wYu);
      }
      AppMethodBeat.o(80179);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80179);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bxw localbxw = (bxw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80179);
          return -1;
        case 1: 
          localbxw.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80179);
          return 0;
        case 2: 
          localbxw.jKG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80179);
          return 0;
        case 3: 
          localbxw.wNI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80179);
          return 0;
        case 4: 
          localbxw.wNJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80179);
          return 0;
        case 5: 
          localbxw.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80179);
          return 0;
        case 6: 
          localbxw.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80179);
          return 0;
        case 7: 
          localbxw.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80179);
          return 0;
        case 8: 
          localbxw.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80179);
          return 0;
        case 9: 
          localbxw.xKf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80179);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bie();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bie)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxw.xKv = ((bie)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80179);
          return 0;
        }
        localbxw.wYu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80179);
        return 0;
      }
      AppMethodBeat.o(80179);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxw
 * JD-Core Version:    0.7.0.1
 */