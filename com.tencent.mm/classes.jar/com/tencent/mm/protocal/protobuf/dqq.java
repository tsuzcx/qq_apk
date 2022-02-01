package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqq
  extends com.tencent.mm.cd.a
{
  public int TXg;
  public boolean TXh;
  public String TXi;
  public int TXj;
  public int TXk;
  public LinkedList<dqp> TXl;
  public String fUL;
  
  public dqq()
  {
    AppMethodBeat.i(114057);
    this.TXl = new LinkedList();
    AppMethodBeat.o(114057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114058);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fUL != null) {
        paramVarArgs.f(1, this.fUL);
      }
      paramVarArgs.aY(2, this.TXg);
      paramVarArgs.co(3, this.TXh);
      if (this.TXi != null) {
        paramVarArgs.f(4, this.TXi);
      }
      paramVarArgs.aY(5, this.TXj);
      paramVarArgs.aY(6, this.TXk);
      paramVarArgs.e(7, 8, this.TXl);
      AppMethodBeat.o(114058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fUL == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = g.a.a.b.b.a.g(1, this.fUL) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TXg) + (g.a.a.b.b.a.gL(3) + 1);
      paramInt = i;
      if (this.TXi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TXi);
      }
      i = g.a.a.b.b.a.bM(5, this.TXj);
      int j = g.a.a.b.b.a.bM(6, this.TXk);
      int k = g.a.a.a.c(7, 8, this.TXl);
      AppMethodBeat.o(114058);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TXl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dqq localdqq = (dqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114058);
          return -1;
        case 1: 
          localdqq.fUL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 2: 
          localdqq.TXg = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114058);
          return 0;
        case 3: 
          localdqq.TXh = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(114058);
          return 0;
        case 4: 
          localdqq.TXi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 5: 
          localdqq.TXj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114058);
          return 0;
        case 6: 
          localdqq.TXk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114058);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dqp localdqp = new dqp();
          if ((localObject != null) && (localObject.length > 0)) {
            localdqp.parseFrom((byte[])localObject);
          }
          localdqq.TXl.add(localdqp);
          paramInt += 1;
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      AppMethodBeat.o(114058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqq
 * JD-Core Version:    0.7.0.1
 */