package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vx
  extends dyy
{
  public int ImU;
  public String ImV;
  public String ImW;
  public String OMa;
  public int ShT;
  public LinkedList<cxf> Sia;
  public cxf Sib;
  public String Sic;
  public boolean Sid;
  public String Sie;
  public int Sif;
  public cxo Sig;
  public dtj Sih;
  public String Sii;
  public String Sij;
  public String Sik;
  public dqi Sil;
  public dqi Sim;
  public dqi Sin;
  public com.tencent.mm.cd.b Sio;
  public int fwx;
  public String mKL;
  public String mKM;
  public String url;
  
  public vx()
  {
    AppMethodBeat.i(91406);
    this.Sia = new LinkedList();
    AppMethodBeat.o(91406);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91407);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91407);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      paramVarArgs.e(3, 8, this.Sia);
      if (this.Sib != null)
      {
        paramVarArgs.oE(4, this.Sib.computeSize());
        this.Sib.writeFields(paramVarArgs);
      }
      if (this.OMa != null) {
        paramVarArgs.f(5, this.OMa);
      }
      if (this.Sic != null) {
        paramVarArgs.f(6, this.Sic);
      }
      paramVarArgs.co(7, this.Sid);
      paramVarArgs.aY(8, this.ImU);
      if (this.Sie != null) {
        paramVarArgs.f(9, this.Sie);
      }
      if (this.ImV != null) {
        paramVarArgs.f(10, this.ImV);
      }
      if (this.ImW != null) {
        paramVarArgs.f(11, this.ImW);
      }
      paramVarArgs.aY(12, this.Sif);
      if (this.Sig != null)
      {
        paramVarArgs.oE(13, this.Sig.computeSize());
        this.Sig.writeFields(paramVarArgs);
      }
      if (this.Sih != null)
      {
        paramVarArgs.oE(14, this.Sih.computeSize());
        this.Sih.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(15, this.fwx);
      paramVarArgs.aY(16, this.ShT);
      if (this.mKL != null) {
        paramVarArgs.f(17, this.mKL);
      }
      if (this.mKM != null) {
        paramVarArgs.f(18, this.mKM);
      }
      if (this.Sii != null) {
        paramVarArgs.f(19, this.Sii);
      }
      if (this.Sij != null) {
        paramVarArgs.f(20, this.Sij);
      }
      if (this.Sik != null) {
        paramVarArgs.f(21, this.Sik);
      }
      if (this.Sil != null)
      {
        paramVarArgs.oE(22, this.Sil.computeSize());
        this.Sil.writeFields(paramVarArgs);
      }
      if (this.Sim != null)
      {
        paramVarArgs.oE(23, this.Sim.computeSize());
        this.Sim.writeFields(paramVarArgs);
      }
      if (this.Sin != null)
      {
        paramVarArgs.oE(24, this.Sin.computeSize());
        this.Sin.writeFields(paramVarArgs);
      }
      if (this.Sio != null) {
        paramVarArgs.c(25, this.Sio);
      }
      AppMethodBeat.o(91407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2222;
      }
    }
    label2222:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.url);
      }
      i += g.a.a.a.c(3, 8, this.Sia);
      paramInt = i;
      if (this.Sib != null) {
        paramInt = i + g.a.a.a.oD(4, this.Sib.computeSize());
      }
      i = paramInt;
      if (this.OMa != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.OMa);
      }
      paramInt = i;
      if (this.Sic != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sic);
      }
      i = paramInt + (g.a.a.b.b.a.gL(7) + 1) + g.a.a.b.b.a.bM(8, this.ImU);
      paramInt = i;
      if (this.Sie != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Sie);
      }
      i = paramInt;
      if (this.ImV != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.ImV);
      }
      paramInt = i;
      if (this.ImW != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.ImW);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.Sif);
      paramInt = i;
      if (this.Sig != null) {
        paramInt = i + g.a.a.a.oD(13, this.Sig.computeSize());
      }
      i = paramInt;
      if (this.Sih != null) {
        i = paramInt + g.a.a.a.oD(14, this.Sih.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(15, this.fwx) + g.a.a.b.b.a.bM(16, this.ShT);
      paramInt = i;
      if (this.mKL != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.mKL);
      }
      i = paramInt;
      if (this.mKM != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.mKM);
      }
      paramInt = i;
      if (this.Sii != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.Sii);
      }
      i = paramInt;
      if (this.Sij != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.Sij);
      }
      paramInt = i;
      if (this.Sik != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.Sik);
      }
      i = paramInt;
      if (this.Sil != null) {
        i = paramInt + g.a.a.a.oD(22, this.Sil.computeSize());
      }
      paramInt = i;
      if (this.Sim != null) {
        paramInt = i + g.a.a.a.oD(23, this.Sim.computeSize());
      }
      i = paramInt;
      if (this.Sin != null) {
        i = paramInt + g.a.a.a.oD(24, this.Sin.computeSize());
      }
      paramInt = i;
      if (this.Sio != null) {
        paramInt = i + g.a.a.b.b.a.b(25, this.Sio);
      }
      AppMethodBeat.o(91407);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sia.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91407);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        vx localvx = (vx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91407);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localvx.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 2: 
          localvx.url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxf)localObject2).parseFrom((byte[])localObject1);
            }
            localvx.Sia.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxf)localObject2).parseFrom((byte[])localObject1);
            }
            localvx.Sib = ((cxf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 5: 
          localvx.OMa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 6: 
          localvx.Sic = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 7: 
          localvx.Sid = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91407);
          return 0;
        case 8: 
          localvx.ImU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91407);
          return 0;
        case 9: 
          localvx.Sie = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 10: 
          localvx.ImV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 11: 
          localvx.ImW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 12: 
          localvx.Sif = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91407);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxo)localObject2).parseFrom((byte[])localObject1);
            }
            localvx.Sig = ((cxo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtj)localObject2).parseFrom((byte[])localObject1);
            }
            localvx.Sih = ((dtj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 15: 
          localvx.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91407);
          return 0;
        case 16: 
          localvx.ShT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91407);
          return 0;
        case 17: 
          localvx.mKL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 18: 
          localvx.mKM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 19: 
          localvx.Sii = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 20: 
          localvx.Sij = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 21: 
          localvx.Sik = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91407);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dqi)localObject2).parseFrom((byte[])localObject1);
            }
            localvx.Sil = ((dqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dqi)localObject2).parseFrom((byte[])localObject1);
            }
            localvx.Sim = ((dqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dqi)localObject2).parseFrom((byte[])localObject1);
            }
            localvx.Sin = ((dqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91407);
          return 0;
        }
        localvx.Sio = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(91407);
        return 0;
      }
      AppMethodBeat.o(91407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vx
 * JD-Core Version:    0.7.0.1
 */