package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhh
  extends cvc
{
  public String HtU;
  public long HtV;
  public int HvL;
  public long Hvg;
  public int Hvh;
  public int Hvm;
  public String Username;
  public int tRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125835);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HtU != null) {
        paramVarArgs.d(2, this.HtU);
      }
      if (this.Username != null) {
        paramVarArgs.d(3, this.Username);
      }
      paramVarArgs.aY(4, this.HtV);
      paramVarArgs.aS(5, this.tRT);
      paramVarArgs.aY(6, this.Hvg);
      paramVarArgs.aS(7, this.Hvh);
      paramVarArgs.aS(8, this.HvL);
      paramVarArgs.aS(9, this.Hvm);
      AppMethodBeat.o(125835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HtU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HtU);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Username);
      }
      paramInt = f.a.a.b.b.a.p(4, this.HtV);
      int j = f.a.a.b.b.a.bz(5, this.tRT);
      int k = f.a.a.b.b.a.p(6, this.Hvg);
      int m = f.a.a.b.b.a.bz(7, this.Hvh);
      int n = f.a.a.b.b.a.bz(8, this.HvL);
      int i1 = f.a.a.b.b.a.bz(9, this.Hvm);
      AppMethodBeat.o(125835);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhh localdhh = (dhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125835);
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
            localdhh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125835);
          return 0;
        case 2: 
          localdhh.HtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 3: 
          localdhh.Username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125835);
          return 0;
        case 4: 
          localdhh.HtV = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125835);
          return 0;
        case 5: 
          localdhh.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125835);
          return 0;
        case 6: 
          localdhh.Hvg = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125835);
          return 0;
        case 7: 
          localdhh.Hvh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125835);
          return 0;
        case 8: 
          localdhh.HvL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125835);
          return 0;
        }
        localdhh.Hvm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125835);
        return 0;
      }
      AppMethodBeat.o(125835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhh
 * JD-Core Version:    0.7.0.1
 */