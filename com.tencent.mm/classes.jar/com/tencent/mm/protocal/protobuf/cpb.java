package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cpb
  extends erp
{
  public int IJG;
  public int YIq;
  public double YTc;
  public double YTd;
  public String aakp;
  public gol aatT;
  public int aatV;
  public double aavR;
  public double aavS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56249);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aatT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56249);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IJG);
      paramVarArgs.bS(3, this.YIq);
      if (this.aakp != null) {
        paramVarArgs.g(4, this.aakp);
      }
      if (this.aatT != null)
      {
        paramVarArgs.qD(5, this.aatT.computeSize());
        this.aatT.writeFields(paramVarArgs);
      }
      paramVarArgs.d(6, this.YTc);
      paramVarArgs.d(7, this.YTd);
      paramVarArgs.d(8, this.aavR);
      paramVarArgs.d(9, this.aavS);
      paramVarArgs.bS(10, this.aatV);
      AppMethodBeat.o(56249);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IJG) + i.a.a.b.b.a.cJ(3, this.YIq);
      paramInt = i;
      if (this.aakp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aakp);
      }
      i = paramInt;
      if (this.aatT != null) {
        i = paramInt + i.a.a.a.qC(5, this.aatT.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(6);
      int j = i.a.a.b.b.a.ko(7);
      int k = i.a.a.b.b.a.ko(8);
      int m = i.a.a.b.b.a.ko(9);
      int n = i.a.a.b.b.a.cJ(10, this.aatV);
      AppMethodBeat.o(56249);
      return i + (paramInt + 8) + (j + 8) + (k + 8) + (m + 8) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aatT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56249);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56249);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cpb localcpb = (cpb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56249);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcpb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 2: 
          localcpb.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56249);
          return 0;
        case 3: 
          localcpb.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(56249);
          return 0;
        case 4: 
          localcpb.aakp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(56249);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localcpb.aatT = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56249);
          return 0;
        case 6: 
          localcpb.YTc = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(56249);
          return 0;
        case 7: 
          localcpb.YTd = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(56249);
          return 0;
        case 8: 
          localcpb.aavR = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(56249);
          return 0;
        case 9: 
          localcpb.aavS = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(56249);
          return 0;
        }
        localcpb.aatV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(56249);
        return 0;
      }
      AppMethodBeat.o(56249);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpb
 * JD-Core Version:    0.7.0.1
 */