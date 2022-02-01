package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bw.a
{
  public LinkedList<Long> qJs;
  public int state;
  public long timestamp;
  public LinkedList<Long> yaO;
  public int yaP;
  public int yaQ;
  
  public k()
  {
    AppMethodBeat.i(179121);
    this.qJs = new LinkedList();
    this.yaO = new LinkedList();
    AppMethodBeat.o(179121);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179122);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.qJs);
      paramVarArgs.aO(2, this.timestamp);
      paramVarArgs.aR(3, this.state);
      paramVarArgs.e(4, 3, this.yaO);
      paramVarArgs.aR(5, this.yaP);
      paramVarArgs.aR(6, this.yaQ);
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 3, this.qJs);
      int i = f.a.a.b.b.a.p(2, this.timestamp);
      int j = f.a.a.b.b.a.bx(3, this.state);
      int k = f.a.a.a.c(4, 3, this.yaO);
      int m = f.a.a.b.b.a.bx(5, this.yaP);
      int n = f.a.a.b.b.a.bx(6, this.yaQ);
      AppMethodBeat.o(179122);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.qJs.clear();
      this.yaO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localk.qJs.add(Long.valueOf(locala.LVo.xG()));
        AppMethodBeat.o(179122);
        return 0;
      case 2: 
        localk.timestamp = locala.LVo.xG();
        AppMethodBeat.o(179122);
        return 0;
      case 3: 
        localk.state = locala.LVo.xF();
        AppMethodBeat.o(179122);
        return 0;
      case 4: 
        localk.yaO.add(Long.valueOf(locala.LVo.xG()));
        AppMethodBeat.o(179122);
        return 0;
      case 5: 
        localk.yaP = locala.LVo.xF();
        AppMethodBeat.o(179122);
        return 0;
      }
      localk.yaQ = locala.LVo.xF();
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