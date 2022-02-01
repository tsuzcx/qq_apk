package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class frg
  extends esc
{
  public int abQP;
  public hw abQQ;
  public ba abQR;
  public dtt abQS;
  public is abQT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133205);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133205);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abQP);
      if (this.abQQ != null)
      {
        paramVarArgs.qD(3, this.abQQ.computeSize());
        this.abQQ.writeFields(paramVarArgs);
      }
      if (this.abQR != null)
      {
        paramVarArgs.qD(4, this.abQR.computeSize());
        this.abQR.writeFields(paramVarArgs);
      }
      if (this.abQS != null)
      {
        paramVarArgs.qD(5, this.abQS.computeSize());
        this.abQS.writeFields(paramVarArgs);
      }
      if (this.abQT != null)
      {
        paramVarArgs.qD(6, this.abQT.computeSize());
        this.abQT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label908;
      }
    }
    label908:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abQP);
      paramInt = i;
      if (this.abQQ != null) {
        paramInt = i + i.a.a.a.qC(3, this.abQQ.computeSize());
      }
      i = paramInt;
      if (this.abQR != null) {
        i = paramInt + i.a.a.a.qC(4, this.abQR.computeSize());
      }
      paramInt = i;
      if (this.abQS != null) {
        paramInt = i + i.a.a.a.qC(5, this.abQS.computeSize());
      }
      i = paramInt;
      if (this.abQT != null) {
        i = paramInt + i.a.a.a.qC(6, this.abQT.computeSize());
      }
      AppMethodBeat.o(133205);
      return i;
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
          AppMethodBeat.o(133205);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        frg localfrg = (frg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133205);
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
            localfrg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 2: 
          localfrg.abQP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133205);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hw)localObject2).parseFrom((byte[])localObject1);
            }
            localfrg.abQQ = ((hw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ba();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ba)localObject2).parseFrom((byte[])localObject1);
            }
            localfrg.abQR = ((ba)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtt)localObject2).parseFrom((byte[])localObject1);
            }
            localfrg.abQS = ((dtt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new is();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((is)localObject2).parseFrom((byte[])localObject1);
          }
          localfrg.abQT = ((is)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      AppMethodBeat.o(133205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.frg
 * JD-Core Version:    0.7.0.1
 */