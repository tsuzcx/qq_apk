package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class my
  extends com.tencent.mm.cd.a
{
  public int EFG;
  public String RTA;
  public int RTB;
  public String RTC;
  public int RTD;
  public int RTE;
  public b RTF;
  public int RTG;
  public dld RTH;
  public String RTI;
  public String RTJ;
  public String RTi;
  public int RTj;
  public String RTk;
  public String RTl;
  public String RTm;
  public String RTn;
  public String RTo;
  public String RTp;
  public int RTq;
  public int RTr;
  public int RTs;
  public int RTt;
  public String RTu;
  public String RTv;
  public int RTw;
  public int RTx;
  public int RTy;
  public String RTz;
  public String fwr;
  public int lpq;
  public int lpx;
  public String lpy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124399);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.RTi != null) {
        paramVarArgs.f(2, this.RTi);
      }
      if (this.lpy != null) {
        paramVarArgs.f(3, this.lpy);
      }
      paramVarArgs.aY(4, this.RTj);
      if (this.RTk != null) {
        paramVarArgs.f(5, this.RTk);
      }
      if (this.RTl != null) {
        paramVarArgs.f(6, this.RTl);
      }
      if (this.RTm != null) {
        paramVarArgs.f(7, this.RTm);
      }
      if (this.RTn != null) {
        paramVarArgs.f(8, this.RTn);
      }
      if (this.RTo != null) {
        paramVarArgs.f(9, this.RTo);
      }
      paramVarArgs.aY(10, this.lpx);
      if (this.RTp != null) {
        paramVarArgs.f(11, this.RTp);
      }
      paramVarArgs.aY(12, this.RTq);
      paramVarArgs.aY(13, this.RTr);
      paramVarArgs.aY(14, this.RTs);
      paramVarArgs.aY(15, this.RTt);
      if (this.RTu != null) {
        paramVarArgs.f(16, this.RTu);
      }
      if (this.RTv != null) {
        paramVarArgs.f(17, this.RTv);
      }
      paramVarArgs.aY(18, this.RTw);
      paramVarArgs.aY(19, this.RTx);
      paramVarArgs.aY(20, this.RTy);
      if (this.RTz != null) {
        paramVarArgs.f(21, this.RTz);
      }
      if (this.RTA != null) {
        paramVarArgs.f(22, this.RTA);
      }
      paramVarArgs.aY(23, this.RTB);
      if (this.RTC != null) {
        paramVarArgs.f(24, this.RTC);
      }
      paramVarArgs.aY(25, this.RTD);
      paramVarArgs.aY(26, this.RTE);
      if (this.RTF != null) {
        paramVarArgs.c(27, this.RTF);
      }
      paramVarArgs.aY(28, this.EFG);
      paramVarArgs.aY(29, this.RTG);
      paramVarArgs.aY(30, this.lpq);
      if (this.RTH != null)
      {
        paramVarArgs.oE(31, this.RTH.computeSize());
        this.RTH.writeFields(paramVarArgs);
      }
      if (this.RTI != null) {
        paramVarArgs.f(32, this.RTI);
      }
      if (this.RTJ != null) {
        paramVarArgs.f(33, this.RTJ);
      }
      AppMethodBeat.o(124399);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label2008;
      }
    }
    label2008:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RTi != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RTi);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lpy);
      }
      i += g.a.a.b.b.a.bM(4, this.RTj);
      paramInt = i;
      if (this.RTk != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RTk);
      }
      i = paramInt;
      if (this.RTl != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RTl);
      }
      paramInt = i;
      if (this.RTm != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RTm);
      }
      i = paramInt;
      if (this.RTn != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RTn);
      }
      paramInt = i;
      if (this.RTo != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RTo);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.lpx);
      paramInt = i;
      if (this.RTp != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RTp);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.RTq) + g.a.a.b.b.a.bM(13, this.RTr) + g.a.a.b.b.a.bM(14, this.RTs) + g.a.a.b.b.a.bM(15, this.RTt);
      paramInt = i;
      if (this.RTu != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.RTu);
      }
      i = paramInt;
      if (this.RTv != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.RTv);
      }
      i = i + g.a.a.b.b.a.bM(18, this.RTw) + g.a.a.b.b.a.bM(19, this.RTx) + g.a.a.b.b.a.bM(20, this.RTy);
      paramInt = i;
      if (this.RTz != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.RTz);
      }
      i = paramInt;
      if (this.RTA != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.RTA);
      }
      i += g.a.a.b.b.a.bM(23, this.RTB);
      paramInt = i;
      if (this.RTC != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.RTC);
      }
      i = paramInt + g.a.a.b.b.a.bM(25, this.RTD) + g.a.a.b.b.a.bM(26, this.RTE);
      paramInt = i;
      if (this.RTF != null) {
        paramInt = i + g.a.a.b.b.a.b(27, this.RTF);
      }
      i = paramInt + g.a.a.b.b.a.bM(28, this.EFG) + g.a.a.b.b.a.bM(29, this.RTG) + g.a.a.b.b.a.bM(30, this.lpq);
      paramInt = i;
      if (this.RTH != null) {
        paramInt = i + g.a.a.a.oD(31, this.RTH.computeSize());
      }
      i = paramInt;
      if (this.RTI != null) {
        i = paramInt + g.a.a.b.b.a.g(32, this.RTI);
      }
      paramInt = i;
      if (this.RTJ != null) {
        paramInt = i + g.a.a.b.b.a.g(33, this.RTJ);
      }
      AppMethodBeat.o(124399);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124399);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        my localmy = (my)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124399);
          return -1;
        case 1: 
          localmy.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 2: 
          localmy.RTi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 3: 
          localmy.lpy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 4: 
          localmy.RTj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 5: 
          localmy.RTk = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 6: 
          localmy.RTl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 7: 
          localmy.RTm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 8: 
          localmy.RTn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 9: 
          localmy.RTo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 10: 
          localmy.lpx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 11: 
          localmy.RTp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 12: 
          localmy.RTq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 13: 
          localmy.RTr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 14: 
          localmy.RTs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 15: 
          localmy.RTt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 16: 
          localmy.RTu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 17: 
          localmy.RTv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 18: 
          localmy.RTw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 19: 
          localmy.RTx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 20: 
          localmy.RTy = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 21: 
          localmy.RTz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 22: 
          localmy.RTA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 23: 
          localmy.RTB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 24: 
          localmy.RTC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        case 25: 
          localmy.RTD = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 26: 
          localmy.RTE = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 27: 
          localmy.RTF = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(124399);
          return 0;
        case 28: 
          localmy.EFG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 29: 
          localmy.RTG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 30: 
          localmy.lpq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124399);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dld localdld = new dld();
            if ((localObject != null) && (localObject.length > 0)) {
              localdld.parseFrom((byte[])localObject);
            }
            localmy.RTH = localdld;
            paramInt += 1;
          }
          AppMethodBeat.o(124399);
          return 0;
        case 32: 
          localmy.RTI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124399);
          return 0;
        }
        localmy.RTJ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124399);
        return 0;
      }
      AppMethodBeat.o(124399);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.my
 * JD-Core Version:    0.7.0.1
 */