package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsg
  extends bvk
{
  public String kqb;
  public int oiE;
  public int oiF;
  public String oiG;
  public com.tencent.mm.bv.b xxC;
  public int xxD;
  public int xxE;
  public String xxJ;
  public String xxK;
  public String xxL;
  public int xxM;
  public String xxO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56953);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56953);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xxD);
      if (this.oiG != null) {
        paramVarArgs.e(3, this.oiG);
      }
      if (this.xxK != null) {
        paramVarArgs.e(4, this.xxK);
      }
      if (this.xxL != null) {
        paramVarArgs.e(5, this.xxL);
      }
      if (this.xxC != null) {
        paramVarArgs.c(6, this.xxC);
      }
      paramVarArgs.aO(7, this.xxE);
      paramVarArgs.aO(8, this.oiE);
      paramVarArgs.aO(9, this.xxM);
      paramVarArgs.aO(10, this.oiF);
      if (this.kqb != null) {
        paramVarArgs.e(11, this.kqb);
      }
      if (this.xxO != null) {
        paramVarArgs.e(12, this.xxO);
      }
      if (this.xxJ != null) {
        paramVarArgs.e(13, this.xxJ);
      }
      AppMethodBeat.o(56953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xxD);
      paramInt = i;
      if (this.oiG != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.oiG);
      }
      i = paramInt;
      if (this.xxK != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xxK);
      }
      paramInt = i;
      if (this.xxL != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xxL);
      }
      i = paramInt;
      if (this.xxC != null) {
        i = paramInt + e.a.a.b.b.a.b(6, this.xxC);
      }
      i = i + e.a.a.b.b.a.bl(7, this.xxE) + e.a.a.b.b.a.bl(8, this.oiE) + e.a.a.b.b.a.bl(9, this.xxM) + e.a.a.b.b.a.bl(10, this.oiF);
      paramInt = i;
      if (this.kqb != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.kqb);
      }
      i = paramInt;
      if (this.xxO != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xxO);
      }
      paramInt = i;
      if (this.xxJ != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.xxJ);
      }
      AppMethodBeat.o(56953);
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
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56953);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bsg localbsg = (bsg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56953);
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
            localbsg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56953);
          return 0;
        case 2: 
          localbsg.xxD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56953);
          return 0;
        case 3: 
          localbsg.oiG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56953);
          return 0;
        case 4: 
          localbsg.xxK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56953);
          return 0;
        case 5: 
          localbsg.xxL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56953);
          return 0;
        case 6: 
          localbsg.xxC = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(56953);
          return 0;
        case 7: 
          localbsg.xxE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56953);
          return 0;
        case 8: 
          localbsg.oiE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56953);
          return 0;
        case 9: 
          localbsg.xxM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56953);
          return 0;
        case 10: 
          localbsg.oiF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56953);
          return 0;
        case 11: 
          localbsg.kqb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56953);
          return 0;
        case 12: 
          localbsg.xxO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56953);
          return 0;
        }
        localbsg.xxJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56953);
        return 0;
      }
      AppMethodBeat.o(56953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsg
 * JD-Core Version:    0.7.0.1
 */