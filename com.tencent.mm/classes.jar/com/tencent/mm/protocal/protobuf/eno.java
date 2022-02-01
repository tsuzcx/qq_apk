package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eno
  extends dop
{
  public int KMz;
  public String KPP;
  public LinkedList<cpb> Mnw;
  public int Nlr;
  public int Nls;
  public LinkedList<cko> Nlt;
  public String UserName;
  
  public eno()
  {
    AppMethodBeat.i(155474);
    this.Mnw = new LinkedList();
    this.Nlt = new LinkedList();
    AppMethodBeat.o(155474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      paramVarArgs.aM(3, this.KMz);
      if (this.KPP != null) {
        paramVarArgs.e(4, this.KPP);
      }
      paramVarArgs.aM(5, this.Nlr);
      paramVarArgs.e(6, 8, this.Mnw);
      paramVarArgs.aM(7, this.Nls);
      paramVarArgs.e(8, 8, this.Nlt);
      AppMethodBeat.o(155475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.UserName);
      }
      i += g.a.a.b.b.a.bu(3, this.KMz);
      paramInt = i;
      if (this.KPP != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KPP);
      }
      i = g.a.a.b.b.a.bu(5, this.Nlr);
      int j = g.a.a.a.c(6, 8, this.Mnw);
      int k = g.a.a.b.b.a.bu(7, this.Nls);
      int m = g.a.a.a.c(8, 8, this.Nlt);
      AppMethodBeat.o(155475);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mnw.clear();
        this.Nlt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eno localeno = (eno)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155475);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeno.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 2: 
          localeno.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 3: 
          localeno.KMz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155475);
          return 0;
        case 4: 
          localeno.KPP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 5: 
          localeno.Nlr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155475);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeno.Mnw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 7: 
          localeno.Nls = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155475);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cko();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cko)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeno.Nlt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      AppMethodBeat.o(155475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eno
 * JD-Core Version:    0.7.0.1
 */