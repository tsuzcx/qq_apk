package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctn
  extends dpc
{
  public LinkedList<ekt> LWt;
  public com.tencent.mm.bw.b LXC;
  public float Myv;
  public String Myw;
  public String Myx;
  public String Myy;
  public int jeU;
  
  public ctn()
  {
    AppMethodBeat.i(120958);
    this.LWt = new LinkedList();
    AppMethodBeat.o(120958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(120959);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.jeU);
      paramVarArgs.e(3, 8, this.LWt);
      if (this.LXC != null) {
        paramVarArgs.c(4, this.LXC);
      }
      paramVarArgs.E(5, this.Myv);
      if (this.Myw != null) {
        paramVarArgs.e(6, this.Myw);
      }
      if (this.Myx != null) {
        paramVarArgs.e(7, this.Myx);
      }
      if (this.Myy != null) {
        paramVarArgs.e(8, this.Myy);
      }
      AppMethodBeat.o(120959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label833;
      }
    }
    label833:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.jeU) + g.a.a.a.c(3, 8, this.LWt);
      paramInt = i;
      if (this.LXC != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LXC);
      }
      i = paramInt + (g.a.a.b.b.a.fS(5) + 4);
      paramInt = i;
      if (this.Myw != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Myw);
      }
      i = paramInt;
      if (this.Myx != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Myx);
      }
      paramInt = i;
      if (this.Myy != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Myy);
      }
      AppMethodBeat.o(120959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LWt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(120959);
          throw paramVarArgs;
        }
        AppMethodBeat.o(120959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctn localctn = (ctn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120959);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 2: 
          localctn.jeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(120959);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctn.LWt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 4: 
          localctn.LXC = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(120959);
          return 0;
        case 5: 
          localctn.Myv = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(120959);
          return 0;
        case 6: 
          localctn.Myw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(120959);
          return 0;
        case 7: 
          localctn.Myx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(120959);
          return 0;
        }
        localctn.Myy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(120959);
        return 0;
      }
      AppMethodBeat.o(120959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctn
 * JD-Core Version:    0.7.0.1
 */