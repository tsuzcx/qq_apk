package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gey
  extends esc
{
  public gez acct;
  public gez accu;
  public gez accv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121116);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.acct != null)
      {
        paramVarArgs.qD(2, this.acct.computeSize());
        this.acct.writeFields(paramVarArgs);
      }
      if (this.accu != null)
      {
        paramVarArgs.qD(3, this.accu.computeSize());
        this.accu.writeFields(paramVarArgs);
      }
      if (this.accv != null)
      {
        paramVarArgs.qD(4, this.accv.computeSize());
        this.accv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(121116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acct != null) {
        paramInt = i + i.a.a.a.qC(2, this.acct.computeSize());
      }
      i = paramInt;
      if (this.accu != null) {
        i = paramInt + i.a.a.a.qC(3, this.accu.computeSize());
      }
      paramInt = i;
      if (this.accv != null) {
        paramInt = i + i.a.a.a.qC(4, this.accv.computeSize());
      }
      AppMethodBeat.o(121116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(121116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gey localgey = (gey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121116);
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
            localgey.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(121116);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gez();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gez)localObject2).parseFrom((byte[])localObject1);
            }
            localgey.acct = ((gez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(121116);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gez();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gez)localObject2).parseFrom((byte[])localObject1);
            }
            localgey.accu = ((gez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(121116);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gez();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gez)localObject2).parseFrom((byte[])localObject1);
          }
          localgey.accv = ((gez)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(121116);
        return 0;
      }
      AppMethodBeat.o(121116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gey
 * JD-Core Version:    0.7.0.1
 */