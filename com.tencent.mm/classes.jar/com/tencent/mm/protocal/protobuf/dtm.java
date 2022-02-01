package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtm
  extends cvc
{
  public int FIg;
  public int FKC;
  public int FMu;
  public String FOL;
  public String Fvn;
  public String Fwt;
  public int GSm;
  public int Gds;
  public int Ges;
  public int HGl;
  public int HGm;
  public int ihf;
  public String uki;
  public String ukj;
  public int xbr;
  public long xbt;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148661);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148661);
        throw paramVarArgs;
      }
      if (this.ukj != null) {
        paramVarArgs.d(1, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(2, this.uki);
      }
      paramVarArgs.aS(3, this.FMu);
      paramVarArgs.aS(4, this.FIg);
      if (this.Fwt != null) {
        paramVarArgs.d(5, this.Fwt);
      }
      paramVarArgs.aS(6, this.xbr);
      paramVarArgs.aS(7, this.FKC);
      if (this.xcN != null)
      {
        paramVarArgs.lC(8, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.ihf);
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(10, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.Gds);
      if (this.Fvn != null) {
        paramVarArgs.d(12, this.Fvn);
      }
      paramVarArgs.aS(13, this.GSm);
      paramVarArgs.aS(14, this.HGl);
      paramVarArgs.aS(15, this.HGm);
      paramVarArgs.aY(16, this.xbt);
      paramVarArgs.aS(17, this.Ges);
      if (this.FOL != null) {
        paramVarArgs.d(19, this.FOL);
      }
      AppMethodBeat.o(148661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ukj == null) {
        break label1314;
      }
    }
    label1314:
    for (paramInt = f.a.a.b.b.a.e(1, this.ukj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uki);
      }
      i = i + f.a.a.b.b.a.bz(3, this.FMu) + f.a.a.b.b.a.bz(4, this.FIg);
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fwt);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.xbr) + f.a.a.b.b.a.bz(7, this.FKC);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + f.a.a.a.lB(8, this.xcN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.ihf);
      paramInt = i;
      if (this.BaseRequest != null) {
        paramInt = i + f.a.a.a.lB(10, this.BaseRequest.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.Gds);
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Fvn);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.GSm) + f.a.a.b.b.a.bz(14, this.HGl) + f.a.a.b.b.a.bz(15, this.HGm) + f.a.a.b.b.a.p(16, this.xbt) + f.a.a.b.b.a.bz(17, this.Ges);
      paramInt = i;
      if (this.FOL != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.FOL);
      }
      AppMethodBeat.o(148661);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148661);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtm localdtm = (dtm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(148661);
          return -1;
        case 1: 
          localdtm.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 2: 
          localdtm.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 3: 
          localdtm.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 4: 
          localdtm.FIg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 5: 
          localdtm.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 6: 
          localdtm.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 7: 
          localdtm.FKC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtm.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 9: 
          localdtm.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148661);
          return 0;
        case 11: 
          localdtm.Gds = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 12: 
          localdtm.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(148661);
          return 0;
        case 13: 
          localdtm.GSm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 14: 
          localdtm.HGl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 15: 
          localdtm.HGm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        case 16: 
          localdtm.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(148661);
          return 0;
        case 17: 
          localdtm.Ges = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(148661);
          return 0;
        }
        localdtm.FOL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(148661);
        return 0;
      }
      AppMethodBeat.o(148661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtm
 * JD-Core Version:    0.7.0.1
 */