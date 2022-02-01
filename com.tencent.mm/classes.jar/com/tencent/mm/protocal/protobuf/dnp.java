package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dnp
  extends dyy
{
  public LinkedList<dhq> TUP;
  public String appid;
  public int version;
  
  public dnp()
  {
    AppMethodBeat.i(123637);
    this.TUP = new LinkedList();
    AppMethodBeat.o(123637);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123638);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123638);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      paramVarArgs.aY(3, this.version);
      paramVarArgs.e(4, 8, this.TUP);
      AppMethodBeat.o(123638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appid);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.version);
      int j = g.a.a.a.c(4, 8, this.TUP);
      AppMethodBeat.o(123638);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TUP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123638);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnp localdnp = (dnp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123638);
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
            localdnp.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123638);
          return 0;
        case 2: 
          localdnp.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123638);
          return 0;
        case 3: 
          localdnp.version = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123638);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhq)localObject2).parseFrom((byte[])localObject1);
          }
          localdnp.TUP.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123638);
        return 0;
      }
      AppMethodBeat.o(123638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnp
 * JD-Core Version:    0.7.0.1
 */