package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class daq
  extends com.tencent.mm.bw.a
{
  public String AOT;
  public String AOV;
  public String AOW;
  public int AOX;
  public String AOY;
  public int AOZ;
  public int APa;
  public String APb;
  public String APc;
  public String APd;
  public String APe;
  public String APf;
  public int APg;
  public LinkedList<dyo> APh;
  public int CreateTime;
  public int MFR;
  public String xMq;
  
  public daq()
  {
    AppMethodBeat.i(91596);
    this.APh = new LinkedList();
    AppMethodBeat.o(91596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91597);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.AOT != null) {
        paramVarArgs.e(1, this.AOT);
      }
      paramVarArgs.aM(2, this.MFR);
      if (this.AOV != null) {
        paramVarArgs.e(3, this.AOV);
      }
      paramVarArgs.aM(4, this.CreateTime);
      if (this.AOW != null) {
        paramVarArgs.e(5, this.AOW);
      }
      paramVarArgs.aM(6, this.AOX);
      if (this.AOY != null) {
        paramVarArgs.e(7, this.AOY);
      }
      paramVarArgs.aM(8, this.AOZ);
      paramVarArgs.aM(9, this.APa);
      if (this.APb != null) {
        paramVarArgs.e(10, this.APb);
      }
      if (this.xMq != null) {
        paramVarArgs.e(11, this.xMq);
      }
      if (this.APc != null) {
        paramVarArgs.e(12, this.APc);
      }
      if (this.APd != null) {
        paramVarArgs.e(13, this.APd);
      }
      if (this.APe != null) {
        paramVarArgs.e(14, this.APe);
      }
      if (this.APf != null) {
        paramVarArgs.e(15, this.APf);
      }
      paramVarArgs.aM(16, this.APg);
      paramVarArgs.e(17, 8, this.APh);
      AppMethodBeat.o(91597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AOT == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = g.a.a.b.b.a.f(1, this.AOT) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MFR);
      paramInt = i;
      if (this.AOV != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.AOV);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.CreateTime);
      paramInt = i;
      if (this.AOW != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.AOW);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.AOX);
      paramInt = i;
      if (this.AOY != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.AOY);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.AOZ) + g.a.a.b.b.a.bu(9, this.APa);
      paramInt = i;
      if (this.APb != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.APb);
      }
      i = paramInt;
      if (this.xMq != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.xMq);
      }
      paramInt = i;
      if (this.APc != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.APc);
      }
      i = paramInt;
      if (this.APd != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.APd);
      }
      paramInt = i;
      if (this.APe != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.APe);
      }
      i = paramInt;
      if (this.APf != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.APf);
      }
      paramInt = g.a.a.b.b.a.bu(16, this.APg);
      int j = g.a.a.a.c(17, 8, this.APh);
      AppMethodBeat.o(91597);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.APh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        daq localdaq = (daq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91597);
          return -1;
        case 1: 
          localdaq.AOT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 2: 
          localdaq.MFR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91597);
          return 0;
        case 3: 
          localdaq.AOV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 4: 
          localdaq.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91597);
          return 0;
        case 5: 
          localdaq.AOW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 6: 
          localdaq.AOX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91597);
          return 0;
        case 7: 
          localdaq.AOY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 8: 
          localdaq.AOZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91597);
          return 0;
        case 9: 
          localdaq.APa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91597);
          return 0;
        case 10: 
          localdaq.APb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 11: 
          localdaq.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 12: 
          localdaq.APc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 13: 
          localdaq.APd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 14: 
          localdaq.APe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 15: 
          localdaq.APf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 16: 
          localdaq.APg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91597);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dyo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdaq.APh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      AppMethodBeat.o(91597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daq
 * JD-Core Version:    0.7.0.1
 */