package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cso
  extends com.tencent.mm.bw.a
{
  public String Djf;
  public String MxA;
  public String MxB;
  public String MxC;
  public String MxD;
  public String Mxy;
  public String Mxz;
  public String appId;
  public String dSF;
  public css jfy;
  public String lDR;
  public String lDS;
  public int musicType;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208709);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfy != null)
      {
        paramVarArgs.ni(1, this.jfy.computeSize());
        this.jfy.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.musicType);
      if (this.Djf != null) {
        paramVarArgs.e(3, this.Djf);
      }
      if (this.name != null) {
        paramVarArgs.e(4, this.name);
      }
      if (this.lDR != null) {
        paramVarArgs.e(5, this.lDR);
      }
      if (this.lDS != null) {
        paramVarArgs.e(6, this.lDS);
      }
      if (this.Mxy != null) {
        paramVarArgs.e(7, this.Mxy);
      }
      if (this.Mxz != null) {
        paramVarArgs.e(8, this.Mxz);
      }
      if (this.dSF != null) {
        paramVarArgs.e(9, this.dSF);
      }
      if (this.MxA != null) {
        paramVarArgs.e(10, this.MxA);
      }
      if (this.MxB != null) {
        paramVarArgs.e(11, this.MxB);
      }
      if (this.MxC != null) {
        paramVarArgs.e(12, this.MxC);
      }
      if (this.appId != null) {
        paramVarArgs.e(13, this.appId);
      }
      if (this.MxD != null) {
        paramVarArgs.e(14, this.MxD);
      }
      AppMethodBeat.o(208709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfy == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = g.a.a.a.nh(1, this.jfy.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.musicType);
      paramInt = i;
      if (this.Djf != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Djf);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.name);
      }
      paramInt = i;
      if (this.lDR != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.lDR);
      }
      i = paramInt;
      if (this.lDS != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.lDS);
      }
      paramInt = i;
      if (this.Mxy != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Mxy);
      }
      i = paramInt;
      if (this.Mxz != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Mxz);
      }
      paramInt = i;
      if (this.dSF != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.dSF);
      }
      i = paramInt;
      if (this.MxA != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MxA);
      }
      paramInt = i;
      if (this.MxB != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MxB);
      }
      i = paramInt;
      if (this.MxC != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MxC);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.appId);
      }
      i = paramInt;
      if (this.MxD != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MxD);
      }
      AppMethodBeat.o(208709);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(208709);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cso localcso = (cso)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(208709);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new css();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((css)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcso.jfy = ((css)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(208709);
          return 0;
        case 2: 
          localcso.musicType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(208709);
          return 0;
        case 3: 
          localcso.Djf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 4: 
          localcso.name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 5: 
          localcso.lDR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 6: 
          localcso.lDS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 7: 
          localcso.Mxy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 8: 
          localcso.Mxz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 9: 
          localcso.dSF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 10: 
          localcso.MxA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 11: 
          localcso.MxB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 12: 
          localcso.MxC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        case 13: 
          localcso.appId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(208709);
          return 0;
        }
        localcso.MxD = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(208709);
        return 0;
      }
      AppMethodBeat.o(208709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cso
 * JD-Core Version:    0.7.0.1
 */