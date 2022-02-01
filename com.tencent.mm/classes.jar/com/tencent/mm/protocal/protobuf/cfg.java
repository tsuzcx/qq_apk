package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cfg
  extends cwj
{
  public String FVK;
  public cls FVM;
  public String HrS;
  public boolean HrT;
  public boolean HrU;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72529);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.HrS != null) {
        paramVarArgs.d(4, this.HrS);
      }
      if (this.FVK != null) {
        paramVarArgs.d(7, this.FVK);
      }
      if (this.FVM != null)
      {
        paramVarArgs.lJ(8, this.FVM.computeSize());
        this.FVM.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(9, this.HrT);
      paramVarArgs.bC(10, this.HrU);
      AppMethodBeat.o(72529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.HrS != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HrS);
      }
      paramInt = i;
      if (this.FVK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FVK);
      }
      i = paramInt;
      if (this.FVM != null) {
        i = paramInt + f.a.a.a.lI(8, this.FVM.computeSize());
      }
      paramInt = f.a.a.b.b.a.amF(9);
      int j = f.a.a.b.b.a.amF(10);
      AppMethodBeat.o(72529);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfg localcfg = (cfg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(72529);
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
            localcfg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 2: 
          localcfg.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72529);
          return 0;
        case 3: 
          localcfg.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 4: 
          localcfg.HrS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 7: 
          localcfg.FVK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cls();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cls)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfg.FVM = ((cls)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 9: 
          localcfg.HrT = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(72529);
          return 0;
        }
        localcfg.HrU = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(72529);
        return 0;
      }
      AppMethodBeat.o(72529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfg
 * JD-Core Version:    0.7.0.1
 */