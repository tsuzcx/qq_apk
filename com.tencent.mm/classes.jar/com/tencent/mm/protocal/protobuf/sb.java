package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class sb
  extends bvk
{
  public String kWy;
  public int koj;
  public String kok;
  public String oiG;
  public long wKm;
  public long wKn;
  public String wKo;
  public String wKp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48820);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48820);
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
      paramVarArgs.am(4, this.wKm);
      paramVarArgs.am(5, this.wKn);
      if (this.wKo != null) {
        paramVarArgs.e(6, this.wKo);
      }
      if (this.wKp != null) {
        paramVarArgs.e(7, this.wKp);
      }
      if (this.oiG != null) {
        paramVarArgs.e(8, this.oiG);
      }
      if (this.kWy != null) {
        paramVarArgs.e(9, this.kWy);
      }
      AppMethodBeat.o(48820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.b.b.a.p(4, this.wKm) + e.a.a.b.b.a.p(5, this.wKn);
      paramInt = i;
      if (this.wKo != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wKo);
      }
      i = paramInt;
      if (this.wKp != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wKp);
      }
      paramInt = i;
      if (this.oiG != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.oiG);
      }
      i = paramInt;
      if (this.kWy != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.kWy);
      }
      AppMethodBeat.o(48820);
      return i;
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
          AppMethodBeat.o(48820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        sb localsb = (sb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48820);
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
            localsb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48820);
          return 0;
        case 2: 
          localsb.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48820);
          return 0;
        case 3: 
          localsb.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48820);
          return 0;
        case 4: 
          localsb.wKm = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48820);
          return 0;
        case 5: 
          localsb.wKn = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48820);
          return 0;
        case 6: 
          localsb.wKo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48820);
          return 0;
        case 7: 
          localsb.wKp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48820);
          return 0;
        case 8: 
          localsb.oiG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48820);
          return 0;
        }
        localsb.kWy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48820);
        return 0;
      }
      AppMethodBeat.o(48820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sb
 * JD-Core Version:    0.7.0.1
 */