package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oi
  extends esc
{
  public com.tencent.mm.bx.b YRt;
  public LinkedList<oj> YRu;
  
  public oi()
  {
    AppMethodBeat.i(124407);
    this.YRu = new LinkedList();
    AppMethodBeat.o(124407);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124408);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124408);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YRt != null) {
        paramVarArgs.d(2, this.YRt);
      }
      paramVarArgs.e(3, 8, this.YRu);
      AppMethodBeat.o(124408);
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
      if (this.YRt != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YRt);
      }
      paramInt = i.a.a.a.c(3, 8, this.YRu);
      AppMethodBeat.o(124408);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YRu.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        oi localoi = (oi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124408);
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
            localoi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124408);
          return 0;
        case 2: 
          localoi.YRt = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(124408);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new oj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((oj)localObject2).parseFrom((byte[])localObject1);
          }
          localoi.YRu.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124408);
        return 0;
      }
      AppMethodBeat.o(124408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oi
 * JD-Core Version:    0.7.0.1
 */