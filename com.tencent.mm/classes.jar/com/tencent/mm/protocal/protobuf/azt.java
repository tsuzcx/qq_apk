package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azt
  extends esc
{
  public bmy ZKs;
  public FinderContact ZKt;
  public bkk live_notice_info;
  public bkl live_notice_list_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259080);
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
      if (this.ZKs != null)
      {
        paramVarArgs.qD(3, this.ZKs.computeSize());
        this.ZKs.writeFields(paramVarArgs);
      }
      if (this.ZKt != null)
      {
        paramVarArgs.qD(4, this.ZKt.computeSize());
        this.ZKt.writeFields(paramVarArgs);
      }
      if (this.live_notice_list_info != null)
      {
        paramVarArgs.qD(5, this.live_notice_list_info.computeSize());
        this.live_notice_list_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label812;
      }
    }
    label812:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.live_notice_info != null) {
        paramInt = i + i.a.a.a.qC(2, this.live_notice_info.computeSize());
      }
      i = paramInt;
      if (this.ZKs != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZKs.computeSize());
      }
      paramInt = i;
      if (this.ZKt != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZKt.computeSize());
      }
      i = paramInt;
      if (this.live_notice_list_info != null) {
        i = paramInt + i.a.a.a.qC(5, this.live_notice_list_info.computeSize());
      }
      AppMethodBeat.o(259080);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259080);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azt localazt = (azt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259080);
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
            localazt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259080);
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
            localazt.live_notice_info = ((bkk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259080);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmy)localObject2).parseFrom((byte[])localObject1);
            }
            localazt.ZKs = ((bmy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259080);
          return 0;
        case 4: 
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
            localazt.ZKt = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259080);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bkl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bkl)localObject2).parseFrom((byte[])localObject1);
          }
          localazt.live_notice_list_info = ((bkl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259080);
        return 0;
      }
      AppMethodBeat.o(259080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azt
 * JD-Core Version:    0.7.0.1
 */