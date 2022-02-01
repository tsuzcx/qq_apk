package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class epo
  extends dyl
{
  public String RUp;
  public boolean qfB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6435);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUp == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(6435);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RUp != null) {
        paramVarArgs.f(2, this.RUp);
      }
      paramVarArgs.co(3, this.qfB);
      AppMethodBeat.o(6435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label449;
      }
    }
    label449:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RUp != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RUp);
      }
      paramInt = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(6435);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RUp == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(6435);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        epo localepo = (epo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6435);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localepo.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(6435);
          return 0;
        case 2: 
          localepo.RUp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(6435);
          return 0;
        }
        localepo.qfB = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(6435);
        return 0;
      }
      AppMethodBeat.o(6435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epo
 * JD-Core Version:    0.7.0.1
 */