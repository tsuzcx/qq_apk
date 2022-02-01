package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amp
  extends com.tencent.mm.bx.a
{
  public String GlF;
  public FinderContact contact;
  public int dDp;
  public int displayFlag;
  public boolean drv;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168954);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.lC(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dDp);
      if (this.GlF != null) {
        paramVarArgs.d(3, this.GlF);
      }
      paramVarArgs.bt(4, this.drv);
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
    for (paramInt = f.a.a.a.lB(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dDp);
      paramInt = i;
      if (this.GlF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GlF);
      }
      i = paramInt + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.bz(5, this.displayFlag);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.username);
      }
      AppMethodBeat.o(168954);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amp localamp = (amp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168954);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamp.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168954);
          return 0;
        case 2: 
          localamp.dDp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168954);
          return 0;
        case 3: 
          localamp.GlF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168954);
          return 0;
        case 4: 
          localamp.drv = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(168954);
          return 0;
        case 5: 
          localamp.displayFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168954);
          return 0;
        }
        localamp.username = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(168954);
        return 0;
      }
      AppMethodBeat.o(168954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amp
 * JD-Core Version:    0.7.0.1
 */