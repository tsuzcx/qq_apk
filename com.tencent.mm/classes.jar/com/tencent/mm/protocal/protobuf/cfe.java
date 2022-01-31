package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class cfe
  extends buy
{
  public SKBuiltinBuffer_t xNO;
  public int xNQ;
  public String xOk;
  public long xOl;
  public long xPt;
  public int xPu;
  public long xPv;
  public int xPw;
  public LinkedList<Long> xPx;
  public int xPy;
  
  public cfe()
  {
    AppMethodBeat.i(94616);
    this.xPx = new LinkedList();
    AppMethodBeat.o(94616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94617);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xOk != null) {
        paramVarArgs.e(2, this.xOk);
      }
      paramVarArgs.am(3, this.xOl);
      paramVarArgs.am(4, this.xPt);
      paramVarArgs.aO(5, this.xPu);
      paramVarArgs.am(6, this.xPv);
      if (this.xNO != null)
      {
        paramVarArgs.iQ(7, this.xNO.computeSize());
        this.xNO.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.xNQ);
      paramVarArgs.aO(11, this.xPw);
      paramVarArgs.f(12, 3, this.xPx);
      paramVarArgs.aO(13, this.xPy);
      AppMethodBeat.o(94617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label961;
      }
    }
    label961:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xOk != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xOk);
      }
      i = i + e.a.a.b.b.a.p(3, this.xOl) + e.a.a.b.b.a.p(4, this.xPt) + e.a.a.b.b.a.bl(5, this.xPu) + e.a.a.b.b.a.p(6, this.xPv);
      paramInt = i;
      if (this.xNO != null) {
        paramInt = i + e.a.a.a.iP(7, this.xNO.computeSize());
      }
      i = e.a.a.b.b.a.bl(8, this.xNQ);
      int j = e.a.a.b.b.a.bl(11, this.xPw);
      int k = e.a.a.a.d(12, 3, this.xPx);
      int m = e.a.a.b.b.a.bl(13, this.xPy);
      AppMethodBeat.o(94617);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xPx.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfe localcfe = (cfe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(94617);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfe.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94617);
          return 0;
        case 2: 
          localcfe.xOk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94617);
          return 0;
        case 3: 
          localcfe.xOl = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94617);
          return 0;
        case 4: 
          localcfe.xPt = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94617);
          return 0;
        case 5: 
          localcfe.xPu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94617);
          return 0;
        case 6: 
          localcfe.xPv = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94617);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfe.xNO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94617);
          return 0;
        case 8: 
          localcfe.xNQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94617);
          return 0;
        case 11: 
          localcfe.xPw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94617);
          return 0;
        case 12: 
          paramVarArgs = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY;
          localObject1 = new LinkedList();
          for (;;)
          {
            if (paramVarArgs.bgR >= paramVarArgs.bufferSize)
            {
              localcfe.xPx = ((LinkedList)localObject1);
              AppMethodBeat.o(94617);
              return 0;
            }
            ((LinkedList)localObject1).add(Long.valueOf(paramVarArgs.sm()));
          }
        }
        localcfe.xPy = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94617);
        return 0;
      }
      AppMethodBeat.o(94617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfe
 * JD-Core Version:    0.7.0.1
 */