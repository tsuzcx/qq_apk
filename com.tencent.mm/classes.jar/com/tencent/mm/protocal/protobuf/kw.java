package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class kw
  extends ckq
{
  public int CCB;
  public int CFD;
  public String CFE;
  public String CFF;
  public String CFG;
  public String CFH;
  public String CFI;
  public String CFJ;
  public String CFK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CCB);
      paramVarArgs.aR(3, this.CFD);
      if (this.CFE != null) {
        paramVarArgs.d(4, this.CFE);
      }
      if (this.CFF != null) {
        paramVarArgs.d(5, this.CFF);
      }
      if (this.CFG != null) {
        paramVarArgs.d(6, this.CFG);
      }
      if (this.CFH != null) {
        paramVarArgs.d(7, this.CFH);
      }
      if (this.CFI != null) {
        paramVarArgs.d(8, this.CFI);
      }
      if (this.CFJ != null) {
        paramVarArgs.d(9, this.CFJ);
      }
      if (this.CFK != null) {
        paramVarArgs.d(10, this.CFK);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CCB) + f.a.a.b.b.a.bA(3, this.CFD);
      paramInt = i;
      if (this.CFE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CFE);
      }
      i = paramInt;
      if (this.CFF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CFF);
      }
      paramInt = i;
      if (this.CFG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CFG);
      }
      i = paramInt;
      if (this.CFH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CFH);
      }
      paramInt = i;
      if (this.CFI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CFI);
      }
      i = paramInt;
      if (this.CFJ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CFJ);
      }
      paramInt = i;
      if (this.CFK != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CFK);
      }
      AppMethodBeat.o(155394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(155394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        kw localkw = (kw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155394);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localkw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155394);
          return 0;
        case 2: 
          localkw.CCB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155394);
          return 0;
        case 3: 
          localkw.CFD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155394);
          return 0;
        case 4: 
          localkw.CFE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 5: 
          localkw.CFF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 6: 
          localkw.CFG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 7: 
          localkw.CFH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 8: 
          localkw.CFI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 9: 
          localkw.CFJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155394);
          return 0;
        }
        localkw.CFK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(155394);
        return 0;
      }
      AppMethodBeat.o(155394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kw
 * JD-Core Version:    0.7.0.1
 */