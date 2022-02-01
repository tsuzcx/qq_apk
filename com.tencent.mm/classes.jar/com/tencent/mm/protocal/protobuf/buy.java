package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buy
  extends com.tencent.mm.bx.a
{
  public String aact;
  public String aacu;
  public String aacv;
  public FinderContact contact;
  public int fansCount;
  public int friendFollowCount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169047);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.qD(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.aact != null) {
        paramVarArgs.g(2, this.aact);
      }
      if (this.aacu != null) {
        paramVarArgs.g(3, this.aacu);
      }
      paramVarArgs.bS(4, this.fansCount);
      paramVarArgs.bS(5, this.friendFollowCount);
      if (this.aacv != null) {
        paramVarArgs.g(6, this.aacv);
      }
      AppMethodBeat.o(169047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label552;
      }
    }
    label552:
    for (int i = i.a.a.a.qC(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aact != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aact);
      }
      i = paramInt;
      if (this.aacu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aacu);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.fansCount) + i.a.a.b.b.a.cJ(5, this.friendFollowCount);
      paramInt = i;
      if (this.aacv != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aacv);
      }
      AppMethodBeat.o(169047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        buy localbuy = (buy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169047);
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
            localbuy.contact = localFinderContact;
            paramInt += 1;
          }
          AppMethodBeat.o(169047);
          return 0;
        case 2: 
          localbuy.aact = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 3: 
          localbuy.aacu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 4: 
          localbuy.fansCount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169047);
          return 0;
        case 5: 
          localbuy.friendFollowCount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(169047);
          return 0;
        }
        localbuy.aacv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(169047);
        return 0;
      }
      AppMethodBeat.o(169047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buy
 * JD-Core Version:    0.7.0.1
 */