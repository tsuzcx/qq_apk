package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class baj
  extends cwj
{
  public LinkedList<Integer> GNm;
  public int GQu;
  public LinkedList<caj> GQv;
  public LinkedList<dwb> GQw;
  public LinkedList<dar> GQx;
  
  public baj()
  {
    AppMethodBeat.i(32234);
    this.GQv = new LinkedList();
    this.GNm = new LinkedList();
    this.GQw = new LinkedList();
    this.GQx = new LinkedList();
    AppMethodBeat.o(32234);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32235);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32235);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GQu);
      paramVarArgs.e(3, 8, this.GQv);
      paramVarArgs.f(4, 2, this.GNm);
      paramVarArgs.e(5, 8, this.GQw);
      paramVarArgs.e(6, 8, this.GQx);
      AppMethodBeat.o(32235);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label917;
      }
    }
    label917:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GQu);
      int j = f.a.a.a.c(3, 8, this.GQv);
      int k = f.a.a.a.d(4, 2, this.GNm);
      int m = f.a.a.a.c(5, 8, this.GQw);
      int n = f.a.a.a.c(6, 8, this.GQx);
      AppMethodBeat.o(32235);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GQv.clear();
        this.GNm.clear();
        this.GQw.clear();
        this.GQx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32235);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32235);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        baj localbaj = (baj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32235);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        case 2: 
          localbaj.GQu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32235);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaj.GQv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        case 4: 
          localbaj.GNm = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
          AppMethodBeat.o(32235);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaj.GQw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dar();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dar)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbaj.GQx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32235);
        return 0;
      }
      AppMethodBeat.o(32235);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baj
 * JD-Core Version:    0.7.0.1
 */