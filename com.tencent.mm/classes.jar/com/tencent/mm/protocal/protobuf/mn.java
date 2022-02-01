package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class mn
  extends com.tencent.mm.bx.a
{
  public String CIQ;
  public String CJA;
  public int CJb;
  public int CJk;
  public int CJl;
  public int CJm;
  public int CJn;
  public long CJo;
  public long CJp;
  public boolean CJq;
  public int CJr;
  public boolean CJs;
  public ii CJt;
  public boolean CJu;
  public to CJv;
  public LinkedList<dpl> CJw;
  public boolean CJx;
  public LinkedList<String> CJy;
  public String CJz;
  
  public mn()
  {
    AppMethodBeat.i(191088);
    this.CJw = new LinkedList();
    this.CJy = new LinkedList();
    AppMethodBeat.o(191088);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124426);
        throw paramVarArgs;
      }
      if (this.CIQ != null) {
        paramVarArgs.d(1, this.CIQ);
      }
      paramVarArgs.aR(2, this.CJk);
      paramVarArgs.aR(3, this.CJl);
      paramVarArgs.aR(4, this.CJm);
      paramVarArgs.aR(5, this.CJn);
      paramVarArgs.aG(6, this.CJo);
      paramVarArgs.aG(7, this.CJp);
      paramVarArgs.aR(8, this.CJb);
      paramVarArgs.bg(9, this.CJq);
      paramVarArgs.aR(10, this.CJr);
      paramVarArgs.bg(11, this.CJs);
      if (this.CJt != null)
      {
        paramVarArgs.kX(12, this.CJt.computeSize());
        this.CJt.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(13, this.CJu);
      if (this.CJv != null)
      {
        paramVarArgs.kX(14, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.CJw);
      paramVarArgs.bg(16, this.CJx);
      paramVarArgs.e(17, 1, this.CJy);
      if (this.CJz != null) {
        paramVarArgs.d(18, this.CJz);
      }
      if (this.CJA != null) {
        paramVarArgs.d(19, this.CJA);
      }
      AppMethodBeat.o(124426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CIQ == null) {
        break label1418;
      }
    }
    label1418:
    for (paramInt = f.a.a.b.b.a.e(1, this.CIQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CJk) + f.a.a.b.b.a.bA(3, this.CJl) + f.a.a.b.b.a.bA(4, this.CJm) + f.a.a.b.b.a.bA(5, this.CJn) + f.a.a.b.b.a.q(6, this.CJo) + f.a.a.b.b.a.q(7, this.CJp) + f.a.a.b.b.a.bA(8, this.CJb) + (f.a.a.b.b.a.fY(9) + 1) + f.a.a.b.b.a.bA(10, this.CJr) + (f.a.a.b.b.a.fY(11) + 1);
      paramInt = i;
      if (this.CJt != null) {
        paramInt = i + f.a.a.a.kW(12, this.CJt.computeSize());
      }
      i = paramInt + (f.a.a.b.b.a.fY(13) + 1);
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + f.a.a.a.kW(14, this.CJv.computeSize());
      }
      i = paramInt + f.a.a.a.c(15, 8, this.CJw) + (f.a.a.b.b.a.fY(16) + 1) + f.a.a.a.c(17, 1, this.CJy);
      paramInt = i;
      if (this.CJz != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.CJz);
      }
      i = paramInt;
      if (this.CJA != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.CJA);
      }
      AppMethodBeat.o(124426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CJw.clear();
        this.CJy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CIQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mn localmn = (mn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124426);
          return -1;
        case 1: 
          localmn.CIQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124426);
          return 0;
        case 2: 
          localmn.CJk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124426);
          return 0;
        case 3: 
          localmn.CJl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124426);
          return 0;
        case 4: 
          localmn.CJm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124426);
          return 0;
        case 5: 
          localmn.CJn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124426);
          return 0;
        case 6: 
          localmn.CJo = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124426);
          return 0;
        case 7: 
          localmn.CJp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124426);
          return 0;
        case 8: 
          localmn.CJb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124426);
          return 0;
        case 9: 
          localmn.CJq = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(124426);
          return 0;
        case 10: 
          localmn.CJr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124426);
          return 0;
        case 11: 
          localmn.CJs = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(124426);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ii();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmn.CJt = ((ii)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 13: 
          localmn.CJu = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(124426);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new to();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((to)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmn.CJv = ((to)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmn.CJw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 16: 
          localmn.CJx = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(124426);
          return 0;
        case 17: 
          localmn.CJy.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(124426);
          return 0;
        case 18: 
          localmn.CJz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124426);
          return 0;
        }
        localmn.CJA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(124426);
        return 0;
      }
      AppMethodBeat.o(124426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mn
 * JD-Core Version:    0.7.0.1
 */