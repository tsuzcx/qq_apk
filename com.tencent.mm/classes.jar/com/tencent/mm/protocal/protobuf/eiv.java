package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiv
  extends com.tencent.mm.bw.a
{
  public LinkedList<aca> IDO;
  public LinkedList<eiw> Mub;
  public String NhX;
  public String NhY;
  public String NhZ;
  public String Nia;
  public long Nib;
  public dyi Nid;
  public boolean Nik;
  public String dDv;
  public int offset;
  public String sGQ;
  public int scene;
  
  public eiv()
  {
    AppMethodBeat.i(153010);
    this.Mub = new LinkedList();
    this.IDO = new LinkedList();
    AppMethodBeat.o(153010);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153011);
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
      if (this.Nid != null)
      {
        paramVarArgs.ni(5, this.Nid.computeSize());
        this.Nid.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.Nib);
      if (this.sGQ != null) {
        paramVarArgs.e(7, this.sGQ);
      }
      paramVarArgs.aM(8, this.offset);
      paramVarArgs.cc(9, this.Nik);
      paramVarArgs.aM(10, this.scene);
      if (this.dDv != null) {
        paramVarArgs.e(11, this.dDv);
      }
      paramVarArgs.e(12, 8, this.Mub);
      paramVarArgs.e(13, 8, this.IDO);
      AppMethodBeat.o(153011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NhX == null) {
        break label1138;
      }
    }
    label1138:
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
      i = paramInt;
      if (this.Nid != null) {
        i = paramInt + g.a.a.a.nh(5, this.Nid.computeSize());
      }
      i += g.a.a.b.b.a.r(6, this.Nib);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.sGQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.offset) + (g.a.a.b.b.a.fS(9) + 1) + g.a.a.b.b.a.bu(10, this.scene);
      paramInt = i;
      if (this.dDv != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.dDv);
      }
      i = g.a.a.a.c(12, 8, this.Mub);
      int j = g.a.a.a.c(13, 8, this.IDO);
      AppMethodBeat.o(153011);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mub.clear();
        this.IDO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eiv localeiv = (eiv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153011);
          return -1;
        case 1: 
          localeiv.NhX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 2: 
          localeiv.NhY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 3: 
          localeiv.NhZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 4: 
          localeiv.Nia = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiv.Nid = ((dyi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        case 6: 
          localeiv.Nib = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(153011);
          return 0;
        case 7: 
          localeiv.sGQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 8: 
          localeiv.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153011);
          return 0;
        case 9: 
          localeiv.Nik = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153011);
          return 0;
        case 10: 
          localeiv.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153011);
          return 0;
        case 11: 
          localeiv.dDv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153011);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeiv.Mub.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153011);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aca();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeiv.IDO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153011);
        return 0;
      }
      AppMethodBeat.o(153011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiv
 * JD-Core Version:    0.7.0.1
 */