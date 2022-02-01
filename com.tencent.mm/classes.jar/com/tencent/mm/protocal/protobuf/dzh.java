package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzh
  extends com.tencent.mm.bx.a
{
  public FinderContact contact;
  public boolean diE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203867);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.kX(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(2, this.diE);
      AppMethodBeat.o(203867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.kW(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      AppMethodBeat.o(203867);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203867);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzh localdzh = (dzh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203867);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzh.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203867);
          return 0;
        }
        localdzh.diE = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(203867);
        return 0;
      }
      AppMethodBeat.o(203867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzh
 * JD-Core Version:    0.7.0.1
 */