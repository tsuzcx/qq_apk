package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agf
  extends bvk
{
  public int koj;
  public String kok;
  public int wZh;
  public String wZi;
  public String wZj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56803);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.aO(4, this.wZh);
      if (this.wZi != null) {
        paramVarArgs.e(5, this.wZi);
      }
      if (this.wZj != null) {
        paramVarArgs.e(6, this.wZj);
      }
      AppMethodBeat.o(56803);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.wZh);
      paramInt = i;
      if (this.wZi != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wZi);
      }
      i = paramInt;
      if (this.wZj != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wZj);
      }
      AppMethodBeat.o(56803);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56803);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agf localagf = (agf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56803);
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
            localagf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56803);
          return 0;
        case 2: 
          localagf.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56803);
          return 0;
        case 3: 
          localagf.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56803);
          return 0;
        case 4: 
          localagf.wZh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56803);
          return 0;
        case 5: 
          localagf.wZi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56803);
          return 0;
        }
        localagf.wZj = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56803);
        return 0;
      }
      AppMethodBeat.o(56803);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agf
 * JD-Core Version:    0.7.0.1
 */