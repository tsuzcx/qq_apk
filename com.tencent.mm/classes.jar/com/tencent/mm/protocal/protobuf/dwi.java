package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dwi
  extends cvp
{
  public LinkedList<cwt> FuM;
  public int GwN;
  public String HIQ;
  public int ihf;
  
  public dwi()
  {
    AppMethodBeat.i(148665);
    this.FuM = new LinkedList();
    AppMethodBeat.o(148665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(148666);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ihf);
      paramVarArgs.aS(3, this.GwN);
      paramVarArgs.e(4, 8, this.FuM);
      if (this.HIQ != null) {
        paramVarArgs.d(5, this.HIQ);
      }
      AppMethodBeat.o(148666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ihf) + f.a.a.b.b.a.bz(3, this.GwN) + f.a.a.a.c(4, 8, this.FuM);
      paramInt = i;
      if (this.HIQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HIQ);
      }
      AppMethodBeat.o(148666);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(148666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwi localdwi = (dwi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148666);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148666);
          return 0;
        case 2: 
          localdwi.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148666);
          return 0;
        case 3: 
          localdwi.GwN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148666);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwi.FuM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148666);
          return 0;
        }
        localdwi.HIQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(148666);
        return 0;
      }
      AppMethodBeat.o(148666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwi
 * JD-Core Version:    0.7.0.1
 */