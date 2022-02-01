package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lm
  extends cvw
{
  public int FSQ;
  public int FVU;
  public String FVV;
  public String FVW;
  public String FVX;
  public String FVY;
  public String FVZ;
  public String FWa;
  public String FWb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FSQ);
      paramVarArgs.aS(3, this.FVU);
      if (this.FVV != null) {
        paramVarArgs.d(4, this.FVV);
      }
      if (this.FVW != null) {
        paramVarArgs.d(5, this.FVW);
      }
      if (this.FVX != null) {
        paramVarArgs.d(6, this.FVX);
      }
      if (this.FVY != null) {
        paramVarArgs.d(7, this.FVY);
      }
      if (this.FVZ != null) {
        paramVarArgs.d(8, this.FVZ);
      }
      if (this.FWa != null) {
        paramVarArgs.d(9, this.FWa);
      }
      if (this.FWb != null) {
        paramVarArgs.d(10, this.FWb);
      }
      AppMethodBeat.o(155394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FSQ) + f.a.a.b.b.a.bz(3, this.FVU);
      paramInt = i;
      if (this.FVV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVV);
      }
      i = paramInt;
      if (this.FVW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FVW);
      }
      paramInt = i;
      if (this.FVX != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FVX);
      }
      i = paramInt;
      if (this.FVY != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FVY);
      }
      paramInt = i;
      if (this.FVZ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FVZ);
      }
      i = paramInt;
      if (this.FWa != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FWa);
      }
      paramInt = i;
      if (this.FWb != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FWb);
      }
      AppMethodBeat.o(155394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lm locallm = (lm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155394);
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
            locallm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155394);
          return 0;
        case 2: 
          locallm.FSQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155394);
          return 0;
        case 3: 
          locallm.FVU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155394);
          return 0;
        case 4: 
          locallm.FVV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 5: 
          locallm.FVW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 6: 
          locallm.FVX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 7: 
          locallm.FVY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 8: 
          locallm.FVZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 9: 
          locallm.FWa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155394);
          return 0;
        }
        locallm.FWb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(155394);
        return 0;
      }
      AppMethodBeat.o(155394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lm
 * JD-Core Version:    0.7.0.1
 */