package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class le
  extends cvw
{
  public String DrK;
  public String FVJ;
  public String FVK;
  public String FVL;
  public int dDd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72422);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FVJ != null) {
        paramVarArgs.d(2, this.FVJ);
      }
      if (this.FVK != null) {
        paramVarArgs.d(3, this.FVK);
      }
      if (this.DrK != null) {
        paramVarArgs.d(4, this.DrK);
      }
      if (this.FVL != null) {
        paramVarArgs.d(5, this.FVL);
      }
      paramVarArgs.aS(7, this.dDd);
      AppMethodBeat.o(72422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FVJ);
      }
      i = paramInt;
      if (this.FVK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVK);
      }
      paramInt = i;
      if (this.DrK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DrK);
      }
      i = paramInt;
      if (this.FVL != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FVL);
      }
      paramInt = f.a.a.b.b.a.bz(7, this.dDd);
      AppMethodBeat.o(72422);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        le localle = (le)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(72422);
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
            localle.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72422);
          return 0;
        case 2: 
          localle.FVJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 3: 
          localle.FVK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 4: 
          localle.DrK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 5: 
          localle.FVL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72422);
          return 0;
        }
        localle.dDd = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72422);
        return 0;
      }
      AppMethodBeat.o(72422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.le
 * JD-Core Version:    0.7.0.1
 */