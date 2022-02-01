package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bru
  extends ckq
{
  public String CxN;
  public long dEb;
  public String dca;
  public int foG;
  public String uoo;
  public int zEA;
  public String zEv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.zEA);
      if (this.dca != null) {
        paramVarArgs.d(3, this.dca);
      }
      if (this.uoo != null) {
        paramVarArgs.d(4, this.uoo);
      }
      if (this.zEv != null) {
        paramVarArgs.d(5, this.zEv);
      }
      paramVarArgs.aG(6, this.dEb);
      paramVarArgs.aR(7, this.foG);
      if (this.CxN != null) {
        paramVarArgs.d(8, this.CxN);
      }
      AppMethodBeat.o(91545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.zEA);
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
      i = paramInt + f.a.a.b.b.a.q(6, this.dEb) + f.a.a.b.b.a.bA(7, this.foG);
      paramInt = i;
      if (this.CxN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CxN);
      }
      AppMethodBeat.o(91545);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bru localbru = (bru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91545);
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
            localbru.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91545);
          return 0;
        case 2: 
          localbru.zEA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91545);
          return 0;
        case 3: 
          localbru.dca = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 4: 
          localbru.uoo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 5: 
          localbru.zEv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 6: 
          localbru.dEb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91545);
          return 0;
        case 7: 
          localbru.foG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91545);
          return 0;
        }
        localbru.CxN = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91545);
        return 0;
      }
      AppMethodBeat.o(91545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bru
 * JD-Core Version:    0.7.0.1
 */