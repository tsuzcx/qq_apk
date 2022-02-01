package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eee
  extends cvc
{
  public String HMG;
  public String HPp;
  public int HPq;
  public int HPr;
  public String HPs;
  public int HPt;
  public String HPu;
  public String HPv;
  public String duW;
  public String dvZ;
  public String okh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dvZ != null) {
        paramVarArgs.d(2, this.dvZ);
      }
      if (this.HPp != null) {
        paramVarArgs.d(3, this.HPp);
      }
      paramVarArgs.aS(4, this.HPq);
      paramVarArgs.aS(5, this.HPr);
      if (this.HMG != null) {
        paramVarArgs.d(6, this.HMG);
      }
      if (this.okh != null) {
        paramVarArgs.d(7, this.okh);
      }
      if (this.duW != null) {
        paramVarArgs.d(8, this.duW);
      }
      if (this.HPs != null) {
        paramVarArgs.d(9, this.HPs);
      }
      paramVarArgs.aS(10, this.HPt);
      if (this.HPu != null) {
        paramVarArgs.d(11, this.HPu);
      }
      if (this.HPv != null) {
        paramVarArgs.d(12, this.HPv);
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
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dvZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dvZ);
      }
      i = paramInt;
      if (this.HPp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HPp);
      }
      i = i + f.a.a.b.b.a.bz(4, this.HPq) + f.a.a.b.b.a.bz(5, this.HPr);
      paramInt = i;
      if (this.HMG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HMG);
      }
      i = paramInt;
      if (this.okh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.okh);
      }
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.duW);
      }
      i = paramInt;
      if (this.HPs != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HPs);
      }
      i += f.a.a.b.b.a.bz(10, this.HPt);
      paramInt = i;
      if (this.HPu != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HPu);
      }
      i = paramInt;
      if (this.HPv != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HPv);
      }
      AppMethodBeat.o(82489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eee localeee = (eee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82489);
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
            localeee.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82489);
          return 0;
        case 2: 
          localeee.dvZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 3: 
          localeee.HPp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 4: 
          localeee.HPq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82489);
          return 0;
        case 5: 
          localeee.HPr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82489);
          return 0;
        case 6: 
          localeee.HMG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 7: 
          localeee.okh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 8: 
          localeee.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 9: 
          localeee.HPs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 10: 
          localeee.HPt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82489);
          return 0;
        case 11: 
          localeee.HPu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82489);
          return 0;
        }
        localeee.HPv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82489);
        return 0;
      }
      AppMethodBeat.o(82489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eee
 * JD-Core Version:    0.7.0.1
 */