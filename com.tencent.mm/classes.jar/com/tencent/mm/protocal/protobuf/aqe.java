package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aqe
  extends cld
{
  public bhf Drm;
  public String Drn;
  public bha Dro;
  public int result;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82408);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Drm != null)
      {
        paramVarArgs.kX(2, this.Drm.computeSize());
        this.Drm.writeFields(paramVarArgs);
      }
      if (this.Drn != null) {
        paramVarArgs.d(3, this.Drn);
      }
      if (this.Dro != null)
      {
        paramVarArgs.kX(4, this.Dro.computeSize());
        this.Dro.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.result);
      AppMethodBeat.o(82408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Drm != null) {
        paramInt = i + f.a.a.a.kW(2, this.Drm.computeSize());
      }
      i = paramInt;
      if (this.Drn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Drn);
      }
      paramInt = i;
      if (this.Dro != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dro.computeSize());
      }
      i = f.a.a.b.b.a.bA(5, this.result);
      AppMethodBeat.o(82408);
      return paramInt + i;
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
          AppMethodBeat.o(82408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqe localaqe = (aqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82408);
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
            localaqe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqe.Drm = ((bhf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        case 3: 
          localaqe.Drn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82408);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bha();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bha)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqe.Dro = ((bha)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82408);
          return 0;
        }
        localaqe.result = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(82408);
        return 0;
      }
      AppMethodBeat.o(82408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqe
 * JD-Core Version:    0.7.0.1
 */