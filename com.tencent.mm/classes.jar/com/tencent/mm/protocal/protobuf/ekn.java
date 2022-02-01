package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ekn
  extends esc
{
  public LinkedList<m> YzQ;
  public eza abpy;
  public o abpz;
  public int hAV;
  public dus ign;
  public long ihV;
  public String nQU;
  public String pHx;
  public String pic_url;
  public String remark;
  public String wYI;
  
  public ekn()
  {
    AppMethodBeat.i(91649);
    this.hAV = 268513600;
    this.wYI = "请求不成功，请稍候再试";
    this.YzQ = new LinkedList();
    AppMethodBeat.o(91649);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91650);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91650);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.bv(4, this.ihV);
      if (this.nQU != null) {
        paramVarArgs.g(5, this.nQU);
      }
      paramVarArgs.e(6, 8, this.YzQ);
      if (this.pic_url != null) {
        paramVarArgs.g(7, this.pic_url);
      }
      if (this.remark != null) {
        paramVarArgs.g(8, this.remark);
      }
      if (this.abpy != null)
      {
        paramVarArgs.qD(9, this.abpy.computeSize());
        this.abpy.writeFields(paramVarArgs);
      }
      if (this.pHx != null) {
        paramVarArgs.g(10, this.pHx);
      }
      if (this.abpz != null)
      {
        paramVarArgs.qD(11, this.abpz.computeSize());
        this.abpz.writeFields(paramVarArgs);
      }
      if (this.ign != null)
      {
        paramVarArgs.qD(12, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1252;
      }
    }
    label1252:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.ihV);
      paramInt = i;
      if (this.nQU != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nQU);
      }
      i = paramInt + i.a.a.a.c(6, 8, this.YzQ);
      paramInt = i;
      if (this.pic_url != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.pic_url);
      }
      i = paramInt;
      if (this.remark != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.remark);
      }
      paramInt = i;
      if (this.abpy != null) {
        paramInt = i + i.a.a.a.qC(9, this.abpy.computeSize());
      }
      i = paramInt;
      if (this.pHx != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.pHx);
      }
      paramInt = i;
      if (this.abpz != null) {
        paramInt = i + i.a.a.a.qC(11, this.abpz.computeSize());
      }
      i = paramInt;
      if (this.ign != null) {
        i = paramInt + i.a.a.a.qC(12, this.ign.computeSize());
      }
      AppMethodBeat.o(91650);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YzQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ekn localekn = (ekn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91650);
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
            localekn.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 2: 
          localekn.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91650);
          return 0;
        case 3: 
          localekn.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 4: 
          localekn.ihV = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91650);
          return 0;
        case 5: 
          localekn.nQU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.YzQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 7: 
          localekn.pic_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 8: 
          localekn.remark = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eza();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eza)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.abpy = ((eza)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 10: 
          localekn.pHx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new o();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((o)localObject2).parseFrom((byte[])localObject1);
            }
            localekn.abpz = ((o)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dus();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dus)localObject2).parseFrom((byte[])localObject1);
          }
          localekn.ign = ((dus)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekn
 * JD-Core Version:    0.7.0.1
 */