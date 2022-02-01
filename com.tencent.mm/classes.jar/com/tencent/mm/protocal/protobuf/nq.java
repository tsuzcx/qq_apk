package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nq
  extends cvc
{
  public LinkedList<String> FHZ;
  public String FIa;
  public double FIb;
  public double FIc;
  public String ProductID;
  public int Scene;
  
  public nq()
  {
    AppMethodBeat.i(124427);
    this.FHZ = new LinkedList();
    AppMethodBeat.o(124427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(2, this.ProductID);
      }
      paramVarArgs.e(3, 1, this.FHZ);
      paramVarArgs.aS(4, this.Scene);
      if (this.FIa != null) {
        paramVarArgs.d(5, this.FIa);
      }
      paramVarArgs.e(6, this.FIb);
      paramVarArgs.e(7, this.FIc);
      AppMethodBeat.o(124428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ProductID);
      }
      i = i + f.a.a.a.c(3, 1, this.FHZ) + f.a.a.b.b.a.bz(4, this.Scene);
      paramInt = i;
      if (this.FIa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FIa);
      }
      i = f.a.a.b.b.a.alT(6);
      int j = f.a.a.b.b.a.alT(7);
      AppMethodBeat.o(124428);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FHZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nq localnq = (nq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124428);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124428);
          return 0;
        case 2: 
          localnq.ProductID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 3: 
          localnq.FHZ.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(124428);
          return 0;
        case 4: 
          localnq.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124428);
          return 0;
        case 5: 
          localnq.FIa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 6: 
          localnq.FIb = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(124428);
          return 0;
        }
        localnq.FIc = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(124428);
        return 0;
      }
      AppMethodBeat.o(124428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nq
 * JD-Core Version:    0.7.0.1
 */