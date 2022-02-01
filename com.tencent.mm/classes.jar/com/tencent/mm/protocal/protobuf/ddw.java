package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddw
  extends cvw
{
  public SKBuiltinBuffer_t FSi;
  public SKBuiltinBuffer_t FSj;
  public float GgZ;
  public float Gha;
  public int Gzf;
  public String Gzg;
  public String Gzh;
  public int Gzi;
  public int HLx;
  public int HLy;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      paramVarArgs.y(3, this.GgZ);
      paramVarArgs.y(4, this.Gha);
      paramVarArgs.aS(5, this.Gzf);
      if (this.Gzg != null) {
        paramVarArgs.d(6, this.Gzg);
      }
      if (this.Gzh != null) {
        paramVarArgs.d(7, this.Gzh);
      }
      paramVarArgs.aS(8, this.HLx);
      paramVarArgs.aS(9, this.HLy);
      paramVarArgs.aS(10, this.Gzi);
      if (this.FSi != null)
      {
        paramVarArgs.lJ(11, this.FSi.computeSize());
        this.FSi.writeFields(paramVarArgs);
      }
      if (this.FSj != null)
      {
        paramVarArgs.lJ(12, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode) + f.a.a.b.b.a.amE(3) + f.a.a.b.b.a.amE(4) + f.a.a.b.b.a.bz(5, this.Gzf);
      paramInt = i;
      if (this.Gzg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gzg);
      }
      i = paramInt;
      if (this.Gzh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gzh);
      }
      i = i + f.a.a.b.b.a.bz(8, this.HLx) + f.a.a.b.b.a.bz(9, this.HLy) + f.a.a.b.b.a.bz(10, this.Gzi);
      paramInt = i;
      if (this.FSi != null) {
        paramInt = i + f.a.a.a.lI(11, this.FSi.computeSize());
      }
      i = paramInt;
      if (this.FSj != null) {
        i = paramInt + f.a.a.a.lI(12, this.FSj.computeSize());
      }
      AppMethodBeat.o(32446);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddw localddw = (ddw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32446);
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
            localddw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32446);
          return 0;
        case 2: 
          localddw.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 3: 
          localddw.GgZ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(32446);
          return 0;
        case 4: 
          localddw.Gha = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(32446);
          return 0;
        case 5: 
          localddw.Gzf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 6: 
          localddw.Gzg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32446);
          return 0;
        case 7: 
          localddw.Gzh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32446);
          return 0;
        case 8: 
          localddw.HLx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 9: 
          localddw.HLy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 10: 
          localddw.Gzi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32446);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddw.FSi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32446);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localddw.FSj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32446);
        return 0;
      }
      AppMethodBeat.o(32446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddw
 * JD-Core Version:    0.7.0.1
 */