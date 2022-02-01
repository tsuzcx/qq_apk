package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ctb
  extends erp
{
  public String YJX;
  public gol YOj;
  public int ZwR;
  public String aayS;
  public String aayT;
  public String aayU;
  public String aayV;
  public String aayW;
  public String vhX;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155417);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOj == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155417);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(2, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      if (this.aayS != null) {
        paramVarArgs.g(3, this.aayS);
      }
      if (this.aayT != null) {
        paramVarArgs.g(4, this.aayT);
      }
      if (this.vhX != null) {
        paramVarArgs.g(5, this.vhX);
      }
      if (this.aayU != null) {
        paramVarArgs.g(6, this.aayU);
      }
      if (this.aayV != null) {
        paramVarArgs.g(7, this.aayV);
      }
      if (this.aayW != null) {
        paramVarArgs.g(8, this.aayW);
      }
      paramVarArgs.bS(9, this.ZwR);
      if (this.yts != null) {
        paramVarArgs.g(10, this.yts);
      }
      if (this.YJX != null) {
        paramVarArgs.g(11, this.YJX);
      }
      AppMethodBeat.o(155417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1002;
      }
    }
    label1002:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YOj != null) {
        paramInt = i + i.a.a.a.qC(2, this.YOj.computeSize());
      }
      i = paramInt;
      if (this.aayS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aayS);
      }
      paramInt = i;
      if (this.aayT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aayT);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.vhX);
      }
      paramInt = i;
      if (this.aayU != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aayU);
      }
      i = paramInt;
      if (this.aayV != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aayV);
      }
      paramInt = i;
      if (this.aayW != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aayW);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.ZwR);
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.yts);
      }
      i = paramInt;
      if (this.YJX != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YJX);
      }
      AppMethodBeat.o(155417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YOj == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155417);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ctb localctb = (ctb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155417);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localctb.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 2: 
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
            localctb.YOj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155417);
          return 0;
        case 3: 
          localctb.aayS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 4: 
          localctb.aayT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 5: 
          localctb.vhX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 6: 
          localctb.aayU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 7: 
          localctb.aayV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 8: 
          localctb.aayW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155417);
          return 0;
        case 9: 
          localctb.ZwR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155417);
          return 0;
        case 10: 
          localctb.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155417);
          return 0;
        }
        localctb.YJX = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(155417);
        return 0;
      }
      AppMethodBeat.o(155417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctb
 * JD-Core Version:    0.7.0.1
 */