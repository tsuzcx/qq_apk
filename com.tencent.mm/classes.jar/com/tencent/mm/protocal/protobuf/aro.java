package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aro
  extends cld
{
  public LinkedList<String> nqc;
  public int nqe;
  public int nqf;
  public int nqg;
  
  public aro()
  {
    AppMethodBeat.i(114018);
    this.nqc = new LinkedList();
    AppMethodBeat.o(114018);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114019);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114019);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.nqc);
      paramVarArgs.aR(3, this.nqe);
      paramVarArgs.aR(4, this.nqf);
      paramVarArgs.aR(5, this.nqg);
      AppMethodBeat.o(114019);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.nqc);
      int j = f.a.a.b.b.a.bA(3, this.nqe);
      int k = f.a.a.b.b.a.bA(4, this.nqf);
      int m = f.a.a.b.b.a.bA(5, this.nqg);
      AppMethodBeat.o(114019);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nqc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114019);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114019);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aro localaro = (aro)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114019);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaro.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114019);
          return 0;
        case 2: 
          localaro.nqc.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(114019);
          return 0;
        case 3: 
          localaro.nqe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114019);
          return 0;
        case 4: 
          localaro.nqf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114019);
          return 0;
        }
        localaro.nqg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(114019);
        return 0;
      }
      AppMethodBeat.o(114019);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aro
 * JD-Core Version:    0.7.0.1
 */