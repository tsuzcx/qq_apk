package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aab
  extends dyy
{
  public String Rzs;
  public djz SlG;
  public etc Smq;
  public String token;
  public int vht;
  public String vhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91419);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91419);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(3, this.vhu);
      }
      if (this.token != null) {
        paramVarArgs.f(4, this.token);
      }
      if (this.SlG != null)
      {
        paramVarArgs.oE(5, this.SlG.computeSize());
        this.SlG.writeFields(paramVarArgs);
      }
      if (this.Rzs != null) {
        paramVarArgs.f(6, this.Rzs);
      }
      if (this.Smq != null)
      {
        paramVarArgs.oE(7, this.Smq.computeSize());
        this.Smq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label828;
      }
    }
    label828:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.vhu);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.token);
      }
      paramInt = i;
      if (this.SlG != null) {
        paramInt = i + g.a.a.a.oD(5, this.SlG.computeSize());
      }
      i = paramInt;
      if (this.Rzs != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Rzs);
      }
      paramInt = i;
      if (this.Smq != null) {
        paramInt = i + g.a.a.a.oD(7, this.Smq.computeSize());
      }
      AppMethodBeat.o(91419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aab localaab = (aab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91419);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localaab.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 2: 
          localaab.vht = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91419);
          return 0;
        case 3: 
          localaab.vhu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 4: 
          localaab.token = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91419);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djz)localObject2).parseFrom((byte[])localObject1);
            }
            localaab.SlG = ((djz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91419);
          return 0;
        case 6: 
          localaab.Rzs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91419);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etc)localObject2).parseFrom((byte[])localObject1);
          }
          localaab.Smq = ((etc)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aab
 * JD-Core Version:    0.7.0.1
 */