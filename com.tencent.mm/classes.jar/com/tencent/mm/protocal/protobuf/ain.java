package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ain
  extends cvc
{
  public String GfR;
  public String GfS;
  public long GfT;
  public double GfU;
  public double GfV;
  public String ePu;
  public String ePv;
  public String qeQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qeQ != null) {
        paramVarArgs.d(2, this.qeQ);
      }
      if (this.ePv != null) {
        paramVarArgs.d(3, this.ePv);
      }
      if (this.ePu != null) {
        paramVarArgs.d(4, this.ePu);
      }
      if (this.GfR != null) {
        paramVarArgs.d(5, this.GfR);
      }
      if (this.GfS != null) {
        paramVarArgs.d(6, this.GfS);
      }
      paramVarArgs.aY(7, this.GfT);
      paramVarArgs.e(8, this.GfU);
      paramVarArgs.e(9, this.GfV);
      AppMethodBeat.o(91452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label752;
      }
    }
    label752:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qeQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.qeQ);
      }
      i = paramInt;
      if (this.ePv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ePv);
      }
      paramInt = i;
      if (this.ePu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ePu);
      }
      i = paramInt;
      if (this.GfR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GfR);
      }
      paramInt = i;
      if (this.GfS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GfS);
      }
      i = f.a.a.b.b.a.p(7, this.GfT);
      int j = f.a.a.b.b.a.alT(8);
      int k = f.a.a.b.b.a.alT(9);
      AppMethodBeat.o(91452);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ain localain = (ain)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91452);
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
            localain.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91452);
          return 0;
        case 2: 
          localain.qeQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 3: 
          localain.ePv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 4: 
          localain.ePu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 5: 
          localain.GfR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 6: 
          localain.GfS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 7: 
          localain.GfT = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91452);
          return 0;
        case 8: 
          localain.GfU = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(91452);
          return 0;
        }
        localain.GfV = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
        AppMethodBeat.o(91452);
        return 0;
      }
      AppMethodBeat.o(91452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ain
 * JD-Core Version:    0.7.0.1
 */