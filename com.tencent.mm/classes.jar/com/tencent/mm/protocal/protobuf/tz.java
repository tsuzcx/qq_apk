package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class tz
  extends com.tencent.mm.bx.a
{
  public LinkedList<dto> FSx;
  public b FSy;
  public b FSz;
  
  public tz()
  {
    AppMethodBeat.i(117854);
    this.FSx = new LinkedList();
    AppMethodBeat.o(117854);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FSx);
      if (this.FSy != null) {
        paramVarArgs.c(2, this.FSy);
      }
      if (this.FSz != null) {
        paramVarArgs.c(3, this.FSz);
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FSx) + 0;
      paramInt = i;
      if (this.FSy != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FSy);
      }
      i = paramInt;
      if (this.FSz != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.FSz);
      }
      AppMethodBeat.o(117855);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FSx.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      tz localtz = (tz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117855);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dto();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dto)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localtz.FSx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117855);
        return 0;
      case 2: 
        localtz.FSy = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(117855);
        return 0;
      }
      localtz.FSz = ((f.a.a.a.a)localObject1).NPN.gxI();
      AppMethodBeat.o(117855);
      return 0;
    }
    AppMethodBeat.o(117855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tz
 * JD-Core Version:    0.7.0.1
 */