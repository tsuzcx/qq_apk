package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpy
  extends com.tencent.mm.bx.a
{
  public String FDt;
  public cwt GKC;
  public int GKD;
  public String GaD;
  public String nDo;
  public int qdX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155423);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.qdX);
      if (this.GKC != null)
      {
        paramVarArgs.lC(2, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      if (this.FDt != null) {
        paramVarArgs.d(3, this.FDt);
      }
      if (this.GaD != null) {
        paramVarArgs.d(4, this.GaD);
      }
      if (this.nDo != null) {
        paramVarArgs.d(5, this.nDo);
      }
      paramVarArgs.aS(6, this.GKD);
      AppMethodBeat.o(155423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.qdX) + 0;
      paramInt = i;
      if (this.GKC != null) {
        paramInt = i + f.a.a.a.lB(2, this.GKC.computeSize());
      }
      i = paramInt;
      if (this.FDt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FDt);
      }
      paramInt = i;
      if (this.GaD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GaD);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDo);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.GKD);
      AppMethodBeat.o(155423);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      AppMethodBeat.o(155423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bpy localbpy = (bpy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155423);
        return -1;
      case 1: 
        localbpy.qdX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(155423);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpy.GKC = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155423);
        return 0;
      case 3: 
        localbpy.FDt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 4: 
        localbpy.GaD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 5: 
        localbpy.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(155423);
        return 0;
      }
      localbpy.GKD = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(155423);
      return 0;
    }
    AppMethodBeat.o(155423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpy
 * JD-Core Version:    0.7.0.1
 */