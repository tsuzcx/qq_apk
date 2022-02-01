package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cbz
  extends dyy
{
  public dvl Tkp;
  public int Tkq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168757);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168757);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tkp != null)
      {
        paramVarArgs.oE(2, this.Tkp.computeSize());
        this.Tkp.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Tkq);
      AppMethodBeat.o(168757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tkp != null) {
        i = paramInt + g.a.a.a.oD(2, this.Tkp.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Tkq);
      AppMethodBeat.o(168757);
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
          AppMethodBeat.o(168757);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbz localcbz = (cbz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168757);
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
            localcbz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168757);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvl)localObject2).parseFrom((byte[])localObject1);
            }
            localcbz.Tkp = ((dvl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168757);
          return 0;
        }
        localcbz.Tkq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168757);
        return 0;
      }
      AppMethodBeat.o(168757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbz
 * JD-Core Version:    0.7.0.1
 */