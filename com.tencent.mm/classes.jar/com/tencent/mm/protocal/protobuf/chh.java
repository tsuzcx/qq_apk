package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class chh
  extends esc
{
  public String aaqe;
  public zg aaqf;
  public int vgK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101815);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.aaqf == null)
      {
        paramVarArgs = new b("Not all required fields were included: NewChatroomData");
        AppMethodBeat.o(101815);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaqe != null) {
        paramVarArgs.g(2, this.aaqe);
      }
      paramVarArgs.bS(3, this.vgK);
      if (this.aaqf != null)
      {
        paramVarArgs.qD(4, this.aaqf.computeSize());
        this.aaqf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaqe != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaqe);
      }
      i += i.a.a.b.b.a.cJ(3, this.vgK);
      paramInt = i;
      if (this.aaqf != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaqf.computeSize());
      }
      AppMethodBeat.o(101815);
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
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        if (this.aaqf == null)
        {
          paramVarArgs = new b("Not all required fields were included: NewChatroomData");
          AppMethodBeat.o(101815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        chh localchh = (chh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101815);
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
            localchh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101815);
          return 0;
        case 2: 
          localchh.aaqe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101815);
          return 0;
        case 3: 
          localchh.vgK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101815);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new zg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((zg)localObject2).parseFrom((byte[])localObject1);
          }
          localchh.aaqf = ((zg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(101815);
        return 0;
      }
      AppMethodBeat.o(101815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chh
 * JD-Core Version:    0.7.0.1
 */