package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byt
  extends com.tencent.mm.bx.a
{
  public cwt GKC;
  public int GNU;
  public String GNV;
  public int GTR;
  public cwt GTS;
  public cwt GTT;
  public cwt GTU;
  public int GaH;
  public cwt Gbr;
  public cwt Gbs;
  public cwt Gcd;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public int jdg;
  public String jdl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101823);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gcd == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Gbr == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Gbs == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.GTS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.GTT == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.GTU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101823);
        throw paramVarArgs;
      }
      if (this.Gcd != null)
      {
        paramVarArgs.lC(1, this.Gcd.computeSize());
        this.Gcd.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GTR);
      if (this.GKC != null)
      {
        paramVarArgs.lC(3, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      if (this.Gbr != null)
      {
        paramVarArgs.lC(4, this.Gbr.computeSize());
        this.Gbr.writeFields(paramVarArgs);
      }
      if (this.Gbs != null)
      {
        paramVarArgs.lC(5, this.Gbs.computeSize());
        this.Gbs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.jdc);
      if (this.GTS != null)
      {
        paramVarArgs.lC(9, this.GTS.computeSize());
        this.GTS.writeFields(paramVarArgs);
      }
      if (this.GTT != null)
      {
        paramVarArgs.lC(10, this.GTT.computeSize());
        this.GTT.writeFields(paramVarArgs);
      }
      if (this.GTU != null)
      {
        paramVarArgs.lC(11, this.GTU.computeSize());
        this.GTU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.GaH);
      if (this.jdd != null) {
        paramVarArgs.d(13, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(14, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(15, this.jdf);
      }
      paramVarArgs.aS(16, this.jdg);
      paramVarArgs.aS(17, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(18, this.GNV);
      }
      if (this.jdl != null) {
        paramVarArgs.d(19, this.jdl);
      }
      AppMethodBeat.o(101823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gcd == null) {
        break label2122;
      }
    }
    label2122:
    for (paramInt = f.a.a.a.lB(1, this.Gcd.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GTR);
      paramInt = i;
      if (this.GKC != null) {
        paramInt = i + f.a.a.a.lB(3, this.GKC.computeSize());
      }
      i = paramInt;
      if (this.Gbr != null) {
        i = paramInt + f.a.a.a.lB(4, this.Gbr.computeSize());
      }
      paramInt = i;
      if (this.Gbs != null) {
        paramInt = i + f.a.a.a.lB(5, this.Gbs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.jdc);
      paramInt = i;
      if (this.GTS != null) {
        paramInt = i + f.a.a.a.lB(9, this.GTS.computeSize());
      }
      i = paramInt;
      if (this.GTT != null) {
        i = paramInt + f.a.a.a.lB(10, this.GTT.computeSize());
      }
      paramInt = i;
      if (this.GTU != null) {
        paramInt = i + f.a.a.a.lB(11, this.GTU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.GaH);
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.jde);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.jdg) + f.a.a.b.b.a.bz(17, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.GNV);
      }
      i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.jdl);
      }
      AppMethodBeat.o(101823);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gcd == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.GKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Gbr == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.Gbs == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.GTS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.GTT == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        if (this.GTU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101823);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101823);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byt localbyt = (byt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(101823);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyt.Gcd = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 2: 
          localbyt.GTR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyt.GKC = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyt.Gbr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyt.Gbs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 6: 
          localbyt.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyt.GTS = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyt.GTT = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyt.GTU = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101823);
          return 0;
        case 12: 
          localbyt.GaH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 13: 
          localbyt.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 14: 
          localbyt.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 15: 
          localbyt.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101823);
          return 0;
        case 16: 
          localbyt.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 17: 
          localbyt.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101823);
          return 0;
        case 18: 
          localbyt.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101823);
          return 0;
        }
        localbyt.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(101823);
        return 0;
      }
      AppMethodBeat.o(101823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byt
 * JD-Core Version:    0.7.0.1
 */