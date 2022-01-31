package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bqb
  extends bvk
{
  public int cnK;
  public String kNv;
  public String mZD;
  public int okH;
  public String qgw;
  public String qgx;
  public int state;
  public String xEt;
  public int xEu;
  public String xEv;
  public String xEw;
  public String xEx;
  public String xEy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48940);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48940);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      paramVarArgs.aO(4, this.state);
      if (this.xEt != null) {
        paramVarArgs.e(5, this.xEt);
      }
      paramVarArgs.aO(6, this.okH);
      paramVarArgs.aO(7, this.xEu);
      if (this.qgw != null) {
        paramVarArgs.e(8, this.qgw);
      }
      if (this.xEv != null) {
        paramVarArgs.e(9, this.xEv);
      }
      if (this.qgx != null) {
        paramVarArgs.e(10, this.qgx);
      }
      if (this.xEw != null) {
        paramVarArgs.e(11, this.xEw);
      }
      if (this.xEx != null) {
        paramVarArgs.e(12, this.xEx);
      }
      if (this.xEy != null) {
        paramVarArgs.e(14, this.xEy);
      }
      if (this.mZD != null) {
        paramVarArgs.e(15, this.mZD);
      }
      AppMethodBeat.o(48940);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.state);
      paramInt = i;
      if (this.xEt != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xEt);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.okH) + e.a.a.b.b.a.bl(7, this.xEu);
      paramInt = i;
      if (this.qgw != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.qgw);
      }
      i = paramInt;
      if (this.xEv != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xEv);
      }
      paramInt = i;
      if (this.qgx != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.qgx);
      }
      i = paramInt;
      if (this.xEw != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.xEw);
      }
      paramInt = i;
      if (this.xEx != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xEx);
      }
      i = paramInt;
      if (this.xEy != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.xEy);
      }
      paramInt = i;
      if (this.mZD != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.mZD);
      }
      AppMethodBeat.o(48940);
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
          AppMethodBeat.o(48940);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48940);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bqb localbqb = (bqb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
        default: 
          AppMethodBeat.o(48940);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbqb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48940);
          return 0;
        case 2: 
          localbqb.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48940);
          return 0;
        case 3: 
          localbqb.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48940);
          return 0;
        case 4: 
          localbqb.state = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48940);
          return 0;
        case 5: 
          localbqb.xEt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48940);
          return 0;
        case 6: 
          localbqb.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48940);
          return 0;
        case 7: 
          localbqb.xEu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48940);
          return 0;
        case 8: 
          localbqb.qgw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48940);
          return 0;
        case 9: 
          localbqb.xEv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48940);
          return 0;
        case 10: 
          localbqb.qgx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48940);
          return 0;
        case 11: 
          localbqb.xEw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48940);
          return 0;
        case 12: 
          localbqb.xEx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48940);
          return 0;
        case 14: 
          localbqb.xEy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48940);
          return 0;
        }
        localbqb.mZD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48940);
        return 0;
      }
      AppMethodBeat.o(48940);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqb
 * JD-Core Version:    0.7.0.1
 */