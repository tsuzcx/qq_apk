package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kj
  extends com.tencent.mm.bx.a
{
  public long CFi;
  public long CFj;
  public LinkedList<kh> CFk;
  public boolean CFl;
  public long uin;
  
  public kj()
  {
    AppMethodBeat.i(110888);
    this.CFk = new LinkedList();
    this.CFl = false;
    AppMethodBeat.o(110888);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.CFi);
      paramVarArgs.aG(2, this.uin);
      paramVarArgs.aG(3, this.CFj);
      paramVarArgs.e(4, 8, this.CFk);
      paramVarArgs.bg(5, this.CFl);
      AppMethodBeat.o(110889);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.CFi);
      i = f.a.a.b.b.a.q(2, this.uin);
      int j = f.a.a.b.b.a.q(3, this.CFj);
      int k = f.a.a.a.c(4, 8, this.CFk);
      int m = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(110889);
      return paramInt + 0 + i + j + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CFk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110889);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      kj localkj = (kj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110889);
        return -1;
      case 1: 
        localkj.CFi = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110889);
        return 0;
      case 2: 
        localkj.uin = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110889);
        return 0;
      case 3: 
        localkj.CFj = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(110889);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((kh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localkj.CFk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110889);
        return 0;
      }
      localkj.CFl = ((f.a.a.a.a)localObject1).KhF.fHu();
      AppMethodBeat.o(110889);
      return 0;
    }
    AppMethodBeat.o(110889);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kj
 * JD-Core Version:    0.7.0.1
 */