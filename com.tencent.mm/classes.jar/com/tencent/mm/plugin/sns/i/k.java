package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bx.a
{
  public LinkedList<Long> rtu;
  public int state;
  public long timestamp;
  public LinkedList<Long> zqK;
  public int zqL;
  public int zqM;
  
  public k()
  {
    AppMethodBeat.i(179121);
    this.rtu = new LinkedList();
    this.zqK = new LinkedList();
    AppMethodBeat.o(179121);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179122);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.rtu);
      paramVarArgs.aY(2, this.timestamp);
      paramVarArgs.aS(3, this.state);
      paramVarArgs.e(4, 3, this.zqK);
      paramVarArgs.aS(5, this.zqL);
      paramVarArgs.aS(6, this.zqM);
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 3, this.rtu);
      int i = f.a.a.b.b.a.p(2, this.timestamp);
      int j = f.a.a.b.b.a.bz(3, this.state);
      int k = f.a.a.a.c(4, 3, this.zqK);
      int m = f.a.a.b.b.a.bz(5, this.zqL);
      int n = f.a.a.b.b.a.bz(6, this.zqM);
      AppMethodBeat.o(179122);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.rtu.clear();
      this.zqK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179122);
        return -1;
      case 1: 
        localk.rtu.add(Long.valueOf(locala.NPN.zd()));
        AppMethodBeat.o(179122);
        return 0;
      case 2: 
        localk.timestamp = locala.NPN.zd();
        AppMethodBeat.o(179122);
        return 0;
      case 3: 
        localk.state = locala.NPN.zc();
        AppMethodBeat.o(179122);
        return 0;
      case 4: 
        localk.zqK.add(Long.valueOf(locala.NPN.zd()));
        AppMethodBeat.o(179122);
        return 0;
      case 5: 
        localk.zqL = locala.NPN.zc();
        AppMethodBeat.o(179122);
        return 0;
      }
      localk.zqM = locala.NPN.zc();
      AppMethodBeat.o(179122);
      return 0;
    }
    AppMethodBeat.o(179122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.k
 * JD-Core Version:    0.7.0.1
 */