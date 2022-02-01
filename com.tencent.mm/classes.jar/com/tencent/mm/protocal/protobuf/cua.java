package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cua
  extends cqk
{
  public int CreateTime;
  public String DRb;
  public String EhA;
  public int EhF;
  public String hOf;
  public int ndI;
  public String tlJ;
  public String tlK;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32427);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32427);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      if (this.tlK != null) {
        paramVarArgs.d(3, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(4, this.tlJ);
      }
      paramVarArgs.aR(5, this.vTO);
      if (this.DRb != null) {
        paramVarArgs.d(6, this.DRb);
      }
      paramVarArgs.aR(7, this.CreateTime);
      paramVarArgs.aR(8, this.ndI);
      paramVarArgs.aO(9, this.vTQ);
      if (this.EhA != null) {
        paramVarArgs.d(10, this.EhA);
      }
      paramVarArgs.aR(12, this.EhF);
      AppMethodBeat.o(32427);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label911;
      }
    }
    label911:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hOf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = paramInt;
      if (this.tlK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlK);
      }
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tlJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.vTO);
      paramInt = i;
      if (this.DRb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DRb);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.CreateTime) + f.a.a.b.b.a.bx(8, this.ndI) + f.a.a.b.b.a.p(9, this.vTQ);
      paramInt = i;
      if (this.EhA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EhA);
      }
      i = f.a.a.b.b.a.bx(12, this.EhF);
      AppMethodBeat.o(32427);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32427);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32427);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cua localcua = (cua)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(32427);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcua.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32427);
          return 0;
        case 2: 
          localcua.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 3: 
          localcua.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 4: 
          localcua.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 5: 
          localcua.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32427);
          return 0;
        case 6: 
          localcua.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32427);
          return 0;
        case 7: 
          localcua.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32427);
          return 0;
        case 8: 
          localcua.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32427);
          return 0;
        case 9: 
          localcua.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32427);
          return 0;
        case 10: 
          localcua.EhA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32427);
          return 0;
        }
        localcua.EhF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32427);
        return 0;
      }
      AppMethodBeat.o(32427);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cua
 * JD-Core Version:    0.7.0.1
 */