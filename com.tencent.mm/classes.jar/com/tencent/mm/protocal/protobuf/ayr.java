package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayr
  extends cvc
{
  public String GvX;
  public String GvY;
  public double latitude;
  public double longitude;
  public String oBD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114020);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.e(3, this.longitude);
      if (this.oBD != null) {
        paramVarArgs.d(4, this.oBD);
      }
      if (this.GvX != null) {
        paramVarArgs.d(5, this.GvX);
      }
      if (this.GvY != null) {
        paramVarArgs.d(6, this.GvY);
      }
      AppMethodBeat.o(114020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alT(2) + f.a.a.b.b.a.alT(3);
      paramInt = i;
      if (this.oBD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oBD);
      }
      i = paramInt;
      if (this.GvX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GvX);
      }
      paramInt = i;
      if (this.GvY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GvY);
      }
      AppMethodBeat.o(114020);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114020);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayr localayr = (ayr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114020);
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
            localayr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114020);
          return 0;
        case 2: 
          localayr.latitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(114020);
          return 0;
        case 3: 
          localayr.longitude = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(114020);
          return 0;
        case 4: 
          localayr.oBD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114020);
          return 0;
        case 5: 
          localayr.GvX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114020);
          return 0;
        }
        localayr.GvY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(114020);
        return 0;
      }
      AppMethodBeat.o(114020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayr
 * JD-Core Version:    0.7.0.1
 */