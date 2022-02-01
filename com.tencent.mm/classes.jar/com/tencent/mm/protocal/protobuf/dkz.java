package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkz
  extends com.tencent.mm.bw.a
{
  public bps FTI;
  public bps FTJ;
  public String content;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72616);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.d(2, this.content);
      }
      if (this.FTI != null)
      {
        paramVarArgs.ln(3, this.FTI.computeSize());
        this.FTI.writeFields(paramVarArgs);
      }
      if (this.FTJ != null)
      {
        paramVarArgs.ln(4, this.FTJ.computeSize());
        this.FTJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72616);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.content);
      }
      i = paramInt;
      if (this.FTI != null) {
        i = paramInt + f.a.a.a.lm(3, this.FTI.computeSize());
      }
      paramInt = i;
      if (this.FTJ != null) {
        paramInt = i + f.a.a.a.lm(4, this.FTJ.computeSize());
      }
      AppMethodBeat.o(72616);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkz localdkz = (dkz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72616);
          return -1;
        case 1: 
          localdkz.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 2: 
          localdkz.content = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bps();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bps)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkz.FTI = ((bps)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72616);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bps();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bps)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkz.FTJ = ((bps)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      AppMethodBeat.o(72616);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkz
 * JD-Core Version:    0.7.0.1
 */