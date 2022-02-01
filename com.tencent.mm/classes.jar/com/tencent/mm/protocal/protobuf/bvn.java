package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvn
  extends com.tencent.mm.bx.a
{
  public int Auy;
  public bvi aadc;
  public String aadd;
  public atg aade;
  public String desc;
  public String iconUrl;
  public String topic;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164048);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.topic != null) {
        paramVarArgs.g(1, this.topic);
      }
      paramVarArgs.bS(2, this.Auy);
      if (this.iconUrl != null) {
        paramVarArgs.g(3, this.iconUrl);
      }
      if (this.desc != null) {
        paramVarArgs.g(4, this.desc);
      }
      if (this.aadc != null)
      {
        paramVarArgs.qD(5, this.aadc.computeSize());
        this.aadc.writeFields(paramVarArgs);
      }
      if (this.aadd != null) {
        paramVarArgs.g(6, this.aadd);
      }
      if (this.aade != null)
      {
        paramVarArgs.qD(7, this.aade.computeSize());
        this.aade.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(164048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.topic == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = i.a.a.b.b.a.h(1, this.topic) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Auy);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.iconUrl);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.desc);
      }
      paramInt = i;
      if (this.aadc != null) {
        paramInt = i + i.a.a.a.qC(5, this.aadc.computeSize());
      }
      i = paramInt;
      if (this.aadd != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aadd);
      }
      paramInt = i;
      if (this.aade != null) {
        paramInt = i + i.a.a.a.qC(7, this.aade.computeSize());
      }
      AppMethodBeat.o(164048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bvn localbvn = (bvn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164048);
          return -1;
        case 1: 
          localbvn.topic = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 2: 
          localbvn.Auy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(164048);
          return 0;
        case 3: 
          localbvn.iconUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 4: 
          localbvn.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvi)localObject2).parseFrom((byte[])localObject1);
            }
            localbvn.aadc = ((bvi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(164048);
          return 0;
        case 6: 
          localbvn.aadd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(164048);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new atg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((atg)localObject2).parseFrom((byte[])localObject1);
          }
          localbvn.aade = ((atg)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvn
 * JD-Core Version:    0.7.0.1
 */