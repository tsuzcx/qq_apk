package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class mv
  extends dop
{
  public b KRc;
  public String KRd;
  public String KRe;
  public String KRf;
  public int KRg;
  public int KRh;
  public long KRi;
  public boolean KRj;
  public boolean KRk;
  public GoodsObject KRl;
  public int KRm;
  public int KRn;
  public mu KRo;
  public ms KRp;
  public mt KRq;
  public long KRr;
  public int mode;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KRc != null) {
        paramVarArgs.c(2, this.KRc);
      }
      paramVarArgs.aM(11, this.type);
      paramVarArgs.aM(12, this.mode);
      if (this.KRd != null) {
        paramVarArgs.e(13, this.KRd);
      }
      if (this.KRe != null) {
        paramVarArgs.e(14, this.KRe);
      }
      if (this.KRf != null) {
        paramVarArgs.e(15, this.KRf);
      }
      paramVarArgs.aM(16, this.KRg);
      paramVarArgs.aM(17, this.KRh);
      paramVarArgs.bb(18, this.KRi);
      paramVarArgs.cc(19, this.KRj);
      paramVarArgs.cc(20, this.KRk);
      if (this.KRl != null)
      {
        paramVarArgs.ni(21, this.KRl.computeSize());
        this.KRl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(22, this.KRm);
      paramVarArgs.aM(23, this.KRn);
      if (this.KRo != null)
      {
        paramVarArgs.ni(26, this.KRo.computeSize());
        this.KRo.writeFields(paramVarArgs);
      }
      if (this.KRp != null)
      {
        paramVarArgs.ni(31, this.KRp.computeSize());
        this.KRp.writeFields(paramVarArgs);
      }
      if (this.KRq != null)
      {
        paramVarArgs.ni(32, this.KRq.computeSize());
        this.KRq.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(50, this.KRr);
      AppMethodBeat.o(124394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1698;
      }
    }
    label1698:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KRc != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KRc);
      }
      i = i + g.a.a.b.b.a.bu(11, this.type) + g.a.a.b.b.a.bu(12, this.mode);
      paramInt = i;
      if (this.KRd != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KRd);
      }
      i = paramInt;
      if (this.KRe != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.KRe);
      }
      paramInt = i;
      if (this.KRf != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.KRf);
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.KRg) + g.a.a.b.b.a.bu(17, this.KRh) + g.a.a.b.b.a.r(18, this.KRi) + (g.a.a.b.b.a.fS(19) + 1) + (g.a.a.b.b.a.fS(20) + 1);
      paramInt = i;
      if (this.KRl != null) {
        paramInt = i + g.a.a.a.nh(21, this.KRl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(22, this.KRm) + g.a.a.b.b.a.bu(23, this.KRn);
      paramInt = i;
      if (this.KRo != null) {
        paramInt = i + g.a.a.a.nh(26, this.KRo.computeSize());
      }
      i = paramInt;
      if (this.KRp != null) {
        i = paramInt + g.a.a.a.nh(31, this.KRp.computeSize());
      }
      paramInt = i;
      if (this.KRq != null) {
        paramInt = i + g.a.a.a.nh(32, this.KRq.computeSize());
      }
      i = g.a.a.b.b.a.r(50, this.KRr);
      AppMethodBeat.o(124394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mv localmv = (mv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124394);
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
            localmv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 2: 
          localmv.KRc = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(124394);
          return 0;
        case 11: 
          localmv.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124394);
          return 0;
        case 12: 
          localmv.mode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124394);
          return 0;
        case 13: 
          localmv.KRd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 14: 
          localmv.KRe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 15: 
          localmv.KRf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 16: 
          localmv.KRg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124394);
          return 0;
        case 17: 
          localmv.KRh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124394);
          return 0;
        case 18: 
          localmv.KRi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(124394);
          return 0;
        case 19: 
          localmv.KRj = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(124394);
          return 0;
        case 20: 
          localmv.KRk = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(124394);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmv.KRl = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 22: 
          localmv.KRm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124394);
          return 0;
        case 23: 
          localmv.KRn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124394);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmv.KRo = ((mu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ms();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ms)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmv.KRp = ((ms)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmv.KRq = ((mt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        }
        localmv.KRr = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(124394);
        return 0;
      }
      AppMethodBeat.o(124394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mv
 * JD-Core Version:    0.7.0.1
 */