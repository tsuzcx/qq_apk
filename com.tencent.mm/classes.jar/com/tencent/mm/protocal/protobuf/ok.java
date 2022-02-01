package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ok
  extends ckq
{
  public b CMb;
  public String CxW;
  public String CxX;
  public String CxY;
  public int Cya;
  public String vBp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91365);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CxW != null) {
        paramVarArgs.d(2, this.CxW);
      }
      if (this.CxX != null) {
        paramVarArgs.d(3, this.CxX);
      }
      if (this.vBp != null) {
        paramVarArgs.d(4, this.vBp);
      }
      paramVarArgs.aR(5, this.Cya);
      if (this.CMb != null) {
        paramVarArgs.c(6, this.CMb);
      }
      if (this.CxY != null) {
        paramVarArgs.d(7, this.CxY);
      }
      AppMethodBeat.o(91365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CxW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CxW);
      }
      i = paramInt;
      if (this.CxX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CxX);
      }
      paramInt = i;
      if (this.vBp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vBp);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Cya);
      paramInt = i;
      if (this.CMb != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.CMb);
      }
      i = paramInt;
      if (this.CxY != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CxY);
      }
      AppMethodBeat.o(91365);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ok localok = (ok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91365);
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
            localok.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91365);
          return 0;
        case 2: 
          localok.CxW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 3: 
          localok.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 4: 
          localok.vBp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91365);
          return 0;
        case 5: 
          localok.Cya = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91365);
          return 0;
        case 6: 
          localok.CMb = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91365);
          return 0;
        }
        localok.CxY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91365);
        return 0;
      }
      AppMethodBeat.o(91365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ok
 * JD-Core Version:    0.7.0.1
 */