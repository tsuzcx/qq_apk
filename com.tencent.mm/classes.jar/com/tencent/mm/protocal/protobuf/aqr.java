package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqr
  extends com.tencent.mm.bw.a
{
  public int cSx;
  public FinderContact contact;
  public boolean dJM;
  public String dMj;
  public int displayFlag;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168954);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.ni(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.cSx);
      if (this.dMj != null) {
        paramVarArgs.e(3, this.dMj);
      }
      paramVarArgs.cc(4, this.dJM);
      paramVarArgs.aM(5, this.displayFlag);
      if (this.username != null) {
        paramVarArgs.e(6, this.username);
      }
      AppMethodBeat.o(168954);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.cSx);
      paramInt = i;
      if (this.dMj != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dMj);
      }
      i = paramInt + (g.a.a.b.b.a.fS(4) + 1) + g.a.a.b.b.a.bu(5, this.displayFlag);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.username);
      }
      AppMethodBeat.o(168954);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqr localaqr = (aqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168954);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqr.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168954);
          return 0;
        case 2: 
          localaqr.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168954);
          return 0;
        case 3: 
          localaqr.dMj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168954);
          return 0;
        case 4: 
          localaqr.dJM = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(168954);
          return 0;
        case 5: 
          localaqr.displayFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168954);
          return 0;
        }
        localaqr.username = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(168954);
        return 0;
      }
      AppMethodBeat.o(168954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqr
 * JD-Core Version:    0.7.0.1
 */