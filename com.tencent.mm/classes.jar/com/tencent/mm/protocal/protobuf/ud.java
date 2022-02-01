package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ud
  extends com.tencent.mm.bw.a
{
  public long LdA;
  public int Ldc;
  public String Ldd;
  public un Lde;
  public String Ldf;
  public String Ldn;
  public String Ldo;
  public String Ldp;
  public String Ldq;
  public LinkedList<ub> Ldr;
  public LinkedList<ua> Lds;
  public String Ldt;
  public String Ldu;
  public un Ldv;
  public ub Ldw;
  public int Ldx;
  public int Ldy;
  public int Ldz;
  
  public ud()
  {
    AppMethodBeat.i(113954);
    this.Ldr = new LinkedList();
    this.Lds = new LinkedList();
    AppMethodBeat.o(113954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113955);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ldn != null) {
        paramVarArgs.e(1, this.Ldn);
      }
      if (this.Ldo != null) {
        paramVarArgs.e(2, this.Ldo);
      }
      if (this.Ldp != null) {
        paramVarArgs.e(3, this.Ldp);
      }
      if (this.Ldq != null) {
        paramVarArgs.e(4, this.Ldq);
      }
      paramVarArgs.e(5, 8, this.Ldr);
      paramVarArgs.aM(6, this.Ldc);
      if (this.Ldd != null) {
        paramVarArgs.e(7, this.Ldd);
      }
      if (this.Lde != null)
      {
        paramVarArgs.ni(8, this.Lde.computeSize());
        this.Lde.writeFields(paramVarArgs);
      }
      if (this.Ldf != null) {
        paramVarArgs.e(9, this.Ldf);
      }
      paramVarArgs.e(10, 8, this.Lds);
      if (this.Ldt != null) {
        paramVarArgs.e(11, this.Ldt);
      }
      if (this.Ldu != null) {
        paramVarArgs.e(12, this.Ldu);
      }
      if (this.Ldv != null)
      {
        paramVarArgs.ni(13, this.Ldv.computeSize());
        this.Ldv.writeFields(paramVarArgs);
      }
      if (this.Ldw != null)
      {
        paramVarArgs.ni(14, this.Ldw.computeSize());
        this.Ldw.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(15, this.Ldx);
      paramVarArgs.aM(16, this.Ldy);
      paramVarArgs.aM(17, this.Ldz);
      paramVarArgs.bb(18, this.LdA);
      AppMethodBeat.o(113955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ldn == null) {
        break label1630;
      }
    }
    label1630:
    for (int i = g.a.a.b.b.a.f(1, this.Ldn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ldo != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Ldo);
      }
      i = paramInt;
      if (this.Ldp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ldp);
      }
      paramInt = i;
      if (this.Ldq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Ldq);
      }
      i = paramInt + g.a.a.a.c(5, 8, this.Ldr) + g.a.a.b.b.a.bu(6, this.Ldc);
      paramInt = i;
      if (this.Ldd != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Ldd);
      }
      i = paramInt;
      if (this.Lde != null) {
        i = paramInt + g.a.a.a.nh(8, this.Lde.computeSize());
      }
      paramInt = i;
      if (this.Ldf != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Ldf);
      }
      i = paramInt + g.a.a.a.c(10, 8, this.Lds);
      paramInt = i;
      if (this.Ldt != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Ldt);
      }
      i = paramInt;
      if (this.Ldu != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Ldu);
      }
      paramInt = i;
      if (this.Ldv != null) {
        paramInt = i + g.a.a.a.nh(13, this.Ldv.computeSize());
      }
      i = paramInt;
      if (this.Ldw != null) {
        i = paramInt + g.a.a.a.nh(14, this.Ldw.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(15, this.Ldx);
      int j = g.a.a.b.b.a.bu(16, this.Ldy);
      int k = g.a.a.b.b.a.bu(17, this.Ldz);
      int m = g.a.a.b.b.a.r(18, this.LdA);
      AppMethodBeat.o(113955);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ldr.clear();
        this.Lds.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ud localud = (ud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113955);
          return -1;
        case 1: 
          localud.Ldn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 2: 
          localud.Ldo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 3: 
          localud.Ldp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 4: 
          localud.Ldq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ub();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ub)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localud.Ldr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 6: 
          localud.Ldc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113955);
          return 0;
        case 7: 
          localud.Ldd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localud.Lde = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 9: 
          localud.Ldf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ua();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ua)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localud.Lds.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 11: 
          localud.Ldt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 12: 
          localud.Ldu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localud.Ldv = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ub();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ub)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localud.Ldw = ((ub)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 15: 
          localud.Ldx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113955);
          return 0;
        case 16: 
          localud.Ldy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113955);
          return 0;
        case 17: 
          localud.Ldz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113955);
          return 0;
        }
        localud.LdA = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(113955);
        return 0;
      }
      AppMethodBeat.o(113955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ud
 * JD-Core Version:    0.7.0.1
 */