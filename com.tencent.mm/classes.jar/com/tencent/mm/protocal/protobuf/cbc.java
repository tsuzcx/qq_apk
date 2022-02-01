package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cbc
  extends com.tencent.mm.bw.a
{
  public cld Hod;
  public String Hol;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32352);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hol == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactUsername");
        AppMethodBeat.o(32352);
        throw paramVarArgs;
      }
      if (this.Hod == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
        AppMethodBeat.o(32352);
        throw paramVarArgs;
      }
      if (this.Hol != null) {
        paramVarArgs.d(1, this.Hol);
      }
      if (this.Hod != null)
      {
        paramVarArgs.lJ(2, this.Hod.computeSize());
        this.Hod.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hol == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hol) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hod != null) {
        i = paramInt + f.a.a.a.lI(2, this.Hod.computeSize());
      }
      AppMethodBeat.o(32352);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Hol == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactUsername");
          AppMethodBeat.o(32352);
          throw paramVarArgs;
        }
        if (this.Hod == null)
        {
          paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
          AppMethodBeat.o(32352);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32352);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbc localcbc = (cbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32352);
          return -1;
        case 1: 
          localcbc.Hol = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32352);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cld();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbc.Hod = ((cld)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32352);
        return 0;
      }
      AppMethodBeat.o(32352);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbc
 * JD-Core Version:    0.7.0.1
 */