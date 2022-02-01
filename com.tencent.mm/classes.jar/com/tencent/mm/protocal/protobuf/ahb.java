package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ahb
  extends esc
{
  public boolean YII;
  public String YIJ;
  public dio Zqe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259291);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259291);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Zqe != null)
      {
        paramVarArgs.qD(2, this.Zqe.computeSize());
        this.Zqe.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.YII);
      if (this.YIJ != null) {
        paramVarArgs.g(4, this.YIJ);
      }
      AppMethodBeat.o(259291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zqe != null) {
        i = paramInt + i.a.a.a.qC(2, this.Zqe.computeSize());
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.YIJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIJ);
      }
      AppMethodBeat.o(259291);
      return paramInt;
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
          AppMethodBeat.o(259291);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259291);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ahb localahb = (ahb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259291);
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
            localahb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259291);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dio();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dio)localObject2).parseFrom((byte[])localObject1);
            }
            localahb.Zqe = ((dio)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259291);
          return 0;
        case 3: 
          localahb.YII = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259291);
          return 0;
        }
        localahb.YIJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259291);
        return 0;
      }
      AppMethodBeat.o(259291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahb
 * JD-Core Version:    0.7.0.1
 */