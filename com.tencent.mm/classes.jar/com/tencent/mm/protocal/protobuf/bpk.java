package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bpk
  extends bvk
{
  public int koj;
  public String kok;
  public String ueu;
  public bmu wvq;
  public String xDw;
  public LinkedList<hg> xDx;
  
  public bpk()
  {
    AppMethodBeat.i(48928);
    this.xDx = new LinkedList();
    AppMethodBeat.o(48928);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48929);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48929);
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
      if (this.xDw != null) {
        paramVarArgs.e(4, this.xDw);
      }
      paramVarArgs.e(5, 8, this.xDx);
      if (this.wvq != null)
      {
        paramVarArgs.iQ(6, this.wvq.computeSize());
        this.wvq.writeFields(paramVarArgs);
      }
      if (this.ueu != null) {
        paramVarArgs.e(7, this.ueu);
      }
      AppMethodBeat.o(48929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.xDw != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xDw);
      }
      i += e.a.a.a.c(5, 8, this.xDx);
      paramInt = i;
      if (this.wvq != null) {
        paramInt = i + e.a.a.a.iP(6, this.wvq.computeSize());
      }
      i = paramInt;
      if (this.ueu != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.ueu);
      }
      AppMethodBeat.o(48929);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xDx.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(48929);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpk localbpk = (bpk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48929);
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
            localbpk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48929);
          return 0;
        case 2: 
          localbpk.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48929);
          return 0;
        case 3: 
          localbpk.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48929);
          return 0;
        case 4: 
          localbpk.xDw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48929);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpk.xDx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48929);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpk.wvq = ((bmu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48929);
          return 0;
        }
        localbpk.ueu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48929);
        return 0;
      }
      AppMethodBeat.o(48929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpk
 * JD-Core Version:    0.7.0.1
 */