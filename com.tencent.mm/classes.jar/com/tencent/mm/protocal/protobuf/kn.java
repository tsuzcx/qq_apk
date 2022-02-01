package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kn
  extends com.tencent.mm.bx.a
{
  public String FCM;
  public String FCR;
  public bzp FCS;
  public bnj FCT;
  public int Ret;
  public String nDs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      if (this.FCR != null) {
        paramVarArgs.d(2, this.FCR);
      }
      if (this.FCS != null)
      {
        paramVarArgs.lC(3, this.FCS.computeSize());
        this.FCS.writeFields(paramVarArgs);
      }
      if (this.FCM != null) {
        paramVarArgs.d(4, this.FCM);
      }
      if (this.nDs != null) {
        paramVarArgs.d(5, this.nDs);
      }
      if (this.FCT != null)
      {
        paramVarArgs.lC(6, this.FCT.computeSize());
        this.FCT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.FCR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FCR);
      }
      i = paramInt;
      if (this.FCS != null) {
        i = paramInt + f.a.a.a.lB(3, this.FCS.computeSize());
      }
      paramInt = i;
      if (this.FCM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FCM);
      }
      i = paramInt;
      if (this.nDs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDs);
      }
      paramInt = i;
      if (this.FCT != null) {
        paramInt = i + f.a.a.a.lB(6, this.FCT.computeSize());
      }
      AppMethodBeat.o(82393);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      kn localkn = (kn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82393);
        return -1;
      case 1: 
        localkn.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(82393);
        return 0;
      case 2: 
        localkn.FCR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bzp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localkn.FCS = ((bzp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82393);
        return 0;
      case 4: 
        localkn.FCM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 5: 
        localkn.nDs = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82393);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bnj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localkn.FCT = ((bnj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    AppMethodBeat.o(82393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kn
 * JD-Core Version:    0.7.0.1
 */