package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class ddz
  extends esc
{
  public ddh aaJx;
  public LinkedList<eun> aaJy;
  
  public ddz()
  {
    AppMethodBeat.i(258800);
    this.aaJy = new LinkedList();
    AppMethodBeat.o(258800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123606);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123606);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaJx != null)
      {
        paramVarArgs.qD(2, this.aaJx.computeSize());
        this.aaJx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.aaJy);
      AppMethodBeat.o(123606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaJx != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaJx.computeSize());
      }
      paramInt = i.a.a.a.c(3, 8, this.aaJy);
      AppMethodBeat.o(123606);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaJy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123606);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ddz localddz = (ddz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123606);
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
            localddz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123606);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddh)localObject2).parseFrom((byte[])localObject1);
            }
            localddz.aaJx = ((ddh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123606);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eun();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eun)localObject2).parseFrom((byte[])localObject1);
          }
          localddz.aaJy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123606);
        return 0;
      }
      AppMethodBeat.o(123606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddz
 * JD-Core Version:    0.7.0.1
 */