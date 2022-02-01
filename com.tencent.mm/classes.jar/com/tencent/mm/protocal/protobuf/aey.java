package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aey
  extends ckq
{
  public String DeZ;
  public String Dfa;
  public long Dfb;
  public double Dfc;
  public double Dfd;
  public String evA;
  public String evz;
  public String oYa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oYa != null) {
        paramVarArgs.d(2, this.oYa);
      }
      if (this.evA != null) {
        paramVarArgs.d(3, this.evA);
      }
      if (this.evz != null) {
        paramVarArgs.d(4, this.evz);
      }
      if (this.DeZ != null) {
        paramVarArgs.d(5, this.DeZ);
      }
      if (this.Dfa != null) {
        paramVarArgs.d(6, this.Dfa);
      }
      paramVarArgs.aG(7, this.Dfb);
      paramVarArgs.e(8, this.Dfc);
      paramVarArgs.e(9, this.Dfd);
      AppMethodBeat.o(91452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label760;
      }
    }
    label760:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oYa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oYa);
      }
      i = paramInt;
      if (this.evA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.evA);
      }
      paramInt = i;
      if (this.evz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.evz);
      }
      i = paramInt;
      if (this.DeZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DeZ);
      }
      paramInt = i;
      if (this.Dfa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dfa);
      }
      i = f.a.a.b.b.a.q(7, this.Dfb);
      int j = f.a.a.b.b.a.fY(8);
      int k = f.a.a.b.b.a.fY(9);
      AppMethodBeat.o(91452);
      return paramInt + i + (j + 8) + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aey localaey = (aey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91452);
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
            localaey.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91452);
          return 0;
        case 2: 
          localaey.oYa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 3: 
          localaey.evA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 4: 
          localaey.evz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 5: 
          localaey.DeZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 6: 
          localaey.Dfa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 7: 
          localaey.Dfb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91452);
          return 0;
        case 8: 
          localaey.Dfc = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
          AppMethodBeat.o(91452);
          return 0;
        }
        localaey.Dfd = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(91452);
        return 0;
      }
      AppMethodBeat.o(91452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aey
 * JD-Core Version:    0.7.0.1
 */