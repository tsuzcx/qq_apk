package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class md
  extends dop
{
  public int KMz;
  public int KPF;
  public String KPG;
  public String KPH;
  public String KPI;
  public String KPJ;
  public String KPK;
  public String KPL;
  public String KPM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KMz);
      paramVarArgs.aM(3, this.KPF);
      if (this.KPG != null) {
        paramVarArgs.e(4, this.KPG);
      }
      if (this.KPH != null) {
        paramVarArgs.e(5, this.KPH);
      }
      if (this.KPI != null) {
        paramVarArgs.e(6, this.KPI);
      }
      if (this.KPJ != null) {
        paramVarArgs.e(7, this.KPJ);
      }
      if (this.KPK != null) {
        paramVarArgs.e(8, this.KPK);
      }
      if (this.KPL != null) {
        paramVarArgs.e(9, this.KPL);
      }
      if (this.KPM != null) {
        paramVarArgs.e(10, this.KPM);
      }
      AppMethodBeat.o(155394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KMz) + g.a.a.b.b.a.bu(3, this.KPF);
      paramInt = i;
      if (this.KPG != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KPG);
      }
      i = paramInt;
      if (this.KPH != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KPH);
      }
      paramInt = i;
      if (this.KPI != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KPI);
      }
      i = paramInt;
      if (this.KPJ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KPJ);
      }
      paramInt = i;
      if (this.KPK != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KPK);
      }
      i = paramInt;
      if (this.KPL != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.KPL);
      }
      paramInt = i;
      if (this.KPM != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KPM);
      }
      AppMethodBeat.o(155394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        md localmd = (md)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155394);
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
            localmd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155394);
          return 0;
        case 2: 
          localmd.KMz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155394);
          return 0;
        case 3: 
          localmd.KPF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155394);
          return 0;
        case 4: 
          localmd.KPG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 5: 
          localmd.KPH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 6: 
          localmd.KPI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 7: 
          localmd.KPJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 8: 
          localmd.KPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 9: 
          localmd.KPL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155394);
          return 0;
        }
        localmd.KPM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(155394);
        return 0;
      }
      AppMethodBeat.o(155394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.md
 * JD-Core Version:    0.7.0.1
 */