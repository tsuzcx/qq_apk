package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ebd
  extends dop
{
  public SKBuiltinBuffer_t MYJ;
  public int MYL;
  public String MZg;
  public long MZh;
  public int NaA;
  public long NaB;
  public long NaC;
  public long NaD;
  public int NaE;
  public long NaF;
  public long Nau;
  public int Nav;
  public long Naw;
  public int Nax;
  public LinkedList<Long> Nay;
  public int Naz;
  
  public ebd()
  {
    AppMethodBeat.i(125826);
    this.Nay = new LinkedList();
    AppMethodBeat.o(125826);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MZg != null) {
        paramVarArgs.e(2, this.MZg);
      }
      paramVarArgs.bb(3, this.MZh);
      paramVarArgs.bb(4, this.Nau);
      paramVarArgs.aM(5, this.Nav);
      paramVarArgs.bb(6, this.Naw);
      if (this.MYJ != null)
      {
        paramVarArgs.ni(7, this.MYJ.computeSize());
        this.MYJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.MYL);
      paramVarArgs.aM(11, this.Nax);
      paramVarArgs.f(12, 3, this.Nay);
      paramVarArgs.aM(13, this.Naz);
      paramVarArgs.aM(14, this.NaA);
      paramVarArgs.bb(15, this.NaB);
      paramVarArgs.bb(16, this.NaC);
      paramVarArgs.bb(17, this.NaD);
      paramVarArgs.aM(18, this.NaE);
      paramVarArgs.bb(19, this.NaF);
      AppMethodBeat.o(125827);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1213;
      }
    }
    label1213:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MZg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MZg);
      }
      i = i + g.a.a.b.b.a.r(3, this.MZh) + g.a.a.b.b.a.r(4, this.Nau) + g.a.a.b.b.a.bu(5, this.Nav) + g.a.a.b.b.a.r(6, this.Naw);
      paramInt = i;
      if (this.MYJ != null) {
        paramInt = i + g.a.a.a.nh(7, this.MYJ.computeSize());
      }
      i = g.a.a.b.b.a.bu(8, this.MYL);
      int j = g.a.a.b.b.a.bu(11, this.Nax);
      int k = g.a.a.a.d(12, 3, this.Nay);
      int m = g.a.a.b.b.a.bu(13, this.Naz);
      int n = g.a.a.b.b.a.bu(14, this.NaA);
      int i1 = g.a.a.b.b.a.r(15, this.NaB);
      int i2 = g.a.a.b.b.a.r(16, this.NaC);
      int i3 = g.a.a.b.b.a.r(17, this.NaD);
      int i4 = g.a.a.b.b.a.bu(18, this.NaE);
      int i5 = g.a.a.b.b.a.r(19, this.NaF);
      AppMethodBeat.o(125827);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nay.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125827);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebd localebd = (ebd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(125827);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 2: 
          localebd.MZg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125827);
          return 0;
        case 3: 
          localebd.MZh = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125827);
          return 0;
        case 4: 
          localebd.Nau = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125827);
          return 0;
        case 5: 
          localebd.Nav = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125827);
          return 0;
        case 6: 
          localebd.Naw = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125827);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebd.MYJ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125827);
          return 0;
        case 8: 
          localebd.MYL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125827);
          return 0;
        case 11: 
          localebd.Nax = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125827);
          return 0;
        case 12: 
          localebd.Nay = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPn();
          AppMethodBeat.o(125827);
          return 0;
        case 13: 
          localebd.Naz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125827);
          return 0;
        case 14: 
          localebd.NaA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125827);
          return 0;
        case 15: 
          localebd.NaB = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125827);
          return 0;
        case 16: 
          localebd.NaC = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125827);
          return 0;
        case 17: 
          localebd.NaD = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125827);
          return 0;
        case 18: 
          localebd.NaE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125827);
          return 0;
        }
        localebd.NaF = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125827);
        return 0;
      }
      AppMethodBeat.o(125827);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebd
 * JD-Core Version:    0.7.0.1
 */