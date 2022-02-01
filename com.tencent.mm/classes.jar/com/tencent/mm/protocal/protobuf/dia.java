package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dia
  extends dpc
{
  public LinkedList<l> KBx;
  public dvf MMH;
  public n MMI;
  public int dDN;
  public long eht;
  public String jTB;
  public String jTD;
  public String jTz;
  public String qwn;
  public String remark;
  
  public dia()
  {
    AppMethodBeat.i(91649);
    this.dDN = 268513600;
    this.qwn = "请求不成功，请稍候再试";
    this.KBx = new LinkedList();
    AppMethodBeat.o(91649);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91650);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91650);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      paramVarArgs.bb(4, this.eht);
      if (this.jTz != null) {
        paramVarArgs.e(5, this.jTz);
      }
      paramVarArgs.e(6, 8, this.KBx);
      if (this.jTB != null) {
        paramVarArgs.e(7, this.jTB);
      }
      if (this.remark != null) {
        paramVarArgs.e(8, this.remark);
      }
      if (this.MMH != null)
      {
        paramVarArgs.ni(9, this.MMH.computeSize());
        this.MMH.writeFields(paramVarArgs);
      }
      if (this.jTD != null) {
        paramVarArgs.e(10, this.jTD);
      }
      if (this.MMI != null)
      {
        paramVarArgs.ni(11, this.MMI.computeSize());
        this.MMI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.eht);
      paramInt = i;
      if (this.jTz != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.jTz);
      }
      i = paramInt + g.a.a.a.c(6, 8, this.KBx);
      paramInt = i;
      if (this.jTB != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.jTB);
      }
      i = paramInt;
      if (this.remark != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.remark);
      }
      paramInt = i;
      if (this.MMH != null) {
        paramInt = i + g.a.a.a.nh(9, this.MMH.computeSize());
      }
      i = paramInt;
      if (this.jTD != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.jTD);
      }
      paramInt = i;
      if (this.MMI != null) {
        paramInt = i + g.a.a.a.nh(11, this.MMI.computeSize());
      }
      AppMethodBeat.o(91650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KBx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91650);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91650);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dia localdia = (dia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91650);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdia.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 2: 
          localdia.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91650);
          return 0;
        case 3: 
          localdia.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 4: 
          localdia.eht = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91650);
          return 0;
        case 5: 
          localdia.jTz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdia.KBx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 7: 
          localdia.jTB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 8: 
          localdia.remark = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdia.MMH = ((dvf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 10: 
          localdia.jTD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91650);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new n();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((n)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdia.MMI = ((n)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91650);
        return 0;
      }
      AppMethodBeat.o(91650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dia
 * JD-Core Version:    0.7.0.1
 */