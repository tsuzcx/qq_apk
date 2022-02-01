package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csf
  extends com.tencent.mm.bx.a
{
  public dmo Gav;
  public String Gzv;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.Gzv != null) {
        paramVarArgs.d(2, this.Gzv);
      }
      if (this.Gav != null)
      {
        paramVarArgs.lC(3, this.Gav.computeSize());
        this.Gav.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.Gzv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gzv);
      }
      i = paramInt;
      if (this.Gav != null) {
        i = paramInt + f.a.a.a.lB(3, this.Gav.computeSize());
      }
      AppMethodBeat.o(91664);
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
      AppMethodBeat.o(91664);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      csf localcsf = (csf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91664);
        return -1;
      case 1: 
        localcsf.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91664);
        return 0;
      case 2: 
        localcsf.Gzv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91664);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dmo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcsf.Gav = ((dmo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    AppMethodBeat.o(91664);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csf
 * JD-Core Version:    0.7.0.1
 */