package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dau
  extends cvw
{
  public String FOR;
  public String HJV;
  public String HJW;
  public String HzT;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HzT != null) {
        paramVarArgs.d(2, this.HzT);
      }
      if (this.HJV != null) {
        paramVarArgs.d(3, this.HJV);
      }
      if (this.HJW != null) {
        paramVarArgs.d(4, this.HJW);
      }
      if (this.FOR != null) {
        paramVarArgs.d(5, this.FOR);
      }
      paramVarArgs.aS(6, this.Scene);
      AppMethodBeat.o(220392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HzT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HzT);
      }
      i = paramInt;
      if (this.HJV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HJV);
      }
      paramInt = i;
      if (this.HJW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HJW);
      }
      i = paramInt;
      if (this.FOR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FOR);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Scene);
      AppMethodBeat.o(220392);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(220392);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dau localdau = (dau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220392);
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
            localdau.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220392);
          return 0;
        case 2: 
          localdau.HzT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(220392);
          return 0;
        case 3: 
          localdau.HJV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(220392);
          return 0;
        case 4: 
          localdau.HJW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(220392);
          return 0;
        case 5: 
          localdau.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(220392);
          return 0;
        }
        localdau.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(220392);
        return 0;
      }
      AppMethodBeat.o(220392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dau
 * JD-Core Version:    0.7.0.1
 */