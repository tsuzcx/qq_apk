package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awe
  extends com.tencent.mm.bw.a
{
  public String EzJ;
  public int LCy;
  public long LDN;
  public long LDU;
  public int LEg;
  public avs LGR;
  public awl LGS;
  public axe LGT;
  public int LGU;
  public axj LGV;
  public int dvv;
  public int iqg;
  public long liveId;
  public int liveStatus;
  public int uBn;
  public int wBG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209525);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.liveId);
      paramVarArgs.aM(2, this.uBn);
      paramVarArgs.aM(3, this.liveStatus);
      if (this.EzJ != null) {
        paramVarArgs.e(4, this.EzJ);
      }
      paramVarArgs.aM(5, this.dvv);
      paramVarArgs.aM(6, this.wBG);
      paramVarArgs.aM(7, this.iqg);
      if (this.LGR != null)
      {
        paramVarArgs.ni(8, this.LGR.computeSize());
        this.LGR.writeFields(paramVarArgs);
      }
      if (this.LGS != null)
      {
        paramVarArgs.ni(9, this.LGS.computeSize());
        this.LGS.writeFields(paramVarArgs);
      }
      if (this.LGT != null)
      {
        paramVarArgs.ni(10, this.LGT.computeSize());
        this.LGT.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.LCy);
      paramVarArgs.bb(12, this.LDU);
      paramVarArgs.aM(13, this.LEg);
      paramVarArgs.aM(14, this.LGU);
      paramVarArgs.bb(15, this.LDN);
      if (this.LGV != null)
      {
        paramVarArgs.ni(16, this.LGV.computeSize());
        this.LGV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209525);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.liveId) + 0 + g.a.a.b.b.a.bu(2, this.uBn) + g.a.a.b.b.a.bu(3, this.liveStatus);
      paramInt = i;
      if (this.EzJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.EzJ);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.dvv) + g.a.a.b.b.a.bu(6, this.wBG) + g.a.a.b.b.a.bu(7, this.iqg);
      paramInt = i;
      if (this.LGR != null) {
        paramInt = i + g.a.a.a.nh(8, this.LGR.computeSize());
      }
      i = paramInt;
      if (this.LGS != null) {
        i = paramInt + g.a.a.a.nh(9, this.LGS.computeSize());
      }
      paramInt = i;
      if (this.LGT != null) {
        paramInt = i + g.a.a.a.nh(10, this.LGT.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.LCy) + g.a.a.b.b.a.r(12, this.LDU) + g.a.a.b.b.a.bu(13, this.LEg) + g.a.a.b.b.a.bu(14, this.LGU) + g.a.a.b.b.a.r(15, this.LDN);
      paramInt = i;
      if (this.LGV != null) {
        paramInt = i + g.a.a.a.nh(16, this.LGV.computeSize());
      }
      AppMethodBeat.o(209525);
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
      AppMethodBeat.o(209525);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      awe localawe = (awe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209525);
        return -1;
      case 1: 
        localawe.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209525);
        return 0;
      case 2: 
        localawe.uBn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209525);
        return 0;
      case 3: 
        localawe.liveStatus = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209525);
        return 0;
      case 4: 
        localawe.EzJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209525);
        return 0;
      case 5: 
        localawe.dvv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209525);
        return 0;
      case 6: 
        localawe.wBG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209525);
        return 0;
      case 7: 
        localawe.iqg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209525);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avs();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localawe.LGR = ((avs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209525);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localawe.LGS = ((awl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209525);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((axe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localawe.LGT = ((axe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209525);
        return 0;
      case 11: 
        localawe.LCy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209525);
        return 0;
      case 12: 
        localawe.LDU = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209525);
        return 0;
      case 13: 
        localawe.LEg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209525);
        return 0;
      case 14: 
        localawe.LGU = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209525);
        return 0;
      case 15: 
        localawe.LDN = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209525);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new axj();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((axj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localawe.LGV = ((axj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209525);
      return 0;
    }
    AppMethodBeat.o(209525);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awe
 * JD-Core Version:    0.7.0.1
 */