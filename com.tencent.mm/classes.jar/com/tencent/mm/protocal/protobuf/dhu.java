package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dhu
  extends cvw
{
  public SKBuiltinBuffer_t HNa;
  public int HNc;
  public String HNx;
  public long HNy;
  public long HOJ;
  public int HOK;
  public long HOL;
  public int HOM;
  public LinkedList<Long> HON;
  public int HOO;
  public int HOP;
  public long HOQ;
  public long HOR;
  
  public dhu()
  {
    AppMethodBeat.i(125826);
    this.HON = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HNx != null) {
        paramVarArgs.d(2, this.HNx);
      }
      paramVarArgs.aZ(3, this.HNy);
      paramVarArgs.aZ(4, this.HOJ);
      paramVarArgs.aS(5, this.HOK);
      paramVarArgs.aZ(6, this.HOL);
      if (this.HNa != null)
      {
        paramVarArgs.lJ(7, this.HNa.computeSize());
        this.HNa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.HNc);
      paramVarArgs.aS(11, this.HOM);
      paramVarArgs.f(12, 3, this.HON);
      paramVarArgs.aS(13, this.HOO);
      paramVarArgs.aS(14, this.HOP);
      paramVarArgs.aZ(15, this.HOQ);
      paramVarArgs.aZ(16, this.HOR);
      AppMethodBeat.o(125827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HNx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HNx);
      }
      i = i + f.a.a.b.b.a.p(3, this.HNy) + f.a.a.b.b.a.p(4, this.HOJ) + f.a.a.b.b.a.bz(5, this.HOK) + f.a.a.b.b.a.p(6, this.HOL);
      paramInt = i;
      if (this.HNa != null) {
        paramInt = i + f.a.a.a.lI(7, this.HNa.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.HNc);
      int j = f.a.a.b.b.a.bz(11, this.HOM);
      int k = f.a.a.a.d(12, 3, this.HON);
      int m = f.a.a.b.b.a.bz(13, this.HOO);
      int n = f.a.a.b.b.a.bz(14, this.HOP);
      int i1 = f.a.a.b.b.a.p(15, this.HOQ);
      int i2 = f.a.a.b.b.a.p(16, this.HOR);
      AppMethodBeat.o(125827);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HON.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhu localdhu = (dhu)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 2: 
          localdhu.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125827);
          return 0;
        case 3: 
          localdhu.HNy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125827);
          return 0;
        case 4: 
          localdhu.HOJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125827);
          return 0;
        case 5: 
          localdhu.HOK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 6: 
          localdhu.HOL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125827);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhu.HNa = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 8: 
          localdhu.HNc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 11: 
          localdhu.HOM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 12: 
          localdhu.HON = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCj();
          AppMethodBeat.o(125827);
          return 0;
        case 13: 
          localdhu.HOO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 14: 
          localdhu.HOP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125827);
          return 0;
        case 15: 
          localdhu.HOQ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125827);
          return 0;
        }
        localdhu.HOR = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(125827);
        return 0;
      }
      AppMethodBeat.o(125827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhu
 * JD-Core Version:    0.7.0.1
 */