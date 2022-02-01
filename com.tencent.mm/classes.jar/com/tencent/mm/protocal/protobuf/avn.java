package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avn
  extends com.tencent.mm.bw.a
{
  public avi LDK;
  public int LGh;
  public int LGi;
  public int LGj;
  public FinderContact contact;
  public int hFI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209507);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.ni(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.hFI);
      paramVarArgs.aM(3, this.LGh);
      paramVarArgs.aM(4, this.LGi);
      paramVarArgs.aM(5, this.LGj);
      if (this.LDK != null)
      {
        paramVarArgs.ni(6, this.LDK.computeSize());
        this.LDK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = g.a.a.a.nh(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.hFI) + g.a.a.b.b.a.bu(3, this.LGh) + g.a.a.b.b.a.bu(4, this.LGi) + g.a.a.b.b.a.bu(5, this.LGj);
      paramInt = i;
      if (this.LDK != null) {
        paramInt = i + g.a.a.a.nh(6, this.LDK.computeSize());
      }
      AppMethodBeat.o(209507);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209507);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avn localavn = (avn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209507);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localavn.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209507);
          return 0;
        case 2: 
          localavn.hFI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209507);
          return 0;
        case 3: 
          localavn.LGh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209507);
          return 0;
        case 4: 
          localavn.LGi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209507);
          return 0;
        case 5: 
          localavn.LGj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209507);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localavn.LDK = ((avi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209507);
        return 0;
      }
      AppMethodBeat.o(209507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avn
 * JD-Core Version:    0.7.0.1
 */