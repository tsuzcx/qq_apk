package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fnq
  extends dyy
{
  public eze ULG;
  public LinkedList<gz> ULH;
  
  public fnq()
  {
    AppMethodBeat.i(179491);
    this.ULH = new LinkedList();
    AppMethodBeat.o(179491);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147825);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(147825);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ULG != null)
      {
        paramVarArgs.oE(2, this.ULG.computeSize());
        this.ULG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.ULH);
      AppMethodBeat.o(147825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ULG != null) {
        i = paramInt + g.a.a.a.oD(2, this.ULG.computeSize());
      }
      paramInt = g.a.a.a.c(3, 8, this.ULH);
      AppMethodBeat.o(147825);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ULH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(147825);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147825);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fnq localfnq = (fnq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147825);
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
            localfnq.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147825);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eze();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eze)localObject2).parseFrom((byte[])localObject1);
            }
            localfnq.ULG = ((eze)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147825);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gz)localObject2).parseFrom((byte[])localObject1);
          }
          localfnq.ULH.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(147825);
        return 0;
      }
      AppMethodBeat.o(147825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnq
 * JD-Core Version:    0.7.0.1
 */