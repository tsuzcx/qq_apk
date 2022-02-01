package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anb
  extends com.tencent.mm.bw.a
{
  public String GEH;
  public FinderContact contact;
  public int dEu;
  public int displayFlag;
  public boolean dsB;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168954);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.lJ(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dEu);
      if (this.GEH != null) {
        paramVarArgs.d(3, this.GEH);
      }
      paramVarArgs.bC(4, this.dsB);
      paramVarArgs.aS(5, this.displayFlag);
      if (this.username != null) {
        paramVarArgs.d(6, this.username);
      }
      AppMethodBeat.o(168954);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = f.a.a.a.lI(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dEu);
      paramInt = i;
      if (this.GEH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GEH);
      }
      i = paramInt + f.a.a.b.b.a.amF(4) + f.a.a.b.b.a.bz(5, this.displayFlag);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.username);
      }
      AppMethodBeat.o(168954);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anb localanb = (anb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168954);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanb.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168954);
          return 0;
        case 2: 
          localanb.dEu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168954);
          return 0;
        case 3: 
          localanb.GEH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168954);
          return 0;
        case 4: 
          localanb.dsB = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(168954);
          return 0;
        case 5: 
          localanb.displayFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168954);
          return 0;
        }
        localanb.username = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(168954);
        return 0;
      }
      AppMethodBeat.o(168954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anb
 * JD-Core Version:    0.7.0.1
 */