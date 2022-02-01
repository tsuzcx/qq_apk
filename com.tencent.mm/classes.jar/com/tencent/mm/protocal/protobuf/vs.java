package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vs
  extends dop
{
  public int Coi;
  public String CpC;
  public String CpD;
  public String KHM;
  public String KHN;
  public String LgK;
  public String LgL;
  public int channel;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91403);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KHM != null) {
        paramVarArgs.e(2, this.KHM);
      }
      if (this.KHN != null) {
        paramVarArgs.e(3, this.KHN);
      }
      paramVarArgs.aM(4, this.yRL);
      if (this.CpD != null) {
        paramVarArgs.e(5, this.CpD);
      }
      if (this.CpC != null) {
        paramVarArgs.e(6, this.CpC);
      }
      paramVarArgs.aM(7, this.channel);
      paramVarArgs.aM(8, this.Coi);
      if (this.LgK != null) {
        paramVarArgs.e(9, this.LgK);
      }
      if (this.LgL != null) {
        paramVarArgs.e(10, this.LgL);
      }
      AppMethodBeat.o(91403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KHM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KHM);
      }
      i = paramInt;
      if (this.KHN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KHN);
      }
      i += g.a.a.b.b.a.bu(4, this.yRL);
      paramInt = i;
      if (this.CpD != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.CpD);
      }
      i = paramInt;
      if (this.CpC != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.CpC);
      }
      i = i + g.a.a.b.b.a.bu(7, this.channel) + g.a.a.b.b.a.bu(8, this.Coi);
      paramInt = i;
      if (this.LgK != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LgK);
      }
      i = paramInt;
      if (this.LgL != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LgL);
      }
      AppMethodBeat.o(91403);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        vs localvs = (vs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91403);
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
            localvs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91403);
          return 0;
        case 2: 
          localvs.KHM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 3: 
          localvs.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 4: 
          localvs.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91403);
          return 0;
        case 5: 
          localvs.CpD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 6: 
          localvs.CpC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 7: 
          localvs.channel = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91403);
          return 0;
        case 8: 
          localvs.Coi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91403);
          return 0;
        case 9: 
          localvs.LgK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91403);
          return 0;
        }
        localvs.LgL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91403);
        return 0;
      }
      AppMethodBeat.o(91403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vs
 * JD-Core Version:    0.7.0.1
 */