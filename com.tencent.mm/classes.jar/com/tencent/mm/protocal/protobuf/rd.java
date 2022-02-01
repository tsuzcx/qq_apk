package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rd
  extends dop
{
  public int Coi;
  public String Coj;
  public String Cok;
  public String CpG;
  public String CpJ;
  public String KYc;
  public int KYd;
  public int channel;
  public String jTz;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91370);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.yRL);
      paramVarArgs.aM(3, this.channel);
      paramVarArgs.aM(4, this.Coi);
      if (this.KYc != null) {
        paramVarArgs.e(5, this.KYc);
      }
      if (this.CpG != null) {
        paramVarArgs.e(6, this.CpG);
      }
      if (this.Coj != null) {
        paramVarArgs.e(7, this.Coj);
      }
      if (this.CpJ != null) {
        paramVarArgs.e(8, this.CpJ);
      }
      if (this.jTz != null) {
        paramVarArgs.e(9, this.jTz);
      }
      if (this.Cok != null) {
        paramVarArgs.e(10, this.Cok);
      }
      paramVarArgs.aM(11, this.KYd);
      AppMethodBeat.o(91370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.yRL) + g.a.a.b.b.a.bu(3, this.channel) + g.a.a.b.b.a.bu(4, this.Coi);
      paramInt = i;
      if (this.KYc != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KYc);
      }
      i = paramInt;
      if (this.CpG != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.CpG);
      }
      paramInt = i;
      if (this.Coj != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Coj);
      }
      i = paramInt;
      if (this.CpJ != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.CpJ);
      }
      paramInt = i;
      if (this.jTz != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.jTz);
      }
      i = paramInt;
      if (this.Cok != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Cok);
      }
      paramInt = g.a.a.b.b.a.bu(11, this.KYd);
      AppMethodBeat.o(91370);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rd localrd = (rd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91370);
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
            localrd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91370);
          return 0;
        case 2: 
          localrd.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91370);
          return 0;
        case 3: 
          localrd.channel = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91370);
          return 0;
        case 4: 
          localrd.Coi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91370);
          return 0;
        case 5: 
          localrd.KYc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 6: 
          localrd.CpG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 7: 
          localrd.Coj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 8: 
          localrd.CpJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 9: 
          localrd.jTz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 10: 
          localrd.Cok = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91370);
          return 0;
        }
        localrd.KYd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91370);
        return 0;
      }
      AppMethodBeat.o(91370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rd
 * JD-Core Version:    0.7.0.1
 */