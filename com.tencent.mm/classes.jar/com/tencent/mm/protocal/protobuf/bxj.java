package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxj
  extends com.tencent.mm.bx.a
{
  public int FAh;
  public String FxN;
  public int GDa;
  public btn GRt;
  public long GRu;
  public String GRv;
  public int Scene;
  public String qei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Scene);
      paramVarArgs.aS(2, this.GDa);
      if (this.GRt != null)
      {
        paramVarArgs.lC(3, this.GRt.computeSize());
        this.GRt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FAh);
      if (this.qei != null) {
        paramVarArgs.d(5, this.qei);
      }
      paramVarArgs.aY(6, this.GRu);
      if (this.FxN != null) {
        paramVarArgs.d(7, this.FxN);
      }
      if (this.GRv != null) {
        paramVarArgs.d(8, this.GRv);
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Scene) + 0 + f.a.a.b.b.a.bz(2, this.GDa);
      paramInt = i;
      if (this.GRt != null) {
        paramInt = i + f.a.a.a.lB(3, this.GRt.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.FAh);
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qei);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.GRu);
      paramInt = i;
      if (this.FxN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FxN);
      }
      i = paramInt;
      if (this.GRv != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GRv);
      }
      AppMethodBeat.o(117878);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bxj localbxj = (bxj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117878);
        return -1;
      case 1: 
        localbxj.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117878);
        return 0;
      case 2: 
        localbxj.GDa = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117878);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxj.GRt = ((btn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117878);
        return 0;
      case 4: 
        localbxj.FAh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117878);
        return 0;
      case 5: 
        localbxj.qei = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117878);
        return 0;
      case 6: 
        localbxj.GRu = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117878);
        return 0;
      case 7: 
        localbxj.FxN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117878);
        return 0;
      }
      localbxj.GRv = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(117878);
      return 0;
    }
    AppMethodBeat.o(117878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxj
 * JD-Core Version:    0.7.0.1
 */