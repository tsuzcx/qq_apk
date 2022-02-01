package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awp
  extends cvc
{
  public String FqI;
  public int FqJ;
  public dw Gvf;
  public String appId;
  public String cUM;
  public String sign;
  public String tnS;
  public String tnT;
  public String tnU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      if (this.tnS != null) {
        paramVarArgs.d(3, this.tnS);
      }
      if (this.tnT != null) {
        paramVarArgs.d(4, this.tnT);
      }
      if (this.tnU != null) {
        paramVarArgs.d(5, this.tnU);
      }
      if (this.cUM != null) {
        paramVarArgs.d(6, this.cUM);
      }
      if (this.sign != null) {
        paramVarArgs.d(7, this.sign);
      }
      if (this.Gvf != null)
      {
        paramVarArgs.lC(8, this.Gvf.computeSize());
        this.Gvf.writeFields(paramVarArgs);
      }
      if (this.FqI != null) {
        paramVarArgs.d(9, this.FqI);
      }
      paramVarArgs.aS(10, this.FqJ);
      AppMethodBeat.o(32219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.appId);
      }
      i = paramInt;
      if (this.tnS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tnS);
      }
      paramInt = i;
      if (this.tnT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tnT);
      }
      i = paramInt;
      if (this.tnU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tnU);
      }
      paramInt = i;
      if (this.cUM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.cUM);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.sign);
      }
      paramInt = i;
      if (this.Gvf != null) {
        paramInt = i + f.a.a.a.lB(8, this.Gvf.computeSize());
      }
      i = paramInt;
      if (this.FqI != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FqI);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.FqJ);
      AppMethodBeat.o(32219);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32219);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awp localawp = (awp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32219);
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
            localawp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 2: 
          localawp.appId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 3: 
          localawp.tnS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 4: 
          localawp.tnT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 5: 
          localawp.tnU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 6: 
          localawp.cUM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 7: 
          localawp.sign = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32219);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawp.Gvf = ((dw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32219);
          return 0;
        case 9: 
          localawp.FqI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32219);
          return 0;
        }
        localawp.FqJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32219);
        return 0;
      }
      AppMethodBeat.o(32219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awp
 * JD-Core Version:    0.7.0.1
 */