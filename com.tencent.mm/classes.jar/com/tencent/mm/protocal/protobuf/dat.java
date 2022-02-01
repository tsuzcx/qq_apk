package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dat
  extends com.tencent.mm.bx.a
{
  public String Esp;
  public ahj Esy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Esp != null) {
        paramVarArgs.d(1, this.Esp);
      }
      if (this.Esy != null)
      {
        paramVarArgs.kX(2, this.Esy.computeSize());
        this.Esy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Esp == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.Esp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Esy != null) {
        i = paramInt + f.a.a.a.kW(2, this.Esy.computeSize());
      }
      AppMethodBeat.o(124562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dat localdat = (dat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124562);
          return -1;
        case 1: 
          localdat.Esp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124562);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdat.Esy = ((ahj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124562);
        return 0;
      }
      AppMethodBeat.o(124562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dat
 * JD-Core Version:    0.7.0.1
 */