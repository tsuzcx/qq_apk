package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oy
  extends com.tencent.mm.bx.a
{
  public String FKf;
  public int FKg;
  public String FKh;
  public int FKi;
  public LinkedList<mk> FKj;
  
  public oy()
  {
    AppMethodBeat.i(152509);
    this.FKj = new LinkedList();
    AppMethodBeat.o(152509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKf != null) {
        paramVarArgs.d(1, this.FKf);
      }
      paramVarArgs.aS(2, this.FKg);
      if (this.FKh != null) {
        paramVarArgs.d(3, this.FKh);
      }
      paramVarArgs.aS(4, this.FKi);
      paramVarArgs.e(5, 8, this.FKj);
      AppMethodBeat.o(152510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKf == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.b.b.a.e(1, this.FKf) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FKg);
      paramInt = i;
      if (this.FKh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FKh);
      }
      i = f.a.a.b.b.a.bz(4, this.FKi);
      int j = f.a.a.a.c(5, 8, this.FKj);
      AppMethodBeat.o(152510);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FKj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oy localoy = (oy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152510);
          return -1;
        case 1: 
          localoy.FKf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 2: 
          localoy.FKg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152510);
          return 0;
        case 3: 
          localoy.FKh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152510);
          return 0;
        case 4: 
          localoy.FKi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152510);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((mk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localoy.FKj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152510);
        return 0;
      }
      AppMethodBeat.o(152510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oy
 * JD-Core Version:    0.7.0.1
 */