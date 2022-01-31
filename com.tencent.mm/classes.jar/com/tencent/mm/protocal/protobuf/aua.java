package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aua
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public int iFL;
  public String knv;
  public String kqb;
  public atz xch;
  public boolean xiS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48864);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.knv != null) {
        paramVarArgs.e(1, this.knv);
      }
      if (this.kqb != null) {
        paramVarArgs.e(2, this.kqb);
      }
      if (this.cDz != null) {
        paramVarArgs.e(3, this.cDz);
      }
      paramVarArgs.aS(4, this.xiS);
      paramVarArgs.aO(5, this.iFL);
      if (this.xch != null)
      {
        paramVarArgs.iQ(6, this.xch.computeSize());
        this.xch.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.knv == null) {
        break label578;
      }
    }
    label578:
    for (int i = e.a.a.b.b.a.f(1, this.knv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kqb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kqb);
      }
      i = paramInt;
      if (this.cDz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cDz);
      }
      i = i + (e.a.a.b.b.a.eW(4) + 1) + e.a.a.b.b.a.bl(5, this.iFL);
      paramInt = i;
      if (this.xch != null) {
        paramInt = i + e.a.a.a.iP(6, this.xch.computeSize());
      }
      AppMethodBeat.o(48864);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aua localaua = (aua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48864);
          return -1;
        case 1: 
          localaua.knv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48864);
          return 0;
        case 2: 
          localaua.kqb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48864);
          return 0;
        case 3: 
          localaua.cDz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48864);
          return 0;
        case 4: 
          localaua.xiS = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(48864);
          return 0;
        case 5: 
          localaua.iFL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48864);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new atz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((atz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaua.xch = ((atz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48864);
        return 0;
      }
      AppMethodBeat.o(48864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aua
 * JD-Core Version:    0.7.0.1
 */