package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cym
  extends com.tencent.mm.bw.a
{
  public LinkedList<Long> MDv;
  public int aHK;
  public String dMl;
  public int dYn;
  public String extraInfo;
  public long sGB;
  public long sGC;
  public long sGD;
  public String sGE;
  public String sGF;
  public String sGH;
  public String sessionId;
  
  public cym()
  {
    AppMethodBeat.i(220715);
    this.aHK = 0;
    this.sGB = 0L;
    this.sGC = 0L;
    this.sGD = 0L;
    this.dYn = 0;
    this.MDv = new LinkedList();
    AppMethodBeat.o(220715);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.e(1, this.sessionId);
      }
      if (this.dMl != null) {
        paramVarArgs.e(2, this.dMl);
      }
      paramVarArgs.aM(3, this.aHK);
      paramVarArgs.bb(4, this.sGB);
      paramVarArgs.bb(5, this.sGC);
      paramVarArgs.bb(6, this.sGD);
      if (this.sGE != null) {
        paramVarArgs.e(7, this.sGE);
      }
      if (this.sGF != null) {
        paramVarArgs.e(8, this.sGF);
      }
      paramVarArgs.aM(9, this.dYn);
      paramVarArgs.e(10, 3, this.MDv);
      if (this.extraInfo != null) {
        paramVarArgs.e(11, this.extraInfo);
      }
      if (this.sGH != null) {
        paramVarArgs.e(12, this.sGH);
      }
      AppMethodBeat.o(220716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label801;
      }
    }
    label801:
    for (paramInt = g.a.a.b.b.a.f(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dMl != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dMl);
      }
      i = i + g.a.a.b.b.a.bu(3, this.aHK) + g.a.a.b.b.a.r(4, this.sGB) + g.a.a.b.b.a.r(5, this.sGC) + g.a.a.b.b.a.r(6, this.sGD);
      paramInt = i;
      if (this.sGE != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.sGE);
      }
      i = paramInt;
      if (this.sGF != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.sGF);
      }
      i = i + g.a.a.b.b.a.bu(9, this.dYn) + g.a.a.a.c(10, 3, this.MDv);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.extraInfo);
      }
      i = paramInt;
      if (this.sGH != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.sGH);
      }
      AppMethodBeat.o(220716);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MDv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(220716);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cym localcym = (cym)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(220716);
          return -1;
        case 1: 
          localcym.sessionId = locala.UbS.readString();
          AppMethodBeat.o(220716);
          return 0;
        case 2: 
          localcym.dMl = locala.UbS.readString();
          AppMethodBeat.o(220716);
          return 0;
        case 3: 
          localcym.aHK = locala.UbS.zi();
          AppMethodBeat.o(220716);
          return 0;
        case 4: 
          localcym.sGB = locala.UbS.zl();
          AppMethodBeat.o(220716);
          return 0;
        case 5: 
          localcym.sGC = locala.UbS.zl();
          AppMethodBeat.o(220716);
          return 0;
        case 6: 
          localcym.sGD = locala.UbS.zl();
          AppMethodBeat.o(220716);
          return 0;
        case 7: 
          localcym.sGE = locala.UbS.readString();
          AppMethodBeat.o(220716);
          return 0;
        case 8: 
          localcym.sGF = locala.UbS.readString();
          AppMethodBeat.o(220716);
          return 0;
        case 9: 
          localcym.dYn = locala.UbS.zi();
          AppMethodBeat.o(220716);
          return 0;
        case 10: 
          localcym.MDv.add(Long.valueOf(locala.UbS.zl()));
          AppMethodBeat.o(220716);
          return 0;
        case 11: 
          localcym.extraInfo = locala.UbS.readString();
          AppMethodBeat.o(220716);
          return 0;
        }
        localcym.sGH = locala.UbS.readString();
        AppMethodBeat.o(220716);
        return 0;
      }
      AppMethodBeat.o(220716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cym
 * JD-Core Version:    0.7.0.1
 */