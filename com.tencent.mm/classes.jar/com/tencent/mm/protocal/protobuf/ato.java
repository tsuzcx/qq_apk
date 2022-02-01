package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ato
  extends dop
{
  public aov LAI;
  public apc LAv;
  public String LEp;
  public String LEq;
  public aoz LEr;
  public atn LEs;
  public String LEt;
  public b LEu;
  public efo LEv;
  public LinkedList<ecq> LEw;
  public buj LEx;
  public int dLS;
  public float dTj;
  public String dkU;
  public String dkV;
  public long hFK;
  public b lastBuffer;
  public float latitude;
  public String objectNonceId;
  public int scene;
  public blo tVd;
  public bcc tvs;
  public b txf;
  
  public ato()
  {
    AppMethodBeat.i(209452);
    this.LEw = new LinkedList();
    AppMethodBeat.o(209452);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.bb(4, this.hFK);
      paramVarArgs.aM(5, this.dLS);
      paramVarArgs.E(6, this.dTj);
      paramVarArgs.E(7, this.latitude);
      if (this.objectNonceId != null) {
        paramVarArgs.e(8, this.objectNonceId);
      }
      if (this.LEp != null) {
        paramVarArgs.e(9, this.LEp);
      }
      paramVarArgs.aM(10, this.scene);
      if (this.LEq != null) {
        paramVarArgs.e(11, this.LEq);
      }
      if (this.tvs != null)
      {
        paramVarArgs.ni(12, this.tvs.computeSize());
        this.tvs.writeFields(paramVarArgs);
      }
      if (this.LEr != null)
      {
        paramVarArgs.ni(13, this.LEr.computeSize());
        this.LEr.writeFields(paramVarArgs);
      }
      if (this.txf != null) {
        paramVarArgs.c(14, this.txf);
      }
      if (this.LAv != null)
      {
        paramVarArgs.ni(15, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      if (this.dkU != null) {
        paramVarArgs.e(16, this.dkU);
      }
      if (this.dkV != null) {
        paramVarArgs.e(17, this.dkV);
      }
      if (this.LEs != null)
      {
        paramVarArgs.ni(18, this.LEs.computeSize());
        this.LEs.writeFields(paramVarArgs);
      }
      if (this.LEt != null) {
        paramVarArgs.e(19, this.LEt);
      }
      if (this.LEu != null) {
        paramVarArgs.c(20, this.LEu);
      }
      if (this.LEv != null)
      {
        paramVarArgs.ni(21, this.LEv.computeSize());
        this.LEv.writeFields(paramVarArgs);
      }
      if (this.tVd != null)
      {
        paramVarArgs.ni(22, this.tVd.computeSize());
        this.tVd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.LEw);
      if (this.LEx != null)
      {
        paramVarArgs.ni(24, this.LEx.computeSize());
        this.LEx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2476;
      }
    }
    label2476:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAI != null) {
        paramInt = i + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = i + g.a.a.b.b.a.r(4, this.hFK) + g.a.a.b.b.a.bu(5, this.dLS) + (g.a.a.b.b.a.fS(6) + 4) + (g.a.a.b.b.a.fS(7) + 4);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.LEp != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LEp);
      }
      i += g.a.a.b.b.a.bu(10, this.scene);
      paramInt = i;
      if (this.LEq != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LEq);
      }
      i = paramInt;
      if (this.tvs != null) {
        i = paramInt + g.a.a.a.nh(12, this.tvs.computeSize());
      }
      paramInt = i;
      if (this.LEr != null) {
        paramInt = i + g.a.a.a.nh(13, this.LEr.computeSize());
      }
      i = paramInt;
      if (this.txf != null) {
        i = paramInt + g.a.a.b.b.a.b(14, this.txf);
      }
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(15, this.LAv.computeSize());
      }
      i = paramInt;
      if (this.dkU != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.dkU);
      }
      paramInt = i;
      if (this.dkV != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.dkV);
      }
      i = paramInt;
      if (this.LEs != null) {
        i = paramInt + g.a.a.a.nh(18, this.LEs.computeSize());
      }
      paramInt = i;
      if (this.LEt != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.LEt);
      }
      i = paramInt;
      if (this.LEu != null) {
        i = paramInt + g.a.a.b.b.a.b(20, this.LEu);
      }
      paramInt = i;
      if (this.LEv != null) {
        paramInt = i + g.a.a.a.nh(21, this.LEv.computeSize());
      }
      i = paramInt;
      if (this.tVd != null) {
        i = paramInt + g.a.a.a.nh(22, this.tVd.computeSize());
      }
      i += g.a.a.a.c(23, 8, this.LEw);
      paramInt = i;
      if (this.LEx != null) {
        paramInt = i + g.a.a.a.nh(24, this.LEx.computeSize());
      }
      AppMethodBeat.o(209453);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LEw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ato localato = (ato)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209453);
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
            localato.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localato.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        case 3: 
          localato.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209453);
          return 0;
        case 4: 
          localato.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209453);
          return 0;
        case 5: 
          localato.dLS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209453);
          return 0;
        case 6: 
          localato.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209453);
          return 0;
        case 7: 
          localato.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(209453);
          return 0;
        case 8: 
          localato.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209453);
          return 0;
        case 9: 
          localato.LEp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209453);
          return 0;
        case 10: 
          localato.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209453);
          return 0;
        case 11: 
          localato.LEq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209453);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localato.tvs = ((bcc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localato.LEr = ((aoz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        case 14: 
          localato.txf = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209453);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localato.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        case 16: 
          localato.dkU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209453);
          return 0;
        case 17: 
          localato.dkV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209453);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localato.LEs = ((atn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        case 19: 
          localato.LEt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209453);
          return 0;
        case 20: 
          localato.LEu = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209453);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localato.LEv = ((efo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localato.tVd = ((blo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localato.LEw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209453);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localato.LEx = ((buj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209453);
        return 0;
      }
      AppMethodBeat.o(209453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ato
 * JD-Core Version:    0.7.0.1
 */