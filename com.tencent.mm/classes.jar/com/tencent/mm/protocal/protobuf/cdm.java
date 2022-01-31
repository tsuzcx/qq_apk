package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdm
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public int IsNotRichText;
  public int jKs;
  public int niK;
  public String ntu;
  public String wQO;
  public btk wpo;
  public String xCG;
  public String xNV;
  public String xNW;
  public int xNX;
  public int xNY;
  public long xNZ;
  public long xOa;
  public SKBuiltinBuffer_t xOb;
  public int xOc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94563);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xCG != null) {
        paramVarArgs.e(1, this.xCG);
      }
      if (this.wQO != null) {
        paramVarArgs.e(2, this.wQO);
      }
      if (this.xNV != null) {
        paramVarArgs.e(3, this.xNV);
      }
      if (this.xNW != null) {
        paramVarArgs.e(4, this.xNW);
      }
      paramVarArgs.aO(5, this.jKs);
      paramVarArgs.aO(6, this.niK);
      paramVarArgs.aO(7, this.CreateTime);
      if (this.ntu != null) {
        paramVarArgs.e(8, this.ntu);
      }
      paramVarArgs.aO(9, this.xNX);
      paramVarArgs.aO(10, this.xNY);
      paramVarArgs.aO(11, this.IsNotRichText);
      paramVarArgs.am(12, this.xNZ);
      paramVarArgs.am(13, this.xOa);
      if (this.xOb != null)
      {
        paramVarArgs.iQ(14, this.xOb.computeSize());
        this.xOb.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(15, this.xOc);
      if (this.wpo != null)
      {
        paramVarArgs.iQ(16, this.wpo.computeSize());
        this.wpo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xCG == null) {
        break label1170;
      }
    }
    label1170:
    for (int i = e.a.a.b.b.a.f(1, this.xCG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wQO != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wQO);
      }
      i = paramInt;
      if (this.xNV != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xNV);
      }
      paramInt = i;
      if (this.xNW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xNW);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.jKs) + e.a.a.b.b.a.bl(6, this.niK) + e.a.a.b.b.a.bl(7, this.CreateTime);
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.ntu);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.xNX) + e.a.a.b.b.a.bl(10, this.xNY) + e.a.a.b.b.a.bl(11, this.IsNotRichText) + e.a.a.b.b.a.p(12, this.xNZ) + e.a.a.b.b.a.p(13, this.xOa);
      paramInt = i;
      if (this.xOb != null) {
        paramInt = i + e.a.a.a.iP(14, this.xOb.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(15, this.xOc);
      paramInt = i;
      if (this.wpo != null) {
        paramInt = i + e.a.a.a.iP(16, this.wpo.computeSize());
      }
      AppMethodBeat.o(94563);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdm localcdm = (cdm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94563);
          return -1;
        case 1: 
          localcdm.xCG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94563);
          return 0;
        case 2: 
          localcdm.wQO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94563);
          return 0;
        case 3: 
          localcdm.xNV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94563);
          return 0;
        case 4: 
          localcdm.xNW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94563);
          return 0;
        case 5: 
          localcdm.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94563);
          return 0;
        case 6: 
          localcdm.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94563);
          return 0;
        case 7: 
          localcdm.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94563);
          return 0;
        case 8: 
          localcdm.ntu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94563);
          return 0;
        case 9: 
          localcdm.xNX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94563);
          return 0;
        case 10: 
          localcdm.xNY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94563);
          return 0;
        case 11: 
          localcdm.IsNotRichText = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94563);
          return 0;
        case 12: 
          localcdm.xNZ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94563);
          return 0;
        case 13: 
          localcdm.xOa = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94563);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcdm.xOb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94563);
          return 0;
        case 15: 
          localcdm.xOc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94563);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdm.wpo = ((btk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94563);
        return 0;
      }
      AppMethodBeat.o(94563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdm
 * JD-Core Version:    0.7.0.1
 */