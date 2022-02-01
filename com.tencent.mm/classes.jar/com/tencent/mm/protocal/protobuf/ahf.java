package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahf
  extends com.tencent.mm.bw.a
{
  public String DWF;
  public ahg EBB;
  public String ddo;
  public int duration;
  public int hgY = -1;
  public int hgZ;
  public int hha = 0;
  public int hhb;
  public int hhc;
  public String hhd;
  public String hkV;
  public String hld;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127467);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.hgY);
      paramVarArgs.aR(2, this.hha);
      paramVarArgs.aR(3, this.videoWidth);
      paramVarArgs.aR(4, this.videoHeight);
      paramVarArgs.aR(5, this.hgZ);
      paramVarArgs.aR(6, this.duration);
      if (this.hhd != null) {
        paramVarArgs.d(7, this.hhd);
      }
      if (this.ddo != null) {
        paramVarArgs.d(8, this.ddo);
      }
      if (this.hkV != null) {
        paramVarArgs.d(9, this.hkV);
      }
      paramVarArgs.aR(10, this.hhc);
      if (this.EBB != null)
      {
        paramVarArgs.ln(11, this.EBB.computeSize());
        this.EBB.writeFields(paramVarArgs);
      }
      if (this.hld != null) {
        paramVarArgs.d(12, this.hld);
      }
      if (this.DWF != null) {
        paramVarArgs.d(13, this.DWF);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(14, this.videoUrl);
      }
      paramVarArgs.aR(15, this.hhb);
      AppMethodBeat.o(127467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.hgY) + 0 + f.a.a.b.b.a.bx(2, this.hha) + f.a.a.b.b.a.bx(3, this.videoWidth) + f.a.a.b.b.a.bx(4, this.videoHeight) + f.a.a.b.b.a.bx(5, this.hgZ) + f.a.a.b.b.a.bx(6, this.duration);
      paramInt = i;
      if (this.hhd != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hhd);
      }
      i = paramInt;
      if (this.ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ddo);
      }
      paramInt = i;
      if (this.hkV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hkV);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.hhc);
      paramInt = i;
      if (this.EBB != null) {
        paramInt = i + f.a.a.a.lm(11, this.EBB.computeSize());
      }
      i = paramInt;
      if (this.hld != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.hld);
      }
      paramInt = i;
      if (this.DWF != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DWF);
      }
      i = paramInt;
      if (this.videoUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.videoUrl);
      }
      paramInt = f.a.a.b.b.a.bx(15, this.hhb);
      AppMethodBeat.o(127467);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ahf localahf = (ahf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127467);
        return -1;
      case 1: 
        localahf.hgY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127467);
        return 0;
      case 2: 
        localahf.hha = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127467);
        return 0;
      case 3: 
        localahf.videoWidth = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127467);
        return 0;
      case 4: 
        localahf.videoHeight = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127467);
        return 0;
      case 5: 
        localahf.hgZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127467);
        return 0;
      case 6: 
        localahf.duration = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127467);
        return 0;
      case 7: 
        localahf.hhd = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 8: 
        localahf.ddo = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 9: 
        localahf.hkV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 10: 
        localahf.hhc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127467);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahf.EBB = ((ahg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127467);
        return 0;
      case 12: 
        localahf.hld = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 13: 
        localahf.DWF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 14: 
        localahf.videoUrl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127467);
        return 0;
      }
      localahf.hhb = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(127467);
      return 0;
    }
    AppMethodBeat.o(127467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahf
 * JD-Core Version:    0.7.0.1
 */