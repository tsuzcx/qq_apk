package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbm
  extends dyy
{
  public dbj TIN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229224);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TIN != null)
      {
        paramVarArgs.oE(2, this.TIN.computeSize());
        this.TIN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(229224);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TIN != null) {
        i = paramInt + g.a.a.a.oD(2, this.TIN.computeSize());
      }
      AppMethodBeat.o(229224);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229224);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbm localdbm = (dbm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229224);
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
            localdbm.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229224);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbj)localObject2).parseFrom((byte[])localObject1);
          }
          localdbm.TIN = ((dbj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(229224);
        return 0;
      }
      AppMethodBeat.o(229224);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbm
 * JD-Core Version:    0.7.0.1
 */