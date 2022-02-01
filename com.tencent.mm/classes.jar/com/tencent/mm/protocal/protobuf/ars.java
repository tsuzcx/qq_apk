package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ars
  extends com.tencent.mm.bw.a
{
  public String GIm;
  public String GIn;
  public String GIo;
  public FinderContact contact;
  public int fansCount;
  public int friendFollowCount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169047);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.lJ(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.GIm != null) {
        paramVarArgs.d(2, this.GIm);
      }
      if (this.GIn != null) {
        paramVarArgs.d(3, this.GIn);
      }
      paramVarArgs.aS(4, this.fansCount);
      paramVarArgs.aS(5, this.friendFollowCount);
      if (this.GIo != null) {
        paramVarArgs.d(6, this.GIo);
      }
      AppMethodBeat.o(169047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.a.lI(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GIm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GIm);
      }
      i = paramInt;
      if (this.GIn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GIn);
      }
      i = i + f.a.a.b.b.a.bz(4, this.fansCount) + f.a.a.b.b.a.bz(5, this.friendFollowCount);
      paramInt = i;
      if (this.GIo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GIo);
      }
      AppMethodBeat.o(169047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ars localars = (ars)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169047);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localars.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169047);
          return 0;
        case 2: 
          localars.GIm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 3: 
          localars.GIn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 4: 
          localars.fansCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169047);
          return 0;
        case 5: 
          localars.friendFollowCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169047);
          return 0;
        }
        localars.GIo = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169047);
        return 0;
      }
      AppMethodBeat.o(169047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ars
 * JD-Core Version:    0.7.0.1
 */