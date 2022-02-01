package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dha
  extends cvc
{
  public String HtU;
  public long HtV;
  public SKBuiltinBuffer_t Htx;
  public int Htz;
  public long Hvg;
  public int Hvh;
  public long Hvi;
  public int Hvj;
  public LinkedList<Long> Hvk;
  public int Hvl;
  public int Hvm;
  public long Hvn;
  public long Hvo;
  
  public dha()
  {
    AppMethodBeat.i(125826);
    this.Hvk = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HtU != null) {
        paramVarArgs.d(2, this.HtU);
      }
      paramVarArgs.aY(3, this.HtV);
      paramVarArgs.aY(4, this.Hvg);
      paramVarArgs.aS(5, this.Hvh);
      paramVarArgs.aY(6, this.Hvi);
      if (this.Htx != null)
      {
        paramVarArgs.lC(7, this.Htx.computeSize());
        this.Htx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.Htz);
      paramVarArgs.aS(11, this.Hvj);
      paramVarArgs.f(12, 3, this.Hvk);
      paramVarArgs.aS(13, this.Hvl);
      paramVarArgs.aS(14, this.Hvm);
      paramVarArgs.aY(15, this.Hvn);
      paramVarArgs.aY(16, this.Hvo);
      AppMethodBeat.o(125827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HtU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HtU);
      }
      i = i + f.a.a.b.b.a.p(3, this.HtV) + f.a.a.b.b.a.p(4, this.Hvg) + f.a.a.b.b.a.bz(5, this.Hvh) + f.a.a.b.b.a.p(6, this.Hvi);
      paramInt = i;
      if (this.Htx != null) {
        paramInt = i + f.a.a.a.lB(7, this.Htx.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.Htz);
      int j = f.a.a.b.b.a.bz(11, this.Hvj);
      int k = f.a.a.a.d(12, 3, this.Hvk);
      int m = f.a.a.b.b.a.bz(13, this.Hvl);
      int n = f.a.a.b.b.a.bz(14, this.Hvm);
      int i1 = f.a.a.b.b.a.p(15, this.Hvn);
      int i2 = f.a.a.b.b.a.p(16, this.Hvo);
      AppMethodBeat.o(125827);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hvk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dha localdha = (dha)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdha.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 2: 
          localdha.HtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125827);
          return 0;
        case 3: 
          localdha.HtV = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125827);
          return 0;
        case 4: 
          localdha.Hvg = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125827);
          return 0;
        case 5: 
          localdha.Hvh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 6: 
          localdha.Hvi = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125827);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdha.Htx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 8: 
          localdha.Htz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 11: 
          localdha.Hvj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 12: 
          localdha.Hvk = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxH();
          AppMethodBeat.o(125827);
          return 0;
        case 13: 
          localdha.Hvl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 14: 
          localdha.Hvm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 15: 
          localdha.Hvn = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125827);
          return 0;
        }
        localdha.Hvo = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125827);
        return 0;
      }
      AppMethodBeat.o(125827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dha
 * JD-Core Version:    0.7.0.1
 */