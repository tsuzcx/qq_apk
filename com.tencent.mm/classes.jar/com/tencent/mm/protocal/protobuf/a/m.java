package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class m
  extends esc
{
  public a acje;
  public boolean acjf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259695);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.acje != null)
      {
        paramVarArgs.qD(2, this.acje.computeSize());
        this.acje.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.acjf);
      AppMethodBeat.o(259695);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acje != null) {
        i = paramInt + i.a.a.a.qC(2, this.acje.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(259695);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259695);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259695);
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
            localm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259695);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localm.acje = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259695);
          return 0;
        }
        localm.acjf = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(259695);
        return 0;
      }
      AppMethodBeat.o(259695);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.m
 * JD-Core Version:    0.7.0.1
 */