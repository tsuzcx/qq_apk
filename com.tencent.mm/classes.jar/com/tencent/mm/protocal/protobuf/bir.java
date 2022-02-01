package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bir
  extends dyy
{
  public LinkedList<bip> ESJ;
  public LinkedList<bkt> SSU;
  public int SSV;
  public int SSW;
  public LinkedList<bfh> SSX;
  public int SSY;
  public bis SSZ;
  public int continueFlag;
  public String fIY;
  public int offset;
  public LinkedList<FinderObject> wHI;
  public b xHE;
  
  public bir()
  {
    AppMethodBeat.i(169049);
    this.ESJ = new LinkedList();
    this.wHI = new LinkedList();
    this.SSU = new LinkedList();
    this.SSX = new LinkedList();
    AppMethodBeat.o(169049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169050);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ESJ);
      paramVarArgs.aY(3, this.offset);
      paramVarArgs.aY(4, this.continueFlag);
      paramVarArgs.e(5, 8, this.wHI);
      if (this.xHE != null) {
        paramVarArgs.c(6, this.xHE);
      }
      if (this.fIY != null) {
        paramVarArgs.f(7, this.fIY);
      }
      paramVarArgs.e(8, 8, this.SSU);
      paramVarArgs.aY(9, this.SSV);
      paramVarArgs.aY(10, this.SSW);
      paramVarArgs.e(11, 8, this.SSX);
      paramVarArgs.aY(12, this.SSY);
      if (this.SSZ != null)
      {
        paramVarArgs.oE(13, this.SSZ.computeSize());
        this.SSZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1234;
      }
    }
    label1234:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.ESJ) + g.a.a.b.b.a.bM(3, this.offset) + g.a.a.b.b.a.bM(4, this.continueFlag) + g.a.a.a.c(5, 8, this.wHI);
      paramInt = i;
      if (this.xHE != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.xHE);
      }
      i = paramInt;
      if (this.fIY != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.fIY);
      }
      i = i + g.a.a.a.c(8, 8, this.SSU) + g.a.a.b.b.a.bM(9, this.SSV) + g.a.a.b.b.a.bM(10, this.SSW) + g.a.a.a.c(11, 8, this.SSX) + g.a.a.b.b.a.bM(12, this.SSY);
      paramInt = i;
      if (this.SSZ != null) {
        paramInt = i + g.a.a.a.oD(13, this.SSZ.computeSize());
      }
      AppMethodBeat.o(169050);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ESJ.clear();
        this.wHI.clear();
        this.SSU.clear();
        this.SSX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bir localbir = (bir)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169050);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbir.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bip();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bip)localObject2).parseFrom((byte[])localObject1);
            }
            localbir.ESJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 3: 
          localbir.offset = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169050);
          return 0;
        case 4: 
          localbir.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169050);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbir.wHI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 6: 
          localbir.xHE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(169050);
          return 0;
        case 7: 
          localbir.fIY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169050);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkt)localObject2).parseFrom((byte[])localObject1);
            }
            localbir.SSU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 9: 
          localbir.SSV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169050);
          return 0;
        case 10: 
          localbir.SSW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169050);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfh)localObject2).parseFrom((byte[])localObject1);
            }
            localbir.SSX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 12: 
          localbir.SSY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(169050);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bis();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bis)localObject2).parseFrom((byte[])localObject1);
          }
          localbir.SSZ = ((bis)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      AppMethodBeat.o(169050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bir
 * JD-Core Version:    0.7.0.1
 */