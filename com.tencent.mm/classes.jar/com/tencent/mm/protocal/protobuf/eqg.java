package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqg
  extends com.tencent.mm.cd.a
{
  public long Uaw;
  public int Uax;
  public eqb UsD;
  public LinkedList<String> UsE;
  public amf UsF;
  public int UsG;
  public due UsH;
  public String UsI;
  public String event;
  public String fMh;
  public long lastUpdateTime;
  public int pos;
  public int style;
  public int weight;
  
  public eqg()
  {
    AppMethodBeat.i(124563);
    this.UsE = new LinkedList();
    AppMethodBeat.o(124563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124564);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UsD != null)
      {
        paramVarArgs.oE(1, this.UsD.computeSize());
        this.UsD.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.lastUpdateTime);
      paramVarArgs.aY(3, this.pos);
      paramVarArgs.aY(4, this.weight);
      paramVarArgs.bm(5, this.Uaw);
      paramVarArgs.e(6, 1, this.UsE);
      paramVarArgs.aY(7, this.style);
      if (this.event != null) {
        paramVarArgs.f(8, this.event);
      }
      if (this.UsF != null)
      {
        paramVarArgs.oE(9, this.UsF.computeSize());
        this.UsF.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.UsG);
      if (this.UsH != null)
      {
        paramVarArgs.oE(11, this.UsH.computeSize());
        this.UsH.writeFields(paramVarArgs);
      }
      if (this.UsI != null) {
        paramVarArgs.f(12, this.UsI);
      }
      if (this.fMh != null) {
        paramVarArgs.f(13, this.fMh);
      }
      paramVarArgs.aY(14, this.Uax);
      AppMethodBeat.o(124564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UsD == null) {
        break label1108;
      }
    }
    label1108:
    for (paramInt = g.a.a.a.oD(1, this.UsD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.lastUpdateTime) + g.a.a.b.b.a.bM(3, this.pos) + g.a.a.b.b.a.bM(4, this.weight) + g.a.a.b.b.a.p(5, this.Uaw) + g.a.a.a.c(6, 1, this.UsE) + g.a.a.b.b.a.bM(7, this.style);
      paramInt = i;
      if (this.event != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.event);
      }
      i = paramInt;
      if (this.UsF != null) {
        i = paramInt + g.a.a.a.oD(9, this.UsF.computeSize());
      }
      i += g.a.a.b.b.a.bM(10, this.UsG);
      paramInt = i;
      if (this.UsH != null) {
        paramInt = i + g.a.a.a.oD(11, this.UsH.computeSize());
      }
      i = paramInt;
      if (this.UsI != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.UsI);
      }
      paramInt = i;
      if (this.fMh != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.fMh);
      }
      i = g.a.a.b.b.a.bM(14, this.Uax);
      AppMethodBeat.o(124564);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UsE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eqg localeqg = (eqg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124564);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqb)localObject2).parseFrom((byte[])localObject1);
            }
            localeqg.UsD = ((eqb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 2: 
          localeqg.lastUpdateTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124564);
          return 0;
        case 3: 
          localeqg.pos = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124564);
          return 0;
        case 4: 
          localeqg.weight = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124564);
          return 0;
        case 5: 
          localeqg.Uaw = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124564);
          return 0;
        case 6: 
          localeqg.UsE.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(124564);
          return 0;
        case 7: 
          localeqg.style = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124564);
          return 0;
        case 8: 
          localeqg.event = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124564);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new amf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((amf)localObject2).parseFrom((byte[])localObject1);
            }
            localeqg.UsF = ((amf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 10: 
          localeqg.UsG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124564);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new due();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((due)localObject2).parseFrom((byte[])localObject1);
            }
            localeqg.UsH = ((due)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 12: 
          localeqg.UsI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124564);
          return 0;
        case 13: 
          localeqg.fMh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124564);
          return 0;
        }
        localeqg.Uax = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(124564);
        return 0;
      }
      AppMethodBeat.o(124564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqg
 * JD-Core Version:    0.7.0.1
 */