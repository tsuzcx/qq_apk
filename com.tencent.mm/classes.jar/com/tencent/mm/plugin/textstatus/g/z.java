package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class z
  extends com.tencent.mm.bw.a
{
  public long UrT;
  public long UsA;
  public long UsB;
  public long UsC;
  public String Usb;
  public long Usc;
  public LinkedList<String> Usd;
  public String Use;
  public String Usf;
  public long Usg;
  public long Ush;
  public long Usi;
  public long Usj;
  public long Usk;
  public String Usl;
  public String Usm;
  public long Usn;
  public long Uso;
  public long Usp;
  public long Usq;
  public long Usr;
  public long Uss;
  public long Ust;
  public long Usu;
  public long Usv;
  public long Usw;
  public long Usx;
  public long Usy;
  public int Usz;
  public int dRk;
  public int enterScene;
  public long enterTime;
  public String iFo;
  public String iFp;
  public String sessionId;
  
  public z()
  {
    AppMethodBeat.i(258635);
    this.Usd = new LinkedList();
    AppMethodBeat.o(258635);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Usb != null) {
        paramVarArgs.e(1, this.Usb);
      }
      paramVarArgs.aM(2, this.enterScene);
      paramVarArgs.aM(3, this.dRk);
      paramVarArgs.bb(4, this.enterTime);
      paramVarArgs.bb(5, this.Usc);
      paramVarArgs.e(6, 1, this.Usd);
      if (this.Use != null) {
        paramVarArgs.e(7, this.Use);
      }
      if (this.Usf != null) {
        paramVarArgs.e(8, this.Usf);
      }
      paramVarArgs.bb(9, this.Usg);
      paramVarArgs.bb(10, this.Ush);
      paramVarArgs.bb(11, this.Usi);
      paramVarArgs.bb(12, this.Usj);
      paramVarArgs.bb(13, this.Usk);
      if (this.Usl != null) {
        paramVarArgs.e(14, this.Usl);
      }
      if (this.Usm != null) {
        paramVarArgs.e(15, this.Usm);
      }
      if (this.iFo != null) {
        paramVarArgs.e(16, this.iFo);
      }
      if (this.iFp != null) {
        paramVarArgs.e(17, this.iFp);
      }
      paramVarArgs.bb(18, this.Usn);
      paramVarArgs.bb(19, this.Uso);
      paramVarArgs.bb(20, this.Usp);
      paramVarArgs.bb(21, this.Usq);
      paramVarArgs.bb(22, this.Usr);
      paramVarArgs.bb(23, this.Uss);
      paramVarArgs.bb(24, this.Ust);
      paramVarArgs.bb(25, this.Usu);
      paramVarArgs.bb(26, this.Usv);
      paramVarArgs.bb(27, this.Usw);
      paramVarArgs.bb(28, this.Usx);
      paramVarArgs.bb(29, this.Usy);
      paramVarArgs.aM(30, this.Usz);
      paramVarArgs.bb(31, this.UsA);
      paramVarArgs.bb(32, this.UsB);
      paramVarArgs.bb(33, this.UsC);
      if (this.sessionId != null) {
        paramVarArgs.e(34, this.sessionId);
      }
      paramVarArgs.bb(35, this.UrT);
      AppMethodBeat.o(258636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Usb == null) {
        break label1850;
      }
    }
    label1850:
    for (paramInt = g.a.a.b.b.a.f(1, this.Usb) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.enterScene) + g.a.a.b.b.a.bu(3, this.dRk) + g.a.a.b.b.a.r(4, this.enterTime) + g.a.a.b.b.a.r(5, this.Usc) + g.a.a.a.c(6, 1, this.Usd);
      paramInt = i;
      if (this.Use != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Use);
      }
      i = paramInt;
      if (this.Usf != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Usf);
      }
      i = i + g.a.a.b.b.a.r(9, this.Usg) + g.a.a.b.b.a.r(10, this.Ush) + g.a.a.b.b.a.r(11, this.Usi) + g.a.a.b.b.a.r(12, this.Usj) + g.a.a.b.b.a.r(13, this.Usk);
      paramInt = i;
      if (this.Usl != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.Usl);
      }
      i = paramInt;
      if (this.Usm != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.Usm);
      }
      paramInt = i;
      if (this.iFo != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.iFo);
      }
      i = paramInt;
      if (this.iFp != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.iFp);
      }
      i = i + g.a.a.b.b.a.r(18, this.Usn) + g.a.a.b.b.a.r(19, this.Uso) + g.a.a.b.b.a.r(20, this.Usp) + g.a.a.b.b.a.r(21, this.Usq) + g.a.a.b.b.a.r(22, this.Usr) + g.a.a.b.b.a.r(23, this.Uss) + g.a.a.b.b.a.r(24, this.Ust) + g.a.a.b.b.a.r(25, this.Usu) + g.a.a.b.b.a.r(26, this.Usv) + g.a.a.b.b.a.r(27, this.Usw) + g.a.a.b.b.a.r(28, this.Usx) + g.a.a.b.b.a.r(29, this.Usy) + g.a.a.b.b.a.bu(30, this.Usz) + g.a.a.b.b.a.r(31, this.UsA) + g.a.a.b.b.a.r(32, this.UsB) + g.a.a.b.b.a.r(33, this.UsC);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(34, this.sessionId);
      }
      i = g.a.a.b.b.a.r(35, this.UrT);
      AppMethodBeat.o(258636);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Usd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(258636);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258636);
          return -1;
        case 1: 
          localz.Usb = locala.UbS.readString();
          AppMethodBeat.o(258636);
          return 0;
        case 2: 
          localz.enterScene = locala.UbS.zi();
          AppMethodBeat.o(258636);
          return 0;
        case 3: 
          localz.dRk = locala.UbS.zi();
          AppMethodBeat.o(258636);
          return 0;
        case 4: 
          localz.enterTime = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 5: 
          localz.Usc = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 6: 
          localz.Usd.add(locala.UbS.readString());
          AppMethodBeat.o(258636);
          return 0;
        case 7: 
          localz.Use = locala.UbS.readString();
          AppMethodBeat.o(258636);
          return 0;
        case 8: 
          localz.Usf = locala.UbS.readString();
          AppMethodBeat.o(258636);
          return 0;
        case 9: 
          localz.Usg = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 10: 
          localz.Ush = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 11: 
          localz.Usi = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 12: 
          localz.Usj = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 13: 
          localz.Usk = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 14: 
          localz.Usl = locala.UbS.readString();
          AppMethodBeat.o(258636);
          return 0;
        case 15: 
          localz.Usm = locala.UbS.readString();
          AppMethodBeat.o(258636);
          return 0;
        case 16: 
          localz.iFo = locala.UbS.readString();
          AppMethodBeat.o(258636);
          return 0;
        case 17: 
          localz.iFp = locala.UbS.readString();
          AppMethodBeat.o(258636);
          return 0;
        case 18: 
          localz.Usn = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 19: 
          localz.Uso = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 20: 
          localz.Usp = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 21: 
          localz.Usq = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 22: 
          localz.Usr = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 23: 
          localz.Uss = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 24: 
          localz.Ust = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 25: 
          localz.Usu = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 26: 
          localz.Usv = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 27: 
          localz.Usw = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 28: 
          localz.Usx = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 29: 
          localz.Usy = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 30: 
          localz.Usz = locala.UbS.zi();
          AppMethodBeat.o(258636);
          return 0;
        case 31: 
          localz.UsA = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 32: 
          localz.UsB = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 33: 
          localz.UsC = locala.UbS.zl();
          AppMethodBeat.o(258636);
          return 0;
        case 34: 
          localz.sessionId = locala.UbS.readString();
          AppMethodBeat.o(258636);
          return 0;
        }
        localz.UrT = locala.UbS.zl();
        AppMethodBeat.o(258636);
        return 0;
      }
      AppMethodBeat.o(258636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.z
 * JD-Core Version:    0.7.0.1
 */