package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mo
  extends com.tencent.mm.bw.a
{
  public mr Ebv;
  public String Ebw;
  public String Ebx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebv != null)
      {
        paramVarArgs.ln(1, this.Ebv.computeSize());
        this.Ebv.writeFields(paramVarArgs);
      }
      if (this.Ebw != null) {
        paramVarArgs.d(2, this.Ebw);
      }
      if (this.Ebx != null) {
        paramVarArgs.d(3, this.Ebx);
      }
      AppMethodBeat.o(124421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ebv == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.a.lm(1, this.Ebv.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ebw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ebw);
      }
      i = paramInt;
      if (this.Ebx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ebx);
      }
      AppMethodBeat.o(124421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mo localmo = (mo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124421);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((mr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmo.Ebv = ((mr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124421);
          return 0;
        case 2: 
          localmo.Ebw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124421);
          return 0;
        }
        localmo.Ebx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(124421);
        return 0;
      }
      AppMethodBeat.o(124421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mo
 * JD-Core Version:    0.7.0.1
 */