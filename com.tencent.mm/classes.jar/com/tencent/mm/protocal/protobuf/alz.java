package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alz
  extends com.tencent.mm.bx.a
{
  public bgc DmZ;
  public int Dna = -1;
  public int Dnb = -1;
  public boolean Dnc = false;
  public int Dnd = -1;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.DmZ != null)
      {
        paramVarArgs.kX(2, this.DmZ.computeSize());
        this.DmZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Dna);
      paramVarArgs.aR(4, this.Dnb);
      paramVarArgs.bg(5, this.Dnc);
      paramVarArgs.aR(6, this.Dnd);
      AppMethodBeat.o(122490);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.DmZ != null) {
        paramInt = i + f.a.a.a.kW(2, this.DmZ.computeSize());
      }
      i = f.a.a.b.b.a.bA(3, this.Dna);
      int j = f.a.a.b.b.a.bA(4, this.Dnb);
      int k = f.a.a.b.b.a.fY(5);
      int m = f.a.a.b.b.a.bA(6, this.Dnd);
      AppMethodBeat.o(122490);
      return paramInt + i + j + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(122490);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      alz localalz = (alz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122490);
        return -1;
      case 1: 
        localalz.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122490);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bgc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localalz.DmZ = ((bgc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122490);
        return 0;
      case 3: 
        localalz.Dna = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122490);
        return 0;
      case 4: 
        localalz.Dnb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122490);
        return 0;
      case 5: 
        localalz.Dnc = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(122490);
        return 0;
      }
      localalz.Dnd = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(122490);
      return 0;
    }
    AppMethodBeat.o(122490);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alz
 * JD-Core Version:    0.7.0.1
 */