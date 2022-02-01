package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnt
  extends esc
{
  public int Njs;
  public long Njv;
  public int NkN;
  public int NkO;
  public int NkP;
  public gol NkQ;
  public etl YFE;
  public etl YFF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152573);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Njs);
      if (this.YFE != null)
      {
        paramVarArgs.qD(3, this.YFE.computeSize());
        this.YFE.writeFields(paramVarArgs);
      }
      if (this.YFF != null)
      {
        paramVarArgs.qD(4, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.NkN);
      paramVarArgs.bS(6, this.NkO);
      paramVarArgs.bS(7, this.NkP);
      if (this.NkQ != null)
      {
        paramVarArgs.qD(8, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(9, this.Njv);
      AppMethodBeat.o(152573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1098;
      }
    }
    label1098:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Njs);
      paramInt = i;
      if (this.YFE != null) {
        paramInt = i + i.a.a.a.qC(3, this.YFE.computeSize());
      }
      i = paramInt;
      if (this.YFF != null) {
        i = paramInt + i.a.a.a.qC(4, this.YFF.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(5, this.NkN) + i.a.a.b.b.a.cJ(6, this.NkO) + i.a.a.b.b.a.cJ(7, this.NkP);
      paramInt = i;
      if (this.NkQ != null) {
        paramInt = i + i.a.a.a.qC(8, this.NkQ.computeSize());
      }
      i = i.a.a.b.b.a.q(9, this.Njv);
      AppMethodBeat.o(152573);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.YFE == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.YFF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnt localcnt = (cnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152573);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcnt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 2: 
          localcnt.Njs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152573);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcnt.YFE = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcnt.YFF = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 5: 
          localcnt.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152573);
          return 0;
        case 6: 
          localcnt.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152573);
          return 0;
        case 7: 
          localcnt.NkP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152573);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localcnt.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        }
        localcnt.Njv = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(152573);
        return 0;
      }
      AppMethodBeat.o(152573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnt
 * JD-Core Version:    0.7.0.1
 */