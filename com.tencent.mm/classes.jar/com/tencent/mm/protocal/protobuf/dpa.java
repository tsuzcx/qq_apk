package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpa
  extends cvc
{
  public String HDi;
  public String HDj;
  public String HDk;
  public String HDl;
  public int reason;
  public String yaM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.reason);
      if (this.HDi != null) {
        paramVarArgs.d(3, this.HDi);
      }
      if (this.HDj != null) {
        paramVarArgs.d(4, this.HDj);
      }
      if (this.yaM != null) {
        paramVarArgs.d(5, this.yaM);
      }
      if (this.HDk != null) {
        paramVarArgs.d(6, this.HDk);
      }
      if (this.HDl != null) {
        paramVarArgs.d(7, this.HDl);
      }
      AppMethodBeat.o(72590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.reason);
      paramInt = i;
      if (this.HDi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HDi);
      }
      i = paramInt;
      if (this.HDj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HDj);
      }
      paramInt = i;
      if (this.yaM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.yaM);
      }
      i = paramInt;
      if (this.HDk != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HDk);
      }
      paramInt = i;
      if (this.HDl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HDl);
      }
      AppMethodBeat.o(72590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpa localdpa = (dpa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72590);
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
            localdpa.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72590);
          return 0;
        case 2: 
          localdpa.reason = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72590);
          return 0;
        case 3: 
          localdpa.HDi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 4: 
          localdpa.HDj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 5: 
          localdpa.yaM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 6: 
          localdpa.HDk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72590);
          return 0;
        }
        localdpa.HDl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72590);
        return 0;
      }
      AppMethodBeat.o(72590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpa
 * JD-Core Version:    0.7.0.1
 */