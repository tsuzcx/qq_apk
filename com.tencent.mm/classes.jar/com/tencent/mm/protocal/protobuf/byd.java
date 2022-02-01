package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byd
  extends com.tencent.mm.bw.a
{
  public String FQl;
  public int GWA;
  public buh HkU;
  public long HkV;
  public String HkW;
  public int Scene;
  public String qkN;
  public int uuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Scene);
      paramVarArgs.aS(2, this.GWA);
      if (this.HkU != null)
      {
        paramVarArgs.lJ(3, this.HkU.computeSize());
        this.HkU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.uuz);
      if (this.qkN != null) {
        paramVarArgs.d(5, this.qkN);
      }
      paramVarArgs.aZ(6, this.HkV);
      if (this.FQl != null) {
        paramVarArgs.d(7, this.FQl);
      }
      if (this.HkW != null) {
        paramVarArgs.d(8, this.HkW);
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Scene) + 0 + f.a.a.b.b.a.bz(2, this.GWA);
      paramInt = i;
      if (this.HkU != null) {
        paramInt = i + f.a.a.a.lI(3, this.HkU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.uuz);
      paramInt = i;
      if (this.qkN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qkN);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.HkV);
      paramInt = i;
      if (this.FQl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FQl);
      }
      i = paramInt;
      if (this.HkW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HkW);
      }
      AppMethodBeat.o(117878);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byd localbyd = (byd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117878);
        return -1;
      case 1: 
        localbyd.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117878);
        return 0;
      case 2: 
        localbyd.GWA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117878);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((buh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyd.HkU = ((buh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117878);
        return 0;
      case 4: 
        localbyd.uuz = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117878);
        return 0;
      case 5: 
        localbyd.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117878);
        return 0;
      case 6: 
        localbyd.HkV = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117878);
        return 0;
      case 7: 
        localbyd.FQl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117878);
        return 0;
      }
      localbyd.HkW = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(117878);
      return 0;
    }
    AppMethodBeat.o(117878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byd
 * JD-Core Version:    0.7.0.1
 */