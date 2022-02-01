package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bkn
  extends esc
{
  public String YKR;
  public b ZTN;
  public bkk live_notice_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259542);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.live_notice_info != null)
      {
        paramVarArgs.qD(2, this.live_notice_info.computeSize());
        this.live_notice_info.writeFields(paramVarArgs);
      }
      if (this.ZTN != null) {
        paramVarArgs.d(3, this.ZTN);
      }
      if (this.YKR != null) {
        paramVarArgs.g(4, this.YKR);
      }
      AppMethodBeat.o(259542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.live_notice_info != null) {
        paramInt = i + i.a.a.a.qC(2, this.live_notice_info.computeSize());
      }
      i = paramInt;
      if (this.ZTN != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZTN);
      }
      paramInt = i;
      if (this.YKR != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YKR);
      }
      AppMethodBeat.o(259542);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bkn localbkn = (bkn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259542);
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
            localbkn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259542);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkk)localObject2).parseFrom((byte[])localObject1);
            }
            localbkn.live_notice_info = ((bkk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259542);
          return 0;
        case 3: 
          localbkn.ZTN = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259542);
          return 0;
        }
        localbkn.YKR = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259542);
        return 0;
      }
      AppMethodBeat.o(259542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkn
 * JD-Core Version:    0.7.0.1
 */