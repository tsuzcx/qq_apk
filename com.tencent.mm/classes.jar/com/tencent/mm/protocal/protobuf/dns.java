package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dns
  extends dop
{
  public LinkedList<String> EmotionList;
  public String KTg;
  public dnm MQN;
  public doi MQO;
  public int oUv;
  
  public dns()
  {
    AppMethodBeat.i(115964);
    this.EmotionList = new LinkedList();
    AppMethodBeat.o(115964);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115965);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oUv);
      if (this.MQN != null)
      {
        paramVarArgs.ni(3, this.MQN.computeSize());
        this.MQN.writeFields(paramVarArgs);
      }
      if (this.MQO != null)
      {
        paramVarArgs.ni(4, this.MQO.computeSize());
        this.MQO.writeFields(paramVarArgs);
      }
      if (this.KTg != null) {
        paramVarArgs.e(5, this.KTg);
      }
      paramVarArgs.e(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv);
      paramInt = i;
      if (this.MQN != null) {
        paramInt = i + g.a.a.a.nh(3, this.MQN.computeSize());
      }
      i = paramInt;
      if (this.MQO != null) {
        i = paramInt + g.a.a.a.nh(4, this.MQO.computeSize());
      }
      paramInt = i;
      if (this.KTg != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KTg);
      }
      i = g.a.a.a.c(6, 1, this.EmotionList);
      AppMethodBeat.o(115965);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EmotionList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dns localdns = (dns)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115965);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdns.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 2: 
          localdns.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115965);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdns.MQN = ((dnm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new doi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((doi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdns.MQO = ((doi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 5: 
          localdns.KTg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115965);
          return 0;
        }
        localdns.EmotionList.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(115965);
        return 0;
      }
      AppMethodBeat.o(115965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dns
 * JD-Core Version:    0.7.0.1
 */