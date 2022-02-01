package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qy
  extends com.tencent.mm.bw.a
{
  public int EhY;
  public int EhZ;
  public LinkedList<sg> Eia;
  public LinkedList<sg> Eib;
  public LinkedList<sg> Eic;
  public LinkedList<String> Eid;
  public int Eie;
  public int Eif;
  public LinkedList<yg> Eig;
  public long Eih;
  public int Eii;
  public String Eij;
  public yg Eik;
  public LinkedList<bc> Eil;
  public yg Eim;
  public yg Ein;
  public yg Eio;
  public acm Eip;
  public String Eiq;
  public yg Eir;
  public String Eis;
  public yg Eit;
  public boolean Eiu;
  public boolean Eiv;
  public String code;
  public int status;
  
  public qy()
  {
    AppMethodBeat.i(113948);
    this.Eia = new LinkedList();
    this.Eib = new LinkedList();
    this.Eic = new LinkedList();
    this.Eid = new LinkedList();
    this.Eig = new LinkedList();
    this.Eil = new LinkedList();
    AppMethodBeat.o(113948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.status);
      paramVarArgs.aR(2, this.EhY);
      paramVarArgs.aR(3, this.EhZ);
      paramVarArgs.e(4, 8, this.Eia);
      paramVarArgs.e(5, 8, this.Eib);
      paramVarArgs.e(6, 8, this.Eic);
      paramVarArgs.e(7, 1, this.Eid);
      paramVarArgs.aR(8, this.Eie);
      if (this.code != null) {
        paramVarArgs.d(9, this.code);
      }
      paramVarArgs.aR(10, this.Eif);
      paramVarArgs.e(11, 8, this.Eig);
      paramVarArgs.aO(12, this.Eih);
      paramVarArgs.aR(13, this.Eii);
      if (this.Eij != null) {
        paramVarArgs.d(14, this.Eij);
      }
      if (this.Eik != null)
      {
        paramVarArgs.ln(15, this.Eik.computeSize());
        this.Eik.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.Eil);
      if (this.Eim != null)
      {
        paramVarArgs.ln(17, this.Eim.computeSize());
        this.Eim.writeFields(paramVarArgs);
      }
      if (this.Ein != null)
      {
        paramVarArgs.ln(18, this.Ein.computeSize());
        this.Ein.writeFields(paramVarArgs);
      }
      if (this.Eio != null)
      {
        paramVarArgs.ln(19, this.Eio.computeSize());
        this.Eio.writeFields(paramVarArgs);
      }
      if (this.Eip != null)
      {
        paramVarArgs.ln(20, this.Eip.computeSize());
        this.Eip.writeFields(paramVarArgs);
      }
      if (this.Eiq != null) {
        paramVarArgs.d(21, this.Eiq);
      }
      if (this.Eir != null)
      {
        paramVarArgs.ln(22, this.Eir.computeSize());
        this.Eir.writeFields(paramVarArgs);
      }
      if (this.Eis != null) {
        paramVarArgs.d(23, this.Eis);
      }
      if (this.Eit != null)
      {
        paramVarArgs.ln(24, this.Eit.computeSize());
        this.Eit.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(25, this.Eiu);
      paramVarArgs.bl(26, this.Eiv);
      AppMethodBeat.o(113949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.status) + 0 + f.a.a.b.b.a.bx(2, this.EhY) + f.a.a.b.b.a.bx(3, this.EhZ) + f.a.a.a.c(4, 8, this.Eia) + f.a.a.a.c(5, 8, this.Eib) + f.a.a.a.c(6, 8, this.Eic) + f.a.a.a.c(7, 1, this.Eid) + f.a.a.b.b.a.bx(8, this.Eie);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.code);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.Eif) + f.a.a.a.c(11, 8, this.Eig) + f.a.a.b.b.a.p(12, this.Eih) + f.a.a.b.b.a.bx(13, this.Eii);
      paramInt = i;
      if (this.Eij != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Eij);
      }
      i = paramInt;
      if (this.Eik != null) {
        i = paramInt + f.a.a.a.lm(15, this.Eik.computeSize());
      }
      i += f.a.a.a.c(16, 8, this.Eil);
      paramInt = i;
      if (this.Eim != null) {
        paramInt = i + f.a.a.a.lm(17, this.Eim.computeSize());
      }
      i = paramInt;
      if (this.Ein != null) {
        i = paramInt + f.a.a.a.lm(18, this.Ein.computeSize());
      }
      paramInt = i;
      if (this.Eio != null) {
        paramInt = i + f.a.a.a.lm(19, this.Eio.computeSize());
      }
      i = paramInt;
      if (this.Eip != null) {
        i = paramInt + f.a.a.a.lm(20, this.Eip.computeSize());
      }
      paramInt = i;
      if (this.Eiq != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Eiq);
      }
      i = paramInt;
      if (this.Eir != null) {
        i = paramInt + f.a.a.a.lm(22, this.Eir.computeSize());
      }
      paramInt = i;
      if (this.Eis != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Eis);
      }
      i = paramInt;
      if (this.Eit != null) {
        i = paramInt + f.a.a.a.lm(24, this.Eit.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(25);
      int j = f.a.a.b.b.a.fK(26);
      AppMethodBeat.o(113949);
      return i + (paramInt + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eia.clear();
      this.Eib.clear();
      this.Eic.clear();
      this.Eid.clear();
      this.Eig.clear();
      this.Eil.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qy localqy = (qy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113949);
        return -1;
      case 1: 
        localqy.status = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113949);
        return 0;
      case 2: 
        localqy.EhY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113949);
        return 0;
      case 3: 
        localqy.EhZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113949);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eia.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eib.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eic.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 7: 
        localqy.Eid.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(113949);
        return 0;
      case 8: 
        localqy.Eie = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113949);
        return 0;
      case 9: 
        localqy.code = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 10: 
        localqy.Eif = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113949);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eig.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 12: 
        localqy.Eih = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(113949);
        return 0;
      case 13: 
        localqy.Eii = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113949);
        return 0;
      case 14: 
        localqy.Eij = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eik = ((yg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eil.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eim = ((yg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Ein = ((yg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eio = ((yg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eip = ((acm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 21: 
        localqy.Eiq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eir = ((yg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 23: 
        localqy.Eis = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqy.Eit = ((yg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 25: 
        localqy.Eiu = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(113949);
        return 0;
      }
      localqy.Eiv = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(113949);
      return 0;
    }
    AppMethodBeat.o(113949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qy
 * JD-Core Version:    0.7.0.1
 */