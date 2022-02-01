package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkr
  extends com.tencent.mm.bw.a
{
  public int KUh;
  public String KUk;
  public String KWA;
  public LinkedList<String> KWr;
  public String Luj;
  public String Luk;
  public LinkedList<dlb> MOG;
  public int MOH;
  public String MOI;
  
  public dkr()
  {
    AppMethodBeat.i(212294);
    this.MOG = new LinkedList();
    this.KWr = new LinkedList();
    AppMethodBeat.o(212294);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212295);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KWA != null) {
        paramVarArgs.e(1, this.KWA);
      }
      paramVarArgs.e(2, 8, this.MOG);
      paramVarArgs.aM(3, this.KUh);
      paramVarArgs.aM(4, this.MOH);
      if (this.KUk != null) {
        paramVarArgs.e(5, this.KUk);
      }
      paramVarArgs.e(6, 1, this.KWr);
      if (this.Luk != null) {
        paramVarArgs.e(7, this.Luk);
      }
      if (this.Luj != null) {
        paramVarArgs.e(8, this.Luj);
      }
      if (this.MOI != null) {
        paramVarArgs.e(9, this.MOI);
      }
      AppMethodBeat.o(212295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KWA == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = g.a.a.b.b.a.f(1, this.KWA) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.MOG) + g.a.a.b.b.a.bu(3, this.KUh) + g.a.a.b.b.a.bu(4, this.MOH);
      paramInt = i;
      if (this.KUk != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KUk);
      }
      i = paramInt + g.a.a.a.c(6, 1, this.KWr);
      paramInt = i;
      if (this.Luk != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Luk);
      }
      i = paramInt;
      if (this.Luj != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Luj);
      }
      paramInt = i;
      if (this.MOI != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MOI);
      }
      AppMethodBeat.o(212295);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MOG.clear();
        this.KWr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212295);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dkr localdkr = (dkr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212295);
          return -1;
        case 1: 
          localdkr.KWA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212295);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dlb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdkr.MOG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212295);
          return 0;
        case 3: 
          localdkr.KUh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212295);
          return 0;
        case 4: 
          localdkr.MOH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212295);
          return 0;
        case 5: 
          localdkr.KUk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212295);
          return 0;
        case 6: 
          localdkr.KWr.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(212295);
          return 0;
        case 7: 
          localdkr.Luk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212295);
          return 0;
        case 8: 
          localdkr.Luj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212295);
          return 0;
        }
        localdkr.MOI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212295);
        return 0;
      }
      AppMethodBeat.o(212295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkr
 * JD-Core Version:    0.7.0.1
 */