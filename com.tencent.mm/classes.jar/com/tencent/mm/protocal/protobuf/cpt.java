package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpt
  extends dop
{
  public int KGZ;
  public LinkedList<cpv> KOH;
  public int MvK;
  public LinkedList<cps> MvL;
  public int MvM;
  public String MvN;
  public int Scene;
  
  public cpt()
  {
    AppMethodBeat.i(127498);
    this.MvL = new LinkedList();
    this.KOH = new LinkedList();
    AppMethodBeat.o(127498);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127499);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KGZ);
      paramVarArgs.aM(3, this.MvK);
      paramVarArgs.e(4, 8, this.MvL);
      paramVarArgs.aM(5, this.MvM);
      paramVarArgs.e(6, 8, this.KOH);
      if (this.MvN != null) {
        paramVarArgs.e(7, this.MvN);
      }
      paramVarArgs.aM(8, this.Scene);
      AppMethodBeat.o(127499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KGZ) + g.a.a.b.b.a.bu(3, this.MvK) + g.a.a.a.c(4, 8, this.MvL) + g.a.a.b.b.a.bu(5, this.MvM) + g.a.a.a.c(6, 8, this.KOH);
      paramInt = i;
      if (this.MvN != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MvN);
      }
      i = g.a.a.b.b.a.bu(8, this.Scene);
      AppMethodBeat.o(127499);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MvL.clear();
        this.KOH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpt localcpt = (cpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127499);
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
            localcpt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 2: 
          localcpt.KGZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127499);
          return 0;
        case 3: 
          localcpt.MvK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127499);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cps();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cps)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpt.MvL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 5: 
          localcpt.MvM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127499);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcpt.KOH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 7: 
          localcpt.MvN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127499);
          return 0;
        }
        localcpt.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127499);
        return 0;
      }
      AppMethodBeat.o(127499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpt
 * JD-Core Version:    0.7.0.1
 */