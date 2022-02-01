package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cla
  extends com.tencent.mm.bx.a
{
  public String Hen;
  public String Heo;
  public LinkedList<dmv> Hep;
  
  public cla()
  {
    AppMethodBeat.i(72550);
    this.Hep = new LinkedList();
    AppMethodBeat.o(72550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72551);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hen != null) {
        paramVarArgs.d(1, this.Hen);
      }
      if (this.Heo != null) {
        paramVarArgs.d(2, this.Heo);
      }
      paramVarArgs.e(3, 8, this.Hep);
      AppMethodBeat.o(72551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hen == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hen) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Heo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Heo);
      }
      paramInt = f.a.a.a.c(3, 8, this.Hep);
      AppMethodBeat.o(72551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hep.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cla localcla = (cla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72551);
          return -1;
        case 1: 
          localcla.Hen = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72551);
          return 0;
        case 2: 
          localcla.Heo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72551);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dmv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcla.Hep.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      AppMethodBeat.o(72551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cla
 * JD-Core Version:    0.7.0.1
 */