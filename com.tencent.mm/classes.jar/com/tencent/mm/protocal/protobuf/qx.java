package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qx
  extends com.tencent.mm.bw.a
{
  public String DKP;
  public LinkedList<zo> EhV;
  public int EhW;
  public String EhX;
  public String name;
  
  public qx()
  {
    AppMethodBeat.i(32155);
    this.EhV = new LinkedList();
    AppMethodBeat.o(32155);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.EhV);
      if (this.DKP != null) {
        paramVarArgs.d(2, this.DKP);
      }
      paramVarArgs.aR(3, this.EhW);
      if (this.EhX != null) {
        paramVarArgs.d(4, this.EhX);
      }
      if (this.name != null) {
        paramVarArgs.d(5, this.name);
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.EhV) + 0;
      paramInt = i;
      if (this.DKP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DKP);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EhW);
      paramInt = i;
      if (this.EhX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EhX);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.name);
      }
      AppMethodBeat.o(32156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EhV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qx localqx = (qx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32156);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((zo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqx.EhV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32156);
        return 0;
      case 2: 
        localqx.DKP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32156);
        return 0;
      case 3: 
        localqx.EhW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32156);
        return 0;
      case 4: 
        localqx.EhX = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32156);
        return 0;
      }
      localqx.name = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(32156);
      return 0;
    }
    AppMethodBeat.o(32156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qx
 * JD-Core Version:    0.7.0.1
 */