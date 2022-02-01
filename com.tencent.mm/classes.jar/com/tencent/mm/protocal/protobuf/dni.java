package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dni
  extends cpx
{
  public String DNn;
  public String DNo;
  public String DNp;
  public crm DPT;
  public crm DPU;
  public String DPY;
  public int ERj;
  public String EhA;
  public int EhB;
  public int EhC;
  public int EhD;
  public String EhE;
  public int EqS;
  public int EwP;
  public int FFJ;
  public int FKX;
  public crm FUT;
  public String FUU;
  public String FUV;
  public int FUW;
  public int FUX;
  public String FUY;
  public int FUZ;
  public int FVa;
  public int FVb;
  public String Fao;
  public int Flw;
  public String Md5;
  public String hOf;
  public String hOi;
  public int tit;
  public int vTH;
  public int vTI;
  public int vTJ;
  public SKBuiltinBuffer_t vTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.DPT == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.DPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FUT != null)
      {
        paramVarArgs.ln(2, this.FUT.computeSize());
        this.FUT.writeFields(paramVarArgs);
      }
      if (this.DPT != null)
      {
        paramVarArgs.ln(3, this.DPT.computeSize());
        this.DPT.writeFields(paramVarArgs);
      }
      if (this.DPU != null)
      {
        paramVarArgs.ln(4, this.DPU.computeSize());
        this.DPU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.vTH);
      paramVarArgs.aR(6, this.vTI);
      paramVarArgs.aR(7, this.vTJ);
      if (this.vTK != null)
      {
        paramVarArgs.ln(8, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.tit);
      if (this.DPY != null) {
        paramVarArgs.d(10, this.DPY);
      }
      paramVarArgs.aR(11, this.ERj);
      paramVarArgs.aR(12, this.EqS);
      paramVarArgs.aR(13, this.FKX);
      if (this.hOi != null) {
        paramVarArgs.d(14, this.hOi);
      }
      if (this.FUU != null) {
        paramVarArgs.d(15, this.FUU);
      }
      if (this.FUV != null) {
        paramVarArgs.d(16, this.FUV);
      }
      if (this.EhA != null) {
        paramVarArgs.d(17, this.EhA);
      }
      paramVarArgs.aR(18, this.EhB);
      paramVarArgs.aR(19, this.FUW);
      paramVarArgs.aR(20, this.FUX);
      if (this.FUY != null) {
        paramVarArgs.d(21, this.FUY);
      }
      paramVarArgs.aR(22, this.FUZ);
      paramVarArgs.aR(23, this.FVa);
      paramVarArgs.aR(24, this.FVb);
      if (this.Fao != null) {
        paramVarArgs.d(25, this.Fao);
      }
      paramVarArgs.aR(26, this.EwP);
      if (this.Md5 != null) {
        paramVarArgs.d(27, this.Md5);
      }
      paramVarArgs.aR(28, this.EhC);
      paramVarArgs.aR(29, this.EhD);
      paramVarArgs.aR(30, this.FFJ);
      if (this.hOf != null) {
        paramVarArgs.d(31, this.hOf);
      }
      if (this.DNp != null) {
        paramVarArgs.d(32, this.DNp);
      }
      if (this.DNo != null) {
        paramVarArgs.d(33, this.DNo);
      }
      if (this.DNn != null) {
        paramVarArgs.d(34, this.DNn);
      }
      if (this.EhE != null) {
        paramVarArgs.d(35, this.EhE);
      }
      paramVarArgs.aR(36, this.Flw);
      AppMethodBeat.o(152719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2734;
      }
    }
    label2734:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FUT != null) {
        paramInt = i + f.a.a.a.lm(2, this.FUT.computeSize());
      }
      i = paramInt;
      if (this.DPT != null) {
        i = paramInt + f.a.a.a.lm(3, this.DPT.computeSize());
      }
      paramInt = i;
      if (this.DPU != null) {
        paramInt = i + f.a.a.a.lm(4, this.DPU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.vTH) + f.a.a.b.b.a.bx(6, this.vTI) + f.a.a.b.b.a.bx(7, this.vTJ);
      paramInt = i;
      if (this.vTK != null) {
        paramInt = i + f.a.a.a.lm(8, this.vTK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.tit);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DPY);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.ERj) + f.a.a.b.b.a.bx(12, this.EqS) + f.a.a.b.b.a.bx(13, this.FKX);
      paramInt = i;
      if (this.hOi != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.hOi);
      }
      i = paramInt;
      if (this.FUU != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.FUU);
      }
      paramInt = i;
      if (this.FUV != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FUV);
      }
      i = paramInt;
      if (this.EhA != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.EhA);
      }
      i = i + f.a.a.b.b.a.bx(18, this.EhB) + f.a.a.b.b.a.bx(19, this.FUW) + f.a.a.b.b.a.bx(20, this.FUX);
      paramInt = i;
      if (this.FUY != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FUY);
      }
      i = paramInt + f.a.a.b.b.a.bx(22, this.FUZ) + f.a.a.b.b.a.bx(23, this.FVa) + f.a.a.b.b.a.bx(24, this.FVb);
      paramInt = i;
      if (this.Fao != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.Fao);
      }
      i = paramInt + f.a.a.b.b.a.bx(26, this.EwP);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.Md5);
      }
      i = paramInt + f.a.a.b.b.a.bx(28, this.EhC) + f.a.a.b.b.a.bx(29, this.EhD) + f.a.a.b.b.a.bx(30, this.FFJ);
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.hOf);
      }
      i = paramInt;
      if (this.DNp != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.DNp);
      }
      paramInt = i;
      if (this.DNo != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.DNo);
      }
      i = paramInt;
      if (this.DNn != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.DNn);
      }
      paramInt = i;
      if (this.EhE != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.EhE);
      }
      i = f.a.a.b.b.a.bx(36, this.Flw);
      AppMethodBeat.o(152719);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FUT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.DPT == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.DPU == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dni localdni = (dni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152719);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdni.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdni.FUT = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdni.DPT = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdni.DPU = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 5: 
          localdni.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 6: 
          localdni.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 7: 
          localdni.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdni.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 9: 
          localdni.tit = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 10: 
          localdni.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 11: 
          localdni.ERj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 12: 
          localdni.EqS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 13: 
          localdni.FKX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 14: 
          localdni.hOi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 15: 
          localdni.FUU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 16: 
          localdni.FUV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 17: 
          localdni.EhA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 18: 
          localdni.EhB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 19: 
          localdni.FUW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 20: 
          localdni.FUX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 21: 
          localdni.FUY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 22: 
          localdni.FUZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 23: 
          localdni.FVa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 24: 
          localdni.FVb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 25: 
          localdni.Fao = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 26: 
          localdni.EwP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 27: 
          localdni.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 28: 
          localdni.EhC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 29: 
          localdni.EhD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 30: 
          localdni.FFJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152719);
          return 0;
        case 31: 
          localdni.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 32: 
          localdni.DNp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 33: 
          localdni.DNo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 34: 
          localdni.DNn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 35: 
          localdni.EhE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152719);
          return 0;
        }
        localdni.Flw = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152719);
        return 0;
      }
      AppMethodBeat.o(152719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dni
 * JD-Core Version:    0.7.0.1
 */