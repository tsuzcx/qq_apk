package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ajh
  extends ckq
{
  public b Dlt;
  public aht Dlx;
  public int IoU;
  public dzq KJJ;
  public ebv LxA;
  public long Lxz;
  public float dpb;
  public String dqA;
  public float dqQ;
  public int evC;
  public int qSS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168990);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dlx != null)
      {
        paramVarArgs.kX(2, this.Dlx.computeSize());
        this.Dlx.writeFields(paramVarArgs);
      }
      if (this.Dlt != null) {
        paramVarArgs.c(3, this.Dlt);
      }
      paramVarArgs.aR(4, this.qSS);
      if (this.dqA != null) {
        paramVarArgs.d(5, this.dqA);
      }
      paramVarArgs.x(6, this.dqQ);
      paramVarArgs.x(7, this.dpb);
      paramVarArgs.aG(8, this.Lxz);
      paramVarArgs.aR(9, this.IoU);
      if (this.LxA != null)
      {
        paramVarArgs.kX(10, this.LxA.computeSize());
        this.LxA.writeFields(paramVarArgs);
      }
      if (this.KJJ != null)
      {
        paramVarArgs.kX(11, this.KJJ.computeSize());
        this.KJJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.evC);
      AppMethodBeat.o(168990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1168;
      }
    }
    label1168:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dlx != null) {
        paramInt = i + f.a.a.a.kW(2, this.Dlx.computeSize());
      }
      i = paramInt;
      if (this.Dlt != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Dlt);
      }
      i += f.a.a.b.b.a.bA(4, this.qSS);
      paramInt = i;
      if (this.dqA != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dqA);
      }
      i = paramInt + (f.a.a.b.b.a.fY(6) + 4) + (f.a.a.b.b.a.fY(7) + 4) + f.a.a.b.b.a.q(8, this.Lxz) + f.a.a.b.b.a.bA(9, this.IoU);
      paramInt = i;
      if (this.LxA != null) {
        paramInt = i + f.a.a.a.kW(10, this.LxA.computeSize());
      }
      i = paramInt;
      if (this.KJJ != null) {
        i = paramInt + f.a.a.a.kW(11, this.KJJ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(12, this.evC);
      AppMethodBeat.o(168990);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajh localajh = (ajh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168990);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajh.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajh.Dlx = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 3: 
          localajh.Dlt = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168990);
          return 0;
        case 4: 
          localajh.qSS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168990);
          return 0;
        case 5: 
          localajh.dqA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168990);
          return 0;
        case 6: 
          localajh.dqQ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(168990);
          return 0;
        case 7: 
          localajh.dpb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(168990);
          return 0;
        case 8: 
          localajh.Lxz = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168990);
          return 0;
        case 9: 
          localajh.IoU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168990);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajh.LxA = ((ebv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajh.KJJ = ((dzq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        }
        localajh.evC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168990);
        return 0;
      }
      AppMethodBeat.o(168990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajh
 * JD-Core Version:    0.7.0.1
 */