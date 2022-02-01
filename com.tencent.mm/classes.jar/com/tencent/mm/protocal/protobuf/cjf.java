package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjf
  extends com.tencent.mm.cd.a
{
  public int RUO;
  public String SpP;
  public long TkV;
  public String TqA;
  public int TqB;
  public int TqC;
  public String TqD;
  public String TqE;
  public String TqF;
  public String Tqn;
  public cjg Tqo;
  public String Tqp;
  public int Tqq;
  public int Tqr;
  public long Tqs;
  public String Tqt;
  public String Tqu;
  public int Tqv;
  public String Tqw;
  public String Tqx;
  public String Tqy;
  public String Tqz;
  public int llL;
  public int subType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91520);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tqn != null) {
        paramVarArgs.f(1, this.Tqn);
      }
      paramVarArgs.aY(2, this.subType);
      if (this.SpP != null) {
        paramVarArgs.f(3, this.SpP);
      }
      if (this.Tqo != null)
      {
        paramVarArgs.oE(4, this.Tqo.computeSize());
        this.Tqo.writeFields(paramVarArgs);
      }
      if (this.Tqp != null) {
        paramVarArgs.f(5, this.Tqp);
      }
      paramVarArgs.aY(6, this.Tqq);
      paramVarArgs.aY(7, this.Tqr);
      paramVarArgs.bm(8, this.Tqs);
      paramVarArgs.aY(9, this.llL);
      paramVarArgs.aY(10, this.RUO);
      if (this.Tqt != null) {
        paramVarArgs.f(11, this.Tqt);
      }
      if (this.Tqu != null) {
        paramVarArgs.f(12, this.Tqu);
      }
      paramVarArgs.aY(13, this.Tqv);
      if (this.Tqw != null) {
        paramVarArgs.f(14, this.Tqw);
      }
      if (this.Tqx != null) {
        paramVarArgs.f(15, this.Tqx);
      }
      if (this.Tqy != null) {
        paramVarArgs.f(16, this.Tqy);
      }
      if (this.Tqz != null) {
        paramVarArgs.f(17, this.Tqz);
      }
      if (this.TqA != null) {
        paramVarArgs.f(18, this.TqA);
      }
      paramVarArgs.aY(19, this.TqB);
      paramVarArgs.bm(20, this.TkV);
      paramVarArgs.aY(21, this.TqC);
      if (this.TqD != null) {
        paramVarArgs.f(22, this.TqD);
      }
      if (this.TqE != null) {
        paramVarArgs.f(23, this.TqE);
      }
      if (this.TqF != null) {
        paramVarArgs.f(24, this.TqF);
      }
      AppMethodBeat.o(91520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tqn == null) {
        break label1536;
      }
    }
    label1536:
    for (paramInt = g.a.a.b.b.a.g(1, this.Tqn) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.subType);
      paramInt = i;
      if (this.SpP != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SpP);
      }
      i = paramInt;
      if (this.Tqo != null) {
        i = paramInt + g.a.a.a.oD(4, this.Tqo.computeSize());
      }
      paramInt = i;
      if (this.Tqp != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tqp);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Tqq) + g.a.a.b.b.a.bM(7, this.Tqr) + g.a.a.b.b.a.p(8, this.Tqs) + g.a.a.b.b.a.bM(9, this.llL) + g.a.a.b.b.a.bM(10, this.RUO);
      paramInt = i;
      if (this.Tqt != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Tqt);
      }
      i = paramInt;
      if (this.Tqu != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.Tqu);
      }
      i += g.a.a.b.b.a.bM(13, this.Tqv);
      paramInt = i;
      if (this.Tqw != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Tqw);
      }
      i = paramInt;
      if (this.Tqx != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.Tqx);
      }
      paramInt = i;
      if (this.Tqy != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Tqy);
      }
      i = paramInt;
      if (this.Tqz != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.Tqz);
      }
      paramInt = i;
      if (this.TqA != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.TqA);
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.TqB) + g.a.a.b.b.a.p(20, this.TkV) + g.a.a.b.b.a.bM(21, this.TqC);
      paramInt = i;
      if (this.TqD != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.TqD);
      }
      i = paramInt;
      if (this.TqE != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.TqE);
      }
      paramInt = i;
      if (this.TqF != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.TqF);
      }
      AppMethodBeat.o(91520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cjf localcjf = (cjf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91520);
          return -1;
        case 1: 
          localcjf.Tqn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 2: 
          localcjf.subType = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91520);
          return 0;
        case 3: 
          localcjf.SpP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cjg localcjg = new cjg();
            if ((localObject != null) && (localObject.length > 0)) {
              localcjg.parseFrom((byte[])localObject);
            }
            localcjf.Tqo = localcjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91520);
          return 0;
        case 5: 
          localcjf.Tqp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 6: 
          localcjf.Tqq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91520);
          return 0;
        case 7: 
          localcjf.Tqr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91520);
          return 0;
        case 8: 
          localcjf.Tqs = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91520);
          return 0;
        case 9: 
          localcjf.llL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91520);
          return 0;
        case 10: 
          localcjf.RUO = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91520);
          return 0;
        case 11: 
          localcjf.Tqt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 12: 
          localcjf.Tqu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 13: 
          localcjf.Tqv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91520);
          return 0;
        case 14: 
          localcjf.Tqw = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 15: 
          localcjf.Tqx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 16: 
          localcjf.Tqy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 17: 
          localcjf.Tqz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 18: 
          localcjf.TqA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 19: 
          localcjf.TqB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91520);
          return 0;
        case 20: 
          localcjf.TkV = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91520);
          return 0;
        case 21: 
          localcjf.TqC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91520);
          return 0;
        case 22: 
          localcjf.TqD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 23: 
          localcjf.TqE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91520);
          return 0;
        }
        localcjf.TqF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91520);
        return 0;
      }
      AppMethodBeat.o(91520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjf
 * JD-Core Version:    0.7.0.1
 */