package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class baf
  extends esc
{
  public b AyB;
  public bph ZLd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168989);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZLd != null)
      {
        paramVarArgs.qD(2, this.ZLd.computeSize());
        this.ZLd.writeFields(paramVarArgs);
      }
      if (this.AyB != null) {
        paramVarArgs.d(3, this.AyB);
      }
      AppMethodBeat.o(168989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZLd != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZLd.computeSize());
      }
      i = paramInt;
      if (this.AyB != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.AyB);
      }
      AppMethodBeat.o(168989);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168989);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        baf localbaf = (baf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168989);
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
            localbaf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168989);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bph();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bph)localObject2).parseFrom((byte[])localObject1);
            }
            localbaf.ZLd = ((bph)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168989);
          return 0;
        }
        localbaf.AyB = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(168989);
        return 0;
      }
      AppMethodBeat.o(168989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baf
 * JD-Core Version:    0.7.0.1
 */