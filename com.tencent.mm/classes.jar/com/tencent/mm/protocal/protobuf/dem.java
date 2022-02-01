package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dem
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int FIY;
  public int FIZ;
  public String FNa;
  public String FNb;
  public int FNd;
  public def FNl;
  public long Id;
  public int IsNotRichText;
  public String ThumbUrl;
  public String hkR;
  public int ndI;
  public String tlJ;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Id);
      if (this.tlK != null) {
        paramVarArgs.d(2, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(3, this.tlJ);
      }
      if (this.FNa != null) {
        paramVarArgs.d(4, this.FNa);
      }
      if (this.FNb != null) {
        paramVarArgs.d(5, this.FNb);
      }
      if (this.hkR != null) {
        paramVarArgs.d(6, this.hkR);
      }
      paramVarArgs.aR(7, this.ndI);
      paramVarArgs.aR(8, this.CreateTime);
      paramVarArgs.aR(9, this.FIZ);
      paramVarArgs.aR(10, this.FIY);
      paramVarArgs.aR(11, this.IsNotRichText);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(12, this.ThumbUrl);
      }
      if (this.FNl != null)
      {
        paramVarArgs.ln(13, this.FNl.computeSize());
        this.FNl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.FNd);
      AppMethodBeat.o(118472);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tlK);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlJ);
      }
      paramInt = i;
      if (this.FNa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNa);
      }
      i = paramInt;
      if (this.FNb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FNb);
      }
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hkR);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.ndI) + f.a.a.b.b.a.bx(8, this.CreateTime) + f.a.a.b.b.a.bx(9, this.FIZ) + f.a.a.b.b.a.bx(10, this.FIY) + f.a.a.b.b.a.bx(11, this.IsNotRichText);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ThumbUrl);
      }
      i = paramInt;
      if (this.FNl != null) {
        i = paramInt + f.a.a.a.lm(13, this.FNl.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(14, this.FNd);
      AppMethodBeat.o(118472);
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
      AppMethodBeat.o(118472);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dem localdem = (dem)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118472);
        return -1;
      case 1: 
        localdem.Id = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(118472);
        return 0;
      case 2: 
        localdem.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 3: 
        localdem.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 4: 
        localdem.FNa = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 5: 
        localdem.FNb = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 6: 
        localdem.hkR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 7: 
        localdem.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118472);
        return 0;
      case 8: 
        localdem.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118472);
        return 0;
      case 9: 
        localdem.FIZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118472);
        return 0;
      case 10: 
        localdem.FIY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118472);
        return 0;
      case 11: 
        localdem.IsNotRichText = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118472);
        return 0;
      case 12: 
        localdem.ThumbUrl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118472);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new def();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((def)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdem.FNl = ((def)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118472);
        return 0;
      }
      localdem.FNd = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(118472);
      return 0;
    }
    AppMethodBeat.o(118472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dem
 * JD-Core Version:    0.7.0.1
 */