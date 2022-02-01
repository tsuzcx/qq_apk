package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cqg
  extends esc
{
  public ejc aawL;
  public eja aawM;
  public int muC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155413);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.aawL == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQGroup");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.aawM == null)
      {
        paramVarArgs = new b("Not all required fields were included: QQFriend");
        AppMethodBeat.o(155413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.muC);
      if (this.aawL != null)
      {
        paramVarArgs.qD(3, this.aawL.computeSize());
        this.aawL.writeFields(paramVarArgs);
      }
      if (this.aawM != null)
      {
        paramVarArgs.qD(4, this.aawM.computeSize());
        this.aawM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label736;
      }
    }
    label736:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.muC);
      paramInt = i;
      if (this.aawL != null) {
        paramInt = i + i.a.a.a.qC(3, this.aawL.computeSize());
      }
      i = paramInt;
      if (this.aawM != null) {
        i = paramInt + i.a.a.a.qC(4, this.aawM.computeSize());
      }
      AppMethodBeat.o(155413);
      return i;
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
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.aawL == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQGroup");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        if (this.aawM == null)
        {
          paramVarArgs = new b("Not all required fields were included: QQFriend");
          AppMethodBeat.o(155413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cqg localcqg = (cqg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155413);
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
            localcqg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        case 2: 
          localcqg.muC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155413);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejc)localObject2).parseFrom((byte[])localObject1);
            }
            localcqg.aawL = ((ejc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155413);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eja();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eja)localObject2).parseFrom((byte[])localObject1);
          }
          localcqg.aawM = ((eja)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155413);
        return 0;
      }
      AppMethodBeat.o(155413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqg
 * JD-Core Version:    0.7.0.1
 */