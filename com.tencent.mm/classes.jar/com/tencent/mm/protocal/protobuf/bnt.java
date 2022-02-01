package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnt
  extends com.tencent.mm.bw.a
{
  public bns GSA;
  public boolean HaE;
  public String dEM;
  public int mwj;
  public String oFF;
  public String oIr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oFF != null) {
        paramVarArgs.d(1, this.oFF);
      }
      if (this.oIr != null) {
        paramVarArgs.d(2, this.oIr);
      }
      if (this.dEM != null) {
        paramVarArgs.d(3, this.dEM);
      }
      paramVarArgs.bC(4, this.HaE);
      paramVarArgs.aS(5, this.mwj);
      if (this.GSA != null)
      {
        paramVarArgs.lJ(6, this.GSA.computeSize());
        this.GSA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oFF == null) {
        break label574;
      }
    }
    label574:
    for (int i = f.a.a.b.b.a.e(1, this.oFF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oIr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oIr);
      }
      i = paramInt;
      if (this.dEM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dEM);
      }
      i = i + f.a.a.b.b.a.amF(4) + f.a.a.b.b.a.bz(5, this.mwj);
      paramInt = i;
      if (this.GSA != null) {
        paramInt = i + f.a.a.a.lI(6, this.GSA.computeSize());
      }
      AppMethodBeat.o(72496);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnt localbnt = (bnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72496);
          return -1;
        case 1: 
          localbnt.oFF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 2: 
          localbnt.oIr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 3: 
          localbnt.dEM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 4: 
          localbnt.HaE = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(72496);
          return 0;
        case 5: 
          localbnt.mwj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72496);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bns();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bns)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbnt.GSA = ((bns)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      AppMethodBeat.o(72496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnt
 * JD-Core Version:    0.7.0.1
 */