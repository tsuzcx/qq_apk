package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bte
  extends cpx
{
  public int DLC;
  public iq DUl;
  public String DUm;
  public int DUn;
  public String DUo;
  public String DUp;
  public SKBuiltinBuffer_t DUq;
  public SKBuiltinBuffer_t DUr;
  public String EKT;
  public String Ews;
  public String Fii;
  public String Fij;
  public String Fik;
  public int Fil;
  public String fZq;
  public String fZr;
  public int fZy;
  public String iJW;
  public String ncV;
  public String pAC;
  public String pAD;
  public String tCb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133176);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DUl != null)
      {
        paramVarArgs.ln(2, this.DUl.computeSize());
        this.DUl.writeFields(paramVarArgs);
      }
      if (this.tCb != null) {
        paramVarArgs.d(3, this.tCb);
      }
      if (this.DUm != null) {
        paramVarArgs.d(4, this.DUm);
      }
      paramVarArgs.aR(5, this.DUn);
      if (this.DUo != null) {
        paramVarArgs.d(6, this.DUo);
      }
      if (this.iJW != null) {
        paramVarArgs.d(7, this.iJW);
      }
      if (this.ncV != null) {
        paramVarArgs.d(8, this.ncV);
      }
      if (this.DUp != null) {
        paramVarArgs.d(9, this.DUp);
      }
      if (this.pAD != null) {
        paramVarArgs.d(10, this.pAD);
      }
      if (this.pAC != null) {
        paramVarArgs.d(11, this.pAC);
      }
      paramVarArgs.aR(13, this.DLC);
      paramVarArgs.aR(14, this.fZy);
      if (this.fZr != null) {
        paramVarArgs.d(15, this.fZr);
      }
      if (this.fZq != null) {
        paramVarArgs.d(16, this.fZq);
      }
      if (this.Fii != null) {
        paramVarArgs.d(17, this.Fii);
      }
      if (this.Ews != null) {
        paramVarArgs.d(18, this.Ews);
      }
      if (this.EKT != null) {
        paramVarArgs.d(19, this.EKT);
      }
      if (this.Fij != null) {
        paramVarArgs.d(20, this.Fij);
      }
      if (this.Fik != null) {
        paramVarArgs.d(21, this.Fik);
      }
      paramVarArgs.aR(22, this.Fil);
      if (this.DUq != null)
      {
        paramVarArgs.ln(23, this.DUq.computeSize());
        this.DUq.writeFields(paramVarArgs);
      }
      if (this.DUr != null)
      {
        paramVarArgs.ln(24, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133176);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1886;
      }
    }
    label1886:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DUl != null) {
        paramInt = i + f.a.a.a.lm(2, this.DUl.computeSize());
      }
      i = paramInt;
      if (this.tCb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tCb);
      }
      paramInt = i;
      if (this.DUm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DUm);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DUn);
      paramInt = i;
      if (this.DUo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DUo);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.iJW);
      }
      paramInt = i;
      if (this.ncV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ncV);
      }
      i = paramInt;
      if (this.DUp != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DUp);
      }
      paramInt = i;
      if (this.pAD != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.pAD);
      }
      i = paramInt;
      if (this.pAC != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.pAC);
      }
      i = i + f.a.a.b.b.a.bx(13, this.DLC) + f.a.a.b.b.a.bx(14, this.fZy);
      paramInt = i;
      if (this.fZr != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.fZr);
      }
      i = paramInt;
      if (this.fZq != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.fZq);
      }
      paramInt = i;
      if (this.Fii != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Fii);
      }
      i = paramInt;
      if (this.Ews != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Ews);
      }
      paramInt = i;
      if (this.EKT != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.EKT);
      }
      i = paramInt;
      if (this.Fij != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Fij);
      }
      paramInt = i;
      if (this.Fik != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Fik);
      }
      i = paramInt + f.a.a.b.b.a.bx(22, this.Fil);
      paramInt = i;
      if (this.DUq != null) {
        paramInt = i + f.a.a.a.lm(23, this.DUq.computeSize());
      }
      i = paramInt;
      if (this.DUr != null) {
        i = paramInt + f.a.a.a.lm(24, this.DUr.computeSize());
      }
      AppMethodBeat.o(133176);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bte localbte = (bte)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 12: 
        default: 
          AppMethodBeat.o(133176);
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
            localbte.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbte.DUl = ((iq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 3: 
          localbte.tCb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 4: 
          localbte.DUm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 5: 
          localbte.DUn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133176);
          return 0;
        case 6: 
          localbte.DUo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 7: 
          localbte.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 8: 
          localbte.ncV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 9: 
          localbte.DUp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 10: 
          localbte.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 11: 
          localbte.pAC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 13: 
          localbte.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133176);
          return 0;
        case 14: 
          localbte.fZy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133176);
          return 0;
        case 15: 
          localbte.fZr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 16: 
          localbte.fZq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 17: 
          localbte.Fii = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 18: 
          localbte.Ews = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 19: 
          localbte.EKT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 20: 
          localbte.Fij = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 21: 
          localbte.Fik = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 22: 
          localbte.Fil = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133176);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbte.DUq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbte.DUr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      AppMethodBeat.o(133176);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bte
 * JD-Core Version:    0.7.0.1
 */