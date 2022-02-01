package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgb
  extends com.tencent.mm.bw.a
{
  public LinkedList<dvg> LPI;
  public dvg LPJ;
  public LinkedList<bga> LPK;
  public boolean LPL;
  public String LPM;
  public long LPN;
  public String dRM;
  public boolean vtY;
  
  public bgb()
  {
    AppMethodBeat.i(122501);
    this.LPI = new LinkedList();
    this.LPK = new LinkedList();
    this.LPL = false;
    this.vtY = false;
    AppMethodBeat.o(122501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122502);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dRM != null) {
        paramVarArgs.e(1, this.dRM);
      }
      paramVarArgs.e(2, 8, this.LPI);
      if (this.LPJ != null)
      {
        paramVarArgs.ni(3, this.LPJ.computeSize());
        this.LPJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.LPK);
      paramVarArgs.cc(5, this.LPL);
      paramVarArgs.cc(6, this.vtY);
      if (this.LPM != null) {
        paramVarArgs.e(7, this.LPM);
      }
      paramVarArgs.bb(8, this.LPN);
      AppMethodBeat.o(122502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dRM == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = g.a.a.b.b.a.f(1, this.dRM) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LPI);
      paramInt = i;
      if (this.LPJ != null) {
        paramInt = i + g.a.a.a.nh(3, this.LPJ.computeSize());
      }
      i = paramInt + g.a.a.a.c(4, 8, this.LPK) + (g.a.a.b.b.a.fS(5) + 1) + (g.a.a.b.b.a.fS(6) + 1);
      paramInt = i;
      if (this.LPM != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LPM);
      }
      i = g.a.a.b.b.a.r(8, this.LPN);
      AppMethodBeat.o(122502);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LPI.clear();
        this.LPK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgb localbgb = (bgb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122502);
          return -1;
        case 1: 
          localbgb.dRM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122502);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgb.LPI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgb.LPJ = ((dvg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bga();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bga)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgb.LPK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122502);
          return 0;
        case 5: 
          localbgb.LPL = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122502);
          return 0;
        case 6: 
          localbgb.vtY = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(122502);
          return 0;
        case 7: 
          localbgb.LPM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122502);
          return 0;
        }
        localbgb.LPN = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(122502);
        return 0;
      }
      AppMethodBeat.o(122502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgb
 * JD-Core Version:    0.7.0.1
 */