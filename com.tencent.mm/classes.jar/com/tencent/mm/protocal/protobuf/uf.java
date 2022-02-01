package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class uf
  extends esc
{
  public LinkedList<Integer> YZR;
  public uc YZS;
  public LinkedList<ub> YZm;
  
  public uf()
  {
    AppMethodBeat.i(259164);
    this.YZR = new LinkedList();
    this.YZm = new LinkedList();
    AppMethodBeat.o(259164);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259169);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259169);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.YZR);
      if (this.YZS != null)
      {
        paramVarArgs.qD(3, this.YZS.computeSize());
        this.YZS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.YZm);
      AppMethodBeat.o(259169);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label643;
      }
    }
    label643:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 2, this.YZR);
      paramInt = i;
      if (this.YZS != null) {
        paramInt = i + i.a.a.a.qC(3, this.YZS.computeSize());
      }
      i = i.a.a.a.c(4, 8, this.YZm);
      AppMethodBeat.o(259169);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YZR.clear();
        this.YZm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(259169);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259169);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        uf localuf = (uf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259169);
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
            localuf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259169);
          return 0;
        case 2: 
          localuf.YZR.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(259169);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uc)localObject2).parseFrom((byte[])localObject1);
            }
            localuf.YZS = ((uc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259169);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ub();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ub)localObject2).parseFrom((byte[])localObject1);
          }
          localuf.YZm.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259169);
        return 0;
      }
      AppMethodBeat.o(259169);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uf
 * JD-Core Version:    0.7.0.1
 */