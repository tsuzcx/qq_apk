package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpb
  extends com.tencent.mm.bx.a
{
  public dne ZXx;
  public FinderContact contact;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258066);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZXx != null)
      {
        paramVarArgs.qD(1, this.ZXx.computeSize());
        this.ZXx.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.qD(2, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258066);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZXx == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.ZXx.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.contact != null) {
        i = paramInt + i.a.a.a.qC(2, this.contact.computeSize());
      }
      AppMethodBeat.o(258066);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258066);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bpb localbpb = (bpb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258066);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dne();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dne)localObject2).parseFrom((byte[])localObject1);
            }
            localbpb.ZXx = ((dne)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258066);
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
          localbpb.contact = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258066);
        return 0;
      }
      AppMethodBeat.o(258066);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpb
 * JD-Core Version:    0.7.0.1
 */