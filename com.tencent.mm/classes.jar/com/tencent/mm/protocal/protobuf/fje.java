package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fje
  extends esc
{
  public int abJU;
  public int abJV;
  public fiz abJh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118470);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118470);
        throw paramVarArgs;
      }
      if (this.abJh == null)
      {
        paramVarArgs = new b("Not all required fields were included: StoryObject");
        AppMethodBeat.o(118470);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abJh != null)
      {
        paramVarArgs.qD(2, this.abJh.computeSize());
        this.abJh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abJU);
      paramVarArgs.bS(4, this.abJV);
      AppMethodBeat.o(118470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abJh != null) {
        i = paramInt + i.a.a.a.qC(2, this.abJh.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abJU);
      int j = i.a.a.b.b.a.cJ(4, this.abJV);
      AppMethodBeat.o(118470);
      return i + paramInt + j;
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
          AppMethodBeat.o(118470);
          throw paramVarArgs;
        }
        if (this.abJh == null)
        {
          paramVarArgs = new b("Not all required fields were included: StoryObject");
          AppMethodBeat.o(118470);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fje localfje = (fje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118470);
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
            localfje.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118470);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fiz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fiz)localObject2).parseFrom((byte[])localObject1);
            }
            localfje.abJh = ((fiz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118470);
          return 0;
        case 3: 
          localfje.abJU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118470);
          return 0;
        }
        localfje.abJV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118470);
        return 0;
      }
      AppMethodBeat.o(118470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fje
 * JD-Core Version:    0.7.0.1
 */