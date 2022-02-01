package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axc
  extends com.tencent.mm.bx.a
{
  public FinderContact contact;
  public int displayFlag;
  public int eQp;
  public boolean hHq;
  public String hJS;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168954);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.qD(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.eQp);
      if (this.hJS != null) {
        paramVarArgs.g(3, this.hJS);
      }
      paramVarArgs.di(4, this.hHq);
      paramVarArgs.bS(5, this.displayFlag);
      if (this.username != null) {
        paramVarArgs.g(6, this.username);
      }
      AppMethodBeat.o(168954);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = i.a.a.a.qC(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.eQp);
      paramInt = i;
      if (this.hJS != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hJS);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.b.b.a.cJ(5, this.displayFlag);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.username);
      }
      AppMethodBeat.o(168954);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        axc localaxc = (axc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168954);
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
            localaxc.contact = localFinderContact;
            paramInt += 1;
          }
          AppMethodBeat.o(168954);
          return 0;
        case 2: 
          localaxc.eQp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(168954);
          return 0;
        case 3: 
          localaxc.hJS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168954);
          return 0;
        case 4: 
          localaxc.hHq = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(168954);
          return 0;
        case 5: 
          localaxc.displayFlag = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(168954);
          return 0;
        }
        localaxc.username = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(168954);
        return 0;
      }
      AppMethodBeat.o(168954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axc
 * JD-Core Version:    0.7.0.1
 */