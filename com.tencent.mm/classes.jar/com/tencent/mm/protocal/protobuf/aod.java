package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aod
  extends com.tencent.mm.bw.a
{
  public int KKA;
  public String LzG;
  public long LzH;
  public String LzI;
  public LinkedList<aob> LzJ;
  public bgn LzK;
  public int oUq;
  
  public aod()
  {
    AppMethodBeat.i(110849);
    this.LzJ = new LinkedList();
    AppMethodBeat.o(110849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110850);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LzG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Rid");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.LzI == null)
      {
        paramVarArgs = new b("Not all required fields were included: MimeType");
        AppMethodBeat.o(110850);
        throw paramVarArgs;
      }
      if (this.LzG != null) {
        paramVarArgs.e(1, this.LzG);
      }
      paramVarArgs.bb(2, this.LzH);
      paramVarArgs.aM(3, this.oUq);
      if (this.LzI != null) {
        paramVarArgs.e(4, this.LzI);
      }
      paramVarArgs.e(5, 8, this.LzJ);
      if (this.LzK != null)
      {
        paramVarArgs.ni(6, this.LzK.computeSize());
        this.LzK.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.KKA);
      AppMethodBeat.o(110850);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LzG == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = g.a.a.b.b.a.f(1, this.LzG) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LzH) + g.a.a.b.b.a.bu(3, this.oUq);
      paramInt = i;
      if (this.LzI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LzI);
      }
      i = paramInt + g.a.a.a.c(5, 8, this.LzJ);
      paramInt = i;
      if (this.LzK != null) {
        paramInt = i + g.a.a.a.nh(6, this.LzK.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.KKA);
      AppMethodBeat.o(110850);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LzJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LzG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Rid");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        if (this.LzI == null)
        {
          paramVarArgs = new b("Not all required fields were included: MimeType");
          AppMethodBeat.o(110850);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110850);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aod localaod = (aod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110850);
          return -1;
        case 1: 
          localaod.LzG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 2: 
          localaod.LzH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(110850);
          return 0;
        case 3: 
          localaod.oUq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(110850);
          return 0;
        case 4: 
          localaod.LzI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(110850);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aob();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aob)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaod.LzJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110850);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaod.LzK = ((bgn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110850);
          return 0;
        }
        localaod.KKA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(110850);
        return 0;
      }
      AppMethodBeat.o(110850);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aod
 * JD-Core Version:    0.7.0.1
 */