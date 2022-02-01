package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpx
  extends cvw
{
  public String HWV;
  public String HWW;
  public String HWX;
  public String HWY;
  public int reason;
  public String yqD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72590);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.reason);
      if (this.HWV != null) {
        paramVarArgs.d(3, this.HWV);
      }
      if (this.HWW != null) {
        paramVarArgs.d(4, this.HWW);
      }
      if (this.yqD != null) {
        paramVarArgs.d(5, this.yqD);
      }
      if (this.HWX != null) {
        paramVarArgs.d(6, this.HWX);
      }
      if (this.HWY != null) {
        paramVarArgs.d(7, this.HWY);
      }
      AppMethodBeat.o(72590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.reason);
      paramInt = i;
      if (this.HWV != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HWV);
      }
      i = paramInt;
      if (this.HWW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HWW);
      }
      paramInt = i;
      if (this.yqD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.yqD);
      }
      i = paramInt;
      if (this.HWX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HWX);
      }
      paramInt = i;
      if (this.HWY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HWY);
      }
      AppMethodBeat.o(72590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpx localdpx = (dpx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72590);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72590);
          return 0;
        case 2: 
          localdpx.reason = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72590);
          return 0;
        case 3: 
          localdpx.HWV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 4: 
          localdpx.HWW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 5: 
          localdpx.yqD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72590);
          return 0;
        case 6: 
          localdpx.HWX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72590);
          return 0;
        }
        localdpx.HWY = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72590);
        return 0;
      }
      AppMethodBeat.o(72590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpx
 * JD-Core Version:    0.7.0.1
 */