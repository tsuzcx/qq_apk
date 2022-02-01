package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class rl
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public ro Sak;
  public rp Sal;
  public ri Sam;
  public String ThumbUrl;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117840);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.CMB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.Sak == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.Sam == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActionInfo");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(3, this.ThumbUrl);
      }
      if (this.Sak != null)
      {
        paramVarArgs.oE(4, this.Sak.computeSize());
        this.Sak.writeFields(paramVarArgs);
      }
      if (this.Sal != null)
      {
        paramVarArgs.oE(5, this.Sal.computeSize());
        this.Sal.writeFields(paramVarArgs);
      }
      if (this.Sam != null)
      {
        paramVarArgs.oE(6, this.Sam.computeSize());
        this.Sam.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label976;
      }
    }
    label976:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMB);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.Sak != null) {
        paramInt = i + g.a.a.a.oD(4, this.Sak.computeSize());
      }
      i = paramInt;
      if (this.Sal != null) {
        i = paramInt + g.a.a.a.oD(5, this.Sal.computeSize());
      }
      paramInt = i;
      if (this.Sam != null) {
        paramInt = i + g.a.a.a.oD(6, this.Sam.computeSize());
      }
      AppMethodBeat.o(117840);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.CMB == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.Sak == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.Sam == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActionInfo");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117840);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rl localrl = (rl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117840);
          return -1;
        case 1: 
          localrl.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 2: 
          localrl.CMB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 3: 
          localrl.ThumbUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ro();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ro)localObject2).parseFrom((byte[])localObject1);
            }
            localrl.Sak = ((ro)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rp)localObject2).parseFrom((byte[])localObject1);
            }
            localrl.Sal = ((rp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ri();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ri)localObject2).parseFrom((byte[])localObject1);
          }
          localrl.Sam = ((ri)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117840);
        return 0;
      }
      AppMethodBeat.o(117840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rl
 * JD-Core Version:    0.7.0.1
 */