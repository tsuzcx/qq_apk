package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class baz
  extends cvp
{
  public int FuX;
  public String Gya;
  public int Gyb;
  public int Gyc;
  public LinkedList<Integer> Gyd;
  public LinkedList<ahl> Gye;
  public int Gyf;
  
  public baz()
  {
    AppMethodBeat.i(210596);
    this.Gyd = new LinkedList();
    this.Gye = new LinkedList();
    AppMethodBeat.o(210596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(210597);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gyb);
      paramVarArgs.aS(3, this.Gyc);
      paramVarArgs.aS(4, this.FuX);
      paramVarArgs.e(5, 2, this.Gyd);
      paramVarArgs.e(6, 8, this.Gye);
      paramVarArgs.aS(7, this.Gyf);
      if (this.Gya != null) {
        paramVarArgs.d(8, this.Gya);
      }
      AppMethodBeat.o(210597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label793;
      }
    }
    label793:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gyb) + f.a.a.b.b.a.bz(3, this.Gyc) + f.a.a.b.b.a.bz(4, this.FuX) + f.a.a.a.c(5, 2, this.Gyd) + f.a.a.a.c(6, 8, this.Gye) + f.a.a.b.b.a.bz(7, this.Gyf);
      paramInt = i;
      if (this.Gya != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gya);
      }
      AppMethodBeat.o(210597);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gyd.clear();
        this.Gye.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(210597);
          throw paramVarArgs;
        }
        AppMethodBeat.o(210597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        baz localbaz = (baz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210597);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210597);
          return 0;
        case 2: 
          localbaz.Gyb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210597);
          return 0;
        case 3: 
          localbaz.Gyc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210597);
          return 0;
        case 4: 
          localbaz.FuX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210597);
          return 0;
        case 5: 
          localbaz.Gyd.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(210597);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbaz.Gye.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210597);
          return 0;
        case 7: 
          localbaz.Gyf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210597);
          return 0;
        }
        localbaz.Gya = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(210597);
        return 0;
      }
      AppMethodBeat.o(210597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baz
 * JD-Core Version:    0.7.0.1
 */