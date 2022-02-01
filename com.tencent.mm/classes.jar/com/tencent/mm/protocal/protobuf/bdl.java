package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdl
  extends com.tencent.mm.cd.a
{
  public String SOx;
  public LinkedList<bdk> SOy;
  
  public bdl()
  {
    AppMethodBeat.i(230676);
    this.SOy = new LinkedList();
    AppMethodBeat.o(230676);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230681);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SOx != null) {
        paramVarArgs.f(1, this.SOx);
      }
      paramVarArgs.e(2, 8, this.SOy);
      AppMethodBeat.o(230681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SOx == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.SOx) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.SOy);
      AppMethodBeat.o(230681);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SOy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bdl localbdl = (bdl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230681);
          return -1;
        case 1: 
          localbdl.SOx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(230681);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bdk localbdk = new bdk();
          if ((localObject != null) && (localObject.length > 0)) {
            localbdk.parseFrom((byte[])localObject);
          }
          localbdl.SOy.add(localbdk);
          paramInt += 1;
        }
        AppMethodBeat.o(230681);
        return 0;
      }
      AppMethodBeat.o(230681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdl
 * JD-Core Version:    0.7.0.1
 */