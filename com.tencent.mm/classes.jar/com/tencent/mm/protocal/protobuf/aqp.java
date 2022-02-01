package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aqp
  extends com.tencent.mm.bw.a
{
  public aqi EJG;
  public LinkedList<String> EJH;
  
  public aqp()
  {
    AppMethodBeat.i(42644);
    this.EJH = new LinkedList();
    AppMethodBeat.o(42644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42645);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EJG == null)
      {
        paramVarArgs = new b("Not all required fields were included: GameItem");
        AppMethodBeat.o(42645);
        throw paramVarArgs;
      }
      if (this.EJG != null)
      {
        paramVarArgs.ln(1, this.EJG.computeSize());
        this.EJG.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.EJH);
      AppMethodBeat.o(42645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EJG == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.a.lm(1, this.EJG.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.EJH);
      AppMethodBeat.o(42645);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EJG == null)
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
        aqp localaqp = (aqp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42645);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aqi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqp.EJG = ((aqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42645);
          return 0;
        }
        localaqp.EJH.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(42645);
        return 0;
      }
      AppMethodBeat.o(42645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqp
 * JD-Core Version:    0.7.0.1
 */