package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhr
  extends ckq
{
  public boolean ExQ;
  public int fVD;
  public String hnC;
  public int mBG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      paramVarArgs.aR(3, this.mBG);
      paramVarArgs.bg(4, this.ExQ);
      paramVarArgs.aR(5, this.fVD);
      AppMethodBeat.o(123666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hnC);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.mBG);
      int j = f.a.a.b.b.a.fY(4);
      int k = f.a.a.b.b.a.bA(5, this.fVD);
      AppMethodBeat.o(123666);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhr localdhr = (dhr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123666);
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
            localdhr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123666);
          return 0;
        case 2: 
          localdhr.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123666);
          return 0;
        case 3: 
          localdhr.mBG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123666);
          return 0;
        case 4: 
          localdhr.ExQ = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(123666);
          return 0;
        }
        localdhr.fVD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123666);
        return 0;
      }
      AppMethodBeat.o(123666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhr
 * JD-Core Version:    0.7.0.1
 */