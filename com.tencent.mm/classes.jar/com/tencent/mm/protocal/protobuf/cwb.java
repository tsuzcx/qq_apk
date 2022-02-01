package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cwb
  extends ckq
{
  public SKBuiltinBuffer_t ElQ;
  public int ElS;
  public String Emn;
  public long Emo;
  public int EnA;
  public long EnB;
  public int EnC;
  public LinkedList<Long> EnD;
  public int EnE;
  public int EnF;
  public long EnG;
  public long EnH;
  public long Enz;
  
  public cwb()
  {
    AppMethodBeat.i(125826);
    this.EnD = new LinkedList();
    AppMethodBeat.o(125826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125827);
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
      paramVarArgs.aG(3, this.Emo);
      paramVarArgs.aG(4, this.Enz);
      paramVarArgs.aR(5, this.EnA);
      paramVarArgs.aG(6, this.EnB);
      if (this.ElQ != null)
      {
        paramVarArgs.kX(7, this.ElQ.computeSize());
        this.ElQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.ElS);
      paramVarArgs.aR(11, this.EnC);
      paramVarArgs.f(12, 3, this.EnD);
      paramVarArgs.aR(13, this.EnE);
      paramVarArgs.aR(14, this.EnF);
      paramVarArgs.aG(15, this.EnG);
      paramVarArgs.aG(16, this.EnH);
      AppMethodBeat.o(125827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Emn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Emn);
      }
      i = i + f.a.a.b.b.a.q(3, this.Emo) + f.a.a.b.b.a.q(4, this.Enz) + f.a.a.b.b.a.bA(5, this.EnA) + f.a.a.b.b.a.q(6, this.EnB);
      paramInt = i;
      if (this.ElQ != null) {
        paramInt = i + f.a.a.a.kW(7, this.ElQ.computeSize());
      }
      i = f.a.a.b.b.a.bA(8, this.ElS);
      int j = f.a.a.b.b.a.bA(11, this.EnC);
      int k = f.a.a.a.d(12, 3, this.EnD);
      int m = f.a.a.b.b.a.bA(13, this.EnE);
      int n = f.a.a.b.b.a.bA(14, this.EnF);
      int i1 = f.a.a.b.b.a.q(15, this.EnG);
      int i2 = f.a.a.b.b.a.q(16, this.EnH);
      AppMethodBeat.o(125827);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EnD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwb localcwb = (cwb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(125827);
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
            localcwb.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 2: 
          localcwb.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125827);
          return 0;
        case 3: 
          localcwb.Emo = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125827);
          return 0;
        case 4: 
          localcwb.Enz = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125827);
          return 0;
        case 5: 
          localcwb.EnA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125827);
          return 0;
        case 6: 
          localcwb.EnB = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125827);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwb.ElQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 8: 
          localcwb.ElS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125827);
          return 0;
        case 11: 
          localcwb.EnC = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125827);
          return 0;
        case 12: 
          localcwb.EnD = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMt();
          AppMethodBeat.o(125827);
          return 0;
        case 13: 
          localcwb.EnE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125827);
          return 0;
        case 14: 
          localcwb.EnF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125827);
          return 0;
        case 15: 
          localcwb.EnG = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125827);
          return 0;
        }
        localcwb.EnH = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125827);
        return 0;
      }
      AppMethodBeat.o(125827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwb
 * JD-Core Version:    0.7.0.1
 */