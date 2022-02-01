package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cvu
  extends com.tencent.mm.cd.a
{
  public LinkedList<eaf> GroupUser;
  public String HlB;
  public int Privated;
  public int TEa;
  public int TEb;
  public LinkedList<csn> TEc;
  public LinkedList<elm> TEd;
  public int TEe;
  public long TEf;
  public int TEg;
  public LinkedList<Long> TEh;
  public int TEi;
  public int TEj;
  public String TEk;
  public int TEl;
  public ekm TEm;
  public LinkedList<eks> TEn;
  public String TEo;
  public long TEp;
  public String TEq;
  public boolean TEr;
  public ejk TEs;
  public dgj TEt;
  public String fUj;
  public int gbp;
  public int kQn;
  public String lps;
  public String sessionId;
  public String token;
  
  public cvu()
  {
    AppMethodBeat.i(125744);
    this.TEc = new LinkedList();
    this.TEd = new LinkedList();
    this.TEh = new LinkedList();
    this.GroupUser = new LinkedList();
    this.TEn = new LinkedList();
    AppMethodBeat.o(125744);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125745);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TEa);
      paramVarArgs.aY(2, this.TEb);
      paramVarArgs.aY(3, this.Privated);
      if (this.lps != null) {
        paramVarArgs.f(4, this.lps);
      }
      paramVarArgs.e(5, 8, this.TEc);
      paramVarArgs.e(6, 8, this.TEd);
      paramVarArgs.aY(7, this.TEe);
      paramVarArgs.aY(8, this.kQn);
      paramVarArgs.bm(9, this.TEf);
      paramVarArgs.aY(10, this.TEg);
      paramVarArgs.e(11, 3, this.TEh);
      paramVarArgs.aY(12, this.TEi);
      paramVarArgs.aY(13, this.TEj);
      if (this.token != null) {
        paramVarArgs.f(14, this.token);
      }
      if (this.TEk != null) {
        paramVarArgs.f(15, this.TEk);
      }
      paramVarArgs.aY(16, this.TEl);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.TEm != null)
      {
        paramVarArgs.oE(18, this.TEm.computeSize());
        this.TEm.writeFields(paramVarArgs);
      }
      if (this.fUj != null) {
        paramVarArgs.f(19, this.fUj);
      }
      paramVarArgs.e(20, 8, this.TEn);
      if (this.sessionId != null) {
        paramVarArgs.f(21, this.sessionId);
      }
      if (this.TEo != null) {
        paramVarArgs.f(22, this.TEo);
      }
      if (this.HlB != null) {
        paramVarArgs.f(23, this.HlB);
      }
      paramVarArgs.aY(24, this.gbp);
      paramVarArgs.bm(25, this.TEp);
      if (this.TEq != null) {
        paramVarArgs.f(26, this.TEq);
      }
      paramVarArgs.co(27, this.TEr);
      if (this.TEs != null)
      {
        paramVarArgs.oE(28, this.TEs.computeSize());
        this.TEs.writeFields(paramVarArgs);
      }
      if (this.TEt != null)
      {
        paramVarArgs.oE(29, this.TEt.computeSize());
        this.TEt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TEa) + 0 + g.a.a.b.b.a.bM(2, this.TEb) + g.a.a.b.b.a.bM(3, this.Privated);
      paramInt = i;
      if (this.lps != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lps);
      }
      i = paramInt + g.a.a.a.c(5, 8, this.TEc) + g.a.a.a.c(6, 8, this.TEd) + g.a.a.b.b.a.bM(7, this.TEe) + g.a.a.b.b.a.bM(8, this.kQn) + g.a.a.b.b.a.p(9, this.TEf) + g.a.a.b.b.a.bM(10, this.TEg) + g.a.a.a.c(11, 3, this.TEh) + g.a.a.b.b.a.bM(12, this.TEi) + g.a.a.b.b.a.bM(13, this.TEj);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.token);
      }
      i = paramInt;
      if (this.TEk != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.TEk);
      }
      i = i + g.a.a.b.b.a.bM(16, this.TEl) + g.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.TEm != null) {
        paramInt = i + g.a.a.a.oD(18, this.TEm.computeSize());
      }
      i = paramInt;
      if (this.fUj != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.fUj);
      }
      i += g.a.a.a.c(20, 8, this.TEn);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.sessionId);
      }
      i = paramInt;
      if (this.TEo != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.TEo);
      }
      paramInt = i;
      if (this.HlB != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.HlB);
      }
      i = paramInt + g.a.a.b.b.a.bM(24, this.gbp) + g.a.a.b.b.a.p(25, this.TEp);
      paramInt = i;
      if (this.TEq != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.TEq);
      }
      i = paramInt + (g.a.a.b.b.a.gL(27) + 1);
      paramInt = i;
      if (this.TEs != null) {
        paramInt = i + g.a.a.a.oD(28, this.TEs.computeSize());
      }
      i = paramInt;
      if (this.TEt != null) {
        i = paramInt + g.a.a.a.oD(29, this.TEt.computeSize());
      }
      AppMethodBeat.o(125745);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TEc.clear();
      this.TEd.clear();
      this.TEh.clear();
      this.GroupUser.clear();
      this.TEn.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cvu localcvu = (cvu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125745);
        return -1;
      case 1: 
        localcvu.TEa = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 2: 
        localcvu.TEb = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 3: 
        localcvu.Privated = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 4: 
        localcvu.lps = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new csn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((csn)localObject2).parseFrom((byte[])localObject1);
          }
          localcvu.TEc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new elm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((elm)localObject2).parseFrom((byte[])localObject1);
          }
          localcvu.TEd.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 7: 
        localcvu.TEe = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 8: 
        localcvu.kQn = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 9: 
        localcvu.TEf = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(125745);
        return 0;
      case 10: 
        localcvu.TEg = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 11: 
        localcvu.TEh.add(Long.valueOf(((g.a.a.a.a)localObject1).abFh.AN()));
        AppMethodBeat.o(125745);
        return 0;
      case 12: 
        localcvu.TEi = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 13: 
        localcvu.TEj = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 14: 
        localcvu.token = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 15: 
        localcvu.TEk = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 16: 
        localcvu.TEl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaf)localObject2).de((byte[])localObject1);
          }
          localcvu.GroupUser.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ekm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ekm)localObject2).parseFrom((byte[])localObject1);
          }
          localcvu.TEm = ((ekm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 19: 
        localcvu.fUj = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eks();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eks)localObject2).parseFrom((byte[])localObject1);
          }
          localcvu.TEn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 21: 
        localcvu.sessionId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 22: 
        localcvu.TEo = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 23: 
        localcvu.HlB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 24: 
        localcvu.gbp = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(125745);
        return 0;
      case 25: 
        localcvu.TEp = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(125745);
        return 0;
      case 26: 
        localcvu.TEq = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 27: 
        localcvu.TEr = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(125745);
        return 0;
      case 28: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ejk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ejk)localObject2).parseFrom((byte[])localObject1);
          }
          localcvu.TEs = ((ejk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dgj();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dgj)localObject2).parseFrom((byte[])localObject1);
        }
        localcvu.TEt = ((dgj)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    AppMethodBeat.o(125745);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvu
 * JD-Core Version:    0.7.0.1
 */