package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amx
  extends com.tencent.mm.bx.a
{
  public LinkedList<FinderObject> Gmm;
  public int fTM;
  public int sUo;
  public String username;
  
  public amx()
  {
    AppMethodBeat.i(209290);
    this.Gmm = new LinkedList();
    AppMethodBeat.o(209290);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209291);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.sUo);
      paramVarArgs.e(2, 8, this.Gmm);
      if (this.username != null) {
        paramVarArgs.d(3, this.username);
      }
      paramVarArgs.aS(4, this.fTM);
      AppMethodBeat.o(209291);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.sUo) + 0 + f.a.a.a.c(2, 8, this.Gmm);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.username);
      }
      i = f.a.a.b.b.a.bz(4, this.fTM);
      AppMethodBeat.o(209291);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gmm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209291);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      amx localamx = (amx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209291);
        return -1;
      case 1: 
        localamx.sUo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209291);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamx.Gmm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209291);
        return 0;
      case 3: 
        localamx.username = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(209291);
        return 0;
      }
      localamx.fTM = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(209291);
      return 0;
    }
    AppMethodBeat.o(209291);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amx
 * JD-Core Version:    0.7.0.1
 */