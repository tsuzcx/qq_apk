package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ajz
  extends bvk
{
  public int jJu;
  public LinkedList<zq> jJv;
  public int xbk;
  public String xbl;
  public int xbm;
  
  public ajz()
  {
    AppMethodBeat.i(62556);
    this.jJv = new LinkedList();
    AppMethodBeat.o(62556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62557);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(62557);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJu);
      paramVarArgs.e(3, 8, this.jJv);
      paramVarArgs.aO(4, this.xbk);
      if (this.xbl != null) {
        paramVarArgs.e(5, this.xbl);
      }
      paramVarArgs.aO(6, this.xbm);
      AppMethodBeat.o(62557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jJu) + e.a.a.a.c(3, 8, this.jJv) + e.a.a.b.b.a.bl(4, this.xbk);
      paramInt = i;
      if (this.xbl != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xbl);
      }
      i = e.a.a.b.b.a.bl(6, this.xbm);
      AppMethodBeat.o(62557);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jJv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(62557);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ajz localajz = (ajz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62557);
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
            localajz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62557);
          return 0;
        case 2: 
          localajz.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62557);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localajz.jJv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62557);
          return 0;
        case 4: 
          localajz.xbk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62557);
          return 0;
        case 5: 
          localajz.xbl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62557);
          return 0;
        }
        localajz.xbm = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62557);
        return 0;
      }
      AppMethodBeat.o(62557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajz
 * JD-Core Version:    0.7.0.1
 */