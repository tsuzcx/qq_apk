package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class atu
  extends dop
{
  public apc LAv;
  public aov LCA;
  public b LDs;
  public eiz LEE;
  public b LEF;
  public int dLS;
  public String dST;
  public float dTj;
  public int fromType;
  public float latitude;
  public int tTH;
  public String tTQ;
  public long trn;
  public int tvC;
  public bcc tvs;
  public long twp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168990);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LCA != null)
      {
        paramVarArgs.ni(2, this.LCA.computeSize());
        this.LCA.writeFields(paramVarArgs);
      }
      if (this.LDs != null) {
        paramVarArgs.c(3, this.LDs);
      }
      paramVarArgs.aM(4, this.tvC);
      if (this.dST != null) {
        paramVarArgs.e(5, this.dST);
      }
      paramVarArgs.E(6, this.dTj);
      paramVarArgs.E(7, this.latitude);
      paramVarArgs.bb(8, this.trn);
      paramVarArgs.aM(9, this.dLS);
      if (this.LEE != null)
      {
        paramVarArgs.ni(10, this.LEE.computeSize());
        this.LEE.writeFields(paramVarArgs);
      }
      if (this.tvs != null)
      {
        paramVarArgs.ni(11, this.tvs.computeSize());
        this.tvs.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.fromType);
      if (this.LAv != null)
      {
        paramVarArgs.ni(13, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(14, this.twp);
      if (this.LEF != null) {
        paramVarArgs.c(15, this.LEF);
      }
      if (this.tTQ != null) {
        paramVarArgs.e(16, this.tTQ);
      }
      paramVarArgs.aM(17, this.tTH);
      AppMethodBeat.o(168990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1540;
      }
    }
    label1540:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LCA != null) {
        paramInt = i + g.a.a.a.nh(2, this.LCA.computeSize());
      }
      i = paramInt;
      if (this.LDs != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LDs);
      }
      i += g.a.a.b.b.a.bu(4, this.tvC);
      paramInt = i;
      if (this.dST != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dST);
      }
      i = paramInt + (g.a.a.b.b.a.fS(6) + 4) + (g.a.a.b.b.a.fS(7) + 4) + g.a.a.b.b.a.r(8, this.trn) + g.a.a.b.b.a.bu(9, this.dLS);
      paramInt = i;
      if (this.LEE != null) {
        paramInt = i + g.a.a.a.nh(10, this.LEE.computeSize());
      }
      i = paramInt;
      if (this.tvs != null) {
        i = paramInt + g.a.a.a.nh(11, this.tvs.computeSize());
      }
      i += g.a.a.b.b.a.bu(12, this.fromType);
      paramInt = i;
      if (this.LAv != null) {
        paramInt = i + g.a.a.a.nh(13, this.LAv.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(14, this.twp);
      paramInt = i;
      if (this.LEF != null) {
        paramInt = i + g.a.a.b.b.a.b(15, this.LEF);
      }
      i = paramInt;
      if (this.tTQ != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.tTQ);
      }
      paramInt = g.a.a.b.b.a.bu(17, this.tTH);
      AppMethodBeat.o(168990);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atu localatu = (atu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168990);
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
            localatu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
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
            localatu.LCA = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 3: 
          localatu.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168990);
          return 0;
        case 4: 
          localatu.tvC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168990);
          return 0;
        case 5: 
          localatu.dST = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168990);
          return 0;
        case 6: 
          localatu.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(168990);
          return 0;
        case 7: 
          localatu.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(168990);
          return 0;
        case 8: 
          localatu.trn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168990);
          return 0;
        case 9: 
          localatu.dLS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168990);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localatu.LEE = ((eiz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localatu.tvs = ((bcc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 12: 
          localatu.fromType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168990);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localatu.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 14: 
          localatu.twp = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168990);
          return 0;
        case 15: 
          localatu.LEF = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168990);
          return 0;
        case 16: 
          localatu.tTQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168990);
          return 0;
        }
        localatu.tTH = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168990);
        return 0;
      }
      AppMethodBeat.o(168990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atu
 * JD-Core Version:    0.7.0.1
 */