package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayl
  extends cvc
{
  public String Frp;
  public String Frq;
  public int Frr;
  public LinkedList<tf> Fru;
  public String GvU;
  public int dHZ;
  public String pkN;
  public String pkf;
  public String sign;
  
  public ayl()
  {
    AppMethodBeat.i(114012);
    this.Fru = new LinkedList();
    AppMethodBeat.o(114012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Fru);
      paramVarArgs.aS(3, this.dHZ);
      if (this.pkN != null) {
        paramVarArgs.d(4, this.pkN);
      }
      if (this.pkf != null) {
        paramVarArgs.d(5, this.pkf);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.Frp != null) {
        paramVarArgs.d(7, this.Frp);
      }
      if (this.Frq != null) {
        paramVarArgs.d(8, this.Frq);
      }
      if (this.GvU != null) {
        paramVarArgs.d(9, this.GvU);
      }
      paramVarArgs.aS(10, this.Frr);
      AppMethodBeat.o(114013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Fru) + f.a.a.b.b.a.bz(3, this.dHZ);
      paramInt = i;
      if (this.pkN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pkN);
      }
      i = paramInt;
      if (this.pkf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.pkf);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.Frp != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Frp);
      }
      paramInt = i;
      if (this.Frq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Frq);
      }
      i = paramInt;
      if (this.GvU != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GvU);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Frr);
      AppMethodBeat.o(114013);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fru.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayl localayl = (ayl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114013);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayl.Fru.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114013);
          return 0;
        case 3: 
          localayl.dHZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114013);
          return 0;
        case 4: 
          localayl.pkN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 5: 
          localayl.pkf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 6: 
          localayl.sign = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 7: 
          localayl.Frp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 8: 
          localayl.Frq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114013);
          return 0;
        case 9: 
          localayl.GvU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114013);
          return 0;
        }
        localayl.Frr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(114013);
        return 0;
      }
      AppMethodBeat.o(114013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayl
 * JD-Core Version:    0.7.0.1
 */