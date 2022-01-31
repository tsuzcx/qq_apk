package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class chi
  extends bvk
{
  public int wlc;
  public String xOk;
  public int xPz;
  public long xRS;
  public int xSk;
  public LinkedList<chg> xSl;
  
  public chi()
  {
    AppMethodBeat.i(56522);
    this.xSl = new LinkedList();
    AppMethodBeat.o(56522);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56523);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56523);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xOk != null) {
        paramVarArgs.e(2, this.xOk);
      }
      paramVarArgs.aO(3, this.xSk);
      paramVarArgs.e(4, 8, this.xSl);
      paramVarArgs.aO(5, this.xPz);
      paramVarArgs.am(6, this.xRS);
      paramVarArgs.aO(7, this.wlc);
      AppMethodBeat.o(56523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xOk != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xOk);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xSk);
      int j = e.a.a.a.c(4, 8, this.xSl);
      int k = e.a.a.b.b.a.bl(5, this.xPz);
      int m = e.a.a.b.b.a.p(6, this.xRS);
      int n = e.a.a.b.b.a.bl(7, this.wlc);
      AppMethodBeat.o(56523);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xSl.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56523);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56523);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        chi localchi = (chi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56523);
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
            localchi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56523);
          return 0;
        case 2: 
          localchi.xOk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56523);
          return 0;
        case 3: 
          localchi.xSk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56523);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localchi.xSl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56523);
          return 0;
        case 5: 
          localchi.xPz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56523);
          return 0;
        case 6: 
          localchi.xRS = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56523);
          return 0;
        }
        localchi.wlc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56523);
        return 0;
      }
      AppMethodBeat.o(56523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chi
 * JD-Core Version:    0.7.0.1
 */