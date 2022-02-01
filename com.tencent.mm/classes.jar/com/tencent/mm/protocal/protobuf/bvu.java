package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bvu
  extends esc
{
  public LinkedList<FinderObject> aadD;
  public bvs aadE;
  public LinkedList<bvr> aadF;
  public boolean aadG;
  public int continueFlag;
  public b lastBuffer;
  
  public bvu()
  {
    AppMethodBeat.i(258766);
    this.aadD = new LinkedList();
    this.aadF = new LinkedList();
    AppMethodBeat.o(258766);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258768);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aadD);
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      paramVarArgs.bS(4, this.continueFlag);
      if (this.aadE != null)
      {
        paramVarArgs.qD(5, this.aadE.computeSize());
        this.aadE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.aadF);
      paramVarArgs.di(7, this.aadG);
      AppMethodBeat.o(258768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aadD);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.continueFlag);
      paramInt = i;
      if (this.aadE != null) {
        paramInt = i + i.a.a.a.qC(5, this.aadE.computeSize());
      }
      i = i.a.a.a.c(6, 8, this.aadF);
      int j = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(258768);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aadD.clear();
        this.aadF.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258768);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bvu localbvu = (bvu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258768);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbvu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258768);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbvu.aadD.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258768);
          return 0;
        case 3: 
          localbvu.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258768);
          return 0;
        case 4: 
          localbvu.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258768);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvs)localObject2).parseFrom((byte[])localObject1);
            }
            localbvu.aadE = ((bvs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258768);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bvr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bvr)localObject2).parseFrom((byte[])localObject1);
            }
            localbvu.aadF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258768);
          return 0;
        }
        localbvu.aadG = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(258768);
        return 0;
      }
      AppMethodBeat.o(258768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvu
 * JD-Core Version:    0.7.0.1
 */