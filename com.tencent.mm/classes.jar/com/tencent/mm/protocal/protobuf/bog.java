package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bog
  extends com.tencent.mm.bx.a
{
  public int CCp;
  public int DLD;
  public ble DLE;
  public long DLF;
  public int Scene;
  public String oXs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Scene);
      paramVarArgs.aR(2, this.DLD);
      if (this.DLE != null)
      {
        paramVarArgs.kX(3, this.DLE.computeSize());
        this.DLE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CCp);
      if (this.oXs != null) {
        paramVarArgs.d(5, this.oXs);
      }
      paramVarArgs.aG(6, this.DLF);
      AppMethodBeat.o(117878);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Scene) + 0 + f.a.a.b.b.a.bA(2, this.DLD);
      paramInt = i;
      if (this.DLE != null) {
        paramInt = i + f.a.a.a.kW(3, this.DLE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.CCp);
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.oXs);
      }
      i = f.a.a.b.b.a.q(6, this.DLF);
      AppMethodBeat.o(117878);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bog localbog = (bog)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117878);
        return -1;
      case 1: 
        localbog.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117878);
        return 0;
      case 2: 
        localbog.DLD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117878);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ble();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ble)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbog.DLE = ((ble)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117878);
        return 0;
      case 4: 
        localbog.CCp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117878);
        return 0;
      case 5: 
        localbog.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117878);
        return 0;
      }
      localbog.DLF = ((f.a.a.a.a)localObject1).KhF.xT();
      AppMethodBeat.o(117878);
      return 0;
    }
    AppMethodBeat.o(117878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bog
 * JD-Core Version:    0.7.0.1
 */