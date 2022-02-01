package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgx
  extends ckq
{
  public int CyE;
  public String Exi;
  public String MD5;
  public String hnC;
  public String mAQ;
  public int mBH;
  public int uKQ;
  public int uKR;
  public int uKS;
  public SKBuiltinBuffer_t uKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32484);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32484);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      paramVarArgs.aR(3, this.CyE);
      if (this.Exi != null) {
        paramVarArgs.d(4, this.Exi);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(5, this.mAQ);
      }
      paramVarArgs.aR(6, this.uKQ);
      paramVarArgs.aR(7, this.uKR);
      paramVarArgs.aR(8, this.uKS);
      if (this.uKT != null)
      {
        paramVarArgs.kX(9, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.mBH);
      if (this.MD5 != null) {
        paramVarArgs.d(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label999;
      }
    }
    label999:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hnC);
      }
      i += f.a.a.b.b.a.bA(3, this.CyE);
      paramInt = i;
      if (this.Exi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Exi);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAQ);
      }
      i = i + f.a.a.b.b.a.bA(6, this.uKQ) + f.a.a.b.b.a.bA(7, this.uKR) + f.a.a.b.b.a.bA(8, this.uKS);
      paramInt = i;
      if (this.uKT != null) {
        paramInt = i + f.a.a.a.kW(9, this.uKT.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.mBH);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.MD5);
      }
      AppMethodBeat.o(32484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.uKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32484);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgx localdgx = (dgx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32484);
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
            localdgx.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 2: 
          localdgx.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 3: 
          localdgx.CyE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32484);
          return 0;
        case 4: 
          localdgx.Exi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 5: 
          localdgx.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32484);
          return 0;
        case 6: 
          localdgx.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32484);
          return 0;
        case 7: 
          localdgx.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32484);
          return 0;
        case 8: 
          localdgx.uKS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32484);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgx.uKT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32484);
          return 0;
        case 10: 
          localdgx.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32484);
          return 0;
        }
        localdgx.MD5 = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32484);
        return 0;
      }
      AppMethodBeat.o(32484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgx
 * JD-Core Version:    0.7.0.1
 */