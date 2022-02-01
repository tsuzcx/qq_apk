package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agm
  extends com.tencent.mm.bx.a
{
  public String Md5;
  public int nDi;
  public LinkedList<btb> nDj;
  
  public agm()
  {
    AppMethodBeat.i(104773);
    this.nDj = new LinkedList();
    AppMethodBeat.o(104773);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104774);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      paramVarArgs.aS(2, this.nDi);
      paramVarArgs.e(3, 8, this.nDj);
      AppMethodBeat.o(104774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nDi);
      int j = f.a.a.a.c(3, 8, this.nDj);
      AppMethodBeat.o(104774);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nDj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104774);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agm localagm = (agm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104774);
          return -1;
        case 1: 
          localagm.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104774);
          return 0;
        case 2: 
          localagm.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104774);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((btb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagm.nDj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104774);
        return 0;
      }
      AppMethodBeat.o(104774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agm
 * JD-Core Version:    0.7.0.1
 */