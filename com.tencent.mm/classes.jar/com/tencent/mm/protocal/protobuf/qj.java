package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qj
  extends cqk
{
  public int CreateTime;
  public String DPY;
  public String DUJ;
  public String EhA;
  public int EhF;
  public String Ehp;
  public String tlJ;
  public String tlK;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152512);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152512);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ehp != null) {
        paramVarArgs.d(3, this.Ehp);
      }
      if (this.tlK != null) {
        paramVarArgs.d(4, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(5, this.tlJ);
      }
      paramVarArgs.aR(9, this.CreateTime);
      paramVarArgs.aO(10, this.vTQ);
      if (this.EhA != null) {
        paramVarArgs.d(11, this.EhA);
      }
      if (this.DUJ != null) {
        paramVarArgs.d(12, this.DUJ);
      }
      if (this.DPY != null) {
        paramVarArgs.d(13, this.DPY);
      }
      paramVarArgs.aR(14, this.EhF);
      AppMethodBeat.o(152512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ehp != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ehp);
      }
      i = paramInt;
      if (this.tlK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tlK);
      }
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tlJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.CreateTime) + f.a.a.b.b.a.p(10, this.vTQ);
      paramInt = i;
      if (this.EhA != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EhA);
      }
      i = paramInt;
      if (this.DUJ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DUJ);
      }
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DPY);
      }
      i = f.a.a.b.b.a.bx(14, this.EhF);
      AppMethodBeat.o(152512);
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
          AppMethodBeat.o(152512);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152512);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qj localqj = (qj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152512);
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
            localqj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152512);
          return 0;
        case 3: 
          localqj.Ehp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 4: 
          localqj.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 5: 
          localqj.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 9: 
          localqj.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152512);
          return 0;
        case 10: 
          localqj.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(152512);
          return 0;
        case 11: 
          localqj.EhA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 12: 
          localqj.DUJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 13: 
          localqj.DPY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152512);
          return 0;
        }
        localqj.EhF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152512);
        return 0;
      }
      AppMethodBeat.o(152512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qj
 * JD-Core Version:    0.7.0.1
 */