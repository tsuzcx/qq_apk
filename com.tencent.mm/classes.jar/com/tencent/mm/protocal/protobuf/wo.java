package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wo
  extends dop
{
  public String CpD;
  public String LhF;
  public String LhG;
  public int LhH;
  public String LhI;
  public String LhJ;
  public String LhK;
  public String LhL;
  public int LhM;
  public String Lhz;
  public int channel;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LhF == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_name");
        AppMethodBeat.o(72437);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LhF != null) {
        paramVarArgs.e(2, this.LhF);
      }
      paramVarArgs.aM(3, this.yRL);
      if (this.LhG != null) {
        paramVarArgs.e(4, this.LhG);
      }
      if (this.CpD != null) {
        paramVarArgs.e(5, this.CpD);
      }
      paramVarArgs.aM(6, this.LhH);
      paramVarArgs.aM(7, this.channel);
      if (this.LhI != null) {
        paramVarArgs.e(8, this.LhI);
      }
      if (this.Lhz != null) {
        paramVarArgs.e(9, this.Lhz);
      }
      if (this.LhJ != null) {
        paramVarArgs.e(10, this.LhJ);
      }
      if (this.LhK != null) {
        paramVarArgs.e(11, this.LhK);
      }
      if (this.LhL != null) {
        paramVarArgs.e(12, this.LhL);
      }
      paramVarArgs.aM(13, this.LhM);
      AppMethodBeat.o(72437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LhF != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LhF);
      }
      i += g.a.a.b.b.a.bu(3, this.yRL);
      paramInt = i;
      if (this.LhG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LhG);
      }
      i = paramInt;
      if (this.CpD != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.CpD);
      }
      i = i + g.a.a.b.b.a.bu(6, this.LhH) + g.a.a.b.b.a.bu(7, this.channel);
      paramInt = i;
      if (this.LhI != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LhI);
      }
      i = paramInt;
      if (this.Lhz != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Lhz);
      }
      paramInt = i;
      if (this.LhJ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LhJ);
      }
      i = paramInt;
      if (this.LhK != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LhK);
      }
      paramInt = i;
      if (this.LhL != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.LhL);
      }
      i = g.a.a.b.b.a.bu(13, this.LhM);
      AppMethodBeat.o(72437);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LhF == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_name");
          AppMethodBeat.o(72437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wo localwo = (wo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72437);
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
            localwo.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72437);
          return 0;
        case 2: 
          localwo.LhF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 3: 
          localwo.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72437);
          return 0;
        case 4: 
          localwo.LhG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 5: 
          localwo.CpD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 6: 
          localwo.LhH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72437);
          return 0;
        case 7: 
          localwo.channel = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72437);
          return 0;
        case 8: 
          localwo.LhI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 9: 
          localwo.Lhz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 10: 
          localwo.LhJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 11: 
          localwo.LhK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72437);
          return 0;
        case 12: 
          localwo.LhL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72437);
          return 0;
        }
        localwo.LhM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72437);
        return 0;
      }
      AppMethodBeat.o(72437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wo
 * JD-Core Version:    0.7.0.1
 */