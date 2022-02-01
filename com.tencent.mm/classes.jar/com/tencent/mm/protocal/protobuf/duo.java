package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duo
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public LinkedList<dtn> DAK;
  public LinkedList<rs> Dbl;
  public int EIV;
  public String EIW;
  public String EIX;
  public int EIY;
  public fo EIZ;
  
  public duo()
  {
    AppMethodBeat.i(123694);
    this.Dbl = new LinkedList();
    this.DAK = new LinkedList();
    AppMethodBeat.o(123694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CHC);
      paramVarArgs.aR(2, this.EIV);
      if (this.EIW != null) {
        paramVarArgs.d(3, this.EIW);
      }
      if (this.EIX != null) {
        paramVarArgs.d(4, this.EIX);
      }
      paramVarArgs.aR(5, this.EIY);
      paramVarArgs.e(6, 8, this.Dbl);
      if (this.EIZ != null)
      {
        paramVarArgs.kX(7, this.EIZ.computeSize());
        this.EIZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(36, 8, this.DAK);
      AppMethodBeat.o(123695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CHC) + 0 + f.a.a.b.b.a.bA(2, this.EIV);
      paramInt = i;
      if (this.EIW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EIW);
      }
      i = paramInt;
      if (this.EIX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EIX);
      }
      i = i + f.a.a.b.b.a.bA(5, this.EIY) + f.a.a.a.c(6, 8, this.Dbl);
      paramInt = i;
      if (this.EIZ != null) {
        paramInt = i + f.a.a.a.kW(7, this.EIZ.computeSize());
      }
      i = f.a.a.a.c(36, 8, this.DAK);
      AppMethodBeat.o(123695);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Dbl.clear();
      this.DAK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      duo localduo = (duo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123695);
        return -1;
      case 1: 
        localduo.CHC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123695);
        return 0;
      case 2: 
        localduo.EIV = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123695);
        return 0;
      case 3: 
        localduo.EIW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 4: 
        localduo.EIX = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 5: 
        localduo.EIY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123695);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localduo.Dbl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localduo.EIZ = ((fo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dtn();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dtn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localduo.DAK.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    AppMethodBeat.o(123695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duo
 * JD-Core Version:    0.7.0.1
 */