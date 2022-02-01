package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cem
  extends dyy
{
  public eze Tmb;
  public LinkedList<eyx> Tmc;
  public int Tmd;
  
  public cem()
  {
    AppMethodBeat.i(82419);
    this.Tmc = new LinkedList();
    AppMethodBeat.o(82419);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82420);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82420);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tmb != null)
      {
        paramVarArgs.oE(2, this.Tmb.computeSize());
        this.Tmb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Tmc);
      paramVarArgs.aY(4, this.Tmd);
      AppMethodBeat.o(82420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label632;
      }
    }
    label632:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tmb != null) {
        i = paramInt + g.a.a.a.oD(2, this.Tmb.computeSize());
      }
      paramInt = g.a.a.a.c(3, 8, this.Tmc);
      int j = g.a.a.b.b.a.bM(4, this.Tmd);
      AppMethodBeat.o(82420);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tmc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cem localcem = (cem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82420);
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
            localcem.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82420);
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
            localcem.Tmb = ((eze)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82420);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eyx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eyx)localObject2).parseFrom((byte[])localObject1);
            }
            localcem.Tmc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82420);
          return 0;
        }
        localcem.Tmd = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(82420);
        return 0;
      }
      AppMethodBeat.o(82420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cem
 * JD-Core Version:    0.7.0.1
 */