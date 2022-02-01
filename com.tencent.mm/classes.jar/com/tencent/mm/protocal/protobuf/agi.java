package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agi
  extends cvw
{
  public int FSQ;
  public String FSg;
  public String FVO;
  public SKBuiltinBuffer_t FWl;
  public String FWw;
  public String GwC;
  public String GwD;
  public int GwE;
  public String qkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FWl == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155402);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FWl != null)
      {
        paramVarArgs.lJ(2, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FSQ);
      if (this.FVO != null) {
        paramVarArgs.d(4, this.FVO);
      }
      if (this.qkN != null) {
        paramVarArgs.d(5, this.qkN);
      }
      if (this.FWw != null) {
        paramVarArgs.d(6, this.FWw);
      }
      if (this.GwC != null) {
        paramVarArgs.d(7, this.GwC);
      }
      if (this.FSg != null) {
        paramVarArgs.d(8, this.FSg);
      }
      if (this.GwD != null) {
        paramVarArgs.d(9, this.GwD);
      }
      paramVarArgs.aS(10, this.GwE);
      AppMethodBeat.o(155402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FWl != null) {
        i = paramInt + f.a.a.a.lI(2, this.FWl.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.FSQ);
      paramInt = i;
      if (this.FVO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVO);
      }
      i = paramInt;
      if (this.qkN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.qkN);
      }
      paramInt = i;
      if (this.FWw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FWw);
      }
      i = paramInt;
      if (this.GwC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GwC);
      }
      paramInt = i;
      if (this.FSg != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FSg);
      }
      i = paramInt;
      if (this.GwD != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GwD);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.GwE);
      AppMethodBeat.o(155402);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FWl == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agi localagi = (agi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155402);
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
            localagi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagi.FWl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 3: 
          localagi.FSQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155402);
          return 0;
        case 4: 
          localagi.FVO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 5: 
          localagi.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 6: 
          localagi.FWw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 7: 
          localagi.GwC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 8: 
          localagi.FSg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 9: 
          localagi.GwD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155402);
          return 0;
        }
        localagi.GwE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155402);
        return 0;
      }
      AppMethodBeat.o(155402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agi
 * JD-Core Version:    0.7.0.1
 */