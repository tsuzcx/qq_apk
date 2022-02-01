package com.tencent.mm.plugin.multimediareport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public long LhU;
  public int LhV;
  public long LhW;
  public String LhX;
  public String LhY;
  public int LhZ;
  public int Lia;
  public int Lib;
  public int Lic;
  public String Lid;
  public String Lie;
  public int Lif;
  public b Lig;
  public LinkedList<a> Lih;
  public long createtime;
  public String fileid;
  public int mMK;
  public String md5;
  public String mdZ;
  public int source;
  public String uuid;
  public String wYJ;
  public String waL;
  
  public d()
  {
    AppMethodBeat.i(262698);
    this.Lih = new LinkedList();
    AppMethodBeat.o(262698);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(262703);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.LhU);
      paramVarArgs.bS(2, this.LhV);
      paramVarArgs.bS(3, this.source);
      paramVarArgs.bv(4, this.LhW);
      if (this.waL != null) {
        paramVarArgs.g(5, this.waL);
      }
      if (this.LhX != null) {
        paramVarArgs.g(6, this.LhX);
      }
      if (this.fileid != null) {
        paramVarArgs.g(7, this.fileid);
      }
      if (this.LhY != null) {
        paramVarArgs.g(8, this.LhY);
      }
      if (this.md5 != null) {
        paramVarArgs.g(9, this.md5);
      }
      paramVarArgs.bv(10, this.createtime);
      paramVarArgs.bS(11, this.LhZ);
      paramVarArgs.bS(12, this.Lia);
      if (this.mdZ != null) {
        paramVarArgs.g(13, this.mdZ);
      }
      paramVarArgs.bS(14, this.Lib);
      paramVarArgs.bS(15, this.mMK);
      paramVarArgs.bS(16, this.Lic);
      if (this.Lid != null) {
        paramVarArgs.g(17, this.Lid);
      }
      if (this.Lie != null) {
        paramVarArgs.g(18, this.Lie);
      }
      if (this.wYJ != null) {
        paramVarArgs.g(19, this.wYJ);
      }
      paramVarArgs.bS(20, this.Lif);
      if (this.uuid != null) {
        paramVarArgs.g(21, this.uuid);
      }
      if (this.Lig != null) {
        paramVarArgs.d(22, this.Lig);
      }
      paramVarArgs.e(23, 8, this.Lih);
      AppMethodBeat.o(262703);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.LhU) + 0 + i.a.a.b.b.a.cJ(2, this.LhV) + i.a.a.b.b.a.cJ(3, this.source) + i.a.a.b.b.a.q(4, this.LhW);
      paramInt = i;
      if (this.waL != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.waL);
      }
      i = paramInt;
      if (this.LhX != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.LhX);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.fileid);
      }
      i = paramInt;
      if (this.LhY != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.LhY);
      }
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.md5);
      }
      i = paramInt + i.a.a.b.b.a.q(10, this.createtime) + i.a.a.b.b.a.cJ(11, this.LhZ) + i.a.a.b.b.a.cJ(12, this.Lia);
      paramInt = i;
      if (this.mdZ != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.mdZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.Lib) + i.a.a.b.b.a.cJ(15, this.mMK) + i.a.a.b.b.a.cJ(16, this.Lic);
      paramInt = i;
      if (this.Lid != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.Lid);
      }
      i = paramInt;
      if (this.Lie != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.Lie);
      }
      paramInt = i;
      if (this.wYJ != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.wYJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(20, this.Lif);
      paramInt = i;
      if (this.uuid != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.uuid);
      }
      i = paramInt;
      if (this.Lig != null) {
        i = paramInt + i.a.a.b.b.a.c(22, this.Lig);
      }
      paramInt = i.a.a.a.c(23, 8, this.Lih);
      AppMethodBeat.o(262703);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lih.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(262703);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(262703);
        return -1;
      case 1: 
        locald.LhU = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(262703);
        return 0;
      case 2: 
        locald.LhV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(262703);
        return 0;
      case 3: 
        locald.source = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(262703);
        return 0;
      case 4: 
        locald.LhW = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(262703);
        return 0;
      case 5: 
        locald.waL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 6: 
        locald.LhX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 7: 
        locald.fileid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 8: 
        locald.LhY = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 9: 
        locald.md5 = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 10: 
        locald.createtime = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(262703);
        return 0;
      case 11: 
        locald.LhZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(262703);
        return 0;
      case 12: 
        locald.Lia = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(262703);
        return 0;
      case 13: 
        locald.mdZ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 14: 
        locald.Lib = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(262703);
        return 0;
      case 15: 
        locald.mMK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(262703);
        return 0;
      case 16: 
        locald.Lic = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(262703);
        return 0;
      case 17: 
        locald.Lid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 18: 
        locald.Lie = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 19: 
        locald.wYJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 20: 
        locald.Lif = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(262703);
        return 0;
      case 21: 
        locald.uuid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(262703);
        return 0;
      case 22: 
        locald.Lig = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(262703);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        a locala = new a();
        if ((localObject != null) && (localObject.length > 0)) {
          locala.parseFrom((byte[])localObject);
        }
        locald.Lih.add(locala);
        paramInt += 1;
      }
      AppMethodBeat.o(262703);
      return 0;
    }
    AppMethodBeat.o(262703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multimediareport.d
 * JD-Core Version:    0.7.0.1
 */