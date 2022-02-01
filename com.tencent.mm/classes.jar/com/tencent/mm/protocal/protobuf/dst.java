package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dst
  extends com.tencent.mm.cd.a
{
  public int CMT;
  public String CNU;
  public String CQz;
  public String RGH;
  public String RGI;
  public String RGJ;
  public String RGK;
  public String RGL;
  public String RGM;
  public fqj RGN;
  public String RSZ;
  public String SZF;
  public int TJI;
  public String TYZ;
  public int TZa;
  public LinkedList<eaf> TZb;
  public String TZc;
  public String TZd;
  public String TZe;
  public String TZf;
  public String TZg;
  public String TZh;
  public String TZi;
  public int TZj;
  public String jUi;
  
  public dst()
  {
    AppMethodBeat.i(152664);
    this.TZb = new LinkedList();
    AppMethodBeat.o(152664);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152665);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jUi != null) {
        paramVarArgs.f(1, this.jUi);
      }
      if (this.CQz != null) {
        paramVarArgs.f(2, this.CQz);
      }
      if (this.RGJ != null) {
        paramVarArgs.f(3, this.RGJ);
      }
      if (this.SZF != null) {
        paramVarArgs.f(4, this.SZF);
      }
      if (this.RGI != null) {
        paramVarArgs.f(5, this.RGI);
      }
      if (this.RGH != null) {
        paramVarArgs.f(6, this.RGH);
      }
      if (this.TYZ != null) {
        paramVarArgs.f(7, this.TYZ);
      }
      paramVarArgs.aY(8, this.TZa);
      paramVarArgs.e(9, 8, this.TZb);
      if (this.RGK != null) {
        paramVarArgs.f(10, this.RGK);
      }
      if (this.TZc != null) {
        paramVarArgs.f(11, this.TZc);
      }
      if (this.TZd != null) {
        paramVarArgs.f(12, this.TZd);
      }
      paramVarArgs.aY(13, this.TJI);
      if (this.RSZ != null) {
        paramVarArgs.f(14, this.RSZ);
      }
      if (this.CNU != null) {
        paramVarArgs.f(15, this.CNU);
      }
      if (this.RGL != null) {
        paramVarArgs.f(16, this.RGL);
      }
      if (this.TZe != null) {
        paramVarArgs.f(17, this.TZe);
      }
      if (this.TZf != null) {
        paramVarArgs.f(18, this.TZf);
      }
      if (this.RGM != null) {
        paramVarArgs.f(19, this.RGM);
      }
      if (this.TZg != null) {
        paramVarArgs.f(20, this.TZg);
      }
      if (this.TZh != null) {
        paramVarArgs.f(21, this.TZh);
      }
      if (this.RGN != null)
      {
        paramVarArgs.oE(22, this.RGN.computeSize());
        this.RGN.writeFields(paramVarArgs);
      }
      if (this.TZi != null) {
        paramVarArgs.f(23, this.TZi);
      }
      paramVarArgs.aY(24, this.TZj);
      paramVarArgs.aY(25, this.CMT);
      AppMethodBeat.o(152665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jUi == null) {
        break label1762;
      }
    }
    label1762:
    for (int i = g.a.a.b.b.a.g(1, this.jUi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CQz);
      }
      i = paramInt;
      if (this.RGJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RGJ);
      }
      paramInt = i;
      if (this.SZF != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SZF);
      }
      i = paramInt;
      if (this.RGI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RGI);
      }
      paramInt = i;
      if (this.RGH != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RGH);
      }
      i = paramInt;
      if (this.TYZ != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TYZ);
      }
      i = i + g.a.a.b.b.a.bM(8, this.TZa) + g.a.a.a.c(9, 8, this.TZb);
      paramInt = i;
      if (this.RGK != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RGK);
      }
      i = paramInt;
      if (this.TZc != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.TZc);
      }
      paramInt = i;
      if (this.TZd != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TZd);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.TJI);
      paramInt = i;
      if (this.RSZ != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.RSZ);
      }
      i = paramInt;
      if (this.CNU != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.CNU);
      }
      paramInt = i;
      if (this.RGL != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.RGL);
      }
      i = paramInt;
      if (this.TZe != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.TZe);
      }
      paramInt = i;
      if (this.TZf != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.TZf);
      }
      i = paramInt;
      if (this.RGM != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.RGM);
      }
      paramInt = i;
      if (this.TZg != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.TZg);
      }
      i = paramInt;
      if (this.TZh != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.TZh);
      }
      paramInt = i;
      if (this.RGN != null) {
        paramInt = i + g.a.a.a.oD(22, this.RGN.computeSize());
      }
      i = paramInt;
      if (this.TZi != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.TZi);
      }
      paramInt = g.a.a.b.b.a.bM(24, this.TZj);
      int j = g.a.a.b.b.a.bM(25, this.CMT);
      AppMethodBeat.o(152665);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TZb.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dst localdst = (dst)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152665);
          return -1;
        case 1: 
          localdst.jUi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 2: 
          localdst.CQz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 3: 
          localdst.RGJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 4: 
          localdst.SZF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 5: 
          localdst.RGI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 6: 
          localdst.RGH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 7: 
          localdst.TYZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 8: 
          localdst.TZa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152665);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localdst.TZb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 10: 
          localdst.RGK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 11: 
          localdst.TZc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 12: 
          localdst.TZd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 13: 
          localdst.TJI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152665);
          return 0;
        case 14: 
          localdst.RSZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 15: 
          localdst.CNU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 16: 
          localdst.RGL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 17: 
          localdst.TZe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 18: 
          localdst.TZf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 19: 
          localdst.RGM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 20: 
          localdst.TZg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 21: 
          localdst.TZh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqj)localObject2).parseFrom((byte[])localObject1);
            }
            localdst.RGN = ((fqj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 23: 
          localdst.TZi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 24: 
          localdst.TZj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152665);
          return 0;
        }
        localdst.CMT = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(152665);
        return 0;
      }
      AppMethodBeat.o(152665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dst
 * JD-Core Version:    0.7.0.1
 */