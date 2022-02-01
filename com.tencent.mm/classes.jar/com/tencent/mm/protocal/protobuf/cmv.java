package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cmv
  extends esc
{
  public String UUID;
  public int aaiS;
  public gol aauA;
  public gol aauw;
  public int aaux;
  public gol aauy;
  public String aauz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257348);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257348);
        throw paramVarArgs;
      }
      if (this.aauw == null)
      {
        paramVarArgs = new b("Not all required fields were included: QRCode");
        AppMethodBeat.o(257348);
        throw paramVarArgs;
      }
      if (this.aauy == null)
      {
        paramVarArgs = new b("Not all required fields were included: NotifyKey");
        AppMethodBeat.o(257348);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aauw != null)
      {
        paramVarArgs.qD(2, this.aauw.computeSize());
        this.aauw.writeFields(paramVarArgs);
      }
      if (this.UUID != null) {
        paramVarArgs.g(3, this.UUID);
      }
      paramVarArgs.bS(4, this.aaux);
      if (this.aauy != null)
      {
        paramVarArgs.qD(5, this.aauy.computeSize());
        this.aauy.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.aaiS);
      if (this.aauz != null) {
        paramVarArgs.g(7, this.aauz);
      }
      if (this.aauA != null)
      {
        paramVarArgs.qD(8, this.aauA.computeSize());
        this.aauA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1038;
      }
    }
    label1038:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aauw != null) {
        paramInt = i + i.a.a.a.qC(2, this.aauw.computeSize());
      }
      i = paramInt;
      if (this.UUID != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.UUID);
      }
      i += i.a.a.b.b.a.cJ(4, this.aaux);
      paramInt = i;
      if (this.aauy != null) {
        paramInt = i + i.a.a.a.qC(5, this.aauy.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.aaiS);
      paramInt = i;
      if (this.aauz != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aauz);
      }
      i = paramInt;
      if (this.aauA != null) {
        i = paramInt + i.a.a.a.qC(8, this.aauA.computeSize());
      }
      AppMethodBeat.o(257348);
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
          AppMethodBeat.o(257348);
          throw paramVarArgs;
        }
        if (this.aauw == null)
        {
          paramVarArgs = new b("Not all required fields were included: QRCode");
          AppMethodBeat.o(257348);
          throw paramVarArgs;
        }
        if (this.aauy == null)
        {
          paramVarArgs = new b("Not all required fields were included: NotifyKey");
          AppMethodBeat.o(257348);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257348);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cmv localcmv = (cmv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257348);
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
            localcmv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257348);
          return 0;
        case 2: 
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
            localcmv.aauw = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257348);
          return 0;
        case 3: 
          localcmv.UUID = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257348);
          return 0;
        case 4: 
          localcmv.aaux = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257348);
          return 0;
        case 5: 
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
            localcmv.aauy = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257348);
          return 0;
        case 6: 
          localcmv.aaiS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257348);
          return 0;
        case 7: 
          localcmv.aauz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257348);
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
          localcmv.aauA = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257348);
        return 0;
      }
      AppMethodBeat.o(257348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmv
 * JD-Core Version:    0.7.0.1
 */