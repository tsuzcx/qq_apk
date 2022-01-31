package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cfi
  extends bvk
{
  public long Id;
  public int jKs;
  public String pIw;
  public int pIx;
  public int pIy;
  public cdp xPM;
  public int xsL;
  public LinkedList<cdp> xsM;
  
  public cfi()
  {
    AppMethodBeat.i(94621);
    this.xsM = new LinkedList();
    AppMethodBeat.o(94621);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94622);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(94622);
        throw paramVarArgs;
      }
      if (this.xPM == null)
      {
        paramVarArgs = new b("Not all required fields were included: BufferUrl");
        AppMethodBeat.o(94622);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIx);
      if (this.pIw != null) {
        paramVarArgs.e(4, this.pIw);
      }
      if (this.xPM != null)
      {
        paramVarArgs.iQ(5, this.xPM.computeSize());
        this.xPM.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.xsL);
      paramVarArgs.e(7, 8, this.xsM);
      paramVarArgs.am(8, this.Id);
      paramVarArgs.aO(9, this.jKs);
      AppMethodBeat.o(94622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIy) + e.a.a.b.b.a.bl(3, this.pIx);
      paramInt = i;
      if (this.pIw != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.pIw);
      }
      i = paramInt;
      if (this.xPM != null) {
        i = paramInt + e.a.a.a.iP(5, this.xPM.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(6, this.xsL);
      int j = e.a.a.a.c(7, 8, this.xsM);
      int k = e.a.a.b.b.a.p(8, this.Id);
      int m = e.a.a.b.b.a.bl(9, this.jKs);
      AppMethodBeat.o(94622);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xsM.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(94622);
          throw paramVarArgs;
        }
        if (this.xPM == null)
        {
          paramVarArgs = new b("Not all required fields were included: BufferUrl");
          AppMethodBeat.o(94622);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94622);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfi localcfi = (cfi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94622);
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
            localcfi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94622);
          return 0;
        case 2: 
          localcfi.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94622);
          return 0;
        case 3: 
          localcfi.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94622);
          return 0;
        case 4: 
          localcfi.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94622);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfi.xPM = ((cdp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94622);
          return 0;
        case 6: 
          localcfi.xsL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94622);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfi.xsM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94622);
          return 0;
        case 8: 
          localcfi.Id = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94622);
          return 0;
        }
        localcfi.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94622);
        return 0;
      }
      AppMethodBeat.o(94622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfi
 * JD-Core Version:    0.7.0.1
 */