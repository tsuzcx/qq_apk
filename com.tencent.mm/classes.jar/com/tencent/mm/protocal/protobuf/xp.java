package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xp
  extends esc
{
  public String Oiv;
  public int Okk;
  public String Okl;
  public String VBL;
  public int ZfZ;
  public LinkedList<dok> Zgg;
  public dok Zgh;
  public String Zgi;
  public boolean Zgj;
  public String Zgk;
  public int Zgl;
  public dot Zgm;
  public eme Zgn;
  public String Zgo;
  public String Zgp;
  public String Zgq;
  public ejd Zgr;
  public ejd Zgs;
  public ejd Zgt;
  public com.tencent.mm.bx.b Zgu;
  public int hAV;
  public String pHt;
  public String pHu;
  public String url;
  
  public xp()
  {
    AppMethodBeat.i(91406);
    this.Zgg = new LinkedList();
    AppMethodBeat.o(91406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91407);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91407);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      paramVarArgs.e(3, 8, this.Zgg);
      if (this.Zgh != null)
      {
        paramVarArgs.qD(4, this.Zgh.computeSize());
        this.Zgh.writeFields(paramVarArgs);
      }
      if (this.VBL != null) {
        paramVarArgs.g(5, this.VBL);
      }
      if (this.Zgi != null) {
        paramVarArgs.g(6, this.Zgi);
      }
      paramVarArgs.di(7, this.Zgj);
      paramVarArgs.bS(8, this.Okk);
      if (this.Zgk != null) {
        paramVarArgs.g(9, this.Zgk);
      }
      if (this.Oiv != null) {
        paramVarArgs.g(10, this.Oiv);
      }
      if (this.Okl != null) {
        paramVarArgs.g(11, this.Okl);
      }
      paramVarArgs.bS(12, this.Zgl);
      if (this.Zgm != null)
      {
        paramVarArgs.qD(13, this.Zgm.computeSize());
        this.Zgm.writeFields(paramVarArgs);
      }
      if (this.Zgn != null)
      {
        paramVarArgs.qD(14, this.Zgn.computeSize());
        this.Zgn.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(15, this.hAV);
      paramVarArgs.bS(16, this.ZfZ);
      if (this.pHt != null) {
        paramVarArgs.g(17, this.pHt);
      }
      if (this.pHu != null) {
        paramVarArgs.g(18, this.pHu);
      }
      if (this.Zgo != null) {
        paramVarArgs.g(19, this.Zgo);
      }
      if (this.Zgp != null) {
        paramVarArgs.g(20, this.Zgp);
      }
      if (this.Zgq != null) {
        paramVarArgs.g(21, this.Zgq);
      }
      if (this.Zgr != null)
      {
        paramVarArgs.qD(22, this.Zgr.computeSize());
        this.Zgr.writeFields(paramVarArgs);
      }
      if (this.Zgs != null)
      {
        paramVarArgs.qD(23, this.Zgs.computeSize());
        this.Zgs.writeFields(paramVarArgs);
      }
      if (this.Zgt != null)
      {
        paramVarArgs.qD(24, this.Zgt.computeSize());
        this.Zgt.writeFields(paramVarArgs);
      }
      if (this.Zgu != null) {
        paramVarArgs.d(25, this.Zgu);
      }
      AppMethodBeat.o(91407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2218;
      }
    }
    label2218:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.url);
      }
      i += i.a.a.a.c(3, 8, this.Zgg);
      paramInt = i;
      if (this.Zgh != null) {
        paramInt = i + i.a.a.a.qC(4, this.Zgh.computeSize());
      }
      i = paramInt;
      if (this.VBL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.VBL);
      }
      paramInt = i;
      if (this.Zgi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zgi);
      }
      i = paramInt + (i.a.a.b.b.a.ko(7) + 1) + i.a.a.b.b.a.cJ(8, this.Okk);
      paramInt = i;
      if (this.Zgk != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Zgk);
      }
      i = paramInt;
      if (this.Oiv != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.Oiv);
      }
      paramInt = i;
      if (this.Okl != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Okl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.Zgl);
      paramInt = i;
      if (this.Zgm != null) {
        paramInt = i + i.a.a.a.qC(13, this.Zgm.computeSize());
      }
      i = paramInt;
      if (this.Zgn != null) {
        i = paramInt + i.a.a.a.qC(14, this.Zgn.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(15, this.hAV) + i.a.a.b.b.a.cJ(16, this.ZfZ);
      paramInt = i;
      if (this.pHt != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.pHt);
      }
      i = paramInt;
      if (this.pHu != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.pHu);
      }
      paramInt = i;
      if (this.Zgo != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.Zgo);
      }
      i = paramInt;
      if (this.Zgp != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.Zgp);
      }
      paramInt = i;
      if (this.Zgq != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.Zgq);
      }
      i = paramInt;
      if (this.Zgr != null) {
        i = paramInt + i.a.a.a.qC(22, this.Zgr.computeSize());
      }
      paramInt = i;
      if (this.Zgs != null) {
        paramInt = i + i.a.a.a.qC(23, this.Zgs.computeSize());
      }
      i = paramInt;
      if (this.Zgt != null) {
        i = paramInt + i.a.a.a.qC(24, this.Zgt.computeSize());
      }
      paramInt = i;
      if (this.Zgu != null) {
        paramInt = i + i.a.a.b.b.a.c(25, this.Zgu);
      }
      AppMethodBeat.o(91407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zgg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91407);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        xp localxp = (xp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91407);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localxp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 2: 
          localxp.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dok();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dok)localObject2).parseFrom((byte[])localObject1);
            }
            localxp.Zgg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dok();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dok)localObject2).parseFrom((byte[])localObject1);
            }
            localxp.Zgh = ((dok)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 5: 
          localxp.VBL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 6: 
          localxp.Zgi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 7: 
          localxp.Zgj = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91407);
          return 0;
        case 8: 
          localxp.Okk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91407);
          return 0;
        case 9: 
          localxp.Zgk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 10: 
          localxp.Oiv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 11: 
          localxp.Okl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 12: 
          localxp.Zgl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91407);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dot();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dot)localObject2).parseFrom((byte[])localObject1);
            }
            localxp.Zgm = ((dot)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eme();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eme)localObject2).parseFrom((byte[])localObject1);
            }
            localxp.Zgn = ((eme)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 15: 
          localxp.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91407);
          return 0;
        case 16: 
          localxp.ZfZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91407);
          return 0;
        case 17: 
          localxp.pHt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 18: 
          localxp.pHu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 19: 
          localxp.Zgo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 20: 
          localxp.Zgp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 21: 
          localxp.Zgq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejd)localObject2).parseFrom((byte[])localObject1);
            }
            localxp.Zgr = ((ejd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejd)localObject2).parseFrom((byte[])localObject1);
            }
            localxp.Zgs = ((ejd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 24: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejd)localObject2).parseFrom((byte[])localObject1);
            }
            localxp.Zgt = ((ejd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        }
        localxp.Zgu = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(91407);
        return 0;
      }
      AppMethodBeat.o(91407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xp
 * JD-Core Version:    0.7.0.1
 */