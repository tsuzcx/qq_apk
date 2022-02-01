package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class qh
  extends com.tencent.mm.bw.a
{
  public int Ehn;
  public LinkedList<Integer> Eho;
  
  public qh()
  {
    AppMethodBeat.i(133164);
    this.Eho = new LinkedList();
    AppMethodBeat.o(133164);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133165);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ehn);
      paramVarArgs.f(2, 2, this.Eho);
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.Ehn);
      int i = f.a.a.a.d(2, 2, this.Eho);
      AppMethodBeat.o(133165);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eho.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(133165);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      qh localqh = (qh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133165);
        return -1;
      case 1: 
        localqh.Ehn = locala.LVo.xF();
        AppMethodBeat.o(133165);
        return 0;
      }
      localqh.Eho = new f.a.a.a.a(locala.LVo.gfk().xy, unknownTagHandler).LVo.gfi();
      AppMethodBeat.o(133165);
      return 0;
    }
    AppMethodBeat.o(133165);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qh
 * JD-Core Version:    0.7.0.1
 */