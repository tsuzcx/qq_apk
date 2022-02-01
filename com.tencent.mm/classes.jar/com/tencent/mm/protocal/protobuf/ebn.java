package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ebn
  extends com.tencent.mm.bw.a
{
  public eas Ihc;
  public int Ihd;
  public int Ihe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ihc == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147808);
        throw paramVarArgs;
      }
      if (this.Ihc != null)
      {
        paramVarArgs.lJ(1, this.Ihc.computeSize());
        this.Ihc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Ihd);
      paramVarArgs.aS(3, this.Ihe);
      AppMethodBeat.o(147808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ihc == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lI(1, this.Ihc.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Ihd);
      int j = f.a.a.b.b.a.bz(3, this.Ihe);
      AppMethodBeat.o(147808);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Ihc == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebn localebn = (ebn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147808);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eas();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((eas)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localebn.Ihc = ((eas)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147808);
          return 0;
        case 2: 
          localebn.Ihd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147808);
          return 0;
        }
        localebn.Ihe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(147808);
        return 0;
      }
      AppMethodBeat.o(147808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebn
 * JD-Core Version:    0.7.0.1
 */