package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bw.a
{
  public String AOT;
  public double AOU;
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
  public LinkedList<k> APh;
  public String APi;
  public String APj;
  public double APk;
  public String APl;
  public int CreateTime;
  public String xMq;
  
  public i()
  {
    AppMethodBeat.i(91261);
    this.APh = new LinkedList();
    AppMethodBeat.o(91261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91262);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.AOT != null) {
        paramVarArgs.e(1, this.AOT);
      }
      paramVarArgs.e(2, this.AOU);
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
      if (this.APi != null) {
        paramVarArgs.e(18, this.APi);
      }
      if (this.APj != null) {
        paramVarArgs.e(19, this.APj);
      }
      paramVarArgs.e(20, this.APk);
      if (this.APl != null) {
        paramVarArgs.e(21, this.APl);
      }
      AppMethodBeat.o(91262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AOT == null) {
        break label1416;
      }
    }
    label1416:
    for (paramInt = g.a.a.b.b.a.f(1, this.AOT) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 8);
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
      i = i + g.a.a.b.b.a.bu(16, this.APg) + g.a.a.a.c(17, 8, this.APh);
      paramInt = i;
      if (this.APi != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.APi);
      }
      i = paramInt;
      if (this.APj != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.APj);
      }
      i += g.a.a.b.b.a.fS(20) + 8;
      paramInt = i;
      if (this.APl != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.APl);
      }
      AppMethodBeat.o(91262);
      return paramInt;
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
        AppMethodBeat.o(91262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91262);
          return -1;
        case 1: 
          locali.AOT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 2: 
          locali.AOU = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91262);
          return 0;
        case 3: 
          locali.AOV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 4: 
          locali.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91262);
          return 0;
        case 5: 
          locali.AOW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 6: 
          locali.AOX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91262);
          return 0;
        case 7: 
          locali.AOY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 8: 
          locali.AOZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91262);
          return 0;
        case 9: 
          locali.APa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91262);
          return 0;
        case 10: 
          locali.APb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 11: 
          locali.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 12: 
          locali.APc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 13: 
          locali.APd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 14: 
          locali.APe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 15: 
          locali.APf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 16: 
          locali.APg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91262);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locali.APh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91262);
          return 0;
        case 18: 
          locali.APi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 19: 
          locali.APj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 20: 
          locali.APk = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91262);
          return 0;
        }
        locali.APl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91262);
        return 0;
      }
      AppMethodBeat.o(91262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.i
 * JD-Core Version:    0.7.0.1
 */