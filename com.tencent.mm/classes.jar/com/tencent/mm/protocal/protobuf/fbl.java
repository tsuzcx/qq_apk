package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fbl
  extends com.tencent.mm.bw.a
{
  public String Md5;
  public String Nvi;
  public int NxA;
  public int NxB;
  public String NxG;
  public fbd NxH;
  public fbk NxI;
  public String xuc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110863);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NxG == null)
      {
        paramVarArgs = new b("Not all required fields were included: EntranceDomain");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.Nvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.NxG != null) {
        paramVarArgs.e(4, this.NxG);
      }
      if (this.Nvi != null) {
        paramVarArgs.e(12, this.Nvi);
      }
      if (this.NxH != null)
      {
        paramVarArgs.ni(9, this.NxH.computeSize());
        this.NxH.writeFields(paramVarArgs);
      }
      if (this.NxI != null)
      {
        paramVarArgs.ni(10, this.NxI.computeSize());
        this.NxI.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(5, this.Md5);
      }
      if (this.xuc != null) {
        paramVarArgs.e(6, this.xuc);
      }
      paramVarArgs.aM(7, this.NxA);
      paramVarArgs.aM(8, this.NxB);
      AppMethodBeat.o(110863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NxG == null) {
        break label906;
      }
    }
    label906:
    for (int i = g.a.a.b.b.a.f(4, this.NxG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nvi != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Nvi);
      }
      i = paramInt;
      if (this.NxH != null) {
        i = paramInt + g.a.a.a.nh(9, this.NxH.computeSize());
      }
      paramInt = i;
      if (this.NxI != null) {
        paramInt = i + g.a.a.a.nh(10, this.NxI.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Md5);
      }
      paramInt = i;
      if (this.xuc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xuc);
      }
      i = g.a.a.b.b.a.bu(7, this.NxA);
      int j = g.a.a.b.b.a.bu(8, this.NxB);
      AppMethodBeat.o(110863);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.NxG == null)
        {
          paramVarArgs = new b("Not all required fields were included: EntranceDomain");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        if (this.Nvi == null)
        {
          paramVarArgs = new b("Not all required fields were included: Charset");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110863);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fbl localfbl = (fbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(110863);
          return -1;
        case 4: 
          localfbl.NxG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 12: 
          localfbl.Nvi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fbd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fbd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfbl.NxH = ((fbd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fbk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fbk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfbl.NxI = ((fbk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 5: 
          localfbl.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 6: 
          localfbl.xuc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 7: 
          localfbl.NxA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(110863);
          return 0;
        }
        localfbl.NxB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(110863);
        return 0;
      }
      AppMethodBeat.o(110863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbl
 * JD-Core Version:    0.7.0.1
 */