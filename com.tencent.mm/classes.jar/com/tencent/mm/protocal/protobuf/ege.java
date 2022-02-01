package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ege
  extends dyl
{
  public String HlB;
  public String RRg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155466);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RRg != null) {
        paramVarArgs.f(2, this.RRg);
      }
      if (this.HlB != null) {
        paramVarArgs.f(3, this.HlB);
      }
      AppMethodBeat.o(155466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label408;
      }
    }
    label408:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RRg != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RRg);
      }
      i = paramInt;
      if (this.HlB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.HlB);
      }
      AppMethodBeat.o(155466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ege localege = (ege)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155466);
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
            localege.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(155466);
          return 0;
        case 2: 
          localege.RRg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155466);
          return 0;
        }
        localege.HlB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155466);
        return 0;
      }
      AppMethodBeat.o(155466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ege
 * JD-Core Version:    0.7.0.1
 */