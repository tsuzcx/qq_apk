package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ctq
  extends esc
{
  public boolean aazq = false;
  public int aazr;
  public int aazs;
  public alg aazt;
  public alg aazu;
  public String aazv;
  public String nQG;
  public String nQH;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257963);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257963);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.aazq);
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.nQG != null) {
        paramVarArgs.g(4, this.nQG);
      }
      if (this.nQH != null) {
        paramVarArgs.g(5, this.nQH);
      }
      if (this.url != null) {
        paramVarArgs.g(6, this.url);
      }
      paramVarArgs.bS(7, this.aazr);
      paramVarArgs.bS(8, this.aazs);
      if (this.aazt != null)
      {
        paramVarArgs.qD(9, this.aazt.computeSize());
        this.aazt.writeFields(paramVarArgs);
      }
      if (this.aazu != null)
      {
        paramVarArgs.qD(10, this.aazu.computeSize());
        this.aazu.writeFields(paramVarArgs);
      }
      if (this.aazv != null) {
        paramVarArgs.g(11, this.aazv);
      }
      AppMethodBeat.o(257963);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1036;
      }
    }
    label1036:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.title);
      }
      i = paramInt;
      if (this.nQG != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.nQG);
      }
      paramInt = i;
      if (this.nQH != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nQH);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.url);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.aazr) + i.a.a.b.b.a.cJ(8, this.aazs);
      paramInt = i;
      if (this.aazt != null) {
        paramInt = i + i.a.a.a.qC(9, this.aazt.computeSize());
      }
      i = paramInt;
      if (this.aazu != null) {
        i = paramInt + i.a.a.a.qC(10, this.aazu.computeSize());
      }
      paramInt = i;
      if (this.aazv != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aazv);
      }
      AppMethodBeat.o(257963);
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
          AppMethodBeat.o(257963);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257963);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ctq localctq = (ctq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257963);
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
            localctq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257963);
          return 0;
        case 2: 
          localctq.aazq = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257963);
          return 0;
        case 3: 
          localctq.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257963);
          return 0;
        case 4: 
          localctq.nQG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257963);
          return 0;
        case 5: 
          localctq.nQH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257963);
          return 0;
        case 6: 
          localctq.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257963);
          return 0;
        case 7: 
          localctq.aazr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257963);
          return 0;
        case 8: 
          localctq.aazs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257963);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alg)localObject2).parseFrom((byte[])localObject1);
            }
            localctq.aazt = ((alg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257963);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alg)localObject2).parseFrom((byte[])localObject1);
            }
            localctq.aazu = ((alg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257963);
          return 0;
        }
        localctq.aazv = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257963);
        return 0;
      }
      AppMethodBeat.o(257963);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctq
 * JD-Core Version:    0.7.0.1
 */