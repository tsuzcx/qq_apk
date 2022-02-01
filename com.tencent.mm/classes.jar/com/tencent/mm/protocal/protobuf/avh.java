package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class avh
  extends dyy
{
  public bei SHF;
  public b xaw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168989);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SHF != null)
      {
        paramVarArgs.oE(2, this.SHF.computeSize());
        this.SHF.writeFields(paramVarArgs);
      }
      if (this.xaw != null) {
        paramVarArgs.c(3, this.xaw);
      }
      AppMethodBeat.o(168989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label482;
      }
    }
    label482:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SHF != null) {
        paramInt = i + g.a.a.a.oD(2, this.SHF.computeSize());
      }
      i = paramInt;
      if (this.xaw != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.xaw);
      }
      AppMethodBeat.o(168989);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168989);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avh localavh = (avh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168989);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localavh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168989);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bei();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bei)localObject2).parseFrom((byte[])localObject1);
            }
            localavh.SHF = ((bei)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168989);
          return 0;
        }
        localavh.xaw = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(168989);
        return 0;
      }
      AppMethodBeat.o(168989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avh
 * JD-Core Version:    0.7.0.1
 */