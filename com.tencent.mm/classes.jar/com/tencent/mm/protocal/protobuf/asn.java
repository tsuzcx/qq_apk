package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asn
  extends com.tencent.mm.cd.a
{
  public int cUP;
  public FinderContact contact;
  public int displayFlag;
  public boolean fCB;
  public String fFa;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168954);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.oE(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.cUP);
      if (this.fFa != null) {
        paramVarArgs.f(3, this.fFa);
      }
      paramVarArgs.co(4, this.fCB);
      paramVarArgs.aY(5, this.displayFlag);
      if (this.username != null) {
        paramVarArgs.f(6, this.username);
      }
      AppMethodBeat.o(168954);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = g.a.a.a.oD(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.cUP);
      paramInt = i;
      if (this.fFa != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fFa);
      }
      i = paramInt + (g.a.a.b.b.a.gL(4) + 1) + g.a.a.b.b.a.bM(5, this.displayFlag);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.username);
      }
      AppMethodBeat.o(168954);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168954);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        asn localasn = (asn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168954);
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
            localasn.contact = localFinderContact;
            paramInt += 1;
          }
          AppMethodBeat.o(168954);
          return 0;
        case 2: 
          localasn.cUP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(168954);
          return 0;
        case 3: 
          localasn.fFa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(168954);
          return 0;
        case 4: 
          localasn.fCB = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(168954);
          return 0;
        case 5: 
          localasn.displayFlag = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(168954);
          return 0;
        }
        localasn.username = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(168954);
        return 0;
      }
      AppMethodBeat.o(168954);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asn
 * JD-Core Version:    0.7.0.1
 */