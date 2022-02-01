package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwx
  extends cvc
{
  public int FRn;
  public long GQR;
  public long GQS;
  public long GQT;
  public int offset;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169915);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.GQR);
      paramVarArgs.aY(3, this.GQS);
      if (this.query != null) {
        paramVarArgs.d(4, this.query);
      }
      paramVarArgs.aS(5, this.offset);
      paramVarArgs.aS(6, this.FRn);
      paramVarArgs.aY(7, this.GQT);
      AppMethodBeat.o(169915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GQR) + f.a.a.b.b.a.p(3, this.GQS);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.query);
      }
      i = f.a.a.b.b.a.bz(5, this.offset);
      int j = f.a.a.b.b.a.bz(6, this.FRn);
      int k = f.a.a.b.b.a.p(7, this.GQT);
      AppMethodBeat.o(169915);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwx localbwx = (bwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169915);
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
            localbwx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169915);
          return 0;
        case 2: 
          localbwx.GQR = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169915);
          return 0;
        case 3: 
          localbwx.GQS = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169915);
          return 0;
        case 4: 
          localbwx.query = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169915);
          return 0;
        case 5: 
          localbwx.offset = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169915);
          return 0;
        case 6: 
          localbwx.FRn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169915);
          return 0;
        }
        localbwx.GQT = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(169915);
        return 0;
      }
      AppMethodBeat.o(169915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwx
 * JD-Core Version:    0.7.0.1
 */