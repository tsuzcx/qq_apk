package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abw
  extends com.tencent.mm.cd.a
{
  public String SnI;
  public String SnJ;
  public LinkedList<cxl> SnK;
  
  public abw()
  {
    AppMethodBeat.i(116467);
    this.SnK = new LinkedList();
    AppMethodBeat.o(116467);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116468);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SnI != null) {
        paramVarArgs.f(1, this.SnI);
      }
      if (this.SnJ != null) {
        paramVarArgs.f(2, this.SnJ);
      }
      paramVarArgs.e(3, 8, this.SnK);
      AppMethodBeat.o(116468);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SnI == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = g.a.a.b.b.a.g(1, this.SnI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SnJ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SnJ);
      }
      paramInt = g.a.a.a.c(3, 8, this.SnK);
      AppMethodBeat.o(116468);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SnK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        abw localabw = (abw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116468);
          return -1;
        case 1: 
          localabw.SnI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116468);
          return 0;
        case 2: 
          localabw.SnJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116468);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cxl localcxl = new cxl();
          if ((localObject != null) && (localObject.length > 0)) {
            localcxl.parseFrom((byte[])localObject);
          }
          localabw.SnK.add(localcxl);
          paramInt += 1;
        }
        AppMethodBeat.o(116468);
        return 0;
      }
      AppMethodBeat.o(116468);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abw
 * JD-Core Version:    0.7.0.1
 */