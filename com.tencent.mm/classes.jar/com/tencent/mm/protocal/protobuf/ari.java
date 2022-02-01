package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ari
  extends com.tencent.mm.cd.a
{
  public FinderContact contact;
  public String recommendReason;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199188);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.oE(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.recommendReason != null) {
        paramVarArgs.f(2, this.recommendReason);
      }
      AppMethodBeat.o(199188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.recommendReason != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.recommendReason);
      }
      AppMethodBeat.o(199188);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199188);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ari localari = (ari)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199188);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderContact localFinderContact = new FinderContact();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderContact.parseFrom((byte[])localObject);
            }
            localari.contact = localFinderContact;
            paramInt += 1;
          }
          AppMethodBeat.o(199188);
          return 0;
        }
        localari.recommendReason = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(199188);
        return 0;
      }
      AppMethodBeat.o(199188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ari
 * JD-Core Version:    0.7.0.1
 */