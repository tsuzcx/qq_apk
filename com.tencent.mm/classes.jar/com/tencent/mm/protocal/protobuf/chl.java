package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chl
  extends com.tencent.mm.bx.a
{
  public LinkedList<Long> HaX;
  public int aHQ;
  public int dFx;
  public String dtL;
  public long qXg;
  public long qXh;
  public long qXi;
  public String qXj;
  public String qXk;
  public String sessionId;
  
  public chl()
  {
    AppMethodBeat.i(210607);
    this.aHQ = 0;
    this.qXg = 0L;
    this.qXh = 0L;
    this.qXi = 0L;
    this.dFx = 0;
    this.HaX = new LinkedList();
    AppMethodBeat.o(210607);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      if (this.dtL != null) {
        paramVarArgs.d(2, this.dtL);
      }
      paramVarArgs.aS(3, this.aHQ);
      paramVarArgs.aY(4, this.qXg);
      paramVarArgs.aY(5, this.qXh);
      paramVarArgs.aY(6, this.qXi);
      if (this.qXj != null) {
        paramVarArgs.d(7, this.qXj);
      }
      if (this.qXk != null) {
        paramVarArgs.d(8, this.qXk);
      }
      paramVarArgs.aS(9, this.dFx);
      paramVarArgs.e(10, 3, this.HaX);
      AppMethodBeat.o(210608);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label681;
      }
    }
    label681:
    for (paramInt = f.a.a.b.b.a.e(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dtL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dtL);
      }
      i = i + f.a.a.b.b.a.bz(3, this.aHQ) + f.a.a.b.b.a.p(4, this.qXg) + f.a.a.b.b.a.p(5, this.qXh) + f.a.a.b.b.a.p(6, this.qXi);
      paramInt = i;
      if (this.qXj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.qXj);
      }
      i = paramInt;
      if (this.qXk != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.qXk);
      }
      paramInt = f.a.a.b.b.a.bz(9, this.dFx);
      int j = f.a.a.a.c(10, 3, this.HaX);
      AppMethodBeat.o(210608);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HaX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(210608);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chl localchl = (chl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(210608);
          return -1;
        case 1: 
          localchl.sessionId = locala.NPN.readString();
          AppMethodBeat.o(210608);
          return 0;
        case 2: 
          localchl.dtL = locala.NPN.readString();
          AppMethodBeat.o(210608);
          return 0;
        case 3: 
          localchl.aHQ = locala.NPN.zc();
          AppMethodBeat.o(210608);
          return 0;
        case 4: 
          localchl.qXg = locala.NPN.zd();
          AppMethodBeat.o(210608);
          return 0;
        case 5: 
          localchl.qXh = locala.NPN.zd();
          AppMethodBeat.o(210608);
          return 0;
        case 6: 
          localchl.qXi = locala.NPN.zd();
          AppMethodBeat.o(210608);
          return 0;
        case 7: 
          localchl.qXj = locala.NPN.readString();
          AppMethodBeat.o(210608);
          return 0;
        case 8: 
          localchl.qXk = locala.NPN.readString();
          AppMethodBeat.o(210608);
          return 0;
        case 9: 
          localchl.dFx = locala.NPN.zc();
          AppMethodBeat.o(210608);
          return 0;
        }
        localchl.HaX.add(Long.valueOf(locala.NPN.zd()));
        AppMethodBeat.o(210608);
        return 0;
      }
      AppMethodBeat.o(210608);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chl
 * JD-Core Version:    0.7.0.1
 */