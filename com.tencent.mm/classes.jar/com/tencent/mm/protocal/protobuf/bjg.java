package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjg
  extends com.tencent.mm.cd.a
{
  public bjb STu;
  public String STv;
  public apn STw;
  public String desc;
  public String iconUrl;
  public String topic;
  public int wXA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164048);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.topic != null) {
        paramVarArgs.f(1, this.topic);
      }
      paramVarArgs.aY(2, this.wXA);
      if (this.iconUrl != null) {
        paramVarArgs.f(3, this.iconUrl);
      }
      if (this.desc != null) {
        paramVarArgs.f(4, this.desc);
      }
      if (this.STu != null)
      {
        paramVarArgs.oE(5, this.STu.computeSize());
        this.STu.writeFields(paramVarArgs);
      }
      if (this.STv != null) {
        paramVarArgs.f(6, this.STv);
      }
      if (this.STw != null)
      {
        paramVarArgs.oE(7, this.STw.computeSize());
        this.STw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(164048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.topic == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = g.a.a.b.b.a.g(1, this.topic) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.wXA);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.iconUrl);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.desc);
      }
      paramInt = i;
      if (this.STu != null) {
        paramInt = i + g.a.a.a.oD(5, this.STu.computeSize());
      }
      i = paramInt;
      if (this.STv != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.STv);
      }
      paramInt = i;
      if (this.STw != null) {
        paramInt = i + g.a.a.a.oD(7, this.STw.computeSize());
      }
      AppMethodBeat.o(164048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjg localbjg = (bjg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164048);
          return -1;
        case 1: 
          localbjg.topic = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 2: 
          localbjg.wXA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(164048);
          return 0;
        case 3: 
          localbjg.iconUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 4: 
          localbjg.desc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjb)localObject2).parseFrom((byte[])localObject1);
            }
            localbjg.STu = ((bjb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(164048);
          return 0;
        case 6: 
          localbjg.STv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(164048);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new apn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((apn)localObject2).parseFrom((byte[])localObject1);
          }
          localbjg.STw = ((apn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      AppMethodBeat.o(164048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjg
 * JD-Core Version:    0.7.0.1
 */