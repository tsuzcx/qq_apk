package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abm
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FNK;
  public String Gtg;
  public String Gth;
  public int Gti;
  public int Gtj;
  public String Gtk;
  public int Gtl;
  public String Gtm;
  public String Gtn;
  public int Gto;
  public int Gtp;
  public LinkedList<cwz> Gtq;
  public String Gtr;
  public int Gts;
  public int Gtt;
  public int Gtu;
  public int Gtv;
  public int jfV;
  public String jga;
  public String nIJ;
  public String nJO;
  public String uvT;
  
  public abm()
  {
    AppMethodBeat.i(32174);
    this.Gtq = new LinkedList();
    AppMethodBeat.o(32174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(32175);
        throw paramVarArgs;
      }
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.Gtg != null) {
        paramVarArgs.d(3, this.Gtg);
      }
      if (this.Gth != null) {
        paramVarArgs.d(4, this.Gth);
      }
      paramVarArgs.aS(5, this.jfV);
      if (this.FNK != null)
      {
        paramVarArgs.lJ(6, this.FNK.computeSize());
        this.FNK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Gti);
      paramVarArgs.aS(8, this.Gtj);
      if (this.Gtk != null) {
        paramVarArgs.d(9, this.Gtk);
      }
      paramVarArgs.aS(10, this.Gtl);
      if (this.Gtm != null) {
        paramVarArgs.d(11, this.Gtm);
      }
      if (this.Gtn != null) {
        paramVarArgs.d(12, this.Gtn);
      }
      paramVarArgs.aS(13, this.Gto);
      paramVarArgs.aS(14, this.Gtp);
      paramVarArgs.e(15, 8, this.Gtq);
      if (this.Gtr != null) {
        paramVarArgs.d(16, this.Gtr);
      }
      paramVarArgs.aS(17, this.Gts);
      paramVarArgs.aS(18, this.Gtt);
      if (this.uvT != null) {
        paramVarArgs.d(19, this.uvT);
      }
      paramVarArgs.aS(20, this.Gtu);
      paramVarArgs.aS(21, this.Gtv);
      if (this.jga != null) {
        paramVarArgs.d(22, this.jga);
      }
      AppMethodBeat.o(32175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label1594;
      }
    }
    label1594:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.Gtg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gtg);
      }
      paramInt = i;
      if (this.Gth != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gth);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jfV);
      paramInt = i;
      if (this.FNK != null) {
        paramInt = i + f.a.a.a.lI(6, this.FNK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Gti) + f.a.a.b.b.a.bz(8, this.Gtj);
      paramInt = i;
      if (this.Gtk != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gtk);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.Gtl);
      paramInt = i;
      if (this.Gtm != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Gtm);
      }
      i = paramInt;
      if (this.Gtn != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Gtn);
      }
      i = i + f.a.a.b.b.a.bz(13, this.Gto) + f.a.a.b.b.a.bz(14, this.Gtp) + f.a.a.a.c(15, 8, this.Gtq);
      paramInt = i;
      if (this.Gtr != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Gtr);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.Gts) + f.a.a.b.b.a.bz(18, this.Gtt);
      paramInt = i;
      if (this.uvT != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.uvT);
      }
      i = paramInt + f.a.a.b.b.a.bz(20, this.Gtu) + f.a.a.b.b.a.bz(21, this.Gtv);
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.jga);
      }
      AppMethodBeat.o(32175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gtq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FNK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(32175);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32175);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abm localabm = (abm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32175);
          return -1;
        case 1: 
          localabm.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 2: 
          localabm.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 3: 
          localabm.Gtg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 4: 
          localabm.Gth = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 5: 
          localabm.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabm.FNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 7: 
          localabm.Gti = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 8: 
          localabm.Gtj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 9: 
          localabm.Gtk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 10: 
          localabm.Gtl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 11: 
          localabm.Gtm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 12: 
          localabm.Gtn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 13: 
          localabm.Gto = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 14: 
          localabm.Gtp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabm.Gtq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 16: 
          localabm.Gtr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 17: 
          localabm.Gts = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 18: 
          localabm.Gtt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 19: 
          localabm.uvT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 20: 
          localabm.Gtu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 21: 
          localabm.Gtv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32175);
          return 0;
        }
        localabm.jga = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32175);
        return 0;
      }
      AppMethodBeat.o(32175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abm
 * JD-Core Version:    0.7.0.1
 */