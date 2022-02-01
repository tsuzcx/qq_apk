package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ft
  extends cld
{
  public fu CAA;
  public com.tencent.mm.bx.b CAs;
  public int CAx;
  public int CAy;
  public fy CAz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32119);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CAx);
      paramVarArgs.aR(3, this.CAy);
      if (this.CAs != null) {
        paramVarArgs.c(4, this.CAs);
      }
      if (this.CAz != null)
      {
        paramVarArgs.kX(5, this.CAz.computeSize());
        this.CAz.writeFields(paramVarArgs);
      }
      if (this.CAA != null)
      {
        paramVarArgs.kX(6, this.CAA.computeSize());
        this.CAA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CAx) + f.a.a.b.b.a.bA(3, this.CAy);
      paramInt = i;
      if (this.CAs != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.CAs);
      }
      i = paramInt;
      if (this.CAz != null) {
        i = paramInt + f.a.a.a.kW(5, this.CAz.computeSize());
      }
      paramInt = i;
      if (this.CAA != null) {
        paramInt = i + f.a.a.a.kW(6, this.CAA.computeSize());
      }
      AppMethodBeat.o(32119);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ft localft = (ft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32119);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localft.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        case 2: 
          localft.CAx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32119);
          return 0;
        case 3: 
          localft.CAy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32119);
          return 0;
        case 4: 
          localft.CAs = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(32119);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localft.CAz = ((fy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localft.CAA = ((fu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      AppMethodBeat.o(32119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ft
 * JD-Core Version:    0.7.0.1
 */