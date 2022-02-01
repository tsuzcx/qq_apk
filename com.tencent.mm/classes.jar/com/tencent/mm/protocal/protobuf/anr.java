package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anr
  extends com.tencent.mm.bw.a
{
  public String EGA;
  public String EGy;
  public String EGz;
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
        paramVarArgs.ln(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.EGy != null) {
        paramVarArgs.d(2, this.EGy);
      }
      if (this.EGz != null) {
        paramVarArgs.d(3, this.EGz);
      }
      paramVarArgs.aR(4, this.fansCount);
      paramVarArgs.aR(5, this.friendFollowCount);
      if (this.EGA != null) {
        paramVarArgs.d(6, this.EGA);
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
    for (int i = f.a.a.a.lm(1, this.contact.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EGy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EGy);
      }
      i = paramInt;
      if (this.EGz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EGz);
      }
      i = i + f.a.a.b.b.a.bx(4, this.fansCount) + f.a.a.b.b.a.bx(5, this.friendFollowCount);
      paramInt = i;
      if (this.EGA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EGA);
      }
      AppMethodBeat.o(169047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anr localanr = (anr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169047);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localanr.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169047);
          return 0;
        case 2: 
          localanr.EGy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 3: 
          localanr.EGz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169047);
          return 0;
        case 4: 
          localanr.fansCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169047);
          return 0;
        case 5: 
          localanr.friendFollowCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169047);
          return 0;
        }
        localanr.EGA = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169047);
        return 0;
      }
      AppMethodBeat.o(169047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anr
 * JD-Core Version:    0.7.0.1
 */