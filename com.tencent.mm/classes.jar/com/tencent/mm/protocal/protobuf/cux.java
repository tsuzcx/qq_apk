package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cux
  extends dpc
{
  public String HuS;
  public cki MAb;
  public String MAc;
  public amh MAd;
  public int MAf;
  public int MAg;
  public int MAh;
  public LinkedList<ahq> MAi;
  public LinkedList<dlw> MAj;
  public LinkedList<jf> MAk;
  public dde MAl;
  public int MAm;
  public String MAn;
  public ddd MAo;
  public ddd MAp;
  public String MAq;
  public acl MAr;
  public ddd MAs;
  public boolean Mma;
  public ckj efB;
  public int pTZ;
  public String pUa;
  
  public cux()
  {
    AppMethodBeat.i(91561);
    this.MAi = new LinkedList();
    this.MAj = new LinkedList();
    this.MAk = new LinkedList();
    AppMethodBeat.o(91561);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91562);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.aM(4, this.MAf);
      paramVarArgs.aM(5, this.MAg);
      paramVarArgs.aM(6, this.MAh);
      paramVarArgs.e(8, 8, this.MAi);
      if (this.MAb != null)
      {
        paramVarArgs.ni(9, this.MAb.computeSize());
        this.MAb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.MAj);
      paramVarArgs.e(11, 8, this.MAk);
      paramVarArgs.cc(12, this.Mma);
      if (this.MAl != null)
      {
        paramVarArgs.ni(13, this.MAl.computeSize());
        this.MAl.writeFields(paramVarArgs);
      }
      if (this.MAc != null) {
        paramVarArgs.e(14, this.MAc);
      }
      if (this.MAd != null)
      {
        paramVarArgs.ni(15, this.MAd.computeSize());
        this.MAd.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(16, this.MAm);
      if (this.MAn != null) {
        paramVarArgs.e(17, this.MAn);
      }
      if (this.MAo != null)
      {
        paramVarArgs.ni(18, this.MAo.computeSize());
        this.MAo.writeFields(paramVarArgs);
      }
      if (this.MAp != null)
      {
        paramVarArgs.ni(19, this.MAp.computeSize());
        this.MAp.writeFields(paramVarArgs);
      }
      if (this.MAq != null) {
        paramVarArgs.e(20, this.MAq);
      }
      if (this.MAr != null)
      {
        paramVarArgs.ni(21, this.MAr.computeSize());
        this.MAr.writeFields(paramVarArgs);
      }
      if (this.MAs != null)
      {
        paramVarArgs.ni(22, this.MAs.computeSize());
        this.MAs.writeFields(paramVarArgs);
      }
      if (this.efB != null)
      {
        paramVarArgs.ni(99, this.efB.computeSize());
        this.efB.writeFields(paramVarArgs);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2686;
      }
    }
    label2686:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.MAf) + g.a.a.b.b.a.bu(5, this.MAg) + g.a.a.b.b.a.bu(6, this.MAh) + g.a.a.a.c(8, 8, this.MAi);
      paramInt = i;
      if (this.MAb != null) {
        paramInt = i + g.a.a.a.nh(9, this.MAb.computeSize());
      }
      i = paramInt + g.a.a.a.c(10, 8, this.MAj) + g.a.a.a.c(11, 8, this.MAk) + (g.a.a.b.b.a.fS(12) + 1);
      paramInt = i;
      if (this.MAl != null) {
        paramInt = i + g.a.a.a.nh(13, this.MAl.computeSize());
      }
      i = paramInt;
      if (this.MAc != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MAc);
      }
      paramInt = i;
      if (this.MAd != null) {
        paramInt = i + g.a.a.a.nh(15, this.MAd.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.MAm);
      paramInt = i;
      if (this.MAn != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.MAn);
      }
      i = paramInt;
      if (this.MAo != null) {
        i = paramInt + g.a.a.a.nh(18, this.MAo.computeSize());
      }
      paramInt = i;
      if (this.MAp != null) {
        paramInt = i + g.a.a.a.nh(19, this.MAp.computeSize());
      }
      i = paramInt;
      if (this.MAq != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.MAq);
      }
      paramInt = i;
      if (this.MAr != null) {
        paramInt = i + g.a.a.a.nh(21, this.MAr.computeSize());
      }
      i = paramInt;
      if (this.MAs != null) {
        i = paramInt + g.a.a.a.nh(22, this.MAs.computeSize());
      }
      paramInt = i;
      if (this.efB != null) {
        paramInt = i + g.a.a.a.nh(99, this.efB.computeSize());
      }
      i = paramInt;
      if (this.HuS != null) {
        i = paramInt + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MAi.clear();
        this.MAj.clear();
        this.MAk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cux localcux = (cux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91562);
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
            localcux.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 2: 
          localcux.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91562);
          return 0;
        case 3: 
          localcux.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 4: 
          localcux.MAf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91562);
          return 0;
        case 5: 
          localcux.MAg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91562);
          return 0;
        case 6: 
          localcux.MAh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91562);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cki();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cki)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAb = ((cki)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 12: 
          localcux.Mma = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(91562);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dde();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dde)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAl = ((dde)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 14: 
          localcux.MAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAd = ((amh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 16: 
          localcux.MAm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91562);
          return 0;
        case 17: 
          localcux.MAn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAo = ((ddd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAp = ((ddd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 20: 
          localcux.MAq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAr = ((acl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.MAs = ((ddd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcux.efB = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        }
        localcux.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91562);
        return 0;
      }
      AppMethodBeat.o(91562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cux
 * JD-Core Version:    0.7.0.1
 */