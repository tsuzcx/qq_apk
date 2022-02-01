package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dfn
  extends cwj
{
  public int HMJ;
  public int HMK;
  public int HML;
  public b HMM;
  public String HMx;
  public String HMy;
  public String HMz;
  public String HkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117928);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HMx != null) {
        paramVarArgs.d(2, this.HMx);
      }
      paramVarArgs.aS(3, this.HMJ);
      paramVarArgs.aS(4, this.HMK);
      if (this.HMy != null) {
        paramVarArgs.d(5, this.HMy);
      }
      if (this.HMz != null) {
        paramVarArgs.d(6, this.HMz);
      }
      paramVarArgs.aS(7, this.HML);
      if (this.HkY != null) {
        paramVarArgs.d(8, this.HkY);
      }
      if (this.HMM != null) {
        paramVarArgs.c(9, this.HMM);
      }
      AppMethodBeat.o(117928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HMx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HMx);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HMJ) + f.a.a.b.b.a.bz(4, this.HMK);
      paramInt = i;
      if (this.HMy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HMy);
      }
      i = paramInt;
      if (this.HMz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HMz);
      }
      i += f.a.a.b.b.a.bz(7, this.HML);
      paramInt = i;
      if (this.HkY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HkY);
      }
      i = paramInt;
      if (this.HMM != null) {
        i = paramInt + f.a.a.b.b.a.b(9, this.HMM);
      }
      AppMethodBeat.o(117928);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfn localdfn = (dfn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117928);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117928);
          return 0;
        case 2: 
          localdfn.HMx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 3: 
          localdfn.HMJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117928);
          return 0;
        case 4: 
          localdfn.HMK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117928);
          return 0;
        case 5: 
          localdfn.HMy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 6: 
          localdfn.HMz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 7: 
          localdfn.HML = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117928);
          return 0;
        case 8: 
          localdfn.HkY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117928);
          return 0;
        }
        localdfn.HMM = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(117928);
        return 0;
      }
      AppMethodBeat.o(117928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfn
 * JD-Core Version:    0.7.0.1
 */