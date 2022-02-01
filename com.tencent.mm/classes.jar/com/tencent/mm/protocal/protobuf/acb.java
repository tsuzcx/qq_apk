package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class acb
  extends esc
{
  public String YvQ;
  public ecj ZjQ;
  public fon ZkC;
  public String token;
  public int ytv;
  public String ytw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91419);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91419);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ytv);
      if (this.ytw != null) {
        paramVarArgs.g(3, this.ytw);
      }
      if (this.token != null) {
        paramVarArgs.g(4, this.token);
      }
      if (this.ZjQ != null)
      {
        paramVarArgs.qD(5, this.ZjQ.computeSize());
        this.ZjQ.writeFields(paramVarArgs);
      }
      if (this.YvQ != null) {
        paramVarArgs.g(6, this.YvQ);
      }
      if (this.ZkC != null)
      {
        paramVarArgs.qD(7, this.ZkC.computeSize());
        this.ZkC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label824;
      }
    }
    label824:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ytv);
      paramInt = i;
      if (this.ytw != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ytw);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.token);
      }
      paramInt = i;
      if (this.ZjQ != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZjQ.computeSize());
      }
      i = paramInt;
      if (this.YvQ != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YvQ);
      }
      paramInt = i;
      if (this.ZkC != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZkC.computeSize());
      }
      AppMethodBeat.o(91419);
      return paramInt;
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
          AppMethodBeat.o(91419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        acb localacb = (acb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91419);
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
            localacb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 2: 
          localacb.ytv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91419);
          return 0;
        case 3: 
          localacb.ytw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 4: 
          localacb.token = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ecj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ecj)localObject2).parseFrom((byte[])localObject1);
            }
            localacb.ZjQ = ((ecj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 6: 
          localacb.YvQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91419);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fon();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fon)localObject2).parseFrom((byte[])localObject1);
          }
          localacb.ZkC = ((fon)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91419);
        return 0;
      }
      AppMethodBeat.o(91419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acb
 * JD-Core Version:    0.7.0.1
 */