package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class car
  extends com.tencent.mm.bx.a
{
  public ddo DXe;
  public bsb DXf;
  public bpy DXg;
  public long dEb;
  public String dca;
  public int foG;
  public int state;
  public String szi;
  public String uoo;
  public String vur;
  public int zEA;
  public String zEB;
  public String zEv;
  public String zEw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.foG);
      paramVarArgs.aG(2, this.dEb);
      if (this.dca != null) {
        paramVarArgs.d(3, this.dca);
      }
      if (this.uoo != null) {
        paramVarArgs.d(4, this.uoo);
      }
      if (this.zEv != null) {
        paramVarArgs.d(5, this.zEv);
      }
      if (this.zEw != null) {
        paramVarArgs.d(6, this.zEw);
      }
      if (this.DXe != null)
      {
        paramVarArgs.kX(7, this.DXe.computeSize());
        this.DXe.writeFields(paramVarArgs);
      }
      if (this.DXf != null)
      {
        paramVarArgs.kX(8, this.DXf.computeSize());
        this.DXf.writeFields(paramVarArgs);
      }
      if (this.DXg != null)
      {
        paramVarArgs.kX(9, this.DXg.computeSize());
        this.DXg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.zEA);
      paramVarArgs.aR(11, this.state);
      if (this.szi != null) {
        paramVarArgs.d(12, this.szi);
      }
      if (this.vur != null) {
        paramVarArgs.d(13, this.vur);
      }
      if (this.zEB != null) {
        paramVarArgs.d(14, this.zEB);
      }
      AppMethodBeat.o(91618);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.foG) + 0 + f.a.a.b.b.a.q(2, this.dEb);
      paramInt = i;
      if (this.dca != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dca);
      }
      i = paramInt;
      if (this.uoo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uoo);
      }
      paramInt = i;
      if (this.zEv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.zEv);
      }
      i = paramInt;
      if (this.zEw != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.zEw);
      }
      paramInt = i;
      if (this.DXe != null) {
        paramInt = i + f.a.a.a.kW(7, this.DXe.computeSize());
      }
      i = paramInt;
      if (this.DXf != null) {
        i = paramInt + f.a.a.a.kW(8, this.DXf.computeSize());
      }
      paramInt = i;
      if (this.DXg != null) {
        paramInt = i + f.a.a.a.kW(9, this.DXg.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.zEA) + f.a.a.b.b.a.bA(11, this.state);
      paramInt = i;
      if (this.szi != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.szi);
      }
      i = paramInt;
      if (this.vur != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.vur);
      }
      paramInt = i;
      if (this.zEB != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.zEB);
      }
      AppMethodBeat.o(91618);
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
      AppMethodBeat.o(91618);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      car localcar = (car)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91618);
        return -1;
      case 1: 
        localcar.foG = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91618);
        return 0;
      case 2: 
        localcar.dEb = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91618);
        return 0;
      case 3: 
        localcar.dca = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 4: 
        localcar.uoo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 5: 
        localcar.zEv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 6: 
        localcar.zEw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ddo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcar.DXe = ((ddo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcar.DXf = ((bsb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcar.DXg = ((bpy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91618);
        return 0;
      case 10: 
        localcar.zEA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91618);
        return 0;
      case 11: 
        localcar.state = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91618);
        return 0;
      case 12: 
        localcar.szi = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91618);
        return 0;
      case 13: 
        localcar.vur = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91618);
        return 0;
      }
      localcar.zEB = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(91618);
      return 0;
    }
    AppMethodBeat.o(91618);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.car
 * JD-Core Version:    0.7.0.1
 */