package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lm
  extends cvc
{
  public int FAt;
  public String FDA;
  public String FDB;
  public String FDC;
  public String FDD;
  public String FDE;
  public String FDF;
  public String FDG;
  public int FDz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FAt);
      paramVarArgs.aS(3, this.FDz);
      if (this.FDA != null) {
        paramVarArgs.d(4, this.FDA);
      }
      if (this.FDB != null) {
        paramVarArgs.d(5, this.FDB);
      }
      if (this.FDC != null) {
        paramVarArgs.d(6, this.FDC);
      }
      if (this.FDD != null) {
        paramVarArgs.d(7, this.FDD);
      }
      if (this.FDE != null) {
        paramVarArgs.d(8, this.FDE);
      }
      if (this.FDF != null) {
        paramVarArgs.d(9, this.FDF);
      }
      if (this.FDG != null) {
        paramVarArgs.d(10, this.FDG);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FAt) + f.a.a.b.b.a.bz(3, this.FDz);
      paramInt = i;
      if (this.FDA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FDA);
      }
      i = paramInt;
      if (this.FDB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FDB);
      }
      paramInt = i;
      if (this.FDC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FDC);
      }
      i = paramInt;
      if (this.FDD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FDD);
      }
      paramInt = i;
      if (this.FDE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FDE);
      }
      i = paramInt;
      if (this.FDF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FDF);
      }
      paramInt = i;
      if (this.FDG != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FDG);
      }
      AppMethodBeat.o(155394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155394);
          return 0;
        case 2: 
          locallm.FAt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155394);
          return 0;
        case 3: 
          locallm.FDz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155394);
          return 0;
        case 4: 
          locallm.FDA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 5: 
          locallm.FDB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 6: 
          locallm.FDC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 7: 
          locallm.FDD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 8: 
          locallm.FDE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 9: 
          locallm.FDF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155394);
          return 0;
        }
        locallm.FDG = ((f.a.a.a.a)localObject1).NPN.readString();
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