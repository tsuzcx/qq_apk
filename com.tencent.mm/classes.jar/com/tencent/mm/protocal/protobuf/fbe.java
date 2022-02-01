package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fbe
  extends com.tencent.mm.cd.a
{
  public int UAX;
  public String UAY;
  public String UAZ;
  public int UBa;
  public String UBb;
  public int UBc;
  public int UBd;
  public String UBe;
  public int UBf;
  public String UBg;
  public int UBh;
  public String UBi;
  public int UBj;
  public String UBk;
  public String Uin;
  public String appid;
  public String extInfo;
  public int interval;
  public String llI;
  public String title;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176157);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      paramVarArgs.aY(3, this.version);
      if (this.llI != null) {
        paramVarArgs.f(4, this.llI);
      }
      paramVarArgs.aY(5, this.UAX);
      if (this.UAY != null) {
        paramVarArgs.f(6, this.UAY);
      }
      if (this.UAZ != null) {
        paramVarArgs.f(7, this.UAZ);
      }
      paramVarArgs.aY(8, this.UBa);
      if (this.UBb != null) {
        paramVarArgs.f(9, this.UBb);
      }
      paramVarArgs.aY(10, this.interval);
      paramVarArgs.aY(11, this.UBc);
      paramVarArgs.aY(12, this.UBd);
      if (this.UBe != null) {
        paramVarArgs.f(13, this.UBe);
      }
      if (this.Uin != null) {
        paramVarArgs.f(14, this.Uin);
      }
      paramVarArgs.aY(15, this.UBf);
      if (this.UBg != null) {
        paramVarArgs.f(16, this.UBg);
      }
      paramVarArgs.aY(17, this.UBh);
      if (this.UBi != null) {
        paramVarArgs.f(18, this.UBi);
      }
      paramVarArgs.aY(19, this.UBj);
      if (this.extInfo != null) {
        paramVarArgs.f(20, this.extInfo);
      }
      if (this.UBk != null) {
        paramVarArgs.f(21, this.UBk);
      }
      AppMethodBeat.o(176157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1298;
      }
    }
    label1298:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appid);
      }
      i += g.a.a.b.b.a.bM(3, this.version);
      paramInt = i;
      if (this.llI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.llI);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UAX);
      paramInt = i;
      if (this.UAY != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UAY);
      }
      i = paramInt;
      if (this.UAZ != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UAZ);
      }
      i += g.a.a.b.b.a.bM(8, this.UBa);
      paramInt = i;
      if (this.UBb != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UBb);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.interval) + g.a.a.b.b.a.bM(11, this.UBc) + g.a.a.b.b.a.bM(12, this.UBd);
      paramInt = i;
      if (this.UBe != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.UBe);
      }
      i = paramInt;
      if (this.Uin != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.Uin);
      }
      i += g.a.a.b.b.a.bM(15, this.UBf);
      paramInt = i;
      if (this.UBg != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.UBg);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.UBh);
      paramInt = i;
      if (this.UBi != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.UBi);
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.UBj);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.extInfo);
      }
      i = paramInt;
      if (this.UBk != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.UBk);
      }
      AppMethodBeat.o(176157);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(176157);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fbe localfbe = (fbe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176157);
          return -1;
        case 1: 
          localfbe.title = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 2: 
          localfbe.appid = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 3: 
          localfbe.version = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 4: 
          localfbe.llI = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 5: 
          localfbe.UAX = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 6: 
          localfbe.UAY = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 7: 
          localfbe.UAZ = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 8: 
          localfbe.UBa = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 9: 
          localfbe.UBb = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 10: 
          localfbe.interval = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 11: 
          localfbe.UBc = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 12: 
          localfbe.UBd = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 13: 
          localfbe.UBe = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 14: 
          localfbe.Uin = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 15: 
          localfbe.UBf = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 16: 
          localfbe.UBg = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 17: 
          localfbe.UBh = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 18: 
          localfbe.UBi = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 19: 
          localfbe.UBj = locala.abFh.AK();
          AppMethodBeat.o(176157);
          return 0;
        case 20: 
          localfbe.extInfo = locala.abFh.readString();
          AppMethodBeat.o(176157);
          return 0;
        }
        localfbe.UBk = locala.abFh.readString();
        AppMethodBeat.o(176157);
        return 0;
      }
      AppMethodBeat.o(176157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbe
 * JD-Core Version:    0.7.0.1
 */