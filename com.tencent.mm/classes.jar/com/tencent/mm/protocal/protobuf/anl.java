package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class anl
  extends com.tencent.mm.bx.a
{
  public ane DoG;
  public LinkedList<String> DoH;
  
  public anl()
  {
    AppMethodBeat.i(42644);
    this.DoH = new LinkedList();
    AppMethodBeat.o(42644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42645);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DoG == null)
      {
        paramVarArgs = new b("Not all required fields were included: GameItem");
        AppMethodBeat.o(42645);
        throw paramVarArgs;
      }
      if (this.DoG != null)
      {
        paramVarArgs.kX(1, this.DoG.computeSize());
        this.DoG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.DoH);
      AppMethodBeat.o(42645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DoG == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.a.kW(1, this.DoG.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.DoH);
      AppMethodBeat.o(42645);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DoH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DoG == null)
        {
          paramVarArgs = new b("Not all required fields were included: GameItem");
          AppMethodBeat.o(42645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anl localanl = (anl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42645);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ane();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ane)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanl.DoG = ((ane)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42645);
          return 0;
        }
        localanl.DoH.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(42645);
        return 0;
      }
      AppMethodBeat.o(42645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anl
 * JD-Core Version:    0.7.0.1
 */