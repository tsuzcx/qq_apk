package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qe
  extends dyy
{
  public dsk RUv;
  public int RYy;
  public com.tencent.mm.cd.b RYz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210740);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(210740);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RYy);
      if (this.RYz != null) {
        paramVarArgs.c(3, this.RYz);
      }
      if (this.RUv != null)
      {
        paramVarArgs.oE(4, this.RUv.computeSize());
        this.RUv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(210740);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RYy);
      paramInt = i;
      if (this.RYz != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.RYz);
      }
      i = paramInt;
      if (this.RUv != null) {
        i = paramInt + g.a.a.a.oD(4, this.RUv.computeSize());
      }
      AppMethodBeat.o(210740);
      return i;
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(210740);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210740);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        qe localqe = (qe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210740);
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
            localqe.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(210740);
          return 0;
        case 2: 
          localqe.RYy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(210740);
          return 0;
        case 3: 
          localqe.RYz = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(210740);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dsk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dsk)localObject2).parseFrom((byte[])localObject1);
          }
          localqe.RUv = ((dsk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(210740);
        return 0;
      }
      AppMethodBeat.o(210740);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qe
 * JD-Core Version:    0.7.0.1
 */