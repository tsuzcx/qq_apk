package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jy
  extends com.tencent.mm.bx.a
{
  public String CEQ;
  public String CEV;
  public bqj CEW;
  public bfj CEX;
  public int Ret;
  public String mAU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      if (this.CEV != null) {
        paramVarArgs.d(2, this.CEV);
      }
      if (this.CEW != null)
      {
        paramVarArgs.kX(3, this.CEW.computeSize());
        this.CEW.writeFields(paramVarArgs);
      }
      if (this.CEQ != null) {
        paramVarArgs.d(4, this.CEQ);
      }
      if (this.mAU != null) {
        paramVarArgs.d(5, this.mAU);
      }
      if (this.CEX != null)
      {
        paramVarArgs.kX(6, this.CEX.computeSize());
        this.CEX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Ret) + 0;
      paramInt = i;
      if (this.CEV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CEV);
      }
      i = paramInt;
      if (this.CEW != null) {
        i = paramInt + f.a.a.a.kW(3, this.CEW.computeSize());
      }
      paramInt = i;
      if (this.CEQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CEQ);
      }
      i = paramInt;
      if (this.mAU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAU);
      }
      paramInt = i;
      if (this.CEX != null) {
        paramInt = i + f.a.a.a.kW(6, this.CEX.computeSize());
      }
      AppMethodBeat.o(82393);
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
      AppMethodBeat.o(82393);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      jy localjy = (jy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82393);
        return -1;
      case 1: 
        localjy.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(82393);
        return 0;
      case 2: 
        localjy.CEV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localjy.CEW = ((bqj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82393);
        return 0;
      case 4: 
        localjy.CEQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 5: 
        localjy.mAU = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82393);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bfj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bfj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localjy.CEX = ((bfj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    AppMethodBeat.o(82393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jy
 * JD-Core Version:    0.7.0.1
 */