package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oq
  extends com.tencent.mm.cd.a
{
  public int RHF;
  public int RKb;
  public String RWE;
  public int RWF;
  public int RWG;
  public int RWH;
  public int RWI;
  public int RWJ;
  public long RWK;
  public LinkedList<String> RWL;
  public ahs RWM;
  public int cUP;
  public LinkedList<String> fmW;
  public int qJt;
  public int time;
  public String url;
  public int weight;
  public String zaX;
  
  public oq()
  {
    AppMethodBeat.i(207415);
    this.fmW = new LinkedList();
    this.RWL = new LinkedList();
    AppMethodBeat.o(207415);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RWE != null) {
        paramVarArgs.f(1, this.RWE);
      }
      paramVarArgs.aY(2, this.weight);
      paramVarArgs.aY(3, this.RWF);
      paramVarArgs.aY(4, this.cUP);
      if (this.url != null) {
        paramVarArgs.f(5, this.url);
      }
      paramVarArgs.aY(6, this.time);
      paramVarArgs.aY(7, this.RWG);
      paramVarArgs.aY(8, this.RWH);
      paramVarArgs.aY(9, this.RWI);
      paramVarArgs.aY(10, this.RWJ);
      paramVarArgs.aY(11, this.RHF);
      paramVarArgs.aY(12, this.RKb);
      paramVarArgs.aY(13, this.qJt);
      paramVarArgs.e(14, 1, this.fmW);
      paramVarArgs.bm(15, this.RWK);
      if (this.zaX != null) {
        paramVarArgs.f(18, this.zaX);
      }
      paramVarArgs.e(19, 1, this.RWL);
      if (this.RWM != null)
      {
        paramVarArgs.oE(20, this.RWM.computeSize());
        this.RWM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RWE == null) {
        break label1124;
      }
    }
    label1124:
    for (paramInt = g.a.a.b.b.a.g(1, this.RWE) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.weight) + g.a.a.b.b.a.bM(3, this.RWF) + g.a.a.b.b.a.bM(4, this.cUP);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.time) + g.a.a.b.b.a.bM(7, this.RWG) + g.a.a.b.b.a.bM(8, this.RWH) + g.a.a.b.b.a.bM(9, this.RWI) + g.a.a.b.b.a.bM(10, this.RWJ) + g.a.a.b.b.a.bM(11, this.RHF) + g.a.a.b.b.a.bM(12, this.RKb) + g.a.a.b.b.a.bM(13, this.qJt) + g.a.a.a.c(14, 1, this.fmW) + g.a.a.b.b.a.p(15, this.RWK);
      paramInt = i;
      if (this.zaX != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.zaX);
      }
      i = paramInt + g.a.a.a.c(19, 1, this.RWL);
      paramInt = i;
      if (this.RWM != null) {
        paramInt = i + g.a.a.a.oD(20, this.RWM.computeSize());
      }
      AppMethodBeat.o(124437);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.fmW.clear();
        this.RWL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        oq localoq = (oq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(124437);
          return -1;
        case 1: 
          localoq.RWE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 2: 
          localoq.weight = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 3: 
          localoq.RWF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 4: 
          localoq.cUP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 5: 
          localoq.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 6: 
          localoq.time = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 7: 
          localoq.RWG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 8: 
          localoq.RWH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 9: 
          localoq.RWI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 10: 
          localoq.RWJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 11: 
          localoq.RHF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 12: 
          localoq.RKb = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 13: 
          localoq.qJt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124437);
          return 0;
        case 14: 
          localoq.fmW.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(124437);
          return 0;
        case 15: 
          localoq.RWK = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(124437);
          return 0;
        case 18: 
          localoq.zaX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124437);
          return 0;
        case 19: 
          localoq.RWL.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(124437);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ahs localahs = new ahs();
          if ((localObject != null) && (localObject.length > 0)) {
            localahs.parseFrom((byte[])localObject);
          }
          localoq.RWM = localahs;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oq
 * JD-Core Version:    0.7.0.1
 */