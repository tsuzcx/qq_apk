package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyj
  extends com.tencent.mm.bx.a
{
  public FinderContact contact;
  public String recommendReason;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203832);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.kX(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.recommendReason != null) {
        paramVarArgs.d(2, this.recommendReason);
      }
      AppMethodBeat.o(203832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.a.kW(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.recommendReason != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.recommendReason);
      }
      AppMethodBeat.o(203832);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(203832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyj localdyj = (dyj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(203832);
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
            localdyj.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(203832);
          return 0;
        }
        localdyj.recommendReason = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(203832);
        return 0;
      }
      AppMethodBeat.o(203832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyj
 * JD-Core Version:    0.7.0.1
 */