package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efz
  extends com.tencent.mm.bw.a
{
  public String KWx;
  public LinkedList<ega> KWy;
  public long KWz;
  public String Lug;
  public String Luh;
  public egb NfT;
  public egd NfU;
  
  public efz()
  {
    AppMethodBeat.i(124556);
    this.KWy = new LinkedList();
    AppMethodBeat.o(124556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124557);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lug != null) {
        paramVarArgs.e(1, this.Lug);
      }
      if (this.NfT != null)
      {
        paramVarArgs.ni(2, this.NfT.computeSize());
        this.NfT.writeFields(paramVarArgs);
      }
      if (this.KWx != null) {
        paramVarArgs.e(3, this.KWx);
      }
      paramVarArgs.e(4, 8, this.KWy);
      if (this.Luh != null) {
        paramVarArgs.e(5, this.Luh);
      }
      paramVarArgs.bb(6, this.KWz);
      if (this.NfU != null)
      {
        paramVarArgs.ni(7, this.NfU.computeSize());
        this.NfU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lug == null) {
        break label834;
      }
    }
    label834:
    for (int i = g.a.a.b.b.a.f(1, this.Lug) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NfT != null) {
        paramInt = i + g.a.a.a.nh(2, this.NfT.computeSize());
      }
      i = paramInt;
      if (this.KWx != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KWx);
      }
      i += g.a.a.a.c(4, 8, this.KWy);
      paramInt = i;
      if (this.Luh != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Luh);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.KWz);
      paramInt = i;
      if (this.NfU != null) {
        paramInt = i + g.a.a.a.nh(7, this.NfU.computeSize());
      }
      AppMethodBeat.o(124557);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KWy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        efz localefz = (efz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124557);
          return -1;
        case 1: 
          localefz.Lug = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefz.NfT = ((egb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 3: 
          localefz.KWx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ega();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ega)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefz.KWy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 5: 
          localefz.Luh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 6: 
          localefz.KWz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124557);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((egd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localefz.NfU = ((egd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      AppMethodBeat.o(124557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efz
 * JD-Core Version:    0.7.0.1
 */