package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class due
  extends cvw
{
  public String FNL;
  public String FOR;
  public int FZk;
  public String Ghg;
  public int Ghh;
  public int Ghi;
  public int Ghj;
  public String Ghk;
  public int GvW;
  public int GwZ;
  public int HJK;
  public int HLF;
  public int HZA;
  public int HZB;
  public int HZC;
  public int HZI;
  public int HZJ;
  public SKBuiltinBuffer_t HZK;
  public String HZL;
  public int HZM;
  public String HZN;
  public String HZO;
  public int HZP;
  public String HZQ;
  public String HZR;
  public String HZS;
  public String HZT;
  public String HZU;
  public String HZV;
  public String HZW;
  public String HZX;
  public String Hdm;
  public String Hdo;
  public int HlG;
  public int HlH;
  public SKBuiltinBuffer_t HlI;
  public int HlJ;
  public int ucK;
  public String uvF;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127180);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HlI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.HZK == null)
      {
        paramVarArgs = new b("Not all required fields were included: VideoData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FOR != null) {
        paramVarArgs.d(2, this.FOR);
      }
      if (this.uvG != null) {
        paramVarArgs.d(3, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(4, this.uvF);
      }
      paramVarArgs.aS(5, this.HlG);
      paramVarArgs.aS(6, this.HlH);
      if (this.HlI != null)
      {
        paramVarArgs.lJ(7, this.HlI.computeSize());
        this.HlI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.HZI);
      paramVarArgs.aS(9, this.HZJ);
      if (this.HZK != null)
      {
        paramVarArgs.lJ(10, this.HZK.computeSize());
        this.HZK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.HLF);
      paramVarArgs.aS(12, this.GvW);
      paramVarArgs.aS(13, this.HlJ);
      paramVarArgs.aS(14, this.FZk);
      if (this.FNL != null) {
        paramVarArgs.d(15, this.FNL);
      }
      if (this.HZL != null) {
        paramVarArgs.d(16, this.HZL);
      }
      if (this.Ghg != null) {
        paramVarArgs.d(17, this.Ghg);
      }
      paramVarArgs.aS(18, this.Ghh);
      if (this.Hdm != null) {
        paramVarArgs.d(19, this.Hdm);
      }
      paramVarArgs.aS(20, this.HZA);
      paramVarArgs.aS(21, this.HZB);
      paramVarArgs.aS(22, this.HZC);
      if (this.Hdo != null) {
        paramVarArgs.d(23, this.Hdo);
      }
      paramVarArgs.aS(24, this.HZM);
      paramVarArgs.aS(25, this.GwZ);
      if (this.HZN != null) {
        paramVarArgs.d(26, this.HZN);
      }
      if (this.HZO != null) {
        paramVarArgs.d(27, this.HZO);
      }
      paramVarArgs.aS(28, this.HZP);
      if (this.HZQ != null) {
        paramVarArgs.d(29, this.HZQ);
      }
      if (this.HZR != null) {
        paramVarArgs.d(30, this.HZR);
      }
      if (this.HZS != null) {
        paramVarArgs.d(31, this.HZS);
      }
      if (this.HZT != null) {
        paramVarArgs.d(32, this.HZT);
      }
      if (this.HZU != null) {
        paramVarArgs.d(33, this.HZU);
      }
      if (this.HZV != null) {
        paramVarArgs.d(34, this.HZV);
      }
      if (this.HZW != null) {
        paramVarArgs.d(35, this.HZW);
      }
      paramVarArgs.aS(36, this.HJK);
      if (this.HZX != null) {
        paramVarArgs.d(37, this.HZX);
      }
      paramVarArgs.aS(38, this.Ghi);
      paramVarArgs.aS(39, this.Ghj);
      paramVarArgs.aS(40, this.ucK);
      if (this.Ghk != null) {
        paramVarArgs.d(41, this.Ghk);
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
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FOR);
      }
      i = paramInt;
      if (this.uvG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvG);
      }
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvF);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HlG) + f.a.a.b.b.a.bz(6, this.HlH);
      paramInt = i;
      if (this.HlI != null) {
        paramInt = i + f.a.a.a.lI(7, this.HlI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HZI) + f.a.a.b.b.a.bz(9, this.HZJ);
      paramInt = i;
      if (this.HZK != null) {
        paramInt = i + f.a.a.a.lI(10, this.HZK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HLF) + f.a.a.b.b.a.bz(12, this.GvW) + f.a.a.b.b.a.bz(13, this.HlJ) + f.a.a.b.b.a.bz(14, this.FZk);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FNL);
      }
      i = paramInt;
      if (this.HZL != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.HZL);
      }
      paramInt = i;
      if (this.Ghg != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Ghg);
      }
      i = paramInt + f.a.a.b.b.a.bz(18, this.Ghh);
      paramInt = i;
      if (this.Hdm != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Hdm);
      }
      i = paramInt + f.a.a.b.b.a.bz(20, this.HZA) + f.a.a.b.b.a.bz(21, this.HZB) + f.a.a.b.b.a.bz(22, this.HZC);
      paramInt = i;
      if (this.Hdo != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Hdo);
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.HZM) + f.a.a.b.b.a.bz(25, this.GwZ);
      paramInt = i;
      if (this.HZN != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.HZN);
      }
      i = paramInt;
      if (this.HZO != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.HZO);
      }
      i += f.a.a.b.b.a.bz(28, this.HZP);
      paramInt = i;
      if (this.HZQ != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.HZQ);
      }
      i = paramInt;
      if (this.HZR != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.HZR);
      }
      paramInt = i;
      if (this.HZS != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.HZS);
      }
      i = paramInt;
      if (this.HZT != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.HZT);
      }
      paramInt = i;
      if (this.HZU != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.HZU);
      }
      i = paramInt;
      if (this.HZV != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.HZV);
      }
      paramInt = i;
      if (this.HZW != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.HZW);
      }
      i = paramInt + f.a.a.b.b.a.bz(36, this.HJK);
      paramInt = i;
      if (this.HZX != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.HZX);
      }
      i = paramInt + f.a.a.b.b.a.bz(38, this.Ghi) + f.a.a.b.b.a.bz(39, this.Ghj) + f.a.a.b.b.a.bz(40, this.ucK);
      paramInt = i;
      if (this.Ghk != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.Ghk);
      }
      AppMethodBeat.o(127180);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HlI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        if (this.HZK == null)
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
        due localdue = (due)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127180);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdue.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 2: 
          localdue.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 3: 
          localdue.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 4: 
          localdue.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 5: 
          localdue.HlG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 6: 
          localdue.HlH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdue.HlI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 8: 
          localdue.HZI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 9: 
          localdue.HZJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdue.HZK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 11: 
          localdue.HLF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 12: 
          localdue.GvW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 13: 
          localdue.HlJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 14: 
          localdue.FZk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 15: 
          localdue.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 16: 
          localdue.HZL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 17: 
          localdue.Ghg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 18: 
          localdue.Ghh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 19: 
          localdue.Hdm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 20: 
          localdue.HZA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 21: 
          localdue.HZB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 22: 
          localdue.HZC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 23: 
          localdue.Hdo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 24: 
          localdue.HZM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 25: 
          localdue.GwZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 26: 
          localdue.HZN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 27: 
          localdue.HZO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 28: 
          localdue.HZP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 29: 
          localdue.HZQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 30: 
          localdue.HZR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 31: 
          localdue.HZS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 32: 
          localdue.HZT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 33: 
          localdue.HZU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 34: 
          localdue.HZV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 35: 
          localdue.HZW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 36: 
          localdue.HJK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 37: 
          localdue.HZX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 38: 
          localdue.Ghi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 39: 
          localdue.Ghj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 40: 
          localdue.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127180);
          return 0;
        }
        localdue.Ghk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127180);
        return 0;
      }
      AppMethodBeat.o(127180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.due
 * JD-Core Version:    0.7.0.1
 */