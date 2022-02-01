package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String MEq;
  public LinkedList<d> MRl;
  public int MRm;
  public int MRn;
  public int MRo;
  public LinkedList<String> MRp;
  public LinkedList<String> MRq;
  public LinkedList<b> MRr;
  public LinkedList<String> MRs;
  public int MRt;
  public int MRu;
  public LinkedList<m> MRv;
  public LinkedList<a> MRw;
  public k MRx;
  public String detail;
  public String nUO;
  public String name;
  public int version;
  
  public c()
  {
    AppMethodBeat.i(91267);
    this.MRl = new LinkedList();
    this.MRp = new LinkedList();
    this.MRq = new LinkedList();
    this.MRr = new LinkedList();
    this.MRs = new LinkedList();
    this.MRv = new LinkedList();
    this.MRw = new LinkedList();
    AppMethodBeat.o(91267);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91268);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      paramVarArgs.e(2, 8, this.MRl);
      paramVarArgs.bS(3, this.MRm);
      paramVarArgs.bS(4, this.MRn);
      paramVarArgs.bS(5, this.MRo);
      paramVarArgs.e(6, 1, this.MRp);
      if (this.nUO != null) {
        paramVarArgs.g(7, this.nUO);
      }
      if (this.detail != null) {
        paramVarArgs.g(8, this.detail);
      }
      paramVarArgs.e(9, 1, this.MRq);
      paramVarArgs.e(10, 8, this.MRr);
      paramVarArgs.e(11, 1, this.MRs);
      paramVarArgs.bS(12, this.MRt);
      paramVarArgs.bS(13, this.MRu);
      paramVarArgs.e(14, 8, this.MRv);
      paramVarArgs.bS(15, this.version);
      paramVarArgs.e(16, 8, this.MRw);
      if (this.MEq != null) {
        paramVarArgs.g(17, this.MEq);
      }
      if (this.MRx != null)
      {
        paramVarArgs.qD(18, this.MRx.computeSize());
        this.MRx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91268);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label1436;
      }
    }
    label1436:
    for (paramInt = i.a.a.b.b.a.h(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.MRl) + i.a.a.b.b.a.cJ(3, this.MRm) + i.a.a.b.b.a.cJ(4, this.MRn) + i.a.a.b.b.a.cJ(5, this.MRo) + i.a.a.a.c(6, 1, this.MRp);
      paramInt = i;
      if (this.nUO != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.nUO);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.detail);
      }
      i = i + i.a.a.a.c(9, 1, this.MRq) + i.a.a.a.c(10, 8, this.MRr) + i.a.a.a.c(11, 1, this.MRs) + i.a.a.b.b.a.cJ(12, this.MRt) + i.a.a.b.b.a.cJ(13, this.MRu) + i.a.a.a.c(14, 8, this.MRv) + i.a.a.b.b.a.cJ(15, this.version) + i.a.a.a.c(16, 8, this.MRw);
      paramInt = i;
      if (this.MEq != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.MEq);
      }
      i = paramInt;
      if (this.MRx != null) {
        i = paramInt + i.a.a.a.qC(18, this.MRx.computeSize());
      }
      AppMethodBeat.o(91268);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MRl.clear();
        this.MRp.clear();
        this.MRq.clear();
        this.MRr.clear();
        this.MRs.clear();
        this.MRv.clear();
        this.MRw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91268);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91268);
          return -1;
        case 1: 
          localc.name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new d();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((d)localObject2).parseFrom((byte[])localObject1);
            }
            localc.MRl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 3: 
          localc.MRm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91268);
          return 0;
        case 4: 
          localc.MRn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91268);
          return 0;
        case 5: 
          localc.MRo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91268);
          return 0;
        case 6: 
          localc.MRp.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 7: 
          localc.nUO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 8: 
          localc.detail = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91268);
          return 0;
        case 9: 
          localc.MRq.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new b();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((b)localObject2).parseFrom((byte[])localObject1);
            }
            localc.MRr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 11: 
          localc.MRs.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(91268);
          return 0;
        case 12: 
          localc.MRt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91268);
          return 0;
        case 13: 
          localc.MRu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91268);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new m();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((m)localObject2).parseFrom((byte[])localObject1);
            }
            localc.MRv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 15: 
          localc.version = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91268);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localc.MRw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91268);
          return 0;
        case 17: 
          localc.MEq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91268);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new k();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((k)localObject2).parseFrom((byte[])localObject1);
          }
          localc.MRx = ((k)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.c
 * JD-Core Version:    0.7.0.1
 */