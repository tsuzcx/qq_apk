package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dnq
  extends cpx
{
  public String DPY;
  public String DRb;
  public int Ebf;
  public String EhA;
  public int EhB;
  public int EhC;
  public int EhD;
  public String EhE;
  public int EvT;
  public int EwP;
  public int FFJ;
  public int FHv;
  public int FUZ;
  public int FVa;
  public int FVb;
  public int FVh;
  public int FVi;
  public SKBuiltinBuffer_t FVj;
  public String FVk;
  public int FVl;
  public String FVm;
  public String FVn;
  public int FVo;
  public String FVp;
  public String FVq;
  public String FVr;
  public String FVs;
  public String FVt;
  public String FVu;
  public String FVv;
  public String FVw;
  public String Fam;
  public String Fao;
  public int FiE;
  public int FiF;
  public SKBuiltinBuffer_t FiG;
  public int FiH;
  public int sVo;
  public String tlJ;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127180);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FiG == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.FVj == null)
      {
        paramVarArgs = new b("Not all required fields were included: VideoData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DRb != null) {
        paramVarArgs.d(2, this.DRb);
      }
      if (this.tlK != null) {
        paramVarArgs.d(3, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(4, this.tlJ);
      }
      paramVarArgs.aR(5, this.FiE);
      paramVarArgs.aR(6, this.FiF);
      if (this.FiG != null)
      {
        paramVarArgs.ln(7, this.FiG.computeSize());
        this.FiG.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.FVh);
      paramVarArgs.aR(9, this.FVi);
      if (this.FVj != null)
      {
        paramVarArgs.ln(10, this.FVj.computeSize());
        this.FVj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.FHv);
      paramVarArgs.aR(12, this.EvT);
      paramVarArgs.aR(13, this.FiH);
      paramVarArgs.aR(14, this.Ebf);
      if (this.DPY != null) {
        paramVarArgs.d(15, this.DPY);
      }
      if (this.FVk != null) {
        paramVarArgs.d(16, this.FVk);
      }
      if (this.EhA != null) {
        paramVarArgs.d(17, this.EhA);
      }
      paramVarArgs.aR(18, this.EhB);
      if (this.Fam != null) {
        paramVarArgs.d(19, this.Fam);
      }
      paramVarArgs.aR(20, this.FUZ);
      paramVarArgs.aR(21, this.FVa);
      paramVarArgs.aR(22, this.FVb);
      if (this.Fao != null) {
        paramVarArgs.d(23, this.Fao);
      }
      paramVarArgs.aR(24, this.FVl);
      paramVarArgs.aR(25, this.EwP);
      if (this.FVm != null) {
        paramVarArgs.d(26, this.FVm);
      }
      if (this.FVn != null) {
        paramVarArgs.d(27, this.FVn);
      }
      paramVarArgs.aR(28, this.FVo);
      if (this.FVp != null) {
        paramVarArgs.d(29, this.FVp);
      }
      if (this.FVq != null) {
        paramVarArgs.d(30, this.FVq);
      }
      if (this.FVr != null) {
        paramVarArgs.d(31, this.FVr);
      }
      if (this.FVs != null) {
        paramVarArgs.d(32, this.FVs);
      }
      if (this.FVt != null) {
        paramVarArgs.d(33, this.FVt);
      }
      if (this.FVu != null) {
        paramVarArgs.d(34, this.FVu);
      }
      if (this.FVv != null) {
        paramVarArgs.d(35, this.FVv);
      }
      paramVarArgs.aR(36, this.FFJ);
      if (this.FVw != null) {
        paramVarArgs.d(37, this.FVw);
      }
      paramVarArgs.aR(38, this.EhC);
      paramVarArgs.aR(39, this.EhD);
      paramVarArgs.aR(40, this.sVo);
      if (this.EhE != null) {
        paramVarArgs.d(41, this.EhE);
      }
      AppMethodBeat.o(127180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2742;
      }
    }
    label2742:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DRb);
      }
      i = paramInt;
      if (this.tlK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlK);
      }
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tlJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FiE) + f.a.a.b.b.a.bx(6, this.FiF);
      paramInt = i;
      if (this.FiG != null) {
        paramInt = i + f.a.a.a.lm(7, this.FiG.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FVh) + f.a.a.b.b.a.bx(9, this.FVi);
      paramInt = i;
      if (this.FVj != null) {
        paramInt = i + f.a.a.a.lm(10, this.FVj.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.FHv) + f.a.a.b.b.a.bx(12, this.EvT) + f.a.a.b.b.a.bx(13, this.FiH) + f.a.a.b.b.a.bx(14, this.Ebf);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.DPY);
      }
      i = paramInt;
      if (this.FVk != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.FVk);
      }
      paramInt = i;
      if (this.EhA != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EhA);
      }
      i = paramInt + f.a.a.b.b.a.bx(18, this.EhB);
      paramInt = i;
      if (this.Fam != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Fam);
      }
      i = paramInt + f.a.a.b.b.a.bx(20, this.FUZ) + f.a.a.b.b.a.bx(21, this.FVa) + f.a.a.b.b.a.bx(22, this.FVb);
      paramInt = i;
      if (this.Fao != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Fao);
      }
      i = paramInt + f.a.a.b.b.a.bx(24, this.FVl) + f.a.a.b.b.a.bx(25, this.EwP);
      paramInt = i;
      if (this.FVm != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.FVm);
      }
      i = paramInt;
      if (this.FVn != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.FVn);
      }
      i += f.a.a.b.b.a.bx(28, this.FVo);
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.FVp);
      }
      i = paramInt;
      if (this.FVq != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.FVq);
      }
      paramInt = i;
      if (this.FVr != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.FVr);
      }
      i = paramInt;
      if (this.FVs != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.FVs);
      }
      paramInt = i;
      if (this.FVt != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.FVt);
      }
      i = paramInt;
      if (this.FVu != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.FVu);
      }
      paramInt = i;
      if (this.FVv != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.FVv);
      }
      i = paramInt + f.a.a.b.b.a.bx(36, this.FFJ);
      paramInt = i;
      if (this.FVw != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.FVw);
      }
      i = paramInt + f.a.a.b.b.a.bx(38, this.EhC) + f.a.a.b.b.a.bx(39, this.EhD) + f.a.a.b.b.a.bx(40, this.sVo);
      paramInt = i;
      if (this.EhE != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.EhE);
      }
      AppMethodBeat.o(127180);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FiG == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        if (this.FVj == null)
        {
          paramVarArgs = new b("Not all required fields were included: VideoData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dnq localdnq = (dnq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127180);
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
            localdnq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 2: 
          localdnq.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 3: 
          localdnq.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 4: 
          localdnq.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 5: 
          localdnq.FiE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 6: 
          localdnq.FiF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnq.FiG = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 8: 
          localdnq.FVh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 9: 
          localdnq.FVi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdnq.FVj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 11: 
          localdnq.FHv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 12: 
          localdnq.EvT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 13: 
          localdnq.FiH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 14: 
          localdnq.Ebf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 15: 
          localdnq.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 16: 
          localdnq.FVk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 17: 
          localdnq.EhA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 18: 
          localdnq.EhB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 19: 
          localdnq.Fam = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 20: 
          localdnq.FUZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 21: 
          localdnq.FVa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 22: 
          localdnq.FVb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 23: 
          localdnq.Fao = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 24: 
          localdnq.FVl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 25: 
          localdnq.EwP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 26: 
          localdnq.FVm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 27: 
          localdnq.FVn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 28: 
          localdnq.FVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 29: 
          localdnq.FVp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 30: 
          localdnq.FVq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 31: 
          localdnq.FVr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 32: 
          localdnq.FVs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 33: 
          localdnq.FVt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 34: 
          localdnq.FVu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 35: 
          localdnq.FVv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 36: 
          localdnq.FFJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 37: 
          localdnq.FVw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 38: 
          localdnq.EhC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 39: 
          localdnq.EhD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        case 40: 
          localdnq.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127180);
          return 0;
        }
        localdnq.EhE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127180);
        return 0;
      }
      AppMethodBeat.o(127180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnq
 * JD-Core Version:    0.7.0.1
 */