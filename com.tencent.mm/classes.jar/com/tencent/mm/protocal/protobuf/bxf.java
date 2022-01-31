package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bxf
  extends com.tencent.mm.bv.a
{
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public int gwT;
  public String gwU;
  public int gwV;
  public int gwW;
  public String gwX;
  public String gwY;
  public String gwZ;
  public String wJq;
  public String wJr;
  public bwc wOT;
  public bwc wOv;
  public bwc wOw;
  public String wYu;
  public SKBuiltinBuffer_t woT;
  public int xKf;
  public bwc xmi;
  public int xpe;
  public String xpf;
  public String xpg;
  public String xph;
  public int xpi;
  public cfj xpk;
  public wc xpl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80175);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(80175);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(80175);
        throw paramVarArgs;
      }
      if (this.wOv == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(80175);
        throw paramVarArgs;
      }
      if (this.wOw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(80175);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(80175);
        throw paramVarArgs;
      }
      if (this.wOT != null)
      {
        paramVarArgs.iQ(1, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      if (this.xmi != null)
      {
        paramVarArgs.iQ(2, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      if (this.wOv != null)
      {
        paramVarArgs.iQ(3, this.wOv.computeSize());
        this.wOv.writeFields(paramVarArgs);
      }
      if (this.wOw != null)
      {
        paramVarArgs.iQ(4, this.wOw.computeSize());
        this.wOw.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.gwP);
      if (this.woT != null)
      {
        paramVarArgs.iQ(6, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      if (this.gwQ != null) {
        paramVarArgs.e(7, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(8, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(9, this.gwS);
      }
      paramVarArgs.aO(10, this.gwT);
      paramVarArgs.aO(11, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(12, this.xpf);
      }
      if (this.xpg != null) {
        paramVarArgs.e(13, this.xpg);
      }
      if (this.gwU != null) {
        paramVarArgs.e(14, this.gwU);
      }
      if (this.xph != null) {
        paramVarArgs.e(15, this.xph);
      }
      paramVarArgs.aO(16, this.xpi);
      paramVarArgs.aO(17, this.gwW);
      paramVarArgs.aO(18, this.gwV);
      if (this.gwX != null) {
        paramVarArgs.e(19, this.gwX);
      }
      if (this.xpk != null)
      {
        paramVarArgs.iQ(20, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      if (this.gwY != null) {
        paramVarArgs.e(21, this.gwY);
      }
      if (this.gwZ != null) {
        paramVarArgs.e(22, this.gwZ);
      }
      if (this.xpl != null)
      {
        paramVarArgs.iQ(23, this.xpl.computeSize());
        this.xpl.writeFields(paramVarArgs);
      }
      if (this.wJq != null) {
        paramVarArgs.e(24, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(25, this.wJr);
      }
      if (this.wYu != null) {
        paramVarArgs.e(26, this.wYu);
      }
      paramVarArgs.aO(27, this.xKf);
      AppMethodBeat.o(80175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOT == null) {
        break label2602;
      }
    }
    label2602:
    for (int i = e.a.a.a.iP(1, this.wOT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xmi != null) {
        paramInt = i + e.a.a.a.iP(2, this.xmi.computeSize());
      }
      i = paramInt;
      if (this.wOv != null) {
        i = paramInt + e.a.a.a.iP(3, this.wOv.computeSize());
      }
      paramInt = i;
      if (this.wOw != null) {
        paramInt = i + e.a.a.a.iP(4, this.wOw.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.gwP);
      paramInt = i;
      if (this.woT != null) {
        paramInt = i + e.a.a.a.iP(6, this.woT.computeSize());
      }
      i = paramInt;
      if (this.gwQ != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.gwQ);
      }
      paramInt = i;
      if (this.gwR != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.gwR);
      }
      i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.gwS);
      }
      i = i + e.a.a.b.b.a.bl(10, this.gwT) + e.a.a.b.b.a.bl(11, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xpf);
      }
      i = paramInt;
      if (this.xpg != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.xpg);
      }
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.gwU);
      }
      i = paramInt;
      if (this.xph != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xph);
      }
      i = i + e.a.a.b.b.a.bl(16, this.xpi) + e.a.a.b.b.a.bl(17, this.gwW) + e.a.a.b.b.a.bl(18, this.gwV);
      paramInt = i;
      if (this.gwX != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.gwX);
      }
      i = paramInt;
      if (this.xpk != null) {
        i = paramInt + e.a.a.a.iP(20, this.xpk.computeSize());
      }
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.gwY);
      }
      i = paramInt;
      if (this.gwZ != null) {
        i = paramInt + e.a.a.b.b.a.f(22, this.gwZ);
      }
      paramInt = i;
      if (this.xpl != null) {
        paramInt = i + e.a.a.a.iP(23, this.xpl.computeSize());
      }
      i = paramInt;
      if (this.wJq != null) {
        i = paramInt + e.a.a.b.b.a.f(24, this.wJq);
      }
      paramInt = i;
      if (this.wJr != null) {
        paramInt = i + e.a.a.b.b.a.f(25, this.wJr);
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(26, this.wYu);
      }
      paramInt = e.a.a.b.b.a.bl(27, this.xKf);
      AppMethodBeat.o(80175);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOT == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(80175);
          throw paramVarArgs;
        }
        if (this.xmi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(80175);
          throw paramVarArgs;
        }
        if (this.wOv == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(80175);
          throw paramVarArgs;
        }
        if (this.wOw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(80175);
          throw paramVarArgs;
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(80175);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80175);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bxf localbxf = (bxf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80175);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxf.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80175);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxf.xmi = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80175);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxf.wOv = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80175);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxf.wOw = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80175);
          return 0;
        case 5: 
          localbxf.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80175);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxf.woT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80175);
          return 0;
        case 7: 
          localbxf.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 8: 
          localbxf.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 9: 
          localbxf.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 10: 
          localbxf.gwT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80175);
          return 0;
        case 11: 
          localbxf.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80175);
          return 0;
        case 12: 
          localbxf.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 13: 
          localbxf.xpg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 14: 
          localbxf.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 15: 
          localbxf.xph = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 16: 
          localbxf.xpi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80175);
          return 0;
        case 17: 
          localbxf.gwW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80175);
          return 0;
        case 18: 
          localbxf.gwV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80175);
          return 0;
        case 19: 
          localbxf.gwX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxf.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80175);
          return 0;
        case 21: 
          localbxf.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 22: 
          localbxf.gwZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 23: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxf.xpl = ((wc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80175);
          return 0;
        case 24: 
          localbxf.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 25: 
          localbxf.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        case 26: 
          localbxf.wYu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80175);
          return 0;
        }
        localbxf.xKf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80175);
        return 0;
      }
      AppMethodBeat.o(80175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxf
 * JD-Core Version:    0.7.0.1
 */