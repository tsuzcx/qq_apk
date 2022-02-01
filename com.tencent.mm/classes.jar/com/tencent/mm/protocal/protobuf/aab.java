package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aab
  extends com.tencent.mm.bx.a
{
  public String FYZ;
  public zx FZa;
  public String FxH;
  public String dwW;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117861);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.timestamp);
      if (this.FYZ != null) {
        paramVarArgs.d(2, this.FYZ);
      }
      if (this.FxH != null) {
        paramVarArgs.d(3, this.FxH);
      }
      if (this.dwW != null) {
        paramVarArgs.d(4, this.dwW);
      }
      if (this.FZa != null)
      {
        paramVarArgs.lC(5, this.FZa.computeSize());
        this.FZa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.timestamp) + 0;
      paramInt = i;
      if (this.FYZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FYZ);
      }
      i = paramInt;
      if (this.FxH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FxH);
      }
      paramInt = i;
      if (this.dwW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dwW);
      }
      i = paramInt;
      if (this.FZa != null) {
        i = paramInt + f.a.a.a.lB(5, this.FZa.computeSize());
      }
      AppMethodBeat.o(117861);
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
      AppMethodBeat.o(117861);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aab localaab = (aab)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117861);
        return -1;
      case 1: 
        localaab.timestamp = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117861);
        return 0;
      case 2: 
        localaab.FYZ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 3: 
        localaab.FxH = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 4: 
        localaab.dwW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117861);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new zx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((zx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaab.FZa = ((zx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    AppMethodBeat.o(117861);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aab
 * JD-Core Version:    0.7.0.1
 */