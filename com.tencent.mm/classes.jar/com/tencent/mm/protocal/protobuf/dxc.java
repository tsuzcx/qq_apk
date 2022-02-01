package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxc
  extends com.tencent.mm.bx.a
{
  public int KRj;
  public int ZJt;
  public int aavC;
  public dxe aavD;
  public int abcX;
  public dxd abcY;
  public int abcZ;
  public int abda;
  public int abdb;
  public String app_id;
  public String pss;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152631);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.pss != null) {
        paramVarArgs.g(1, this.pss);
      }
      paramVarArgs.bS(2, this.abcX);
      if (this.abcY != null)
      {
        paramVarArgs.qD(3, this.abcY.computeSize());
        this.abcY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.aavC);
      if (this.aavD != null)
      {
        paramVarArgs.qD(5, this.aavD.computeSize());
        this.aavD.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.abcZ);
      paramVarArgs.bS(7, this.abda);
      paramVarArgs.bS(8, this.KRj);
      paramVarArgs.bS(9, this.abdb);
      if (this.app_id != null) {
        paramVarArgs.g(10, this.app_id);
      }
      paramVarArgs.bS(11, this.ZJt);
      AppMethodBeat.o(152631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pss == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = i.a.a.b.b.a.h(1, this.pss) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abcX);
      paramInt = i;
      if (this.abcY != null) {
        paramInt = i + i.a.a.a.qC(3, this.abcY.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aavC);
      paramInt = i;
      if (this.aavD != null) {
        paramInt = i + i.a.a.a.qC(5, this.aavD.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abcZ) + i.a.a.b.b.a.cJ(7, this.abda) + i.a.a.b.b.a.cJ(8, this.KRj) + i.a.a.b.b.a.cJ(9, this.abdb);
      paramInt = i;
      if (this.app_id != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.app_id);
      }
      i = i.a.a.b.b.a.cJ(11, this.ZJt);
      AppMethodBeat.o(152631);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dxc localdxc = (dxc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152631);
          return -1;
        case 1: 
          localdxc.pss = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152631);
          return 0;
        case 2: 
          localdxc.abcX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152631);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dxd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dxd)localObject2).parseFrom((byte[])localObject1);
            }
            localdxc.abcY = ((dxd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 4: 
          localdxc.aavC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152631);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dxe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dxe)localObject2).parseFrom((byte[])localObject1);
            }
            localdxc.aavD = ((dxe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152631);
          return 0;
        case 6: 
          localdxc.abcZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152631);
          return 0;
        case 7: 
          localdxc.abda = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152631);
          return 0;
        case 8: 
          localdxc.KRj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152631);
          return 0;
        case 9: 
          localdxc.abdb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152631);
          return 0;
        case 10: 
          localdxc.app_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152631);
          return 0;
        }
        localdxc.ZJt = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152631);
        return 0;
      }
      AppMethodBeat.o(152631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxc
 * JD-Core Version:    0.7.0.1
 */