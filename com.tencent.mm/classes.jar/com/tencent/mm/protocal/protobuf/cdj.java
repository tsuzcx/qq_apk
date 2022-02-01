package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdj
  extends cwj
{
  public String FJg;
  public String FKE;
  public int FKH;
  public String FKK;
  public String FKL;
  public int FKM;
  public String FKN;
  public dfb FRC;
  public int FRH;
  public String FRz;
  public rz FWY;
  public rz FWZ;
  public bpj FWx;
  public px FWy;
  public ccw FWz;
  public rz FXa;
  public String GWZ;
  public SKBuiltinBuffer_t GXc;
  public String Hqe;
  public int Hqf;
  public String Hqg;
  public int Hqh;
  public clo Hqi;
  public int Hqj;
  public String Hqk;
  public String Hql;
  public czw Hqm;
  public String nIJ;
  public int nJb;
  public int qkC;
  public String qkE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133185);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qkC);
      if (this.FJg != null) {
        paramVarArgs.d(3, this.FJg);
      }
      if (this.FKK != null) {
        paramVarArgs.d(4, this.FKK);
      }
      if (this.FKL != null) {
        paramVarArgs.d(5, this.FKL);
      }
      if (this.Hqe != null) {
        paramVarArgs.d(6, this.Hqe);
      }
      if (this.FKE != null) {
        paramVarArgs.d(7, this.FKE);
      }
      paramVarArgs.aS(8, this.FKM);
      paramVarArgs.aS(9, this.Hqf);
      if (this.Hqg != null) {
        paramVarArgs.d(10, this.Hqg);
      }
      if (this.FWy != null)
      {
        paramVarArgs.lJ(14, this.FWy.computeSize());
        this.FWy.writeFields(paramVarArgs);
      }
      if (this.FKN != null) {
        paramVarArgs.d(15, this.FKN);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(16, this.nIJ);
      }
      paramVarArgs.aS(17, this.nJb);
      if (this.FWz != null)
      {
        paramVarArgs.lJ(18, this.FWz.computeSize());
        this.FWz.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(19, this.Hqh);
      paramVarArgs.aS(20, this.FKH);
      if (this.FRz != null) {
        paramVarArgs.d(21, this.FRz);
      }
      if (this.Hqi != null)
      {
        paramVarArgs.lJ(22, this.Hqi.computeSize());
        this.Hqi.writeFields(paramVarArgs);
      }
      if (this.qkE != null) {
        paramVarArgs.d(23, this.qkE);
      }
      paramVarArgs.aS(24, this.Hqj);
      if (this.FWx != null)
      {
        paramVarArgs.lJ(25, this.FWx.computeSize());
        this.FWx.writeFields(paramVarArgs);
      }
      if (this.Hqk != null) {
        paramVarArgs.d(26, this.Hqk);
      }
      if (this.FWY != null)
      {
        paramVarArgs.lJ(27, this.FWY.computeSize());
        this.FWY.writeFields(paramVarArgs);
      }
      if (this.Hql != null) {
        paramVarArgs.d(28, this.Hql);
      }
      if (this.GWZ != null) {
        paramVarArgs.d(29, this.GWZ);
      }
      if (this.GXc != null)
      {
        paramVarArgs.lJ(30, this.GXc.computeSize());
        this.GXc.writeFields(paramVarArgs);
      }
      if (this.FRC != null)
      {
        paramVarArgs.lJ(31, this.FRC.computeSize());
        this.FRC.writeFields(paramVarArgs);
      }
      if (this.FWZ != null)
      {
        paramVarArgs.lJ(32, this.FWZ.computeSize());
        this.FWZ.writeFields(paramVarArgs);
      }
      if (this.FXa != null)
      {
        paramVarArgs.lJ(33, this.FXa.computeSize());
        this.FXa.writeFields(paramVarArgs);
      }
      if (this.Hqm != null)
      {
        paramVarArgs.lJ(34, this.Hqm.computeSize());
        this.Hqm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(35, this.FRH);
      AppMethodBeat.o(133185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3094;
      }
    }
    label3094:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qkC);
      paramInt = i;
      if (this.FJg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FJg);
      }
      i = paramInt;
      if (this.FKK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FKK);
      }
      paramInt = i;
      if (this.FKL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FKL);
      }
      i = paramInt;
      if (this.Hqe != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hqe);
      }
      paramInt = i;
      if (this.FKE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FKE);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FKM) + f.a.a.b.b.a.bz(9, this.Hqf);
      paramInt = i;
      if (this.Hqg != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hqg);
      }
      i = paramInt;
      if (this.FWy != null) {
        i = paramInt + f.a.a.a.lI(14, this.FWy.computeSize());
      }
      paramInt = i;
      if (this.FKN != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FKN);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(17, this.nJb);
      paramInt = i;
      if (this.FWz != null) {
        paramInt = i + f.a.a.a.lI(18, this.FWz.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.Hqh) + f.a.a.b.b.a.bz(20, this.FKH);
      paramInt = i;
      if (this.FRz != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FRz);
      }
      i = paramInt;
      if (this.Hqi != null) {
        i = paramInt + f.a.a.a.lI(22, this.Hqi.computeSize());
      }
      paramInt = i;
      if (this.qkE != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.qkE);
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.Hqj);
      paramInt = i;
      if (this.FWx != null) {
        paramInt = i + f.a.a.a.lI(25, this.FWx.computeSize());
      }
      i = paramInt;
      if (this.Hqk != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.Hqk);
      }
      paramInt = i;
      if (this.FWY != null) {
        paramInt = i + f.a.a.a.lI(27, this.FWY.computeSize());
      }
      i = paramInt;
      if (this.Hql != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.Hql);
      }
      paramInt = i;
      if (this.GWZ != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.GWZ);
      }
      i = paramInt;
      if (this.GXc != null) {
        i = paramInt + f.a.a.a.lI(30, this.GXc.computeSize());
      }
      paramInt = i;
      if (this.FRC != null) {
        paramInt = i + f.a.a.a.lI(31, this.FRC.computeSize());
      }
      i = paramInt;
      if (this.FWZ != null) {
        i = paramInt + f.a.a.a.lI(32, this.FWZ.computeSize());
      }
      paramInt = i;
      if (this.FXa != null) {
        paramInt = i + f.a.a.a.lI(33, this.FXa.computeSize());
      }
      i = paramInt;
      if (this.Hqm != null) {
        i = paramInt + f.a.a.a.lI(34, this.Hqm.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(35, this.FRH);
      AppMethodBeat.o(133185);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133185);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdj localcdj = (cdj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(133185);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 2: 
          localcdj.qkC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 3: 
          localcdj.FJg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 4: 
          localcdj.FKK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 5: 
          localcdj.FKL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 6: 
          localcdj.Hqe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 7: 
          localcdj.FKE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 8: 
          localcdj.FKM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 9: 
          localcdj.Hqf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 10: 
          localcdj.Hqg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new px();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.FWy = ((px)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 15: 
          localcdj.FKN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 16: 
          localcdj.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 17: 
          localcdj.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.FWz = ((ccw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 19: 
          localcdj.Hqh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 20: 
          localcdj.FKH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 21: 
          localcdj.FRz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.Hqi = ((clo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 23: 
          localcdj.qkE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 24: 
          localcdj.Hqj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133185);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.FWx = ((bpj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 26: 
          localcdj.Hqk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.FWY = ((rz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 28: 
          localcdj.Hql = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 29: 
          localcdj.GWZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.GXc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.FRC = ((dfb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.FWZ = ((rz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.FXa = ((rz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdj.Hqm = ((czw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        }
        localcdj.FRH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133185);
        return 0;
      }
      AppMethodBeat.o(133185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdj
 * JD-Core Version:    0.7.0.1
 */