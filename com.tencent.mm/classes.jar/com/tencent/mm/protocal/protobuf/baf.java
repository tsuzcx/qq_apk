package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class baf
  extends cwj
{
  public int FST;
  public LinkedList<abj> FSU;
  public String FSV;
  public String FSW;
  public String FSX;
  public SKBuiltinBuffer_t FSl;
  public int FTb;
  public String FTc;
  public String FTd;
  public String GQm;
  public String ID;
  public int Scene;
  public long nIX;
  public int nJA;
  
  public baf()
  {
    AppMethodBeat.i(32227);
    this.FSU = new LinkedList();
    AppMethodBeat.o(32227);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32228);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.FSl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ID != null) {
        paramVarArgs.d(2, this.ID);
      }
      if (this.FSl != null)
      {
        paramVarArgs.lJ(3, this.FSl.computeSize());
        this.FSl.writeFields(paramVarArgs);
      }
      if (this.FTc != null) {
        paramVarArgs.d(4, this.FTc);
      }
      if (this.FTd != null) {
        paramVarArgs.d(5, this.FTd);
      }
      paramVarArgs.aS(6, this.nJA);
      paramVarArgs.aS(7, this.FST);
      paramVarArgs.e(8, 8, this.FSU);
      if (this.GQm != null) {
        paramVarArgs.d(9, this.GQm);
      }
      if (this.FSV != null) {
        paramVarArgs.d(10, this.FSV);
      }
      if (this.FSW != null) {
        paramVarArgs.d(11, this.FSW);
      }
      paramVarArgs.aS(12, this.FTb);
      paramVarArgs.aS(13, this.Scene);
      paramVarArgs.aZ(14, this.nIX);
      if (this.FSX != null) {
        paramVarArgs.d(15, this.FSX);
      }
      AppMethodBeat.o(32228);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1379;
      }
    }
    label1379:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ID);
      }
      i = paramInt;
      if (this.FSl != null) {
        i = paramInt + f.a.a.a.lI(3, this.FSl.computeSize());
      }
      paramInt = i;
      if (this.FTc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FTc);
      }
      i = paramInt;
      if (this.FTd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FTd);
      }
      i = i + f.a.a.b.b.a.bz(6, this.nJA) + f.a.a.b.b.a.bz(7, this.FST) + f.a.a.a.c(8, 8, this.FSU);
      paramInt = i;
      if (this.GQm != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GQm);
      }
      i = paramInt;
      if (this.FSV != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FSV);
      }
      paramInt = i;
      if (this.FSW != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FSW);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FTb) + f.a.a.b.b.a.bz(13, this.Scene) + f.a.a.b.b.a.p(14, this.nIX);
      paramInt = i;
      if (this.FSX != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FSX);
      }
      AppMethodBeat.o(32228);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FSU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        if (this.FSl == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32228);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        baf localbaf = (baf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32228);
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
            localbaf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 2: 
          localbaf.ID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaf.FSl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 4: 
          localbaf.FTc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 5: 
          localbaf.FTd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 6: 
          localbaf.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32228);
          return 0;
        case 7: 
          localbaf.FST = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32228);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaf.FSU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 9: 
          localbaf.GQm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 10: 
          localbaf.FSV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 11: 
          localbaf.FSW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 12: 
          localbaf.FTb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32228);
          return 0;
        case 13: 
          localbaf.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32228);
          return 0;
        case 14: 
          localbaf.nIX = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32228);
          return 0;
        }
        localbaf.FSX = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32228);
        return 0;
      }
      AppMethodBeat.o(32228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baf
 * JD-Core Version:    0.7.0.1
 */