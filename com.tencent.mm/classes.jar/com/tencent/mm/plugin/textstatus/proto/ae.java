package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import i.a.a.b;
import java.util.LinkedList;

public final class ae
  extends esc
{
  public ar TpA;
  public w TpB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290013);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(290013);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TpA != null)
      {
        paramVarArgs.qD(2, this.TpA.computeSize());
        this.TpA.writeFields(paramVarArgs);
      }
      if (this.TpB != null)
      {
        paramVarArgs.qD(3, this.TpB.computeSize());
        this.TpB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(290013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label596;
      }
    }
    label596:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TpA != null) {
        paramInt = i + i.a.a.a.qC(2, this.TpA.computeSize());
      }
      i = paramInt;
      if (this.TpB != null) {
        i = paramInt + i.a.a.a.qC(3, this.TpB.computeSize());
      }
      AppMethodBeat.o(290013);
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
          AppMethodBeat.o(290013);
          throw paramVarArgs;
        }
        AppMethodBeat.o(290013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(290013);
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
            localae.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(290013);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ar();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ar)localObject2).parseFrom((byte[])localObject1);
            }
            localae.TpA = ((ar)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(290013);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new w();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((w)localObject2).parseFrom((byte[])localObject1);
          }
          localae.TpB = ((w)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(290013);
        return 0;
      }
      AppMethodBeat.o(290013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ae
 * JD-Core Version:    0.7.0.1
 */