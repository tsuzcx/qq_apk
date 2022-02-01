package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ae
  extends com.tencent.mm.cd.a
{
  public LinkedList<af> MFG;
  public String MFn;
  public long key;
  public LinkedList<ac> tse;
  
  public ae()
  {
    AppMethodBeat.i(243610);
    this.MFG = new LinkedList();
    this.tse = new LinkedList();
    AppMethodBeat.o(243610);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243611);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.key);
      if (this.MFn != null) {
        paramVarArgs.f(2, this.MFn);
      }
      paramVarArgs.e(3, 8, this.MFG);
      paramVarArgs.e(4, 8, this.tse);
      AppMethodBeat.o(243611);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.key) + 0;
      paramInt = i;
      if (this.MFn != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.MFn);
      }
      i = g.a.a.a.c(3, 8, this.MFG);
      int j = g.a.a.a.c(4, 8, this.tse);
      AppMethodBeat.o(243611);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MFG.clear();
      this.tse.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(243611);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ae localae = (ae)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(243611);
        return -1;
      case 1: 
        localae.key = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(243611);
        return 0;
      case 2: 
        localae.MFn = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(243611);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new af();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((af)localObject2).parseFrom((byte[])localObject1);
          }
          localae.MFG.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(243611);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ac();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ac)localObject2).parseFrom((byte[])localObject1);
        }
        localae.tse.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(243611);
      return 0;
    }
    AppMethodBeat.o(243611);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ae
 * JD-Core Version:    0.7.0.1
 */