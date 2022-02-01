package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpf
  extends com.tencent.mm.bx.a
{
  public long ZXP;
  public int ZXQ;
  public FinderContact contact;
  public boolean hHq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258124);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.qD(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.hHq);
      paramVarArgs.bv(3, this.ZXP);
      paramVarArgs.bS(4, this.ZXQ);
      AppMethodBeat.o(258124);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label420;
      }
    }
    label420:
    for (paramInt = i.a.a.a.qC(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.q(3, this.ZXP);
      int k = i.a.a.b.b.a.cJ(4, this.ZXQ);
      AppMethodBeat.o(258124);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258124);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bpf localbpf = (bpf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258124);
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
            localbpf.contact = localFinderContact;
            paramInt += 1;
          }
          AppMethodBeat.o(258124);
          return 0;
        case 2: 
          localbpf.hHq = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258124);
          return 0;
        case 3: 
          localbpf.ZXP = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(258124);
          return 0;
        }
        localbpf.ZXQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258124);
        return 0;
      }
      AppMethodBeat.o(258124);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpf
 * JD-Core Version:    0.7.0.1
 */