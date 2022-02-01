package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.cd.a
{
  public String GHz;
  public LinkedList<d> GTI;
  public int GTJ;
  public int GTK;
  public int GTL;
  public LinkedList<String> GTM;
  public LinkedList<String> GTN;
  public LinkedList<b> GTO;
  public LinkedList<String> GTP;
  public int GTQ;
  public int GTR;
  public LinkedList<m> GTS;
  public LinkedList<a> GTT;
  public k GTU;
  public String detail;
  public String lpM;
  public String name;
  public int version;
  
  public c()
  {
    AppMethodBeat.i(91267);
    this.GTI = new LinkedList();
    this.GTM = new LinkedList();
    this.GTN = new LinkedList();
    this.GTO = new LinkedList();
    this.GTP = new LinkedList();
    this.GTS = new LinkedList();
    this.GTT = new LinkedList();
    AppMethodBeat.o(91267);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91268);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      paramVarArgs.e(2, 8, this.GTI);
      paramVarArgs.aY(3, this.GTJ);
      paramVarArgs.aY(4, this.GTK);
      paramVarArgs.aY(5, this.GTL);
      paramVarArgs.e(6, 1, this.GTM);
      if (this.lpM != null) {
        paramVarArgs.f(7, this.lpM);
      }
      if (this.detail != null) {
        paramVarArgs.f(8, this.detail);
      }
      paramVarArgs.e(9, 1, this.GTN);
      paramVarArgs.e(10, 8, this.GTO);
      paramVarArgs.e(11, 1, this.GTP);
      paramVarArgs.aY(12, this.GTQ);
      paramVarArgs.aY(13, this.GTR);
      paramVarArgs.e(14, 8, this.GTS);
      paramVarArgs.aY(15, this.version);
      paramVarArgs.e(16, 8, this.GTT);
      if (this.GHz != null) {
        paramVarArgs.f(17, this.GHz);
      }
      if (this.GTU != null)
      {
        paramVarArgs.oE(18, this.GTU.computeSize());
        this.GTU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91268);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label1436;
      }
    }
    label1436:
    for (paramInt = g.a.a.b.b.a.g(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.GTI) + g.a.a.b.b.a.bM(3, this.GTJ) + g.a.a.b.b.a.bM(4, this.GTK) + g.a.a.b.b.a.bM(5, this.GTL) + g.a.a.a.c(6, 1, this.GTM);
      paramInt = i;
      if (this.lpM != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.lpM);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.detail);
      }
      i = i + g.a.a.a.c(9, 1, this.GTN) + g.a.a.a.c(10, 8, this.GTO) + g.a.a.a.c(11, 1, this.GTP) + g.a.a.b.b.a.bM(12, this.GTQ) + g.a.a.b.b.a.bM(13, this.GTR) + g.a.a.a.c(14, 8, this.GTS) + g.a.a.b.b.a.bM(15, this.version) + g.a.a.a.c(16, 8, this.GTT);
      paramInt = i;
      if (this.GHz != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.GHz);
      }
      i = paramInt;
      if (this.GTU != null) {
        i = paramInt + g.a.a.a.oD(18, this.GTU.computeSize());
      }
      AppMethodBeat.o(91268);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GTI.clear();
        this.GTM.clear();
        this.GTN.clear();
        this.GTO.clear();
        this.GTP.clear();
        this.GTS.clear();
        this.GTT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91268);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91268);
          return -1;
        case 1: 
          localc.name = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localc.GTI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 3: 
          localc.GTJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91268);
          return 0;
        case 4: 
          localc.GTK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91268);
          return 0;
        case 5: 
          localc.GTL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91268);
          return 0;
        case 6: 
          localc.GTM.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 7: 
          localc.lpM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 8: 
          localc.detail = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 9: 
          localc.GTN.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new b();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((b)localObject2).parseFrom((byte[])localObject1);
            }
            localc.GTO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 11: 
          localc.GTP.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 12: 
          localc.GTQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91268);
          return 0;
        case 13: 
          localc.GTR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91268);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localc.GTS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 15: 
          localc.version = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91268);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localc.GTT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 17: 
          localc.GHz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91268);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new k();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((k)localObject2).parseFrom((byte[])localObject1);
          }
          localc.GTU = ((k)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91268);
        return 0;
      }
      AppMethodBeat.o(91268);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.c
 * JD-Core Version:    0.7.0.1
 */