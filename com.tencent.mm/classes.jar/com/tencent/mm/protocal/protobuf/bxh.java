package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bxh
  extends bvk
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
  public SKBuiltinBuffer_t xKh;
  public String xKi;
  public String xKj;
  public int xKk;
  public LinkedList<bxw> xKl;
  public int xaS;
  public LinkedList<bxf> xaT;
  public bwc xmi;
  public int xpe;
  public String xpf;
  public String xpg;
  public String xph;
  public int xpi;
  public cfj xpk;
  public wc xpl;
  
  public bxh()
  {
    AppMethodBeat.i(80177);
    this.xaT = new LinkedList();
    this.xKl = new LinkedList();
    AppMethodBeat.o(80177);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80178);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80178);
        throw paramVarArgs;
      }
      if (this.wOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(80178);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(80178);
        throw paramVarArgs;
      }
      if (this.wOv == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(80178);
        throw paramVarArgs;
      }
      if (this.wOw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(80178);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(80178);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wOT != null)
      {
        paramVarArgs.iQ(2, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      if (this.xmi != null)
      {
        paramVarArgs.iQ(3, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      if (this.wOv != null)
      {
        paramVarArgs.iQ(4, this.wOv.computeSize());
        this.wOv.writeFields(paramVarArgs);
      }
      if (this.wOw != null)
      {
        paramVarArgs.iQ(5, this.wOw.computeSize());
        this.wOw.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.gwP);
      if (this.woT != null)
      {
        paramVarArgs.iQ(7, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      if (this.gwQ != null) {
        paramVarArgs.e(8, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(9, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(10, this.gwS);
      }
      paramVarArgs.aO(11, this.gwT);
      paramVarArgs.aO(12, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(13, this.xpf);
      }
      if (this.xpg != null) {
        paramVarArgs.e(14, this.xpg);
      }
      if (this.gwU != null) {
        paramVarArgs.e(15, this.gwU);
      }
      if (this.xph != null) {
        paramVarArgs.e(16, this.xph);
      }
      paramVarArgs.aO(17, this.xpi);
      paramVarArgs.aO(18, this.gwW);
      paramVarArgs.aO(19, this.gwV);
      if (this.gwX != null) {
        paramVarArgs.e(20, this.gwX);
      }
      if (this.xpk != null)
      {
        paramVarArgs.iQ(21, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      if (this.gwY != null) {
        paramVarArgs.e(22, this.gwY);
      }
      if (this.gwZ != null) {
        paramVarArgs.e(23, this.gwZ);
      }
      if (this.xpl != null)
      {
        paramVarArgs.iQ(24, this.xpl.computeSize());
        this.xpl.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(25, this.xaS);
      paramVarArgs.e(26, 8, this.xaT);
      if (this.wJq != null) {
        paramVarArgs.e(27, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(28, this.wJr);
      }
      if (this.xKh != null)
      {
        paramVarArgs.iQ(29, this.xKh.computeSize());
        this.xKh.writeFields(paramVarArgs);
      }
      if (this.wYu != null) {
        paramVarArgs.e(30, this.wYu);
      }
      if (this.xKi != null) {
        paramVarArgs.e(31, this.xKi);
      }
      paramVarArgs.aO(32, this.xKf);
      if (this.xKj != null) {
        paramVarArgs.e(33, this.xKj);
      }
      paramVarArgs.aO(34, this.xKk);
      paramVarArgs.e(35, 8, this.xKl);
      AppMethodBeat.o(80178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3462;
      }
    }
    label3462:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wOT != null) {
        paramInt = i + e.a.a.a.iP(2, this.wOT.computeSize());
      }
      i = paramInt;
      if (this.xmi != null) {
        i = paramInt + e.a.a.a.iP(3, this.xmi.computeSize());
      }
      paramInt = i;
      if (this.wOv != null) {
        paramInt = i + e.a.a.a.iP(4, this.wOv.computeSize());
      }
      i = paramInt;
      if (this.wOw != null) {
        i = paramInt + e.a.a.a.iP(5, this.wOw.computeSize());
      }
      i += e.a.a.b.b.a.bl(6, this.gwP);
      paramInt = i;
      if (this.woT != null) {
        paramInt = i + e.a.a.a.iP(7, this.woT.computeSize());
      }
      i = paramInt;
      if (this.gwQ != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.gwQ);
      }
      paramInt = i;
      if (this.gwR != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.gwR);
      }
      i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.gwS);
      }
      i = i + e.a.a.b.b.a.bl(11, this.gwT) + e.a.a.b.b.a.bl(12, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.xpf);
      }
      i = paramInt;
      if (this.xpg != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.xpg);
      }
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.gwU);
      }
      i = paramInt;
      if (this.xph != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.xph);
      }
      i = i + e.a.a.b.b.a.bl(17, this.xpi) + e.a.a.b.b.a.bl(18, this.gwW) + e.a.a.b.b.a.bl(19, this.gwV);
      paramInt = i;
      if (this.gwX != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.gwX);
      }
      i = paramInt;
      if (this.xpk != null) {
        i = paramInt + e.a.a.a.iP(21, this.xpk.computeSize());
      }
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.gwY);
      }
      i = paramInt;
      if (this.gwZ != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.gwZ);
      }
      paramInt = i;
      if (this.xpl != null) {
        paramInt = i + e.a.a.a.iP(24, this.xpl.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(25, this.xaS) + e.a.a.a.c(26, 8, this.xaT);
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(28, this.wJr);
      }
      paramInt = i;
      if (this.xKh != null) {
        paramInt = i + e.a.a.a.iP(29, this.xKh.computeSize());
      }
      i = paramInt;
      if (this.wYu != null) {
        i = paramInt + e.a.a.b.b.a.f(30, this.wYu);
      }
      paramInt = i;
      if (this.xKi != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.xKi);
      }
      i = paramInt + e.a.a.b.b.a.bl(32, this.xKf);
      paramInt = i;
      if (this.xKj != null) {
        paramInt = i + e.a.a.b.b.a.f(33, this.xKj);
      }
      i = e.a.a.b.b.a.bl(34, this.xKk);
      int j = e.a.a.a.c(35, 8, this.xKl);
      AppMethodBeat.o(80178);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xaT.clear();
        this.xKl.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(80178);
          throw paramVarArgs;
        }
        if (this.wOT == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(80178);
          throw paramVarArgs;
        }
        if (this.xmi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(80178);
          throw paramVarArgs;
        }
        if (this.wOv == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(80178);
          throw paramVarArgs;
        }
        if (this.wOw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(80178);
          throw paramVarArgs;
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(80178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bxh localbxh = (bxh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80178);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
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
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
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
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.xmi = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
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
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.wOv = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.wOw = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
          return 0;
        case 6: 
          localbxh.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.woT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
          return 0;
        case 8: 
          localbxh.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 9: 
          localbxh.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 10: 
          localbxh.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 11: 
          localbxh.gwT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        case 12: 
          localbxh.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        case 13: 
          localbxh.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 14: 
          localbxh.xpg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 15: 
          localbxh.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 16: 
          localbxh.xph = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 17: 
          localbxh.xpi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        case 18: 
          localbxh.gwW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        case 19: 
          localbxh.gwV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        case 20: 
          localbxh.gwX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 21: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
          return 0;
        case 22: 
          localbxh.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 23: 
          localbxh.gwZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 24: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.xpl = ((wc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
          return 0;
        case 25: 
          localbxh.xaS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        case 26: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.xaT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
          return 0;
        case 27: 
          localbxh.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 28: 
          localbxh.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 29: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxh.xKh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80178);
          return 0;
        case 30: 
          localbxh.wYu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 31: 
          localbxh.xKi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 32: 
          localbxh.xKf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        case 33: 
          localbxh.xKj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80178);
          return 0;
        case 34: 
          localbxh.xKk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80178);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbxh.xKl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80178);
        return 0;
      }
      AppMethodBeat.o(80178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxh
 * JD-Core Version:    0.7.0.1
 */