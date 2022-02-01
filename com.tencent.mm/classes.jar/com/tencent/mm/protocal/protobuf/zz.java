package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zz
  extends cqk
{
  public LinkedList<cac> DQg;
  public String Euf;
  public String Eug;
  public String ioe;
  
  public zz()
  {
    AppMethodBeat.i(152524);
    this.DQg = new LinkedList();
    AppMethodBeat.o(152524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ioe != null) {
        paramVarArgs.d(2, this.ioe);
      }
      paramVarArgs.e(3, 8, this.DQg);
      if (this.Euf != null) {
        paramVarArgs.d(4, this.Euf);
      }
      if (this.Eug != null) {
        paramVarArgs.d(5, this.Eug);
      }
      AppMethodBeat.o(152525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ioe != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ioe);
      }
      i += f.a.a.a.c(3, 8, this.DQg);
      paramInt = i;
      if (this.Euf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Euf);
      }
      i = paramInt;
      if (this.Eug != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eug);
      }
      AppMethodBeat.o(152525);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DQg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zz localzz = (zz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152525);
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
            localzz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 2: 
          localzz.ioe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152525);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cac();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cac)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzz.DQg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 4: 
          localzz.Euf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152525);
          return 0;
        }
        localzz.Eug = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152525);
        return 0;
      }
      AppMethodBeat.o(152525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zz
 * JD-Core Version:    0.7.0.1
 */