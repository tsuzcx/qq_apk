package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dtz
  extends esc
{
  public int GroupCount;
  public LinkedList<caj> GroupList;
  public LinkedList<duc> ILu;
  public int aaZx;
  
  public dtz()
  {
    AppMethodBeat.i(155443);
    this.ILu = new LinkedList();
    this.GroupList = new LinkedList();
    AppMethodBeat.o(155443);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155444);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155444);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaZx);
      paramVarArgs.e(3, 8, this.ILu);
      paramVarArgs.bS(4, this.GroupCount);
      paramVarArgs.e(5, 8, this.GroupList);
      AppMethodBeat.o(155444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label664;
      }
    }
    label664:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaZx);
      int j = i.a.a.a.c(3, 8, this.ILu);
      int k = i.a.a.b.b.a.cJ(4, this.GroupCount);
      int m = i.a.a.a.c(5, 8, this.GroupList);
      AppMethodBeat.o(155444);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ILu.clear();
        this.GroupList.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155444);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dtz localdtz = (dtz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155444);
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
            localdtz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155444);
          return 0;
        case 2: 
          localdtz.aaZx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155444);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duc)localObject2).parseFrom((byte[])localObject1);
            }
            localdtz.ILu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155444);
          return 0;
        case 4: 
          localdtz.GroupCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155444);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new caj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((caj)localObject2).parseFrom((byte[])localObject1);
          }
          localdtz.GroupList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155444);
        return 0;
      }
      AppMethodBeat.o(155444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtz
 * JD-Core Version:    0.7.0.1
 */