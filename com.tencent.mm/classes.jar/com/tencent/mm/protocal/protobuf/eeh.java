package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eeh
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public long Id;
  public int IsNotRichText;
  public int MYS;
  public int MYT;
  public String NdA;
  public String NdB;
  public int NdD;
  public eea NdL;
  public String ThumbUrl;
  public String iAc;
  public int oUv;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118472);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Id);
      if (this.xNH != null) {
        paramVarArgs.e(2, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(3, this.xNG);
      }
      if (this.NdA != null) {
        paramVarArgs.e(4, this.NdA);
      }
      if (this.NdB != null) {
        paramVarArgs.e(5, this.NdB);
      }
      if (this.iAc != null) {
        paramVarArgs.e(6, this.iAc);
      }
      paramVarArgs.aM(7, this.oUv);
      paramVarArgs.aM(8, this.CreateTime);
      paramVarArgs.aM(9, this.MYT);
      paramVarArgs.aM(10, this.MYS);
      paramVarArgs.aM(11, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.e(12, this.ThumbUrl);
      }
      if (this.NdL != null)
      {
        paramVarArgs.ni(13, this.NdL.computeSize());
        this.NdL.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.NdD);
      AppMethodBeat.o(118472);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Id) + 0;
      paramInt = i;
      if (this.xNH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xNH);
      }
      i = paramInt;
      if (this.xNG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xNG);
      }
      paramInt = i;
      if (this.NdA != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NdA);
      }
      i = paramInt;
      if (this.NdB != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.NdB);
      }
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.iAc);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.oUv) + g.a.a.b.b.a.bu(8, this.CreateTime) + g.a.a.b.b.a.bu(9, this.MYT) + g.a.a.b.b.a.bu(10, this.MYS) + g.a.a.b.b.a.bu(11, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.ThumbUrl);
      }
      i = paramInt;
      if (this.NdL != null) {
        i = paramInt + g.a.a.a.nh(13, this.NdL.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(14, this.NdD);
      AppMethodBeat.o(118472);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(118472);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eeh localeeh = (eeh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118472);
        return -1;
      case 1: 
        localeeh.Id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(118472);
        return 0;
      case 2: 
        localeeh.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 3: 
        localeeh.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 4: 
        localeeh.NdA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 5: 
        localeeh.NdB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 6: 
        localeeh.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 7: 
        localeeh.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118472);
        return 0;
      case 8: 
        localeeh.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118472);
        return 0;
      case 9: 
        localeeh.MYT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118472);
        return 0;
      case 10: 
        localeeh.MYS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118472);
        return 0;
      case 11: 
        localeeh.IsNotRichText = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118472);
        return 0;
      case 12: 
        localeeh.ThumbUrl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eea();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eea)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeeh.NdL = ((eea)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118472);
        return 0;
      }
      localeeh.NdD = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(118472);
      return 0;
    }
    AppMethodBeat.o(118472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eeh
 * JD-Core Version:    0.7.0.1
 */