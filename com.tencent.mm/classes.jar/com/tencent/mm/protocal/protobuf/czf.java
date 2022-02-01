package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czf
  extends ckq
{
  public String Cxb;
  public String Emn;
  public long Emo;
  public int EnA;
  public long Enz;
  public long Erf;
  public String mAQ;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Emn != null) {
        paramVarArgs.d(2, this.Emn);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      paramVarArgs.aG(4, this.Emo);
      paramVarArgs.aG(5, this.Enz);
      paramVarArgs.aR(6, this.EnA);
      paramVarArgs.aG(7, this.Erf);
      paramVarArgs.aR(8, this.rNz);
      if (this.Cxb != null) {
        paramVarArgs.d(9, this.Cxb);
      }
      AppMethodBeat.o(118476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label710;
      }
    }
    label710:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Emn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Emn);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mAQ);
      }
      i = i + f.a.a.b.b.a.q(4, this.Emo) + f.a.a.b.b.a.q(5, this.Enz) + f.a.a.b.b.a.bA(6, this.EnA) + f.a.a.b.b.a.q(7, this.Erf) + f.a.a.b.b.a.bA(8, this.rNz);
      paramInt = i;
      if (this.Cxb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Cxb);
      }
      AppMethodBeat.o(118476);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czf localczf = (czf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118476);
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
            localczf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118476);
          return 0;
        case 2: 
          localczf.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 3: 
          localczf.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118476);
          return 0;
        case 4: 
          localczf.Emo = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118476);
          return 0;
        case 5: 
          localczf.Enz = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118476);
          return 0;
        case 6: 
          localczf.EnA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118476);
          return 0;
        case 7: 
          localczf.Erf = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118476);
          return 0;
        case 8: 
          localczf.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118476);
          return 0;
        }
        localczf.Cxb = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(118476);
        return 0;
      }
      AppMethodBeat.o(118476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czf
 * JD-Core Version:    0.7.0.1
 */