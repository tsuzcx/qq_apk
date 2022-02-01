package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvw
  extends cvc
{
  public int CreateTime;
  public String Fwt;
  public int HnV;
  public int HnW;
  public int HnX;
  public long HnY;
  public String uki;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fwt != null) {
        paramVarArgs.d(2, this.Fwt);
      }
      paramVarArgs.aS(3, this.HnV);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(5, this.HnW);
      if (this.ukj != null) {
        paramVarArgs.d(6, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(7, this.uki);
      }
      paramVarArgs.aS(8, this.HnX);
      paramVarArgs.aY(9, this.HnY);
      AppMethodBeat.o(32415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label733;
      }
    }
    label733:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fwt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fwt);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HnV) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(5, this.HnW);
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ukj);
      }
      i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uki);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.HnX);
      int j = f.a.a.b.b.a.p(9, this.HnY);
      AppMethodBeat.o(32415);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvw localcvw = (cvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32415);
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
            localcvw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32415);
          return 0;
        case 2: 
          localcvw.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 3: 
          localcvw.HnV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32415);
          return 0;
        case 4: 
          localcvw.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32415);
          return 0;
        case 5: 
          localcvw.HnW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32415);
          return 0;
        case 6: 
          localcvw.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 7: 
          localcvw.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 8: 
          localcvw.HnX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32415);
          return 0;
        }
        localcvw.HnY = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(32415);
        return 0;
      }
      AppMethodBeat.o(32415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvw
 * JD-Core Version:    0.7.0.1
 */