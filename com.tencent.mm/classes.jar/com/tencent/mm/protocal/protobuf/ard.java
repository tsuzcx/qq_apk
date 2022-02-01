package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ard
  extends com.tencent.mm.bx.a
{
  public String GoW;
  public String GoX;
  public String GoY;
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
        paramVarArgs.lC(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.GoW != null) {
        paramVarArgs.d(2, this.GoW);
      }
      if (this.GoX != null) {
        paramVarArgs.d(3, this.GoX);
      }
      paramVarArgs.aS(4, this.fansCount);
      paramVarArgs.aS(5, this.friendFollowCount);
      if (this.GoY != null) {
        paramVarArgs.d(6, this.GoY);
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
    for (int i = f.a.a.a.lB(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GoW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GoW);
      }
      i = paramInt;
      if (this.GoX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GoX);
      }
      i = i + f.a.a.b.b.a.bz(4, this.fansCount) + f.a.a.b.b.a.bz(5, this.friendFollowCount);
      paramInt = i;
      if (this.GoY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GoY);
      }
      AppMethodBeat.o(169047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ard localard = (ard)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169047);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localard.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169047);
          return 0;
        case 2: 
          localard.GoW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 3: 
          localard.GoX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 4: 
          localard.fansCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169047);
          return 0;
        case 5: 
          localard.friendFollowCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169047);
          return 0;
        }
        localard.GoY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169047);
        return 0;
      }
      AppMethodBeat.o(169047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ard
 * JD-Core Version:    0.7.0.1
 */