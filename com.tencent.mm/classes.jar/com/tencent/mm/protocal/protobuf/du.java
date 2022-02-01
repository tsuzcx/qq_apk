package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class du
  extends com.tencent.mm.bw.a
{
  public int Coi;
  public String CpJ;
  public String KHM;
  public String KHN;
  public String KHO;
  public anr KHP;
  public int KHQ;
  public int channel;
  public String jTz;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91349);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHM == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.KHO == null)
      {
        paramVarArgs = new b("Not all required fields were included: payok_checksign");
        AppMethodBeat.o(91349);
        throw paramVarArgs;
      }
      if (this.KHM != null) {
        paramVarArgs.e(1, this.KHM);
      }
      if (this.KHN != null) {
        paramVarArgs.e(2, this.KHN);
      }
      paramVarArgs.aM(3, this.channel);
      paramVarArgs.aM(4, this.Coi);
      paramVarArgs.aM(5, this.scene);
      if (this.KHO != null) {
        paramVarArgs.e(6, this.KHO);
      }
      if (this.KHP != null)
      {
        paramVarArgs.ni(7, this.KHP.computeSize());
        this.KHP.writeFields(paramVarArgs);
      }
      if (this.jTz != null) {
        paramVarArgs.e(8, this.jTz);
      }
      if (this.CpJ != null) {
        paramVarArgs.e(9, this.CpJ);
      }
      paramVarArgs.aM(10, this.KHQ);
      AppMethodBeat.o(91349);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHM == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = g.a.a.b.b.a.f(1, this.KHM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KHN != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KHN);
      }
      i = i + g.a.a.b.b.a.bu(3, this.channel) + g.a.a.b.b.a.bu(4, this.Coi) + g.a.a.b.b.a.bu(5, this.scene);
      paramInt = i;
      if (this.KHO != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KHO);
      }
      i = paramInt;
      if (this.KHP != null) {
        i = paramInt + g.a.a.a.nh(7, this.KHP.computeSize());
      }
      paramInt = i;
      if (this.jTz != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.jTz);
      }
      i = paramInt;
      if (this.CpJ != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.CpJ);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.KHQ);
      AppMethodBeat.o(91349);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHM == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        if (this.KHO == null)
        {
          paramVarArgs = new b("Not all required fields were included: payok_checksign");
          AppMethodBeat.o(91349);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91349);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        du localdu = (du)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91349);
          return -1;
        case 1: 
          localdu.KHM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 2: 
          localdu.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 3: 
          localdu.channel = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91349);
          return 0;
        case 4: 
          localdu.Coi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91349);
          return 0;
        case 5: 
          localdu.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91349);
          return 0;
        case 6: 
          localdu.KHO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((anr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdu.KHP = ((anr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91349);
          return 0;
        case 8: 
          localdu.jTz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91349);
          return 0;
        case 9: 
          localdu.CpJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91349);
          return 0;
        }
        localdu.KHQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91349);
        return 0;
      }
      AppMethodBeat.o(91349);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.du
 * JD-Core Version:    0.7.0.1
 */