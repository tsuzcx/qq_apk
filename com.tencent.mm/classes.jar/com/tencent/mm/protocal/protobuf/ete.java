package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ete
  extends dyy
{
  public String ByB;
  public int UnM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129976);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(129976);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ByB != null) {
        paramVarArgs.f(2, this.ByB);
      }
      paramVarArgs.aY(3, this.UnM);
      AppMethodBeat.o(129976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ByB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ByB);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.UnM);
      AppMethodBeat.o(129976);
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
          AppMethodBeat.o(129976);
          throw paramVarArgs;
        }
        AppMethodBeat.o(129976);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ete localete = (ete)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129976);
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
            localete.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(129976);
          return 0;
        case 2: 
          localete.ByB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(129976);
          return 0;
        }
        localete.UnM = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(129976);
        return 0;
      }
      AppMethodBeat.o(129976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ete
 * JD-Core Version:    0.7.0.1
 */