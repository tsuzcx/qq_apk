package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnc
  extends com.tencent.mm.bx.a
{
  public bkk ZFA;
  public FinderContact contact;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258821);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZFA != null)
      {
        paramVarArgs.qD(1, this.ZFA.computeSize());
        this.ZFA.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.qD(2, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258821);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZFA == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.ZFA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.contact != null) {
        i = paramInt + i.a.a.a.qC(2, this.contact.computeSize());
      }
      AppMethodBeat.o(258821);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258821);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bnc localbnc = (bnc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258821);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkk)localObject2).parseFrom((byte[])localObject1);
            }
            localbnc.ZFA = ((bkk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258821);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderContact();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderContact)localObject2).parseFrom((byte[])localObject1);
          }
          localbnc.contact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258821);
        return 0;
      }
      AppMethodBeat.o(258821);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnc
 * JD-Core Version:    0.7.0.1
 */