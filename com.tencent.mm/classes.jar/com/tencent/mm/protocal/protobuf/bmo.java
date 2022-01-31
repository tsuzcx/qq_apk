package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmo
  extends com.tencent.mm.bv.a
{
  public long cNd;
  public int eel;
  public String nLq;
  public String poq;
  public String ppo;
  public int state;
  public String wpe;
  public int wpg;
  public String xAV;
  public clk xAW;
  public bff xAX;
  public bdi xAY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56921);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.eel);
      paramVarArgs.am(2, this.cNd);
      if (this.poq != null) {
        paramVarArgs.e(3, this.poq);
      }
      if (this.ppo != null) {
        paramVarArgs.e(4, this.ppo);
      }
      if (this.wpe != null) {
        paramVarArgs.e(5, this.wpe);
      }
      if (this.xAV != null) {
        paramVarArgs.e(6, this.xAV);
      }
      if (this.xAW != null)
      {
        paramVarArgs.iQ(7, this.xAW.computeSize());
        this.xAW.writeFields(paramVarArgs);
      }
      if (this.xAX != null)
      {
        paramVarArgs.iQ(8, this.xAX.computeSize());
        this.xAX.writeFields(paramVarArgs);
      }
      if (this.xAY != null)
      {
        paramVarArgs.iQ(9, this.xAY.computeSize());
        this.xAY.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.wpg);
      paramVarArgs.aO(11, this.state);
      if (this.nLq != null) {
        paramVarArgs.e(12, this.nLq);
      }
      AppMethodBeat.o(56921);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.eel) + 0 + e.a.a.b.b.a.p(2, this.cNd);
      paramInt = i;
      if (this.poq != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.poq);
      }
      i = paramInt;
      if (this.ppo != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.ppo);
      }
      paramInt = i;
      if (this.wpe != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wpe);
      }
      i = paramInt;
      if (this.xAV != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xAV);
      }
      paramInt = i;
      if (this.xAW != null) {
        paramInt = i + e.a.a.a.iP(7, this.xAW.computeSize());
      }
      i = paramInt;
      if (this.xAX != null) {
        i = paramInt + e.a.a.a.iP(8, this.xAX.computeSize());
      }
      paramInt = i;
      if (this.xAY != null) {
        paramInt = i + e.a.a.a.iP(9, this.xAY.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.wpg) + e.a.a.b.b.a.bl(11, this.state);
      paramInt = i;
      if (this.nLq != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.nLq);
      }
      AppMethodBeat.o(56921);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56921);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bmo localbmo = (bmo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56921);
        return -1;
      case 1: 
        localbmo.eel = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56921);
        return 0;
      case 2: 
        localbmo.cNd = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56921);
        return 0;
      case 3: 
        localbmo.poq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56921);
        return 0;
      case 4: 
        localbmo.ppo = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56921);
        return 0;
      case 5: 
        localbmo.wpe = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56921);
        return 0;
      case 6: 
        localbmo.xAV = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56921);
        return 0;
      case 7: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbmo.xAW = ((clk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56921);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bff();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bff)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbmo.xAX = ((bff)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56921);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdi();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbmo.xAY = ((bdi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56921);
        return 0;
      case 10: 
        localbmo.wpg = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56921);
        return 0;
      case 11: 
        localbmo.state = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56921);
        return 0;
      }
      localbmo.nLq = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(56921);
      return 0;
    }
    AppMethodBeat.o(56921);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmo
 * JD-Core Version:    0.7.0.1
 */