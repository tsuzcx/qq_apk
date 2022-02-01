package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ti
  extends cld
{
  public String CUY;
  public boolean CUZ;
  public int dcG;
  public String nTK;
  public int vBt;
  public String vII;
  public String vIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72449);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72449);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      if (this.CUY != null) {
        paramVarArgs.d(4, this.CUY);
      }
      if (this.vII != null) {
        paramVarArgs.d(5, this.vII);
      }
      paramVarArgs.bg(6, this.CUZ);
      if (this.vIJ != null) {
        paramVarArgs.d(7, this.vIJ);
      }
      paramVarArgs.aR(8, this.vBt);
      AppMethodBeat.o(72449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt;
      if (this.CUY != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CUY);
      }
      paramInt = i;
      if (this.vII != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vII);
      }
      i = paramInt + (f.a.a.b.b.a.fY(6) + 1);
      paramInt = i;
      if (this.vIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vIJ);
      }
      i = f.a.a.b.b.a.bA(8, this.vBt);
      AppMethodBeat.o(72449);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ti localti = (ti)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72449);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localti.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72449);
          return 0;
        case 2: 
          localti.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72449);
          return 0;
        case 3: 
          localti.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 4: 
          localti.CUY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 5: 
          localti.vII = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 6: 
          localti.CUZ = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72449);
          return 0;
        case 7: 
          localti.vIJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72449);
          return 0;
        }
        localti.vBt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72449);
        return 0;
      }
      AppMethodBeat.o(72449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ti
 * JD-Core Version:    0.7.0.1
 */