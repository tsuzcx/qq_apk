package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fkc
  extends com.tencent.mm.cd.a
{
  public int Sat;
  public LinkedList<fiy> Tdk;
  public boolean Tic;
  
  public fkc()
  {
    AppMethodBeat.i(32554);
    this.Tdk = new LinkedList();
    AppMethodBeat.o(32554);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32555);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Tdk);
      paramVarArgs.aY(2, this.Sat);
      paramVarArgs.co(3, this.Tic);
      AppMethodBeat.o(32555);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.Tdk);
      i = g.a.a.b.b.a.bM(2, this.Sat);
      int j = g.a.a.b.b.a.gL(3);
      AppMethodBeat.o(32555);
      return paramInt + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Tdk.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32555);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fkc localfkc = (fkc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32555);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fiy localfiy = new fiy();
          if ((localObject != null) && (localObject.length > 0)) {
            localfiy.parseFrom((byte[])localObject);
          }
          localfkc.Tdk.add(localfiy);
          paramInt += 1;
        }
        AppMethodBeat.o(32555);
        return 0;
      case 2: 
        localfkc.Sat = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32555);
        return 0;
      }
      localfkc.Tic = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(32555);
      return 0;
    }
    AppMethodBeat.o(32555);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkc
 * JD-Core Version:    0.7.0.1
 */