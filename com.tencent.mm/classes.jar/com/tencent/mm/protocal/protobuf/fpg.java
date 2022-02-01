package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpg
  extends com.tencent.mm.cd.a
{
  public String UMX;
  public LinkedList<fpf> UMY;
  
  public fpg()
  {
    AppMethodBeat.i(153332);
    this.UMY = new LinkedList();
    AppMethodBeat.o(153332);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153333);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UMX != null) {
        paramVarArgs.f(1, this.UMX);
      }
      paramVarArgs.e(2, 8, this.UMY);
      AppMethodBeat.o(153333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UMX == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.UMX) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.UMY);
      AppMethodBeat.o(153333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UMY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fpg localfpg = (fpg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153333);
          return -1;
        case 1: 
          localfpg.UMX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153333);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fpf localfpf = new fpf();
          if ((localObject != null) && (localObject.length > 0)) {
            localfpf.parseFrom((byte[])localObject);
          }
          localfpg.UMY.add(localfpf);
          paramInt += 1;
        }
        AppMethodBeat.o(153333);
        return 0;
      }
      AppMethodBeat.o(153333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpg
 * JD-Core Version:    0.7.0.1
 */