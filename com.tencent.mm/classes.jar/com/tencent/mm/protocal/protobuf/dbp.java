package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dbp
  extends com.tencent.mm.bx.a
{
  public int KFe;
  public int KPQ;
  public String Znz;
  public b aaGT;
  public b aaGU;
  public int aaGX;
  public b aaGY;
  public int aaGZ;
  public dbp aaHa;
  public dbp aaHb;
  public int dataType;
  public boolean isPatch;
  public String mOI;
  public String md5;
  public String name;
  public int oGu;
  public String path;
  public int typeId;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259450);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaGX);
      paramVarArgs.bS(2, this.dataType);
      paramVarArgs.bS(3, this.KPQ);
      if (this.name != null) {
        paramVarArgs.g(4, this.name);
      }
      paramVarArgs.bS(5, this.version);
      paramVarArgs.bS(6, this.typeId);
      if (this.aaGT != null) {
        paramVarArgs.d(7, this.aaGT);
      }
      if (this.mOI != null) {
        paramVarArgs.g(8, this.mOI);
      }
      if (this.aaGU != null) {
        paramVarArgs.d(9, this.aaGU);
      }
      if (this.md5 != null) {
        paramVarArgs.g(10, this.md5);
      }
      if (this.aaGY != null) {
        paramVarArgs.d(11, this.aaGY);
      }
      if (this.path != null) {
        paramVarArgs.g(12, this.path);
      }
      paramVarArgs.bS(13, this.KFe);
      paramVarArgs.bS(14, this.oGu);
      if (this.Znz != null) {
        paramVarArgs.g(15, this.Znz);
      }
      paramVarArgs.bS(16, this.aaGZ);
      if (this.aaHa != null)
      {
        paramVarArgs.qD(17, this.aaHa.computeSize());
        this.aaHa.writeFields(paramVarArgs);
      }
      paramVarArgs.di(18, this.isPatch);
      if (this.aaHb != null)
      {
        paramVarArgs.qD(19, this.aaHb.computeSize());
        this.aaHb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aaGX) + 0 + i.a.a.b.b.a.cJ(2, this.dataType) + i.a.a.b.b.a.cJ(3, this.KPQ);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.name);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.version) + i.a.a.b.b.a.cJ(6, this.typeId);
      paramInt = i;
      if (this.aaGT != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.aaGT);
      }
      i = paramInt;
      if (this.mOI != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.mOI);
      }
      paramInt = i;
      if (this.aaGU != null) {
        paramInt = i + i.a.a.b.b.a.c(9, this.aaGU);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.md5);
      }
      paramInt = i;
      if (this.aaGY != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.aaGY);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.path);
      }
      i = i + i.a.a.b.b.a.cJ(13, this.KFe) + i.a.a.b.b.a.cJ(14, this.oGu);
      paramInt = i;
      if (this.Znz != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.Znz);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.aaGZ);
      paramInt = i;
      if (this.aaHa != null) {
        paramInt = i + i.a.a.a.qC(17, this.aaHa.computeSize());
      }
      i = paramInt + (i.a.a.b.b.a.ko(18) + 1);
      paramInt = i;
      if (this.aaHb != null) {
        paramInt = i + i.a.a.a.qC(19, this.aaHb.computeSize());
      }
      AppMethodBeat.o(259450);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dbp localdbp1 = (dbp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      dbp localdbp2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259450);
        return -1;
      case 1: 
        localdbp1.aaGX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259450);
        return 0;
      case 2: 
        localdbp1.dataType = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259450);
        return 0;
      case 3: 
        localdbp1.KPQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259450);
        return 0;
      case 4: 
        localdbp1.name = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259450);
        return 0;
      case 5: 
        localdbp1.version = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259450);
        return 0;
      case 6: 
        localdbp1.typeId = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259450);
        return 0;
      case 7: 
        localdbp1.aaGT = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(259450);
        return 0;
      case 8: 
        localdbp1.mOI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259450);
        return 0;
      case 9: 
        localdbp1.aaGU = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(259450);
        return 0;
      case 10: 
        localdbp1.md5 = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259450);
        return 0;
      case 11: 
        localdbp1.aaGY = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(259450);
        return 0;
      case 12: 
        localdbp1.path = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259450);
        return 0;
      case 13: 
        localdbp1.KFe = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259450);
        return 0;
      case 14: 
        localdbp1.oGu = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259450);
        return 0;
      case 15: 
        localdbp1.Znz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259450);
        return 0;
      case 16: 
        localdbp1.aaGZ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259450);
        return 0;
      case 17: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdbp2 = new dbp();
          if ((localObject != null) && (localObject.length > 0)) {
            localdbp2.parseFrom((byte[])localObject);
          }
          localdbp1.aaHa = localdbp2;
          paramInt += 1;
        }
        AppMethodBeat.o(259450);
        return 0;
      case 18: 
        localdbp1.isPatch = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(259450);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localdbp2 = new dbp();
        if ((localObject != null) && (localObject.length > 0)) {
          localdbp2.parseFrom((byte[])localObject);
        }
        localdbp1.aaHb = localdbp2;
        paramInt += 1;
      }
      AppMethodBeat.o(259450);
      return 0;
    }
    AppMethodBeat.o(259450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbp
 * JD-Core Version:    0.7.0.1
 */