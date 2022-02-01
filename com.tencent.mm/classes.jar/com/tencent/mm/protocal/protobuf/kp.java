package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kp
  extends com.tencent.mm.bw.a
{
  public long DXI;
  public long DXJ;
  public LinkedList<kn> DXK;
  public boolean DXL;
  public long uin;
  
  public kp()
  {
    AppMethodBeat.i(110888);
    this.DXK = new LinkedList();
    this.DXL = false;
    AppMethodBeat.o(110888);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DXI);
      paramVarArgs.aO(2, this.uin);
      paramVarArgs.aO(3, this.DXJ);
      paramVarArgs.e(4, 8, this.DXK);
      paramVarArgs.bl(5, this.DXL);
      AppMethodBeat.o(110889);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.DXI);
      i = f.a.a.b.b.a.p(2, this.uin);
      int j = f.a.a.b.b.a.p(3, this.DXJ);
      int k = f.a.a.a.c(4, 8, this.DXK);
      int m = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(110889);
      return paramInt + 0 + i + j + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DXK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(110889);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      kp localkp = (kp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110889);
        return -1;
      case 1: 
        localkp.DXI = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110889);
        return 0;
      case 2: 
        localkp.uin = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110889);
        return 0;
      case 3: 
        localkp.DXJ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(110889);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((kn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localkp.DXK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110889);
        return 0;
      }
      localkp.DXL = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(110889);
      return 0;
    }
    AppMethodBeat.o(110889);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kp
 * JD-Core Version:    0.7.0.1
 */