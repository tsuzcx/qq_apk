package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class jv
  extends dyy
{
  public LinkedList<fh> RPy;
  public LinkedList<eav> RPz;
  
  public jv()
  {
    AppMethodBeat.i(6396);
    this.RPy = new LinkedList();
    this.RPz = new LinkedList();
    AppMethodBeat.o(6396);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6397);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(6397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RPy);
      paramVarArgs.e(3, 8, this.RPz);
      AppMethodBeat.o(6397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label585;
      }
    }
    label585:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RPy);
      int j = g.a.a.a.c(3, 8, this.RPz);
      AppMethodBeat.o(6397);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RPy.clear();
        this.RPz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(6397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        jv localjv = (jv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6397);
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
            localjv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6397);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fh)localObject2).parseFrom((byte[])localObject1);
            }
            localjv.RPy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(6397);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eav();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eav)localObject2).parseFrom((byte[])localObject1);
          }
          localjv.RPz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6397);
        return 0;
      }
      AppMethodBeat.o(6397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jv
 * JD-Core Version:    0.7.0.1
 */