package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abu
  extends cvc
{
  public String FWt;
  public String FWx;
  public String Gbt;
  public long Gbu;
  public int mrl;
  public String vjr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gbt != null) {
        paramVarArgs.d(2, this.Gbt);
      }
      paramVarArgs.aY(3, this.Gbu);
      if (this.FWt != null) {
        paramVarArgs.d(4, this.FWt);
      }
      if (this.FWx != null) {
        paramVarArgs.d(5, this.FWx);
      }
      paramVarArgs.aS(6, this.mrl);
      if (this.vjr != null) {
        paramVarArgs.d(7, this.vjr);
      }
      AppMethodBeat.o(72466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gbt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gbt);
      }
      i += f.a.a.b.b.a.p(3, this.Gbu);
      paramInt = i;
      if (this.FWt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FWt);
      }
      i = paramInt;
      if (this.FWx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FWx);
      }
      i += f.a.a.b.b.a.bz(6, this.mrl);
      paramInt = i;
      if (this.vjr != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vjr);
      }
      AppMethodBeat.o(72466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abu localabu = (abu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72466);
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
            localabu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72466);
          return 0;
        case 2: 
          localabu.Gbt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 3: 
          localabu.Gbu = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(72466);
          return 0;
        case 4: 
          localabu.FWt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 5: 
          localabu.FWx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72466);
          return 0;
        case 6: 
          localabu.mrl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72466);
          return 0;
        }
        localabu.vjr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72466);
        return 0;
      }
      AppMethodBeat.o(72466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abu
 * JD-Core Version:    0.7.0.1
 */