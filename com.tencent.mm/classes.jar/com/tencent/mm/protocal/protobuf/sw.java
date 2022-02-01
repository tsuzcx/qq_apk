package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sw
  extends com.tencent.mm.bw.a
{
  public String GiD;
  public String GiE;
  public String GiF;
  public int GiG;
  public ti GiH;
  public int GiI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113953);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GiD != null) {
        paramVarArgs.d(1, this.GiD);
      }
      if (this.GiE != null) {
        paramVarArgs.d(2, this.GiE);
      }
      if (this.GiF != null) {
        paramVarArgs.d(3, this.GiF);
      }
      paramVarArgs.aS(4, this.GiG);
      if (this.GiH != null)
      {
        paramVarArgs.lJ(5, this.GiH.computeSize());
        this.GiH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.GiI);
      AppMethodBeat.o(113953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GiD == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.b.b.a.e(1, this.GiD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GiE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GiE);
      }
      i = paramInt;
      if (this.GiF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GiF);
      }
      i += f.a.a.b.b.a.bz(4, this.GiG);
      paramInt = i;
      if (this.GiH != null) {
        paramInt = i + f.a.a.a.lI(5, this.GiH.computeSize());
      }
      i = f.a.a.b.b.a.bz(6, this.GiI);
      AppMethodBeat.o(113953);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sw localsw = (sw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113953);
          return -1;
        case 1: 
          localsw.GiD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 2: 
          localsw.GiE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 3: 
          localsw.GiF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 4: 
          localsw.GiG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113953);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsw.GiH = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113953);
          return 0;
        }
        localsw.GiI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113953);
        return 0;
      }
      AppMethodBeat.o(113953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sw
 * JD-Core Version:    0.7.0.1
 */