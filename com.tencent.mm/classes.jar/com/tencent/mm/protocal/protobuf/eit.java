package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eit
  extends com.tencent.mm.bw.a
{
  public LinkedList<aca> IDO;
  public String NhX;
  public String NhY;
  public String NhZ;
  public String Nia;
  public long Nib;
  public eiw Nic;
  public dyi Nid;
  public boolean Nie;
  public LinkedList<eiw> Nif;
  public int Nig;
  public int Nih;
  public String Nii;
  public int Nij;
  public boolean Nik;
  public String dDv;
  public boolean guh;
  public String hes;
  public int offset;
  public String sGQ;
  public int scene;
  
  public eit()
  {
    AppMethodBeat.i(153006);
    this.IDO = new LinkedList();
    this.Nif = new LinkedList();
    AppMethodBeat.o(153006);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153007);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NhX != null) {
        paramVarArgs.e(1, this.NhX);
      }
      if (this.NhY != null) {
        paramVarArgs.e(2, this.NhY);
      }
      if (this.NhZ != null) {
        paramVarArgs.e(3, this.NhZ);
      }
      if (this.Nia != null) {
        paramVarArgs.e(4, this.Nia);
      }
      paramVarArgs.bb(5, this.Nib);
      paramVarArgs.aM(6, this.scene);
      if (this.hes != null) {
        paramVarArgs.e(7, this.hes);
      }
      if (this.dDv != null) {
        paramVarArgs.e(8, this.dDv);
      }
      if (this.Nic != null)
      {
        paramVarArgs.ni(9, this.Nic.computeSize());
        this.Nic.writeFields(paramVarArgs);
      }
      if (this.Nid != null)
      {
        paramVarArgs.ni(10, this.Nid.computeSize());
        this.Nid.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.IDO);
      if (this.sGQ != null) {
        paramVarArgs.e(12, this.sGQ);
      }
      paramVarArgs.aM(13, this.offset);
      paramVarArgs.cc(14, this.Nie);
      paramVarArgs.e(15, 8, this.Nif);
      paramVarArgs.aM(16, this.Nig);
      paramVarArgs.aM(17, this.Nih);
      paramVarArgs.cc(18, this.guh);
      if (this.Nii != null) {
        paramVarArgs.e(19, this.Nii);
      }
      paramVarArgs.aM(20, this.Nij);
      paramVarArgs.cc(21, this.Nik);
      AppMethodBeat.o(153007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NhX == null) {
        break label1638;
      }
    }
    label1638:
    for (int i = g.a.a.b.b.a.f(1, this.NhX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NhY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NhY);
      }
      i = paramInt;
      if (this.NhZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NhZ);
      }
      paramInt = i;
      if (this.Nia != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nia);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.Nib) + g.a.a.b.b.a.bu(6, this.scene);
      paramInt = i;
      if (this.hes != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.hes);
      }
      i = paramInt;
      if (this.dDv != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.dDv);
      }
      paramInt = i;
      if (this.Nic != null) {
        paramInt = i + g.a.a.a.nh(9, this.Nic.computeSize());
      }
      i = paramInt;
      if (this.Nid != null) {
        i = paramInt + g.a.a.a.nh(10, this.Nid.computeSize());
      }
      i += g.a.a.a.c(11, 8, this.IDO);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.sGQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.offset) + (g.a.a.b.b.a.fS(14) + 1) + g.a.a.a.c(15, 8, this.Nif) + g.a.a.b.b.a.bu(16, this.Nig) + g.a.a.b.b.a.bu(17, this.Nih) + (g.a.a.b.b.a.fS(18) + 1);
      paramInt = i;
      if (this.Nii != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.Nii);
      }
      i = g.a.a.b.b.a.bu(20, this.Nij);
      int j = g.a.a.b.b.a.fS(21);
      AppMethodBeat.o(153007);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IDO.clear();
        this.Nif.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eit localeit = (eit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153007);
          return -1;
        case 1: 
          localeit.NhX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 2: 
          localeit.NhY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 3: 
          localeit.NhZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 4: 
          localeit.Nia = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 5: 
          localeit.Nib = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153007);
          return 0;
        case 6: 
          localeit.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153007);
          return 0;
        case 7: 
          localeit.hes = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 8: 
          localeit.dDv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeit.Nic = ((eiw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeit.Nid = ((dyi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeit.IDO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 12: 
          localeit.sGQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 13: 
          localeit.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153007);
          return 0;
        case 14: 
          localeit.Nie = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153007);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeit.Nif.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153007);
          return 0;
        case 16: 
          localeit.Nig = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153007);
          return 0;
        case 17: 
          localeit.Nih = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153007);
          return 0;
        case 18: 
          localeit.guh = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153007);
          return 0;
        case 19: 
          localeit.Nii = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153007);
          return 0;
        case 20: 
          localeit.Nij = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153007);
          return 0;
        }
        localeit.Nik = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(153007);
        return 0;
      }
      AppMethodBeat.o(153007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eit
 * JD-Core Version:    0.7.0.1
 */