package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dab
  extends cvp
{
  public long FAf;
  public String GUX;
  public String Hqv;
  public int Hqw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Hqv != null) {
        paramVarArgs.d(3, this.Hqv);
      }
      if (this.GUX != null) {
        paramVarArgs.d(4, this.GUX);
      }
      paramVarArgs.aY(5, this.FAf);
      paramVarArgs.aS(6, this.Hqw);
      AppMethodBeat.o(215760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hqv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hqv);
      }
      i = paramInt;
      if (this.GUX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GUX);
      }
      paramInt = f.a.a.b.b.a.p(5, this.FAf);
      int j = f.a.a.b.b.a.bz(6, this.Hqw);
      AppMethodBeat.o(215760);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dab localdab = (dab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(215760);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdab.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215760);
          return 0;
        case 3: 
          localdab.Hqv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215760);
          return 0;
        case 4: 
          localdab.GUX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215760);
          return 0;
        case 5: 
          localdab.FAf = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(215760);
          return 0;
        }
        localdab.Hqw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(215760);
        return 0;
      }
      AppMethodBeat.o(215760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dab
 * JD-Core Version:    0.7.0.1
 */