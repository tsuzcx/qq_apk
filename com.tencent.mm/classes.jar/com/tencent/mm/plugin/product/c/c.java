package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String detail;
  public String hlf;
  public String name;
  public k vFA;
  public LinkedList<d> vFo;
  public int vFp;
  public int vFq;
  public int vFr;
  public LinkedList<String> vFs;
  public LinkedList<String> vFt;
  public LinkedList<b> vFu;
  public LinkedList<String> vFv;
  public int vFw;
  public int vFx;
  public LinkedList<m> vFy;
  public LinkedList<a> vFz;
  public int version;
  public String vxl;
  
  public c()
  {
    AppMethodBeat.i(91267);
    this.vFo = new LinkedList();
    this.vFs = new LinkedList();
    this.vFt = new LinkedList();
    this.vFu = new LinkedList();
    this.vFv = new LinkedList();
    this.vFy = new LinkedList();
    this.vFz = new LinkedList();
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
      paramVarArgs.e(2, 8, this.vFo);
      paramVarArgs.aR(3, this.vFp);
      paramVarArgs.aR(4, this.vFq);
      paramVarArgs.aR(5, this.vFr);
      paramVarArgs.e(6, 1, this.vFs);
      if (this.hlf != null) {
        paramVarArgs.d(7, this.hlf);
      }
      if (this.detail != null) {
        paramVarArgs.d(8, this.detail);
      }
      paramVarArgs.e(9, 1, this.vFt);
      paramVarArgs.e(10, 8, this.vFu);
      paramVarArgs.e(11, 1, this.vFv);
      paramVarArgs.aR(12, this.vFw);
      paramVarArgs.aR(13, this.vFx);
      paramVarArgs.e(14, 8, this.vFy);
      paramVarArgs.aR(15, this.version);
      paramVarArgs.e(16, 8, this.vFz);
      if (this.vxl != null) {
        paramVarArgs.d(17, this.vxl);
      }
      if (this.vFA != null)
      {
        paramVarArgs.ln(18, this.vFA.computeSize());
        this.vFA.writeFields(paramVarArgs);
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
      int i = paramInt + f.a.a.a.c(2, 8, this.vFo) + f.a.a.b.b.a.bx(3, this.vFp) + f.a.a.b.b.a.bx(4, this.vFq) + f.a.a.b.b.a.bx(5, this.vFr) + f.a.a.a.c(6, 1, this.vFs);
      paramInt = i;
      if (this.hlf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hlf);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.detail);
      }
      i = i + f.a.a.a.c(9, 1, this.vFt) + f.a.a.a.c(10, 8, this.vFu) + f.a.a.a.c(11, 1, this.vFv) + f.a.a.b.b.a.bx(12, this.vFw) + f.a.a.b.b.a.bx(13, this.vFx) + f.a.a.a.c(14, 8, this.vFy) + f.a.a.b.b.a.bx(15, this.version) + f.a.a.a.c(16, 8, this.vFz);
      paramInt = i;
      if (this.vxl != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.vxl);
      }
      i = paramInt;
      if (this.vFA != null) {
        i = paramInt + f.a.a.a.lm(18, this.vFA.computeSize());
      }
      AppMethodBeat.o(91268);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vFo.clear();
        this.vFs.clear();
        this.vFt.clear();
        this.vFu.clear();
        this.vFv.clear();
        this.vFy.clear();
        this.vFz.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localc.name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.vFo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 3: 
          localc.vFp = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91268);
          return 0;
        case 4: 
          localc.vFq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91268);
          return 0;
        case 5: 
          localc.vFr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91268);
          return 0;
        case 6: 
          localc.vFs.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 7: 
          localc.hlf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 8: 
          localc.detail = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 9: 
          localc.vFt.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.vFu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 11: 
          localc.vFv.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 12: 
          localc.vFw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91268);
          return 0;
        case 13: 
          localc.vFx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91268);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.vFy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 15: 
          localc.version = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91268);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localc.vFz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 17: 
          localc.vxl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91268);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.vFA = ((k)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.c
 * JD-Core Version:    0.7.0.1
 */