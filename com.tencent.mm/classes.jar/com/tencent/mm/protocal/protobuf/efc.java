package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efc
  extends com.tencent.mm.bw.a
{
  public String KSV;
  public LinkedList<cgj> KZi;
  public String Mqy;
  public int NeU;
  public int NeV;
  public int NeW;
  public int NeX;
  public int NeY;
  public int NeZ;
  public int Nfa;
  public String Nfb;
  public String Nfc;
  public int Nfd;
  public String Title;
  
  public efc()
  {
    AppMethodBeat.i(152702);
    this.KZi = new LinkedList();
    AppMethodBeat.o(152702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152703);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mqy != null) {
        paramVarArgs.e(1, this.Mqy);
      }
      paramVarArgs.aM(2, this.NeU);
      paramVarArgs.aM(3, this.NeV);
      paramVarArgs.aM(4, this.NeW);
      paramVarArgs.aM(5, this.NeX);
      if (this.Title != null) {
        paramVarArgs.e(6, this.Title);
      }
      paramVarArgs.e(7, 8, this.KZi);
      paramVarArgs.aM(8, this.NeY);
      if (this.KSV != null) {
        paramVarArgs.e(9, this.KSV);
      }
      paramVarArgs.aM(10, this.NeZ);
      paramVarArgs.aM(11, this.Nfa);
      if (this.Nfb != null) {
        paramVarArgs.e(12, this.Nfb);
      }
      if (this.Nfc != null) {
        paramVarArgs.e(13, this.Nfc);
      }
      paramVarArgs.aM(14, this.Nfd);
      AppMethodBeat.o(152703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mqy == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mqy) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.NeU) + g.a.a.b.b.a.bu(3, this.NeV) + g.a.a.b.b.a.bu(4, this.NeW) + g.a.a.b.b.a.bu(5, this.NeX);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Title);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.KZi) + g.a.a.b.b.a.bu(8, this.NeY);
      paramInt = i;
      if (this.KSV != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KSV);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.NeZ) + g.a.a.b.b.a.bu(11, this.Nfa);
      paramInt = i;
      if (this.Nfb != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Nfb);
      }
      i = paramInt;
      if (this.Nfc != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.Nfc);
      }
      paramInt = g.a.a.b.b.a.bu(14, this.Nfd);
      AppMethodBeat.o(152703);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KZi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        efc localefc = (efc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152703);
          return -1;
        case 1: 
          localefc.Mqy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 2: 
          localefc.NeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152703);
          return 0;
        case 3: 
          localefc.NeV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152703);
          return 0;
        case 4: 
          localefc.NeW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152703);
          return 0;
        case 5: 
          localefc.NeX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152703);
          return 0;
        case 6: 
          localefc.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cgj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefc.KZi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152703);
          return 0;
        case 8: 
          localefc.NeY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152703);
          return 0;
        case 9: 
          localefc.KSV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 10: 
          localefc.NeZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152703);
          return 0;
        case 11: 
          localefc.Nfa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152703);
          return 0;
        case 12: 
          localefc.Nfb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 13: 
          localefc.Nfc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152703);
          return 0;
        }
        localefc.Nfd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152703);
        return 0;
      }
      AppMethodBeat.o(152703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efc
 * JD-Core Version:    0.7.0.1
 */