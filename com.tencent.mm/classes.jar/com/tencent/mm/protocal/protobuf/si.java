package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class si
  extends esc
{
  public sg OhT;
  public apv Oia;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91371);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91371);
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
      if (this.OhT != null)
      {
        paramVarArgs.qD(4, this.OhT.computeSize());
        this.OhT.writeFields(paramVarArgs);
      }
      if (this.Oia != null)
      {
        paramVarArgs.qD(5, this.Oia.computeSize());
        this.Oia.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label700;
      }
    }
    label700:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.OhT != null) {
        i = paramInt + i.a.a.a.qC(4, this.OhT.computeSize());
      }
      paramInt = i;
      if (this.Oia != null) {
        paramInt = i + i.a.a.a.qC(5, this.Oia.computeSize());
      }
      AppMethodBeat.o(91371);
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
          AppMethodBeat.o(91371);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        si localsi = (si)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91371);
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
            localsi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91371);
          return 0;
        case 2: 
          localsi.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91371);
          return 0;
        case 3: 
          localsi.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91371);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sg)localObject2).parseFrom((byte[])localObject1);
            }
            localsi.OhT = ((sg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91371);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new apv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((apv)localObject2).parseFrom((byte[])localObject1);
          }
          localsi.Oia = ((apv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91371);
        return 0;
      }
      AppMethodBeat.o(91371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.si
 * JD-Core Version:    0.7.0.1
 */