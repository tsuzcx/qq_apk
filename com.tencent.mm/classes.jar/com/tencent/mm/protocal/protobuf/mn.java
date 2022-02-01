package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class mn
  extends esc
{
  public eff YNL;
  public dyt YNM;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72423);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72423);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.YNL != null)
      {
        paramVarArgs.qD(6, this.YNL.computeSize());
        this.YNL.writeFields(paramVarArgs);
      }
      if (this.YNM != null)
      {
        paramVarArgs.qD(7, this.YNM.computeSize());
        this.YNM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72423);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label712;
      }
    }
    label712:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.YNL != null) {
        i = paramInt + i.a.a.a.qC(6, this.YNL.computeSize());
      }
      paramInt = i;
      if (this.YNM != null) {
        paramInt = i + i.a.a.a.qC(7, this.YNM.computeSize());
      }
      AppMethodBeat.o(72423);
      return paramInt;
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
          AppMethodBeat.o(72423);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        mn localmn = (mn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(72423);
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
            localmn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72423);
          return 0;
        case 2: 
          localmn.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72423);
          return 0;
        case 3: 
          localmn.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72423);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eff();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eff)localObject2).parseFrom((byte[])localObject1);
            }
            localmn.YNL = ((eff)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72423);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dyt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dyt)localObject2).parseFrom((byte[])localObject1);
          }
          localmn.YNM = ((dyt)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72423);
        return 0;
      }
      AppMethodBeat.o(72423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mn
 * JD-Core Version:    0.7.0.1
 */