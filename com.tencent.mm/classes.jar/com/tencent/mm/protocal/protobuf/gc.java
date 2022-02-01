package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gc
  extends cvp
{
  public com.tencent.mm.bx.b Fyh;
  public int Fym;
  public int Fyn;
  public gh Fyo;
  public gd Fyp;
  
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Fym);
      paramVarArgs.aS(3, this.Fyn);
      if (this.Fyh != null) {
        paramVarArgs.c(4, this.Fyh);
      }
      if (this.Fyo != null)
      {
        paramVarArgs.lC(5, this.Fyo.computeSize());
        this.Fyo.writeFields(paramVarArgs);
      }
      if (this.Fyp != null)
      {
        paramVarArgs.lC(6, this.Fyp.computeSize());
        this.Fyp.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Fym) + f.a.a.b.b.a.bz(3, this.Fyn);
      paramInt = i;
      if (this.Fyh != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Fyh);
      }
      i = paramInt;
      if (this.Fyo != null) {
        i = paramInt + f.a.a.a.lB(5, this.Fyo.computeSize());
      }
      paramInt = i;
      if (this.Fyp != null) {
        paramInt = i + f.a.a.a.lB(6, this.Fyp.computeSize());
      }
      AppMethodBeat.o(32119);
      return paramInt;
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
        gc localgc = (gc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32119);
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
            localgc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        case 2: 
          localgc.Fym = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32119);
          return 0;
        case 3: 
          localgc.Fyn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32119);
          return 0;
        case 4: 
          localgc.Fyh = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(32119);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgc.Fyo = ((gh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgc.Fyp = ((gd)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gc
 * JD-Core Version:    0.7.0.1
 */