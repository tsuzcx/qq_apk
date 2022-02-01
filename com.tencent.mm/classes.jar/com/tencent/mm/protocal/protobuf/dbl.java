package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dbl
  extends com.tencent.mm.bx.a
{
  public dbm aaGS;
  public b aaGT;
  public b aaGU;
  public afe aaGV;
  public int aaGW;
  public String mOI;
  public String md5;
  public String name;
  public int typeId;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259580);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      paramVarArgs.bS(2, this.version);
      if (this.aaGS != null)
      {
        paramVarArgs.qD(3, this.aaGS.computeSize());
        this.aaGS.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.typeId);
      if (this.aaGT != null) {
        paramVarArgs.d(5, this.aaGT);
      }
      if (this.mOI != null) {
        paramVarArgs.g(6, this.mOI);
      }
      if (this.aaGU != null) {
        paramVarArgs.d(7, this.aaGU);
      }
      if (this.md5 != null) {
        paramVarArgs.g(8, this.md5);
      }
      if (this.aaGV != null)
      {
        paramVarArgs.qD(9, this.aaGV.computeSize());
        this.aaGV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.aaGW);
      AppMethodBeat.o(259580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = i.a.a.b.b.a.h(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.version);
      paramInt = i;
      if (this.aaGS != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaGS.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.typeId);
      paramInt = i;
      if (this.aaGT != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.aaGT);
      }
      i = paramInt;
      if (this.mOI != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.mOI);
      }
      paramInt = i;
      if (this.aaGU != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.aaGU);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.md5);
      }
      paramInt = i;
      if (this.aaGV != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaGV.computeSize());
      }
      i = i.a.a.b.b.a.cJ(10, this.aaGW);
      AppMethodBeat.o(259580);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dbl localdbl = (dbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259580);
          return -1;
        case 1: 
          localdbl.name = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259580);
          return 0;
        case 2: 
          localdbl.version = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259580);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbm)localObject2).parseFrom((byte[])localObject1);
            }
            localdbl.aaGS = ((dbm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259580);
          return 0;
        case 4: 
          localdbl.typeId = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259580);
          return 0;
        case 5: 
          localdbl.aaGT = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259580);
          return 0;
        case 6: 
          localdbl.mOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259580);
          return 0;
        case 7: 
          localdbl.aaGU = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259580);
          return 0;
        case 8: 
          localdbl.md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259580);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new afe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((afe)localObject2).parseFrom((byte[])localObject1);
            }
            localdbl.aaGV = ((afe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259580);
          return 0;
        }
        localdbl.aaGW = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259580);
        return 0;
      }
      AppMethodBeat.o(259580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbl
 * JD-Core Version:    0.7.0.1
 */