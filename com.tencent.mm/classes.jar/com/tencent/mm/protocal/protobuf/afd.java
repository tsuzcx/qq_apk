package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afd
  extends cvc
{
  public int Fws;
  public String Gdm;
  public int Gdn;
  public int Gdo;
  public String iht;
  public String ihw;
  public String nDo;
  public int nEf;
  public long xbt;
  public int xcK;
  public int xcL;
  public int xcM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      paramVarArgs.aS(3, this.Fws);
      if (this.ihw != null) {
        paramVarArgs.d(4, this.ihw);
      }
      if (this.nDo != null) {
        paramVarArgs.d(5, this.nDo);
      }
      paramVarArgs.aS(6, this.xcK);
      paramVarArgs.aS(7, this.xcL);
      paramVarArgs.aS(8, this.xcM);
      if (this.Gdm != null) {
        paramVarArgs.d(9, this.Gdm);
      }
      paramVarArgs.aS(10, this.Gdn);
      paramVarArgs.aS(11, this.nEf);
      paramVarArgs.aS(12, this.Gdo);
      paramVarArgs.aY(13, this.xbt);
      AppMethodBeat.o(9590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.iht);
      }
      i += f.a.a.b.b.a.bz(3, this.Fws);
      paramInt = i;
      if (this.ihw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ihw);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nDo);
      }
      i = i + f.a.a.b.b.a.bz(6, this.xcK) + f.a.a.b.b.a.bz(7, this.xcL) + f.a.a.b.b.a.bz(8, this.xcM);
      paramInt = i;
      if (this.Gdm != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gdm);
      }
      i = f.a.a.b.b.a.bz(10, this.Gdn);
      int j = f.a.a.b.b.a.bz(11, this.nEf);
      int k = f.a.a.b.b.a.bz(12, this.Gdo);
      int m = f.a.a.b.b.a.p(13, this.xbt);
      AppMethodBeat.o(9590);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(9590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afd localafd = (afd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9590);
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
            localafd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9590);
          return 0;
        case 2: 
          localafd.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 3: 
          localafd.Fws = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 4: 
          localafd.ihw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 5: 
          localafd.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 6: 
          localafd.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 7: 
          localafd.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 8: 
          localafd.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 9: 
          localafd.Gdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 10: 
          localafd.Gdn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 11: 
          localafd.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9590);
          return 0;
        case 12: 
          localafd.Gdo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9590);
          return 0;
        }
        localafd.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(9590);
        return 0;
      }
      AppMethodBeat.o(9590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afd
 * JD-Core Version:    0.7.0.1
 */