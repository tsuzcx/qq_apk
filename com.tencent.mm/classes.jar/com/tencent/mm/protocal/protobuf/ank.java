package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ank
  extends com.tencent.mm.bw.a
{
  public LinkedList<FinderObject> GFu;
  public int fVS;
  public int sgH;
  public String username;
  
  public ank()
  {
    AppMethodBeat.i(189331);
    this.GFu = new LinkedList();
    AppMethodBeat.o(189331);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.sgH);
      paramVarArgs.e(2, 8, this.GFu);
      if (this.username != null) {
        paramVarArgs.d(3, this.username);
      }
      paramVarArgs.aS(4, this.fVS);
      AppMethodBeat.o(189332);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.sgH) + 0 + f.a.a.a.c(2, 8, this.GFu);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.username);
      }
      i = f.a.a.b.b.a.bz(4, this.fVS);
      AppMethodBeat.o(189332);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GFu.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189332);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ank localank = (ank)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(189332);
        return -1;
      case 1: 
        localank.sgH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189332);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localank.GFu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189332);
        return 0;
      case 3: 
        localank.username = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189332);
        return 0;
      }
      localank.fVS = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(189332);
      return 0;
    }
    AppMethodBeat.o(189332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ank
 * JD-Core Version:    0.7.0.1
 */