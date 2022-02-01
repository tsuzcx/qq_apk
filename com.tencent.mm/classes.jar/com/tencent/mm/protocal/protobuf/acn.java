package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acn
  extends com.tencent.mm.bw.a
{
  public aco Gxw;
  public acm Gxx;
  public boolean Gzo;
  public boolean Gzp;
  public LinkedList<ejf> Lnd;
  public long Lne;
  public long Lnf;
  public boolean Lng;
  public LinkedList<clz> Lnh;
  public eqy Lni;
  public LinkedList<acp> Lnj;
  public boolean Lnk;
  public LinkedList<ecy> Lnl;
  public String editId;
  public String iiv;
  
  public acn()
  {
    AppMethodBeat.i(201288);
    this.Lnd = new LinkedList();
    this.Lnh = new LinkedList();
    this.Lnj = new LinkedList();
    this.Lnl = new LinkedList();
    AppMethodBeat.o(201288);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201289);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Lnd);
      paramVarArgs.bb(2, this.Lne);
      paramVarArgs.bb(3, this.Lnf);
      paramVarArgs.cc(4, this.Gzo);
      if (this.iiv != null) {
        paramVarArgs.e(5, this.iiv);
      }
      if (this.Gxw != null)
      {
        paramVarArgs.ni(6, this.Gxw.computeSize());
        this.Gxw.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(7, this.Lng);
      if (this.Gxx != null)
      {
        paramVarArgs.ni(8, this.Gxx.computeSize());
        this.Gxx.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.Lnh);
      if (this.Lni != null)
      {
        paramVarArgs.ni(10, this.Lni.computeSize());
        this.Lni.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(11, this.Gzp);
      paramVarArgs.e(12, 8, this.Lnj);
      if (this.editId != null) {
        paramVarArgs.e(13, this.editId);
      }
      paramVarArgs.cc(14, this.Lnk);
      paramVarArgs.e(15, 8, this.Lnl);
      AppMethodBeat.o(201289);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Lnd) + 0 + g.a.a.b.b.a.r(2, this.Lne) + g.a.a.b.b.a.r(3, this.Lnf) + (g.a.a.b.b.a.fS(4) + 1);
      paramInt = i;
      if (this.iiv != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.iiv);
      }
      i = paramInt;
      if (this.Gxw != null) {
        i = paramInt + g.a.a.a.nh(6, this.Gxw.computeSize());
      }
      i += g.a.a.b.b.a.fS(7) + 1;
      paramInt = i;
      if (this.Gxx != null) {
        paramInt = i + g.a.a.a.nh(8, this.Gxx.computeSize());
      }
      i = paramInt + g.a.a.a.c(9, 8, this.Lnh);
      paramInt = i;
      if (this.Lni != null) {
        paramInt = i + g.a.a.a.nh(10, this.Lni.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.fS(11) + 1) + g.a.a.a.c(12, 8, this.Lnj);
      paramInt = i;
      if (this.editId != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.editId);
      }
      i = g.a.a.b.b.a.fS(14);
      int j = g.a.a.a.c(15, 8, this.Lnl);
      AppMethodBeat.o(201289);
      return paramInt + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lnd.clear();
      this.Lnh.clear();
      this.Lnj.clear();
      this.Lnl.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(201289);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      acn localacn = (acn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(201289);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ejf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localacn.Lnd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201289);
        return 0;
      case 2: 
        localacn.Lne = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(201289);
        return 0;
      case 3: 
        localacn.Lnf = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(201289);
        return 0;
      case 4: 
        localacn.Gzo = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(201289);
        return 0;
      case 5: 
        localacn.iiv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(201289);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aco();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localacn.Gxw = ((aco)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201289);
        return 0;
      case 7: 
        localacn.Lng = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(201289);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localacn.Gxx = ((acm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201289);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localacn.Lnh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201289);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eqy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eqy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localacn.Lni = ((eqy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201289);
        return 0;
      case 11: 
        localacn.Gzp = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(201289);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localacn.Lnj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201289);
        return 0;
      case 13: 
        localacn.editId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(201289);
        return 0;
      case 14: 
        localacn.Lnk = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(201289);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ecy();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ecy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localacn.Lnl.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(201289);
      return 0;
    }
    AppMethodBeat.o(201289);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acn
 * JD-Core Version:    0.7.0.1
 */