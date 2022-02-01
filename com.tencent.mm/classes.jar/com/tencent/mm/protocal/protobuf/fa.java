package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fa
  extends cpx
{
  public int DRM;
  public int DRN;
  public long DRO;
  public long DRP;
  public oe DRQ;
  public int DRR;
  public int DRS;
  public int DRT;
  public String DRU;
  public int DRm;
  public int DRn;
  public String hhd;
  public int nettype;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.hhd != null) {
        paramVarArgs.d(3, this.hhd);
      }
      paramVarArgs.aR(4, this.scene);
      paramVarArgs.aR(5, this.DRn);
      paramVarArgs.aR(6, this.nettype);
      if (this.session_id != null) {
        paramVarArgs.d(7, this.session_id);
      }
      paramVarArgs.aR(8, this.DRm);
      paramVarArgs.aR(9, this.DRM);
      paramVarArgs.aR(10, this.DRN);
      paramVarArgs.aO(11, this.DRO);
      paramVarArgs.aO(12, this.DRP);
      if (this.DRQ != null)
      {
        paramVarArgs.ln(13, this.DRQ.computeSize());
        this.DRQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.DRR);
      paramVarArgs.aR(15, this.DRS);
      paramVarArgs.aR(16, this.DRT);
      if (this.DRU != null) {
        paramVarArgs.d(17, this.DRU);
      }
      AppMethodBeat.o(103194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.hhd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hhd);
      }
      i = i + f.a.a.b.b.a.bx(4, this.scene) + f.a.a.b.b.a.bx(5, this.DRn) + f.a.a.b.b.a.bx(6, this.nettype);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.session_id);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.DRm) + f.a.a.b.b.a.bx(9, this.DRM) + f.a.a.b.b.a.bx(10, this.DRN) + f.a.a.b.b.a.p(11, this.DRO) + f.a.a.b.b.a.p(12, this.DRP);
      paramInt = i;
      if (this.DRQ != null) {
        paramInt = i + f.a.a.a.lm(13, this.DRQ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(14, this.DRR) + f.a.a.b.b.a.bx(15, this.DRS) + f.a.a.b.b.a.bx(16, this.DRT);
      paramInt = i;
      if (this.DRU != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.DRU);
      }
      AppMethodBeat.o(103194);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fa localfa = (fa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103194);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfa.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 2: 
          localfa.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 3: 
          localfa.hhd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 4: 
          localfa.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        case 5: 
          localfa.DRn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        case 6: 
          localfa.nettype = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        case 7: 
          localfa.session_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 8: 
          localfa.DRm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        case 9: 
          localfa.DRM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        case 10: 
          localfa.DRN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        case 11: 
          localfa.DRO = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(103194);
          return 0;
        case 12: 
          localfa.DRP = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(103194);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfa.DRQ = ((oe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 14: 
          localfa.DRR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        case 15: 
          localfa.DRS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        case 16: 
          localfa.DRT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103194);
          return 0;
        }
        localfa.DRU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(103194);
        return 0;
      }
      AppMethodBeat.o(103194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fa
 * JD-Core Version:    0.7.0.1
 */