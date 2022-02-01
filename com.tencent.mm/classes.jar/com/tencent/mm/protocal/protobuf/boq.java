package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class boq
  extends com.tencent.mm.cd.a
{
  public String CNP;
  public String SZL;
  public String SZM;
  public int SZN;
  public String SZO;
  public String SZP;
  public String SZQ;
  public int SZR;
  public int SZS;
  public int SZT;
  public b SZU;
  public LinkedList<ckf> SZV;
  public int Slv;
  public String UserName;
  public String fwr;
  public String lpy;
  
  public boq()
  {
    AppMethodBeat.i(230554);
    this.SZV = new LinkedList();
    AppMethodBeat.o(230554);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Slv);
      if (this.SZL != null) {
        paramVarArgs.f(2, this.SZL);
      }
      if (this.SZM != null) {
        paramVarArgs.f(3, this.SZM);
      }
      paramVarArgs.aY(4, this.SZN);
      if (this.fwr != null) {
        paramVarArgs.f(5, this.fwr);
      }
      if (this.lpy != null) {
        paramVarArgs.f(6, this.lpy);
      }
      if (this.UserName != null) {
        paramVarArgs.f(7, this.UserName);
      }
      if (this.SZO != null) {
        paramVarArgs.f(8, this.SZO);
      }
      if (this.CNP != null) {
        paramVarArgs.f(10, this.CNP);
      }
      if (this.SZP != null) {
        paramVarArgs.f(11, this.SZP);
      }
      if (this.SZQ != null) {
        paramVarArgs.f(12, this.SZQ);
      }
      paramVarArgs.aY(13, this.SZR);
      paramVarArgs.aY(14, this.SZS);
      paramVarArgs.aY(15, this.SZT);
      if (this.SZU != null) {
        paramVarArgs.c(16, this.SZU);
      }
      paramVarArgs.e(17, 8, this.SZV);
      AppMethodBeat.o(152549);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Slv) + 0;
      paramInt = i;
      if (this.SZL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SZL);
      }
      i = paramInt;
      if (this.SZM != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SZM);
      }
      i += g.a.a.b.b.a.bM(4, this.SZN);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fwr);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.lpy);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UserName);
      }
      i = paramInt;
      if (this.SZO != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.SZO);
      }
      paramInt = i;
      if (this.CNP != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.CNP);
      }
      i = paramInt;
      if (this.SZP != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SZP);
      }
      paramInt = i;
      if (this.SZQ != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SZQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.SZR) + g.a.a.b.b.a.bM(14, this.SZS) + g.a.a.b.b.a.bM(15, this.SZT);
      paramInt = i;
      if (this.SZU != null) {
        paramInt = i + g.a.a.b.b.a.b(16, this.SZU);
      }
      i = g.a.a.a.c(17, 8, this.SZV);
      AppMethodBeat.o(152549);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SZV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      boq localboq = (boq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 9: 
      default: 
        AppMethodBeat.o(152549);
        return -1;
      case 1: 
        localboq.Slv = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152549);
        return 0;
      case 2: 
        localboq.SZL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 3: 
        localboq.SZM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 4: 
        localboq.SZN = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152549);
        return 0;
      case 5: 
        localboq.fwr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 6: 
        localboq.lpy = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 7: 
        localboq.UserName = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 8: 
        localboq.SZO = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 10: 
        localboq.CNP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 11: 
        localboq.SZP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 12: 
        localboq.SZQ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152549);
        return 0;
      case 13: 
        localboq.SZR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152549);
        return 0;
      case 14: 
        localboq.SZS = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152549);
        return 0;
      case 15: 
        localboq.SZT = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152549);
        return 0;
      case 16: 
        localboq.SZU = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(152549);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ckf localckf = new ckf();
        if ((localObject != null) && (localObject.length > 0)) {
          localckf.parseFrom((byte[])localObject);
        }
        localboq.SZV.add(localckf);
        paramInt += 1;
      }
      AppMethodBeat.o(152549);
      return 0;
    }
    AppMethodBeat.o(152549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boq
 * JD-Core Version:    0.7.0.1
 */