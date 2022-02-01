package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oa
  extends com.tencent.mm.bw.a
{
  public LinkedList<ob> KTC;
  public int KTD;
  public String KTm;
  public int KTn;
  public String KTr;
  public String KTu;
  public String gTH;
  public String pWm;
  public int ver;
  
  public oa()
  {
    AppMethodBeat.i(212231);
    this.KTC = new LinkedList();
    AppMethodBeat.o(212231);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTu != null) {
        paramVarArgs.e(1, this.KTu);
      }
      if (this.pWm != null) {
        paramVarArgs.e(2, this.pWm);
      }
      paramVarArgs.aM(3, this.ver);
      if (this.KTm != null) {
        paramVarArgs.e(4, this.KTm);
      }
      if (this.gTH != null) {
        paramVarArgs.e(5, this.gTH);
      }
      paramVarArgs.aM(6, this.KTn);
      if (this.KTr != null) {
        paramVarArgs.e(7, this.KTr);
      }
      paramVarArgs.e(8, 8, this.KTC);
      paramVarArgs.aM(9, this.KTD);
      AppMethodBeat.o(124425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KTu == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.b.b.a.f(1, this.KTu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pWm != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pWm);
      }
      i += g.a.a.b.b.a.bu(3, this.ver);
      paramInt = i;
      if (this.KTm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KTm);
      }
      i = paramInt;
      if (this.gTH != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.gTH);
      }
      i += g.a.a.b.b.a.bu(6, this.KTn);
      paramInt = i;
      if (this.KTr != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KTr);
      }
      i = g.a.a.a.c(8, 8, this.KTC);
      int j = g.a.a.b.b.a.bu(9, this.KTD);
      AppMethodBeat.o(124425);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KTC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        oa localoa = (oa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124425);
          return -1;
        case 1: 
          localoa.KTu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 2: 
          localoa.pWm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 3: 
          localoa.ver = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124425);
          return 0;
        case 4: 
          localoa.KTm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 5: 
          localoa.gTH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 6: 
          localoa.KTn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124425);
          return 0;
        case 7: 
          localoa.KTr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ob();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ob)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localoa.KTC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124425);
          return 0;
        }
        localoa.KTD = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124425);
        return 0;
      }
      AppMethodBeat.o(124425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oa
 * JD-Core Version:    0.7.0.1
 */