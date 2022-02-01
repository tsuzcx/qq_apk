package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddt
  extends cwj
{
  public LinkedList<ddr> HLk;
  public int HLl;
  public int Ret;
  public int nID;
  public String xcg;
  
  public ddt()
  {
    AppMethodBeat.i(32442);
    this.HLk = new LinkedList();
    AppMethodBeat.o(32442);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32443);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32443);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nID);
      paramVarArgs.e(3, 8, this.HLk);
      if (this.xcg != null) {
        paramVarArgs.d(4, this.xcg);
      }
      paramVarArgs.aS(5, this.HLl);
      paramVarArgs.aS(6, this.Ret);
      AppMethodBeat.o(32443);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nID) + f.a.a.a.c(3, 8, this.HLk);
      paramInt = i;
      if (this.xcg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xcg);
      }
      i = f.a.a.b.b.a.bz(5, this.HLl);
      int j = f.a.a.b.b.a.bz(6, this.Ret);
      AppMethodBeat.o(32443);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HLk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32443);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddt localddt = (ddt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32443);
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
            localddt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 2: 
          localddt.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32443);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddt.HLk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 4: 
          localddt.xcg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32443);
          return 0;
        case 5: 
          localddt.HLl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32443);
          return 0;
        }
        localddt.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32443);
        return 0;
      }
      AppMethodBeat.o(32443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddt
 * JD-Core Version:    0.7.0.1
 */