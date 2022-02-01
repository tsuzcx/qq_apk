package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avq
  extends com.tencent.mm.bx.a
{
  public FinderContact contact;
  public String recommendReason;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257546);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.qD(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.recommendReason != null) {
        paramVarArgs.g(2, this.recommendReason);
      }
      AppMethodBeat.o(257546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.recommendReason != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.recommendReason);
      }
      AppMethodBeat.o(257546);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257546);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        avq localavq = (avq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257546);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderContact localFinderContact = new FinderContact();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderContact.parseFrom((byte[])localObject);
            }
            localavq.contact = localFinderContact;
            paramInt += 1;
          }
          AppMethodBeat.o(257546);
          return 0;
        }
        localavq.recommendReason = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257546);
        return 0;
      }
      AppMethodBeat.o(257546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avq
 * JD-Core Version:    0.7.0.1
 */