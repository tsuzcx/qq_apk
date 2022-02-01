package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvz
  extends com.tencent.mm.bx.a
{
  public abe HIh;
  public boolean HIi = true;
  public dvl HIj;
  public String HIk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HIh != null)
      {
        paramVarArgs.lC(1, this.HIh.computeSize());
        this.HIh.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.HIi);
      if (this.HIj != null)
      {
        paramVarArgs.lC(3, this.HIj.computeSize());
        this.HIj.writeFields(paramVarArgs);
      }
      if (this.HIk != null) {
        paramVarArgs.d(4, this.HIk);
      }
      AppMethodBeat.o(117943);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HIh == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lB(1, this.HIh.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alV(2);
      paramInt = i;
      if (this.HIj != null) {
        paramInt = i + f.a.a.a.lB(3, this.HIj.computeSize());
      }
      i = paramInt;
      if (this.HIk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HIk);
      }
      AppMethodBeat.o(117943);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117943);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvz localdvz = (dvz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117943);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvz.HIh = ((abe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        case 2: 
          localdvz.HIi = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(117943);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvz.HIj = ((dvl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117943);
          return 0;
        }
        localdvz.HIk = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117943);
        return 0;
      }
      AppMethodBeat.o(117943);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvz
 * JD-Core Version:    0.7.0.1
 */