package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cbj
  extends dyy
{
  public boolean OHR;
  public String OKB;
  public String OKC;
  public String TjA;
  public String TjB;
  public String TjC;
  public boolean TjD;
  public String TjE;
  public long TjF;
  public boolean TjG;
  public boolean TjH;
  public boolean TjI;
  public String TjJ;
  public String TjK;
  public String TjL;
  public String TjM;
  public boolean TjN;
  public LinkedList<String> TjO;
  public coj TjP;
  public boolean TjQ;
  public boolean TjR;
  public boolean TjS;
  public LinkedList<dtk> TjT;
  public boolean TjU;
  public ely TjV;
  public String Tjy;
  public String Tjz;
  public int fwx;
  public String tVo;
  
  public cbj()
  {
    AppMethodBeat.i(91509);
    this.TjO = new LinkedList();
    this.TjT = new LinkedList();
    AppMethodBeat.o(91509);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91510);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.Tjy != null) {
        paramVarArgs.f(4, this.Tjy);
      }
      if (this.Tjz != null) {
        paramVarArgs.f(5, this.Tjz);
      }
      if (this.TjA != null) {
        paramVarArgs.f(6, this.TjA);
      }
      if (this.TjB != null) {
        paramVarArgs.f(7, this.TjB);
      }
      if (this.TjC != null) {
        paramVarArgs.f(8, this.TjC);
      }
      paramVarArgs.co(9, this.TjD);
      if (this.TjE != null) {
        paramVarArgs.f(10, this.TjE);
      }
      paramVarArgs.bm(11, this.TjF);
      paramVarArgs.co(12, this.TjG);
      paramVarArgs.co(13, this.TjH);
      paramVarArgs.co(14, this.TjI);
      if (this.TjJ != null) {
        paramVarArgs.f(15, this.TjJ);
      }
      if (this.TjK != null) {
        paramVarArgs.f(16, this.TjK);
      }
      if (this.TjL != null) {
        paramVarArgs.f(17, this.TjL);
      }
      if (this.TjM != null) {
        paramVarArgs.f(18, this.TjM);
      }
      paramVarArgs.co(19, this.TjN);
      paramVarArgs.e(20, 1, this.TjO);
      paramVarArgs.co(21, this.OHR);
      if (this.TjP != null)
      {
        paramVarArgs.oE(22, this.TjP.computeSize());
        this.TjP.writeFields(paramVarArgs);
      }
      paramVarArgs.co(23, this.TjQ);
      paramVarArgs.co(26, this.TjR);
      paramVarArgs.co(27, this.TjS);
      paramVarArgs.e(28, 8, this.TjT);
      if (this.OKB != null) {
        paramVarArgs.f(29, this.OKB);
      }
      if (this.OKC != null) {
        paramVarArgs.f(30, this.OKC);
      }
      paramVarArgs.co(31, this.TjU);
      if (this.TjV != null)
      {
        paramVarArgs.oE(32, this.TjV.computeSize());
        this.TjV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2106;
      }
    }
    label2106:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.Tjy != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Tjy);
      }
      paramInt = i;
      if (this.Tjz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Tjz);
      }
      i = paramInt;
      if (this.TjA != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TjA);
      }
      paramInt = i;
      if (this.TjB != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TjB);
      }
      i = paramInt;
      if (this.TjC != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TjC);
      }
      i += g.a.a.b.b.a.gL(9) + 1;
      paramInt = i;
      if (this.TjE != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TjE);
      }
      i = paramInt + g.a.a.b.b.a.p(11, this.TjF) + (g.a.a.b.b.a.gL(12) + 1) + (g.a.a.b.b.a.gL(13) + 1) + (g.a.a.b.b.a.gL(14) + 1);
      paramInt = i;
      if (this.TjJ != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.TjJ);
      }
      i = paramInt;
      if (this.TjK != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.TjK);
      }
      paramInt = i;
      if (this.TjL != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.TjL);
      }
      i = paramInt;
      if (this.TjM != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.TjM);
      }
      i = i + (g.a.a.b.b.a.gL(19) + 1) + g.a.a.a.c(20, 1, this.TjO) + (g.a.a.b.b.a.gL(21) + 1);
      paramInt = i;
      if (this.TjP != null) {
        paramInt = i + g.a.a.a.oD(22, this.TjP.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(23) + 1) + (g.a.a.b.b.a.gL(26) + 1) + (g.a.a.b.b.a.gL(27) + 1) + g.a.a.a.c(28, 8, this.TjT);
      paramInt = i;
      if (this.OKB != null) {
        paramInt = i + g.a.a.b.b.a.g(29, this.OKB);
      }
      i = paramInt;
      if (this.OKC != null) {
        i = paramInt + g.a.a.b.b.a.g(30, this.OKC);
      }
      i += g.a.a.b.b.a.gL(31) + 1;
      paramInt = i;
      if (this.TjV != null) {
        paramInt = i + g.a.a.a.oD(32, this.TjV.computeSize());
      }
      AppMethodBeat.o(91510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TjO.clear();
        this.TjT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbj localcbj = (cbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(91510);
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
            localcbj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 2: 
          localcbj.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91510);
          return 0;
        case 3: 
          localcbj.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 4: 
          localcbj.Tjy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 5: 
          localcbj.Tjz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 6: 
          localcbj.TjA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 7: 
          localcbj.TjB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 8: 
          localcbj.TjC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 9: 
          localcbj.TjD = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 10: 
          localcbj.TjE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 11: 
          localcbj.TjF = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91510);
          return 0;
        case 12: 
          localcbj.TjG = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 13: 
          localcbj.TjH = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 14: 
          localcbj.TjI = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 15: 
          localcbj.TjJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 16: 
          localcbj.TjK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 17: 
          localcbj.TjL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 18: 
          localcbj.TjM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 19: 
          localcbj.TjN = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 20: 
          localcbj.TjO.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(91510);
          return 0;
        case 21: 
          localcbj.OHR = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new coj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((coj)localObject2).parseFrom((byte[])localObject1);
            }
            localcbj.TjP = ((coj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 23: 
          localcbj.TjQ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 26: 
          localcbj.TjR = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 27: 
          localcbj.TjS = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtk)localObject2).parseFrom((byte[])localObject1);
            }
            localcbj.TjT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91510);
          return 0;
        case 29: 
          localcbj.OKB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 30: 
          localcbj.OKC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91510);
          return 0;
        case 31: 
          localcbj.TjU = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91510);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ely();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ely)localObject2).parseFrom((byte[])localObject1);
          }
          localcbj.TjV = ((ely)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91510);
        return 0;
      }
      AppMethodBeat.o(91510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbj
 * JD-Core Version:    0.7.0.1
 */