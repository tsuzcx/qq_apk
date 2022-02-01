package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class any
  extends com.tencent.mm.bw.a
{
  public anv EGK;
  public String desc;
  public String dol;
  public String iconUrl;
  public int rPI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dol != null) {
        paramVarArgs.d(1, this.dol);
      }
      paramVarArgs.aR(2, this.rPI);
      if (this.iconUrl != null) {
        paramVarArgs.d(3, this.iconUrl);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      if (this.EGK != null)
      {
        paramVarArgs.ln(5, this.EGK.computeSize());
        this.EGK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(164048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dol == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.dol) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.rPI);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.iconUrl);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.desc);
      }
      paramInt = i;
      if (this.EGK != null) {
        paramInt = i + f.a.a.a.lm(5, this.EGK.computeSize());
      }
      AppMethodBeat.o(164048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        any localany = (any)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164048);
          return -1;
        case 1: 
          localany.dol = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 2: 
          localany.rPI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(164048);
          return 0;
        case 3: 
          localany.iconUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 4: 
          localany.desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(164048);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((anv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localany.EGK = ((anv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      AppMethodBeat.o(164048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.any
 * JD-Core Version:    0.7.0.1
 */