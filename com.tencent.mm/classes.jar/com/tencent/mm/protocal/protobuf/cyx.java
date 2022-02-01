package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyx
  extends com.tencent.mm.bw.a
{
  public String GQJ;
  public long GeP;
  public String GeS;
  public int GeT;
  public int HIW;
  public LinkedList<duv> HIX;
  public buh HkU;
  public int Scene;
  
  public cyx()
  {
    AppMethodBeat.i(117908);
    this.HIX = new LinkedList();
    AppMethodBeat.o(117908);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117909);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GQJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.GeP);
      if (this.GQJ != null) {
        paramVarArgs.d(2, this.GQJ);
      }
      paramVarArgs.aS(3, this.GeT);
      if (this.HkU != null)
      {
        paramVarArgs.lJ(4, this.HkU.computeSize());
        this.HkU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HIW);
      paramVarArgs.e(6, 8, this.HIX);
      paramVarArgs.aS(7, this.Scene);
      if (this.GeS != null) {
        paramVarArgs.d(8, this.GeS);
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.GeP) + 0;
      paramInt = i;
      if (this.GQJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GQJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GeT);
      paramInt = i;
      if (this.HkU != null) {
        paramInt = i + f.a.a.a.lI(4, this.HkU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HIW) + f.a.a.a.c(6, 8, this.HIX) + f.a.a.b.b.a.bz(7, this.Scene);
      paramInt = i;
      if (this.GeS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GeS);
      }
      AppMethodBeat.o(117909);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HIX.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GQJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cyx localcyx = (cyx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117909);
        return -1;
      case 1: 
        localcyx.GeP = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117909);
        return 0;
      case 2: 
        localcyx.GQJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117909);
        return 0;
      case 3: 
        localcyx.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117909);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyx.HkU = ((buh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 5: 
        localcyx.HIW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117909);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new duv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((duv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyx.HIX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 7: 
        localcyx.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117909);
        return 0;
      }
      localcyx.GeS = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(117909);
      return 0;
    }
    AppMethodBeat.o(117909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyx
 * JD-Core Version:    0.7.0.1
 */