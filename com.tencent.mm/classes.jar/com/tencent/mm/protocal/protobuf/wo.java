package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wo
  extends com.tencent.mm.bw.a
{
  public bnn BND;
  public bnn BNE;
  public LinkedList<boa> EqP;
  public String subtitle;
  public String title;
  
  public wo()
  {
    AppMethodBeat.i(72460);
    this.EqP = new LinkedList();
    AppMethodBeat.o(72460);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72461);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.d(2, this.subtitle);
      }
      paramVarArgs.e(3, 8, this.EqP);
      if (this.BND != null)
      {
        paramVarArgs.ln(4, this.BND.computeSize());
        this.BND.writeFields(paramVarArgs);
      }
      if (this.BNE != null)
      {
        paramVarArgs.ln(5, this.BNE.computeSize());
        this.BNE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.subtitle != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.subtitle);
      }
      i += f.a.a.a.c(3, 8, this.EqP);
      paramInt = i;
      if (this.BND != null) {
        paramInt = i + f.a.a.a.lm(4, this.BND.computeSize());
      }
      i = paramInt;
      if (this.BNE != null) {
        i = paramInt + f.a.a.a.lm(5, this.BNE.computeSize());
      }
      AppMethodBeat.o(72461);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EqP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wo localwo = (wo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72461);
          return -1;
        case 1: 
          localwo.title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 2: 
          localwo.subtitle = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwo.EqP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwo.BND = ((bnn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwo.BNE = ((bnn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      AppMethodBeat.o(72461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wo
 * JD-Core Version:    0.7.0.1
 */