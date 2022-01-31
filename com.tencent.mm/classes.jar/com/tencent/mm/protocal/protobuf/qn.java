package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qn
  extends bvk
{
  public int cnK;
  public String cwk;
  public String kNv;
  public int okH;
  public String wIJ;
  public String wIK;
  public String wIM;
  public String wIV;
  public String wpq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48800);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48800);
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
      if (this.cwk != null) {
        paramVarArgs.e(4, this.cwk);
      }
      if (this.wIM != null) {
        paramVarArgs.e(5, this.wIM);
      }
      if (this.wpq != null) {
        paramVarArgs.e(6, this.wpq);
      }
      paramVarArgs.aO(7, this.okH);
      if (this.wIV != null) {
        paramVarArgs.e(8, this.wIV);
      }
      if (this.wIK != null) {
        paramVarArgs.e(9, this.wIK);
      }
      if (this.wIJ != null) {
        paramVarArgs.e(10, this.wIJ);
      }
      AppMethodBeat.o(48800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.cwk != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.cwk);
      }
      paramInt = i;
      if (this.wIM != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wIM);
      }
      i = paramInt;
      if (this.wpq != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wpq);
      }
      i += e.a.a.b.b.a.bl(7, this.okH);
      paramInt = i;
      if (this.wIV != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wIV);
      }
      i = paramInt;
      if (this.wIK != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wIK);
      }
      paramInt = i;
      if (this.wIJ != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wIJ);
      }
      AppMethodBeat.o(48800);
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
          AppMethodBeat.o(48800);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qn localqn = (qn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48800);
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
            localqn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48800);
          return 0;
        case 2: 
          localqn.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48800);
          return 0;
        case 3: 
          localqn.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48800);
          return 0;
        case 4: 
          localqn.cwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48800);
          return 0;
        case 5: 
          localqn.wIM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48800);
          return 0;
        case 6: 
          localqn.wpq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48800);
          return 0;
        case 7: 
          localqn.okH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48800);
          return 0;
        case 8: 
          localqn.wIV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48800);
          return 0;
        case 9: 
          localqn.wIK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48800);
          return 0;
        }
        localqn.wIJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48800);
        return 0;
      }
      AppMethodBeat.o(48800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qn
 * JD-Core Version:    0.7.0.1
 */