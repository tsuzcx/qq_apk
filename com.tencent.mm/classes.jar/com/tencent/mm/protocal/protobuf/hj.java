package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hj
  extends cpx
{
  public int DLC;
  public int DUM;
  public SKBuiltinBuffer_t DUN;
  public String DUm;
  public String DUp;
  public SKBuiltinBuffer_t DUr;
  public String iJW;
  public String ncV;
  public String pAC;
  public String pAD;
  public String tCb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133150);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUN == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133150);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DUM);
      if (this.DUN != null)
      {
        paramVarArgs.ln(3, this.DUN.computeSize());
        this.DUN.writeFields(paramVarArgs);
      }
      if (this.tCb != null) {
        paramVarArgs.d(4, this.tCb);
      }
      if (this.DUm != null) {
        paramVarArgs.d(5, this.DUm);
      }
      if (this.iJW != null) {
        paramVarArgs.d(6, this.iJW);
      }
      if (this.ncV != null) {
        paramVarArgs.d(7, this.ncV);
      }
      if (this.DUp != null) {
        paramVarArgs.d(8, this.DUp);
      }
      if (this.pAD != null) {
        paramVarArgs.d(9, this.pAD);
      }
      if (this.pAC != null) {
        paramVarArgs.d(10, this.pAC);
      }
      paramVarArgs.aR(11, this.DLC);
      if (this.DUr != null)
      {
        paramVarArgs.ln(12, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133150);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DUM);
      paramInt = i;
      if (this.DUN != null) {
        paramInt = i + f.a.a.a.lm(3, this.DUN.computeSize());
      }
      i = paramInt;
      if (this.tCb != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tCb);
      }
      paramInt = i;
      if (this.DUm != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DUm);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.iJW);
      }
      paramInt = i;
      if (this.ncV != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ncV);
      }
      i = paramInt;
      if (this.DUp != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DUp);
      }
      paramInt = i;
      if (this.pAD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.pAD);
      }
      i = paramInt;
      if (this.pAC != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.pAC);
      }
      i += f.a.a.b.b.a.bx(11, this.DLC);
      paramInt = i;
      if (this.DUr != null) {
        paramInt = i + f.a.a.a.lm(12, this.DUr.computeSize());
      }
      AppMethodBeat.o(133150);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DUN == null)
        {
          paramVarArgs = new b("Not all required fields were included: AxTicket");
          AppMethodBeat.o(133150);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hj localhj = (hj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133150);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 2: 
          localhj.DUM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133150);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhj.DUN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 4: 
          localhj.tCb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 5: 
          localhj.DUm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 6: 
          localhj.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 7: 
          localhj.ncV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 8: 
          localhj.DUp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 9: 
          localhj.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 10: 
          localhj.pAC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 11: 
          localhj.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133150);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhj.DUr = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      AppMethodBeat.o(133150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hj
 * JD-Core Version:    0.7.0.1
 */