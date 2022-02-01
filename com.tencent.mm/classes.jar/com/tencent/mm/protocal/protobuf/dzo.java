package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzo
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int DeleteFlag;
  public int IsNotRichText;
  public int MYS;
  public int MYT;
  public long MYU;
  public long MYV;
  public int MYX;
  public LinkedList<dzu> MYY;
  public int MYZ;
  public String MZm;
  public String Nickname;
  public String Username;
  public String iAc;
  public int oUv;
  public int xub;
  
  public dzo()
  {
    AppMethodBeat.i(125778);
    this.MYY = new LinkedList();
    AppMethodBeat.o(125778);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125779);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.e(2, this.Nickname);
      }
      paramVarArgs.aM(3, this.xub);
      paramVarArgs.aM(4, this.oUv);
      if (this.iAc != null) {
        paramVarArgs.e(5, this.iAc);
      }
      paramVarArgs.aM(6, this.CreateTime);
      paramVarArgs.aM(7, this.MYT);
      paramVarArgs.aM(8, this.MYS);
      if (this.MZm != null) {
        paramVarArgs.e(9, this.MZm);
      }
      paramVarArgs.aM(10, this.IsNotRichText);
      paramVarArgs.bb(11, this.MYU);
      paramVarArgs.bb(12, this.MYV);
      paramVarArgs.aM(13, this.DeleteFlag);
      paramVarArgs.aM(14, this.MYX);
      paramVarArgs.e(15, 8, this.MYY);
      paramVarArgs.aM(16, this.MYZ);
      AppMethodBeat.o(125779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1050;
      }
    }
    label1050:
    for (paramInt = g.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Nickname);
      }
      i = i + g.a.a.b.b.a.bu(3, this.xub) + g.a.a.b.b.a.bu(4, this.oUv);
      paramInt = i;
      if (this.iAc != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.iAc);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.CreateTime) + g.a.a.b.b.a.bu(7, this.MYT) + g.a.a.b.b.a.bu(8, this.MYS);
      paramInt = i;
      if (this.MZm != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MZm);
      }
      i = g.a.a.b.b.a.bu(10, this.IsNotRichText);
      int j = g.a.a.b.b.a.r(11, this.MYU);
      int k = g.a.a.b.b.a.r(12, this.MYV);
      int m = g.a.a.b.b.a.bu(13, this.DeleteFlag);
      int n = g.a.a.b.b.a.bu(14, this.MYX);
      int i1 = g.a.a.a.c(15, 8, this.MYY);
      int i2 = g.a.a.b.b.a.bu(16, this.MYZ);
      AppMethodBeat.o(125779);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MYY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125779);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzo localdzo = (dzo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125779);
          return -1;
        case 1: 
          localdzo.Username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 2: 
          localdzo.Nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 3: 
          localdzo.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125779);
          return 0;
        case 4: 
          localdzo.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125779);
          return 0;
        case 5: 
          localdzo.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 6: 
          localdzo.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125779);
          return 0;
        case 7: 
          localdzo.MYT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125779);
          return 0;
        case 8: 
          localdzo.MYS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125779);
          return 0;
        case 9: 
          localdzo.MZm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 10: 
          localdzo.IsNotRichText = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125779);
          return 0;
        case 11: 
          localdzo.MYU = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125779);
          return 0;
        case 12: 
          localdzo.MYV = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125779);
          return 0;
        case 13: 
          localdzo.DeleteFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125779);
          return 0;
        case 14: 
          localdzo.MYX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125779);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dzu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdzo.MYY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125779);
          return 0;
        }
        localdzo.MYZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125779);
        return 0;
      }
      AppMethodBeat.o(125779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzo
 * JD-Core Version:    0.7.0.1
 */