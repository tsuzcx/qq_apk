package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fji
  extends esc
{
  public int YYp;
  public gol ZdD;
  public adx ZdG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118474);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118474);
        throw paramVarArgs;
      }
      if (this.ZdG == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(118474);
        throw paramVarArgs;
      }
      if (this.ZdD == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(118474);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZdG != null)
      {
        paramVarArgs.qD(2, this.ZdG.computeSize());
        this.ZdG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YYp);
      if (this.ZdD != null)
      {
        paramVarArgs.qD(4, this.ZdD.computeSize());
        this.ZdD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118474);
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
      if (this.ZdG != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZdG.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.YYp);
      paramInt = i;
      if (this.ZdD != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZdD.computeSize());
      }
      AppMethodBeat.o(118474);
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
          AppMethodBeat.o(118474);
          throw paramVarArgs;
        }
        if (this.ZdG == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(118474);
          throw paramVarArgs;
        }
        if (this.ZdD == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(118474);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fji localfji = (fji)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118474);
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
            localfji.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118474);
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
            localfji.ZdG = ((adx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118474);
          return 0;
        case 3: 
          localfji.YYp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118474);
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
          localfji.ZdD = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118474);
        return 0;
      }
      AppMethodBeat.o(118474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fji
 * JD-Core Version:    0.7.0.1
 */