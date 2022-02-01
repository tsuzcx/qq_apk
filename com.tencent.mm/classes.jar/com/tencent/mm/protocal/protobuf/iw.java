package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iw
  extends com.tencent.mm.bw.a
{
  public cxk FLp;
  public String FUn;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91360);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.FLp != null)
      {
        paramVarArgs.lJ(2, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      if (this.FUn != null) {
        paramVarArgs.d(3, this.FUn);
      }
      AppMethodBeat.o(91360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FLp != null) {
        paramInt = i + f.a.a.a.lI(2, this.FLp.computeSize());
      }
      i = paramInt;
      if (this.FUn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FUn);
      }
      AppMethodBeat.o(91360);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        iw localiw = (iw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91360);
          return -1;
        case 1: 
          localiw.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91360);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localiw.FLp = ((cxk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91360);
          return 0;
        }
        localiw.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91360);
        return 0;
      }
      AppMethodBeat.o(91360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iw
 * JD-Core Version:    0.7.0.1
 */