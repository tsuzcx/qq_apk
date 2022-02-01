package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpj
  extends cvp
{
  public String CKD;
  public boolean CKR;
  public String dxD;
  public int ozR;
  public String ozS;
  public boolean ozk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72601);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.bt(4, this.ozk);
      paramVarArgs.bt(5, this.CKR);
      if (this.CKD != null) {
        paramVarArgs.d(6, this.CKD);
      }
      if (this.dxD != null) {
        paramVarArgs.d(7, this.dxD);
      }
      AppMethodBeat.o(72601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.alV(5);
      paramInt = i;
      if (this.CKD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CKD);
      }
      i = paramInt;
      if (this.dxD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dxD);
      }
      AppMethodBeat.o(72601);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpj localdpj = (dpj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72601);
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
            localdpj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72601);
          return 0;
        case 2: 
          localdpj.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72601);
          return 0;
        case 3: 
          localdpj.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72601);
          return 0;
        case 4: 
          localdpj.ozk = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72601);
          return 0;
        case 5: 
          localdpj.CKR = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72601);
          return 0;
        case 6: 
          localdpj.CKD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72601);
          return 0;
        }
        localdpj.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72601);
        return 0;
      }
      AppMethodBeat.o(72601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpj
 * JD-Core Version:    0.7.0.1
 */