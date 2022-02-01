package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amt
  extends com.tencent.mm.bw.a
{
  public String KOe;
  public amu LxS;
  public String dHc;
  public int duration;
  public String iAg;
  public String iAo;
  public int iwc = -1;
  public int iwd;
  public int iwe = 0;
  public int iwf;
  public int iwg;
  public String vid;
  public int videoHeight;
  public String videoUrl;
  public int videoWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127467);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.iwc);
      paramVarArgs.aM(2, this.iwe);
      paramVarArgs.aM(3, this.videoWidth);
      paramVarArgs.aM(4, this.videoHeight);
      paramVarArgs.aM(5, this.iwd);
      paramVarArgs.aM(6, this.duration);
      if (this.vid != null) {
        paramVarArgs.e(7, this.vid);
      }
      if (this.dHc != null) {
        paramVarArgs.e(8, this.dHc);
      }
      if (this.iAg != null) {
        paramVarArgs.e(9, this.iAg);
      }
      paramVarArgs.aM(10, this.iwg);
      if (this.LxS != null)
      {
        paramVarArgs.ni(11, this.LxS.computeSize());
        this.LxS.writeFields(paramVarArgs);
      }
      if (this.iAo != null) {
        paramVarArgs.e(12, this.iAo);
      }
      if (this.KOe != null) {
        paramVarArgs.e(13, this.KOe);
      }
      if (this.videoUrl != null) {
        paramVarArgs.e(14, this.videoUrl);
      }
      paramVarArgs.aM(15, this.iwf);
      AppMethodBeat.o(127467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.iwc) + 0 + g.a.a.b.b.a.bu(2, this.iwe) + g.a.a.b.b.a.bu(3, this.videoWidth) + g.a.a.b.b.a.bu(4, this.videoHeight) + g.a.a.b.b.a.bu(5, this.iwd) + g.a.a.b.b.a.bu(6, this.duration);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.vid);
      }
      i = paramInt;
      if (this.dHc != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.dHc);
      }
      paramInt = i;
      if (this.iAg != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.iAg);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.iwg);
      paramInt = i;
      if (this.LxS != null) {
        paramInt = i + g.a.a.a.nh(11, this.LxS.computeSize());
      }
      i = paramInt;
      if (this.iAo != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.iAo);
      }
      paramInt = i;
      if (this.KOe != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KOe);
      }
      i = paramInt;
      if (this.videoUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.videoUrl);
      }
      paramInt = g.a.a.b.b.a.bu(15, this.iwf);
      AppMethodBeat.o(127467);
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
      AppMethodBeat.o(127467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      amt localamt = (amt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127467);
        return -1;
      case 1: 
        localamt.iwc = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127467);
        return 0;
      case 2: 
        localamt.iwe = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127467);
        return 0;
      case 3: 
        localamt.videoWidth = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127467);
        return 0;
      case 4: 
        localamt.videoHeight = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127467);
        return 0;
      case 5: 
        localamt.iwd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127467);
        return 0;
      case 6: 
        localamt.duration = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127467);
        return 0;
      case 7: 
        localamt.vid = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 8: 
        localamt.dHc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 9: 
        localamt.iAg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 10: 
        localamt.iwg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127467);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new amu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((amu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localamt.LxS = ((amu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127467);
        return 0;
      case 12: 
        localamt.iAo = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 13: 
        localamt.KOe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127467);
        return 0;
      case 14: 
        localamt.videoUrl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(127467);
        return 0;
      }
      localamt.iwf = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(127467);
      return 0;
    }
    AppMethodBeat.o(127467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amt
 * JD-Core Version:    0.7.0.1
 */