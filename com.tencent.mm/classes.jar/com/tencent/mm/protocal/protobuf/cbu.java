package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbu
  extends com.tencent.mm.bx.a
{
  public long FHC;
  public String GRf;
  public String GRh;
  public LinkedList<String> GRi;
  public LinkedList<bxe> GRj;
  public String GVH;
  public long Gth;
  public long Gti;
  
  public cbu()
  {
    AppMethodBeat.i(110907);
    this.GRi = new LinkedList();
    this.GRj = new LinkedList();
    AppMethodBeat.o(110907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110908);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Gti);
      paramVarArgs.aY(2, this.Gth);
      if (this.GRf != null) {
        paramVarArgs.d(3, this.GRf);
      }
      paramVarArgs.aY(4, this.FHC);
      if (this.GRh != null) {
        paramVarArgs.d(5, this.GRh);
      }
      paramVarArgs.e(6, 1, this.GRi);
      paramVarArgs.e(7, 8, this.GRj);
      if (this.GVH != null) {
        paramVarArgs.d(8, this.GVH);
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Gti) + 0 + f.a.a.b.b.a.p(2, this.Gth);
      paramInt = i;
      if (this.GRf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GRf);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.FHC);
      paramInt = i;
      if (this.GRh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GRh);
      }
      i = paramInt + f.a.a.a.c(6, 1, this.GRi) + f.a.a.a.c(7, 8, this.GRj);
      paramInt = i;
      if (this.GVH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GVH);
      }
      AppMethodBeat.o(110908);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GRi.clear();
      this.GRj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cbu localcbu = (cbu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110908);
        return -1;
      case 1: 
        localcbu.Gti = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110908);
        return 0;
      case 2: 
        localcbu.Gth = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110908);
        return 0;
      case 3: 
        localcbu.GRf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 4: 
        localcbu.FHC = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110908);
        return 0;
      case 5: 
        localcbu.GRh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 6: 
        localcbu.GRi.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(110908);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bxe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbu.GRj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110908);
        return 0;
      }
      localcbu.GVH = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(110908);
      return 0;
    }
    AppMethodBeat.o(110908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbu
 * JD-Core Version:    0.7.0.1
 */