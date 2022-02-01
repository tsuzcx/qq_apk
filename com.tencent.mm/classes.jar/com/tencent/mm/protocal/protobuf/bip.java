package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bip
  extends com.tencent.mm.cd.a
{
  public String SSR;
  public String SSS;
  public String SST;
  public FinderContact contact;
  public int fansCount;
  public int friendFollowCount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169047);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.oE(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.SSR != null) {
        paramVarArgs.f(2, this.SSR);
      }
      if (this.SSS != null) {
        paramVarArgs.f(3, this.SSS);
      }
      paramVarArgs.aY(4, this.fansCount);
      paramVarArgs.aY(5, this.friendFollowCount);
      if (this.SST != null) {
        paramVarArgs.f(6, this.SST);
      }
      AppMethodBeat.o(169047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label556;
      }
    }
    label556:
    for (int i = g.a.a.a.oD(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SSR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SSR);
      }
      i = paramInt;
      if (this.SSS != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SSS);
      }
      i = i + g.a.a.b.b.a.bM(4, this.fansCount) + g.a.a.b.b.a.bM(5, this.friendFollowCount);
      paramInt = i;
      if (this.SST != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SST);
      }
      AppMethodBeat.o(169047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bip localbip = (bip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169047);
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
            localbip.contact = localFinderContact;
            paramInt += 1;
          }
          AppMethodBeat.o(169047);
          return 0;
        case 2: 
          localbip.SSR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 3: 
          localbip.SSS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 4: 
          localbip.fansCount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169047);
          return 0;
        case 5: 
          localbip.friendFollowCount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(169047);
          return 0;
        }
        localbip.SST = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(169047);
        return 0;
      }
      AppMethodBeat.o(169047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bip
 * JD-Core Version:    0.7.0.1
 */