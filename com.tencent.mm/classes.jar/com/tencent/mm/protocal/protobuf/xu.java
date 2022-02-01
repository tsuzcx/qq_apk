package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xu
  extends com.tencent.mm.bw.a
{
  public bss DFA;
  public bss DFB;
  public String Geb;
  public String GpN;
  public int GpO;
  public String dyI;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.DFA != null)
      {
        paramVarArgs.lJ(3, this.DFA.computeSize());
        this.DFA.writeFields(paramVarArgs);
      }
      if (this.DFB != null)
      {
        paramVarArgs.lJ(4, this.DFB.computeSize());
        this.DFB.writeFields(paramVarArgs);
      }
      if (this.GpN != null) {
        paramVarArgs.d(5, this.GpN);
      }
      if (this.Geb != null) {
        paramVarArgs.d(6, this.Geb);
      }
      paramVarArgs.aS(7, this.GpO);
      AppMethodBeat.o(177332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label754;
      }
    }
    label754:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.DFA != null) {
        i = paramInt + f.a.a.a.lI(3, this.DFA.computeSize());
      }
      paramInt = i;
      if (this.DFB != null) {
        paramInt = i + f.a.a.a.lI(4, this.DFB.computeSize());
      }
      i = paramInt;
      if (this.GpN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GpN);
      }
      paramInt = i;
      if (this.Geb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Geb);
      }
      i = f.a.a.b.b.a.bz(7, this.GpO);
      AppMethodBeat.o(177332);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(177332);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xu localxu = (xu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(177332);
          return -1;
        case 1: 
          localxu.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 2: 
          localxu.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxu.DFA = ((bss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
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
            localxu.DFB = ((bss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 5: 
          localxu.GpN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 6: 
          localxu.Geb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(177332);
          return 0;
        }
        localxu.GpO = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(177332);
        return 0;
      }
      AppMethodBeat.o(177332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xu
 * JD-Core Version:    0.7.0.1
 */