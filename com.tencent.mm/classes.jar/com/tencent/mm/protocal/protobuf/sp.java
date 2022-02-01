package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class sp
  extends dyy
{
  public LinkedList<Integer> SbY;
  public sm SbZ;
  public LinkedList<sl> Sca;
  
  public sp()
  {
    AppMethodBeat.i(247697);
    this.SbY = new LinkedList();
    this.Sca = new LinkedList();
    AppMethodBeat.o(247697);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247699);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(247699);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.SbY);
      if (this.SbZ != null)
      {
        paramVarArgs.oE(3, this.SbZ.computeSize());
        this.SbZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.Sca);
      AppMethodBeat.o(247699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label647;
      }
    }
    label647:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 2, this.SbY);
      paramInt = i;
      if (this.SbZ != null) {
        paramInt = i + g.a.a.a.oD(3, this.SbZ.computeSize());
      }
      i = g.a.a.a.c(4, 8, this.Sca);
      AppMethodBeat.o(247699);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SbY.clear();
        this.Sca.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(247699);
          throw paramVarArgs;
        }
        AppMethodBeat.o(247699);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        sp localsp = (sp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(247699);
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
            localsp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(247699);
          return 0;
        case 2: 
          localsp.SbY.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
          AppMethodBeat.o(247699);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sm)localObject2).parseFrom((byte[])localObject1);
            }
            localsp.SbZ = ((sm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(247699);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new sl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((sl)localObject2).parseFrom((byte[])localObject1);
          }
          localsp.Sca.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(247699);
        return 0;
      }
      AppMethodBeat.o(247699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sp
 * JD-Core Version:    0.7.0.1
 */