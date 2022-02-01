package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sv
  extends com.tencent.mm.bw.a
{
  public String FKu;
  public String GiA;
  public ti GiB;
  public String GiC;
  public String Gil;
  public String Gim;
  public String Gin;
  public String Gio;
  public String Gip;
  public LinkedList<su> Giq;
  public int Gir;
  public String Gis;
  public String Git;
  public String Giu;
  public int Giv;
  public String Giw;
  public int Gix;
  public String Giy;
  public int Giz;
  
  public sv()
  {
    AppMethodBeat.i(113951);
    this.Giq = new LinkedList();
    AppMethodBeat.o(113951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKu != null) {
        paramVarArgs.d(1, this.FKu);
      }
      if (this.Gil != null) {
        paramVarArgs.d(2, this.Gil);
      }
      if (this.Gim != null) {
        paramVarArgs.d(3, this.Gim);
      }
      if (this.Gin != null) {
        paramVarArgs.d(4, this.Gin);
      }
      if (this.Gio != null) {
        paramVarArgs.d(5, this.Gio);
      }
      if (this.Gip != null) {
        paramVarArgs.d(6, this.Gip);
      }
      paramVarArgs.e(7, 8, this.Giq);
      paramVarArgs.aS(8, this.Gir);
      if (this.Gis != null) {
        paramVarArgs.d(9, this.Gis);
      }
      if (this.Git != null) {
        paramVarArgs.d(10, this.Git);
      }
      if (this.Giu != null) {
        paramVarArgs.d(11, this.Giu);
      }
      paramVarArgs.aS(12, this.Giv);
      if (this.Giw != null) {
        paramVarArgs.d(13, this.Giw);
      }
      paramVarArgs.aS(14, this.Gix);
      if (this.Giy != null) {
        paramVarArgs.d(15, this.Giy);
      }
      paramVarArgs.aS(16, this.Giz);
      if (this.GiA != null) {
        paramVarArgs.d(17, this.GiA);
      }
      if (this.GiB != null)
      {
        paramVarArgs.lJ(18, this.GiB.computeSize());
        this.GiB.writeFields(paramVarArgs);
      }
      if (this.GiC != null) {
        paramVarArgs.d(19, this.GiC);
      }
      AppMethodBeat.o(113952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKu == null) {
        break label1434;
      }
    }
    label1434:
    for (int i = f.a.a.b.b.a.e(1, this.FKu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gil != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gil);
      }
      i = paramInt;
      if (this.Gim != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gim);
      }
      paramInt = i;
      if (this.Gin != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gin);
      }
      i = paramInt;
      if (this.Gio != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gio);
      }
      paramInt = i;
      if (this.Gip != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gip);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.Giq) + f.a.a.b.b.a.bz(8, this.Gir);
      paramInt = i;
      if (this.Gis != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gis);
      }
      i = paramInt;
      if (this.Git != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Git);
      }
      paramInt = i;
      if (this.Giu != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Giu);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.Giv);
      paramInt = i;
      if (this.Giw != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Giw);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.Gix);
      paramInt = i;
      if (this.Giy != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Giy);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.Giz);
      paramInt = i;
      if (this.GiA != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GiA);
      }
      i = paramInt;
      if (this.GiB != null) {
        i = paramInt + f.a.a.a.lI(18, this.GiB.computeSize());
      }
      paramInt = i;
      if (this.GiC != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GiC);
      }
      AppMethodBeat.o(113952);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Giq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113952);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sv localsv = (sv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113952);
          return -1;
        case 1: 
          localsv.FKu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 2: 
          localsv.Gil = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 3: 
          localsv.Gim = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 4: 
          localsv.Gin = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 5: 
          localsv.Gio = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 6: 
          localsv.Gip = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new su();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((su)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsv.Giq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 8: 
          localsv.Gir = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113952);
          return 0;
        case 9: 
          localsv.Gis = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 10: 
          localsv.Git = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 11: 
          localsv.Giu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 12: 
          localsv.Giv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113952);
          return 0;
        case 13: 
          localsv.Giw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 14: 
          localsv.Gix = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113952);
          return 0;
        case 15: 
          localsv.Giy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 16: 
          localsv.Giz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113952);
          return 0;
        case 17: 
          localsv.GiA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsv.GiB = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        }
        localsv.GiC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113952);
        return 0;
      }
      AppMethodBeat.o(113952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sv
 * JD-Core Version:    0.7.0.1
 */