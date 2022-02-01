package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acd
  extends ckq
{
  public int CyE;
  public String DcJ;
  public int DcK;
  public int DcL;
  public String hnC;
  public String hnF;
  public String mAQ;
  public int mBH;
  public int uKQ;
  public int uKR;
  public int uKS;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9590);
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
      paramVarArgs.aR(3, this.CyE);
      if (this.hnF != null) {
        paramVarArgs.d(4, this.hnF);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(5, this.mAQ);
      }
      paramVarArgs.aR(6, this.uKQ);
      paramVarArgs.aR(7, this.uKR);
      paramVarArgs.aR(8, this.uKS);
      if (this.DcJ != null) {
        paramVarArgs.d(9, this.DcJ);
      }
      paramVarArgs.aR(10, this.DcK);
      paramVarArgs.aR(11, this.mBH);
      paramVarArgs.aR(12, this.DcL);
      paramVarArgs.aG(13, this.uKZ);
      AppMethodBeat.o(9590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hnC);
      }
      i += f.a.a.b.b.a.bA(3, this.CyE);
      paramInt = i;
      if (this.hnF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hnF);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAQ);
      }
      i = i + f.a.a.b.b.a.bA(6, this.uKQ) + f.a.a.b.b.a.bA(7, this.uKR) + f.a.a.b.b.a.bA(8, this.uKS);
      paramInt = i;
      if (this.DcJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DcJ);
      }
      i = f.a.a.b.b.a.bA(10, this.DcK);
      int j = f.a.a.b.b.a.bA(11, this.mBH);
      int k = f.a.a.b.b.a.bA(12, this.DcL);
      int m = f.a.a.b.b.a.q(13, this.uKZ);
      AppMethodBeat.o(9590);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(9590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acd localacd = (acd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9590);
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
            localacd.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9590);
          return 0;
        case 2: 
          localacd.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 3: 
          localacd.CyE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9590);
          return 0;
        case 4: 
          localacd.hnF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 5: 
          localacd.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 6: 
          localacd.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9590);
          return 0;
        case 7: 
          localacd.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9590);
          return 0;
        case 8: 
          localacd.uKS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9590);
          return 0;
        case 9: 
          localacd.DcJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(9590);
          return 0;
        case 10: 
          localacd.DcK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9590);
          return 0;
        case 11: 
          localacd.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9590);
          return 0;
        case 12: 
          localacd.DcL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9590);
          return 0;
        }
        localacd.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(9590);
        return 0;
      }
      AppMethodBeat.o(9590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acd
 * JD-Core Version:    0.7.0.1
 */