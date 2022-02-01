package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dyh
  extends esc
{
  public int BeA;
  public gol abdy;
  public adx abdz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152656);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152656);
        throw paramVarArgs;
      }
      if (this.abdz == null)
      {
        paramVarArgs = new b("Not all required fields were included: cmd_list");
        AppMethodBeat.o(152656);
        throw paramVarArgs;
      }
      if (this.abdy == null)
      {
        paramVarArgs = new b("Not all required fields were included: key_buf");
        AppMethodBeat.o(152656);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abdz != null)
      {
        paramVarArgs.qD(2, this.abdz.computeSize());
        this.abdz.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.BeA);
      if (this.abdy != null)
      {
        paramVarArgs.qD(4, this.abdy.computeSize());
        this.abdy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152656);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label736;
      }
    }
    label736:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abdz != null) {
        i = paramInt + i.a.a.a.qC(2, this.abdz.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.BeA);
      paramInt = i;
      if (this.abdy != null) {
        paramInt = i + i.a.a.a.qC(4, this.abdy.computeSize());
      }
      AppMethodBeat.o(152656);
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
          AppMethodBeat.o(152656);
          throw paramVarArgs;
        }
        if (this.abdz == null)
        {
          paramVarArgs = new b("Not all required fields were included: cmd_list");
          AppMethodBeat.o(152656);
          throw paramVarArgs;
        }
        if (this.abdy == null)
        {
          paramVarArgs = new b("Not all required fields were included: key_buf");
          AppMethodBeat.o(152656);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152656);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dyh localdyh = (dyh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152656);
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
            localdyh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152656);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adx)localObject2).parseFrom((byte[])localObject1);
            }
            localdyh.abdz = ((adx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152656);
          return 0;
        case 3: 
          localdyh.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152656);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localdyh.abdy = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152656);
        return 0;
      }
      AppMethodBeat.o(152656);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyh
 * JD-Core Version:    0.7.0.1
 */