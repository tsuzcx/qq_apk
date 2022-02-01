package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bfl
  extends cwj
{
  public int FNv;
  public int GUr;
  public LinkedList<cet> GUs;
  public String GUt;
  public int GUu;
  
  public bfl()
  {
    AppMethodBeat.i(32254);
    this.GUs = new LinkedList();
    AppMethodBeat.o(32254);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32255);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32255);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GUr);
      paramVarArgs.e(3, 8, this.GUs);
      if (this.GUt != null) {
        paramVarArgs.d(4, this.GUt);
      }
      paramVarArgs.aS(5, this.FNv);
      paramVarArgs.aS(6, this.GUu);
      AppMethodBeat.o(32255);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GUr) + f.a.a.a.c(3, 8, this.GUs);
      paramInt = i;
      if (this.GUt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GUt);
      }
      i = f.a.a.b.b.a.bz(5, this.FNv);
      int j = f.a.a.b.b.a.bz(6, this.GUu);
      AppMethodBeat.o(32255);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GUs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32255);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32255);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfl localbfl = (bfl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32255);
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
            localbfl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 2: 
          localbfl.GUr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32255);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cet();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cet)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfl.GUs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 4: 
          localbfl.GUt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32255);
          return 0;
        case 5: 
          localbfl.FNv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32255);
          return 0;
        }
        localbfl.GUu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32255);
        return 0;
      }
      AppMethodBeat.o(32255);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfl
 * JD-Core Version:    0.7.0.1
 */