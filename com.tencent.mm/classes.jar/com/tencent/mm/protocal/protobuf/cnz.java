package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnz
  extends esc
{
  public fnb aavj;
  public String aavk;
  public boolean aavl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176146);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(176146);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aavj != null)
      {
        paramVarArgs.qD(2, this.aavj.computeSize());
        this.aavj.writeFields(paramVarArgs);
      }
      if (this.aavk != null) {
        paramVarArgs.g(3, this.aavk);
      }
      paramVarArgs.di(4, this.aavl);
      AppMethodBeat.o(176146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aavj != null) {
        paramInt = i + i.a.a.a.qC(2, this.aavj.computeSize());
      }
      i = paramInt;
      if (this.aavk != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aavk);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(176146);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(176146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(176146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnz localcnz = (cnz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(176146);
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
            localcnz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(176146);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnb)localObject2).parseFrom((byte[])localObject1);
            }
            localcnz.aavj = ((fnb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(176146);
          return 0;
        case 3: 
          localcnz.aavk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(176146);
          return 0;
        }
        localcnz.aavl = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(176146);
        return 0;
      }
      AppMethodBeat.o(176146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnz
 * JD-Core Version:    0.7.0.1
 */