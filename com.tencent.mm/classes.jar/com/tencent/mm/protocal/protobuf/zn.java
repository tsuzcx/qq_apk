package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zn
  extends cqk
{
  public String Bpi;
  public LinkedList<qx> EtR;
  public int EtS;
  public int EtT;
  public int version;
  
  public zn()
  {
    AppMethodBeat.i(32177);
    this.EtR = new LinkedList();
    AppMethodBeat.o(32177);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32178);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.EtR);
      paramVarArgs.aR(3, this.version);
      paramVarArgs.aR(4, this.EtS);
      paramVarArgs.aR(5, this.EtT);
      if (this.Bpi != null) {
        paramVarArgs.d(6, this.Bpi);
      }
      AppMethodBeat.o(32178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EtR) + f.a.a.b.b.a.bx(3, this.version) + f.a.a.b.b.a.bx(4, this.EtS) + f.a.a.b.b.a.bx(5, this.EtT);
      paramInt = i;
      if (this.Bpi != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Bpi);
      }
      AppMethodBeat.o(32178);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EtR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zn localzn = (zn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32178);
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
            localzn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzn.EtR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 3: 
          localzn.version = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32178);
          return 0;
        case 4: 
          localzn.EtS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32178);
          return 0;
        case 5: 
          localzn.EtT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32178);
          return 0;
        }
        localzn.Bpi = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32178);
        return 0;
      }
      AppMethodBeat.o(32178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zn
 * JD-Core Version:    0.7.0.1
 */