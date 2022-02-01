package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvo
  extends dop
{
  public String HQc;
  public String KPu;
  public String KPv;
  public boolean MAR;
  public String MAS;
  public String MAT;
  public int MAU;
  public String MAV;
  public String dDj;
  public int dUS;
  public int eaQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72530);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KPu != null) {
        paramVarArgs.e(2, this.KPu);
      }
      if (this.KPv != null) {
        paramVarArgs.e(3, this.KPv);
      }
      if (this.MAS != null) {
        paramVarArgs.e(4, this.MAS);
      }
      if (this.MAT != null) {
        paramVarArgs.e(5, this.MAT);
      }
      if (this.HQc != null) {
        paramVarArgs.e(6, this.HQc);
      }
      if (this.dDj != null) {
        paramVarArgs.e(7, this.dDj);
      }
      paramVarArgs.aM(8, this.dUS);
      paramVarArgs.aM(9, this.MAU);
      paramVarArgs.cc(10, this.MAR);
      paramVarArgs.aM(11, this.eaQ);
      if (this.MAV != null) {
        paramVarArgs.e(12, this.MAV);
      }
      AppMethodBeat.o(72530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KPu != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KPu);
      }
      i = paramInt;
      if (this.KPv != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KPv);
      }
      paramInt = i;
      if (this.MAS != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MAS);
      }
      i = paramInt;
      if (this.MAT != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MAT);
      }
      paramInt = i;
      if (this.HQc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.HQc);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.dDj);
      }
      i = i + g.a.a.b.b.a.bu(8, this.dUS) + g.a.a.b.b.a.bu(9, this.MAU) + (g.a.a.b.b.a.fS(10) + 1) + g.a.a.b.b.a.bu(11, this.eaQ);
      paramInt = i;
      if (this.MAV != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MAV);
      }
      AppMethodBeat.o(72530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvo localcvo = (cvo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72530);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcvo.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72530);
          return 0;
        case 2: 
          localcvo.KPu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 3: 
          localcvo.KPv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 4: 
          localcvo.MAS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 5: 
          localcvo.MAT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 6: 
          localcvo.HQc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 7: 
          localcvo.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 8: 
          localcvo.dUS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72530);
          return 0;
        case 9: 
          localcvo.MAU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72530);
          return 0;
        case 10: 
          localcvo.MAR = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72530);
          return 0;
        case 11: 
          localcvo.eaQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72530);
          return 0;
        }
        localcvo.MAV = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72530);
        return 0;
      }
      AppMethodBeat.o(72530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvo
 * JD-Core Version:    0.7.0.1
 */