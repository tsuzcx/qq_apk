package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clf
  extends com.tencent.mm.bx.a
{
  public int Gzf;
  public String Gzg;
  public String Gzh;
  public dqc Hex;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gzf);
      if (this.Gzg != null) {
        paramVarArgs.d(2, this.Gzg);
      }
      if (this.Gzh != null) {
        paramVarArgs.d(3, this.Gzh);
      }
      if (this.Hex != null)
      {
        paramVarArgs.lC(4, this.Hex.computeSize());
        this.Hex.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gzf) + 0;
      paramInt = i;
      if (this.Gzg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gzg);
      }
      i = paramInt;
      if (this.Gzh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gzh);
      }
      paramInt = i;
      if (this.Hex != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hex.computeSize());
      }
      AppMethodBeat.o(32369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      clf localclf = (clf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32369);
        return -1;
      case 1: 
        localclf.Gzf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32369);
        return 0;
      case 2: 
        localclf.Gzg = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32369);
        return 0;
      case 3: 
        localclf.Gzh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32369);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dqc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dqc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localclf.Hex = ((dqc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    AppMethodBeat.o(32369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clf
 * JD-Core Version:    0.7.0.1
 */