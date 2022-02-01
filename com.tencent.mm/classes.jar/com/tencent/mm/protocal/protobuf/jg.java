package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jg
  extends com.tencent.mm.bw.a
{
  public String CiX;
  public int CiY;
  public int CiZ;
  public String Cja;
  public String Cjb;
  public String Cjc;
  public long Cjf;
  public LinkedList<ajr> KNO;
  public String KNP;
  public String KNQ;
  public String dDj;
  public String ynT;
  
  public jg()
  {
    AppMethodBeat.i(72420);
    this.KNO = new LinkedList();
    AppMethodBeat.o(72420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72421);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dDj != null) {
        paramVarArgs.e(1, this.dDj);
      }
      if (this.ynT != null) {
        paramVarArgs.e(2, this.ynT);
      }
      if (this.CiX != null) {
        paramVarArgs.e(3, this.CiX);
      }
      paramVarArgs.aM(4, this.CiY);
      paramVarArgs.aM(5, this.CiZ);
      paramVarArgs.e(6, 8, this.KNO);
      if (this.Cja != null) {
        paramVarArgs.e(7, this.Cja);
      }
      if (this.Cjb != null) {
        paramVarArgs.e(8, this.Cjb);
      }
      if (this.Cjc != null) {
        paramVarArgs.e(9, this.Cjc);
      }
      if (this.KNP != null) {
        paramVarArgs.e(10, this.KNP);
      }
      if (this.KNQ != null) {
        paramVarArgs.e(11, this.KNQ);
      }
      paramVarArgs.bb(12, this.Cjf);
      AppMethodBeat.o(72421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dDj == null) {
        break label918;
      }
    }
    label918:
    for (int i = g.a.a.b.b.a.f(1, this.dDj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ynT != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ynT);
      }
      i = paramInt;
      if (this.CiX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.CiX);
      }
      i = i + g.a.a.b.b.a.bu(4, this.CiY) + g.a.a.b.b.a.bu(5, this.CiZ) + g.a.a.a.c(6, 8, this.KNO);
      paramInt = i;
      if (this.Cja != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Cja);
      }
      i = paramInt;
      if (this.Cjb != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Cjb);
      }
      paramInt = i;
      if (this.Cjc != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Cjc);
      }
      i = paramInt;
      if (this.KNP != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.KNP);
      }
      paramInt = i;
      if (this.KNQ != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KNQ);
      }
      i = g.a.a.b.b.a.r(12, this.Cjf);
      AppMethodBeat.o(72421);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KNO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        jg localjg = (jg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72421);
          return -1;
        case 1: 
          localjg.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 2: 
          localjg.ynT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 3: 
          localjg.CiX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 4: 
          localjg.CiY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72421);
          return 0;
        case 5: 
          localjg.CiZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72421);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ajr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localjg.KNO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72421);
          return 0;
        case 7: 
          localjg.Cja = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 8: 
          localjg.Cjb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 9: 
          localjg.Cjc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 10: 
          localjg.KNP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 11: 
          localjg.KNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72421);
          return 0;
        }
        localjg.Cjf = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(72421);
        return 0;
      }
      AppMethodBeat.o(72421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jg
 * JD-Core Version:    0.7.0.1
 */