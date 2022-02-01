package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxc
  extends cvc
{
  public int FYc;
  public String HJO;
  public com.tencent.mm.bx.b HJP;
  public com.tencent.mm.bx.b HJQ;
  public String HJR;
  public long HfW;
  public int HfX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125498);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HJO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ToBizUserName");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.HJQ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HfX);
      if (this.HJO != null) {
        paramVarArgs.d(3, this.HJO);
      }
      paramVarArgs.aS(4, this.FYc);
      if (this.HJP != null) {
        paramVarArgs.c(5, this.HJP);
      }
      if (this.HJQ != null) {
        paramVarArgs.c(6, this.HJQ);
      }
      paramVarArgs.aY(7, this.HfW);
      if (this.HJR != null) {
        paramVarArgs.d(8, this.HJR);
      }
      AppMethodBeat.o(125498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HfX);
      paramInt = i;
      if (this.HJO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HJO);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.FYc);
      paramInt = i;
      if (this.HJP != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.HJP);
      }
      i = paramInt;
      if (this.HJQ != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.HJQ);
      }
      i += f.a.a.b.b.a.p(7, this.HfW);
      paramInt = i;
      if (this.HJR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HJR);
      }
      AppMethodBeat.o(125498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HJO == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ToBizUserName");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        if (this.HJQ == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxc localdxc = (dxc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125498);
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
            localdxc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125498);
          return 0;
        case 2: 
          localdxc.HfX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125498);
          return 0;
        case 3: 
          localdxc.HJO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125498);
          return 0;
        case 4: 
          localdxc.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125498);
          return 0;
        case 5: 
          localdxc.HJP = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(125498);
          return 0;
        case 6: 
          localdxc.HJQ = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(125498);
          return 0;
        case 7: 
          localdxc.HfW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125498);
          return 0;
        }
        localdxc.HJR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125498);
        return 0;
      }
      AppMethodBeat.o(125498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxc
 * JD-Core Version:    0.7.0.1
 */