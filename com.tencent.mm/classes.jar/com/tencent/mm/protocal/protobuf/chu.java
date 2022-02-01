package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chu
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public LinkedList<cvt> Sqr;
  
  public chu()
  {
    AppMethodBeat.i(125736);
    this.Sqr = new LinkedList();
    AppMethodBeat.o(125736);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125737);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      paramVarArgs.e(2, 8, this.Sqr);
      AppMethodBeat.o(125737);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMP) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.Sqr);
      AppMethodBeat.o(125737);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sqr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125737);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        chu localchu = (chu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125737);
          return -1;
        case 1: 
          localchu.CMP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125737);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cvt localcvt = new cvt();
          if ((localObject != null) && (localObject.length > 0)) {
            localcvt.parseFrom((byte[])localObject);
          }
          localchu.Sqr.add(localcvt);
          paramInt += 1;
        }
        AppMethodBeat.o(125737);
        return 0;
      }
      AppMethodBeat.o(125737);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chu
 * JD-Core Version:    0.7.0.1
 */