package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yq
  extends com.tencent.mm.bw.a
{
  public bss DFA;
  public bss DFB;
  public LinkedList<btg> Gqy;
  public String subtitle;
  public String title;
  
  public yq()
  {
    AppMethodBeat.i(72460);
    this.Gqy = new LinkedList();
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
      paramVarArgs.e(3, 8, this.Gqy);
      if (this.DFA != null)
      {
        paramVarArgs.lJ(4, this.DFA.computeSize());
        this.DFA.writeFields(paramVarArgs);
      }
      if (this.DFB != null)
      {
        paramVarArgs.lJ(5, this.DFB.computeSize());
        this.DFB.writeFields(paramVarArgs);
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
      i += f.a.a.a.c(3, 8, this.Gqy);
      paramInt = i;
      if (this.DFA != null) {
        paramInt = i + f.a.a.a.lI(4, this.DFA.computeSize());
      }
      i = paramInt;
      if (this.DFB != null) {
        i = paramInt + f.a.a.a.lI(5, this.DFB.computeSize());
      }
      AppMethodBeat.o(72461);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gqy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yq localyq = (yq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72461);
          return -1;
        case 1: 
          localyq.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 2: 
          localyq.subtitle = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyq.Gqy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyq.DFA = ((bss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bss();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyq.DFB = ((bss)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yq
 * JD-Core Version:    0.7.0.1
 */