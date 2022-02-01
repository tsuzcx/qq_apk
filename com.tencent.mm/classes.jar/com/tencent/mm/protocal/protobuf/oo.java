package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oo
  extends com.tencent.mm.bw.a
{
  public LinkedList<nx> Gal;
  public int Gan;
  public String Gao;
  public long Gcv;
  
  public oo()
  {
    AppMethodBeat.i(188942);
    this.Gal = new LinkedList();
    AppMethodBeat.o(188942);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Gcv);
      paramVarArgs.e(2, 8, this.Gal);
      paramVarArgs.aS(3, this.Gan);
      if (this.Gao != null) {
        paramVarArgs.d(4, this.Gao);
      }
      AppMethodBeat.o(188943);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Gcv) + 0 + f.a.a.a.c(2, 8, this.Gal) + f.a.a.b.b.a.bz(3, this.Gan);
      paramInt = i;
      if (this.Gao != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gao);
      }
      AppMethodBeat.o(188943);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gal.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188943);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      oo localoo = (oo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(188943);
        return -1;
      case 1: 
        localoo.Gcv = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(188943);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((nx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localoo.Gal.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(188943);
        return 0;
      case 3: 
        localoo.Gan = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(188943);
        return 0;
      }
      localoo.Gao = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(188943);
      return 0;
    }
    AppMethodBeat.o(188943);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oo
 * JD-Core Version:    0.7.0.1
 */