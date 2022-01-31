package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bhf
  extends bvk
{
  public int koj;
  public String kok;
  public String tMq;
  public String tMr;
  public String tMs;
  public int tMt;
  public String tMu;
  public String tNy;
  public bax xwj;
  public String xwk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56867);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56867);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      if (this.xwj != null)
      {
        paramVarArgs.iQ(4, this.xwj.computeSize());
        this.xwj.writeFields(paramVarArgs);
      }
      if (this.tMq != null) {
        paramVarArgs.e(5, this.tMq);
      }
      if (this.tMr != null) {
        paramVarArgs.e(6, this.tMr);
      }
      if (this.tMs != null) {
        paramVarArgs.e(7, this.tMs);
      }
      paramVarArgs.aO(8, this.tMt);
      if (this.tMu != null) {
        paramVarArgs.e(9, this.tMu);
      }
      if (this.xwk != null) {
        paramVarArgs.e(10, this.xwk);
      }
      if (this.tNy != null) {
        paramVarArgs.e(100, this.tNy);
      }
      AppMethodBeat.o(56867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1074;
      }
    }
    label1074:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.xwj != null) {
        i = paramInt + e.a.a.a.iP(4, this.xwj.computeSize());
      }
      paramInt = i;
      if (this.tMq != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.tMq);
      }
      i = paramInt;
      if (this.tMr != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.tMr);
      }
      paramInt = i;
      if (this.tMs != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.tMs);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.tMt);
      paramInt = i;
      if (this.tMu != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.tMu);
      }
      i = paramInt;
      if (this.xwk != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xwk);
      }
      paramInt = i;
      if (this.tNy != null) {
        paramInt = i + e.a.a.b.b.a.f(100, this.tNy);
      }
      AppMethodBeat.o(56867);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56867);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56867);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bhf localbhf = (bhf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56867);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56867);
          return 0;
        case 2: 
          localbhf.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56867);
          return 0;
        case 3: 
          localbhf.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56867);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bax();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bax)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhf.xwj = ((bax)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56867);
          return 0;
        case 5: 
          localbhf.tMq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56867);
          return 0;
        case 6: 
          localbhf.tMr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56867);
          return 0;
        case 7: 
          localbhf.tMs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56867);
          return 0;
        case 8: 
          localbhf.tMt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56867);
          return 0;
        case 9: 
          localbhf.tMu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56867);
          return 0;
        case 10: 
          localbhf.xwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56867);
          return 0;
        }
        localbhf.tNy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56867);
        return 0;
      }
      AppMethodBeat.o(56867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhf
 * JD-Core Version:    0.7.0.1
 */