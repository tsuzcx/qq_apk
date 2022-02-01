package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aox
  extends cld
{
  public bhi DqF;
  public bhj DqG;
  public int dmD;
  public String dmE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72477);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dmD);
      if (this.dmE != null) {
        paramVarArgs.d(3, this.dmE);
      }
      if (this.DqF != null)
      {
        paramVarArgs.kX(4, this.DqF.computeSize());
        this.DqF.writeFields(paramVarArgs);
      }
      if (this.DqG != null)
      {
        paramVarArgs.kX(5, this.DqG.computeSize());
        this.DqG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dmD);
      paramInt = i;
      if (this.dmE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dmE);
      }
      i = paramInt;
      if (this.DqF != null) {
        i = paramInt + f.a.a.a.kW(4, this.DqF.computeSize());
      }
      paramInt = i;
      if (this.DqG != null) {
        paramInt = i + f.a.a.a.kW(5, this.DqG.computeSize());
      }
      AppMethodBeat.o(72477);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72477);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aox localaox = (aox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72477);
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
            localaox.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72477);
          return 0;
        case 2: 
          localaox.dmD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72477);
          return 0;
        case 3: 
          localaox.dmE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72477);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaox.DqF = ((bhi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72477);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bhj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bhj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaox.DqG = ((bhj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72477);
        return 0;
      }
      AppMethodBeat.o(72477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aox
 * JD-Core Version:    0.7.0.1
 */