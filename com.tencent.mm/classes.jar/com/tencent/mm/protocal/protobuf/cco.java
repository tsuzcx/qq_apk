package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cco
  extends com.tencent.mm.bw.a
{
  public long FZY;
  public long GMF;
  public long GMG;
  public String HkG;
  public String HkI;
  public LinkedList<String> HkJ;
  public LinkedList<bxy> HkK;
  public String Hpi;
  
  public cco()
  {
    AppMethodBeat.i(110907);
    this.HkJ = new LinkedList();
    this.HkK = new LinkedList();
    AppMethodBeat.o(110907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110908);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GMG);
      paramVarArgs.aZ(2, this.GMF);
      if (this.HkG != null) {
        paramVarArgs.d(3, this.HkG);
      }
      paramVarArgs.aZ(4, this.FZY);
      if (this.HkI != null) {
        paramVarArgs.d(5, this.HkI);
      }
      paramVarArgs.e(6, 1, this.HkJ);
      paramVarArgs.e(7, 8, this.HkK);
      if (this.Hpi != null) {
        paramVarArgs.d(8, this.Hpi);
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.GMG) + 0 + f.a.a.b.b.a.p(2, this.GMF);
      paramInt = i;
      if (this.HkG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HkG);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.FZY);
      paramInt = i;
      if (this.HkI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HkI);
      }
      i = paramInt + f.a.a.a.c(6, 1, this.HkJ) + f.a.a.a.c(7, 8, this.HkK);
      paramInt = i;
      if (this.Hpi != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hpi);
      }
      AppMethodBeat.o(110908);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HkJ.clear();
      this.HkK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110908);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cco localcco = (cco)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110908);
        return -1;
      case 1: 
        localcco.GMG = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110908);
        return 0;
      case 2: 
        localcco.GMF = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110908);
        return 0;
      case 3: 
        localcco.HkG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 4: 
        localcco.FZY = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110908);
        return 0;
      case 5: 
        localcco.HkI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(110908);
        return 0;
      case 6: 
        localcco.HkJ.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(110908);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bxy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcco.HkK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110908);
        return 0;
      }
      localcco.Hpi = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(110908);
      return 0;
    }
    AppMethodBeat.o(110908);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cco
 * JD-Core Version:    0.7.0.1
 */