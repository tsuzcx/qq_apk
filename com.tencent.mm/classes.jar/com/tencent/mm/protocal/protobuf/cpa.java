package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpa
  extends cwj
{
  public String DkG;
  public cls FVM;
  public String HAK;
  public LinkedList<ir> HAL;
  public int oGt;
  public String oGu;
  
  public cpa()
  {
    AppMethodBeat.i(72553);
    this.HAL = new LinkedList();
    AppMethodBeat.o(72553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72554);
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
      if (this.HAK != null) {
        paramVarArgs.d(4, this.HAK);
      }
      paramVarArgs.e(5, 8, this.HAL);
      if (this.FVM != null)
      {
        paramVarArgs.lJ(6, this.FVM.computeSize());
        this.FVM.writeFields(paramVarArgs);
      }
      if (this.DkG != null) {
        paramVarArgs.d(7, this.DkG);
      }
      AppMethodBeat.o(72554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.HAK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HAK);
      }
      i += f.a.a.a.c(5, 8, this.HAL);
      paramInt = i;
      if (this.FVM != null) {
        paramInt = i + f.a.a.a.lI(6, this.FVM.computeSize());
      }
      i = paramInt;
      if (this.DkG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DkG);
      }
      AppMethodBeat.o(72554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HAL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpa localcpa = (cpa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72554);
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
            localcpa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 2: 
          localcpa.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72554);
          return 0;
        case 3: 
          localcpa.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 4: 
          localcpa.HAK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpa.HAL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cls();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cls)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpa.FVM = ((cls)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        }
        localcpa.DkG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72554);
        return 0;
      }
      AppMethodBeat.o(72554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpa
 * JD-Core Version:    0.7.0.1
 */