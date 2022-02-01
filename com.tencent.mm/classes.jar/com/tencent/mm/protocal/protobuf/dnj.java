package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dnj
  extends dyy
{
  public String OkW;
  public int Olc;
  public String TAJ;
  public boolean TAK;
  public int TUA;
  public long TUB;
  public String TUC;
  public String TUD;
  public String TUE;
  public String TUF;
  public LinkedList<dux> TUG;
  public clu TUx;
  public dox TUy;
  public String TUz;
  public LinkedList<vm> Tbw;
  public int tqa;
  public String tqb;
  
  public dnj()
  {
    AppMethodBeat.i(91622);
    this.Tbw = new LinkedList();
    this.TAK = true;
    this.TUG = new LinkedList();
    AppMethodBeat.o(91622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91623);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91623);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.TUx != null)
      {
        paramVarArgs.oE(4, this.TUx.computeSize());
        this.TUx.writeFields(paramVarArgs);
      }
      if (this.TUy != null)
      {
        paramVarArgs.oE(5, this.TUy.computeSize());
        this.TUy.writeFields(paramVarArgs);
      }
      if (this.TAJ != null) {
        paramVarArgs.f(6, this.TAJ);
      }
      paramVarArgs.e(7, 8, this.Tbw);
      paramVarArgs.co(8, this.TAK);
      paramVarArgs.aY(9, this.Olc);
      if (this.TUz != null) {
        paramVarArgs.f(10, this.TUz);
      }
      paramVarArgs.aY(11, this.TUA);
      paramVarArgs.bm(12, this.TUB);
      if (this.OkW != null) {
        paramVarArgs.f(13, this.OkW);
      }
      if (this.TUC != null) {
        paramVarArgs.f(14, this.TUC);
      }
      if (this.TUD != null) {
        paramVarArgs.f(15, this.TUD);
      }
      if (this.TUE != null) {
        paramVarArgs.f(16, this.TUE);
      }
      if (this.TUF != null) {
        paramVarArgs.f(17, this.TUF);
      }
      paramVarArgs.e(18, 8, this.TUG);
      AppMethodBeat.o(91623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1556;
      }
    }
    label1556:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TUx != null) {
        i = paramInt + g.a.a.a.oD(4, this.TUx.computeSize());
      }
      paramInt = i;
      if (this.TUy != null) {
        paramInt = i + g.a.a.a.oD(5, this.TUy.computeSize());
      }
      i = paramInt;
      if (this.TAJ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TAJ);
      }
      i = i + g.a.a.a.c(7, 8, this.Tbw) + (g.a.a.b.b.a.gL(8) + 1) + g.a.a.b.b.a.bM(9, this.Olc);
      paramInt = i;
      if (this.TUz != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TUz);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.TUA) + g.a.a.b.b.a.p(12, this.TUB);
      paramInt = i;
      if (this.OkW != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.OkW);
      }
      i = paramInt;
      if (this.TUC != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TUC);
      }
      paramInt = i;
      if (this.TUD != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.TUD);
      }
      i = paramInt;
      if (this.TUE != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.TUE);
      }
      paramInt = i;
      if (this.TUF != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.TUF);
      }
      i = g.a.a.a.c(18, 8, this.TUG);
      AppMethodBeat.o(91623);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tbw.clear();
        this.TUG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91623);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnj localdnj = (dnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91623);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localdnj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 2: 
          localdnj.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91623);
          return 0;
        case 3: 
          localdnj.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clu)localObject2).parseFrom((byte[])localObject1);
            }
            localdnj.TUx = ((clu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dox();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dox)localObject2).parseFrom((byte[])localObject1);
            }
            localdnj.TUy = ((dox)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 6: 
          localdnj.TAJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vm)localObject2).parseFrom((byte[])localObject1);
            }
            localdnj.Tbw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 8: 
          localdnj.TAK = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91623);
          return 0;
        case 9: 
          localdnj.Olc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91623);
          return 0;
        case 10: 
          localdnj.TUz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 11: 
          localdnj.TUA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91623);
          return 0;
        case 12: 
          localdnj.TUB = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91623);
          return 0;
        case 13: 
          localdnj.OkW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 14: 
          localdnj.TUC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 15: 
          localdnj.TUD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 16: 
          localdnj.TUE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 17: 
          localdnj.TUF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91623);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dux();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dux)localObject2).parseFrom((byte[])localObject1);
          }
          localdnj.TUG.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      AppMethodBeat.o(91623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnj
 * JD-Core Version:    0.7.0.1
 */