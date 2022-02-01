package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class rj
  extends com.tencent.mm.bw.a
{
  public String FKA;
  public String FNg;
  public int GaV;
  public String GfS;
  public b GfT;
  public rk GfU;
  public ri GfV;
  public rl GfW;
  public String oBM;
  public String oBN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220222);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GaV);
      if (this.oBM != null) {
        paramVarArgs.d(2, this.oBM);
      }
      if (this.oBN != null) {
        paramVarArgs.d(3, this.oBN);
      }
      if (this.FKA != null) {
        paramVarArgs.d(4, this.FKA);
      }
      if (this.GfS != null) {
        paramVarArgs.d(5, this.GfS);
      }
      if (this.GfT != null) {
        paramVarArgs.c(6, this.GfT);
      }
      if (this.FNg != null) {
        paramVarArgs.d(7, this.FNg);
      }
      if (this.GfU != null)
      {
        paramVarArgs.lJ(101, this.GfU.computeSize());
        this.GfU.writeFields(paramVarArgs);
      }
      if (this.GfV != null)
      {
        paramVarArgs.lJ(102, this.GfV.computeSize());
        this.GfV.writeFields(paramVarArgs);
      }
      if (this.GfW != null)
      {
        paramVarArgs.lJ(103, this.GfW.computeSize());
        this.GfW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(220222);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GaV) + 0;
      paramInt = i;
      if (this.oBM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oBM);
      }
      i = paramInt;
      if (this.oBN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oBN);
      }
      paramInt = i;
      if (this.FKA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FKA);
      }
      i = paramInt;
      if (this.GfS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GfS);
      }
      paramInt = i;
      if (this.GfT != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.GfT);
      }
      i = paramInt;
      if (this.FNg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FNg);
      }
      paramInt = i;
      if (this.GfU != null) {
        paramInt = i + f.a.a.a.lI(101, this.GfU.computeSize());
      }
      i = paramInt;
      if (this.GfV != null) {
        i = paramInt + f.a.a.a.lI(102, this.GfV.computeSize());
      }
      paramInt = i;
      if (this.GfW != null) {
        paramInt = i + f.a.a.a.lI(103, this.GfW.computeSize());
      }
      AppMethodBeat.o(220222);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(220222);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      rj localrj = (rj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(220222);
        return -1;
      case 1: 
        localrj.GaV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(220222);
        return 0;
      case 2: 
        localrj.oBM = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(220222);
        return 0;
      case 3: 
        localrj.oBN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(220222);
        return 0;
      case 4: 
        localrj.FKA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(220222);
        return 0;
      case 5: 
        localrj.GfS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(220222);
        return 0;
      case 6: 
        localrj.GfT = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(220222);
        return 0;
      case 7: 
        localrj.FNg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(220222);
        return 0;
      case 101: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrj.GfU = ((rk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(220222);
        return 0;
      case 102: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ri();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ri)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrj.GfV = ((ri)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(220222);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new rl();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((rl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localrj.GfW = ((rl)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(220222);
      return 0;
    }
    AppMethodBeat.o(220222);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rj
 * JD-Core Version:    0.7.0.1
 */