package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esx
  extends com.tencent.mm.cd.a
{
  public LinkedList<aci> Pye;
  public LinkedList<esy> TFg;
  public String UuD;
  public String UuE;
  public String UuF;
  public String UuG;
  public long UuH;
  public eij UuJ;
  public boolean UuQ;
  public String fwe;
  public int offset;
  public int scene;
  public String wmL;
  
  public esx()
  {
    AppMethodBeat.i(153010);
    this.TFg = new LinkedList();
    this.Pye = new LinkedList();
    AppMethodBeat.o(153010);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153011);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UuD != null) {
        paramVarArgs.f(1, this.UuD);
      }
      if (this.UuE != null) {
        paramVarArgs.f(2, this.UuE);
      }
      if (this.UuF != null) {
        paramVarArgs.f(3, this.UuF);
      }
      if (this.UuG != null) {
        paramVarArgs.f(4, this.UuG);
      }
      if (this.UuJ != null)
      {
        paramVarArgs.oE(5, this.UuJ.computeSize());
        this.UuJ.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.UuH);
      if (this.wmL != null) {
        paramVarArgs.f(7, this.wmL);
      }
      paramVarArgs.aY(8, this.offset);
      paramVarArgs.co(9, this.UuQ);
      paramVarArgs.aY(10, this.scene);
      if (this.fwe != null) {
        paramVarArgs.f(11, this.fwe);
      }
      paramVarArgs.e(12, 8, this.TFg);
      paramVarArgs.e(13, 8, this.Pye);
      AppMethodBeat.o(153011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UuD == null) {
        break label1072;
      }
    }
    label1072:
    for (int i = g.a.a.b.b.a.g(1, this.UuD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UuE != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UuE);
      }
      i = paramInt;
      if (this.UuF != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UuF);
      }
      paramInt = i;
      if (this.UuG != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UuG);
      }
      i = paramInt;
      if (this.UuJ != null) {
        i = paramInt + g.a.a.a.oD(5, this.UuJ.computeSize());
      }
      i += g.a.a.b.b.a.p(6, this.UuH);
      paramInt = i;
      if (this.wmL != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.wmL);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.offset) + (g.a.a.b.b.a.gL(9) + 1) + g.a.a.b.b.a.bM(10, this.scene);
      paramInt = i;
      if (this.fwe != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.fwe);
      }
      i = g.a.a.a.c(12, 8, this.TFg);
      int j = g.a.a.a.c(13, 8, this.Pye);
      AppMethodBeat.o(153011);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TFg.clear();
        this.Pye.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        esx localesx = (esx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153011);
          return -1;
        case 1: 
          localesx.UuD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 2: 
          localesx.UuE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 3: 
          localesx.UuF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 4: 
          localesx.UuG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eij();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eij)localObject2).parseFrom((byte[])localObject1);
            }
            localesx.UuJ = ((eij)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        case 6: 
          localesx.UuH = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(153011);
          return 0;
        case 7: 
          localesx.wmL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 8: 
          localesx.offset = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153011);
          return 0;
        case 9: 
          localesx.UuQ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(153011);
          return 0;
        case 10: 
          localesx.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(153011);
          return 0;
        case 11: 
          localesx.fwe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esy)localObject2).parseFrom((byte[])localObject1);
            }
            localesx.TFg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aci();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aci)localObject2).parseFrom((byte[])localObject1);
          }
          localesx.Pye.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      AppMethodBeat.o(153011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esx
 * JD-Core Version:    0.7.0.1
 */