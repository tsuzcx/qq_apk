package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahr
  extends com.tencent.mm.bx.a
{
  public LinkedList<ahs> hDb;
  public String key;
  public String title;
  
  public ahr()
  {
    AppMethodBeat.i(195468);
    this.hDb = new LinkedList();
    AppMethodBeat.o(195468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.hDb);
      if (this.key != null) {
        paramVarArgs.d(2, this.key);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      AppMethodBeat.o(195469);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.hDb) + 0;
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.key);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      AppMethodBeat.o(195469);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hDb.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(195469);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ahr localahr = (ahr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195469);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahr.hDb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195469);
        return 0;
      case 2: 
        localahr.key = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(195469);
        return 0;
      }
      localahr.title = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(195469);
      return 0;
    }
    AppMethodBeat.o(195469);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahr
 * JD-Core Version:    0.7.0.1
 */