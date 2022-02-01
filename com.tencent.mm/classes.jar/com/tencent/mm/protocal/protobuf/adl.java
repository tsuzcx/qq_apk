package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class adl
  extends esc
{
  public String Vbl;
  public dkf ifY;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91421);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91421);
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
      if (this.ifY != null)
      {
        paramVarArgs.qD(99, this.ifY.computeSize());
        this.ifY.writeFields(paramVarArgs);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.ifY != null) {
        i = paramInt + i.a.a.a.qC(99, this.ifY.computeSize());
      }
      paramInt = i;
      if (this.Vbl != null) {
        paramInt = i + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91421);
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
          AppMethodBeat.o(91421);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        adl localadl = (adl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91421);
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
            localadl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91421);
          return 0;
        case 2: 
          localadl.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91421);
          return 0;
        case 3: 
          localadl.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91421);
          return 0;
        case 99: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkf)localObject2).parseFrom((byte[])localObject1);
            }
            localadl.ifY = ((dkf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91421);
          return 0;
        }
        localadl.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91421);
        return 0;
      }
      AppMethodBeat.o(91421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adl
 * JD-Core Version:    0.7.0.1
 */