package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class asn
  extends cld
{
  public SKBuiltinBuffer_t CBW;
  public int CCF;
  public LinkedList<yf> CCG;
  public String CCH;
  public String CCI;
  public String CCJ;
  public int CCN;
  public String CCO;
  public String CCP;
  public String DsE;
  public String ID;
  public int Scene;
  public int mBH;
  public long mBe;
  
  public asn()
  {
    AppMethodBeat.i(32227);
    this.CCG = new LinkedList();
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
      if (this.CBW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(32228);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ID != null) {
        paramVarArgs.d(2, this.ID);
      }
      if (this.CBW != null)
      {
        paramVarArgs.kX(3, this.CBW.computeSize());
        this.CBW.writeFields(paramVarArgs);
      }
      if (this.CCO != null) {
        paramVarArgs.d(4, this.CCO);
      }
      if (this.CCP != null) {
        paramVarArgs.d(5, this.CCP);
      }
      paramVarArgs.aR(6, this.mBH);
      paramVarArgs.aR(7, this.CCF);
      paramVarArgs.e(8, 8, this.CCG);
      if (this.DsE != null) {
        paramVarArgs.d(9, this.DsE);
      }
      if (this.CCH != null) {
        paramVarArgs.d(10, this.CCH);
      }
      if (this.CCI != null) {
        paramVarArgs.d(11, this.CCI);
      }
      paramVarArgs.aR(12, this.CCN);
      paramVarArgs.aR(13, this.Scene);
      paramVarArgs.aG(14, this.mBe);
      if (this.CCJ != null) {
        paramVarArgs.d(15, this.CCJ);
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
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ID);
      }
      i = paramInt;
      if (this.CBW != null) {
        i = paramInt + f.a.a.a.kW(3, this.CBW.computeSize());
      }
      paramInt = i;
      if (this.CCO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CCO);
      }
      i = paramInt;
      if (this.CCP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CCP);
      }
      i = i + f.a.a.b.b.a.bA(6, this.mBH) + f.a.a.b.b.a.bA(7, this.CCF) + f.a.a.a.c(8, 8, this.CCG);
      paramInt = i;
      if (this.DsE != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DsE);
      }
      i = paramInt;
      if (this.CCH != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CCH);
      }
      paramInt = i;
      if (this.CCI != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CCI);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.CCN) + f.a.a.b.b.a.bA(13, this.Scene) + f.a.a.b.b.a.q(14, this.mBe);
      paramInt = i;
      if (this.CCJ != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.CCJ);
      }
      AppMethodBeat.o(32228);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CCG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32228);
          throw paramVarArgs;
        }
        if (this.CBW == null)
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
        asn localasn = (asn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32228);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 2: 
          localasn.ID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasn.CBW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 4: 
          localasn.CCO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 5: 
          localasn.CCP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 6: 
          localasn.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32228);
          return 0;
        case 7: 
          localasn.CCF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32228);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localasn.CCG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32228);
          return 0;
        case 9: 
          localasn.DsE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 10: 
          localasn.CCH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 11: 
          localasn.CCI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32228);
          return 0;
        case 12: 
          localasn.CCN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32228);
          return 0;
        case 13: 
          localasn.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32228);
          return 0;
        case 14: 
          localasn.mBe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32228);
          return 0;
        }
        localasn.CCJ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32228);
        return 0;
      }
      AppMethodBeat.o(32228);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asn
 * JD-Core Version:    0.7.0.1
 */