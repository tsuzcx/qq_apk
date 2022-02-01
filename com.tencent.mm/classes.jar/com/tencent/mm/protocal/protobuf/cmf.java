package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmf
  extends esc
{
  public com.tencent.mm.bx.b aaui;
  public LinkedList<dhp> aauk;
  
  public cmf()
  {
    AppMethodBeat.i(104808);
    this.aauk = new LinkedList();
    AppMethodBeat.o(104808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104809);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104809);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaui != null) {
        paramVarArgs.d(2, this.aaui);
      }
      paramVarArgs.e(3, 8, this.aauk);
      AppMethodBeat.o(104809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaui != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.aaui);
      }
      paramInt = i.a.a.a.c(3, 8, this.aauk);
      AppMethodBeat.o(104809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aauk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cmf localcmf = (cmf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104809);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcmf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104809);
          return 0;
        case 2: 
          localcmf.aaui = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(104809);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhp)localObject2).parseFrom((byte[])localObject1);
          }
          localcmf.aauk.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104809);
        return 0;
      }
      AppMethodBeat.o(104809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmf
 * JD-Core Version:    0.7.0.1
 */