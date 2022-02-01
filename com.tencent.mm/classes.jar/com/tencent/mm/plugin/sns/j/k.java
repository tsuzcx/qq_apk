package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bx.a
{
  public LinkedList<Long> qaM;
  public int state;
  public long timestamp;
  public LinkedList<Long> wOh;
  public int wOi;
  public int wOj;
  
  public k()
  {
    AppMethodBeat.i(179121);
    this.qaM = new LinkedList();
    this.wOh = new LinkedList();
    AppMethodBeat.o(179121);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179122);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.qaM);
      paramVarArgs.aG(2, this.timestamp);
      paramVarArgs.aR(3, this.state);
      paramVarArgs.e(4, 3, this.wOh);
      paramVarArgs.aR(5, this.wOi);
      paramVarArgs.aR(6, this.wOj);
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 3, this.qaM);
      int i = f.a.a.b.b.a.q(2, this.timestamp);
      int j = f.a.a.b.b.a.bA(3, this.state);
      int k = f.a.a.a.c(4, 3, this.wOh);
      int m = f.a.a.b.b.a.bA(5, this.wOi);
      int n = f.a.a.b.b.a.bA(6, this.wOj);
      AppMethodBeat.o(179122);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.qaM.clear();
      this.wOh.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localk.qaM.add(Long.valueOf(locala.KhF.xT()));
        AppMethodBeat.o(179122);
        return 0;
      case 2: 
        localk.timestamp = locala.KhF.xT();
        AppMethodBeat.o(179122);
        return 0;
      case 3: 
        localk.state = locala.KhF.xS();
        AppMethodBeat.o(179122);
        return 0;
      case 4: 
        localk.wOh.add(Long.valueOf(locala.KhF.xT()));
        AppMethodBeat.o(179122);
        return 0;
      case 5: 
        localk.wOi = locala.KhF.xS();
        AppMethodBeat.o(179122);
        return 0;
      }
      localk.wOj = locala.KhF.xS();
      AppMethodBeat.o(179122);
      return 0;
    }
    AppMethodBeat.o(179122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.k
 * JD-Core Version:    0.7.0.1
 */