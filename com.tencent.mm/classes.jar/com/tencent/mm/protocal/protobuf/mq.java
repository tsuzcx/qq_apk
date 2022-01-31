package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mq
  extends bvk
{
  public String cwk;
  public int koj;
  public String kok;
  public int qjU = 0;
  public String qjV;
  public String qjW;
  public String qjX;
  public String qjY;
  public int wBA;
  public int wBB;
  public mj wBC;
  public String wBa;
  public String wBm;
  public ccm wBn;
  public String wBo;
  public String wBp;
  public int wBq;
  public int wBr;
  public int wBs;
  public ckm wBt;
  public String wBu;
  public int wBv;
  public int wBw;
  public int wBx;
  public com.tencent.mm.bv.b wBy;
  public int wBz;
  public String wpp;
  public String wpq;
  public String wpr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56725);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56725);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      if (this.cwk != null) {
        paramVarArgs.e(4, this.cwk);
      }
      if (this.wBm != null) {
        paramVarArgs.e(5, this.wBm);
      }
      if (this.wBn != null)
      {
        paramVarArgs.iQ(6, this.wBn.computeSize());
        this.wBn.writeFields(paramVarArgs);
      }
      if (this.wpp != null) {
        paramVarArgs.e(7, this.wpp);
      }
      if (this.wpr != null) {
        paramVarArgs.e(8, this.wpr);
      }
      if (this.wBo != null) {
        paramVarArgs.e(9, this.wBo);
      }
      if (this.wBp != null) {
        paramVarArgs.e(10, this.wBp);
      }
      paramVarArgs.aO(11, this.wBq);
      if (this.wpq != null) {
        paramVarArgs.e(12, this.wpq);
      }
      if (this.wBa != null) {
        paramVarArgs.e(13, this.wBa);
      }
      paramVarArgs.aO(14, this.wBr);
      paramVarArgs.aO(15, this.wBs);
      if (this.wBt != null)
      {
        paramVarArgs.iQ(16, this.wBt.computeSize());
        this.wBt.writeFields(paramVarArgs);
      }
      if (this.wBu != null) {
        paramVarArgs.e(17, this.wBu);
      }
      paramVarArgs.aO(18, this.wBv);
      paramVarArgs.aO(19, this.wBw);
      paramVarArgs.aO(20, this.wBx);
      if (this.wBy != null) {
        paramVarArgs.c(21, this.wBy);
      }
      paramVarArgs.aO(22, this.wBz);
      paramVarArgs.aO(23, this.qjU);
      if (this.qjV != null) {
        paramVarArgs.e(24, this.qjV);
      }
      if (this.qjW != null) {
        paramVarArgs.e(25, this.qjW);
      }
      paramVarArgs.aO(26, this.wBA);
      if (this.qjX != null) {
        paramVarArgs.e(27, this.qjX);
      }
      if (this.qjY != null) {
        paramVarArgs.e(28, this.qjY);
      }
      paramVarArgs.aO(29, this.wBB);
      if (this.wBC != null)
      {
        paramVarArgs.iQ(30, this.wBC.computeSize());
        this.wBC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2246;
      }
    }
    label2246:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.cwk != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.cwk);
      }
      paramInt = i;
      if (this.wBm != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wBm);
      }
      i = paramInt;
      if (this.wBn != null) {
        i = paramInt + e.a.a.a.iP(6, this.wBn.computeSize());
      }
      paramInt = i;
      if (this.wpp != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wpp);
      }
      i = paramInt;
      if (this.wpr != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wpr);
      }
      paramInt = i;
      if (this.wBo != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wBo);
      }
      i = paramInt;
      if (this.wBp != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wBp);
      }
      i += e.a.a.b.b.a.bl(11, this.wBq);
      paramInt = i;
      if (this.wpq != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wpq);
      }
      i = paramInt;
      if (this.wBa != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.wBa);
      }
      i = i + e.a.a.b.b.a.bl(14, this.wBr) + e.a.a.b.b.a.bl(15, this.wBs);
      paramInt = i;
      if (this.wBt != null) {
        paramInt = i + e.a.a.a.iP(16, this.wBt.computeSize());
      }
      i = paramInt;
      if (this.wBu != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.wBu);
      }
      i = i + e.a.a.b.b.a.bl(18, this.wBv) + e.a.a.b.b.a.bl(19, this.wBw) + e.a.a.b.b.a.bl(20, this.wBx);
      paramInt = i;
      if (this.wBy != null) {
        paramInt = i + e.a.a.b.b.a.b(21, this.wBy);
      }
      i = paramInt + e.a.a.b.b.a.bl(22, this.wBz) + e.a.a.b.b.a.bl(23, this.qjU);
      paramInt = i;
      if (this.qjV != null) {
        paramInt = i + e.a.a.b.b.a.f(24, this.qjV);
      }
      i = paramInt;
      if (this.qjW != null) {
        i = paramInt + e.a.a.b.b.a.f(25, this.qjW);
      }
      i += e.a.a.b.b.a.bl(26, this.wBA);
      paramInt = i;
      if (this.qjX != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.qjX);
      }
      i = paramInt;
      if (this.qjY != null) {
        i = paramInt + e.a.a.b.b.a.f(28, this.qjY);
      }
      i += e.a.a.b.b.a.bl(29, this.wBB);
      paramInt = i;
      if (this.wBC != null) {
        paramInt = i + e.a.a.a.iP(30, this.wBC.computeSize());
      }
      AppMethodBeat.o(56725);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56725);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        mq localmq = (mq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56725);
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
            localmq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56725);
          return 0;
        case 2: 
          localmq.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 3: 
          localmq.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 4: 
          localmq.cwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 5: 
          localmq.wBm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localmq.wBn = ((ccm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56725);
          return 0;
        case 7: 
          localmq.wpp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 8: 
          localmq.wpr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 9: 
          localmq.wBo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 10: 
          localmq.wBp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 11: 
          localmq.wBq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 12: 
          localmq.wpq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 13: 
          localmq.wBa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 14: 
          localmq.wBr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 15: 
          localmq.wBs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 16: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localmq.wBt = ((ckm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56725);
          return 0;
        case 17: 
          localmq.wBu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 18: 
          localmq.wBv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 19: 
          localmq.wBw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 20: 
          localmq.wBx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 21: 
          localmq.wBy = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(56725);
          return 0;
        case 22: 
          localmq.wBz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 23: 
          localmq.qjU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 24: 
          localmq.qjV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 25: 
          localmq.qjW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 26: 
          localmq.wBA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        case 27: 
          localmq.qjX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 28: 
          localmq.qjY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56725);
          return 0;
        case 29: 
          localmq.wBB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56725);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localmq.wBC = ((mj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56725);
        return 0;
      }
      AppMethodBeat.o(56725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mq
 * JD-Core Version:    0.7.0.1
 */