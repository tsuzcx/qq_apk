package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fks
  extends dyy
{
  public String UJk;
  public String fIY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117946);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.UJk != null) {
        paramVarArgs.f(2, this.UJk);
      }
      if (this.fIY != null) {
        paramVarArgs.f(3, this.fIY);
      }
      AppMethodBeat.o(117946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label408;
      }
    }
    label408:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UJk != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UJk);
      }
      i = paramInt;
      if (this.fIY != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fIY);
      }
      AppMethodBeat.o(117946);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117946);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fks localfks = (fks)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117946);
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
            localfks.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(117946);
          return 0;
        case 2: 
          localfks.UJk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(117946);
          return 0;
        }
        localfks.fIY = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(117946);
        return 0;
      }
      AppMethodBeat.o(117946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fks
 * JD-Core Version:    0.7.0.1
 */