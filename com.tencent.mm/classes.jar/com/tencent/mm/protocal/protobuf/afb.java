package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afb
  extends com.tencent.mm.bx.a
{
  public afc TYB;
  public afa TYC;
  public boolean Uax;
  public boolean Uay;
  public LinkedList<fos> Zng;
  public long Znh;
  public long Zni;
  public boolean Znj;
  public LinkedList<dmc> Znk;
  public fxt Znl;
  public LinkedList<afd> Znm;
  public boolean Znn;
  public LinkedList<fhx> Zno;
  public String editId;
  public String nBT;
  
  public afb()
  {
    AppMethodBeat.i(260136);
    this.Zng = new LinkedList();
    this.Znk = new LinkedList();
    this.Znm = new LinkedList();
    this.Zno = new LinkedList();
    AppMethodBeat.o(260136);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260147);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Zng);
      paramVarArgs.bv(2, this.Znh);
      paramVarArgs.bv(3, this.Zni);
      paramVarArgs.di(4, this.Uax);
      if (this.nBT != null) {
        paramVarArgs.g(5, this.nBT);
      }
      if (this.TYB != null)
      {
        paramVarArgs.qD(6, this.TYB.computeSize());
        this.TYB.writeFields(paramVarArgs);
      }
      paramVarArgs.di(7, this.Znj);
      if (this.TYC != null)
      {
        paramVarArgs.qD(8, this.TYC.computeSize());
        this.TYC.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.Znk);
      if (this.Znl != null)
      {
        paramVarArgs.qD(10, this.Znl.computeSize());
        this.Znl.writeFields(paramVarArgs);
      }
      paramVarArgs.di(11, this.Uay);
      paramVarArgs.e(12, 8, this.Znm);
      if (this.editId != null) {
        paramVarArgs.g(13, this.editId);
      }
      paramVarArgs.di(14, this.Znn);
      paramVarArgs.e(15, 8, this.Zno);
      AppMethodBeat.o(260147);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.Zng) + 0 + i.a.a.b.b.a.q(2, this.Znh) + i.a.a.b.b.a.q(3, this.Zni) + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.nBT != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nBT);
      }
      i = paramInt;
      if (this.TYB != null) {
        i = paramInt + i.a.a.a.qC(6, this.TYB.computeSize());
      }
      i += i.a.a.b.b.a.ko(7) + 1;
      paramInt = i;
      if (this.TYC != null) {
        paramInt = i + i.a.a.a.qC(8, this.TYC.computeSize());
      }
      i = paramInt + i.a.a.a.c(9, 8, this.Znk);
      paramInt = i;
      if (this.Znl != null) {
        paramInt = i + i.a.a.a.qC(10, this.Znl.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(11) + 1) + i.a.a.a.c(12, 8, this.Znm);
      paramInt = i;
      if (this.editId != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.editId);
      }
      i = i.a.a.b.b.a.ko(14);
      int j = i.a.a.a.c(15, 8, this.Zno);
      AppMethodBeat.o(260147);
      return paramInt + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zng.clear();
      this.Znk.clear();
      this.Znm.clear();
      this.Zno.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260147);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      afb localafb = (afb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260147);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fos();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fos)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.Zng.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260147);
        return 0;
      case 2: 
        localafb.Znh = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(260147);
        return 0;
      case 3: 
        localafb.Zni = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(260147);
        return 0;
      case 4: 
        localafb.Uax = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(260147);
        return 0;
      case 5: 
        localafb.nBT = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260147);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new afc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((afc)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.TYB = ((afc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260147);
        return 0;
      case 7: 
        localafb.Znj = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(260147);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new afa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((afa)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.TYC = ((afa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260147);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dmc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dmc)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.Znk.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260147);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fxt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fxt)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.Znl = ((fxt)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260147);
        return 0;
      case 11: 
        localafb.Uay = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(260147);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new afd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((afd)localObject2).parseFrom((byte[])localObject1);
          }
          localafb.Znm.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260147);
        return 0;
      case 13: 
        localafb.editId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260147);
        return 0;
      case 14: 
        localafb.Znn = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(260147);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fhx();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fhx)localObject2).parseFrom((byte[])localObject1);
        }
        localafb.Zno.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(260147);
      return 0;
    }
    AppMethodBeat.o(260147);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afb
 * JD-Core Version:    0.7.0.1
 */