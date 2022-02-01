package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rd
  extends com.tencent.mm.bw.a
{
  public String Ejo;
  public int Ejp;
  public String Ejq;
  public rm Ejr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113956);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ejo != null) {
        paramVarArgs.d(1, this.Ejo);
      }
      paramVarArgs.aR(2, this.Ejp);
      if (this.Ejq != null) {
        paramVarArgs.d(3, this.Ejq);
      }
      if (this.Ejr != null)
      {
        paramVarArgs.ln(4, this.Ejr.computeSize());
        this.Ejr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ejo == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ejo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Ejp);
      paramInt = i;
      if (this.Ejq != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ejq);
      }
      i = paramInt;
      if (this.Ejr != null) {
        i = paramInt + f.a.a.a.lm(4, this.Ejr.computeSize());
      }
      AppMethodBeat.o(113956);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rd localrd = (rd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113956);
          return -1;
        case 1: 
          localrd.Ejo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 2: 
          localrd.Ejp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113956);
          return 0;
        case 3: 
          localrd.Ejq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113956);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrd.Ejr = ((rm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      AppMethodBeat.o(113956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rd
 * JD-Core Version:    0.7.0.1
 */