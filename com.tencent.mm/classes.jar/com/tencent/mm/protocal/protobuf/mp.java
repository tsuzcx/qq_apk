package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mp
  extends ckq
{
  public LinkedList<String> CJB;
  public String CJC;
  public double CJD;
  public double CJE;
  public String ProductID;
  public int Scene;
  
  public mp()
  {
    AppMethodBeat.i(124427);
    this.CJB = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(2, this.ProductID);
      }
      paramVarArgs.e(3, 1, this.CJB);
      paramVarArgs.aR(4, this.Scene);
      if (this.CJC != null) {
        paramVarArgs.d(5, this.CJC);
      }
      paramVarArgs.e(6, this.CJD);
      paramVarArgs.e(7, this.CJE);
      AppMethodBeat.o(124428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ProductID);
      }
      i = i + f.a.a.a.c(3, 1, this.CJB) + f.a.a.b.b.a.bA(4, this.Scene);
      paramInt = i;
      if (this.CJC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CJC);
      }
      i = f.a.a.b.b.a.fY(6);
      int j = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(124428);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CJB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mp localmp = (mp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124428);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124428);
          return 0;
        case 2: 
          localmp.ProductID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 3: 
          localmp.CJB.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(124428);
          return 0;
        case 4: 
          localmp.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124428);
          return 0;
        case 5: 
          localmp.CJC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 6: 
          localmp.CJD = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(124428);
          return 0;
        }
        localmp.CJE = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(124428);
        return 0;
      }
      AppMethodBeat.o(124428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mp
 * JD-Core Version:    0.7.0.1
 */