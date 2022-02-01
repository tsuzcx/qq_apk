package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azg
  extends com.tencent.mm.bw.a
{
  public int LBx;
  public int LBy;
  public int LBz;
  public int LCj;
  public int LCk;
  public app LCl;
  public int LIY;
  public int LIZ;
  public int LJa;
  public int LJb;
  public int LJc;
  public int LJd;
  public String country;
  public String coverImgUrl;
  public int fuA;
  public String fuJ;
  public String fuK;
  public String iAR;
  public String nickname;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169015);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.e(1, this.nickname);
      }
      if (this.signature != null) {
        paramVarArgs.e(2, this.signature);
      }
      if (this.coverImgUrl != null) {
        paramVarArgs.e(3, this.coverImgUrl);
      }
      if (this.iAR != null) {
        paramVarArgs.e(4, this.iAR);
      }
      if (this.country != null) {
        paramVarArgs.e(5, this.country);
      }
      if (this.fuJ != null) {
        paramVarArgs.e(6, this.fuJ);
      }
      if (this.fuK != null) {
        paramVarArgs.e(7, this.fuK);
      }
      paramVarArgs.aM(8, this.fuA);
      paramVarArgs.aM(9, this.LBx);
      paramVarArgs.aM(10, this.LBy);
      paramVarArgs.aM(11, this.LBz);
      paramVarArgs.aM(12, this.LCj);
      paramVarArgs.aM(13, this.LCk);
      paramVarArgs.aM(14, this.LIY);
      paramVarArgs.aM(15, this.LIZ);
      paramVarArgs.aM(16, this.LJa);
      paramVarArgs.aM(17, this.LJb);
      if (this.LCl != null)
      {
        paramVarArgs.ni(18, this.LCl.computeSize());
        this.LCl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(19, this.LJc);
      paramVarArgs.aM(20, this.LJd);
      AppMethodBeat.o(169015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label1274;
      }
    }
    label1274:
    for (int i = g.a.a.b.b.a.f(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.signature);
      }
      i = paramInt;
      if (this.coverImgUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.coverImgUrl);
      }
      paramInt = i;
      if (this.iAR != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iAR);
      }
      i = paramInt;
      if (this.country != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.country);
      }
      paramInt = i;
      if (this.fuJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.fuJ);
      }
      i = paramInt;
      if (this.fuK != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.fuK);
      }
      i = i + g.a.a.b.b.a.bu(8, this.fuA) + g.a.a.b.b.a.bu(9, this.LBx) + g.a.a.b.b.a.bu(10, this.LBy) + g.a.a.b.b.a.bu(11, this.LBz) + g.a.a.b.b.a.bu(12, this.LCj) + g.a.a.b.b.a.bu(13, this.LCk) + g.a.a.b.b.a.bu(14, this.LIY) + g.a.a.b.b.a.bu(15, this.LIZ) + g.a.a.b.b.a.bu(16, this.LJa) + g.a.a.b.b.a.bu(17, this.LJb);
      paramInt = i;
      if (this.LCl != null) {
        paramInt = i + g.a.a.a.nh(18, this.LCl.computeSize());
      }
      i = g.a.a.b.b.a.bu(19, this.LJc);
      int j = g.a.a.b.b.a.bu(20, this.LJd);
      AppMethodBeat.o(169015);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azg localazg = (azg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169015);
          return -1;
        case 1: 
          localazg.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 2: 
          localazg.signature = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 3: 
          localazg.coverImgUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 4: 
          localazg.iAR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 5: 
          localazg.country = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 6: 
          localazg.fuJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 7: 
          localazg.fuK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169015);
          return 0;
        case 8: 
          localazg.fuA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 9: 
          localazg.LBx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 10: 
          localazg.LBy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 11: 
          localazg.LBz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 12: 
          localazg.LCj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 13: 
          localazg.LCk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 14: 
          localazg.LIY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 15: 
          localazg.LIZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 16: 
          localazg.LJa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 17: 
          localazg.LJb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new app();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((app)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localazg.LCl = ((app)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169015);
          return 0;
        case 19: 
          localazg.LJc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169015);
          return 0;
        }
        localazg.LJd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169015);
        return 0;
      }
      AppMethodBeat.o(169015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azg
 * JD-Core Version:    0.7.0.1
 */