package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dnl
  extends dyy
{
  public epz TUJ;
  public LinkedList<epz> TUK;
  
  public dnl()
  {
    AppMethodBeat.i(153291);
    this.TUK = new LinkedList();
    AppMethodBeat.o(153291);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153292);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153292);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TUJ != null)
      {
        paramVarArgs.oE(2, this.TUJ.computeSize());
        this.TUJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.TUK);
      AppMethodBeat.o(153292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label588;
      }
    }
    label588:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TUJ != null) {
        i = paramInt + g.a.a.a.oD(2, this.TUJ.computeSize());
      }
      paramInt = g.a.a.a.c(3, 8, this.TUK);
      AppMethodBeat.o(153292);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TUK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153292);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnl localdnl = (dnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153292);
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
            localdnl.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153292);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epz)localObject2).parseFrom((byte[])localObject1);
            }
            localdnl.TUJ = ((epz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153292);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new epz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((epz)localObject2).parseFrom((byte[])localObject1);
          }
          localdnl.TUK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153292);
        return 0;
      }
      AppMethodBeat.o(153292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnl
 * JD-Core Version:    0.7.0.1
 */