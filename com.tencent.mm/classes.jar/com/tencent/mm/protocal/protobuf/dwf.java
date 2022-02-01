package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwf
  extends com.tencent.mm.bx.a
{
  public bxz HII;
  public int HIJ;
  public che Hor;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91725);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hor != null)
      {
        paramVarArgs.lC(1, this.Hor.computeSize());
        this.Hor.writeFields(paramVarArgs);
      }
      if (this.HII != null)
      {
        paramVarArgs.lC(2, this.HII.computeSize());
        this.HII.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HIJ);
      AppMethodBeat.o(91725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hor == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lB(1, this.Hor.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HII != null) {
        i = paramInt + f.a.a.a.lB(2, this.HII.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HIJ);
      AppMethodBeat.o(91725);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwf localdwf = (dwf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91725);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new che();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((che)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwf.Hor = ((che)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwf.HII = ((bxz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        }
        localdwf.HIJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91725);
        return 0;
      }
      AppMethodBeat.o(91725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwf
 * JD-Core Version:    0.7.0.1
 */