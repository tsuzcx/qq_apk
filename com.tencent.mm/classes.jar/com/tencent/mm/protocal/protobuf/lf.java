package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lf
  extends com.tencent.mm.cd.a
{
  public long RQi;
  public long RQj;
  public LinkedList<ld> RQk;
  public boolean RQl;
  public long uin;
  
  public lf()
  {
    AppMethodBeat.i(110888);
    this.RQk = new LinkedList();
    this.RQl = false;
    AppMethodBeat.o(110888);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110889);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RQi);
      paramVarArgs.bm(2, this.uin);
      paramVarArgs.bm(3, this.RQj);
      paramVarArgs.e(4, 8, this.RQk);
      paramVarArgs.co(5, this.RQl);
      AppMethodBeat.o(110889);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.RQi);
      i = g.a.a.b.b.a.p(2, this.uin);
      int j = g.a.a.b.b.a.p(3, this.RQj);
      int k = g.a.a.a.c(4, 8, this.RQk);
      int m = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(110889);
      return paramInt + 0 + i + j + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RQk.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(110889);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      lf locallf = (lf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110889);
        return -1;
      case 1: 
        locallf.RQi = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110889);
        return 0;
      case 2: 
        locallf.uin = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110889);
        return 0;
      case 3: 
        locallf.RQj = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(110889);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ld localld = new ld();
          if ((localObject != null) && (localObject.length > 0)) {
            localld.parseFrom((byte[])localObject);
          }
          locallf.RQk.add(localld);
          paramInt += 1;
        }
        AppMethodBeat.o(110889);
        return 0;
      }
      locallf.RQl = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(110889);
      return 0;
    }
    AppMethodBeat.o(110889);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lf
 * JD-Core Version:    0.7.0.1
 */