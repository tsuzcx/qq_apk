package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String detail;
  public String hGg;
  public String name;
  public int version;
  public String wSq;
  public LinkedList<d> xci;
  public int xcj;
  public int xck;
  public int xcl;
  public LinkedList<String> xcm;
  public LinkedList<String> xcn;
  public LinkedList<b> xco;
  public LinkedList<String> xcp;
  public int xcq;
  public int xcr;
  public LinkedList<m> xcs;
  public LinkedList<a> xct;
  public k xcu;
  
  public c()
  {
    AppMethodBeat.i(91267);
    this.xci = new LinkedList();
    this.xcm = new LinkedList();
    this.xcn = new LinkedList();
    this.xco = new LinkedList();
    this.xcp = new LinkedList();
    this.xcs = new LinkedList();
    this.xct = new LinkedList();
    AppMethodBeat.o(91267);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91268);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      paramVarArgs.e(2, 8, this.xci);
      paramVarArgs.aS(3, this.xcj);
      paramVarArgs.aS(4, this.xck);
      paramVarArgs.aS(5, this.xcl);
      paramVarArgs.e(6, 1, this.xcm);
      if (this.hGg != null) {
        paramVarArgs.d(7, this.hGg);
      }
      if (this.detail != null) {
        paramVarArgs.d(8, this.detail);
      }
      paramVarArgs.e(9, 1, this.xcn);
      paramVarArgs.e(10, 8, this.xco);
      paramVarArgs.e(11, 1, this.xcp);
      paramVarArgs.aS(12, this.xcq);
      paramVarArgs.aS(13, this.xcr);
      paramVarArgs.e(14, 8, this.xcs);
      paramVarArgs.aS(15, this.version);
      paramVarArgs.e(16, 8, this.xct);
      if (this.wSq != null) {
        paramVarArgs.d(17, this.wSq);
      }
      if (this.xcu != null)
      {
        paramVarArgs.lJ(18, this.xcu.computeSize());
        this.xcu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91268);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label1546;
      }
    }
    label1546:
    for (paramInt = f.a.a.b.b.a.e(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.xci) + f.a.a.b.b.a.bz(3, this.xcj) + f.a.a.b.b.a.bz(4, this.xck) + f.a.a.b.b.a.bz(5, this.xcl) + f.a.a.a.c(6, 1, this.xcm);
      paramInt = i;
      if (this.hGg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hGg);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.detail);
      }
      i = i + f.a.a.a.c(9, 1, this.xcn) + f.a.a.a.c(10, 8, this.xco) + f.a.a.a.c(11, 1, this.xcp) + f.a.a.b.b.a.bz(12, this.xcq) + f.a.a.b.b.a.bz(13, this.xcr) + f.a.a.a.c(14, 8, this.xcs) + f.a.a.b.b.a.bz(15, this.version) + f.a.a.a.c(16, 8, this.xct);
      paramInt = i;
      if (this.wSq != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.wSq);
      }
      i = paramInt;
      if (this.xcu != null) {
        i = paramInt + f.a.a.a.lI(18, this.xcu.computeSize());
      }
      AppMethodBeat.o(91268);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xci.clear();
        this.xcm.clear();
        this.xcn.clear();
        this.xco.clear();
        this.xcp.clear();
        this.xcs.clear();
        this.xct.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91268);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91268);
          return -1;
        case 1: 
          localc.name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.xci.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 3: 
          localc.xcj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 4: 
          localc.xck = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 5: 
          localc.xcl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 6: 
          localc.xcm.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 7: 
          localc.hGg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 8: 
          localc.detail = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 9: 
          localc.xcn.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.xco.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 11: 
          localc.xcp.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 12: 
          localc.xcq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 13: 
          localc.xcr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.xcs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 15: 
          localc.version = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91268);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.xct.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 17: 
          localc.wSq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91268);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.xcu = ((k)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91268);
        return 0;
      }
      AppMethodBeat.o(91268);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.c
 * JD-Core Version:    0.7.0.1
 */