package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpk
  extends dyl
{
  public int Svu;
  public long TWc;
  public eaf TWs;
  public eaf TWt;
  public eaf TWu;
  public int TWv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32386);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TWs == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.TWt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChannelReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.TWu == null)
      {
        paramVarArgs = new b("Not all required fields were included: EngineReport");
        AppMethodBeat.o(32386);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TWs != null)
      {
        paramVarArgs.oE(2, this.TWs.computeSize());
        this.TWs.writeFields(paramVarArgs);
      }
      if (this.TWt != null)
      {
        paramVarArgs.oE(3, this.TWt.computeSize());
        this.TWt.writeFields(paramVarArgs);
      }
      if (this.TWu != null)
      {
        paramVarArgs.oE(4, this.TWu.computeSize());
        this.TWu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Svu);
      paramVarArgs.bm(6, this.TWc);
      paramVarArgs.aY(7, this.TWv);
      AppMethodBeat.o(32386);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label987;
      }
    }
    label987:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TWs != null) {
        paramInt = i + g.a.a.a.oD(2, this.TWs.computeSize());
      }
      i = paramInt;
      if (this.TWt != null) {
        i = paramInt + g.a.a.a.oD(3, this.TWt.computeSize());
      }
      paramInt = i;
      if (this.TWu != null) {
        paramInt = i + g.a.a.a.oD(4, this.TWu.computeSize());
      }
      i = g.a.a.b.b.a.bM(5, this.Svu);
      int j = g.a.a.b.b.a.p(6, this.TWc);
      int k = g.a.a.b.b.a.bM(7, this.TWv);
      AppMethodBeat.o(32386);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TWs == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.TWt == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChannelReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        if (this.TWu == null)
        {
          paramVarArgs = new b("Not all required fields were included: EngineReport");
          AppMethodBeat.o(32386);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32386);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dpk localdpk = (dpk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32386);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdpk.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localdpk.TWs = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localdpk.TWt = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localdpk.TWu = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32386);
          return 0;
        case 5: 
          localdpk.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32386);
          return 0;
        case 6: 
          localdpk.TWc = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(32386);
          return 0;
        }
        localdpk.TWv = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32386);
        return 0;
      }
      AppMethodBeat.o(32386);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpk
 * JD-Core Version:    0.7.0.1
 */