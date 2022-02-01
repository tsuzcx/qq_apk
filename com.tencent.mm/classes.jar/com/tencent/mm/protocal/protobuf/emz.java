package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class emz
  extends dpc
{
  public int BsF;
  public int BsG;
  public int BsH;
  public int CreateTime;
  public String NkS;
  public String UserName;
  public String jfi;
  public String jfl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.jfl != null) {
        paramVarArgs.e(3, this.jfl);
      }
      if (this.NkS != null) {
        paramVarArgs.e(4, this.NkS);
      }
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      paramVarArgs.aM(6, this.BsF);
      paramVarArgs.aM(7, this.BsG);
      paramVarArgs.aM(8, this.BsH);
      paramVarArgs.aM(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label805;
      }
    }
    label805:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.jfl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.jfl);
      }
      paramInt = i;
      if (this.NkS != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NkS);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UserName);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.BsF);
      int j = g.a.a.b.b.a.bu(7, this.BsG);
      int k = g.a.a.b.b.a.bu(8, this.BsH);
      int m = g.a.a.b.b.a.bu(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        emz localemz = (emz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32485);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localemz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32485);
          return 0;
        case 2: 
          localemz.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 3: 
          localemz.jfl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 4: 
          localemz.NkS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 5: 
          localemz.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 6: 
          localemz.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32485);
          return 0;
        case 7: 
          localemz.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32485);
          return 0;
        case 8: 
          localemz.BsH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32485);
          return 0;
        }
        localemz.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32485);
        return 0;
      }
      AppMethodBeat.o(32485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emz
 * JD-Core Version:    0.7.0.1
 */