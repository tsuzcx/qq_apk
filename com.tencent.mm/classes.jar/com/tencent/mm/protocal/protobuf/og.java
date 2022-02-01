package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class og
  extends dyy
{
  public String ProductID;
  public LinkedList<String> RVA;
  
  public og()
  {
    AppMethodBeat.i(124429);
    this.RVA = new LinkedList();
    AppMethodBeat.o(124429);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124430);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124430);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.f(3, this.ProductID);
      }
      paramVarArgs.e(4, 1, this.RVA);
      AppMethodBeat.o(124430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label460;
      }
    }
    label460:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ProductID);
      }
      paramInt = g.a.a.a.c(4, 1, this.RVA);
      AppMethodBeat.o(124430);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RVA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124430);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        og localog = (og)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(124430);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localog.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(124430);
          return 0;
        case 3: 
          localog.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124430);
          return 0;
        }
        localog.RVA.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(124430);
        return 0;
      }
      AppMethodBeat.o(124430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.og
 * JD-Core Version:    0.7.0.1
 */