package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cmt
  extends com.tencent.mm.bw.a
{
  public long MqN;
  public LinkedList<b> Msh;
  public ccw Msi;
  public long Msj;
  public long dDw;
  public long id;
  
  public cmt()
  {
    AppMethodBeat.i(110903);
    this.Msh = new LinkedList();
    AppMethodBeat.o(110903);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110904);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.id);
      paramVarArgs.e(2, 6, this.Msh);
      if (this.Msi != null)
      {
        paramVarArgs.ni(3, this.Msi.computeSize());
        this.Msi.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(4, this.dDw);
      paramVarArgs.bb(5, this.MqN);
      paramVarArgs.bb(6, this.Msj);
      AppMethodBeat.o(110904);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.id) + 0 + g.a.a.a.c(2, 6, this.Msh);
      paramInt = i;
      if (this.Msi != null) {
        paramInt = i + g.a.a.a.nh(3, this.Msi.computeSize());
      }
      i = g.a.a.b.b.a.r(4, this.dDw);
      int j = g.a.a.b.b.a.r(5, this.MqN);
      int k = g.a.a.b.b.a.r(6, this.Msj);
      AppMethodBeat.o(110904);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Msh.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110904);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cmt localcmt = (cmt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110904);
        return -1;
      case 1: 
        localcmt.id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110904);
        return 0;
      case 2: 
        localcmt.Msh.add(((g.a.a.a.a)localObject1).UbS.hPo());
        AppMethodBeat.o(110904);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ccw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcmt.Msi = ((ccw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110904);
        return 0;
      case 4: 
        localcmt.dDw = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110904);
        return 0;
      case 5: 
        localcmt.MqN = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110904);
        return 0;
      }
      localcmt.Msj = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(110904);
      return 0;
    }
    AppMethodBeat.o(110904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmt
 * JD-Core Version:    0.7.0.1
 */