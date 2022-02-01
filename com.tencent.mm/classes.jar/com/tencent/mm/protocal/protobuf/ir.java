package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ir
  extends com.tencent.mm.bx.a
{
  public int IKW;
  public dal YKA;
  public int YKB;
  public gol YKC;
  public String YKD;
  public gol YKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133152);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YKz == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.YKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.IKW);
      if (this.YKz != null)
      {
        paramVarArgs.qD(2, this.YKz.computeSize());
        this.YKz.writeFields(paramVarArgs);
      }
      if (this.YKA != null)
      {
        paramVarArgs.qD(3, this.YKA.computeSize());
        this.YKA.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.YKB);
      if (this.YKC != null)
      {
        paramVarArgs.qD(5, this.YKC.computeSize());
        this.YKC.writeFields(paramVarArgs);
      }
      if (this.YKD != null) {
        paramVarArgs.g(6, this.YKD);
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.IKW) + 0;
      paramInt = i;
      if (this.YKz != null) {
        paramInt = i + i.a.a.a.qC(2, this.YKz.computeSize());
      }
      i = paramInt;
      if (this.YKA != null) {
        i = paramInt + i.a.a.a.qC(3, this.YKA.computeSize());
      }
      i += i.a.a.b.b.a.cJ(4, this.YKB);
      paramInt = i;
      if (this.YKC != null) {
        paramInt = i + i.a.a.a.qC(5, this.YKC.computeSize());
      }
      i = paramInt;
      if (this.YKD != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YKD);
      }
      AppMethodBeat.o(133152);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YKz == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.YKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ir localir = (ir)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133152);
        return -1;
      case 1: 
        localir.IKW = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133152);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localir.YKz = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dal();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dal)localObject2).parseFrom((byte[])localObject1);
          }
          localir.YKA = ((dal)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 4: 
        localir.YKB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133152);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localir.YKC = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      }
      localir.YKD = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(133152);
      return 0;
    }
    AppMethodBeat.o(133152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ir
 * JD-Core Version:    0.7.0.1
 */