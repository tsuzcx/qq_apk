package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dib
  extends ckq
{
  public int CID;
  public String COP;
  public int COQ;
  public int COR;
  public int COS;
  public String COT;
  public String CxC;
  public String CyF;
  public String DER;
  public String DET;
  public int DMo;
  public int DMp;
  public SKBuiltinBuffer_t DMq;
  public int DMr;
  public int DcM;
  public int DdJ;
  public int EiL;
  public int Ekx;
  public int ExX;
  public int ExY;
  public int ExZ;
  public int Eyf;
  public int Eyg;
  public SKBuiltinBuffer_t Eyh;
  public String Eyi;
  public int Eyj;
  public String Eyk;
  public String Eyl;
  public int Eym;
  public String Eyn;
  public String Eyo;
  public String Eyp;
  public String Eyq;
  public String Eyr;
  public String Eys;
  public String Eyt;
  public String Eyu;
  public int rNz;
  public String sdP;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127180);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DMq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.Eyh == null)
      {
        paramVarArgs = new b("Not all required fields were included: VideoData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CyF != null) {
        paramVarArgs.d(2, this.CyF);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(3, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(4, this.sdP);
      }
      paramVarArgs.aR(5, this.DMo);
      paramVarArgs.aR(6, this.DMp);
      if (this.DMq != null)
      {
        paramVarArgs.kX(7, this.DMq.computeSize());
        this.DMq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Eyf);
      paramVarArgs.aR(9, this.Eyg);
      if (this.Eyh != null)
      {
        paramVarArgs.kX(10, this.Eyh.computeSize());
        this.Eyh.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.Ekx);
      paramVarArgs.aR(12, this.DcM);
      paramVarArgs.aR(13, this.DMr);
      paramVarArgs.aR(14, this.CID);
      if (this.CxC != null) {
        paramVarArgs.d(15, this.CxC);
      }
      if (this.Eyi != null) {
        paramVarArgs.d(16, this.Eyi);
      }
      if (this.COP != null) {
        paramVarArgs.d(17, this.COP);
      }
      paramVarArgs.aR(18, this.COQ);
      if (this.DER != null) {
        paramVarArgs.d(19, this.DER);
      }
      paramVarArgs.aR(20, this.ExX);
      paramVarArgs.aR(21, this.ExY);
      paramVarArgs.aR(22, this.ExZ);
      if (this.DET != null) {
        paramVarArgs.d(23, this.DET);
      }
      paramVarArgs.aR(24, this.Eyj);
      paramVarArgs.aR(25, this.DdJ);
      if (this.Eyk != null) {
        paramVarArgs.d(26, this.Eyk);
      }
      if (this.Eyl != null) {
        paramVarArgs.d(27, this.Eyl);
      }
      paramVarArgs.aR(28, this.Eym);
      if (this.Eyn != null) {
        paramVarArgs.d(29, this.Eyn);
      }
      if (this.Eyo != null) {
        paramVarArgs.d(30, this.Eyo);
      }
      if (this.Eyp != null) {
        paramVarArgs.d(31, this.Eyp);
      }
      if (this.Eyq != null) {
        paramVarArgs.d(32, this.Eyq);
      }
      if (this.Eyr != null) {
        paramVarArgs.d(33, this.Eyr);
      }
      if (this.Eys != null) {
        paramVarArgs.d(34, this.Eys);
      }
      if (this.Eyt != null) {
        paramVarArgs.d(35, this.Eyt);
      }
      paramVarArgs.aR(36, this.EiL);
      if (this.Eyu != null) {
        paramVarArgs.d(37, this.Eyu);
      }
      paramVarArgs.aR(38, this.COR);
      paramVarArgs.aR(39, this.COS);
      paramVarArgs.aR(40, this.rNz);
      if (this.COT != null) {
        paramVarArgs.d(41, this.COT);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CyF);
      }
      i = paramInt;
      if (this.sdQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdQ);
      }
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sdP);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DMo) + f.a.a.b.b.a.bA(6, this.DMp);
      paramInt = i;
      if (this.DMq != null) {
        paramInt = i + f.a.a.a.kW(7, this.DMq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.Eyf) + f.a.a.b.b.a.bA(9, this.Eyg);
      paramInt = i;
      if (this.Eyh != null) {
        paramInt = i + f.a.a.a.kW(10, this.Eyh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.Ekx) + f.a.a.b.b.a.bA(12, this.DcM) + f.a.a.b.b.a.bA(13, this.DMr) + f.a.a.b.b.a.bA(14, this.CID);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CxC);
      }
      i = paramInt;
      if (this.Eyi != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.Eyi);
      }
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.COP);
      }
      i = paramInt + f.a.a.b.b.a.bA(18, this.COQ);
      paramInt = i;
      if (this.DER != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DER);
      }
      i = paramInt + f.a.a.b.b.a.bA(20, this.ExX) + f.a.a.b.b.a.bA(21, this.ExY) + f.a.a.b.b.a.bA(22, this.ExZ);
      paramInt = i;
      if (this.DET != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.DET);
      }
      i = paramInt + f.a.a.b.b.a.bA(24, this.Eyj) + f.a.a.b.b.a.bA(25, this.DdJ);
      paramInt = i;
      if (this.Eyk != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.Eyk);
      }
      i = paramInt;
      if (this.Eyl != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.Eyl);
      }
      i += f.a.a.b.b.a.bA(28, this.Eym);
      paramInt = i;
      if (this.Eyn != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.Eyn);
      }
      i = paramInt;
      if (this.Eyo != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.Eyo);
      }
      paramInt = i;
      if (this.Eyp != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.Eyp);
      }
      i = paramInt;
      if (this.Eyq != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.Eyq);
      }
      paramInt = i;
      if (this.Eyr != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.Eyr);
      }
      i = paramInt;
      if (this.Eys != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.Eys);
      }
      paramInt = i;
      if (this.Eyt != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.Eyt);
      }
      i = paramInt + f.a.a.b.b.a.bA(36, this.EiL);
      paramInt = i;
      if (this.Eyu != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.Eyu);
      }
      i = paramInt + f.a.a.b.b.a.bA(38, this.COR) + f.a.a.b.b.a.bA(39, this.COS) + f.a.a.b.b.a.bA(40, this.rNz);
      paramInt = i;
      if (this.COT != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.COT);
      }
      AppMethodBeat.o(127180);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DMq == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        if (this.Eyh == null)
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
        dib localdib = (dib)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127180);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdib.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 2: 
          localdib.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 3: 
          localdib.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 4: 
          localdib.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 5: 
          localdib.DMo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 6: 
          localdib.DMp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdib.DMq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 8: 
          localdib.Eyf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 9: 
          localdib.Eyg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdib.Eyh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 11: 
          localdib.Ekx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 12: 
          localdib.DcM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 13: 
          localdib.DMr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 14: 
          localdib.CID = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 15: 
          localdib.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 16: 
          localdib.Eyi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 17: 
          localdib.COP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 18: 
          localdib.COQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 19: 
          localdib.DER = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 20: 
          localdib.ExX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 21: 
          localdib.ExY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 22: 
          localdib.ExZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 23: 
          localdib.DET = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 24: 
          localdib.Eyj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 25: 
          localdib.DdJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 26: 
          localdib.Eyk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 27: 
          localdib.Eyl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 28: 
          localdib.Eym = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 29: 
          localdib.Eyn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 30: 
          localdib.Eyo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 31: 
          localdib.Eyp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 32: 
          localdib.Eyq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 33: 
          localdib.Eyr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 34: 
          localdib.Eys = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 35: 
          localdib.Eyt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 36: 
          localdib.EiL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 37: 
          localdib.Eyu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 38: 
          localdib.COR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 39: 
          localdib.COS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        case 40: 
          localdib.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127180);
          return 0;
        }
        localdib.COT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(127180);
        return 0;
      }
      AppMethodBeat.o(127180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dib
 * JD-Core Version:    0.7.0.1
 */