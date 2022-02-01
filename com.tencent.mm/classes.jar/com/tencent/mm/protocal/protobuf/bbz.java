package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbz
  extends com.tencent.mm.bw.a
{
  public String LLd;
  public String LLe;
  public String LLf;
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
        paramVarArgs.ni(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.LLd != null) {
        paramVarArgs.e(2, this.LLd);
      }
      if (this.LLe != null) {
        paramVarArgs.e(3, this.LLe);
      }
      paramVarArgs.aM(4, this.fansCount);
      paramVarArgs.aM(5, this.friendFollowCount);
      if (this.LLf != null) {
        paramVarArgs.e(6, this.LLf);
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
    for (int i = g.a.a.a.nh(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LLd != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LLd);
      }
      i = paramInt;
      if (this.LLe != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LLe);
      }
      i = i + g.a.a.b.b.a.bu(4, this.fansCount) + g.a.a.b.b.a.bu(5, this.friendFollowCount);
      paramInt = i;
      if (this.LLf != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LLf);
      }
      AppMethodBeat.o(169047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bbz localbbz = (bbz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169047);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbbz.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169047);
          return 0;
        case 2: 
          localbbz.LLd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 3: 
          localbbz.LLe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 4: 
          localbbz.fansCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169047);
          return 0;
        case 5: 
          localbbz.friendFollowCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169047);
          return 0;
        }
        localbbz.LLf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169047);
        return 0;
      }
      AppMethodBeat.o(169047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbz
 * JD-Core Version:    0.7.0.1
 */