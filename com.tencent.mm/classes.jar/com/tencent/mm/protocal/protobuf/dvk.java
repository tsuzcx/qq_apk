package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvk
  extends com.tencent.mm.bw.a
{
  public String LPM;
  public long LPN;
  public LinkedList<dvg> MWr;
  public int index;
  public String sGF;
  public int type;
  public boolean vtY;
  
  public dvk()
  {
    AppMethodBeat.i(169384);
    this.MWr = new LinkedList();
    this.vtY = false;
    this.type = 0;
    this.index = -1;
    AppMethodBeat.o(169384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169385);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sGF != null) {
        paramVarArgs.e(1, this.sGF);
      }
      paramVarArgs.bb(2, this.LPN);
      paramVarArgs.e(3, 8, this.MWr);
      if (this.LPM != null) {
        paramVarArgs.e(4, this.LPM);
      }
      paramVarArgs.cc(5, this.vtY);
      paramVarArgs.aM(6, this.type);
      paramVarArgs.aM(7, this.index);
      AppMethodBeat.o(169385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGF == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.b.b.a.f(1, this.sGF) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LPN) + g.a.a.a.c(3, 8, this.MWr);
      paramInt = i;
      if (this.LPM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LPM);
      }
      i = g.a.a.b.b.a.fS(5);
      int j = g.a.a.b.b.a.bu(6, this.type);
      int k = g.a.a.b.b.a.bu(7, this.index);
      AppMethodBeat.o(169385);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MWr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvk localdvk = (dvk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169385);
          return -1;
        case 1: 
          localdvk.sGF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 2: 
          localdvk.LPN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169385);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dvg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdvk.MWr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169385);
          return 0;
        case 4: 
          localdvk.LPM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 5: 
          localdvk.vtY = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(169385);
          return 0;
        case 6: 
          localdvk.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169385);
          return 0;
        }
        localdvk.index = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169385);
        return 0;
      }
      AppMethodBeat.o(169385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvk
 * JD-Core Version:    0.7.0.1
 */