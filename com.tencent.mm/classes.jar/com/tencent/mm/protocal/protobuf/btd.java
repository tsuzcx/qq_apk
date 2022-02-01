package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btd
  extends cvc
{
  public String GNv;
  public String GNw;
  public String GNx;
  public int dnh;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153288);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GNv != null) {
        paramVarArgs.d(2, this.GNv);
      }
      if (this.query != null) {
        paramVarArgs.d(3, this.query);
      }
      if (this.GNw != null) {
        paramVarArgs.d(4, this.GNw);
      }
      if (this.GNx != null) {
        paramVarArgs.d(5, this.GNx);
      }
      paramVarArgs.aS(6, this.dnh);
      AppMethodBeat.o(153288);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GNv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GNv);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.query);
      }
      paramInt = i;
      if (this.GNw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GNw);
      }
      i = paramInt;
      if (this.GNx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GNx);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.dnh);
      AppMethodBeat.o(153288);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153288);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btd localbtd = (btd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153288);
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
            localbtd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153288);
          return 0;
        case 2: 
          localbtd.GNv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 3: 
          localbtd.query = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 4: 
          localbtd.GNw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 5: 
          localbtd.GNx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153288);
          return 0;
        }
        localbtd.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153288);
        return 0;
      }
      AppMethodBeat.o(153288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btd
 * JD-Core Version:    0.7.0.1
 */