package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fa
  extends com.tencent.mm.cd.a
{
  public String CRQ;
  public String CRR;
  public String CqB;
  public int Cqs;
  public int CreateTime;
  public String RII;
  public int RJP;
  public String RJQ;
  public eae RJR;
  public int RJS;
  public String RJT;
  public String RJU;
  public String RJV;
  public int RJW;
  public String lVG;
  public String lpy;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32116);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRR != null) {
        paramVarArgs.f(1, this.CRR);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      paramVarArgs.aY(3, this.RJP);
      if (this.CRQ != null) {
        paramVarArgs.f(4, this.CRQ);
      }
      paramVarArgs.aY(5, this.rWu);
      if (this.lpy != null) {
        paramVarArgs.f(6, this.lpy);
      }
      paramVarArgs.aY(7, this.CreateTime);
      if (this.RJQ != null) {
        paramVarArgs.f(8, this.RJQ);
      }
      if (this.RJR != null)
      {
        paramVarArgs.oE(9, this.RJR.computeSize());
        this.RJR.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.Cqs);
      paramVarArgs.aY(11, this.RJS);
      if (this.RII != null) {
        paramVarArgs.f(12, this.RII);
      }
      if (this.RJT != null) {
        paramVarArgs.f(13, this.RJT);
      }
      if (this.RJU != null) {
        paramVarArgs.f(14, this.RJU);
      }
      if (this.RJV != null) {
        paramVarArgs.f(15, this.RJV);
      }
      paramVarArgs.aY(16, this.RJW);
      if (this.CqB != null) {
        paramVarArgs.f(17, this.CqB);
      }
      AppMethodBeat.o(32116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRR == null) {
        break label1199;
      }
    }
    label1199:
    for (paramInt = g.a.a.b.b.a.g(1, this.CRR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lVG);
      }
      i += g.a.a.b.b.a.bM(3, this.RJP);
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.rWu);
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.lpy);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.CreateTime);
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RJQ);
      }
      i = paramInt;
      if (this.RJR != null) {
        i = paramInt + g.a.a.a.oD(9, this.RJR.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(10, this.Cqs) + g.a.a.b.b.a.bM(11, this.RJS);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.RII);
      }
      i = paramInt;
      if (this.RJT != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.RJT);
      }
      paramInt = i;
      if (this.RJU != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.RJU);
      }
      i = paramInt;
      if (this.RJV != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.RJV);
      }
      i += g.a.a.b.b.a.bM(16, this.RJW);
      paramInt = i;
      if (this.CqB != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.CqB);
      }
      AppMethodBeat.o(32116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fa localfa = (fa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32116);
          return -1;
        case 1: 
          localfa.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 2: 
          localfa.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 3: 
          localfa.RJP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32116);
          return 0;
        case 4: 
          localfa.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 5: 
          localfa.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32116);
          return 0;
        case 6: 
          localfa.lpy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 7: 
          localfa.CreateTime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32116);
          return 0;
        case 8: 
          localfa.RJQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eae localeae = new eae();
            if ((localObject != null) && (localObject.length > 0)) {
              localeae.dd((byte[])localObject);
            }
            localfa.RJR = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(32116);
          return 0;
        case 10: 
          localfa.Cqs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32116);
          return 0;
        case 11: 
          localfa.RJS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32116);
          return 0;
        case 12: 
          localfa.RII = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 13: 
          localfa.RJT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 14: 
          localfa.RJU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 15: 
          localfa.RJV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 16: 
          localfa.RJW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32116);
          return 0;
        }
        localfa.CqB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32116);
        return 0;
      }
      AppMethodBeat.o(32116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fa
 * JD-Core Version:    0.7.0.1
 */