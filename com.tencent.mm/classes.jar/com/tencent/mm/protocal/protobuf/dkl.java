package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkl
  extends cvp
{
  public int Fzq;
  public String Gbt;
  public he HqD;
  public hi Hzb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123658);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123658);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HqD != null)
      {
        paramVarArgs.lC(2, this.HqD.computeSize());
        this.HqD.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Fzq);
      if (this.Hzb != null)
      {
        paramVarArgs.lC(4, this.Hzb.computeSize());
        this.Hzb.writeFields(paramVarArgs);
      }
      if (this.Gbt != null) {
        paramVarArgs.d(5, this.Gbt);
      }
      AppMethodBeat.o(123658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HqD != null) {
        i = paramInt + f.a.a.a.lB(2, this.HqD.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.Fzq);
      paramInt = i;
      if (this.Hzb != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hzb.computeSize());
      }
      i = paramInt;
      if (this.Gbt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gbt);
      }
      AppMethodBeat.o(123658);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123658);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkl localdkl = (dkl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123658);
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
            localdkl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new he();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((he)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkl.HqD = ((he)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 3: 
          localdkl.Fzq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123658);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkl.Hzb = ((hi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        }
        localdkl.Gbt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123658);
        return 0;
      }
      AppMethodBeat.o(123658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkl
 * JD-Core Version:    0.7.0.1
 */