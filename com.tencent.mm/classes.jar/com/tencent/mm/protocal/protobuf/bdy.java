package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdy
  extends com.tencent.mm.bw.a
{
  public String LNC;
  public int LND;
  public String LNE;
  public FinderAuthInfo LNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LNC != null) {
        paramVarArgs.e(1, this.LNC);
      }
      paramVarArgs.aM(2, this.LND);
      if (this.LNE != null) {
        paramVarArgs.e(3, this.LNE);
      }
      if (this.LNF != null)
      {
        paramVarArgs.ni(4, this.LNF.computeSize());
        this.LNF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LNC == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = g.a.a.b.b.a.f(1, this.LNC) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LND);
      paramInt = i;
      if (this.LNE != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LNE);
      }
      i = paramInt;
      if (this.LNF != null) {
        i = paramInt + g.a.a.a.nh(4, this.LNF.computeSize());
      }
      AppMethodBeat.o(209709);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209709);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdy localbdy = (bdy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209709);
          return -1;
        case 1: 
          localbdy.LNC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209709);
          return 0;
        case 2: 
          localbdy.LND = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209709);
          return 0;
        case 3: 
          localbdy.LNE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209709);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderAuthInfo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderAuthInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbdy.LNF = ((FinderAuthInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209709);
        return 0;
      }
      AppMethodBeat.o(209709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdy
 * JD-Core Version:    0.7.0.1
 */