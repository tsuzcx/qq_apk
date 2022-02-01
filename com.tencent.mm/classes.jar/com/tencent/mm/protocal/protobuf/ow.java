package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ow
  extends com.tencent.mm.bw.a
{
  public int KGm;
  public int KIJ;
  public String KUp;
  public int KVA;
  public int KVB;
  public int KVC;
  public int KVD;
  public long KVE;
  public LinkedList<String> KVF;
  public ahh KVG;
  public String KVy;
  public int KVz;
  public int cSx;
  public LinkedList<String> duo;
  public int hXs;
  public int nHh;
  public String url;
  public int weight;
  
  public ow()
  {
    AppMethodBeat.i(212246);
    this.duo = new LinkedList();
    this.KVF = new LinkedList();
    AppMethodBeat.o(212246);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KVy != null) {
        paramVarArgs.e(1, this.KVy);
      }
      paramVarArgs.aM(2, this.weight);
      paramVarArgs.aM(3, this.KVz);
      paramVarArgs.aM(4, this.cSx);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      paramVarArgs.aM(6, this.hXs);
      paramVarArgs.aM(7, this.KVA);
      paramVarArgs.aM(8, this.KVB);
      paramVarArgs.aM(9, this.KVC);
      paramVarArgs.aM(10, this.KVD);
      paramVarArgs.aM(11, this.KGm);
      paramVarArgs.aM(12, this.KIJ);
      paramVarArgs.aM(13, this.nHh);
      paramVarArgs.e(14, 1, this.duo);
      paramVarArgs.bb(15, this.KVE);
      if (this.KUp != null) {
        paramVarArgs.e(18, this.KUp);
      }
      paramVarArgs.e(19, 1, this.KVF);
      if (this.KVG != null)
      {
        paramVarArgs.ni(20, this.KVG.computeSize());
        this.KVG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KVy == null) {
        break label1146;
      }
    }
    label1146:
    for (paramInt = g.a.a.b.b.a.f(1, this.KVy) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.weight) + g.a.a.b.b.a.bu(3, this.KVz) + g.a.a.b.b.a.bu(4, this.cSx);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.hXs) + g.a.a.b.b.a.bu(7, this.KVA) + g.a.a.b.b.a.bu(8, this.KVB) + g.a.a.b.b.a.bu(9, this.KVC) + g.a.a.b.b.a.bu(10, this.KVD) + g.a.a.b.b.a.bu(11, this.KGm) + g.a.a.b.b.a.bu(12, this.KIJ) + g.a.a.b.b.a.bu(13, this.nHh) + g.a.a.a.c(14, 1, this.duo) + g.a.a.b.b.a.r(15, this.KVE);
      paramInt = i;
      if (this.KUp != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.KUp);
      }
      i = paramInt + g.a.a.a.c(19, 1, this.KVF);
      paramInt = i;
      if (this.KVG != null) {
        paramInt = i + g.a.a.a.nh(20, this.KVG.computeSize());
      }
      AppMethodBeat.o(124437);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.duo.clear();
        this.KVF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ow localow = (ow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(124437);
          return -1;
        case 1: 
          localow.KVy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 2: 
          localow.weight = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 3: 
          localow.KVz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 4: 
          localow.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 5: 
          localow.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 6: 
          localow.hXs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 7: 
          localow.KVA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 8: 
          localow.KVB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 9: 
          localow.KVC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 10: 
          localow.KVD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 11: 
          localow.KGm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 12: 
          localow.KIJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 13: 
          localow.nHh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124437);
          return 0;
        case 14: 
          localow.duo.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(124437);
          return 0;
        case 15: 
          localow.KVE = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124437);
          return 0;
        case 18: 
          localow.KUp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 19: 
          localow.KVF.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(124437);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localow.KVG = ((ahh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124437);
        return 0;
      }
      AppMethodBeat.o(124437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ow
 * JD-Core Version:    0.7.0.1
 */