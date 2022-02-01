package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajz
  extends com.tencent.mm.bw.a
{
  public LinkedList<FinderObject> EEw;
  public int fAw;
  public int rXu;
  public String username;
  
  public ajz()
  {
    AppMethodBeat.i(195063);
    this.EEw = new LinkedList();
    AppMethodBeat.o(195063);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195064);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.rXu);
      paramVarArgs.e(2, 8, this.EEw);
      if (this.username != null) {
        paramVarArgs.d(3, this.username);
      }
      paramVarArgs.aR(4, this.fAw);
      AppMethodBeat.o(195064);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.rXu) + 0 + f.a.a.a.c(2, 8, this.EEw);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.username);
      }
      i = f.a.a.b.b.a.bx(4, this.fAw);
      AppMethodBeat.o(195064);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EEw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195064);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ajz localajz = (ajz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195064);
        return -1;
      case 1: 
        localajz.rXu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(195064);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localajz.EEw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195064);
        return 0;
      case 3: 
        localajz.username = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(195064);
        return 0;
      }
      localajz.fAw = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(195064);
      return 0;
    }
    AppMethodBeat.o(195064);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajz
 * JD-Core Version:    0.7.0.1
 */