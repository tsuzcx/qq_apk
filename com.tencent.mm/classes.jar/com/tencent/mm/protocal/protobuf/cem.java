package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cem
  extends ckq
{
  public int CYU;
  public String DYc;
  public int DZB;
  public String Eau;
  public String vBv;
  public int zFN;
  public String zFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91641);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eau != null) {
        paramVarArgs.d(2, this.Eau);
      }
      if (this.vBv != null) {
        paramVarArgs.d(3, this.vBv);
      }
      paramVarArgs.aR(4, this.DZB);
      paramVarArgs.aR(5, this.CYU);
      if (this.DYc != null) {
        paramVarArgs.d(6, this.DYc);
      }
      paramVarArgs.aR(7, this.zFN);
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eau != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eau);
      }
      i = paramInt;
      if (this.vBv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vBv);
      }
      i = i + f.a.a.b.b.a.bA(4, this.DZB) + f.a.a.b.b.a.bA(5, this.CYU);
      paramInt = i;
      if (this.DYc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DYc);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.zFN);
      paramInt = i;
      if (this.zFY != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91641);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91641);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cem localcem = (cem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91641);
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
            localcem.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91641);
          return 0;
        case 2: 
          localcem.Eau = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 3: 
          localcem.vBv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 4: 
          localcem.DZB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91641);
          return 0;
        case 5: 
          localcem.CYU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91641);
          return 0;
        case 6: 
          localcem.DYc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 7: 
          localcem.zFN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91641);
          return 0;
        }
        localcem.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91641);
        return 0;
      }
      AppMethodBeat.o(91641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cem
 * JD-Core Version:    0.7.0.1
 */