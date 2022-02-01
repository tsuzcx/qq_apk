package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.cd.a
{
  public long FlS;
  public int FlT;
  public long FlU;
  public String FlV;
  public String FlW;
  public int FlX;
  public int FlY;
  public int FlZ;
  public int Fma;
  public String Fmb;
  public String Fmc;
  public int Fmd;
  public b Fme;
  public LinkedList<a> Fmf;
  public long createtime;
  public String fileid;
  public String jEd;
  public int klF;
  public String md5;
  public String sWA;
  public int source;
  public String tVp;
  public String uuid;
  
  public d()
  {
    AppMethodBeat.i(187536);
    this.Fmf = new LinkedList();
    AppMethodBeat.o(187536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187539);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.FlS);
      paramVarArgs.aY(2, this.FlT);
      paramVarArgs.aY(3, this.source);
      paramVarArgs.bm(4, this.FlU);
      if (this.sWA != null) {
        paramVarArgs.f(5, this.sWA);
      }
      if (this.FlV != null) {
        paramVarArgs.f(6, this.FlV);
      }
      if (this.fileid != null) {
        paramVarArgs.f(7, this.fileid);
      }
      if (this.FlW != null) {
        paramVarArgs.f(8, this.FlW);
      }
      if (this.md5 != null) {
        paramVarArgs.f(9, this.md5);
      }
      paramVarArgs.bm(10, this.createtime);
      paramVarArgs.aY(11, this.FlX);
      paramVarArgs.aY(12, this.FlY);
      if (this.jEd != null) {
        paramVarArgs.f(13, this.jEd);
      }
      paramVarArgs.aY(14, this.FlZ);
      paramVarArgs.aY(15, this.klF);
      paramVarArgs.aY(16, this.Fma);
      if (this.Fmb != null) {
        paramVarArgs.f(17, this.Fmb);
      }
      if (this.Fmc != null) {
        paramVarArgs.f(18, this.Fmc);
      }
      if (this.tVp != null) {
        paramVarArgs.f(19, this.tVp);
      }
      paramVarArgs.aY(20, this.Fmd);
      if (this.uuid != null) {
        paramVarArgs.f(21, this.uuid);
      }
      if (this.Fme != null) {
        paramVarArgs.c(22, this.Fme);
      }
      paramVarArgs.e(23, 8, this.Fmf);
      AppMethodBeat.o(187539);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.FlS) + 0 + g.a.a.b.b.a.bM(2, this.FlT) + g.a.a.b.b.a.bM(3, this.source) + g.a.a.b.b.a.p(4, this.FlU);
      paramInt = i;
      if (this.sWA != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.sWA);
      }
      i = paramInt;
      if (this.FlV != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.FlV);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.fileid);
      }
      i = paramInt;
      if (this.FlW != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.FlW);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.md5);
      }
      i = paramInt + g.a.a.b.b.a.p(10, this.createtime) + g.a.a.b.b.a.bM(11, this.FlX) + g.a.a.b.b.a.bM(12, this.FlY);
      paramInt = i;
      if (this.jEd != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.jEd);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.FlZ) + g.a.a.b.b.a.bM(15, this.klF) + g.a.a.b.b.a.bM(16, this.Fma);
      paramInt = i;
      if (this.Fmb != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.Fmb);
      }
      i = paramInt;
      if (this.Fmc != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.Fmc);
      }
      paramInt = i;
      if (this.tVp != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.tVp);
      }
      i = paramInt + g.a.a.b.b.a.bM(20, this.Fmd);
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.uuid);
      }
      i = paramInt;
      if (this.Fme != null) {
        i = paramInt + g.a.a.b.b.a.b(22, this.Fme);
      }
      paramInt = g.a.a.a.c(23, 8, this.Fmf);
      AppMethodBeat.o(187539);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fmf.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(187539);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(187539);
        return -1;
      case 1: 
        locald.FlS = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(187539);
        return 0;
      case 2: 
        locald.FlT = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(187539);
        return 0;
      case 3: 
        locald.source = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(187539);
        return 0;
      case 4: 
        locald.FlU = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(187539);
        return 0;
      case 5: 
        locald.sWA = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 6: 
        locald.FlV = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 7: 
        locald.fileid = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 8: 
        locald.FlW = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 9: 
        locald.md5 = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 10: 
        locald.createtime = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(187539);
        return 0;
      case 11: 
        locald.FlX = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(187539);
        return 0;
      case 12: 
        locald.FlY = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(187539);
        return 0;
      case 13: 
        locald.jEd = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 14: 
        locald.FlZ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(187539);
        return 0;
      case 15: 
        locald.klF = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(187539);
        return 0;
      case 16: 
        locald.Fma = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(187539);
        return 0;
      case 17: 
        locald.Fmb = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 18: 
        locald.Fmc = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 19: 
        locald.tVp = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 20: 
        locald.Fmd = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(187539);
        return 0;
      case 21: 
        locald.uuid = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(187539);
        return 0;
      case 22: 
        locald.Fme = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(187539);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        a locala = new a();
        if ((localObject != null) && (localObject.length > 0)) {
          locala.parseFrom((byte[])localObject);
        }
        locald.Fmf.add(locala);
        paramInt += 1;
      }
      AppMethodBeat.o(187539);
      return 0;
    }
    AppMethodBeat.o(187539);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.d
 * JD-Core Version:    0.7.0.1
 */