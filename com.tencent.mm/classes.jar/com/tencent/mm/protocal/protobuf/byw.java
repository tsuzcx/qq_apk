package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byw
  extends esc
{
  public byt aahT;
  public byu aahU;
  public bqj musicInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257780);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aahT != null)
      {
        paramVarArgs.qD(2, this.aahT.computeSize());
        this.aahT.writeFields(paramVarArgs);
      }
      if (this.aahU != null)
      {
        paramVarArgs.qD(3, this.aahU.computeSize());
        this.aahU.writeFields(paramVarArgs);
      }
      if (this.musicInfo != null)
      {
        paramVarArgs.qD(4, this.musicInfo.computeSize());
        this.musicInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aahT != null) {
        paramInt = i + i.a.a.a.qC(2, this.aahT.computeSize());
      }
      i = paramInt;
      if (this.aahU != null) {
        i = paramInt + i.a.a.a.qC(3, this.aahU.computeSize());
      }
      paramInt = i;
      if (this.musicInfo != null) {
        paramInt = i + i.a.a.a.qC(4, this.musicInfo.computeSize());
      }
      AppMethodBeat.o(257780);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257780);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        byw localbyw = (byw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257780);
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
            localbyw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257780);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byt)localObject2).parseFrom((byte[])localObject1);
            }
            localbyw.aahT = ((byt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257780);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byu)localObject2).parseFrom((byte[])localObject1);
            }
            localbyw.aahU = ((byu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257780);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bqj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bqj)localObject2).parseFrom((byte[])localObject1);
          }
          localbyw.musicInfo = ((bqj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257780);
        return 0;
      }
      AppMethodBeat.o(257780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byw
 * JD-Core Version:    0.7.0.1
 */