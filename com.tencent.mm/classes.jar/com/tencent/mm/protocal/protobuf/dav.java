package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dav
  extends cwj
{
  public long FSD;
  public String HJX;
  public int HJY;
  public String Hoy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HJX != null) {
        paramVarArgs.d(3, this.HJX);
      }
      if (this.Hoy != null) {
        paramVarArgs.d(4, this.Hoy);
      }
      paramVarArgs.aZ(5, this.FSD);
      paramVarArgs.aS(6, this.HJY);
      AppMethodBeat.o(220393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HJX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HJX);
      }
      i = paramInt;
      if (this.Hoy != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hoy);
      }
      paramInt = f.a.a.b.b.a.p(5, this.FSD);
      int j = f.a.a.b.b.a.bz(6, this.HJY);
      AppMethodBeat.o(220393);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(220393);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dav localdav = (dav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(220393);
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
            localdav.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220393);
          return 0;
        case 3: 
          localdav.HJX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(220393);
          return 0;
        case 4: 
          localdav.Hoy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(220393);
          return 0;
        case 5: 
          localdav.FSD = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(220393);
          return 0;
        }
        localdav.HJY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(220393);
        return 0;
      }
      AppMethodBeat.o(220393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dav
 * JD-Core Version:    0.7.0.1
 */