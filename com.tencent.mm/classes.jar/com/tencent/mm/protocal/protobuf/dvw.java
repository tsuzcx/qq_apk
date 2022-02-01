package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dvw
  extends dyy
{
  public dcb TbO;
  public String UbQ;
  public int UbR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104376);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104376);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UbQ != null) {
        paramVarArgs.f(2, this.UbQ);
      }
      if (this.TbO != null)
      {
        paramVarArgs.oE(3, this.TbO.computeSize());
        this.TbO.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.UbR);
      AppMethodBeat.o(104376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label574;
      }
    }
    label574:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UbQ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UbQ);
      }
      i = paramInt;
      if (this.TbO != null) {
        i = paramInt + g.a.a.a.oD(3, this.TbO.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.UbR);
      AppMethodBeat.o(104376);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104376);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvw localdvw = (dvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104376);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdvw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104376);
          return 0;
        case 2: 
          localdvw.UbQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104376);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcb)localObject2).parseFrom((byte[])localObject1);
            }
            localdvw.TbO = ((dcb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104376);
          return 0;
        }
        localdvw.UbR = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(104376);
        return 0;
      }
      AppMethodBeat.o(104376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvw
 * JD-Core Version:    0.7.0.1
 */