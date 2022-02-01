package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dfs
  extends cvp
{
  public SKBuiltinBuffer_t FAN;
  public String Hud;
  public int nEf;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125783);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125783);
        throw paramVarArgs;
      }
      if (this.FAN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125783);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xcL);
      paramVarArgs.aS(3, this.xcK);
      if (this.FAN != null)
      {
        paramVarArgs.lC(4, this.FAN.computeSize());
        this.FAN.writeFields(paramVarArgs);
      }
      if (this.Hud != null) {
        paramVarArgs.d(5, this.Hud);
      }
      paramVarArgs.aS(6, this.nEf);
      AppMethodBeat.o(125783);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xcL) + f.a.a.b.b.a.bz(3, this.xcK);
      paramInt = i;
      if (this.FAN != null) {
        paramInt = i + f.a.a.a.lB(4, this.FAN.computeSize());
      }
      i = paramInt;
      if (this.Hud != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hud);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.nEf);
      AppMethodBeat.o(125783);
      return i + paramInt;
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
          AppMethodBeat.o(125783);
          throw paramVarArgs;
        }
        if (this.FAN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125783);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125783);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfs localdfs = (dfs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125783);
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
            localdfs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125783);
          return 0;
        case 2: 
          localdfs.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125783);
          return 0;
        case 3: 
          localdfs.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125783);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfs.FAN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125783);
          return 0;
        case 5: 
          localdfs.Hud = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125783);
          return 0;
        }
        localdfs.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125783);
        return 0;
      }
      AppMethodBeat.o(125783);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfs
 * JD-Core Version:    0.7.0.1
 */