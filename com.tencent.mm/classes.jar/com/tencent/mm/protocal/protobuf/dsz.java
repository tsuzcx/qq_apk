package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsz
  extends cvc
{
  public String FOH;
  public int FOI;
  public int FOJ;
  public int FOK;
  public String FOL;
  public int FYc;
  public String Fss;
  public String Fst;
  public String Fsu;
  public cwt Fvi;
  public cwt Fvj;
  public String Fvn;
  public int GAB;
  public String GJN;
  public int GVf;
  public int Ges;
  public cwt HFH;
  public String HFI;
  public String HFJ;
  public int HFK;
  public int HFL;
  public String HFM;
  public int HFN;
  public int HFO;
  public int HFP;
  public String HbB;
  public int Hqi;
  public int HvF;
  public String Md5;
  public String iht;
  public String ihw;
  public int ugm;
  public int xcK;
  public int xcL;
  public int xcM;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152719);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HFH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.Fvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HFH != null)
      {
        paramVarArgs.lC(2, this.HFH.computeSize());
        this.HFH.writeFields(paramVarArgs);
      }
      if (this.Fvi != null)
      {
        paramVarArgs.lC(3, this.Fvi.computeSize());
        this.Fvi.writeFields(paramVarArgs);
      }
      if (this.Fvj != null)
      {
        paramVarArgs.lC(4, this.Fvj.computeSize());
        this.Fvj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.xcK);
      paramVarArgs.aS(6, this.xcL);
      paramVarArgs.aS(7, this.xcM);
      if (this.xcN != null)
      {
        paramVarArgs.lC(8, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.ugm);
      if (this.Fvn != null) {
        paramVarArgs.d(10, this.Fvn);
      }
      paramVarArgs.aS(11, this.GAB);
      paramVarArgs.aS(12, this.FYc);
      paramVarArgs.aS(13, this.HvF);
      if (this.ihw != null) {
        paramVarArgs.d(14, this.ihw);
      }
      if (this.HFI != null) {
        paramVarArgs.d(15, this.HFI);
      }
      if (this.HFJ != null) {
        paramVarArgs.d(16, this.HFJ);
      }
      if (this.FOH != null) {
        paramVarArgs.d(17, this.FOH);
      }
      paramVarArgs.aS(18, this.FOI);
      paramVarArgs.aS(19, this.HFK);
      paramVarArgs.aS(20, this.HFL);
      if (this.HFM != null) {
        paramVarArgs.d(21, this.HFM);
      }
      paramVarArgs.aS(22, this.HFN);
      paramVarArgs.aS(23, this.HFO);
      paramVarArgs.aS(24, this.HFP);
      if (this.GJN != null) {
        paramVarArgs.d(25, this.GJN);
      }
      paramVarArgs.aS(26, this.Ges);
      if (this.Md5 != null) {
        paramVarArgs.d(27, this.Md5);
      }
      paramVarArgs.aS(28, this.FOJ);
      paramVarArgs.aS(29, this.FOK);
      paramVarArgs.aS(30, this.Hqi);
      if (this.iht != null) {
        paramVarArgs.d(31, this.iht);
      }
      if (this.Fsu != null) {
        paramVarArgs.d(32, this.Fsu);
      }
      if (this.Fst != null) {
        paramVarArgs.d(33, this.Fst);
      }
      if (this.Fss != null) {
        paramVarArgs.d(34, this.Fss);
      }
      if (this.FOL != null) {
        paramVarArgs.d(35, this.FOL);
      }
      paramVarArgs.aS(36, this.GVf);
      if (this.HbB != null) {
        paramVarArgs.d(37, this.HbB);
      }
      AppMethodBeat.o(152719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2794;
      }
    }
    label2794:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HFH != null) {
        paramInt = i + f.a.a.a.lB(2, this.HFH.computeSize());
      }
      i = paramInt;
      if (this.Fvi != null) {
        i = paramInt + f.a.a.a.lB(3, this.Fvi.computeSize());
      }
      paramInt = i;
      if (this.Fvj != null) {
        paramInt = i + f.a.a.a.lB(4, this.Fvj.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.xcK) + f.a.a.b.b.a.bz(6, this.xcL) + f.a.a.b.b.a.bz(7, this.xcM);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + f.a.a.a.lB(8, this.xcN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.ugm);
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Fvn);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GAB) + f.a.a.b.b.a.bz(12, this.FYc) + f.a.a.b.b.a.bz(13, this.HvF);
      paramInt = i;
      if (this.ihw != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.ihw);
      }
      i = paramInt;
      if (this.HFI != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HFI);
      }
      paramInt = i;
      if (this.HFJ != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.HFJ);
      }
      i = paramInt;
      if (this.FOH != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FOH);
      }
      i = i + f.a.a.b.b.a.bz(18, this.FOI) + f.a.a.b.b.a.bz(19, this.HFK) + f.a.a.b.b.a.bz(20, this.HFL);
      paramInt = i;
      if (this.HFM != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.HFM);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.HFN) + f.a.a.b.b.a.bz(23, this.HFO) + f.a.a.b.b.a.bz(24, this.HFP);
      paramInt = i;
      if (this.GJN != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.GJN);
      }
      i = paramInt + f.a.a.b.b.a.bz(26, this.Ges);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.Md5);
      }
      i = paramInt + f.a.a.b.b.a.bz(28, this.FOJ) + f.a.a.b.b.a.bz(29, this.FOK) + f.a.a.b.b.a.bz(30, this.Hqi);
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.iht);
      }
      i = paramInt;
      if (this.Fsu != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.Fsu);
      }
      paramInt = i;
      if (this.Fst != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.Fst);
      }
      i = paramInt;
      if (this.Fss != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.Fss);
      }
      paramInt = i;
      if (this.FOL != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.FOL);
      }
      i = paramInt + f.a.a.b.b.a.bz(36, this.GVf);
      paramInt = i;
      if (this.HbB != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.HbB);
      }
      AppMethodBeat.o(152719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HFH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.Fvi == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.Fvj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.xcN == null)
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
        dsz localdsz = (dsz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152719);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsz.HFH = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsz.Fvi = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsz.Fvj = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 5: 
          localdsz.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 6: 
          localdsz.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 7: 
          localdsz.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsz.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 9: 
          localdsz.ugm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 10: 
          localdsz.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 11: 
          localdsz.GAB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 12: 
          localdsz.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 13: 
          localdsz.HvF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 14: 
          localdsz.ihw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 15: 
          localdsz.HFI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 16: 
          localdsz.HFJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 17: 
          localdsz.FOH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 18: 
          localdsz.FOI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 19: 
          localdsz.HFK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 20: 
          localdsz.HFL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 21: 
          localdsz.HFM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 22: 
          localdsz.HFN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 23: 
          localdsz.HFO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 24: 
          localdsz.HFP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 25: 
          localdsz.GJN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 26: 
          localdsz.Ges = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 27: 
          localdsz.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 28: 
          localdsz.FOJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 29: 
          localdsz.FOK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 30: 
          localdsz.Hqi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        case 31: 
          localdsz.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 32: 
          localdsz.Fsu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 33: 
          localdsz.Fst = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 34: 
          localdsz.Fss = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 35: 
          localdsz.FOL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 36: 
          localdsz.GVf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152719);
          return 0;
        }
        localdsz.HbB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152719);
        return 0;
      }
      AppMethodBeat.o(152719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsz
 * JD-Core Version:    0.7.0.1
 */