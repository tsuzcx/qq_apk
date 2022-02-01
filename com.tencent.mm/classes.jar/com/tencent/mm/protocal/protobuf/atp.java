package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atp
  extends esc
{
  public FinderContact ZEd;
  public String ZEe;
  public dzk entranceInfo;
  public String tgw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258212);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZEd != null)
      {
        paramVarArgs.qD(2, this.ZEd.computeSize());
        this.ZEd.writeFields(paramVarArgs);
      }
      if (this.tgw != null) {
        paramVarArgs.g(3, this.tgw);
      }
      if (this.ZEe != null) {
        paramVarArgs.g(4, this.ZEe);
      }
      if (this.entranceInfo != null)
      {
        paramVarArgs.qD(5, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258212);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label668;
      }
    }
    label668:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZEd != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEd.computeSize());
      }
      i = paramInt;
      if (this.tgw != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.tgw);
      }
      paramInt = i;
      if (this.ZEe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZEe);
      }
      i = paramInt;
      if (this.entranceInfo != null) {
        i = paramInt + i.a.a.a.qC(5, this.entranceInfo.computeSize());
      }
      AppMethodBeat.o(258212);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258212);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        atp localatp = (atp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258212);
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
            localatp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258212);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localatp.ZEd = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258212);
          return 0;
        case 3: 
          localatp.tgw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258212);
          return 0;
        case 4: 
          localatp.ZEe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258212);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzk)localObject2).parseFrom((byte[])localObject1);
          }
          localatp.entranceInfo = ((dzk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258212);
        return 0;
      }
      AppMethodBeat.o(258212);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atp
 * JD-Core Version:    0.7.0.1
 */