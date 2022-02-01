package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cxu
  extends cvc
{
  public String Hpc;
  public String Hpd;
  public b Hpe;
  public String Hpj;
  public String Hpk;
  public String duW;
  public String scope;
  public String state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      if (this.scope != null) {
        paramVarArgs.d(3, this.scope);
      }
      if (this.state != null) {
        paramVarArgs.d(4, this.state);
      }
      if (this.Hpc != null) {
        paramVarArgs.d(5, this.Hpc);
      }
      if (this.Hpj != null) {
        paramVarArgs.d(6, this.Hpj);
      }
      if (this.Hpk != null) {
        paramVarArgs.d(7, this.Hpk);
      }
      if (this.Hpd != null) {
        paramVarArgs.d(13, this.Hpd);
      }
      if (this.Hpe != null) {
        paramVarArgs.c(14, this.Hpe);
      }
      AppMethodBeat.o(82473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.scope != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.scope);
      }
      paramInt = i;
      if (this.state != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.state);
      }
      i = paramInt;
      if (this.Hpc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hpc);
      }
      paramInt = i;
      if (this.Hpj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hpj);
      }
      i = paramInt;
      if (this.Hpk != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hpk);
      }
      paramInt = i;
      if (this.Hpd != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Hpd);
      }
      i = paramInt;
      if (this.Hpe != null) {
        i = paramInt + f.a.a.b.b.a.b(14, this.Hpe);
      }
      AppMethodBeat.o(82473);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxu localcxu = (cxu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(82473);
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
            localcxu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82473);
          return 0;
        case 2: 
          localcxu.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 3: 
          localcxu.scope = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 4: 
          localcxu.state = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 5: 
          localcxu.Hpc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 6: 
          localcxu.Hpj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 7: 
          localcxu.Hpk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82473);
          return 0;
        case 13: 
          localcxu.Hpd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82473);
          return 0;
        }
        localcxu.Hpe = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(82473);
        return 0;
      }
      AppMethodBeat.o(82473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxu
 * JD-Core Version:    0.7.0.1
 */