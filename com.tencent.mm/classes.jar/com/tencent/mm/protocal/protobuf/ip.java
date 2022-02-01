package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ip
  extends com.tencent.mm.bw.a
{
  public crj DNL;
  public String DWw;
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
      if (this.DNL != null)
      {
        paramVarArgs.ln(2, this.DNL.computeSize());
        this.DNL.writeFields(paramVarArgs);
      }
      if (this.DWw != null) {
        paramVarArgs.d(3, this.DWw);
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
      if (this.DNL != null) {
        paramInt = i + f.a.a.a.lm(2, this.DNL.computeSize());
      }
      i = paramInt;
      if (this.DWw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DWw);
      }
      AppMethodBeat.o(91360);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ip localip = (ip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91360);
          return -1;
        case 1: 
          localip.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91360);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((crj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localip.DNL = ((crj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91360);
          return 0;
        }
        localip.DWw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91360);
        return 0;
      }
      AppMethodBeat.o(91360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ip
 * JD-Core Version:    0.7.0.1
 */