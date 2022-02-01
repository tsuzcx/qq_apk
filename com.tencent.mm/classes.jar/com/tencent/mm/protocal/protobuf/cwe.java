package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cwe
  extends ckq
{
  public SKBuiltinBuffer_t CCV;
  public int CYi;
  public String Cxw;
  public int DNn;
  public int DNo;
  public dew DXy;
  public int EnX;
  public int EnY;
  public int EnZ;
  public int ExtFlag;
  public String MD5;
  public String gKn;
  public String hnC;
  public int mBH;
  public int uKQ;
  public int uKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125830);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CCV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125830);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.uKR);
      paramVarArgs.aR(17, this.EnX);
      paramVarArgs.aR(4, this.uKQ);
      if (this.CCV != null)
      {
        paramVarArgs.kX(5, this.CCV.computeSize());
        this.CCV.writeFields(paramVarArgs);
      }
      if (this.gKn != null) {
        paramVarArgs.d(6, this.gKn);
      }
      paramVarArgs.aR(7, this.DNn);
      paramVarArgs.aR(8, this.DNo);
      if (this.Cxw != null) {
        paramVarArgs.d(9, this.Cxw);
      }
      paramVarArgs.aR(10, this.EnY);
      paramVarArgs.aR(11, this.CYi);
      if (this.DXy != null)
      {
        paramVarArgs.kX(12, this.DXy.computeSize());
        this.DXy.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(13, this.hnC);
      }
      paramVarArgs.aR(14, this.ExtFlag);
      if (this.MD5 != null) {
        paramVarArgs.d(15, this.MD5);
      }
      paramVarArgs.aR(16, this.EnZ);
      AppMethodBeat.o(125830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1362;
      }
    }
    label1362:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH) + f.a.a.b.b.a.bA(3, this.uKR) + f.a.a.b.b.a.bA(17, this.EnX) + f.a.a.b.b.a.bA(4, this.uKQ);
      paramInt = i;
      if (this.CCV != null) {
        paramInt = i + f.a.a.a.kW(5, this.CCV.computeSize());
      }
      i = paramInt;
      if (this.gKn != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.gKn);
      }
      i = i + f.a.a.b.b.a.bA(7, this.DNn) + f.a.a.b.b.a.bA(8, this.DNo);
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Cxw);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.EnY) + f.a.a.b.b.a.bA(11, this.CYi);
      paramInt = i;
      if (this.DXy != null) {
        paramInt = i + f.a.a.a.kW(12, this.DXy.computeSize());
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hnC);
      }
      i += f.a.a.b.b.a.bA(14, this.ExtFlag);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.MD5);
      }
      i = f.a.a.b.b.a.bA(16, this.EnZ);
      AppMethodBeat.o(125830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CCV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125830);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwe localcwe = (cwe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125830);
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
            localcwe.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 2: 
          localcwe.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 3: 
          localcwe.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 17: 
          localcwe.EnX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 4: 
          localcwe.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwe.CCV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 6: 
          localcwe.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 7: 
          localcwe.DNn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 8: 
          localcwe.DNo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 9: 
          localcwe.Cxw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 10: 
          localcwe.EnY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 11: 
          localcwe.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dew();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwe.DXy = ((dew)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 13: 
          localcwe.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 14: 
          localcwe.ExtFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125830);
          return 0;
        case 15: 
          localcwe.MD5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125830);
          return 0;
        }
        localcwe.EnZ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125830);
        return 0;
      }
      AppMethodBeat.o(125830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwe
 * JD-Core Version:    0.7.0.1
 */