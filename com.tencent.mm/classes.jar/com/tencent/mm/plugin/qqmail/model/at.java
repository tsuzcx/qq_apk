package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class at
  extends esc
{
  public al Nlp;
  public ax Nlq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267052);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Nlp != null)
      {
        paramVarArgs.qD(2, this.Nlp.computeSize());
        this.Nlp.writeFields(paramVarArgs);
      }
      if (this.Nlq != null)
      {
        paramVarArgs.qD(3, this.Nlq.computeSize());
        this.Nlq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(267052);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nlp != null) {
        paramInt = i + i.a.a.a.qC(2, this.Nlp.computeSize());
      }
      i = paramInt;
      if (this.Nlq != null) {
        i = paramInt + i.a.a.a.qC(3, this.Nlq.computeSize());
      }
      AppMethodBeat.o(267052);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267052);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        at localat = (at)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267052);
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
            localat.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267052);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new al();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((al)localObject2).parseFrom((byte[])localObject1);
            }
            localat.Nlp = ((al)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(267052);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ax();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ax)localObject2).parseFrom((byte[])localObject1);
          }
          localat.Nlq = ((ax)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(267052);
        return 0;
      }
      AppMethodBeat.o(267052);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.at
 * JD-Core Version:    0.7.0.1
 */