package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class boz
  extends ckq
{
  public int COF;
  public int COG;
  public String DMh;
  public String DMi;
  public String DMj;
  public int DMk;
  public SKBuiltinBuffer_t DMl;
  public int DMm;
  public int DMn;
  public int DMo;
  public int DMp;
  public SKBuiltinBuffer_t DMq;
  public int DMr;
  public int DMs;
  public int DMt;
  public int DMu;
  public int DMv;
  public String DMw;
  public String DMx;
  public int DvO;
  public String ThumbUrl;
  public int saz;
  public String sbz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32345);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DMl == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataBuffer");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.DMq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DMh != null) {
        paramVarArgs.d(2, this.DMh);
      }
      if (this.DMi != null) {
        paramVarArgs.d(3, this.DMi);
      }
      if (this.DMj != null) {
        paramVarArgs.d(4, this.DMj);
      }
      paramVarArgs.aR(5, this.saz);
      paramVarArgs.aR(6, this.DMk);
      if (this.DMl != null)
      {
        paramVarArgs.kX(7, this.DMl.computeSize());
        this.DMl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.DMm);
      paramVarArgs.aR(9, this.DMn);
      paramVarArgs.aR(10, this.DMo);
      paramVarArgs.aR(11, this.DMp);
      if (this.DMq != null)
      {
        paramVarArgs.kX(12, this.DMq.computeSize());
        this.DMq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.DMr);
      paramVarArgs.aR(14, this.DMs);
      paramVarArgs.aR(15, this.DMt);
      paramVarArgs.aR(16, this.DMu);
      paramVarArgs.aR(17, this.DvO);
      paramVarArgs.aR(18, this.DMv);
      if (this.sbz != null) {
        paramVarArgs.d(19, this.sbz);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(20, this.ThumbUrl);
      }
      paramVarArgs.aR(21, this.COG);
      paramVarArgs.aR(22, this.COF);
      if (this.DMw != null) {
        paramVarArgs.d(23, this.DMw);
      }
      if (this.DMx != null) {
        paramVarArgs.d(24, this.DMx);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DMh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DMh);
      }
      i = paramInt;
      if (this.DMi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DMi);
      }
      paramInt = i;
      if (this.DMj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DMj);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.saz) + f.a.a.b.b.a.bA(6, this.DMk);
      paramInt = i;
      if (this.DMl != null) {
        paramInt = i + f.a.a.a.kW(7, this.DMl.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.DMm) + f.a.a.b.b.a.bA(9, this.DMn) + f.a.a.b.b.a.bA(10, this.DMo) + f.a.a.b.b.a.bA(11, this.DMp);
      paramInt = i;
      if (this.DMq != null) {
        paramInt = i + f.a.a.a.kW(12, this.DMq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.DMr) + f.a.a.b.b.a.bA(14, this.DMs) + f.a.a.b.b.a.bA(15, this.DMt) + f.a.a.b.b.a.bA(16, this.DMu) + f.a.a.b.b.a.bA(17, this.DvO) + f.a.a.b.b.a.bA(18, this.DMv);
      paramInt = i;
      if (this.sbz != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.sbz);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.ThumbUrl);
      }
      i = i + f.a.a.b.b.a.bA(21, this.COG) + f.a.a.b.b.a.bA(22, this.COF);
      paramInt = i;
      if (this.DMw != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.DMw);
      }
      i = paramInt;
      if (this.DMx != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.DMx);
      }
      AppMethodBeat.o(32345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DMl == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataBuffer");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        if (this.DMq == null)
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
        boz localboz = (boz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32345);
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
            localboz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 2: 
          localboz.DMh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 3: 
          localboz.DMi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 4: 
          localboz.DMj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 5: 
          localboz.saz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 6: 
          localboz.DMk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
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
            localboz.DMl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 8: 
          localboz.DMm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 9: 
          localboz.DMn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 10: 
          localboz.DMo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 11: 
          localboz.DMp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboz.DMq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 13: 
          localboz.DMr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 14: 
          localboz.DMs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 15: 
          localboz.DMt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 16: 
          localboz.DMu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 17: 
          localboz.DvO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 18: 
          localboz.DMv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 19: 
          localboz.sbz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 20: 
          localboz.ThumbUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 21: 
          localboz.COG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 22: 
          localboz.COF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32345);
          return 0;
        case 23: 
          localboz.DMw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32345);
          return 0;
        }
        localboz.DMx = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32345);
        return 0;
      }
      AppMethodBeat.o(32345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boz
 * JD-Core Version:    0.7.0.1
 */