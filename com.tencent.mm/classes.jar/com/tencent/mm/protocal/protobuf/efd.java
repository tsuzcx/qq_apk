package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efd
  extends com.tencent.mm.bw.a
{
  public LinkedList<edz> GQv;
  public boolean GUq;
  public int GeT;
  
  public efd()
  {
    AppMethodBeat.i(32554);
    this.GQv = new LinkedList();
    AppMethodBeat.o(32554);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32555);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GQv);
      paramVarArgs.aS(2, this.GeT);
      paramVarArgs.bC(3, this.GUq);
      AppMethodBeat.o(32555);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.GQv);
      i = f.a.a.b.b.a.bz(2, this.GeT);
      int j = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(32555);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GQv.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32555);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      efd localefd = (efd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32555);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new edz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((edz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localefd.GQv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32555);
        return 0;
      case 2: 
        localefd.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32555);
        return 0;
      }
      localefd.GUq = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(32555);
      return 0;
    }
    AppMethodBeat.o(32555);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efd
 * JD-Core Version:    0.7.0.1
 */