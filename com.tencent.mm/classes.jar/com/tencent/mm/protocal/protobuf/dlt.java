package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlt
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public int Cqs;
  public dmc TSC;
  public dmf TSD;
  public String TSE;
  public LinkedList<dlw> TSF;
  public float TSG;
  public String TSH;
  public String TSI;
  public LinkedList<dlr> TSJ;
  public String TxS;
  public String UID;
  public String mVA;
  public String mVH;
  public String mVz;
  
  public dlt()
  {
    AppMethodBeat.i(206856);
    this.TSF = new LinkedList();
    this.TSJ = new LinkedList();
    AppMethodBeat.o(206856);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206859);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UID != null) {
        paramVarArgs.f(1, this.UID);
      }
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      if (this.TSC != null)
      {
        paramVarArgs.oE(3, this.TSC.computeSize());
        this.TSC.writeFields(paramVarArgs);
      }
      if (this.TSD != null)
      {
        paramVarArgs.oE(4, this.TSD.computeSize());
        this.TSD.writeFields(paramVarArgs);
      }
      if (this.TxS != null) {
        paramVarArgs.f(5, this.TxS);
      }
      if (this.TSE != null) {
        paramVarArgs.f(6, this.TSE);
      }
      paramVarArgs.e(7, 8, this.TSF);
      paramVarArgs.i(8, this.TSG);
      if (this.mVz != null) {
        paramVarArgs.f(9, this.mVz);
      }
      if (this.mVA != null) {
        paramVarArgs.f(10, this.mVA);
      }
      if (this.TSH != null) {
        paramVarArgs.f(11, this.TSH);
      }
      if (this.TSI != null) {
        paramVarArgs.f(12, this.TSI);
      }
      paramVarArgs.aY(13, this.Cqs);
      if (this.mVH != null) {
        paramVarArgs.f(14, this.mVH);
      }
      paramVarArgs.e(15, 8, this.TSJ);
      AppMethodBeat.o(206859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UID == null) {
        break label1305;
      }
    }
    label1305:
    for (int i = g.a.a.b.b.a.g(1, this.UID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMP);
      }
      i = paramInt;
      if (this.TSC != null) {
        i = paramInt + g.a.a.a.oD(3, this.TSC.computeSize());
      }
      paramInt = i;
      if (this.TSD != null) {
        paramInt = i + g.a.a.a.oD(4, this.TSD.computeSize());
      }
      i = paramInt;
      if (this.TxS != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TxS);
      }
      paramInt = i;
      if (this.TSE != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TSE);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.TSF) + (g.a.a.b.b.a.gL(8) + 4);
      paramInt = i;
      if (this.mVz != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.mVz);
      }
      i = paramInt;
      if (this.mVA != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.mVA);
      }
      paramInt = i;
      if (this.TSH != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TSH);
      }
      i = paramInt;
      if (this.TSI != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.TSI);
      }
      i += g.a.a.b.b.a.bM(13, this.Cqs);
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.mVH);
      }
      i = g.a.a.a.c(15, 8, this.TSJ);
      AppMethodBeat.o(206859);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TSF.clear();
        this.TSJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dlt localdlt = (dlt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206859);
          return -1;
        case 1: 
          localdlt.UID = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 2: 
          localdlt.CMP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmc)localObject2).parseFrom((byte[])localObject1);
            }
            localdlt.TSC = ((dmc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206859);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmf)localObject2).parseFrom((byte[])localObject1);
            }
            localdlt.TSD = ((dmf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206859);
          return 0;
        case 5: 
          localdlt.TxS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 6: 
          localdlt.TSE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlw)localObject2).parseFrom((byte[])localObject1);
            }
            localdlt.TSF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206859);
          return 0;
        case 8: 
          localdlt.TSG = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(206859);
          return 0;
        case 9: 
          localdlt.mVz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 10: 
          localdlt.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 11: 
          localdlt.TSH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 12: 
          localdlt.TSI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        case 13: 
          localdlt.Cqs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206859);
          return 0;
        case 14: 
          localdlt.mVH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206859);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dlr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dlr)localObject2).parseFrom((byte[])localObject1);
          }
          localdlt.TSJ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(206859);
        return 0;
      }
      AppMethodBeat.o(206859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlt
 * JD-Core Version:    0.7.0.1
 */