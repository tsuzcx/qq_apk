package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class des
  extends cqk
{
  public int DLH;
  public String FJm;
  public int FKH;
  public long FNn;
  public int FOi;
  public LinkedList<def> FOj;
  public int FOk;
  public int FOl;
  
  public des()
  {
    AppMethodBeat.i(118477);
    this.FOj = new LinkedList();
    AppMethodBeat.o(118477);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118478);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FJm != null) {
        paramVarArgs.d(2, this.FJm);
      }
      paramVarArgs.aR(3, this.FOi);
      paramVarArgs.e(4, 8, this.FOj);
      paramVarArgs.aR(5, this.FOk);
      paramVarArgs.aR(6, this.FOl);
      paramVarArgs.aR(7, this.FKH);
      paramVarArgs.aO(8, this.FNn);
      paramVarArgs.aR(9, this.DLH);
      AppMethodBeat.o(118478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FJm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FJm);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FOi);
      int j = f.a.a.a.c(4, 8, this.FOj);
      int k = f.a.a.b.b.a.bx(5, this.FOk);
      int m = f.a.a.b.b.a.bx(6, this.FOl);
      int n = f.a.a.b.b.a.bx(7, this.FKH);
      int i1 = f.a.a.b.b.a.p(8, this.FNn);
      int i2 = f.a.a.b.b.a.bx(9, this.DLH);
      AppMethodBeat.o(118478);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FOj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118478);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        des localdes = (des)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118478);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdes.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 2: 
          localdes.FJm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118478);
          return 0;
        case 3: 
          localdes.FOi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118478);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new def();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((def)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdes.FOj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 5: 
          localdes.FOk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118478);
          return 0;
        case 6: 
          localdes.FOl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118478);
          return 0;
        case 7: 
          localdes.FKH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118478);
          return 0;
        case 8: 
          localdes.FNn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(118478);
          return 0;
        }
        localdes.DLH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118478);
        return 0;
      }
      AppMethodBeat.o(118478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.des
 * JD-Core Version:    0.7.0.1
 */