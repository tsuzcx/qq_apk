package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aqz
  extends esc
{
  public String Njp;
  public String YFk;
  public LinkedList<ara> YFm;
  public int lyF;
  
  public aqz()
  {
    AppMethodBeat.i(32208);
    this.YFm = new LinkedList();
    AppMethodBeat.o(32208);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32209);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32209);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Njp != null) {
        paramVarArgs.g(2, this.Njp);
      }
      paramVarArgs.bS(3, this.lyF);
      paramVarArgs.e(4, 8, this.YFm);
      if (this.YFk != null) {
        paramVarArgs.g(5, this.YFk);
      }
      AppMethodBeat.o(32209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label629;
      }
    }
    label629:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Njp != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Njp);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.lyF) + i.a.a.a.c(4, 8, this.YFm);
      paramInt = i;
      if (this.YFk != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YFk);
      }
      AppMethodBeat.o(32209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32209);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aqz localaqz = (aqz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32209);
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
            localaqz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32209);
          return 0;
        case 2: 
          localaqz.Njp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32209);
          return 0;
        case 3: 
          localaqz.lyF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32209);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ara();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ara)localObject2).parseFrom((byte[])localObject1);
            }
            localaqz.YFm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32209);
          return 0;
        }
        localaqz.YFk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32209);
        return 0;
      }
      AppMethodBeat.o(32209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqz
 * JD-Core Version:    0.7.0.1
 */