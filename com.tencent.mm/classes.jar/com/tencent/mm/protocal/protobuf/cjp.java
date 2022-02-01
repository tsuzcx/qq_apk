package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjp
  extends com.tencent.mm.cd.a
{
  public LinkedList<cjq> SXU;
  public LinkedList<fbo> SXV;
  public LinkedList<cjq> Trc;
  public int aNf;
  public int count;
  public long duration;
  public String fFe;
  public String fLj;
  public long startTime;
  
  public cjp()
  {
    AppMethodBeat.i(122512);
    this.fFe = "";
    this.startTime = 0L;
    this.duration = 0L;
    this.fLj = "";
    this.SXU = new LinkedList();
    this.count = 1;
    this.Trc = new LinkedList();
    this.SXV = new LinkedList();
    AppMethodBeat.o(122512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fFe != null) {
        paramVarArgs.f(1, this.fFe);
      }
      paramVarArgs.bm(2, this.startTime);
      paramVarArgs.bm(3, this.duration);
      if (this.fLj != null) {
        paramVarArgs.f(4, this.fLj);
      }
      paramVarArgs.e(5, 8, this.SXU);
      paramVarArgs.aY(6, this.count);
      paramVarArgs.e(7, 8, this.Trc);
      paramVarArgs.e(8, 8, this.SXV);
      paramVarArgs.aY(9, this.aNf);
      AppMethodBeat.o(122513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fFe == null) {
        break label820;
      }
    }
    label820:
    for (paramInt = g.a.a.b.b.a.g(1, this.fFe) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.startTime) + g.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.fLj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fLj);
      }
      i = g.a.a.a.c(5, 8, this.SXU);
      int j = g.a.a.b.b.a.bM(6, this.count);
      int k = g.a.a.a.c(7, 8, this.Trc);
      int m = g.a.a.a.c(8, 8, this.SXV);
      int n = g.a.a.b.b.a.bM(9, this.aNf);
      AppMethodBeat.o(122513);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SXU.clear();
        this.Trc.clear();
        this.SXV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cjp localcjp = (cjp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122513);
          return -1;
        case 1: 
          localcjp.fFe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 2: 
          localcjp.startTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(122513);
          return 0;
        case 3: 
          localcjp.duration = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(122513);
          return 0;
        case 4: 
          localcjp.fLj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjq)localObject2).parseFrom((byte[])localObject1);
            }
            localcjp.SXU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 6: 
          localcjp.count = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(122513);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjq)localObject2).parseFrom((byte[])localObject1);
            }
            localcjp.Trc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbo)localObject2).parseFrom((byte[])localObject1);
            }
            localcjp.SXV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        }
        localcjp.aNf = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(122513);
        return 0;
      }
      AppMethodBeat.o(122513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjp
 * JD-Core Version:    0.7.0.1
 */