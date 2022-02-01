package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsn
  extends ckq
{
  public String EEw;
  public String EGX;
  public int EGY;
  public int EGZ;
  public String EHa;
  public int EHb;
  public String EHc;
  public String EHd;
  public String dlB;
  public String dmE;
  public String neR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dmE != null) {
        paramVarArgs.d(2, this.dmE);
      }
      if (this.EGX != null) {
        paramVarArgs.d(3, this.EGX);
      }
      paramVarArgs.aR(4, this.EGY);
      paramVarArgs.aR(5, this.EGZ);
      if (this.EEw != null) {
        paramVarArgs.d(6, this.EEw);
      }
      if (this.neR != null) {
        paramVarArgs.d(7, this.neR);
      }
      if (this.dlB != null) {
        paramVarArgs.d(8, this.dlB);
      }
      if (this.EHa != null) {
        paramVarArgs.d(9, this.EHa);
      }
      paramVarArgs.aR(10, this.EHb);
      if (this.EHc != null) {
        paramVarArgs.d(11, this.EHc);
      }
      if (this.EHd != null) {
        paramVarArgs.d(12, this.EHd);
      }
      AppMethodBeat.o(82489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label934;
      }
    }
    label934:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dmE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dmE);
      }
      i = paramInt;
      if (this.EGX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EGX);
      }
      i = i + f.a.a.b.b.a.bA(4, this.EGY) + f.a.a.b.b.a.bA(5, this.EGZ);
      paramInt = i;
      if (this.EEw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EEw);
      }
      i = paramInt;
      if (this.neR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.neR);
      }
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dlB);
      }
      i = paramInt;
      if (this.EHa != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EHa);
      }
      i += f.a.a.b.b.a.bA(10, this.EHb);
      paramInt = i;
      if (this.EHc != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EHc);
      }
      i = paramInt;
      if (this.EHd != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EHd);
      }
      AppMethodBeat.o(82489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsn localdsn = (dsn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82489);
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
            localdsn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82489);
          return 0;
        case 2: 
          localdsn.dmE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 3: 
          localdsn.EGX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 4: 
          localdsn.EGY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82489);
          return 0;
        case 5: 
          localdsn.EGZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82489);
          return 0;
        case 6: 
          localdsn.EEw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 7: 
          localdsn.neR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 8: 
          localdsn.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 9: 
          localdsn.EHa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 10: 
          localdsn.EHb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82489);
          return 0;
        case 11: 
          localdsn.EHc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82489);
          return 0;
        }
        localdsn.EHd = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(82489);
        return 0;
      }
      AppMethodBeat.o(82489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsn
 * JD-Core Version:    0.7.0.1
 */