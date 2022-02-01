package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdy
  extends com.tencent.mm.bx.a
{
  public boolean GIC = false;
  public dno Grv;
  public String Grw;
  public boolean Grz = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Grv != null)
      {
        paramVarArgs.lC(1, this.Grv.computeSize());
        this.Grv.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.Grz);
      paramVarArgs.bt(3, this.GIC);
      if (this.Grw != null) {
        paramVarArgs.d(4, this.Grw);
      }
      AppMethodBeat.o(122520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Grv == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lB(1, this.Grv.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alV(2) + f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.Grw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Grw);
      }
      AppMethodBeat.o(122520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdy localcdy = (cdy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122520);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dno();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdy.Grv = ((dno)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122520);
          return 0;
        case 2: 
          localcdy.Grz = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122520);
          return 0;
        case 3: 
          localcdy.GIC = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122520);
          return 0;
        }
        localcdy.Grw = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122520);
        return 0;
      }
      AppMethodBeat.o(122520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdy
 * JD-Core Version:    0.7.0.1
 */