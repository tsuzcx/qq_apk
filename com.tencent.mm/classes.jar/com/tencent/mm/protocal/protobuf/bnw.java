package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bnw
  extends ckq
{
  public int DLe;
  public LinkedList<b> DLf;
  public long DLg;
  public long DLh;
  public float dpb;
  public float dqQ;
  public long viE;
  
  public bnw()
  {
    AppMethodBeat.i(169918);
    this.DLf = new LinkedList();
    AppMethodBeat.o(169918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DLe);
      paramVarArgs.x(3, this.dpb);
      paramVarArgs.x(4, this.dqQ);
      paramVarArgs.e(5, 6, this.DLf);
      paramVarArgs.aG(6, this.viE);
      paramVarArgs.aG(7, this.DLg);
      paramVarArgs.aG(8, this.DLh);
      AppMethodBeat.o(169919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DLe);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.a.c(5, 6, this.DLf);
      int n = f.a.a.b.b.a.q(6, this.viE);
      int i1 = f.a.a.b.b.a.q(7, this.DLg);
      int i2 = f.a.a.b.b.a.q(8, this.DLh);
      AppMethodBeat.o(169919);
      return paramInt + i + (j + 4) + (k + 4) + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DLf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnw localbnw = (bnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169919);
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
            localbnw.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169919);
          return 0;
        case 2: 
          localbnw.DLe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169919);
          return 0;
        case 3: 
          localbnw.dpb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169919);
          return 0;
        case 4: 
          localbnw.dqQ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(169919);
          return 0;
        case 5: 
          localbnw.DLf.add(((f.a.a.a.a)localObject1).KhF.fMu());
          AppMethodBeat.o(169919);
          return 0;
        case 6: 
          localbnw.viE = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169919);
          return 0;
        case 7: 
          localbnw.DLg = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169919);
          return 0;
        }
        localbnw.DLh = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(169919);
        return 0;
      }
      AppMethodBeat.o(169919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnw
 * JD-Core Version:    0.7.0.1
 */