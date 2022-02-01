package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byx
  extends cvw
{
  public int GUb;
  public int GgW;
  public int GgX;
  public String HlA;
  public String HlB;
  public int HlC;
  public SKBuiltinBuffer_t HlD;
  public int HlE;
  public int HlF;
  public int HlG;
  public int HlH;
  public SKBuiltinBuffer_t HlI;
  public int HlJ;
  public int HlK;
  public int HlL;
  public int HlM;
  public int HlN;
  public String HlO;
  public String HlP;
  public String Hlz;
  public String ThumbUrl;
  public int urJ;
  public String usR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32345);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HlD == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataBuffer");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.HlI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hlz != null) {
        paramVarArgs.d(2, this.Hlz);
      }
      if (this.HlA != null) {
        paramVarArgs.d(3, this.HlA);
      }
      if (this.HlB != null) {
        paramVarArgs.d(4, this.HlB);
      }
      paramVarArgs.aS(5, this.urJ);
      paramVarArgs.aS(6, this.HlC);
      if (this.HlD != null)
      {
        paramVarArgs.lJ(7, this.HlD.computeSize());
        this.HlD.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.HlE);
      paramVarArgs.aS(9, this.HlF);
      paramVarArgs.aS(10, this.HlG);
      paramVarArgs.aS(11, this.HlH);
      if (this.HlI != null)
      {
        paramVarArgs.lJ(12, this.HlI.computeSize());
        this.HlI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.HlJ);
      paramVarArgs.aS(14, this.HlK);
      paramVarArgs.aS(15, this.HlL);
      paramVarArgs.aS(16, this.HlM);
      paramVarArgs.aS(17, this.GUb);
      paramVarArgs.aS(18, this.HlN);
      if (this.usR != null) {
        paramVarArgs.d(19, this.usR);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(20, this.ThumbUrl);
      }
      paramVarArgs.aS(21, this.GgX);
      paramVarArgs.aS(22, this.GgW);
      if (this.HlO != null) {
        paramVarArgs.d(23, this.HlO);
      }
      if (this.HlP != null) {
        paramVarArgs.d(24, this.HlP);
      }
      AppMethodBeat.o(32345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1804;
      }
    }
    label1804:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hlz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hlz);
      }
      i = paramInt;
      if (this.HlA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HlA);
      }
      paramInt = i;
      if (this.HlB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HlB);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.urJ) + f.a.a.b.b.a.bz(6, this.HlC);
      paramInt = i;
      if (this.HlD != null) {
        paramInt = i + f.a.a.a.lI(7, this.HlD.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HlE) + f.a.a.b.b.a.bz(9, this.HlF) + f.a.a.b.b.a.bz(10, this.HlG) + f.a.a.b.b.a.bz(11, this.HlH);
      paramInt = i;
      if (this.HlI != null) {
        paramInt = i + f.a.a.a.lI(12, this.HlI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.HlJ) + f.a.a.b.b.a.bz(14, this.HlK) + f.a.a.b.b.a.bz(15, this.HlL) + f.a.a.b.b.a.bz(16, this.HlM) + f.a.a.b.b.a.bz(17, this.GUb) + f.a.a.b.b.a.bz(18, this.HlN);
      paramInt = i;
      if (this.usR != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.usR);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.ThumbUrl);
      }
      i = i + f.a.a.b.b.a.bz(21, this.GgX) + f.a.a.b.b.a.bz(22, this.GgW);
      paramInt = i;
      if (this.HlO != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.HlO);
      }
      i = paramInt;
      if (this.HlP != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.HlP);
      }
      AppMethodBeat.o(32345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HlD == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataBuffer");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        if (this.HlI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32345);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byx localbyx = (byx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32345);
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
            localbyx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 2: 
          localbyx.Hlz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 3: 
          localbyx.HlA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 4: 
          localbyx.HlB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 5: 
          localbyx.urJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 6: 
          localbyx.HlC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
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
            localbyx.HlD = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 8: 
          localbyx.HlE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 9: 
          localbyx.HlF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 10: 
          localbyx.HlG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 11: 
          localbyx.HlH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyx.HlI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 13: 
          localbyx.HlJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 14: 
          localbyx.HlK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 15: 
          localbyx.HlL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 16: 
          localbyx.HlM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 17: 
          localbyx.GUb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 18: 
          localbyx.HlN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 19: 
          localbyx.usR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 20: 
          localbyx.ThumbUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 21: 
          localbyx.GgX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 22: 
          localbyx.GgW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32345);
          return 0;
        case 23: 
          localbyx.HlO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32345);
          return 0;
        }
        localbyx.HlP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32345);
        return 0;
      }
      AppMethodBeat.o(32345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byx
 * JD-Core Version:    0.7.0.1
 */