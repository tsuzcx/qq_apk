package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckf
  extends ckq
{
  public int DJm;
  public long DYU;
  public long EfA;
  public long Efv;
  public String Efw;
  public int Efx;
  public int Efy;
  public int Efz;
  public int Scene;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.Efv);
      if (this.Efw != null) {
        paramVarArgs.d(3, this.Efw);
      }
      paramVarArgs.aR(4, this.Scene);
      paramVarArgs.aR(5, this.Efx);
      paramVarArgs.aR(6, this.DJm);
      paramVarArgs.aR(7, this.Efy);
      paramVarArgs.aG(8, this.DYU);
      paramVarArgs.aR(9, this.Efz);
      if (this.hnC != null) {
        paramVarArgs.d(10, this.hnC);
      }
      paramVarArgs.aG(11, this.EfA);
      AppMethodBeat.o(117902);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.Efv);
      paramInt = i;
      if (this.Efw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Efw);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Scene) + f.a.a.b.b.a.bA(5, this.Efx) + f.a.a.b.b.a.bA(6, this.DJm) + f.a.a.b.b.a.bA(7, this.Efy) + f.a.a.b.b.a.q(8, this.DYU) + f.a.a.b.b.a.bA(9, this.Efz);
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hnC);
      }
      i = f.a.a.b.b.a.q(11, this.EfA);
      AppMethodBeat.o(117902);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117902);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckf localckf = (ckf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117902);
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
            localckf.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117902);
          return 0;
        case 2: 
          localckf.Efv = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(117902);
          return 0;
        case 3: 
          localckf.Efw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117902);
          return 0;
        case 4: 
          localckf.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117902);
          return 0;
        case 5: 
          localckf.Efx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117902);
          return 0;
        case 6: 
          localckf.DJm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117902);
          return 0;
        case 7: 
          localckf.Efy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117902);
          return 0;
        case 8: 
          localckf.DYU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(117902);
          return 0;
        case 9: 
          localckf.Efz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117902);
          return 0;
        case 10: 
          localckf.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117902);
          return 0;
        }
        localckf.EfA = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117902);
        return 0;
      }
      AppMethodBeat.o(117902);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckf
 * JD-Core Version:    0.7.0.1
 */