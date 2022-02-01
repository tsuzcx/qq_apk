package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ffl
  extends com.tencent.mm.bw.a
{
  public int Lqb;
  public int NAI;
  public int NAJ;
  public ecf NAK;
  public int score;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32570);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32570);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.aM(2, this.score);
      paramVarArgs.aM(3, this.NAI);
      paramVarArgs.aM(4, this.Lqb);
      paramVarArgs.aM(5, this.NAJ);
      if (this.NAK != null)
      {
        paramVarArgs.ni(6, this.NAK.computeSize());
        this.NAK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.score) + g.a.a.b.b.a.bu(3, this.NAI) + g.a.a.b.b.a.bu(4, this.Lqb) + g.a.a.b.b.a.bu(5, this.NAJ);
      paramInt = i;
      if (this.NAK != null) {
        paramInt = i + g.a.a.a.nh(6, this.NAK.computeSize());
      }
      AppMethodBeat.o(32570);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ffl localffl = (ffl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32570);
          return -1;
        case 1: 
          localffl.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32570);
          return 0;
        case 2: 
          localffl.score = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32570);
          return 0;
        case 3: 
          localffl.NAI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32570);
          return 0;
        case 4: 
          localffl.Lqb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32570);
          return 0;
        case 5: 
          localffl.NAJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32570);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ecf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localffl.NAK = ((ecf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32570);
        return 0;
      }
      AppMethodBeat.o(32570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffl
 * JD-Core Version:    0.7.0.1
 */