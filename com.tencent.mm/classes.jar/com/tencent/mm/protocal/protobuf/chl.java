package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chl
  extends com.tencent.mm.bw.a
{
  public boolean ERq;
  public int Fnv;
  public LinkedList<byg> FvH;
  public String FvI;
  public String dlQ;
  public String nWj;
  
  public chl()
  {
    AppMethodBeat.i(176148);
    this.FvH = new LinkedList();
    AppMethodBeat.o(176148);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FvH);
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.FvI != null) {
        paramVarArgs.d(3, this.FvI);
      }
      if (this.nWj != null) {
        paramVarArgs.d(4, this.nWj);
      }
      paramVarArgs.bl(5, this.ERq);
      paramVarArgs.aR(6, this.Fnv);
      AppMethodBeat.o(176149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FvH) + 0;
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.FvI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FvI);
      }
      paramInt = i;
      if (this.nWj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nWj);
      }
      i = f.a.a.b.b.a.fK(5);
      int j = f.a.a.b.b.a.bx(6, this.Fnv);
      AppMethodBeat.o(176149);
      return paramInt + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FvH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(176149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      chl localchl = (chl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176149);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((byg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchl.FvH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176149);
        return 0;
      case 2: 
        localchl.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 3: 
        localchl.FvI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 4: 
        localchl.nWj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 5: 
        localchl.ERq = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(176149);
        return 0;
      }
      localchl.Fnv = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(176149);
      return 0;
    }
    AppMethodBeat.o(176149);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chl
 * JD-Core Version:    0.7.0.1
 */