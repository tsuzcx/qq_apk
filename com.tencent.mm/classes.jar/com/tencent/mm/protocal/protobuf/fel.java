package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fel
  extends esc
{
  public SnsObject abDT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125794);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125794);
        throw paramVarArgs;
      }
      if (this.abDT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Object");
        AppMethodBeat.o(125794);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abDT != null)
      {
        paramVarArgs.qD(2, this.abDT.computeSize());
        this.abDT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abDT != null) {
        i = paramInt + i.a.a.a.qC(2, this.abDT.computeSize());
      }
      AppMethodBeat.o(125794);
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
          AppMethodBeat.o(125794);
          throw paramVarArgs;
        }
        if (this.abDT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Object");
          AppMethodBeat.o(125794);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125794);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fel localfel = (fel)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125794);
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
            localfel.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125794);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new SnsObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((SnsObject)localObject2).parseFrom((byte[])localObject1);
          }
          localfel.abDT = ((SnsObject)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125794);
        return 0;
      }
      AppMethodBeat.o(125794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fel
 * JD-Core Version:    0.7.0.1
 */