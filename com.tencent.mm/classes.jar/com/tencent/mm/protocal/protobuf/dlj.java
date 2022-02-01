package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlj
  extends cpx
{
  public int FTY;
  public String devicetype;
  public String eNf;
  public String vsV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.devicetype == null)
      {
        paramVarArgs = new b("Not all required fields were included: devicetype");
        AppMethodBeat.o(32477);
        throw paramVarArgs;
      }
      if (this.vsV == null)
      {
        paramVarArgs = new b("Not all required fields were included: deviceid");
        AppMethodBeat.o(32477);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.devicetype != null) {
        paramVarArgs.d(2, this.devicetype);
      }
      if (this.vsV != null) {
        paramVarArgs.d(3, this.vsV);
      }
      if (this.eNf != null) {
        paramVarArgs.d(4, this.eNf);
      }
      paramVarArgs.aR(5, this.FTY);
      AppMethodBeat.o(32477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label645;
      }
    }
    label645:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicetype != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.devicetype);
      }
      i = paramInt;
      if (this.vsV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vsV);
      }
      paramInt = i;
      if (this.eNf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.eNf);
      }
      i = f.a.a.b.b.a.bx(5, this.FTY);
      AppMethodBeat.o(32477);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.devicetype == null)
        {
          paramVarArgs = new b("Not all required fields were included: devicetype");
          AppMethodBeat.o(32477);
          throw paramVarArgs;
        }
        if (this.vsV == null)
        {
          paramVarArgs = new b("Not all required fields were included: deviceid");
          AppMethodBeat.o(32477);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlj localdlj = (dlj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32477);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32477);
          return 0;
        case 2: 
          localdlj.devicetype = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32477);
          return 0;
        case 3: 
          localdlj.vsV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32477);
          return 0;
        case 4: 
          localdlj.eNf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32477);
          return 0;
        }
        localdlj.FTY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32477);
        return 0;
      }
      AppMethodBeat.o(32477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlj
 * JD-Core Version:    0.7.0.1
 */