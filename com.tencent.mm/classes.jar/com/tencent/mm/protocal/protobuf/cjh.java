package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjh
  extends cvp
{
  public String Hdd;
  public int Hde;
  public long Hdf;
  public int dvY;
  public String dvZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209411);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dvY);
      if (this.dvZ != null) {
        paramVarArgs.d(3, this.dvZ);
      }
      if (this.Hdd != null) {
        paramVarArgs.d(4, this.Hdd);
      }
      paramVarArgs.aS(5, this.Hde);
      paramVarArgs.aY(100, this.Hdf);
      AppMethodBeat.o(209411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label586;
      }
    }
    label586:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dvY);
      paramInt = i;
      if (this.dvZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dvZ);
      }
      i = paramInt;
      if (this.Hdd != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hdd);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.Hde);
      int j = f.a.a.b.b.a.p(100, this.Hdf);
      AppMethodBeat.o(209411);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjh localcjh = (cjh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209411);
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
            localcjh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209411);
          return 0;
        case 2: 
          localcjh.dvY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209411);
          return 0;
        case 3: 
          localcjh.dvZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209411);
          return 0;
        case 4: 
          localcjh.Hdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209411);
          return 0;
        case 5: 
          localcjh.Hde = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209411);
          return 0;
        }
        localcjh.Hdf = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(209411);
        return 0;
      }
      AppMethodBeat.o(209411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjh
 * JD-Core Version:    0.7.0.1
 */