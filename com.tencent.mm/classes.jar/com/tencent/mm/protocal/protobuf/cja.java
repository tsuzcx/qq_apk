package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cja
  extends com.tencent.mm.bw.a
{
  public String MnU;
  public String MnV;
  public int MnW;
  public int MnX;
  public long MnY;
  public long MnZ;
  public LinkedList<vh> Moa;
  public int Mob;
  public LinkedList<String> Moc;
  public String Mod;
  public int Moe;
  public int Mof;
  public int Mog;
  public int Moh;
  public int Moi;
  
  public cja()
  {
    AppMethodBeat.i(196380);
    this.Moa = new LinkedList();
    this.Moc = new LinkedList();
    AppMethodBeat.o(196380);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196381);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MnU != null) {
        paramVarArgs.e(1, this.MnU);
      }
      if (this.MnV != null) {
        paramVarArgs.e(2, this.MnV);
      }
      paramVarArgs.aM(3, this.MnW);
      paramVarArgs.aM(4, this.MnX);
      paramVarArgs.bb(5, this.MnY);
      paramVarArgs.bb(6, this.MnZ);
      paramVarArgs.e(7, 8, this.Moa);
      paramVarArgs.aM(8, this.Mob);
      paramVarArgs.e(9, 1, this.Moc);
      if (this.Mod != null) {
        paramVarArgs.e(10, this.Mod);
      }
      paramVarArgs.aM(11, this.Moe);
      paramVarArgs.aM(12, this.Mof);
      paramVarArgs.aM(13, this.Mog);
      paramVarArgs.aM(14, this.Moh);
      paramVarArgs.aM(15, this.Moi);
      AppMethodBeat.o(196381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MnU == null) {
        break label990;
      }
    }
    label990:
    for (paramInt = g.a.a.b.b.a.f(1, this.MnU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MnV != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MnV);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MnW) + g.a.a.b.b.a.bu(4, this.MnX) + g.a.a.b.b.a.r(5, this.MnY) + g.a.a.b.b.a.r(6, this.MnZ) + g.a.a.a.c(7, 8, this.Moa) + g.a.a.b.b.a.bu(8, this.Mob) + g.a.a.a.c(9, 1, this.Moc);
      paramInt = i;
      if (this.Mod != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Mod);
      }
      i = g.a.a.b.b.a.bu(11, this.Moe);
      int j = g.a.a.b.b.a.bu(12, this.Mof);
      int k = g.a.a.b.b.a.bu(13, this.Mog);
      int m = g.a.a.b.b.a.bu(14, this.Moh);
      int n = g.a.a.b.b.a.bu(15, this.Moi);
      AppMethodBeat.o(196381);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Moa.clear();
        this.Moc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196381);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cja localcja = (cja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196381);
          return -1;
        case 1: 
          localcja.MnU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196381);
          return 0;
        case 2: 
          localcja.MnV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196381);
          return 0;
        case 3: 
          localcja.MnW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(196381);
          return 0;
        case 4: 
          localcja.MnX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(196381);
          return 0;
        case 5: 
          localcja.MnY = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(196381);
          return 0;
        case 6: 
          localcja.MnZ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(196381);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((vh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcja.Moa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196381);
          return 0;
        case 8: 
          localcja.Mob = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(196381);
          return 0;
        case 9: 
          localcja.Moc.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(196381);
          return 0;
        case 10: 
          localcja.Mod = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(196381);
          return 0;
        case 11: 
          localcja.Moe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(196381);
          return 0;
        case 12: 
          localcja.Mof = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(196381);
          return 0;
        case 13: 
          localcja.Mog = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(196381);
          return 0;
        case 14: 
          localcja.Moh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(196381);
          return 0;
        }
        localcja.Moi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(196381);
        return 0;
      }
      AppMethodBeat.o(196381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cja
 * JD-Core Version:    0.7.0.1
 */