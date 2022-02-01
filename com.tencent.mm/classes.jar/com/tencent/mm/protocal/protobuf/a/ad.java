package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class ad
  extends esc
{
  public boolean aavs;
  public LinkedList<ab> acja;
  
  public ad()
  {
    AppMethodBeat.i(259709);
    this.acja = new LinkedList();
    AppMethodBeat.o(259709);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259714);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.aavs);
      paramVarArgs.e(3, 8, this.acja);
      AppMethodBeat.o(259714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.a.c(3, 8, this.acja);
      AppMethodBeat.o(259714);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acja.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259714);
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
            localad.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259714);
          return 0;
        case 2: 
          localad.aavs = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(259714);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ab();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ab)localObject2).parseFrom((byte[])localObject1);
          }
          localad.acja.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259714);
        return 0;
      }
      AppMethodBeat.o(259714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.ad
 * JD-Core Version:    0.7.0.1
 */