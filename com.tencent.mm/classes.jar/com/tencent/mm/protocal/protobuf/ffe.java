package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffe
  extends com.tencent.mm.bx.a
{
  public String IKH;
  public long abES;
  public int vgN;
  public LinkedList<etl> vgO;
  
  public ffe()
  {
    AppMethodBeat.i(125816);
    this.vgO = new LinkedList();
    AppMethodBeat.o(125816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125817);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abES);
      if (this.IKH != null) {
        paramVarArgs.g(2, this.IKH);
      }
      paramVarArgs.bS(3, this.vgN);
      paramVarArgs.e(4, 8, this.vgO);
      AppMethodBeat.o(125817);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.abES) + 0;
      paramInt = i;
      if (this.IKH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IKH);
      }
      i = i.a.a.b.b.a.cJ(3, this.vgN);
      int j = i.a.a.a.c(4, 8, this.vgO);
      AppMethodBeat.o(125817);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.vgO.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ffe localffe = (ffe)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125817);
        return -1;
      case 1: 
        localffe.abES = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(125817);
        return 0;
      case 2: 
        localffe.IKH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(125817);
        return 0;
      case 3: 
        localffe.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125817);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        etl localetl = new etl();
        if ((localObject != null) && (localObject.length > 0)) {
          localetl.dh((byte[])localObject);
        }
        localffe.vgO.add(localetl);
        paramInt += 1;
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    AppMethodBeat.o(125817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffe
 * JD-Core Version:    0.7.0.1
 */