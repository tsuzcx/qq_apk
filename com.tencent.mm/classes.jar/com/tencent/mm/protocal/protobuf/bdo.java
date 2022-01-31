package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bdo
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
  public int wNQ;
  public bwc wOT;
  public bwc wOv;
  public bwc wOw;
  public SKBuiltinBuffer_t woT;
  public String xfJ;
  public bwc xmi;
  public int xpe;
  public String xpf;
  public String xpg;
  public String xph;
  public int xpi;
  public cfj xpk;
  public wc xpl;
  public bwc xsT;
  public bwc xsU;
  public bwc xsV;
  public int xtk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5595);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(5595);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(5595);
        throw paramVarArgs;
      }
      if (this.wOv == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(5595);
        throw paramVarArgs;
      }
      if (this.wOw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(5595);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(5595);
        throw paramVarArgs;
      }
      if (this.xsT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(5595);
        throw paramVarArgs;
      }
      if (this.xsU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(5595);
        throw paramVarArgs;
      }
      if (this.xsV == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(5595);
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
      paramVarArgs.aO(7, this.xtk);
      if (this.xsT != null)
      {
        paramVarArgs.iQ(8, this.xsT.computeSize());
        this.xsT.writeFields(paramVarArgs);
      }
      if (this.xsU != null)
      {
        paramVarArgs.iQ(9, this.xsU.computeSize());
        this.xsU.writeFields(paramVarArgs);
      }
      if (this.xsV != null)
      {
        paramVarArgs.iQ(10, this.xsV.computeSize());
        this.xsV.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.wNQ);
      if (this.gwQ != null) {
        paramVarArgs.e(12, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(13, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(14, this.gwS);
      }
      paramVarArgs.aO(15, this.gwT);
      paramVarArgs.aO(16, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(17, this.xpf);
      }
      if (this.xpg != null) {
        paramVarArgs.e(18, this.xpg);
      }
      if (this.xfJ != null) {
        paramVarArgs.e(19, this.xfJ);
      }
      if (this.xph != null) {
        paramVarArgs.e(20, this.xph);
      }
      paramVarArgs.aO(21, this.xpi);
      paramVarArgs.aO(22, this.gwW);
      paramVarArgs.aO(23, this.gwV);
      if (this.gwX != null) {
        paramVarArgs.e(24, this.gwX);
      }
      if (this.gwU != null) {
        paramVarArgs.e(25, this.gwU);
      }
      if (this.xpk != null)
      {
        paramVarArgs.iQ(26, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      if (this.gwY != null) {
        paramVarArgs.e(27, this.gwY);
      }
      if (this.wJq != null) {
        paramVarArgs.e(28, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(29, this.wJr);
      }
      if (this.gwZ != null) {
        paramVarArgs.e(30, this.gwZ);
      }
      if (this.xpl != null)
      {
        paramVarArgs.iQ(31, this.xpl.computeSize());
        this.xpl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(5595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOT == null) {
        break label3311;
      }
    }
    label3311:
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
      i = paramInt + e.a.a.b.b.a.bl(7, this.xtk);
      paramInt = i;
      if (this.xsT != null) {
        paramInt = i + e.a.a.a.iP(8, this.xsT.computeSize());
      }
      i = paramInt;
      if (this.xsU != null) {
        i = paramInt + e.a.a.a.iP(9, this.xsU.computeSize());
      }
      paramInt = i;
      if (this.xsV != null) {
        paramInt = i + e.a.a.a.iP(10, this.xsV.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.wNQ);
      paramInt = i;
      if (this.gwQ != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.gwQ);
      }
      i = paramInt;
      if (this.gwR != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.gwR);
      }
      paramInt = i;
      if (this.gwS != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.gwS);
      }
      i = paramInt + e.a.a.b.b.a.bl(15, this.gwT) + e.a.a.b.b.a.bl(16, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.xpf);
      }
      i = paramInt;
      if (this.xpg != null) {
        i = paramInt + e.a.a.b.b.a.f(18, this.xpg);
      }
      paramInt = i;
      if (this.xfJ != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.xfJ);
      }
      i = paramInt;
      if (this.xph != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.xph);
      }
      i = i + e.a.a.b.b.a.bl(21, this.xpi) + e.a.a.b.b.a.bl(22, this.gwW) + e.a.a.b.b.a.bl(23, this.gwV);
      paramInt = i;
      if (this.gwX != null) {
        paramInt = i + e.a.a.b.b.a.f(24, this.gwX);
      }
      i = paramInt;
      if (this.gwU != null) {
        i = paramInt + e.a.a.b.b.a.f(25, this.gwU);
      }
      paramInt = i;
      if (this.xpk != null) {
        paramInt = i + e.a.a.a.iP(26, this.xpk.computeSize());
      }
      i = paramInt;
      if (this.gwY != null) {
        i = paramInt + e.a.a.b.b.a.f(27, this.gwY);
      }
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(28, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(29, this.wJr);
      }
      paramInt = i;
      if (this.gwZ != null) {
        paramInt = i + e.a.a.b.b.a.f(30, this.gwZ);
      }
      i = paramInt;
      if (this.xpl != null) {
        i = paramInt + e.a.a.a.iP(31, this.xpl.computeSize());
      }
      AppMethodBeat.o(5595);
      return i;
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
          AppMethodBeat.o(5595);
          throw paramVarArgs;
        }
        if (this.xmi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(5595);
          throw paramVarArgs;
        }
        if (this.wOv == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(5595);
          throw paramVarArgs;
        }
        if (this.wOw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(5595);
          throw paramVarArgs;
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(5595);
          throw paramVarArgs;
        }
        if (this.xsT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(5595);
          throw paramVarArgs;
        }
        if (this.xsU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(5595);
          throw paramVarArgs;
        }
        if (this.xsV == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(5595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bdo localbdo = (bdo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5595);
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
            localbdo.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
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
            localbdo.xmi = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
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
            localbdo.wOv = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
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
            localbdo.wOw = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
          return 0;
        case 5: 
          localbdo.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5595);
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
            localbdo.woT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
          return 0;
        case 7: 
          localbdo.xtk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5595);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdo.xsT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdo.xsU = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdo.xsV = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
          return 0;
        case 11: 
          localbdo.wNQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5595);
          return 0;
        case 12: 
          localbdo.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 13: 
          localbdo.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 14: 
          localbdo.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 15: 
          localbdo.gwT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5595);
          return 0;
        case 16: 
          localbdo.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5595);
          return 0;
        case 17: 
          localbdo.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 18: 
          localbdo.xpg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 19: 
          localbdo.xfJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 20: 
          localbdo.xph = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 21: 
          localbdo.xpi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5595);
          return 0;
        case 22: 
          localbdo.gwW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5595);
          return 0;
        case 23: 
          localbdo.gwV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5595);
          return 0;
        case 24: 
          localbdo.gwX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 25: 
          localbdo.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 26: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbdo.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5595);
          return 0;
        case 27: 
          localbdo.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 28: 
          localbdo.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 29: 
          localbdo.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        case 30: 
          localbdo.gwZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5595);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new wc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((wc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbdo.xpl = ((wc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5595);
        return 0;
      }
      AppMethodBeat.o(5595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdo
 * JD-Core Version:    0.7.0.1
 */