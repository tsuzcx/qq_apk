package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ps
  extends com.tencent.mm.bx.a
{
  public String CDW;
  public int COc;
  public bhl COd;
  public xc COe;
  public cmc Cvq;
  public int ntg;
  public int state;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91384);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.state);
      if (this.Cvq != null)
      {
        paramVarArgs.kX(2, this.Cvq.computeSize());
        this.Cvq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.COc);
      if (this.COd != null)
      {
        paramVarArgs.kX(4, this.COd.computeSize());
        this.COd.writeFields(paramVarArgs);
      }
      if (this.text != null) {
        paramVarArgs.d(5, this.text);
      }
      if (this.CDW != null) {
        paramVarArgs.d(6, this.CDW);
      }
      paramVarArgs.aR(7, this.ntg);
      if (this.COe != null)
      {
        paramVarArgs.kX(8, this.COe.computeSize());
        this.COe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.state) + 0;
      paramInt = i;
      if (this.Cvq != null) {
        paramInt = i + f.a.a.a.kW(2, this.Cvq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.COc);
      paramInt = i;
      if (this.COd != null) {
        paramInt = i + f.a.a.a.kW(4, this.COd.computeSize());
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.text);
      }
      paramInt = i;
      if (this.CDW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CDW);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.ntg);
      paramInt = i;
      if (this.COe != null) {
        paramInt = i + f.a.a.a.kW(8, this.COe.computeSize());
      }
      AppMethodBeat.o(91384);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ps localps = (ps)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91384);
        return -1;
      case 1: 
        localps.state = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91384);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localps.Cvq = ((cmc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 3: 
        localps.COc = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91384);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bhl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bhl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localps.COd = ((bhl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 5: 
        localps.text = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 6: 
        localps.CDW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 7: 
        localps.ntg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91384);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new xc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((xc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localps.COe = ((xc)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    AppMethodBeat.o(91384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ps
 * JD-Core Version:    0.7.0.1
 */