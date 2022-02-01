package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axg
  extends com.tencent.mm.bw.a
{
  public int AZq;
  public int AZr;
  public det LHI;
  public int LHJ;
  public int LHK;
  public String LHL;
  public String LHM;
  public det LHN;
  public int LHO;
  public String dCu;
  public String dSJ;
  public int status;
  public String title;
  public String twt;
  public long uko;
  public String ukr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.uko);
      if (this.LHI != null)
      {
        paramVarArgs.ni(2, this.LHI.computeSize());
        this.LHI.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.twt != null) {
        paramVarArgs.e(4, this.twt);
      }
      paramVarArgs.aM(5, this.LHJ);
      paramVarArgs.aM(6, this.AZr);
      paramVarArgs.aM(7, this.AZq);
      paramVarArgs.aM(8, this.LHK);
      if (this.LHL != null) {
        paramVarArgs.e(9, this.LHL);
      }
      if (this.LHM != null) {
        paramVarArgs.e(10, this.LHM);
      }
      paramVarArgs.aM(11, this.status);
      if (this.LHN != null)
      {
        paramVarArgs.ni(12, this.LHN.computeSize());
        this.LHN.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.LHO);
      if (this.dSJ != null) {
        paramVarArgs.e(14, this.dSJ);
      }
      if (this.dCu != null) {
        paramVarArgs.e(15, this.dCu);
      }
      if (this.ukr != null) {
        paramVarArgs.e(16, this.ukr);
      }
      AppMethodBeat.o(209558);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.uko) + 0;
      paramInt = i;
      if (this.LHI != null) {
        paramInt = i + g.a.a.a.nh(2, this.LHI.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      paramInt = i;
      if (this.twt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.twt);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LHJ) + g.a.a.b.b.a.bu(6, this.AZr) + g.a.a.b.b.a.bu(7, this.AZq) + g.a.a.b.b.a.bu(8, this.LHK);
      paramInt = i;
      if (this.LHL != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LHL);
      }
      i = paramInt;
      if (this.LHM != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LHM);
      }
      i += g.a.a.b.b.a.bu(11, this.status);
      paramInt = i;
      if (this.LHN != null) {
        paramInt = i + g.a.a.a.nh(12, this.LHN.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.LHO);
      paramInt = i;
      if (this.dSJ != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.dSJ);
      }
      i = paramInt;
      if (this.dCu != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.dCu);
      }
      paramInt = i;
      if (this.ukr != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.ukr);
      }
      AppMethodBeat.o(209558);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209558);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      axg localaxg = (axg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209558);
        return -1;
      case 1: 
        localaxg.uko = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209558);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new det();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaxg.LHI = ((det)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209558);
        return 0;
      case 3: 
        localaxg.title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209558);
        return 0;
      case 4: 
        localaxg.twt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209558);
        return 0;
      case 5: 
        localaxg.LHJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209558);
        return 0;
      case 6: 
        localaxg.AZr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209558);
        return 0;
      case 7: 
        localaxg.AZq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209558);
        return 0;
      case 8: 
        localaxg.LHK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209558);
        return 0;
      case 9: 
        localaxg.LHL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209558);
        return 0;
      case 10: 
        localaxg.LHM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209558);
        return 0;
      case 11: 
        localaxg.status = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209558);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new det();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaxg.LHN = ((det)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209558);
        return 0;
      case 13: 
        localaxg.LHO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209558);
        return 0;
      case 14: 
        localaxg.dSJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209558);
        return 0;
      case 15: 
        localaxg.dCu = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209558);
        return 0;
      }
      localaxg.ukr = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(209558);
      return 0;
    }
    AppMethodBeat.o(209558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axg
 * JD-Core Version:    0.7.0.1
 */