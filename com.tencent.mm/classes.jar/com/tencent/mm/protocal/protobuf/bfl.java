package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bfl
  extends cvp
{
  public String FGP;
  public int FJy;
  public String FMt;
  public String FqV;
  public int GBj;
  public LinkedList<cgs> GBk;
  public SKBuiltinBuffer_t GzA;
  public String GzJ;
  public int GzK;
  public int OpCode;
  public String Url;
  
  public bfl()
  {
    AppMethodBeat.i(56250);
    this.GBk = new LinkedList();
    AppMethodBeat.o(56250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.GzA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GBj);
      paramVarArgs.e(3, 8, this.GBk);
      paramVarArgs.aS(4, this.OpCode);
      paramVarArgs.aS(5, this.FJy);
      if (this.GzA != null)
      {
        paramVarArgs.lC(6, this.GzA.computeSize());
        this.GzA.writeFields(paramVarArgs);
      }
      if (this.Url != null) {
        paramVarArgs.d(7, this.Url);
      }
      if (this.GzJ != null) {
        paramVarArgs.d(8, this.GzJ);
      }
      if (this.FGP != null) {
        paramVarArgs.d(9, this.FGP);
      }
      if (this.FqV != null) {
        paramVarArgs.d(10, this.FqV);
      }
      paramVarArgs.aS(11, this.GzK);
      if (this.FMt != null) {
        paramVarArgs.d(12, this.FMt);
      }
      AppMethodBeat.o(56251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GBj) + f.a.a.a.c(3, 8, this.GBk) + f.a.a.b.b.a.bz(4, this.OpCode) + f.a.a.b.b.a.bz(5, this.FJy);
      paramInt = i;
      if (this.GzA != null) {
        paramInt = i + f.a.a.a.lB(6, this.GzA.computeSize());
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Url);
      }
      paramInt = i;
      if (this.GzJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GzJ);
      }
      i = paramInt;
      if (this.FGP != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FGP);
      }
      paramInt = i;
      if (this.FqV != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FqV);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GzK);
      paramInt = i;
      if (this.FMt != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FMt);
      }
      AppMethodBeat.o(56251);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GBk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        if (this.GzA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfl localbfl = (bfl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56251);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 2: 
          localbfl.GBj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56251);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfl.GBk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 4: 
          localbfl.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56251);
          return 0;
        case 5: 
          localbfl.FJy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56251);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfl.GzA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 7: 
          localbfl.Url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 8: 
          localbfl.GzJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 9: 
          localbfl.FGP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 10: 
          localbfl.FqV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 11: 
          localbfl.GzK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56251);
          return 0;
        }
        localbfl.FMt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(56251);
        return 0;
      }
      AppMethodBeat.o(56251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfl
 * JD-Core Version:    0.7.0.1
 */